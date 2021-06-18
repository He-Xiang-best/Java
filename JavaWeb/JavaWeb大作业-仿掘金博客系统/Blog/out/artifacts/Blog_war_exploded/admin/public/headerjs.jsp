<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
  <script src="${pageContext.request.contextPath}/static/editor/js/jquery.min.js"></script>
  <script src="${pageContext.request.contextPath}/static/layuiadmin/layui/layui.js"></script>
  <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.0/jquery.js"></script>
<script>
  layui.config({
    base: '${pageContext.request.contextPath}/static/layuiadmin/' //静态资源所在路径
  }).extend({
    index: 'lib/index' //主入口模块
  }).use(['index', 'useradmin', 'table'], function(){
    var $ = layui.$
    ,form = layui.form
    ,table = layui.table;
  });
  </script>
