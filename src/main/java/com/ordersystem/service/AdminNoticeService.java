package com.ordersystem.service;


import com.ordersystem.entity.Notice;
import java.util.List;

/**
 * (Notice)表服务接口
 *
 * @author makejava
 * @since 2021-07-25 01:09:31
 */
public interface AdminNoticeService {


    boolean notice(Notice notice);

    List<Notice> getAllNotice();

}
