package mycontroller;

import com.github.pagehelper.PageInfo;
import com.mydomain.Syslog;
import com.myservice.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/sysLog")
public class SysLogController {

    @Autowired
    private SysLogService sysLogService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name="page" ,required = true,defaultValue = "1")Integer page, @RequestParam(name="size",required = true,defaultValue = "5")Integer size) throws Exception {
        ModelAndView mv=new ModelAndView();
        List<Syslog> syslogs =  sysLogService.findAll(page, size);
        PageInfo pageInfo=new PageInfo(syslogs);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("syslog-list");
        return mv;
    }

}
