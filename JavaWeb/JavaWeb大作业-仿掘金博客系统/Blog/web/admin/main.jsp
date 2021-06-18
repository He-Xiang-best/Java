<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="public/headercss.jsp"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/font-awesome/css/font-awesome.css">
  <title></title>
</head>
<body class="layui-layout-body">
  
  <div id="LAY_app">
    <div class="layui-layout layui-layout-admin">
      <div class="layui-header">
        <!-- 头部区域 -->
        <ul class="layui-nav layui-layout-left">
          <li class="layui-nav-item layadmin-flexible" lay-unselect>
            <a href="javascript:;" layadmin-event="flexible" title="侧边伸缩">
              <i class="layui-icon layui-icon-shrink-right" id="LAY_app_flexible"></i>
            </a>
          </li>
          <li class="layui-nav-item" lay-unselect>
            <a href="javascript:;" layadmin-event="refresh" title="刷新">
              <i class="layui-icon layui-icon-refresh-3"></i>
            </a>
          </li>
          <li class="layui-nav-item layui-hide-xs" lay-unselect>
            <input type="text" placeholder="搜索..." autocomplete="off" class="layui-input layui-input-search"
                   layadmin-event="search" id="searchInfo">
          </li>
          <li class="layui-nav-item" lay-unselect style="margin-left: -20px;">
            <button class="javaex-btn yellow" id="search_btn"
                    value=""><span id="btn_name" class="icon-zoom-in">搜索</span></button>
          </li>
        </ul>
        <ul class="layui-nav layui-layout-right" lay-filter="layadmin-layout-right">
          <li class="layui-nav-item layui-hide-xs" lay-unselect>
            <a href="javascript:;" layadmin-event="theme">
              <i class="layui-icon layui-icon-theme"></i>
            </a>
          </li>
          <li class="layui-nav-item layui-hide-xs" lay-unselect>
            <a href="javascript:;" layadmin-event="note">
              <i class="layui-icon layui-icon-note"></i>
            </a>
          </li>
          <li class="layui-nav-item layui-hide-xs" lay-unselect>
            <a href="javascript:;" layadmin-event="fullscreen">
              <i class="layui-icon layui-icon-screen-full"></i>
            </a>
          </li>
          <li class="layui-nav-item" lay-unselect>
            <a href="javascript:;">
            <img src="${pageContext.request.contextPath }/${sessionScope.userInfo.avatarPath}" class="layui-nav-img"
                 style="margin-top: 10px;" alt="">
              <cite>${sessionScope.userInfo.userName}</cite>
            </a>
            <dl class="layui-nav-child">
              <dd><a lay-href="${pageContext.request.contextPath }/admin/user">基本资料</a></dd>
              <dd><a lay-href="${pageContext.request.contextPath }/admin/password">修改密码</a></dd>
              <hr>
              <dd><a href="${pageContext.request.contextPath }/admin/logout">退出</a></dd>
            </dl>
          </li>
          
          <li class="layui-nav-item layui-hide-xs" lay-unselect>
            <a href="${pageContext.request.contextPath }/page/1" ><i class="layui-icon layui-icon-more-vertical"></i>
              博客主页</a>
          </li>

        </ul>
      </div>
      
      <!-- 侧边菜单 -->
      <div class="layui-side layui-side-menu">
        <div class="layui-side-scroll">
          <div class="layui-logo" lay-href="console.jsp">
            <span style="font-weight: bold;margin-right: 30px;color: wheat;">后台管理系统</span>
          </div>
          
          <ul class="layui-nav layui-nav-tree" lay-shrink="all" id="LAY-system-side-menu" lay-filter="layadmin-system-side-menu">
            <li data-name="home" class="layui-nav-item layui-nav-itemed">
              <a lay-href="${pageContext.request.contextPath }/admin/console" lay-tips="主页" lay-direction="2">
                <i class="layui-icon layui-icon-home"></i>
               <cite>主页</cite>
              </a>
            </li>
            <li data-name="component" class="layui-nav-item">
              <a href="javascript:;" lay-tips="文章" lay-direction="2">
                <i class="layui-icon layui-icon-file-b"></i>
                <cite>文章</cite>
              </a>
              <dl class="layui-nav-child">
                <dd data-name="carousel"> 
                  <a lay-href="${pageContext.request.contextPath }/admin/articles/1" id="all_article" >
                   <i class="layui-icon layui-icon-list"></i>
                  所有文章</a>  
                </dd>
                <dd data-name="flow"> 
                  <a lay-href="${pageContext.request.contextPath }/admin/jump_write">
                   <i class="layui-icon layui-icon-survey"></i>
                  写文章</a>  
                </dd>
                <dd data-name="util"> 
                  <a lay-href="${pageContext.request.contextPath }/admin/jump_category" id="article_type">
                   <i class="layui-icon layui-icon-template-1"></i>
                  分类目录</a>  
                </dd>
                <dd data-name="code"> 
                  <a lay-href="${pageContext.request.contextPath }/admin/jump_tag" id="ar_tag">
                  <i class="layui-icon layui-icon-note"></i>
                  标签</a> 
                </dd>
                <dd data-name="code">
                  <a lay-href="${pageContext.request.contextPath }/admin/like_ar/1" id="like_ar">
                  <i class="layui-icon layui-icon-praise"></i>
                  点赞文章</a>
                </dd>
                <dd data-name="code">
                  <a lay-href="${pageContext.request.contextPath }/admin/star_ar/1" id="star_ar">
                  <i class="layui-icon layui-icon-rate-solid"></i>
                  收藏文章</a>
                </dd>
              </dl>
            </li>
              <li data-name="component" class="layui-nav-item">
              <a href="javascript:;" lay-tips="评论" lay-direction="2">
                <i class="layui-icon layui-icon-reply-fill"></i>
               <cite>评论</cite>
              </a>
                            <dl class="layui-nav-child">
                <dd data-name="carousel"> 
                  <a lay-href="${pageContext.request.contextPath }/admin/comment">
                   <i class="layui-icon layui-icon-menu-fill"></i>
                 用户评论</a>  
                </dd>
                <dd data-name="flow"> 
                  <a lay-href="${pageContext.request.contextPath }/admin/my_comment">
                   <i class="layui-icon layui-icon-friends"></i>
                  我的回复</a>  
                </dd>

              </dl>
            </li>
