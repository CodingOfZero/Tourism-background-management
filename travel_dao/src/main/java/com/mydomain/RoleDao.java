package com.mydomain;

import org.apache.ibatis.annotations.*;


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

    @Select("select * from role")
    public List<Role> findAll(int page,int size) throws Exception;

    @Insert("insert into role (roleName,roleDesc) values(#{roleName},#{roleDesc})")
    public void saveRole(Role role)throws Exception;

    @Select("select * from role where id=#{roleId}")
    Role findById(int roleId) throws Exception;

    @Select("select * from permission where id not in (select permissionId from role_permission where roleId=#{roleId})")
    List<Permission> findOtherPermission(int roleId) throws Exception;

    @Insert("insert into role_permission(permissionId,roleId) values(#{permissionId},#{roleId})")
    void addPermissionToRole(@Param("roleId") int roleId, @Param("permissionId") int perId) throws Exception;
}
