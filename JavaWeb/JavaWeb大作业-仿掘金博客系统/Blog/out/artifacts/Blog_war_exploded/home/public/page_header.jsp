<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!--字体图标-->
<link href="${pageContext.request.contextPath}/static/javaex/pc/css/icomoon.css" rel="stylesheet" />
<!--动画-->
<link href="${pageContext.request.contextPath}/static/javaex/pc/css/animate.css" rel="stylesheet" />
<!--骨架样式-->
<link href="${pageContext.request.contextPath}/static/javaex/pc/css/common.css" rel="stylesheet" />
<!--皮肤-->
<link href="${pageContext.request.contextPath}/static/javaex/pc/css/skin/default.css" rel="stylesheet" />
<!--jquery，不可修改版本-->
<script src="${pageContext.request.contextPath}/static/javaex/pc/lib/jquery-1.7.2.min.js"></script>
<!--核心组件-->
<script src="${pageContext.request.contextPath}/static/javaex/pc/js/javaex.min.js"></script>
<!--表单验证-->
<script src="${pageContext.request.contextPath}/static/javaex/pc/js/javaex-formVerify.js"></script>

   <div id="page-header">
    <span class="pull-left"><strong></h2><a href="${pageContext.request.contextPath }/page/1">${inform.pageNickname }のBlog</a></strong></span>
    <i class="fa fa-bars toggle-menu pull-right" aria-hidden="true"></i>
    <span class="pull-right menus">
<!-- 	<input type="search" class="site-page social-icon search"  placeholder="搜索"> -->

    <a class="site-page social-icon search" ><i class="fa fa-search"></i><span> 搜索</span></a>
    <a class="site-page" href="${pageContext.request.contextPath }/page/1"><i class="menu-item-icon fa fa-fw fa-home"></i>首页</a>
    <a class="site-page" href="${pageContext.request.contextPath }/archives"><i class="menu-item-icon fa fa-fw fa-archive"></i>归档</a>
    <a class="site-page" href="${pageContext.request.contextPath }/tags"><i class="menu-item-icon fa fa-fw fa-tags"></i>标签</a>
    <a class="site-page" href="${pageContext.request.contextPath }/categories"><i class="menu-item-icon fa fa-fw fa-th"></i>分类</a>
    <a class="site-page" href="${pageContext.request.contextPath }/about">   <i class="menu-item-icon fa fa-fw fa-user fa-fw"></i>关于</a>
    <a class="site-page" href="#" id="step_in">
        <i class="menu-item-icon fa fa-fw fa-user fa-fw"></i>进入后台</a></span>
   </div>

<script>
$('#step_in').click(function () {

    <c:choose>
    <c:when test="${empty sessionScope.userInfo}">
    javaex.tip({
        mode : "message",
        content : "请先登入！",
        type : "error"
    });
    setTimeout(function() {
        window.location.href = "${pageContext.request.contextPath}/index.jsp";
    }, 1000);
    </c:when>
    <c:otherwise>
    window.location.href = "${pageContext.request.contextPath }/login";
    </c:otherwise>
    </c:choose>
})
</script>