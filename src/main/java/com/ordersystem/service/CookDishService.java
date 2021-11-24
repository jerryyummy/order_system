package com.ordersystem.service;

import com.ordersystem.entity.Dish;
import com.ordersystem.entity.OrderDetail;

import java.util.List;

public interface CookDishService {
    OrderDetail queryById(String id);

    List<OrderDetail> queryAllDish();


    boolean finish(OrderDetail orderDetail);

//    /**
//     * 通过主键删除数据
//     *
//     * @param dishid 主键
//     * @return 是否成功
//     */
//    boolean deleteById(String dishid);
}
