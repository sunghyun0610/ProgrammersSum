<%@ page import="com.grepp.model.ParamDTO" %><%--
  Created by IntelliJ IDEA.
  User: moon
  Date: 8/21/24
  Time: 3:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    int gugudan=(Integer) request.getAttribute("gugudan");
    for(int i=1;i<10;i++){
%>
<h5><%=gugudan%> * <%=i%>=<%=gugudan%></h5>
<%
    }
%>
당신이/ forward/str한테 보낸 파라미터는 dto에 담겨 나한테까지 전달되었습니다.<br>

<%
    ParamDTO param=(ParamDTO)request.getAttribute("param2");
%>
param1 : <%=param.getParam1()%><br>
param2 : <%=param.getParam2()%><br>

</body>
</html>
