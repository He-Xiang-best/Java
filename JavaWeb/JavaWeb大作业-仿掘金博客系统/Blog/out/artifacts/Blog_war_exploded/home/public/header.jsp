<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
  <canvas class="fireworks"></canvas>
  <i class="fa fa-arrow-right" id="toggle-sidebar" aria-hidden="true"></i>

  <div id="sidebar">
   <div class="author-info">

        <jsp:include page="author_info.jsp"/>
   </div>
  </div>
  
    <nav id="nav" style="background-image:url(${pageContext.request.contextPath}/${page.imagePath })">
        <jsp:include page="page_header.jsp"/>
   
   <div id="site-info">
    <div id="site-title">
 ${inform.pageNickname }
    </div>
    <div id="site-sub-title">
     ${page.pageTag}  
    </div>
        <div id="site-social-icons">
     <a class="social-icon" href="https://github.com/He-Xiang-best"><i class="fa-github fa"></i></a>
     <a class="social-icon" href="https://github.com/He-Xiang-best"><i class="fa-weibo fa"></i></a>
     <a class="social-icon" href=https://github.com/He-Xiang-best"><i class="fa-qq fa"></i></a>
     <a class="social-icon" href="https://github.com/He-Xiang-best"><i class="fa-facebook fa"></i></a>
     <a class="social-icon search"><i class="fa fa-search"></i></a>
    </div>
   </div>
   </nav>