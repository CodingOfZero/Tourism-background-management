package com.myservice;

import com.mydomain.Product;

import java.util.List;

public interface ProductService {
    //查询所有用户信息
    public List<Product> findAll(int page,int size) throws Exception;

    //新建产品信息
    public void saveProduct(Product product) throws Exception;

    //根据id删除产品
    public void deleteById(int id)throws Exception;
}
