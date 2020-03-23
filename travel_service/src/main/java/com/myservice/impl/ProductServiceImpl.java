package com.myservice.impl;


import com.github.pagehelper.PageHelper;
import com.mydomain.Product;
import com.mydomain.ProductDao;
import com.myservice.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

    public List<Product> findAll(int page,int size) throws Exception {
        PageHelper.startPage(page,size);
        return  productDao.findAll(page,size);
    }

    public void saveProduct(Product product) throws Exception {
        productDao.saveProduct(product);
    }

    public void deleteById(int id) throws Exception {
        productDao.deleteById(id);
    }

    public Product findById(int id) throws Exception {
        return productDao.findById(id);
    }

    public void update(Product product) throws Exception {
        productDao.update(product);
    }
}
