<%--
  Created by IntelliJ IDEA.
  User: moon
  Date: 8/21/24
  Time: 11:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>welcome page</title>
</head>
<body>
hi가 만든 html을 보게 됩니다!<br>
<form action="<%=request.getContextPath()%>/bye" method="get">
    param 1: <input type="text" name="param1"><br>
    param 2: <input type="number" name="param2"><br>
    <input type="submit" value="전송">
</form>
</body>
</html>
