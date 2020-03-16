package com.mydomain;

import java.io.Serializable;

/**
 * 旅客信息实体类
 */
public class Traveller implements Serializable {
    private Integer id;//主键，无实际含义
    private String name;//姓名
    private String sex;//性别
    private String phoneNum;//手机号码
    private Short credentialsType;//证件类型
    private String credentialsTypeStr;//( 0 身份证 1 护照 2 军官证 )
    private String credentialsNum;//证件号码
    private Short travellerType;//旅客类型
    private String travellerTypeStr;// ( 0 成人 1 儿童)

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Short getCredentialsType() {
        return credentialsType;
    }

    public void setCredentialsType(Short credentialsType) {
        this.credentialsType = credentialsType;
    }

    public String getCredentialsTypeStr() {
        if(credentialsType!=null){
            if (credentialsType == 0){
                credentialsTypeStr = "身份证";
            }
            if (credentialsType == 1){
                credentialsTypeStr = "护照";
            }
            if (credentialsType == 2){
                credentialsTypeStr = "军官证";
            }
        }
        return credentialsTypeStr;
    }

    public void setCredentialsTypeStr(String credentialsTypeStr) {
        this.credentialsTypeStr = credentialsTypeStr;
    }

    public String getCredentialsNum() {
        return credentialsNum;
    }

    public void setCredentialsNum(String credentialsNum) {
        this.credentialsNum = credentialsNum;
    }

    public Short getTravellerType() {
        return travellerType;
    }

    public void setTravellerType(Short travellerType) {
        this.travellerType = travellerType;
    }

    public String getTravellerTypeStr() {
        if(travellerType != null){
            if (travellerType == 0){
                travellerTypeStr = "成人";
            }
            if (travellerType == 1){
                travellerTypeStr = "儿童";
            }
        }
        return travellerTypeStr;
    }

    public void setTravellerTypeStr(String travellerTypeStr) {
        this.travellerTypeStr = travellerTypeStr;
    }

    @Override
    public String toString() {
        return "Traveller{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", credentialsType=" + credentialsType +
                ", credentialsTypeStr='" + credentialsTypeStr + '\'' +
                ", credentialsNum='" + credentialsNum + '\'' +
                ", travellerType=" + travellerType +
                ", travellerTypeStr='" + travellerTypeStr + '\'' +
                '}';
    }
}
