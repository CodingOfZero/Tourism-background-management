package com.myservice.impl;

import com.github.pagehelper.PageHelper;
import com.mydomain.Role;
import com.mydomain.UserDao;
import com.mydomain.UserInfo;
import com.myservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private BCryptPasswordEncoder bcPasswordEncoder;//加密对象
    /*
    根据用户名称查询
    */
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserInfo userinfo=null;
        try {
            userinfo = userDao.findByUserName(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //处理自己用户对象封装为UserDetails，User对象为springSecurity提供
        //User user=new User(userinfo.getUserName(),userinfo.getPassword(),getAuthority(userinfo.getRoles()));//"{noop}"
        if(userinfo==null) return null;
        User user=new User(userinfo.getUserName(),userinfo.getPassword(), userinfo.getStatus() != 0,true,true,true,getAuthority(userinfo.getRoles()));//"{noop}"

        return user;
    }
    //作用返回一个集合，集合中装入的是角色描述
    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles){
        List<SimpleGrantedAuthority> list=new ArrayList<SimpleGrantedAuthority>();
        for(Role role:roles){
            list.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
        }
        return list;
    }

    //查询所用用户
    public List<UserInfo> findAll(int page,int size) throws Exception{
        PageHelper.startPage(page,size);
        return userDao.findAll(page,size);
    }
    //新建用户，并且对密码进行加密
    public void saveUserInfo(UserInfo userInfo) throws Exception {
        userInfo.setPassword(bcPasswordEncoder.encode(userInfo.getPassword()));//进行加密
        userDao.saveUserInfo(userInfo);
    }
    //根据id查询
    public UserInfo findUserInfoById(int id) throws Exception {
        return userDao.findUserInfoById(id);
    }

    public List<Role> findOtherRoles(int userId) throws Exception {
        return userDao.findOtherRoles(userId);
    }

    public void addRoleToUser(int userId, int[] ids) throws Exception {
        for(int roleId:ids){
            userDao.addRoleToUser(userId,roleId);
        }

    }
}
