package com.ordersystem.service;

import com.ordersystem.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AdminInfoService {

    User queryById(String userid);

    boolean update(User user);

    boolean delete(String userId);

}
