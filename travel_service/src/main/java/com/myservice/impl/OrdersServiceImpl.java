package com.myservice.impl;

import com.mydomain.Orders;
import com.mydomain.OrdersDao;
import com.myservice.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("ordersService")
@Transactional
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersDao ordersDao;

    public List<Orders> findAll() throws Exception {
        return ordersDao.findAll();
    }
}
