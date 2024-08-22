<%@ page import="com.grepp.model.dtos.BoardDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>글 수정화면</title>
</head>
<body>
<%
    // 서버에서 전달된 게시글 정보 (BoardDTO 객체)
    BoardDTO bbb = (BoardDTO) request.getAttribute("bbb");
%>
<h1>글 수정하기</h1>
<%--역할: <form> 태그의 action 속성은 폼 데이터를 제출할 때, 데이터를 전송할 서버 측의 URL을 지정합니다.--%>
<form action="<%=request.getContextPath()%>/list/update<%=bbb.getNo()%>" method="post">
    <input type="hidden" name="purpose" value="update"/>
    <%--    역할: <input type="hidden" name="action" value="update"/>은 폼이 제출될 때 서버로 전송되는 데이터 중 하나입니다.
    이 필드는 숨겨져 있으며, 사용자에게 보이지 않지만, 서버로 전송될 때 중요한 데이터를 포함합니다.--%>
    <input type="hidden" name="no" value="<%=bbb.getNo()%>"/> <!-- 글번호는 숨김 필드로 전송 -->
    <table border="1">
        <tr>
            <td>제목 :</td>
            <td><input type="text" name="title" value="<%=bbb.getTitle()%>"/></td>
        </tr>
        <tr>
            <td>작성자 :</td>
            <td><input type="text" name="writer" value="<%=bbb.getWriter()%>"/></td>
        </tr>
        <tr>
            <td>내용 :</td>
            <td><textarea name="content" rows="10" cols="50"><%=bbb.getContent()%></textarea></td>
        </tr>
    </table>
    <br>
    <input type="submit" value="수정하기"/>
    <a href="<%=request.getContextPath()%>/list/<%=bbb.getNo()%>">[취소]</a>
</form>
</body>
</html>
