package com.ordersystem.controller;

import com.ordersystem.entity.*;
import com.ordersystem.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping("admin")
public class AdminController {
        /**
         * 服务对象
         */
        @Autowired
        private AdminDishService adminDishService;
        @Resource
        private AdminStatService adminStatService;
        @Resource
        private AdminInfoService adminInfoService;
        @Resource
        private AdminEmployeeService adminEmployeeService;
        @Autowired
        private AdminNoticeService adminNoticeService;
        @Autowired
        private AdminOrderService adminOrderService;

        @RequestMapping("adddish")
        public String addDish(Dish dish){
                adminDishService.addDish(dish);
                return "forward:getAllDish";
        }

        @RequestMapping("deleteDish")
        public String deleteDish(String dishId){
                adminDishService.deleteDishById(dishId);
                return "forward:getAllDish";
        }

        @RequestMapping("getAllDish")
        public String getAllDish(Model model){
                List<Dish> dishList = adminDishService.getAllDish();
                model.addAttribute("getAllDish",dishList);
                return "admin_dish";
        }

        @RequestMapping("addEmployee")
        public String addEmployee(User user){
                adminEmployeeService.insert(user);
                return "forward:showEmployee";
        }

        @RequestMapping("deleteEmployee")
        public String deleteEmployee(String userId){
                adminEmployeeService.deleteById(userId);
                return "forward:showEmployee";
        }


        @RequestMapping("showEmployee")
        public String showEmployee(Model model){
                List<User> userList = adminEmployeeService.queryAll();
                model.addAttribute("employeeList",userList);
                return "admin_employee";
        }

        @RequestMapping("info")
        public String showInfo(Model model, HttpSession session){
                User user = (User) session.getAttribute("user_session");
                System.out.println(user.getRole());
                model.addAttribute("user",user);
                return "admin_info";
        }

        @RequestMapping("changePassword")
        public String changePassword(String userId,String password){
                User user = adminInfoService.queryById(userId);
                user.setPassword(password);
                adminInfoService.update(user);
                return "forward:showInfo";
        }

        @RequestMapping("changeImage")
        public String changeImage(String userId, String url){
                User user = adminInfoService.queryById(userId);
                user.setUrl_image(url);
                adminInfoService.update(user);
                return "forward:showInfo";
        }

        @RequestMapping("notice")
        public String notice(Model model){
                List<Notice> noticeList = adminNoticeService.getAllNotice();
                model.addAttribute("receivedNotice",noticeList);
                return "admin_notice";
        }

        @RequestMapping("pushNotice")
        public String pushNotice(String id, String publisher, String text){
                Notice notice = new Notice(id,text,publisher,0);
                adminNoticeService.notice(notice);
                return "forward:notice";
        }

        @RequestMapping("Order")
        public String showOrder(Model model){
                List<Order> orders = adminOrderService.queryUnconfirmedOrder();
                model.addAttribute("UnconfirmedOrder",orders);
                return "admin_order";
        }

        @RequestMapping("finishOrder")
        public String finishOrder(String orderId){
                Order order = adminOrderService.queryById(orderId);
                adminOrderService.update(order);
                return "forward:showOrder";
        }

        @RequestMapping("getStat")
        public String getStat(){
                return "admin_stat";
        }

    }
