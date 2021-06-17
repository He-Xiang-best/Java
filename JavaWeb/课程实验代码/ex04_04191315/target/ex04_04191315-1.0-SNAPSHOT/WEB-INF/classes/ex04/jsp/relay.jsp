<%@ page import="java.io.IOException" %>
<%@ page import="ex04.Student" %><%--
  Created by IntelliJ IDEA.
  User: 17283
  Date: 2021/3/25
  Time: 1:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--<%--%>

<%--    class Relay extends HttpServlet {--%>


<%--        public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {--%>
<%--            Student stu = (Student) request.getAttribute("stu");--%>

<%--        }--%>

<%--        @Override--%>
<%--        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {--%>
<%--            doGet(req, resp);--%>
<%--        }--%>
<%--    }--%>
<%--%>--%>
<%
    Student stu = (Student) request.getAttribute("stu");
    System.out.println(stu);
%>


<html>
<head>
    <meta charset="UTF-8">
    <title>登入成功页面</title>

    <link rel="stylesheet" type="text/css" href="../../../webapp/css/login.css">

</head>
<body>
<div class="header"></div>

<div class="rg_layout">

    <div class="rg_left">
        <p>用户状态</p>
        <p>USER STATUS</p>
    </div>

    <div class="rg_center">
        <div class="rg_form">
            <h1>Welcome！ 登入成功！</h1>

            <!--定义表单 form-->
            <form action="/test04/login" id="form"  method="get">
                <table>
                    <tr>
                        <td class="td_left"><label >学号:</label></td>
                        <td class="td_right">
                            <label>
                                <%
                                out.print(stu.getS_id());
                                %>

                            </label>
                        </td>

                    </tr>

                    <tr>
                        <td class="td_left"><label >姓名:</label></td>
                        <td class="td_right">
                            <label>
                                <%
                                    out.print(stu.getS_name());
                                %>

                            </label>
                        </td>
                    </tr>

                    <tr>
                        <td class="td_left"><label >学院:</label></td>
                        <td class="td_right">
                            <label>
                                <%
                                    out.print(stu.getAcademy());
                                %>

                            </label>
                        </td>
                    </tr>

                    <tr>
                        <td class="td_left"><label>专业:</label></td>
                        <td class="td_right">
                            <label>
                                <%
                                    out.print(stu.getSpecialize_course());
                                %>

                            </label>
                        </td>
                    </tr>

                    <tr>
                        <td colspan="2"  id="td_sub"><input type="submit" id="btn_sub" value="返回主页"></td>
                    </tr>
                </table>

            </form>

        </div>

    </div>


</div>

</body>

</html>