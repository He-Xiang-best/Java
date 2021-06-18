<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <jsp:include page="public/headercss.jsp"/>
    <title></title>
</head>
<body>

<!--    列表 -->
  <div class="layui-fluid">
    <div class="layui-row layui-col-space15">
               <fieldset class="layui-elem-field layui-field-title">
              <legend>已点赞文章</legend>
            </fieldset>
    <div class="layui-tab layui-tab-card">
        <form id="articleForm" method="post">
            <input type="hidden" name="currentUrl" id="currentUrl" value="">
            <table class="layui-table">
                <colgroup>
                    <col width="300">
                    <col width="120">
                    <col width="120">
                    <col width="5">
                    <col width="5">
                    <col width="20">
                    <col width="100">
                    <col width="25">
                </colgroup>
                <thead>
                <tr>
                    <th>标题</th>
                    <th>所属分类</th>
                    <th>标签</th>
                    <th>点击量</th>
                    <th>评论数</th>
                    <th>发布类型</th>
                    <th>发布时间</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${sessionScope.likeAr}" var="a">
                    <tr>
                        <td>
                            <a href="${pageContext.request.contextPath }/${a.articleId}" target="_blank">
                                ${a.articleTitle }
                            </a>
                            </td>
                        <td>
                            <c:forEach items="${a.categoryList}" var="c">
                                <a href="${pageContext.request.contextPath }/category/archives/${c.categoryId}"
                                   target="_blank">${c.categoryName}</a>
                                &nbsp;
                            </c:forEach>
                         <td>
                            <c:forEach items="${a.tagList}" var="t">
                                <a href="${pageContext.request.contextPath }/tag/archives/${t.tagId}"
                                   target="_blank">${t.tagName}</a>
                                &nbsp;
                            </c:forEach>
                        </td>
                        <td align="center">
                                  <span class="layui-badge layui-bg-cyan">${a.articleViewCount}</span>
                        </td>
                        <td align="center">
                         <span class="layui-badge">${a.articleCommentCount}</span>
                        </td>
                        
                       <td align="center">
                       <c:choose>
                       <c:when test="${a.issueType eq 1}">
                         <span class="layui-badge layui-bg-green">正文</span>
                         </c:when>
                         <c:otherwise>
                         <span class="layui-badge layui-bg-cyan">草稿</span>
                         </c:otherwise>
                         </c:choose>
                        </td>
                        
                        <td>
                            <fmt:formatDate value="${a.articleCreateTime}"
                                            pattern="yyyy-MM-dd HH:mm:ss"/>
                        </td>
                        <td align="center">
<%--                            <a  lay-href="${pageContext.request.contextPath }/admin/jump_editor_article?aid=${a.articleId}"--%>
<%--                               class="layui-btn layui-btn-mini">编辑</a>--%>
                            <button type="button" class="layui-btn layui-btn-danger layui-btn-mini" id="del"
<%--                                    onclick="funDelete()"--%>
                                    style="margin-right: 10px;" data-type="remove" data-index="${a.articleId }"
                                    onclick="delFun(${a.articleId })">取消点赞
                            </button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
<%--            <jsp:include page="public/paging.jsp"/>--%>

            <div class="layui-card-body"  align="center">
                <div id="test-laypage-demo1">
                    <div class="layui-box layui-laypage layui-laypage-default" id="layui-laypage-2">
                        <c:choose >
                            <c:when test="${sessionScope.nowpage>1}">
                                <a href="${pageContext.request.contextPath }/admin/${sessionScope.type}/1">首页</a>
                                <a href="${pageContext.request.contextPath }/admin/${sessionScope.type}/${sessionScope.nowpage-1}">上一页</a>
                                <a class="page-number" href="${pageContext.request.contextPath }/admin/${sessionScope.type}/1">1</a>
                            </c:when>
                            <c:otherwise>
                                <a class="layui-laypage-prev layui-disabled">首页</a>
                                <a  class="layui-laypage-prev layui-disabled">上一页</a>
                            </c:otherwise>
                        </c:choose>
                        <c:if test="${sessionScope.nowpage>3 }">
                            <span class="space">…</span>
                        </c:if>
                        <c:if test="${sessionScope.nowpage>2 }">
                            <a class="page-number" href="${pageContext.request.contextPath }/admin/${sessionScope.type}/${sessionScope.nowpage-1}" class="layui-laypage-em">${sessionScope.nowpage-1 }</a>
                        </c:if>
                        <span class="layui-laypage-curr" style="background-color:#009688;"><em>${sessionScope.nowpage }</em></span>
                        <c:if test="${sessionScope.nowpage<sessionScope.totalpage-1 }">
                            <a class="page-number" href="${pageContext.request.contextPath }/admin/${sessionScope.type}/${sessionScope.nowpage+1}" class="layui-laypage-em">${sessionScope.nowpage+1 }</a>
                        </c:if>
                        <c:if test="${sessionScope.nowpage<sessionScope.totalpage-2 }"><span class="space">…</span></c:if>
                        <c:choose >
                            <c:when test="${sessionScope.nowpage<sessionScope.totalpage }">
                                <a class="page-number" href="${pageContext.request.contextPath }/admin/${sessionScope.type}/${sessionScope.totalpage }">${sessionScope.totalpage}</a>
                                <a  href="${pageContext.request.contextPath }/admin/${sessionScope.type}/${sessionScope.nowpage+1}">下一页</a>
                                <a href="${pageContext.request.contextPath }/admin/${sessionScope.type}/${sessionScope.totalpage }" >尾页</a>
                            </c:when>
                            <c:otherwise>
                                <a  class="layui-laypage-prev layui-disabled">下一页</a>
                                <a   class="layui-laypage-prev layui-disabled">尾页</a>
                            </c:otherwise>
                        </c:choose>

                    </div>
                </div>
            </div>


        </form>
    </div>
  
    

      </div>
    </div>	


<jsp:include page="public/headerjs.jsp"/>

<script>

    <%--$("[id=del]").on("click",function(){--%>
    <%--    var aid=$(this).attr('data-index');--%>
    <%--    console.log(aid);--%>
    <%--    layer.confirm('确定要取消点赞么？', {--%>
    <%--        btn: ['确认','取消'] //按钮--%>
    <%--    }, function(){--%>
    <%--        $.post('${pageContext.request.contextPath}/admin/delete_article',--%>
    <%--            {--%>
    <%--            aid:aid--%>
    <%--            },function(d){--%>
    <%--                if(d.success===true)--%>
    <%--                {--%>
    <%--                    layer.alert(d.msg,{icon:1},function(){--%>
    <%--                        window.location.reload();--%>
    <%--                    });--%>

    <%--                }else{--%>
    <%--                    layer.msg(d.msg,{icon:5});--%>
    <%--                }--%>
    <%--            },'json');--%>
    <%--    });--%>
    <%--});--%>



    function delFun(ar_id) {
        console.log(ar_id);
        javaex.confirm({
            content : "确定要取消点赞么",
            confirm : function() {
                console.log("点击了确定按钮");
                $.ajax({
                    type:"post",
                    url:'${pageContext.request.contextPath}/admin/cancel_like_ar',
                    data:{ar_id:ar_id},
                    success:function (res){
                        if(res["type"]==='success'){
                            javaex.tip({
                                content : res["msg"],
                                type : "success"
                            });
                            // 建议延迟加载
                            setTimeout(function() {
                                // 刷新页面
                                window.location.reload();
                            }, 1000);
                        }else {
                            javaex.tip({
                                content : res["msg"],
                                type : "error"
                            });
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
