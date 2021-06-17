package cc.test.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShopingServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取从Shopping.jsp传来的request对象中的ID号
		
        //在ID号不为空的情况下，获取Session对象中的购物车信息，Book数组。
		
		//找到数组中与ID对应的Book对象，将其属性bookNum数字加1
		
		//将数组写回session对象中去。
		
		//跳转回Shopping.jsp
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

	

}
