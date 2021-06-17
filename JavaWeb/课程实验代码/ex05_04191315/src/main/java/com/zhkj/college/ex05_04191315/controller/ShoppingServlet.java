package com.zhkj.college.ex05_04191315.controller;

/*
 * @ClassName ShoppingServlet
 * @description: TODO
 * @author: 何翔
 * @Date 2021/3/30 22:35
 */


import com.zhkj.college.ex05_04191315.vo.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/shopping.view")
public class ShoppingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html ; Charset=UTF-8");
        //获取从Shopping.jsp传来的request对象中的ID号
        String bookId = request.getParameter("id");
        System.out.println("已选购书本的ID为: "+bookId);
        //在ID号不为空的情况下，获取Session对象中的购物车信息，Book数组。
        HttpSession session = request.getSession();
        if (bookId!=null){
            Book[] bookList = (Book[]) session.getAttribute("bookList");
        // 找到数组中与ID对应的Book对象，将其属性bookNum数字加1
        for (Book book : bookList) {
            if(book.getBookId().equals(bookId)){
            book.setBookNum(book.getBookNum()+1);
          System.out.println(bookId+"当前的数量是: "+book.getBookNum());
            }
        }
        //将数组写回session对象中去。
            session.setAttribute("bookList",bookList);
            String num= (String) session.getAttribute("sumNum");
            if (num==null) {
            num="0";
            session.setAttribute("sumNum", String.valueOf(Integer.parseInt(num)+1));
            }
            session.setAttribute("sumNum", String.valueOf(Integer.parseInt(num)+1));
        }
        //跳转回Shopping.jsp
        response.sendRedirect("index.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
    }
}
