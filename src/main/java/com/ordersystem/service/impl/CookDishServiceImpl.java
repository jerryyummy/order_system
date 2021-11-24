package com.ordersystem.service.impl;

import com.ordersystem.dao.DishDao;
import com.ordersystem.dao.OrderDao;
import com.ordersystem.dao.OrderDetailDao;
import com.ordersystem.entity.OrderDetail;
import com.ordersystem.service.CookDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CookDishServiceImpl implements CookDishService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private OrderDetailDao orderDetailDao;

    @Override
    public OrderDetail queryById(String id) {
        return orderDetailDao.queryById(id);
    }

    @Override
    public List<OrderDetail> queryAllDish() {
        List<OrderDetail> orderDetailList = orderDetailDao.queryDoingDish();
        return orderDetailList;
    }

    @Override
    public boolean finish(OrderDetail orderDetail) {

        return orderDetailDao.finishDish(orderDetail);
    }
}
