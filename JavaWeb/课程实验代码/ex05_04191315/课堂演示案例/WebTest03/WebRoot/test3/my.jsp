<%@ page language="java"   pageEncoding="Utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Session ID的显示</title>
</head>
<body><font size=8>
<%String ID=(String)session.getId();
  %>
  sessionID号<%=ID%></font>
<br><A HREF="main.jsp">返回登录页</A>
</body>
</html>