package com.ordersystem.service.impl;

import com.ordersystem.dao.OrderDao;
import com.ordersystem.entity.Order;
import com.ordersystem.entity.OrderDetail;
import com.ordersystem.dao.OrderDetailDao;
import com.ordersystem.service.AdminOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (OrderDetail)表服务实现类
 *
 * @author makejava
 * @since 2021-07-25 01:09:38
 */
@Service
public class AdminOrderServiceImpl implements AdminOrderService {
    @Autowired
    private OrderDetailDao orderDetailDao;
    @Autowired
    private OrderDao orderDao;
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Order queryById(String id) {
        return orderDao.queryById(id);
    }

    @Override
    public List<Order> queryUnconfirmedOrder() {
        List<Order> orders= orderDao.queryUnconfirmedOrder();
        return orders;
    }

    @Override
    public boolean update(Order order) {
        orderDao.update(order);
        return  orderDao.update(order);
    }


//    @Override
//    public OrderDetail insert(OrderDetail orderDetail) {
//        return null;
//    }




}
