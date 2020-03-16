package com.mydomain;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersDao {
    @Select("select * from orders")
    @Results({
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "product",column = "productId",one = @One(select = "com.mydomain.ProductDao.findById",fetchType = FetchType.EAGER)),
            @Result(property = "memberId",column = "memberId")
    })
    public List<Orders> findAll(int page,int size) throws Exception;
    /*
    根据id查询订单详情,多表操作
     */
    @Select("select * from orders where id=#{id}")
    @Results({
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "product",column = "productId",one = @One(select = "com.mydomain.ProductDao.findById",fetchType = FetchType.EAGER)),
            @Result(property = "members",column = "memberId" ,one=@One(select = "com.mydomain.MemberDao.findById",fetchType = FetchType.EAGER)),
            @Result(property = "travellers",column = "id",many = @Many(select = "com.mydomain.TravellersDao.findByOrderId",fetchType = FetchType.EAGER))

    })
    public Orders findById(int id) throws Exception;
}
