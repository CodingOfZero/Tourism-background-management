package com.myservice;

import com.mydomain.Syslog;
import org.springframework.stereotype.Service;


public interface SysLogService {
    public void save(Syslog syslog) throws Exception;
}
