package com.mydomain;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao {
    /**
     * 根据id查询产品信息
     * @param id
     * @return
     * @throws Exception
     */
    @Select("select * from product where id = #{id}")
    public Product findById(Integer id) throws Exception;
    //查询所有产品信息
    @Select("select * from product")
    public List<Product> findAll(int page,int size) throws Exception;
    /**
     * 保存一个 商品的信息
     * @param product 需要保存的商品的对象
     */
    @Insert("insert into product (productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values (#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    public void saveProduct(Product product) throws Exception;

    //根据id删除产品
    @Delete("delete  from product where id=#{id}")
    public void deleteById(int id)throws Exception;

    @Update("update product set productNum=#{productNum},productName=#{productName},cityName=#{cityName},departureTime=#{departureTime},productPrice=#{productPrice},productDesc=#{productDesc},productStatus=#{productStatus} where id=#{id}")
    public void update(Product product) throws Exception;
}
