package mycontroller;

import com.github.pagehelper.PageInfo;
import com.mydomain.Orders;
import com.myservice.OrdersService;

import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import sun.security.provider.MD2;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    //查询所有订单，未分页
/*    @RequestMapping("/findAll")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv=new ModelAndView();
        List<Orders> ordersList = ordersService.findAll();
        mv.addObject("ordersList",ordersList);
        mv.setViewName("orders-list");
        return mv;
    }*/

    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name="page",required = true,defaultValue = "1") int page,@RequestParam(name = "size",required = true,defaultValue = "5") int size) throws Exception {
        ModelAndView mv=new ModelAndView();
        List<Orders> ordersList = ordersService.findAll(page,size);
        //就是一个Bean
        PageInfo pageInfo=new PageInfo(ordersList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("orders-page-list");
        return mv;
    }

    @RequestMapping("/findById")
    public ModelAndView findById(@RequestParam(name="id",required = true) int id) throws Exception{
        ModelAndView mv=new ModelAndView();
        Orders order=ordersService.findById(id);
        mv.addObject("orders",order);
        mv.setViewName("orders-show");
        return mv;
    }
}
