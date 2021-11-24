package com.ordersystem.dao;

import com.ordersystem.entity.Dish;
import com.ordersystem.entity.Order;
import com.ordersystem.entity.OrderDetail;
import org.apache.ibatis.annotations.Param;

import java.awt.*;
import java.util.List;

/**
 * (OrderDetail)表数据库访问层
 *
 * @author makejava
 * @since 2021-07-25 01:09:38
 */
public interface OrderDetailDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    OrderDetail queryById(String id);

    OrderDetail queryByDish(Dish dish);


    List<OrderDetail> queryAll(String orderId);//通过订单号获取

    List<OrderDetail> queryOrderedDish();//获得已经下单的订单

    List<OrderDetail> queryDoingDish();//获得正在烹饪的订单详情

    List<OrderDetail> queryFinishedDish();//获得可传菜的订单详情

    /**
     * 新增数据
     *
     * @param orderDetail 实例对象
     * @return 影响行数
     */
    boolean insert(OrderDetail orderDetail);

//    /**
//     * 批量新增数据（MyBatis原生foreach方法）
//     *
//     * @param entities List<OrderDetail> 实例对象列表
//     * @return 影响行数
//     */
//    int insertBatch(@Param("entities") List<OrderDetail> entities);

//    /**
//     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
//     *
//     * @param entities List<OrderDetail> 实例对象列表
//     * @return 影响行数
//     */
//    int insertOrUpdateBatch(@Param("entities") List<OrderDetail> entities);


    boolean doDish(OrderDetail orderDetail);


    boolean finishDish(OrderDetail orderDetail);

    boolean passDish(OrderDetail orderDetail);
}

