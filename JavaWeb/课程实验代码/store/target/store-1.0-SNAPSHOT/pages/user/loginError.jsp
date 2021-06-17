<%@ page import="tool.GoBack" %><%--
  Created by IntelliJ IDEA.
  User: 17283
  Date: 2021/3/25
  Time: 1:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>此用户不存在</title>

    <link rel="stylesheet" type="text/css" href="/store/static/css/loginError.css">

</head>
<body>
<div class="header">

</div>

<div class="rg_layout">

    <div class="rg_left">
        <p>登入失败</p>
        <p>Fail to login!</p>
    </div>

    <div class="rg_center">


        <h3 class="tishi">用户信息错误！<a href="login.jsp" >3秒后转向登录页面...(点击立即返回)</a></h3>
        <div class="rg_form" style="margin-left: 40px">

            <table>
                <tr>

                    <td><img style="vertical-align: middle " width="200px" height="200px"
                             src="/store/static/img/error.png"></td>
                </tr>

            </table>

        </div>

    </div>

</div>

</body>
<%
    response.setHeader("Refresh", "3;URL=/store/pages/user/login.jsp");
%>
</html>