<%--            <li data-name="app" class="layui-nav-item">--%>
<%--              <a lay-href="${pageContext.request.contextPath }/admin/page_setup" lay-tips="应用" lay-direction="2">--%>
<%--                <i class="layui-icon layui-icon-layer"></i>--%>
<%--                <cite>页面</cite>--%>
<%--              </a>--%>
<%--            </li>--%>
            <c:if test="${sessionScope.userType==0}">
                        <li data-name="app" class="layui-nav-item">
                          <a lay-href="${pageContext.request.contextPath }/admin/report_ar/1" lay-tips="应用"
                             lay-direction="2">
                            <i class="layui-icon layui-icon-survey"></i>
                            <cite>审核</cite>
                          </a>
                        </li>
            </c:if>
            <li data-name="user" class="layui-nav-item">
              <a href="javascript:;" lay-tips="用户" lay-direction="2">
                <i class="layui-icon layui-icon-user"></i>
                <cite>用户</cite>
              </a>
              <dl class="layui-nav-child">
                <c:if test="${sessionScope.userType==0}">
                  <dd>
                    <a lay-href="${pageContext.request.contextPath }/admin/manage" id="user_manage">
                      <i class="layui-icon layui-icon-group"></i>
                      用户管理
                    </a>
                  </dd>
                </c:if>
                <dd>
                  <a lay-href="${pageContext.request.contextPath }/admin/user">
                   <i class="layui-icon layui-icon-form"></i>
                  个人资料
                  </a>
                </dd>
                <dd>
                  <a lay-href="${pageContext.request.contextPath }/admin/password">
                    <i class="layui-icon layui-icon-util"></i>
                  修改密码</a>
                </dd>
              </dl>
            </li>
                  <li data-name="app" class="layui-nav-item">
              <a lay-href="${pageContext.request.contextPath }/admin/logs/1" lay-tips="应用" lay-direction="2">
                <i class="layui-icon layui-icon-notice"></i>
                <cite>日志</cite>
              </a>
            </li>
            <li data-name="app" class="layui-nav-item">
              <a lay-href="${pageContext.request.contextPath }/admin/vistor/1" lay-tips="应用" lay-direction="2">
                <i class="layui-icon layui-icon-log"></i>
                <cite>访问</cite>
              </a>
            </li>	
          </ul>
        </div>
      </div>

      <!-- 页面标签 -->
      <div class="layadmin-pagetabs" id="LAY_app_tabs">
        <div class="layui-icon layadmin-tabs-control layui-icon-prev" layadmin-event="leftPage"></div>
        <div class="layui-icon layadmin-tabs-control layui-icon-next" layadmin-event="rightPage"></div>
        <div class="layui-icon layadmin-tabs-control layui-icon-down">
          <ul class="layui-nav layadmin-tabs-select" lay-filter="layadmin-pagetabs-nav">
            <li class="layui-nav-item" lay-unselect>
              <a href="javascript:;"></a>
              <dl class="layui-nav-child layui-anim-fadein">
                <dd layadmin-event="closeThisTabs"><a href="javascript:;">关闭当前标签页</a></dd>
                <dd layadmin-event="closeOtherTabs"><a href="javascript:;">关闭其它标签页</a></dd>
                <dd layadmin-event="closeAllTabs"><a href="javascript:;">关闭全部标签页</a></dd>
              </dl>
            </li>
          </ul>
        </div>
        <div class="layui-tab" lay-unauto lay-allowClose="true" lay-filter="layadmin-layout-tabs">
          <ul class="layui-tab-title" id="LAY_app_tabsheader">
            <li lay-id="console.jsp" lay-attr="console.jsp" class="layui-this"><i class="layui-icon layui-icon-home"></i></li>
          </ul>
        </div>
      </div>
      
      
      <!-- 主体内容 -->
      <div class="layui-body" id="LAY_app_body">
        <div class="layadmin-tabsbody-item layui-show">
          <iframe src="console.jsp" frameborder="0" class="layadmin-iframe"></iframe>
        </div>
      </div>
      
      <!-- 辅助元素，一般用于移动设备下遮罩 -->
      <div class="layadmin-body-shade" layadmin-event="shade"></div>
    </div>
  </div>

  <script src="../static/layuiadmin/layui/layui.js"></script>
  <script>
  layui.config({
    base: '../static/layuiadmin/' //静态资源所在路径
  }).extend({
    index: 'lib/index' //主入口模块
  }).use('index');



  $('#all_article').click(function () {
    $(this).attr("lay-href","${pageContext.request.contextPath }/admin/articles/1")
    $('#search_btn').attr("value","article");
    document.getElementById("btn_name").innerHTML = "搜索文章";
  });
  $('#article_type').click(function () {
    $(this).attr("lay-href","${pageContext.request.contextPath }/admin/jump_category")
    $('#search_btn').attr("value","article_type");
    document.getElementById("btn_name").innerHTML = "搜索分类";
  });

  $('#ar_tag').click(function () {
    $(this).attr("lay-href","${pageContext.request.contextPath }/admin/jump_tag")
    $('#search_btn').attr("value","ar_tag");
    document.getElementById("btn_name").innerHTML = "搜索标签";
  });

  $('#user_manage').click(function () {
    $(this).attr("lay-href","${pageContext.request.contextPath }/admin/manage")
    $('#search_btn').attr("value","user_manage");
    document.getElementById("btn_name").innerHTML = "搜索用户";
  });

  $("#search_btn").click(function () {
    var value = $(this).val();
    var searchKey = $("#searchInfo").val();
    console.log("searchKey = "+searchKey);
    if(searchKey===''){
      javaex.tip({
        mode : "message",
        content : "请填写搜索内容！",
        type : "error"
      });
    }
    else if(value==='article'){
      $(this).attr("lay-href","${pageContext.request.contextPath }/admin/search_articles/1/"+searchKey)
    }else if(value==='article_type'){
      $(this).attr("lay-href","${pageContext.request.contextPath }/admin/searchCategory/"+searchKey)
    }else if(value==='ar_tag') {
      $(this).attr("lay-href","${pageContext.request.contextPath }/admin/searchTag/"+searchKey)
    }
    else if(value==='user_manage') {
      $(this).attr("lay-href","${pageContext.request.contextPath }/admin/searchUser/"+searchKey)
    }
      else {
        console.log("searchInfo = "+searchKey);
        window.location.href ="${pageContext.request.contextPath }/admin/search?q="+searchKey;
    }
  })



  </script>
</body>
</html>


