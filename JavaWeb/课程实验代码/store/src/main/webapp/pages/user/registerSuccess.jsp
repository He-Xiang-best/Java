<%--
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
    <title>用户注册信息</title>

    <link rel="stylesheet" type="text/css" href="/store/static/css/loginSuccess.css">

</head>
<body>
<div class="header">

</div>

<div class="rg_layout">

    <div class="rg_left">
        <p>注册成功</p>
        <p>REGISTER<br/>SUCCESSFULLY!</p>
    </div>

    <div class="rg_center">

        <div class="rg_form">

            <!--定义表单 form-->
            <form action="/store/index.jsp" id="form" method="get">
                <table>
                    <tr>
                        <td class="td_left"><label >用户名:</label></td>
                        <td class="td_right">
                            <label>
                            ${sessionScope.user.username}
                            </label>
                        </td>

                    </tr>

                    <tr>
                        <td class="td_left"><label >手机号:</label></td>
                        <td class="td_right">
                            <label>
                                ${sessionScope.user.phone}
                            </label>
                        </td>
                    </tr>

                    <tr>
                        <td class="td_left"><label >电子邮箱:</label></td>
                        <td class="td_right">
                            <label>
                                ${sessionScope.user.email}

                            </label>
                        </td>
                    </tr>

                    <tr>
                        <td class="td_left"><label>账号ID:</label></td>
                        <td class="td_right">
                            <label>
                                ${sessionScope.user.id}

                            </label>
                        </td>
                    </tr>

                    <tr>
                        <td colspan="2"  id="td_sub"><input type="submit" id="btn_sub" value="进入主页"></td>
                    </tr>
                </table>

            </form>

        </div>

    </div>


</div>

</body>

</html>