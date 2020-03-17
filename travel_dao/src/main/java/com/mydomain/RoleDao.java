package com.mydomain;

import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleDao {
    @Select("select * from role where id in (select roleId from users_role where userId=#{id} )")
    public List<Role> findRoleByUserId(int id) throws Exception;
}
