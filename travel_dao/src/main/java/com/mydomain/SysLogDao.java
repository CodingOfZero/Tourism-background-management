package com.mydomain;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SysLogDao {
    @Insert("insert into syslog (visitTime,userName,ip,url,executionTime,method) values (#{visitTime},#{userName},#{ip},#{url},#{executionTime},#{method})")
    public void save(Syslog syslog) throws Exception;

    @Select("select * from syslog")
    public List<Syslog> findAll(int page,int size) throws Exception;
}
