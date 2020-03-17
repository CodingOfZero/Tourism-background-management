package com.mydomain;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface UserDao {
    /*
    根据用户名称查询
     */
    @Select("select * from user where userName=#{username}")
    @Results({
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "email",column = "email"),
            @Result(property = "userName",column = "userName"),
            @Result(property = "password",column = "password"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "roles",column = "id",many = @Many(select = "com.mydomain.RoleDao.findRoleByUserId" ,fetchType = FetchType.EAGER))
    })
    public UserInfo findByUserName(String username) throws Exception;

    /*
    查询所有用户信息
     */
    @Select("select * from user")
    public List<UserInfo> findAll(int page,int size) throws Exception;
}
