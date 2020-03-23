package mycontroller;

import com.mydomain.Syslog;
import com.myservice.SysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Date;

@Component
@Aspect
public class LogAop {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private SysLogService sysLogService;

    private Date visitTime;//访问时间
    private Class aClass;//访问的类
    private Method method;//访问的方法

    /**
     * 前置通知 获取开始时间 执行是那个方法
     */
    @Before("execution(* mycontroller.*.*(..))")
    public void doBefore(JoinPoint jp)  {
        visitTime=new Date(); //当前时间就是访问时间
        aClass=jp.getTarget().getClass();//具体要访问的类
        String methodName=jp.getSignature().getName();//获取访问的方法的名称
        Object[] args=jp.getArgs();//获取访问方法的参数
        if(args==null||args.length==0){
            try{
                method=aClass.getMethod(methodName);
            }catch (NoSuchMethodException e){
                e.printStackTrace();
            }

        }else{
            try{
                Class[] classArgs=new Class[args.length];
                for(int i=0;i<args.length;i++){
                    classArgs[i]=args[i].getClass();
                }
                method=aClass.getMethod(methodName,classArgs);
            }catch (NoSuchMethodException e){
                e.printStackTrace();
            }

        }

    }

    //后置通知
    @After("execution(* mycontroller.*.*(..))")
    public void doAfter(JoinPoint jp)  {
        long time= new Date().getTime()-visitTime.getTime();//访问时长
        //获取url
        String url="";
        if(aClass!=null&&method!=null&&aClass!=Syslog.class){
            //1.获取类上的@RequestMapping
            RequestMapping classAnnotation = (RequestMapping)aClass.getAnnotation(RequestMapping.class);
            if(classAnnotation!=null){
                String[] classValue=classAnnotation.value();

                //2.获取方法上的@RequestMapping
                RequestMapping methodAnnotation = (RequestMapping)method.getAnnotation(RequestMapping.class);
                if(methodAnnotation!=null){
                    String[] methodValue=classAnnotation.value();
                    url=classValue[0]+methodValue[0];
                    if("/sysLog/findAll".equals(url))
                        return;
                    //获取IP
                    String ip=request.getRemoteAddr();
                    //获取当前操作的用户
                    SecurityContext context= SecurityContextHolder.getContext();
                    User user = (User) context.getAuthentication().getPrincipal();//springsecurity中的User
                    String userName=user.getUsername();

                    //将日志相关封装到Syslog
                    Syslog syslog=new Syslog();
                    syslog.setExecutionTime(time);
                    syslog.setIp(ip);
                    syslog.setUrl(url);
                    syslog.setUsername(userName);
                    syslog.setVisitTime(visitTime);
                    syslog.setMethod("[类名] "+aClass.getName()+"[方法名] "+method.getName());


                    //调用service完成记录操作
                    try{
                        sysLogService.save(syslog);
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                }
            }
        }

    }
}
