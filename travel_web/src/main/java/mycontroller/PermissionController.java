package mycontroller;

import com.github.pagehelper.PageInfo;
import com.mydomain.Permission;
import com.myservice.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@Controller
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;
    @RequestMapping("findAll")
    public ModelAndView findAll(@RequestParam(name="page" ,required = true,defaultValue = "1")Integer page, @RequestParam(name="size",required = true,defaultValue = "5")Integer size) throws Exception{
        ModelAndView mv=new ModelAndView();
        List<Permission> permission = permissionService.findAll(page,size);
        PageInfo pageInfo=new PageInfo(permission);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("permission-list");
        return mv;
    }

    //新建角色
    @RequestMapping("/save")
    public String saveUser(Permission permission) throws Exception{
        permissionService.savePermission(permission);
        return "redirect: findAll";
    }
}
