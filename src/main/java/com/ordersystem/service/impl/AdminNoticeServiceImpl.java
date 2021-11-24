package com.ordersystem.service.impl;


import com.ordersystem.entity.Notice;
import com.ordersystem.dao.NoticeDao;
import com.ordersystem.service.AdminNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Notice)表服务实现类
 *
 * @author makejava
 * @since 2021-07-25 01:09:32
 */
@Service
public class AdminNoticeServiceImpl implements AdminNoticeService {
    @Autowired
    private NoticeDao noticeDao;


    @Override
    public boolean notice(Notice notice) {//生成公告
        return noticeDao.insert(notice);

    }

    @Override
    public List<Notice> getAllNotice() {//获得过往公告

        List<Notice> noticeList = noticeDao.queryReceivedNotice();
        return noticeList;
    }
}
