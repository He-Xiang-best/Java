<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>纳税页面</title>

    <link rel="stylesheet" type="text/css" href="/test06/static/css/index.css">
    <script type="text/javascript" src="/test06/static/script/index.js"></script>

</head>
<body>
<div class="header">

</div>
<div class="rg_layout">
    <div class="rg_left">
        <p>纳税税收计算</p>
        <p>TAX REVENUE</p>

    </div>

    <div class="rg_center">
        <div class="rg_form">
            <!--定义表单 form-->
            <form action="${pageContext.request.contextPath}/taxServlet" id="form"  method="post">
                <input type="hidden" name="action" value="tax" />
                <table>
                    <tr>
                        <td class="td_left"><label for="username">输入你的月收入</label></td>
                        <td class="td_right">
                            <input type="text" name="money" id="username" placeholder="请输入你的月收入："
                                   value="${requestScope.taxMoney.money}">
                            <span id="s_username" class="error"></span>
                        </td>
                    </tr>


                    <tr>
                        <td colspan="2"  id="td_sub"><input type="submit" id="btn_sub" value="计算"></td>
                    </tr>

                    <tr>
                        <td class="td_left"><label for="password">计算所得纳税税收为</label></td>
                        <td class="td_right">
                            <input type="text" name="dr" id="password"
                                   value="${requestScope.taxMoney.dr}">
                        </td>
                    </tr>

                </table>

            </form>

        </div>

    </div>

</div>

</body>

</html>