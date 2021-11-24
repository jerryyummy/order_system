package com.ordersystem.dao;

import com.ordersystem.entity.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Order)表数据库访问层
 *
 * @author makejava
 * @since 2021-07-25 01:09:36
 */
public interface OrderDao {

    /**
     * 通过ID查询单条数据
     *
     * @param orderid 主键
     * @return 实例对象
     */
    Order queryById(String orderid);

    /**
     * 查询指定行数据
     *
     */
    List<Order> queryUnconfirmedOrder();


    /**
     * 通过实体作为筛选条件查询
     *
     */
    List<Order> queryAll();

    /**
     * 新增数据
     *
     * @param order 实例对象
     * @return 影响行数
     */
    boolean insert(Order order);


//    /**
//     * 批量新增数据（MyBatis原生foreach方法）
//     *
//     * @param entities List<Order> 实例对象列表
//     * @return 影响行数
//     */
//    int insertBatch(@Param("entities") List<Order> entities);
//
//    /**
//     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
//     *
//     * @param entities List<Order> 实例对象列表
//     * @return 影响行数
//     */
//    int insertOrUpdateBatch(@Param("entities") List<Order> entities);

    /**
     * 修改数据
     *
     * @param order 实例对象
     * @return 影响行数
     */
    boolean update(Order order);

//    /**
//     * 通过主键删除数据
//     *
//     * @param orderid 主键
//     * @return 影响行数
//     */
//    int deleteById(String orderid);

}

