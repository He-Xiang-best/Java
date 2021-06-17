<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<h2>实验三：编写与使用Servlet</h2>
    <br>
<p>P28习题：</p>
<form action="http://localhost:8080/test03/hello">
    <span>请输入姓名：</span>
    <input type="text" name="name">
    <input type="submit" value="提交">
</form>
<br>
<p>P38习题：</p>
<form action="http://localhost:8080/test03/servlet">
    <input type="submit" value="点击查看">
</form>

<br>
<p>视频学习测试：</p>
<form action="http://localhost:8080/test03/video_06" method="get">
    <input type="submit" value="video_06_07测试">
</form>

<%--<p>路径测试：</p>--%>
<%--<a href="hello">hello</a><br>--%>
<%--<a href="/hello">/hello</a><br>--%>
<%--<a href="servlet/">servlet/</a><br>--%>
<%--<a href="/servlet/">/servlet/</a>--%>
</body>
</html>