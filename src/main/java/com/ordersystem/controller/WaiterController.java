package com.ordersystem.controller;

import com.ordersystem.entity.*;
import com.ordersystem.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
        System.out.println(table_number);
        HashMap<String, OrderItem> orderItems = (HashMap<String, OrderItem>) session.getAttribute("orderItems");
        String userid = ((User) session.getAttribute("user_session")).getUserid();
        Order order = new Order(orderId,userid,table_number,sum);
        waiterOrderService.createOrder(order);//创建订单
        for (OrderItem orderItem:orderItems.values()){
            String Id = UUID.randomUUID().toString();;
            Dish dish = waiterOrderService.queryDishByName(orderItem.getName());
            OrderDetail orderDetail = new OrderDetail(Id,orderId, orderItem.getAmount(),dish.getDishid(),order,dish);
            waiterOrderService.createOrderDetail(orderDetail);//创建订单详情
        }
        session.removeAttribute("orderItems");
        return "redirect:showOrder";
    }


    @RequestMapping("addDish")
    public ResponseEntity<Map<String, Object>> addDish(String dishId, int amount, float price, HttpSession session){
        String name = waiterOrderService.addDish(dishId); // Returns the dish name
        HashMap<String, OrderItem> orderItems = (HashMap<String, OrderItem>) session.getAttribute("orderItems");

        if (orderItems == null) {
            orderItems = new HashMap<>();
            session.setAttribute("orderItems", orderItems);
        }

        // Check if the dish is already ordered
        if (orderItems.containsKey(dishId)) {
            // If yes, just update the amount
            OrderItem existingItem = orderItems.get(dishId);
            existingItem.setAmount(existingItem.getAmount() + amount);
        } else {
            // If no, create a new order item and add it to the map
            OrderItem orderItem = new OrderItem(name, amount, dishId, price);
            orderItems.put(dishId, orderItem);
        }

        // 返回更新后的订单列表和总金额
        Map<String, Object> response = new HashMap<>();
        response.put("orderItems", orderItems.values());
        response.put("totalPrice", orderItems.values().stream().mapToDouble(item -> item.getPrice() * item.getAmount()).sum());
        return ResponseEntity.ok(response);
    }


    @RequestMapping("deleteDish")
    public ResponseEntity<Map<String, Object>> deleteDish(String dishId, int amount, HttpSession session){
        HashMap<String, OrderItem> orderItems = (HashMap<String, OrderItem>) session.getAttribute("orderItems");

        if (orderItems != null) {
            OrderItem orderItem = orderItems.get(dishId);
            if (orderItem.getAmount()-amount<=0){
                orderItems.remove(dishId);
            }else{
                orderItem.setAmount(orderItem.getAmount()-amount);
                orderItems.put(dishId,orderItem);
            }
            session.setAttribute("orderItems", orderItems);
        }

        Map<String, Object> response = new HashMap<>();
        response.put("orderItems", orderItems.values());
        response.put("totalPrice", orderItems.values().stream().mapToDouble(item -> item.getPrice() * item.getAmount()).sum());
        return ResponseEntity.ok(response);
    }


}
