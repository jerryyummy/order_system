package com.ordersystem.service.impl;

import com.ordersystem.entity.Dish;
import com.ordersystem.dao.DishDao;
import com.ordersystem.service.AdminDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Dish)表服务实现类
 *
 * @author makejava
 * @since 2021-07-25 01:08:50
 */
@Service
public class AdminDishServiceImpl implements AdminDishService {

    @Autowired
    private DishDao dishDao;


    @Override
    public Dish getDish(String dishId) {
        Dish dish = dishDao.queryById(dishId);
        return dish;
    }

    @Override
    public boolean deleteDishById(String dishId) {

        return dishDao.deleteById(dishId);
    }

    @Override
    public List<Dish> getAllDish() {
        List<Dish> dishList = dishDao.queryAll();
        return dishList;
    }

    @Override
    public boolean addDish(Dish dish) {

        return dishDao.insert(dish);
    }
}
