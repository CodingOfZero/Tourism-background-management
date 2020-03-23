package com.myservice.impl;

import com.github.pagehelper.PageHelper;
import com.mydomain.SysLogDao;
import com.mydomain.Syslog;
import com.myservice.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sysLogService")
public class SysLogServiceImpl implements SysLogService {
    @Autowired
    private SysLogDao sysLogDao;
    public void save(Syslog syslog) throws Exception {
        sysLogDao.save(syslog);
    }

    public List<Syslog> findAll(int page, int size) throws Exception {
        PageHelper.startPage(page, size);
        return sysLogDao.findAll(page, size);
    }
}
