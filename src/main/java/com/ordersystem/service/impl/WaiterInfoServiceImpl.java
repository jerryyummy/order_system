package com.ordersystem.service.impl;

import com.ordersystem.dao.UserDao;
import com.ordersystem.entity.User;
import com.ordersystem.service.WaiterInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WaiterInfoServiceImpl implements WaiterInfoService {
    @Autowired
    private UserDao userDao;

    @Override
    public User queryById(String userid) {
        return userDao.queryById(userid);
    }

    @Override
    public boolean update(User user) {

        return userDao.update(user);
    }

    @Override
    public boolean delete(String userid){
        return userDao.deleteById(userid);
    }
}
