<%--
  Created by IntelliJ IDEA.
  User: moon
  Date: 8/20/24
  Time: 9:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="common/header.jsp"%>
<h2>백엔드 데브코스 MVC 게시판에 오신걸 환영합니다</h2>
<a href="<%=request.getContextPath()%>/board/writeForm.do">[글쓰기 하러가기]</a>
<a href="<%=request.getContextPath()%>/board/list.do">[게시판 목록으로]</a>
</body>
</html>
