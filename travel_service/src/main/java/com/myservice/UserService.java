package com.myservice;

import com.mydomain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    //用户信息
    public List<UserInfo> findAll(int page,int size) throws Exception;
}
