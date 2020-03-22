package mycontroller;


import com.github.pagehelper.PageInfo;
import com.mydomain.Permission;
import com.mydomain.Role;
import com.myservice.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name="page" ,required = true,defaultValue = "1")int page, @RequestParam(name="size",required = true,defaultValue = "5")int size)throws Exception{
        ModelAndView mv=new ModelAndView();
        List<Role> roles = roleService.findAll(page,size);
        PageInfo pageInfo=new PageInfo(roles);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("role-list");
        return mv;
    }
    //新建角色
    @RequestMapping("/save")
    public String saveUser(Role role) throws Exception{
        roleService.saveRole(role);
        return "redirect: findAll";
    }

    //为角色添加权限
    @RequestMapping("/findRoleByIdAndAllPermission")
    public ModelAndView findRoleByIdAndAllPermission(@RequestParam(name="id" ,required = true)int roleId) throws Exception{
        ModelAndView mv=new ModelAndView();
        Role role=roleService.findById(roleId);
        List<Permission> perlist=roleService.findOtherPermission(roleId);
        mv.addObject("role",role);
        mv.addObject("permissionList",perlist);
        mv.setViewName("role-permission-add");
        return mv;
    }

    @RequestMapping("/addPermissionToRole")
    @Secured("ROLE_ADMIN")
    public String addPermissionToRole(@RequestParam(name="roleId" ,required = true)int roleId,@RequestParam(name="ids" ,required = true)int[] ids) throws Exception{
        roleService.addPermissionToRole(roleId,ids);
        return "redirect: findAll";//角色信息
    }


}
