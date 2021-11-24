package com.ordersystem.service.impl;

import com.ordersystem.dao.OrderDetailDao;
import com.ordersystem.entity.Dish;
import com.ordersystem.entity.OrderDetail;
import com.ordersystem.service.WaiterPassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WaiterPassServiceImpl implements WaiterPassService {
    @Autowired
    private OrderDetailDao orderDetailDao;

    @Override
    public OrderDetail queryById(String Id) {
        OrderDetail orderDetail = orderDetailDao.queryById(Id);
        return orderDetail;
    }

    @Override
    public List<OrderDetail> queryFinishedDish() {
        List<OrderDetail> dishList = orderDetailDao.queryFinishedDish();
        return dishList;
    }

    @Override
    public boolean pass(OrderDetail orderDetail) {

        return orderDetailDao.passDish(orderDetail);
    }
}
