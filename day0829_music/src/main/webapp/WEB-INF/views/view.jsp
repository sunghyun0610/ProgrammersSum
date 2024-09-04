
<%@ page import="com.grepp.model.dtos.MusicDTO" %><%--
  Created by IntelliJ IDEA.
  User: moon
  Date: 8/20/24
  Time: 9:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>글 상세</title>
</head>
<body>
<%@include file="common/header.jsp"%>
<%
    MusicDTO bbb = (MusicDTO) request.getAttribute("bbb");
%>
<table border="1">
    <tr>
        <td>글번호 : </td>
        <td><%=bbb.getNo()%></td>
    </tr>
    <tr>
        <td>제목 : </td>
        <td><%=bbb.getTitle()%></td>
    </tr>
    <tr>
        <td>작성자 : </td>
        <td><%=bbb.getArtist()%></td>
    </tr>
    <tr>
        <td>내용 : </td>
        <td><%=bbb.getGenre()%></td>
    </tr>
    <tr>
        <td>작성일시 : </td>
        <td><%=bbb.getDuration()%></td>
    </tr>
    <tr>
        <td>조회수 : </td>
        <td><%=bbb.getReg_date()%></td>
    </tr>

</table>
<a href="<%=request.getContextPath()%>/board.do?purpose=update&no=<%=bbb.getNo()%>">[수정하기]</a>
<a href="<%=request.getContextPath()%>/list">[게시판 목록으로]</a>
</body>
</html>
