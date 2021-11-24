package com.ordersystem.service.impl;


import com.ordersystem.dao.DishDao;
import com.ordersystem.dao.OrderDetailDao;
import com.ordersystem.entity.Dish;
import com.ordersystem.entity.Order;
import com.ordersystem.dao.OrderDao;
import com.ordersystem.entity.OrderDetail;
import com.ordersystem.service.WaiterOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Order)表服务实现类
 *
 * @author makejava
 * @since 2021-07-25 01:09:36
 */
@Service
public class WaiterOrderServiceImpl implements WaiterOrderService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private DishDao dishDao;
    @Autowired
    private OrderDetailDao orderDetailDao;

    @Override
    public List<Dish> queryOrder() {
        List<Dish> dishList = dishDao.queryAll();
        return dishList;
    }


    @Override
    public boolean createOrder(Order order) {
        return orderDao.insert(order);
    }

    @Override
    public boolean createOrderDetail(OrderDetail orderDetail) {
        return orderDetailDao.insert(orderDetail);
    }

    @Override
    public String addDish(String dishId) {
        Dish dish = dishDao.queryById(dishId);
        return dish.getName();
    }

    @Override
    public String deleteDish(String dishId) {
        Dish dish = dishDao.queryById(dishId);
        return dish.getName();
    }

    @Override
    public Dish queryDishByName(String name) {
        return dishDao.queryByName(name);
    }
}
