package com.ordersystem.service;

import com.ordersystem.entity.Dish;
import com.ordersystem.entity.Notice;

import java.util.List;

public interface CookNoticeService {

    List<Notice> queryAllNotice();

    Notice queryNotice(String id);

    boolean update(Notice notice);
}
