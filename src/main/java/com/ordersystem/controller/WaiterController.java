package com.ordersystem.controller;

import com.ordersystem.entity.*;
import com.ordersystem.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * (Order)表控制层
 *
 * @author makejava
 * @since 2021-07-25 01:09:36
 */
@Controller
@RequestMapping("waiter")
public class WaiterController {
    /**
     * 服务对象
     */
    @Autowired
    private WaiterPassService waiterPassService;
    @Autowired
    private WaiterInfoService waiterInfoService;
    @Autowired
    private WaiterNoticeService waiterNoticeService;
    @Autowired
    private WaiterOrderService waiterOrderService;
    @Autowired
    private WaiterMenuService waiterMenuService;
    @Autowired
    private waiterDetailService waiterDetailService;


    @RequestMapping("index")
    public String index(){
        return "waiter_index";
    }

    @RequestMapping("info")
    public String  showInfo(Model model, HttpSession session){
        User user = (User) session.getAttribute("user_session");
        model.addAttribute("user",user);
        return "waiter_info";
    }

    @RequestMapping("/changePassword")
    public String changePassword(String userId,String password){
        User user = waiterInfoService.queryById(userId);
        user.setPassword(password);
        waiterInfoService.update(user);
        return "forward:info";
    }

    @RequestMapping("changeImage")
    public String changeImage(String userId, String url){
        User user = waiterInfoService.queryById(userId);
        user.setUrl_image(url);
        waiterInfoService.update(user);
        return "forward:info";
    }

    @RequestMapping("showMenu")
    public String showMenu(Model model){
        List<Dish> getNormalDish = waiterMenuService.getNormalDish();
        List<Dish> getSpecialList = waiterMenuService.getRecommendDish();
        model.addAttribute("getSpecialList",getSpecialList);
        model.addAttribute("getNormalDish",getNormalDish);
        return "waiter_menu";
    }

    @RequestMapping("getDetail")
    public String getDetail(String dishId,Model model){
        Dish dish = waiterDetailService.getDetail(dishId);
        model.addAttribute("dish",dish);
        return "waiter_detail";
    }

    @RequestMapping("notice")
    public String notice(Model model){
        List<Notice> noticeList = waiterNoticeService.queryAllNotice();
        model.addAttribute("notices",noticeList);
        return "waiter_notice";
    }

    @RequestMapping("changeNoticeStatus")
    public String changeNoticeStatus(String noticeId){
        Notice notice = waiterNoticeService.queryById(noticeId);
        waiterNoticeService.update(notice);
        return "forward:notice";
    }

    @RequestMapping("getDish")
    public String getDish(Model model){
        List<OrderDetail> orderDetailList = waiterPassService.queryFinishedDish();
        model.addAttribute("orderDetailList",orderDetailList);
        return "waiter_pass";
    }

    @RequestMapping("finishPass")
    public String finishPass(String Id){
        OrderDetail orderDetail = waiterPassService.queryById(Id);
        waiterPassService.pass(orderDetail);
        return "forward:getDish";
    }

    @RequestMapping("showOrder")
    public String showOrder(Model model){
        List<Dish> dishList = waiterOrderService.queryOrder();
        model.addAttribute("dishlist",dishList);
        return "waiter_order";
    }

    @RequestMapping("makeOrder")//生成订单以及订单详情
    public String makeOrder(String orderId, String table_number, Float sum, HttpSession session){
        List<OrderItem> lists = (List<OrderItem>)session.getAttribute("list");
        String userid = ((User) session.getAttribute("user_session")).getUserid();
        Order order = new Order(orderId,userid,table_number,sum);
        waiterOrderService.createOrder(order);//创建订单
        for (OrderItem orderItem:lists){
            String Id = userid+orderId+sum+table_number;
            Dish dish = waiterOrderService.queryDishByName(orderItem.getName());
            OrderDetail orderDetail = new OrderDetail(Id,orderId, orderItem.getAmount(),dish.getDishid(),order,dish);
            waiterOrderService.createOrderDetail(orderDetail);//创建订单详情
        }
        session.removeAttribute("list");
        return "redirect:showOrder";
    }


    @RequestMapping("addDish")
    public String addDish(String dishId, int amount,HttpSession session){
        String name = waiterOrderService.addDish(dishId);//返回菜名
        OrderItem orderItem = new OrderItem(name,amount,dishId);
        System.out.println(orderItem.getAmount());
        List<OrderItem> list = new ArrayList<>();
        List<OrderItem> lists = (List<OrderItem>)session.getAttribute("list");//获得session当中的表
        if( lists != null){
            lists.add(orderItem);
            session.setAttribute("list", lists);
        }else {
            list.add(orderItem);
            session.setAttribute("list", list);
        }

        return "redirect:showOrder";
    }

    @RequestMapping("deleteDish")
    public String deleteDish(String dishId, int amount,HttpSession session){
        String name = waiterOrderService.addDish(dishId);//返回菜名
        OrderItem orderItem = new OrderItem(name,amount,dishId);
        System.out.println(orderItem.getAmount());
        List<OrderItem> lists = (List<OrderItem>)session.getAttribute("list");//获得session当中的表
        lists.remove(orderItem);
        session.setAttribute("list", lists);

        return "redirect:showOrder";
    }

}
