package com.ordersystem.entity;

public class OrderItem {

    private String name;

    private int amount;

    public String getDishId() {
        return dishId;
    }

    public void setDishId(String dishId) {
        this.dishId = dishId;
    }

    private String dishId;

    public OrderItem(String name, int amount, String dishId) {
        this.name=name;
        this.amount=amount;
        this.dishId=dishId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


}
