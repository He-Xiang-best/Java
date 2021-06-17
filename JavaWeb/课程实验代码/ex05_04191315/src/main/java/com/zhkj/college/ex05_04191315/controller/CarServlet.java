package com.zhkj.college.ex05_04191315.controller;

import com.zhkj.college.ex05_04191315.vo.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cart.view")
public class CarServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html ; Charset=UTF-8");
        PrintWriter out = response.getWriter();
        /*判断得到session对象中存储的book信息是否为空
		不为空的前提下，读出Book数组中的内容，并将数目不为1的图书信息显示在网页上。
	     */
        HttpSession session = request.getSession();
        String sumNum = (String) session.getAttribute("sumNum");
        if (sumNum==null) sumNum="0";
        Book[] bookList = (Book[]) session.getAttribute("bookList");
        out.println("<html><body>");
        out.println("<h1>已采购"+sumNum+"本书籍</h1>");
        out.println("<table border=\"1\">");
        if (bookList != null) {
          for (Book book : bookList) {
            if (book.getBookNum() > 0) {
              out.println("<tr>");
              out.println("<td><img src='" + book.getBookImg() + "'> </td>");
              out.println("<td>&nbsp共" + book.getBookNum() + "本&nbsp</td>");
              out.println("</tr>");
            }
          }
          out.println("</table></body></html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}