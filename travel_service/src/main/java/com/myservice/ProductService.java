package com.myservice;

import com.mydomain.Product;

import java.util.List;

public interface ProductService {
    //查询所有用户信息
    public List<Product> findAll() throws Exception;

    //新建产品信息
    public void saveProduct(Product product) throws Exception;
}
