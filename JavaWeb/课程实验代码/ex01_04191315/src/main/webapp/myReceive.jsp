<%--
  Created by IntelliJ IDEA.
  User: 17283
  Date: 2021/3/6
  Time: 18:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.net.*"%>
<html>
<head>
    <title>我的表单反馈</title>
</head>
<body>
<Font size=8>
    <a href="index.jsp">回到首页</a>
        <%  request.setCharacterEncoding("utf-8");
       String yourName=request.getParameter("myName");   //获取姓名提交的值
	   String yourId=request.getParameter("id");         //获取学号提交的值
       out.println("<P> 你的学号:"+yourId+"</P>");
       out.println("<P> 你的姓名:"+yourName+"</P>");
 %>

</body>
</html>
