package com.ordersystem.service;

import com.ordersystem.entity.Dish;
import com.ordersystem.entity.User;

import java.util.List;

public interface CookInfoService {
    User queryById(String userid);

    boolean delete(String userid);

    /**
     * 修改数据
     *
     */
    boolean update(User user);
}
