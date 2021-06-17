<%@ page import="com.zhkj.college.ex05_04191315.vo.Book" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<%
    //当第一次访问采购网页，session对象中还没有book购物车信息时，进行初始化。
    if (session.getAttribute("bookList")==null){
        //在session对象中存储图书采购信息
        Book[] BookList = new Book[4];
        BookList[0] = new Book("10101", "Java核心技术", "img/10101.jpg", 0);
        BookList[1] = new Book("10102", "Java经典实例", "img/10102.jpg", 0);
        BookList[2] = new Book("10103", "Java7", "img/10103.jpg", 0);
        BookList[3] = new Book("10104", "JSP&Servlet", "img/10104.jpg",0);
        //存入session对象中
        session.setAttribute("bookList", BookList);
    }
%>
<body>
<br>
<img src="img/cart.jpg" height="60px" width="60px">
<a href="cart.view" >已采购
    <%
    String sumNum = (String)session.getAttribute("sumNum");
    if (sumNum==null) out.print("0");
    else out.print(sumNum);
    %>&nbsp;本书籍
</a>
<br/>
<%
    Book[]  bookList=(Book[])session.getAttribute("bookList");
    for (Book book:bookList){
        out.println("<tr>") ;
        out.println("<td> <img src='"+book.getBookImg()+ "'> </td>");
        String id=book.getBookId();
        out.println("<td> <a href=shopping.view?id="+id+">采购此书</a></td>");
        out.println("</tr>") ;
    }
%>
</table></body>
</html>