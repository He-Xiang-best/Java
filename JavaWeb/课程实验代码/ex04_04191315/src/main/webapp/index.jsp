<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登入页面</title>

    <link rel="stylesheet" type="text/css" href="css/login.css">
    <script type="text/javascript" src="js/index.js"></script>

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
            <form action="/test04/login" id="form"  method="post">
                <table>
                    <tr>
                        <td class="td_left"><label for="username">学号</label></td>
                        <td class="td_right">
                            <input type="text" name="s_id" id="username" placeholder="请输入学号">
                            <span id="s_username" class="error"></span>
                        </td>

                    </tr>

                    <tr>
                        <td class="td_left"><label for="password">姓名</label></td>
                        <td class="td_right">
                            <input type="text" name="s_name" id="password" placeholder="请输入姓名">
                            <span id="s_password" class="error"></span>
                        </td>
                    </tr>

                    <tr>
                        <td class="td_left"><label class="xueyuan">请选择学院</label></td>
                        <td class="td_right">
                            <select class="college" name="academy">
                                <option  value="计算机学院">计算机学院</option>
                                <option  value="工商管理学院">工商管理学院</option>
                                <option  value="旅游学院">旅游学院</option>
                            </select>
                        </td>
                    </tr>

                    <tr>
                        <td class="td_left"><label class="zhuanye">请选择专业</label></td>
                        <td class="td_right">
                            <select class="subject" name="specialize_course">
                                <option  value="计算机科学与技术">计算机科学与技术</option>
                                <option  value="软件工程">软件工程</option>
                                <option  value="网络工程">网络工程</option>
                            </select>
                        </td>
                    </tr>

                    <tr>
                        <td class="td_left"><label for="checkcode">验证码</label></td>
                        <td class="td_right"><input type="text" name="checkcode" id="checkcode" placeholder="请输入验证码">
                        <td class="yan"><img id="verificationCode" src="/test04/VerificationCode"></td>
                        <td class="yan2"><a id="change" class="view" href="" style="color: blue">看不清？换一张</a></td>
                        </td>
                    </tr>

                    <tr>
                        <td colspan="2"  id="td_sub"><input type="submit" id="btn_sub" value="登入"></td>
                    </tr>
                </table>

            </form>

        </div>

    </div>

    <div class="rg_right">
        <p>没有账号?&nbsp&nbsp&nbsp<a href="#">现在注册</a></p>
    </div>

</div>

</body>

</html>