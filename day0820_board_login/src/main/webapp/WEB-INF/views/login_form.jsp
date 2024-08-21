<%--
  Created by IntelliJ IDEA.
  User: moon
  Date: 8/20/24
  Time: 2:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>로그인 화면</title>
</head>
<body>
<h2>로그인 화면입니다</h2>
<form action="<%=request.getContextPath()%>/member/login.do" method="post">
<table>
    <tr>
        <td>ID :</td>
        <td><input type="text" name="userid"/></td>
    </tr>
    <tr>
        <td>PW :</td>
        <td><input type="text" name="userpw"/></td>
    </tr>

    <tr>
        <td colspan="2">
            <input type="submit" value="LOGIN"/>
        </td>

    </tr>

</table>
</form>

</body>
</html>
