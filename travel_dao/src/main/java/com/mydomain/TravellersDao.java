package com.mydomain;

import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TravellersDao {

    @Select("select * from traveller where id in (select travellerId from order_traveller where orderId=#{id})")
    public List<Traveller> findByOrderId(int id) throws Exception;
}
