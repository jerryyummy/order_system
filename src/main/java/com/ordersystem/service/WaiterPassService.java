package com.ordersystem.service;

import com.ordersystem.entity.Dish;
import com.ordersystem.entity.OrderDetail;

import java.util.List;

public interface WaiterPassService {
    OrderDetail queryById(String Id);

    List<OrderDetail> queryFinishedDish() ;


    boolean pass(OrderDetail orderDetail);

}
