package com.mydomain;

import org.apache.ibatis.annotations.Insert;

public interface SysLogDao {
    @Insert("insert into syslog (visitTime,userName,ip,url,executionTime,method) values (#{visitTime},#{userName},#{ip},#{url},#{executionTime},#{method})")
    public void save(Syslog syslog) throws Exception;
}
