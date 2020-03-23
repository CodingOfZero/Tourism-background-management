package com.myservice;

import com.mydomain.Syslog;

import java.util.List;


public interface SysLogService {
    public void save(Syslog syslog) throws Exception;

    public List<Syslog> findAll(int page,int size)throws Exception;
}
