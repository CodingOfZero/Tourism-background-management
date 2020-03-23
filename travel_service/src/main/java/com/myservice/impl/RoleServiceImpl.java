package com.myservice.impl;

import com.github.pagehelper.PageHelper;
import com.mydomain.Permission;
import com.mydomain.Role;
import com.mydomain.RoleDao;
import com.myservice.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service("roleService")
@Transactional
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;

    public List<Role> findAll(int page,int size) throws Exception {
        PageHelper.startPage(page, size);
        return roleDao.findAll(page,size);
    }

    public void saveRole(Role role) throws Exception {
        roleDao.saveRole(role);
    }

    public Role findById(int roleId) throws Exception {
        return roleDao.findById(roleId);
    }

    public List<Permission> findOtherPermission(int roleId) throws Exception {
        return roleDao.findOtherPermission(roleId);
    }

    public void addPermissionToRole(int roleId, int[] ids) throws Exception{
        for(int perId:ids){
            roleDao.addPermissionToRole(roleId,perId);
        }
    }
}
