package com.ordersystem.service.impl;

import com.ordersystem.dao.NoticeDao;
import com.ordersystem.entity.Notice;
import com.ordersystem.service.CookNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CookNoticeServiceImpl implements CookNoticeService {
    @Autowired
    private NoticeDao noticeDao;

    @Override
    public List<Notice> queryAllNotice() {
        List<Notice> noticeList = noticeDao.queryNormalNotice();
        return noticeList;
    }

    @Override
    public Notice queryNotice(String id) {
        Notice notice = noticeDao.queryById(id);
        return notice;
    }

    @Override
    public boolean update(Notice notice) {
        return noticeDao.update(notice);
    }
}
