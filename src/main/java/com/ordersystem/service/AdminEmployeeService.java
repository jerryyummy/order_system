package com.ordersystem.service;

import com.ordersystem.entity.User;
import java.util.List;

public interface AdminEmployeeService {

    User queryById(String userid);


    List<User> queryAll();//查询除了管理人员之外的员工

    /**
     * 新增数据
     *
     */
    boolean insert(User user);


    boolean deleteById(String dishid);
}
