package com.ordersystem.service.impl;

import com.ordersystem.dao.DishDao;
import com.ordersystem.dao.UserDao;
import com.ordersystem.entity.User;
import com.ordersystem.service.AdminEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminEmployeeServiceImpl implements AdminEmployeeService {
    @Autowired
    private UserDao userDao;

    @Override
    public User queryById(String userid) {
        User user = userDao.queryById(userid);
        return user;
    }

    @Override
    public List<User> queryAll() {
        List<User> userList = userDao.queryAllByLimit();
        return userList;
    }

    @Override
    public boolean insert(User user) {
        return userDao.insert(user);
    }

    @Override
    public boolean deleteById(String userId) {
        return userDao.deleteById(userId);
    }
}
