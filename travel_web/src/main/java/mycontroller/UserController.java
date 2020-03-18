package mycontroller;

import com.github.pagehelper.PageInfo;
import com.mydomain.Role;
import com.mydomain.UserInfo;
import com.myservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 查找所有用户
     * @return
     */
    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name="page" ,required = true,defaultValue = "1")int page,@RequestParam(name="size",required = true,defaultValue = "5")int size) throws Exception{
        ModelAndView mv=new ModelAndView();
        List<UserInfo> user = userService.findAll(page,size);
        PageInfo pageInfo=new PageInfo(user);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("user-list");
        return mv;
    }
    /*
    新建用户
     */
    @RequestMapping("/save")
    public String saveUser(UserInfo userInfo) throws Exception{
        userService.saveUserInfo(userInfo);
        return "redirect: findAll";
    }
    /*
    用户详细信息
     */
    @RequestMapping("/findById")
    public ModelAndView findUserInfoById(Integer id) throws Exception{
        ModelAndView mv=new ModelAndView();
        UserInfo userinfo = userService.findUserInfoById(id);

        mv.addObject("user",userinfo);
        mv.setViewName("user-show");
        return mv;
    }
}
