package com.myservice.impl;

import com.mydomain.SysLogDao;
import com.mydomain.Syslog;
import com.myservice.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("sysLogService")
public class SysLogServiceImpl implements SysLogService {
    @Autowired
    private SysLogDao sysLogDao;
    public void save(Syslog syslog) throws Exception {
        sysLogDao.save(syslog);
    }
}
