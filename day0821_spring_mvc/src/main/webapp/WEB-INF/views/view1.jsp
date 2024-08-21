<%--
  Created by IntelliJ IDEA.
  User: moon
  Date: 8/21/24
  Time: 3:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
저는 자바이지만 html만들기 장인입니다!<br>
먼저 작업한 자바 데이터를 받아서 html 사이에 넣겠습니다 <br>
필요한 경우 조건문이나 반복문도 활용가능하죠!<br>
다만 그렇게 되면 자바와 html태그가 섞여 있어서 지저분해 집니다...<br>
<%=request.getAttribute("msg")%><br>
<h3>현재시간 : <%=request.getAttribute("now")%><br></h3>
</body>
</html>
