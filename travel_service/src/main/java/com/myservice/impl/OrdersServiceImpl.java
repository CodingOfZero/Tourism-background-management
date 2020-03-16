package com.myservice.impl;

import com.github.pagehelper.PageHelper;
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


     //查询所有订单信息,未分页
/*    public List<Orders> findAll() throws Exception {
        //参数pageNum为页码值，pageSize为每页显示条数，必须在执行查询语句之前，与findAll紧贴
        PageHelper.startPage(1,5);
        return ordersDao.findAll();
    }*/

    /**
     * 查询所有订单信息
     * @param page 页码
     * @param size 每页分页数
     */
    public List<Orders> findAll(int page,int size) throws Exception {
        //参数pageNum为页码值，pageSize为每页显示条数，必须在执行查询语句之前，与findAll紧贴
        PageHelper.startPage(page,size);
        return ordersDao.findAll(page,size);
    }

    /**
     * 根据id返回订单详细信息
     * @param id
     */
    public Orders findById(int id) throws Exception {
        return ordersDao.findById(id);
    }
}
