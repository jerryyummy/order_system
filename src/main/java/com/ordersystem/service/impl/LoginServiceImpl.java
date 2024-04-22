package com.ordersystem.service.impl;


import com.ordersystem.entity.User;
import com.ordersystem.dao.UserDao;
import com.ordersystem.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2021-07-25 01:09:39
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserDao userDao;


    @Override
    public int login(String name, String pwd) {

        User user = userDao.queryByName(name);
        if (user.getPassword().equals(pwd)){
            if (user.getRole().equals("0")){
                return 0;
            }
            else if (user.getRole().equals("1")){
                return 1;
            }
            else {
                return 2;
            }
        }
        else {
            return 3;
        }

    }

    @Override
    public User getUser(String username) {
        return userDao.queryByName(username);
    }

//    @Override
//    public boolean logout(User user) {
//        return false;
//    }
}
