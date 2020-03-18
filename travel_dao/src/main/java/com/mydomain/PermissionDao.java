package com.mydomain;

import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PermissionDao {
    //查询角色权限信息
    @Select("select * from permission where id in (select permissionId from role_permission where roleId=#{id})")
    public List<Permission> findPermissionByRoleId(int id) throws Exception;
}
