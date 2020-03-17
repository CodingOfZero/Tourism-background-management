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
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    /*
    根据用户名称查询
    */
    @Autowired
    private UserDao userDao;

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
        User user=new User(userinfo.getUserName(),"{noop}"+userinfo.getPassword(), userinfo.getStatus() != 0,true,true,true,getAuthority(userinfo.getRoles()));//"{noop}"

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
}
