<%@ page contentType="text/html;charset=utf-8" %>
<html>
<head>
<title>登录网页</title>
</head>
    <body>
      <form action="CheckUser.do" method="post">
            名称：<input type="text" name="user"><br>
            密码：<input type="password" name="passwd"><br>
            自动登录：<input type="checkbox" name="login" value="auto"><br>
            <input type="submit" value="发送">
        </form>
    </body>
</html>
