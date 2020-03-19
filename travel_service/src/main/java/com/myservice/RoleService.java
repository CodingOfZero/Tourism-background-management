package com.myservice;

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
}
