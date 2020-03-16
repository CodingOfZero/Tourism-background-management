package com.myservice;

import com.mydomain.Orders;

import java.util.List;


public interface OrdersService {
    public List<Orders> findAll() throws Exception;
}
