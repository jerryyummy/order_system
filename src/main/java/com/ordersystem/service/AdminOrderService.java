package com.ordersystem.service;

import com.ordersystem.entity.Order;
import com.ordersystem.entity.OrderDetail;

import java.util.List;

/**
 * (OrderDetail)表服务接口
 *
 * @author makejava
 * @since 2021-07-25 01:09:38
 */
public interface AdminOrderService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Order queryById(String id);


    List<Order> queryUnconfirmedOrder();//获得未确认订单

//    /**
//     * 新增数据
//     *
//     * @param orderDetail 实例对象
//     * @return 实例对象
//     */
//    OrderDetail insert(OrderDetail orderDetail);

    /**
     * 修改数据
     *
     */
    boolean update(Order order);//确认订单收钱


}
