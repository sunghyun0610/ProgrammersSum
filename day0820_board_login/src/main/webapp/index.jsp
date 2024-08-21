<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %></h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<%
    response.sendRedirect("main.do");
%>
<%--절대 경로:

경로가 /로 시작하면, 해당 경로는 애플리케이션의 루트(컨텍스트 루트)를 기준으로 해석됩니다.
예를 들어, 애플리케이션의 컨텍스트 루트가 http://example.com/myapp이고, response.sendRedirect("/main.do");가 호출되면, 리다이렉트는 http://example.com/myapp/main.do로 이루어집니다.
상대 경로:

경로가 /로 시작하지 않으면, 현재 경로를 기준으로 상대적으로 해석됩니다.
예를 들어, 현재 경로가 http://example.com/myapp/member/profile.do이고, response.sendRedirect("main.do");를 호출하면, 리다이렉트는 http://example.com/myapp/member/main.do로 이루어집니다.
--%>
</body>
</html>