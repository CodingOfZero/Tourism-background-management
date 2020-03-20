package com.myservice;

import com.mydomain.Permission;
import com.mydomain.Role;

import java.util.List;

/*
角色
 */
public interface RoleService {
    //查询所有
    public List<Role> findAll(int page,int size) throws Exception;
    //add role
    public void saveRole(Role role) throws Exception;
    //1.根据id查询角色信息
    Role findById(int roleId) throws Exception;
    //2.查询角色未拥有的权限信息
    List<Permission> findOtherPermission(int roleId) throws Exception;
    //3.为角色添加权限信息
    void addPermissionToRole(int roleId, int[] ids) throws Exception;
}
