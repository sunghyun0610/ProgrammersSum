<%--
  Created by IntelliJ IDEA.
  User: moon
  Date: 8/22/24
  Time: 10:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>로그인 페이지입니다</title>

    <script>
        // 페이지 로드 시 메시지 확인 후 alert 표시
        window.onload = function() {
            const message = "<%= (request.getAttribute("message") != null) ? request.getAttribute("message") : "" %>";
            if (message) {
                alert(message);
            }
        };
    </script>
</head>
<body>
<form action="<%=request.getContextPath()%>/login" method="post">
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
