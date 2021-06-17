<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登入页面</title>

    <%-- 静态包含 base标签、css样式、jQuery文件 --%>
    <%@ include file="/pages/common/head.jsp"%>

    <link rel="stylesheet" type="text/css" href="static/css/login.css">
    <script type="text/javascript" src="static/script/login.js"></script>

</head>
<body>
<div class="header">

</div>
<div class="rg_layout">
    <div class="rg_left">
        <p>用户登入</p>
        <p>USER LOGIN</p>

    </div>

    <div class="rg_center">
        <div class="rg_form">
            <!--定义表单 form-->
            <form action="${pageContext.request.contextPath}/userServlet" id="form"  method="post">
                <input type="hidden" name="action" value="login" />
                <table>
                    <tr>
                        <td class="td_left"><label for="username">用户名</label></td>
                        <td class="td_right">
                            <input type="text" name="username" id="username" placeholder="请输入用户名"
                                   value="${requestScope.userInfo.username}">
                            <span id="s_username" class="error"></span>
                        </td>

                    </tr>

                    <tr>
                        <td class="td_left"><label for="password">密码</label></td>
                        <td class="td_right">
                            <input type="password" name="password" id="password" placeholder="请输入密码"
                                   value="${requestScope.userInfo.username}">
                            <span id="s_password" class="error"></span>
                        </td>
                    </tr>

                    <tr>
                        <td class="td_left"><label for="checkcode">验证码</label></td>
                        <td class="td_right"><input type="text" name="checkCode" id="checkCode" placeholder="请输入验证码">
                        <td class="yan"><img id="verificationCode" src="VerificationCode"></td>
<%--                        <td class="yan2"><a id="change" class="view" href="" style="color: blue">看不清？换一张</a></td>--%>
                    </tr>

                    <tr>
                        <td colspan="2"  id="td_sub"><input type="submit" id="btn_sub" value="登入"></td>
                    </tr>
                </table>

            </form>

        </div>

    </div>

    <div class="returnIndex">
        <a href="index.jsp">返回主页</a>
    </div>
    <div class="rg_right">
        <p>
<%--            <a href="/store/index.jsp"></a>返回主页&nbsp;&nbsp;&nbsp;--%>
            没有账号?&nbsp;&nbsp;&nbsp;
            <a href="pages/user/register.jsp">现在注册</a>
        </p>
    </div>

</div>

</body>
<%
    String flag = (String) request.getAttribute("loginInfo");
    if(flag!=null) {
        if (Integer.parseInt(flag)==0) {
            out.print("<script>alert(' 验证码输入错误！请重新输入！');</script>");
        }
    }
%>
</html>