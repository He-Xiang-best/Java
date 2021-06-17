<%@ page import="java.io.IOException" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="ex04.GoBack" %><%--
  Created by IntelliJ IDEA.
  User: 17283
  Date: 2021/3/25
  Time: 1:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%

new GoBack().doPost(request, response);
%>



<html>
<head>
    <meta charset="UTF-8">
    <title>此用户不存在</title>

    <link rel="stylesheet" type="text/css" href="css/redirect.css">

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


        <h3 class="tishi">用户信息错误！<a href="/test04/index.jsp" >5秒后转向登录页面...(点击立即返回)</a></h3>
        <div class="rg_form" style="margin-left: 40px">

            <table>
                <tr>

                    <td><img style="vertical-align: middle " width="200px" height="200px"
                             src="/test04/img/fail1.png"></td>
                </tr>

            </table>

        </div>

    </div>

</div>

</body>

</html>