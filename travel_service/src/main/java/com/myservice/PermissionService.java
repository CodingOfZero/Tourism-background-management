package com.myservice;

import com.mydomain.Permission;

import java.util.List;

public interface PermissionService {
    //权限查询
    public List<Permission> findAll(int page,int size) throws Exception;

    //add Permission
    public void savePermission(Permission permission) throws Exception;
}
