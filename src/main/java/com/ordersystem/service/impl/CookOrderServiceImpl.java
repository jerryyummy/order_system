package com.ordersystem.service.impl;

import com.ordersystem.dao.OrderDetailDao;
import com.ordersystem.entity.OrderDetail;
import com.ordersystem.service.CookOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CookOrderServiceImpl implements CookOrderService {
    @Autowired
    private OrderDetailDao orderDetailDao;

    @Override
    public OrderDetail queryById(String id) {
        return orderDetailDao.queryById(id);
    }


    @Override
    public List<OrderDetail> queryAllOrderDetail() {//返回没有烹饪的订单
        List<OrderDetail> orderDetailList = orderDetailDao.queryOrderedDish();
        return orderDetailList;
    }

    @Override
    public boolean finish(OrderDetail orderDetail) {
        return orderDetailDao.doDish(orderDetail);
    }
}
