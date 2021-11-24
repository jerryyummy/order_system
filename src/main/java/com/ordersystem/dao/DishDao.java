package com.ordersystem.dao;

import com.ordersystem.entity.Dish;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Dish)表数据库访问层
 *
 * @author makejava
 * @since 2021-07-25 01:08:46
 */
public interface DishDao {

    /**
     * 通过ID查询单条数据
     *
     * @param dishid 主键
     * @return 实例对象
     */
    Dish queryById(String dishid);

    Dish queryByName(String name);

    /**
     * 查询指定行数据
     *
     *
     */
    List<Dish> queryRecommendDish();

    List<Dish> queryNormalDish();


    /**
     * 通过实体作为筛选条件查询
     *
     */
    List<Dish> queryAll();

    /**
     * 新增数据
     *
     * @param dish 实例对象
     * @return 影响行数
     */
    boolean insert(Dish dish);

//    /**
//     * 批量新增数据（MyBatis原生foreach方法）
//     *
//     * @param entities List<Dish> 实例对象列表
//     * @return 影响行数
//     */
//    int insertBatch(@Param("entities") List<Dish> entities);

//    /**
//     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
//     *
//     * @param entities List<Dish> 实例对象列表
//     * @return 影响行数
//     */
//    int insertOrUpdateBatch(@Param("entities") List<Dish> entities);

//    /**
//     * 修改数据
//     *
//     * @param dish 实例对象
//     * @return 影响行数
//     */
//    int update(Dish dish);

    /**
     * 通过主键删除数据
     *
     * @param dishid 主键
     * @return 影响行数
     */
    boolean deleteById(String dishid);

}

