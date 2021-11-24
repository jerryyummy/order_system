package com.ordersystem.service.impl;
import com.ordersystem.dao.DishDao;
import com.ordersystem.entity.Dish;
import com.ordersystem.service.waiterDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class waiterDetailServiceImpl implements waiterDetailService {
    @Autowired
    private DishDao dishDao;

    @Override
    public Dish getDetail(String dishId) {
        Dish dish = dishDao.queryById(dishId);
        return dish;
    }
}
