package com.ordersystem.dao;


import com.ordersystem.entity.Notice;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Notice)表数据库访问层
 *
 * @author makejava
 * @since 2021-07-25 01:09:30
 */
public interface NoticeDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Notice queryById(String id);


    List<Notice> queryReceivedNotice();

    List<Notice> queryNormalNotice();


    List<Notice> queryAll();

    /**
     * 新增数据
     *
     * @param notice 实例对象
     * @return 影响行数
     */
    boolean insert(Notice notice);

//    /**
//     * 批量新增数据（MyBatis原生foreach方法）
//     *
//     * @param entities List<Notice> 实例对象列表
//     * @return 影响行数
//     */
//    int insertBatch(@Param("entities") List<Notice> entities);
//
//    /**
//     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
//     *
//     * @param entities List<Notice> 实例对象列表
//     * @return 影响行数
//     */
//    int insertOrUpdateBatch(@Param("entities") List<Notice> entities);
//
    /**
     * 修改数据
     *
     * @param notice 实例对象
     * @return 影响行数
     */
    boolean update(Notice notice);

//    /**
//     * 通过主键删除数据
//     *
//     * @param id 主键
//     * @return 影响行数
//     */
//    int deleteById(String id);

}

