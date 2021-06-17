<%--
  Created by IntelliJ IDEA.
  User: 17283
  Date: 2021/4/1
  Time: 18:17
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>注册页面</title>

    <%-- 静态包含 base标签、css样式、jQuery文件 --%>
    <%@ include file="/pages/common/head.jsp"%>

    <link rel="stylesheet" type="text/css" href="static/css/register.css">

    <script type="text/javascript" src="static/script/register.js"></script>
</head>
<body>
<div class="header">

</div>
<div class="rg_layout">
    <div class="rg_left">
        <p>用户注册</p>
        <p>USER REGISTER</p>

    </div>

    <div class="rg_center">
        <div class="rg_form">
            <!--定义表单 form-->
            <form action="${pageContext.request.contextPath}/userServlet" id="form"  method="post">
                <input type="hidden" name="action" value="register" />
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
                                   value="${requestScope.userInfo.password}">
                            <span id="s_password" class="error"></span>
                        </td>
                    </tr>

                    <tr>
                        <td class="td_left"><label for="password">确认密码</label></td>
                        <td class="td_right">
                            <input type="password"  id="confirmpassword" placeholder="请再次输入密码"
                                   value="${requestScope.userInfo.password}">
                            <span id="s_comfirmpassword" class="error"></span>
                        </td>
                    </tr>

                    <tr>
                        <td class="td_left"><label for="email">电子邮箱</label></td>
                        <td class="td_right"><input type="email" name="email" id="email" placeholder="请输入邮箱"
                                                    value="${requestScope.userInfo.email}">
                            <span id="s_email" class="error"></span>
                        </td>

                    </tr>

                    <tr>
                        <td class="td_left"><label for="tel">手机号</label></td>
                        <td class="td_right"><input type="text" name="phone" id="tel" placeholder="请输入手机号"
                                                    value="${requestScope.userInfo.phone}">
                            <span id="s_telphone" class="error"></span>
                        </td>

                    </tr>


                    <tr>
                        <td class="td_left"><label>性别</label></td>
                        <td class="td_right">
                            <input type="radio"  value="male"> 男
                            <input type="radio"  value="female"> 女
                        </td>
                    </tr>


                    <tr>
                        <td class="td_left"><label for="checkcode">验证码</label></td>
                        <td class="td_right"><input type="text" name="checkCode" id="checkcode" placeholder="请输入验证码">
                        <td class="yan"><img id="verificationCode" src="${pageContext.request.contextPath}/VerificationCode"></td>
<%--                        <td class="yan2"><a id="change" class="view" href="" style="color: blue">看不清？换一张</a></td>--%>
                            </a>
                        </td>
                    </tr>

                    <tr>
                        <td colspan="2"  id="td_sub"><input type="submit" id="btn_sub" value="注册"></td>
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
            已有账号?&nbsp;&nbsp;&nbsp;
            <a href="pages/user/login.jsp">立即登录</a>
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
        if (Integer.parseInt(flag)==2) {
            out.print("<script>alert('用户名已存在或用户已创建成功，请重试注册或登入查看！');</script>");
        }
    }
%>
</html>
