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

import javax.annotation.security.RolesAllowed;
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
    /*
    给用户添加角色，首先必须先查出用户及可添加的角色信息，然后将这些信息返回到用户添加角色页面，
    供其选择添加的角色，接着执行添加操作
     */
    //查询用户以及用户可以添加的角色
    @RequestMapping("/findUserByIdAndAllRole")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name="id" ,required = true)int userId) throws Exception{
        ModelAndView mv=new ModelAndView();
        //1.根据用户的id查询用户
        UserInfo user = userService.findUserInfoById(userId);
        //2.根据用户id查询可以添加的角色
        List<Role> otherRoles=userService.findOtherRoles(userId);
        mv.addObject("user",user);
        mv.addObject("roleList",otherRoles);
        mv.setViewName("user-role-add");
        return mv;
    }
    @RequestMapping("/addRoleToUser")
    public String addRoleToUser(@RequestParam(name="userId" ,required = true)int userId,@RequestParam(name="ids" ,required = true)int[] ids) throws Exception{
        userService.addRoleToUser(userId,ids);
        return "redirect: findAll";//用户
    }

}
