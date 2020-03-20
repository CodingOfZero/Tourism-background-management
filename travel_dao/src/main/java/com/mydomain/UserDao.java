package com.mydomain;

import org.apache.ibatis.annotations.*;
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
            @Result(property = "status",column = "status"),
            @Result(property = "roles",column = "id",many = @Many(select = "com.mydomain.RoleDao.findRoleByUserId" ,fetchType = FetchType.EAGER))
    })
    public UserInfo findByUserName(String username) throws Exception;

    /*
    查询所有用户信息
     */
    @Select("select * from user")
    public List<UserInfo> findAll(int page,int size) throws Exception;
    /*
    新建用户信息
     */
    @Insert("insert into user (email,userName,password,phoneNum,status) values(#{email},#{userName},#{password},#{phoneNum},#{status})")
    public void saveUserInfo(UserInfo userInfo) throws Exception;
    /*
    根据id查询用户详细信息，包含角色，权限信息
     */
    @Select("select * from user where id=#{id}")
    @Results({
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "email",column = "email"),
            @Result(property = "userName",column = "userName"),
            @Result(property = "password",column = "password"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "status",column = "status"),
            @Result(property = "roles",column = "id",many = @Many(select = "com.mydomain.RoleDao.findRoleByUserId" ))    })
    public UserInfo findUserInfoById(int id) throws Exception;

    //根据用户id查询可以添加的角色,查出未关联的角色
    @Select("select * from role where id not in (select roleId from users_role where userId = #{userId})")
    public List<Role> findOtherRoles(int userId) throws Exception;

    @Insert("insert into users_role(userId,roleId) values(#{userId},#{roleId})")
    void addRoleToUser(@Param("userId") int userId,@Param("roleId") int roleId);
}
