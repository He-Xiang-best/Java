package com.demo3.chart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.demo3.chart.*;
@WebServlet("/foodCount.do")
public class FoodCount extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FoodList foods;
		String foodId[];
		String message="";
		double totalP=0;
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session=request.getSession();
		
		//获取选购的商品id号
		foodId=request.getParameterValues("choice"); 
		
		foods=(FoodList)session.getAttribute("foods");		
	    if(foodId!=null&&foods!=null){    
	    	foods.setNum(foodId);	    
	    	message=foods.printFood();	  
	    	totalP=foods.totalP();
	    	session.setAttribute("foods", foods);
	    }
	    
	    
		//显示选购的商品
	    out.println("<HTML><BODY><P>这里是结帐处");
		String ID=(String)session.getId();
		String personName=(String)session.getAttribute("name");
		out.println("<br>您的ID号："+ID);
		out.println("<br>您的姓名："+personName);
	     out.println("<br>购物车中的商品：<br>"
	    +message+"<br>");
	    out.println("<br>总价格为：<br>"
	    	    +totalP+"<br>");	  
	  
	    out.println("<P>点击超链接，重新选购商品。");
	    out.println("<A HREF=test3/food.jsp>  欢迎去food.jsp！</A>");
	    out.println("<P>点击超链接，连接到main.jsp的页面,去修改姓名。");
	    out.println("<A HREF=test3/main.jsp> 欢迎去main.jsp！</A>");
	    out.println("</BODY></HTML>");
	}

}
