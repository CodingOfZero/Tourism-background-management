package com.mydomain;

import com.myutils.DateUtils;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

public class Orders implements Serializable {
    private Integer id;//主键id
    private String orderNum;//订单编号 唯一
    private Date orderTime;//订单的时间
    private String orderTimeStr;//格式化的时间
    private Short peopleCount;//订单所含人数
    private String orderDesc;//订单信息描述
    private Short payType; //付款方式
    private String payTypeStr;//支付方式(0 支付宝 1 微信 2 其他)
    private Short orderStatus;//订单状态
    private String orderStatusStr;//订单状态(0 未支付 1 已经支付)
    private Integer productId; // 商品id
    private Integer memberId;// 用户id

    private Product product;//商品
    private List<Traveller> travellers;//旅客们
    private Members members;//会员

    public String getOrderTimeStr() {
        if(orderTime!=null){
            orderTimeStr=DateUtils.dateToString(orderTime,"yyyy-MM-dd HH:mm:ss");
        }
        return orderTimeStr;
    }

    public void setOrderTimeStr(String orderTimeStr) {
        this.orderTimeStr = orderTimeStr;
    }

    public String getPayTypeStr() {
        //支付方式(-1 未支付 0 支付宝 1 微信 2 其他)
        if(payType!=null){
            if (payType == 0) {
                payTypeStr = "支付宝";
            }
            if (payType == 1) {
                payTypeStr = "微信";
            }
            if (payType == 2) {
                payTypeStr = "其他";
            }
            if (payType == -1 ) {
                payTypeStr="未支付";
            }
        }
        return payTypeStr;
    }

    public void setPayTypeStr(String payTypeStr) {
        this.payTypeStr = payTypeStr;
    }

    public String getOrderStatusStr() {
        //订单状态(0 未支付 1 已经支付)
        if(orderStatus != null){
            if (orderStatus != 1) {
                orderStatusStr = "未支付";
            }
            if (orderStatus == 1) {
                orderStatusStr = "已经支付";
            }
        }
        return orderStatusStr;
    }

    public void setOrderStatusStr(String orderStatusStr) {
        this.orderStatusStr = orderStatusStr;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Short getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(Short peopleCount) {
        this.peopleCount = peopleCount;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }

    public Short getPayType() {
        return payType;
    }

    public void setPayType(Short payType) {
        this.payType = payType;
    }

    public Short getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Short orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Traveller> getTravellers() {
        return travellers;
    }

    public void setTravellers(List<Traveller> travellers) {
        this.travellers = travellers;
    }

    public Members getMembers() {
        return members;
    }

    public void setMembers(Members members) {
        this.members = members;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", orderNum='" + orderNum + '\'' +
                ", orderTime=" + orderTime +
                ", orderTimeStr='" + orderTimeStr + '\'' +
                ", peopleCount=" + peopleCount +
                ", orderDesc='" + orderDesc + '\'' +
                ", payType=" + payType +
                ", payTypeStr='" + payTypeStr + '\'' +
                ", orderStatus=" + orderStatus +
                ", orderStatusStr='" + orderStatusStr + '\'' +
                ", productId=" + productId +
                ", memberId=" + memberId +
                ", product=" + product +
                ", travellers=" + travellers +
                ", members=" + members +
                '}';
    }
}
