package com.demo3.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet ("/index.do")
public class Index extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Cookie[] cookies=request.getCookies();
    	String name="",pwd="";
    	boolean flag=true;
    	Cookie cookie=null;
    	int i=0;    	
    	if (cookies!=null) {
    		System.out.println("cookie的长度"+cookies.length);
    	      while (i<cookies.length ) {
    	    	 cookie=cookies[i];
    	    	 i++;
    	        if(cookie.getName().equals("user"))
    	        	name=cookie.getValue();
    	        if(cookie.getName().equals("pwd"))
    		       pwd=cookie.getValue();
    		   System.out.println(i+"1"+name+":::2"+pwd);
    	      }
    		   if ("hello".equals(name)&&"123456".equals(pwd)){    			
    			request.getRequestDispatcher("welcome.jsp").forward(request,response);
    		   }
    		   else{
    			   //message="请重新登陆";
    			   //request.getSession().setAttribute("message", message);
    			   response.sendRedirect("login.jsp");
    		   }
    	     
    	}
    	
    
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

}
