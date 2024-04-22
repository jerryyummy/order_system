package com.ordersystem.entity;

import java.util.Objects;

public class OrderItem {

    private String name;

    private int amount;

    private String dishId;

    private float price;

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDishId() {
        return dishId;
    }

    public void setDishId(String dishId) {
        this.dishId = dishId;
    }


    public OrderItem(String name, int amount, String dishId, float price) {
        this.name = name;
        this.amount = amount;
        this.dishId = dishId;
        this.price = price;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return amount == orderItem.amount &&
                Objects.equals(name, orderItem.name) &&
                Objects.equals(dishId, orderItem.dishId) &&
                Objects.equals(price, orderItem.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, amount, dishId, price);
    }

}
