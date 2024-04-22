package com.ordersystem.service;

import com.ordersystem.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (User)表服务接口
 *
 * @author makejava
 * @since 2021-07-25 01:09:39
 */
public interface LoginService {

    int login(String name, String pwd);

    User getUser(String username);

//    boolean logout(User user);

}
