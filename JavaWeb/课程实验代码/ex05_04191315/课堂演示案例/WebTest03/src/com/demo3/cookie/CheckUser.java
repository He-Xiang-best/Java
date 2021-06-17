package com.demo3.cookie;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CheckUser.do")
public class CheckUser extends HttpServlet {
	String message=null;
     @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
                             throws ServletException, IOException {
    	 doPost(request,response);
     }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
                            throws ServletException, IOException {
    	 String user = request.getParameter("user");
         String passwd = request.getParameter("passwd");
         
         if("hello".equals(user) && "123456".equals(passwd)) {
             
             String login = request.getParameter("login");
             if("auto".equals(login)){
             	Cookie namecookie=new Cookie("user",user);//新建Cookie
             	Cookie pwdcookie=new Cookie("pwd",passwd);
             	namecookie.setMaxAge(7*24*60*60); 
             	pwdcookie.setMaxAge(7*24*60*60);
             	response.addCookie(namecookie);
             	response.addCookie(pwdcookie);
             }
             //message="你已成功登陆！";
             request.getSession().setAttribute("message", message);
             System.out.println("login::"+login);
             response.sendRedirect("welcome.jsp");
         }
         else {
        	 //message="用户名或口令不正确，请重试！";
        	 //request.getSession().setAttribute("message", message);
             response.sendRedirect("login.jsp");
         }
    }
} 