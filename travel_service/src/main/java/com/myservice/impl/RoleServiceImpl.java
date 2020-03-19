package com.myservice.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
        return roleDao.findAll(page,size);
    }

    public void saveRole(Role role) throws Exception {
        roleDao.saveRole(role);
    }
}
