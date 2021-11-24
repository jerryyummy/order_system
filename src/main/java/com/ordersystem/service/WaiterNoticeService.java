package com.ordersystem.service;

import com.ordersystem.entity.Notice;

import java.util.List;

public interface WaiterNoticeService {
    Notice queryById(String id);

    List<Notice> queryAllNotice();


    boolean update(Notice notice);


}
