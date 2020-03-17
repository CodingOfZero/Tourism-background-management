package com.mydomain;

import java.util.List;

/**
 * 与数据库中User对应
 */
public class UserInfo {
    private Integer id;//主键
    private String email;//邮件
    private String userName;//用户名称
    private String password;//用户密码
    private String phoneNum;//电话号码
    private Short status;//用户状态是否可用
    private String statusStr;//用户状态是否可用,0不可用

    private List<Role> roles;//对应角色

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public String getStatusStr() {
        statusStr=status==0?"账户不可用":"账户可用";
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", status=" + status +
                ", statusStr='" + statusStr + '\'' +
                ", roles=" + roles +
                '}';
    }
}
