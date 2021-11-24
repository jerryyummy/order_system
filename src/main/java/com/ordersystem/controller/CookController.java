package com.ordersystem.controller;

import com.ordersystem.entity.Dish;
import com.ordersystem.entity.Notice;
import com.ordersystem.entity.OrderDetail;
import com.ordersystem.entity.User;
import com.ordersystem.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * (Dish)表控制层
 *
 * @author makejava
 * @since 2021-07-25 01:08:52
 */
@Controller
@RequestMapping("cook")
public class CookController {
    /**
     * 服务对象
     */
    @Autowired
    private CookDishService cookDishService;
    @Autowired
    private CookInfoService cookInfoService;
    @Autowired
    private CookNoticeService cookNoticeService;
    @Autowired
    private CookOrderService cookOrderService;

    @RequestMapping("notice")
    public String showNotice(Model model){
        List<Notice> noticeList = cookNoticeService.queryAllNotice();
        model.addAttribute("notices",noticeList);
        return "cook_notice";
    }

    @RequestMapping("changeNoticeStatus")
    public String changeNoticeStatus(String noticeId){
        Notice notice = cookNoticeService.queryNotice(noticeId);
        cookNoticeService.update(notice);
        return "forward:showNotice";
    }

    @RequestMapping("dish")
    public String showDish(Model model){
        List<OrderDetail> orderDetailList = cookDishService.queryAllDish();
        model.addAttribute("cookingList",orderDetailList);
        return "cook_dish";
    }

    @RequestMapping("finishDish")
    public String finishDish(String id){
        OrderDetail orderDetail = cookDishService.queryById(id);
        cookDishService.finish(orderDetail);
        return "forward:showDish";
    }

    @RequestMapping("order")
    public String showOrder(Model model){
        List<OrderDetail> orderDetailList = cookOrderService.queryAllOrderDetail();
        model.addAttribute("cookingList",orderDetailList);
        return "cook_order";
    }

    @RequestMapping("doOrder")
    public String doOrder(String id){//接收订单，开始烹饪
        OrderDetail orderDetail = cookOrderService.queryById(id);
        cookOrderService.finish(orderDetail);
        return "forward:showOrder";
    }

    @RequestMapping("info")
    public String  showInfo(Model model, HttpSession session){
        User user = (User) session.getAttribute("user_session");
        model.addAttribute("user",user);
        return "cook_info";
    }

    @RequestMapping("changePassword")
    public String changePassword(String userId,String password){
        User user = cookInfoService.queryById(userId);
        user.setPassword(password);
        cookInfoService.update(user);
        return "forward:showInfo";
    }

    @RequestMapping("changeImage")
    public String changeImage(String userId, String url){
        User user = cookInfoService.queryById(userId);
        user.setUrl_image(url);
        cookInfoService.update(user);
        return "forward:showInfo";
    }

}
