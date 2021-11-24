package com.ordersystem.interceptor;

import com.ordersystem.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserLoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object o) throws Exception{
        String url=request.getRequestURI();
        if(!url.contains("/admin")||!url.contains("/waiter")||!url.contains("/cook")){
            HttpSession session=request.getSession();
            User user=(User)session.getAttribute("USER_SESSION");
            if(user!=null)
                return true;
            request.setAttribute("msg","您还没有登录，请先登录");
            request.getRequestDispatcher("/").forward(request,response);
            return false;
        }
        return true;

    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
