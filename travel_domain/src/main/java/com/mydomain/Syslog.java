package com.mydomain;

import com.myutils.DateUtils;

import java.util.Date;

public class Syslog {
    //id 主键
    private Long id;
    //访问的时间
    private Date visitTime;
    //访问的时间格式化
    private String visitTimeStr;
    //用户名
    private String userName;
    //用户登陆的ip地址
    private String ip;
    //用户访问的 资源路径
    private String url;
    //用户操作时间
    private Long executionTime;
    //用户执行了那些方法
    private String method;

    public String getVisitTimeStr() {
        if(visitTime != null){
            visitTimeStr = DateUtils.dateToString(visitTime,"yyyy-MM-dd HH:ss");
        }
        return visitTimeStr;
    }

    public void setVisitTimeStr(String visitTimeStr) {
        this.visitTimeStr = visitTimeStr;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Date visitTime) {
        this.visitTime = visitTime;
    }

    public String getUsername() {
        return userName;
    }

    public void setUsername(String username) {
        this.userName = username;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(Long executionTime) {
        this.executionTime = executionTime;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    @Override
    public String toString() {
        return "Syslog{" +
                "id=" + id +
                ", visitTime=" + visitTime +
                ", visitTimeStr='" + visitTimeStr + '\'' +
                ", username='" + userName + '\'' +
                ", ip='" + ip + '\'' +
                ", url='" + url + '\'' +
                ", executionTime=" + executionTime +
                ", method='" + method + '\'' +
                '}';
    }
}
