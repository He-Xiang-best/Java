<%--
  Created by IntelliJ IDEA.
  User: 17283
  Date: 2021/6/10
  Time: 10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="${pageContext.request.contextPath}/static/js/anime.min.js"></script>
<script src="${pageContext.request.contextPath}/static/jquery/jquery.js"></script>
<script src="${pageContext.request.contextPath}/static/js/jquery.fancybox.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/velocity.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/velocity.ui.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/utils.js"></script>
<script src="${pageContext.request.contextPath}/static/js/fancybox.js"></script>
<script src="${pageContext.request.contextPath}/static/js/sidebar.js"></script>
<script src="${pageContext.request.contextPath}/static/js/fireworks.js"></script>
<script src="${pageContext.request.contextPath}/static/js/transition.js"></script>
<script src="${pageContext.request.contextPath}/static/js/scroll.js"></script>
<script src="${pageContext.request.contextPath}/static/js/nightshift.js"></script>
<script src="${pageContext.request.contextPath}/static/js/head.js"></script>
<script src="${pageContext.request.contextPath}/static/js/local-search.js"></script>
<script async="" src="${pageContext.request.contextPath}/static/js/busuanzi.pure.mini.js"></script>
<%--    <script src="${pageContext.request.contextPath}/static/js/instantsearch.min.js" defer=""></script> --%>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery.flexText.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/layer/layer.js"></script>
<script type="text/javascript">

    function overFn(obj){//鼠标在上面
        $(obj).css("background","#F0F8FF");
    }
    function outFn(obj){//鼠标离开
        $(obj).css("background","white");
    }
    function clickFn(obj){//鼠标点击
        $("#display").val($(obj).html());
    }
</script>