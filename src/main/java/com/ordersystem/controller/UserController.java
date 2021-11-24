package com.ordersystem.controller;

import com.ordersystem.entity.User;
import com.ordersystem.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    /**
     * 服务对象
     */
    @Autowired
    private LoginService loginService;

    @RequestMapping("/")
    public String index(){
        return "login";
    }


    @RequestMapping("login")
    public String login(User user, HttpServletRequest request, HttpSession session){
        //调用login方法来验证是否是注册用户
        int loginType = loginService.login(user.getUserid(),user.getPassword());
        if(loginType!=3){
            //如果验证通过,则将用户信息传到前台
            request.setAttribute("user",user);
            request.setAttribute("message","登陆成功");
            session.setAttribute("user_session",user);
            if (loginType==2){
                return "redirect:/waiter/index";
            }
            else if (loginType==1){
                return "redirect:/cook/notice";
            }
            else {
                return "redirect:/admin/getAllDish";
            }

        }else{
            //若不对,则返回
            request.setAttribute("message","用户名密码错误");
            return "redirect:/";
        }
    }


    //登出,地址/logout
    @RequestMapping("logout")
    public String logout(HttpSession session){
        //清除session
        session.removeAttribute("user_session");
        //重定向到登录页面的跳转方法
        return "/login";
    }

}
