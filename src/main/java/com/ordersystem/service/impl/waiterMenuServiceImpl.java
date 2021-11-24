package com.ordersystem.service.impl;

import com.ordersystem.dao.DishDao;
import com.ordersystem.entity.Dish;
import com.ordersystem.service.WaiterMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class waiterMenuServiceImpl implements WaiterMenuService {
    @Autowired
    private DishDao dishDao;

    @Override
    public List<Dish> getNormalDish() {
        List<Dish> dishList = dishDao.queryNormalDish();
        return dishList;
    }

    @Override
    public List<Dish> getRecommendDish() {
        List<Dish> dishList = dishDao.queryRecommendDish();
        return dishList;
    }
}
