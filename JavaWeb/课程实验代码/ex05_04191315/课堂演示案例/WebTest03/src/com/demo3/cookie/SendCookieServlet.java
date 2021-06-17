package com.demo3.cookie;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test3/sendCookie.do")
public class SendCookieServlet extends HttpServlet {
	String message=null;
     @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
                             throws ServletException, IOException {
    	 Cookie usercookie=new Cookie("username","hacker");
    	 //新建Cookie
    	 usercookie.setMaxAge(7*24*60*60);     
    	 response.addCookie(usercookie);
    	 

 		response.setContentType("text/html;charset=utf-8");
 		PrintWriter out = response.getWriter();
 
 		out.println("<HTML>");
 		out.println("  <HEAD><TITLE>A Servlet发送Cookie</TITLE></HEAD>");
 		out.println("  <BODY>");
 		out.println("<h3>已向浏览器发送一个Cookie</h3>");
 		out.println("  </BODY>");
 		out.println("</HTML>");
 		out.flush();
 		out.close();	 
     }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
                            throws ServletException, IOException {
    	 doGet(request,response);
    }
} 