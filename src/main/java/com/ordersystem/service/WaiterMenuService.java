package com.ordersystem.service;

import com.ordersystem.entity.Dish;

import java.util.List;

public interface WaiterMenuService {
    List<Dish> getNormalDish();

    List<Dish> getRecommendDish();
}
