package com.ordersystem.service;

import com.ordersystem.entity.Dish;
import com.ordersystem.entity.OrderDetail;

import java.util.List;

public interface CookOrderService {
    OrderDetail queryById(String id);

    List<OrderDetail> queryAllOrderDetail();//查询所有订单详情

    boolean finish(OrderDetail orderDetail);//接收某个订单，开始烹饪

//    /**
//     * 通过主键删除数据
//     *
//     * @param dishid 主键
//     * @return 是否成功
//     */
//    boolean deleteById(String dishid);
}
