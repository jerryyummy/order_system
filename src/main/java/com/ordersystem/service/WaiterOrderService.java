package com.ordersystem.service;

import com.ordersystem.entity.*;
import java.util.List;


public interface WaiterOrderService {


    List<Dish> queryOrder();


    boolean createOrder(Order order);

    boolean createOrderDetail(OrderDetail orderDetail);

    String addDish(String dishid);

    String getDishName(String dishId);

    String deleteDish(String dishid);

    Dish queryDishByName(String name);

}
