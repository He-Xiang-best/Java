<%--
  Created by IntelliJ IDEA.
  User: 何翔
  Date: 2021/3/6
  Time: 18:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的表单</title>
</head>
<body>
<h1>用户登录</h1>
<br />
<br />
<form action="http://localhost:8080/test01/myReceive.jsp" method="GET">
    学 号:<input type="text" placeholder="请输入学号....." name="id">
    <br />
    <br />
    姓 名:<input type="text" placeholder="请输入姓名....." name="myName">
    <br />
    <br />
    <input type="submit" value="登录">
</form>
</body>
</html>
