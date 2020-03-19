package com.mydomain;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionDao {
    //查询角色权限信息
    @Select("select * from permission where id in (select permissionId from role_permission where roleId=#{id})")
    public List<Permission> findPermissionByRoleId(int id) throws Exception;
    @Select("select * from permission")
    public List<Permission> findAll(int page,int size) throws Exception;

    //插入授权，这里是否应该用字符串描述每个权限，提高用户体验，而非只用url
    @Insert("insert into permission (permissionName,url) values(#{permissionName},#{url})")
    public void savePermission(Permission permission)throws Exception;
}
