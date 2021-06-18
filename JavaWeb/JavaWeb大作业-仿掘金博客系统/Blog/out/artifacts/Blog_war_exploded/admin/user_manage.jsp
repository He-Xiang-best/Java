<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>

<jsp:include page="public/headercss.jsp"/>
</head>
<body>

<!--    列表 -->
  <div class="layui-fluid">
    <div class="layui-row layui-col-space15">
               <fieldset class="layui-elem-field layui-field-title">
              <legend>所有用户</legend>
            </fieldset>
    <div class="layui-tab layui-tab-card">
        <form id="articleForm" method="post">
            <input type="hidden" name="currentUrl" id="currentUrl" value="">
            <table class="layui-table">
<%--                <colgroup>--%>
<%--                    <col width="100">--%>
<%--                    <col width="100">--%>
<%--                    <col width="200">--%>
<%--                    <col width="100">--%>
<%--                    <col width="20">--%>
<%--                </colgroup>--%>
                <thead>
                <tr>
                    <th style="text-align:center;">用户名</th>
                    <th style="text-align:center;">用户邮箱</th>
                    <th style="text-align:center;">用户类型</th>
                    <th style="text-align:center;">信息管理</th>
                    <th style="text-align:center;">权限管理</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${sessionScope.allUser}" var="user">
                    <tr>
                        <td align="center">
                            ${user.userName}
                            </td>
                         <td align="center">
                            ${user.userEmail }
                            </td>
                        <td align="center">
                            <c:if test="${sessionScope.userTypeMap.get(user.userId)==0}">
                                管理员
                            </c:if>
                            <c:if test="${sessionScope.userTypeMap.get(user.userId)==1}">
                                普通用户
                            </c:if>
                            <c:if test="${sessionScope.userTypeMap.get(user.userId)==2}">
                               封禁用户
                            </c:if>
                            </td>                                       
                        <td align="center">
                            <a lay-href="${pageContext.request.contextPath }/admin/user/${user.userId}">
                                <button type="button" class="layui-btn  layui-btn-mini">信息编辑</button>
                            </a>
                            <a lay-href="${pageContext.request.contextPath }/admin/password_manage/${user.userId}">
                                <button type="button" class="layui-btn  layui-btn-mini">修改密码</button>
                            </a>
                        </td>
                        <td align="center">
                            <c:if test="${sessionScope.userTypeMap.get(user.userId)==0}">
                                   <button type="button" class="layui-btn layui-btn-danger layui-btn-mini"
                                           onclick="powerFun(${user.userId},0)">解除管理员权限
                                   </button>

                                    <button type="button" class="layui-btn layui-btn-danger layui-btn-mini"
                                            onclick="powerFun(${user.userId},2)">封禁用户
                                    </button>
                            </c:if>
                            <c:if test="${sessionScope.userTypeMap.get(user.userId)==1}">
                                    <button type="button" class="layui-btn layui-btn-danger layui-btn-mini"
                                            onclick="powerFun(${user.userId},1)">添加管理员权限
                                    </button>
                                <button type="button" class="layui-btn layui-btn-danger layui-btn-mini"
                                        onclick="powerFun(${user.userId},2)">封禁用户
                                </button>
                            </c:if>
                            <c:if test="${sessionScope.userTypeMap.get(user.userId)==2}">
                                <button type="button" class="layui-btn layui-btn-danger layui-btn-mini"
                                        onclick="powerFun(${user.userId},3)">解禁用户
                                </button>
                            </c:if>
                            <button type="button" class="layui-btn layui-btn-danger layui-btn-mini"
                                 onclick="deleteUser(${user.userId})"   >删除用户</button>
                        </td>
                    </tr>
                </c:forEach>
	
                </tbody>

            </table>
               <jsp:include page="public/paging.jsp"/>
        </form>
    </div>
      </div>
    </div>	


<jsp:include page="public/headerjs.jsp"/>
<script>

function powerFun(userId,type) {
    console.log('${pageContext.request.contextPath }/admin/manage_power/'+userId+'/'+type);
    javaex.confirm({
        content : "确定要更改权限么",
        confirm : function() {
            console.log("点击了确定按钮");
            $.ajax({
                type:'post',
                url:'${pageContext.request.contextPath }/admin/manage_power/'+userId+'/'+type,
                success:function (res) {
                    if(res['type']==='success'){
                        javaex.tip({
                            content : res['msg'],
                            type : "success"
                        });
                        setTimeout(function() {
                            // 刷新页面
                             window.location.reload();
                        }, 500);
                    }else if(res['type']==='error'){
                        javaex.tip({
                            content : res['msg'],
                            type : "error"
                        });
                    }else {
                        javaex.tip({
                            content : res['msg'],
                            type : "success"
                        });
                        window.location.href='${pageContext.request.contextPath }/admin/logout'
                    }
                }
            })
            return false;
        }
    });
}

function deleteUser(userId) {
    javaex.confirm({
        content : "确定要删除用户么",
        confirm : function() {
            console.log("点击了确定按钮");
            console.log(userId);
            $.ajax({
                type:'post',
                url:'${pageContext.request.contextPath }/admin/deleteUser/'+userId,
                success:function (res) {
                    if(res['type']==='success'){
                        javaex.tip({
                            content : res['msg'],
                            type : "success"
                        });
                        setTimeout(function() {
                            // 刷新页面
                            window.location.reload();
                        }, 500);
                    }else if(res['type']==='error'){
                        javaex.tip({
                            content : res['msg'],
                            type : "error"
                        });
                    }else {
                        javaex.tip({
                            content : res['msg'],
                            type : "success"
                        });
                        window.location.href='${pageContext.request.contextPath }/admin/logout'
                    }
                }
            })
            return false;
        }
    });
}


  </script>
</body>
</html>
