package com.demo3.cookie;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test3/readCookie.do")
public class ReadCookieServlet extends HttpServlet {
	String message=null;
     @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
                             throws ServletException, IOException {
    	String cookieName="username";
    	String cookieValue=null;
    	Cookie[] cookies=request.getCookies();
    	String value1="",value2="";
     	int i=0;
     	if (cookies!=null) {
     	      for (Cookie cookie:cookies){
     	    	  i++;
     	        if(cookieName.equals(cookie.getName()))
     	        	cookieValue=cookie.getValue();
    	 
     	      }
     	}
 		response.setContentType("text/html;charset=utf-8");
 		PrintWriter out = response.getWriter();
 
 		out.println("<HTML>");
 		out.println("  <HEAD><TITLE>读取Cookie</TITLE></HEAD>");
 		out.println("  <BODY>");
 		out.println("<h3>从浏览器读回一个Cookie</h3>");
 		out.println("Cookie名 "+cookieName);
 		out.println("Cookie值 "+cookieValue);
 		out.println("</HTML></BODY>");
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