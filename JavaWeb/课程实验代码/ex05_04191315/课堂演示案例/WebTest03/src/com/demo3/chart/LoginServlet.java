package com.demo3.chart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/login.view")
public class LoginServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");			
		HttpSession session=request.getSession();
		
		String name=request.getParameter("name");
	     FoodList foods=new FoodList();  
		if(name==null)
	       {  name="";
	       	  response.sendRedirect("/WEB-INF/main.jsp");
	       }
	       else
	       {  
	    	   //System.out.println("µÇÂ¼³É¹¦");
	    	   session.setAttribute("name",name);
	    	   session.setAttribute("foods", foods);
	    	   response.sendRedirect("test3/food.jsp");
	       }
		
	}
	
	

}
