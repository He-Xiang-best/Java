package com.blog.interceptor;

/*
 * @ClassName Login
 * @description: TODO
 * @author: 何翔
 * @Date 2021/6/10 15:43
 */

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       //放行：判断什么情况登入
        if(request.getSession().getAttribute("userInfo")!=null)
            return true;
        if ((request.getRequestURI().contains("admin"))){
            if(request.getSession().getAttribute("userInfo")==null){
                System.out.println("已拦截");
                request.getRequestDispatcher("/index.jsp").forward(request, response);
                return false;
            }

        }
        //判断什么情况下没有登入
        request.getRequestDispatcher("/index.jsp").forward(request, response);
        return false;
    }
}

