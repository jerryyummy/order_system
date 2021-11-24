package com.ordersystem.service;

import com.ordersystem.entity.Dish;

import java.util.List;

/**
 * (Dish)表服务接口
 *
 * @author makejava
 * @since 2021-07-25 01:08:48
 */
public interface AdminDishService {
    Dish getDish(String dishId);

    boolean deleteDishById(String dishId);

    List<Dish> getAllDish();

    boolean addDish(Dish dish);

}
