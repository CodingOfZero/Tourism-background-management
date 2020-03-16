package com.myservice.impl;


import com.mydomain.Product;
import com.mydomain.ProductDao;
import com.myservice.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productService")
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

    public List<Product> findAll() throws Exception {
        return  productDao.findAll();
    }

    public void saveProduct(Product product) throws Exception {
        productDao.saveProduct(product);
    }
}
