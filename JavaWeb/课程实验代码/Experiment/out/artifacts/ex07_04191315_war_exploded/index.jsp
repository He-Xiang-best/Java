<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 17283
  Date: 2021/4/24
  Time: 14:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>翻译</title>
    <style>
        .translation{
            font-size: 20px;
        }
        .translation:not(:first-child) {
            padding-left: 50px;
        }

        a:visited{text-decoration: none;color:blue;}

    </style>
</head>
<body>

<span class="translation"><a href="<c:url value="/translationServlet?action=transTOEnglish"/>">English</a></span>
<span class="translation"><a href="<c:url value="/translationServlet?action=transTOComplexChinese"/>"  >繁中</a></span>
<span class="translation"><a href="<c:url value="/translationServlet?action=transTOSimplifiedChinese"/>"  >简中</a></span>
<hr>

<c:choose>
    <c:when test="${empty requestScope.content}">
        <jsp:forward page="/translationServlet?action=transTOEnglish"></jsp:forward>
    </c:when>
    <c:otherwise>
        ${requestScope.content}
    </c:otherwise>
</c:choose>



</body>
</html>
