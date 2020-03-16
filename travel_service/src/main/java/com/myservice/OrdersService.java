package com.myservice;

import com.mydomain.Orders;

import java.util.List;


public interface OrdersService {
    //查询所有订单，未分页
    //public List<Orders> findAll() throws Exception;
    //查询所有订单
    public List<Orders> findAll(int page,int size) throws Exception;

    //根据id查询
    public Orders findById(int id) throws Exception;
}
