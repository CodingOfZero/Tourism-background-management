package mycontroller;


import com.github.pagehelper.PageInfo;
import com.mydomain.Product;
import com.myservice.ProductService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

   @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name="page",required = true,defaultValue = "1") Integer page, @RequestParam(name = "size",required = true,defaultValue = "5") Integer size) throws Exception {
        ModelAndView mv=new ModelAndView();
        List<Product> products = productService.findAll(page,size);
        PageInfo pageInfo=new PageInfo(products);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("product-list");
        return mv;
    }

    @RequestMapping("/saveProduct")
    public String saveProduct(Product product) throws Exception {
        productService.saveProduct(product);
        return "redirect:findAll";
    }
    //根据id删除产品
    @RequestMapping("/deleteById")
    public String deleteById(Integer id) throws Exception {
        productService.deleteById(id);
        return "redirect:findAll";
    }
    //根据id查询产品
    @RequestMapping("/findById")
    public ModelAndView findById(Integer id) throws Exception {
        ModelAndView mv=new ModelAndView();
        Product product=productService.findById(id);
        mv.addObject("product",product);
        mv.setViewName("product-edit");
        return mv;
    }

    //更新产品
    @RequestMapping("/update")
    public String update(Product product) throws Exception {
        productService.update(product);
        return "redirect:findAll";
    }
}
