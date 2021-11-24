package com.ordersystem.entity;

import java.io.Serializable;
import java.util.List;

/**
 * (Order)实体类
 *
 * @author makejava
 * @since 2021-07-25 01:09:36
 */
public class Order implements Serializable {
    private static final long serialVersionUID = 741156620896375521L;

    private String orderid;

    private String userid;

    private String tableNumber;

    private Float sum;

    private Integer status;

    public Order(String orderid, String userid, String tableNumber, Float sum){
        this.orderid=orderid;
        this.tableNumber=tableNumber;
        this.userid=userid;
        this.status=0;
        this.sum=sum;
    }

    public Order(){

    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(String tableNumber) {
        this.tableNumber = tableNumber;
    }

    public Object getSum() {
        return sum;
    }

    public void setSum(Float sum) {
        this.sum = sum;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }


}
