<%--
  Created by IntelliJ IDEA.
  User: moon
  Date: 8/20/24
  Time: 4:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>글 작성화면</title>
</head>
<body>
<%@include file="common/header.jsp"%>
<br>
<form action="<%=request.getContextPath()%>/board/write.do" method="post">
    제목 : <input type="text" name="title"><br>
    내용 : <textarea name="content"></textarea><br>
    <input type="submit" value="작성완료">
</form>
</body>
</html>
