<%--
  Created by IntelliJ IDEA.
  User: moon
  Date: 8/20/24
  Time: 9:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<script>
    alert('<%=request.getAttribute("msg")%>');
    location.href='<%=request.getAttribute("path")%>'
</script>

</body>
</html>
