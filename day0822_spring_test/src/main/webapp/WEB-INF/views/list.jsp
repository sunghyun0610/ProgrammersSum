<%@ page import="com.grepp.model.dtos.BoardDTO" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: moon
  Date: 8/20/24
  Time: 9:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>게시판 전체조회입니다</title>
</head>
<body>
<a href="<%=request.getContextPath()%>/login">[로그인하러 가기]</a>

<table border="1">
    <%
        List<BoardDTO> bList = (List<BoardDTO>) request.getAttribute("boards");
        for(BoardDTO b: bList){
    %>
    <tr>
        <td><%=b.getNo()%></td>
        <td><a href="<%=request.getContextPath()%>/list/<%=b.getNo()%>"><%=b.getTitle()%></a></td>

        <td><%=b.getWriter()%></td>
        <td><%=b.getRegDate()%></td>
        <td><%=b.getReadCount()%></td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
