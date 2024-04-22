package com.ordersystem.entity;

import java.io.Serializable;

/**
 * (OrderDetail)实体类
 *
 * @author makejava
 * @since 2021-07-25 01:09:38
 */
public class OrderDetail implements Serializable {
    private static final long serialVersionUID = -52678001763103431L;

    private String id;

    private String orderid;

    private Integer amount;

    private String dishid;

    private Integer status;

    private  Order order;

    private Dish dish;

    public OrderDetail() {
    }

    public OrderDetail(String id, String orderid, Integer amount, String dishid, Order order, Dish dish) {
        this.id = id;
        this.orderid = orderid;
        this.amount = amount;
        this.dishid = dishid;
        this.status = 0;
        this.order = order;
        this.dish = dish;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getDishid() {
        return dishid;
    }

    public void setDishid(String dishid) {
        this.dishid = dishid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}
