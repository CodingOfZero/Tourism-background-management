package com.myservice.impl;

import com.github.pagehelper.PageHelper;
import com.mydomain.Permission;
import com.mydomain.PermissionDao;
import com.myservice.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service("permissionService")
@Transactional
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionDao permissionDao;


    public List<Permission> findAll(int page,int size) throws Exception {
        PageHelper.startPage(page,size);
        return permissionDao.findAll(page,size);
    }

    public void savePermission(Permission permission) throws Exception {
        permissionDao.savePermission(permission);
    }
}
