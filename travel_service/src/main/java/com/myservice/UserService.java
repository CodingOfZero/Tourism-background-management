package com.myservice;

import com.mydomain.Role;
import com.mydomain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    //用户信息
    public List<UserInfo> findAll(int page,int size) throws Exception;
    //保存用户信息
    public void saveUserInfo(UserInfo userInfo) throws Exception;
    //根据用户id查询用户详细信息，包含角色，权限信息
    public UserInfo findUserInfoById(int id) throws Exception;
    //根据用户id查询可以添加的角色
    public List<Role> findOtherRoles(int userId) throws Exception;
    public void addRoleToUser(int userId, int[] ids) throws Exception;

}
