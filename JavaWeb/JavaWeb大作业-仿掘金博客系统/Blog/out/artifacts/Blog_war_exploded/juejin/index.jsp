<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>掘金</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/JueJin/css/base.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/JueJin/css/index.css">
    <script src="${pageContext.request.contextPath}/static/JueJin/js/jquery-3.4.1.min.js"></script>
    <link rel="stylesheet" href="https://cdn.staticfile.org/font-awesome/5.12.1/css/all.min.css">
    <c:import url="common/head.jsp"/>

</head>
<body>
<c:import url="common/header.jsp"/>

<main class="container">
    <nav class="main-list">
        <ul class="container">
            <li class="active main-list-item"><a href="#">推荐</a></li>
            <li class="main-list-item"><a href="#">后端</a><c:import url="common/category-pop.jsp"/></li>
            <li class="main-list-item"><a href="#">前端</a><c:import url="common/category-pop.jsp"/></li>
            <li class="main-list-item"><a href="#">Android</a><c:import url="common/category-pop.jsp"/></li>
            <li class="main-list-item"><a href="#">IOS</a><c:import url="common/category-pop.jsp"/></li>
            <li class="main-list-item"><a href="#">人工智能</a><c:import url="common/category-pop.jsp"/></li>
            <li class="main-list-item"><a href="#">开发工具</a><c:import url="common/category-pop.jsp"/></li>
            <li class="main-list-item"><a href="#">代码人生</a><c:import url="common/category-pop.jsp"/></li>
            <li class="main-list-item"><a href="#">阅读</a><c:import url="common/category-pop.jsp"/></li>
        </ul>
    </nav>

    <div class="view">

        <div class="left">
            <nav class="left-nav">
                <ul class="nav-list" style="margin-top: 50px;">
                    <li class="nav-item active">
                        <a href="#">热门</a>
                    </li>
                    <li class="nav-item">
                        <a href="#">最新</a>
                    </li>
                    <li class="nav-item">
                        <a href="#">热榜</a>
                    </li>
                </ul>
            </nav>

            <ul class="article-list">
                <c:forEach items="${articles}" var="a">

                <li class="article-item">
                    <a href="#" class="content-info">
                        <div class="cl" style="width: 580px;">
                            <div class="meta-row">
                                <ul class="meta-list">
                    <c:forEach items="${a.categoryList }" var="c">
                        <c:if test="${c.categoryPid eq 0}">
                            <strong></c:if>
                        <li class="meta-item post">
                            <a href="${pageContext.request.contextPath }/category/archives/${c.categoryId}">${c.categoryName }</a></li></strong>
                    </c:forEach>
                     <span>&nbsp;|&nbsp;</span>
                    <c:forEach items="${a. tagList}" var="t">
                        <li class="meta-item">
                            <a  href="${pageContext.request.contextPath }/tag/archives/${t.tagId}">${t.tagName }</a></li>
                    </c:forEach>

                                    <li class="meta-item"><fmt:formatDate pattern="yyyy-MM-dd"  value="${a.articleCreateTime }" /></li>

                                </ul>
                            </div>
                            <div class="title-row">
                                <a href="${pageContext.request.contextPath}/${a.articleId}">
                                       ${a.articleTitle }
                                </a>
                            </div>
                            <div class="action-row">
                                <ul class="action-list">
                                    <li class="action-item">
                                        <a href="#">
                                            <img class="action-img"
                                                 src="${pageContext.request.contextPath}/static/JueJin/imgs/访问量.png"
                                                 alt="">
                                            <span class="count">${a.articleViewCount}</span>
                                        </a>
                                    </li>
                                    <li class="action-item">
                                        <a href="#">
                                            <img class="action-img"
                                                 src="${pageContext.request.contextPath}/static/JueJin/imgs/评论-.png"
                                                 alt="">
                                            <span class="count">${a.articleCommentCount}</span>
                                        </a>
                                    </li>
                                    <li class="action-item share">
                                        <a href="#">
                                            <img class="action-img"
                                                 src="${pageContext.request.contextPath}/static/JueJin/imgs/share.1d55e69.svg"
                                                 alt="">
                                        </a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <div class="img"><img
                                src="${pageContext.request.contextPath}/${a.articleImagePath}"
                                alt=""></div>
                    </a>
                </li>

                </c:forEach>
            </ul>
            <jsp:include page="../home/public/paging.jsp"/>
        </div>

        <div class="right newRight">

            <div class="hot-tag">
                <div class="tag-head" style="margin-top: 50px;">
                    <div class="title">热门标签</div>
                    <div class="more">
                        <a href="${pageContext.request.contextPath }/tags">查看全部</a>
                    </div>
                </div>
                <div class="tag-body">
                    <a href="#">架构</a>
                    <a href="#">开源</a>
                    <a href="#">算法</a>
                    <a href="#">Github</a>
                    <a href="#">面试</a>
                    <a href="#">代码规范</a>
                    <a href="#">产品</a>
                    <a href="#">掘金翻译计划</a>
                </div>
            </div>
            <div class="down-app">
                <img src="${pageContext.request.contextPath}/static/JueJin/imgs/welcome.6f27533.png" alt="">
                <div class="content">
                    <div class="download">下载掘金客户端</div>
                    <div class="desc">一个帮助开发者成长的社区</div>
                </div>
            </div>
            <div class="links">
                <ul class="links-list">
                    <li class="links-item">
                        <a href="#">
                            <img src="${pageContext.request.contextPath}/static/JueJin/imgs/收藏.png" alt="">
                            <span>收藏集</span>
                        </a>
                    </li>
                    <li class="links-item">
                        <a href="#">
                            <img src="${pageContext.request.contextPath}/static/JueJin/imgs/book.75582b2.png" alt="">
                            <span>掘金社区漫游指南</span>
                        </a>
                    </li>
                    <li class="links-item">
                        <a href="#">
                            <img src="${pageContext.request.contextPath}/static/JueJin/imgs/谷歌%20google.png"
                                 alt="">
                            <span>下载掘金浏览器插件</span>
                        </a>
                    </li>
                    <li class="links-item">
                        <a href="#">
                            <img src="${pageContext.request.contextPath}/static/JueJin/imgs/juejin-miner.b78347c.png" alt="">
                            <span>前往掘金翻译计划</span>
                        </a>
                    </li>
                    <li class="links-item">
                        <a href="#">
                            <img src="${pageContext.request.contextPath}/static/JueJin/imgs/juejin-partner.4dd2d8c.png" alt="">
                            <span>商务合作</span>
                        </a>
                    </li>
                </ul>
            </div>
            <div class="foot">
                <div class="us">关注我们</div>
                <ul class="foot-icons">
                    <li class="foot-item">
                        <img src="${pageContext.request.contextPath}/static/JueJin/imgs/weibo.0cd39f5.png" alt="">
                    </li>
                    <li class="foot-item">
                        <img src="${pageContext.request.contextPath}/static/JueJin/imgs/weibo.0cd39f5.png" alt="">
                    </li>
                    <li class="foot-item">
                        <img src="${pageContext.request.contextPath}/static/JueJin/imgs/weibo.0cd39f5.png" alt="">
                    </li>
                    <li class="foot-item">
                        <img src="${pageContext.request.contextPath}/static/JueJin/imgs/weibo.0cd39f5.png" alt="">
                    </li>
                </ul>
                <div class="lj">
                    <ul class="lj-list">
                        <li class="item">关于</li>
                        <li class="item">招牌</li>
                        <li class="item">商务合作</li>
                        <li class="item">友情链接</li>
                    </ul>
                    <ul class="lj-list">
                        <li class="item">用户协议</li>
                        <li class="item">隐私政策</li>
                    </ul>
                    <div>©2021 掘金</div>
                    <a href="#">Powered by 何翔</a><br>
                    <a href="#">津ICP备15003202号-2</a><br>
                    <a href="#">京公网安备11010802026719号</a>
                </div>
            </div>
        </div>
    </div>
</main>

<c:import url="common/fixed-btn.jsp"/>
<c:import url="common/headjs.jsp"/>
<script src="${pageContext.request.contextPath}/static/JueJin/js/index.js"></script>
<script src="${pageContext.request.contextPath}/static/JueJin/js/public.js"></script>
</body>


</html>
