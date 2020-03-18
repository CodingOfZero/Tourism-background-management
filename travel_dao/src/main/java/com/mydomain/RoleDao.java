package com.mydomain;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;


import java.util.List;

public interface RoleDao {
    @Select("select * from role where id in (select roleId from users_role where userId=#{id} )")
    @Results({
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions",column = "id",many = @Many(select = "com.mydomain.PermissionDao.findPermissionByRoleId"))
    })
    public List<Role> findRoleByUserId(int id) throws Exception;
}
