package com.ordersystem.service.impl;

import com.ordersystem.dao.*;
import com.ordersystem.entity.*;
import com.ordersystem.service.AdminStatService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminStatServiceImpl implements AdminStatService {
    @Resource
    private OrderDetailDao orderDetailDao;
    @Resource
    private OrderDao orderDao;
    @Resource
    private DishDao dishDao;
    @Resource
    private UserDao userDao;


    @Override
    public void show() {

    }
}
