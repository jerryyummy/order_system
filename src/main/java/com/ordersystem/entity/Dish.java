package com.ordersystem.entity;

import java.io.Serializable;

/**
 * (Dish)实体类
 *
 * @author makejava
 * @since 2021-07-25 01:08:44
 */
public class Dish implements Serializable {
    private static final long serialVersionUID = -88279301095149367L;

    private String dishId;

    private String name;

    private String introduce;

    private int isRecommend;

    private float price;

    private String urlDish;


    public String getDishid() {
        return dishId;
    }

    public void setDishid(String dishid) {
        this.dishId = dishid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce =introduce;
    }

    public int getIsRecommend() {
        return isRecommend;
    }

    public void setIsRecommend(int isrecommend) {
        this.isRecommend = isrecommend;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getUrlDish() {
        return urlDish;
    }

    public void setUrlDish(String urlDish) {
        this.urlDish = urlDish;
    }

}
