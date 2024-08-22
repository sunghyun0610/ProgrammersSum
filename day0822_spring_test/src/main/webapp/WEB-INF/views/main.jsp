<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>메인페이지 입니다</title>
    <style>
        /* 이전 스타일은 그대로 유지 */
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            color: #333;
            margin: 0;
            padding: 0;
        }

        .container {
            width: 80%;
            max-width: 1200px;
            margin: 50px auto;
            background-color: #fff;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
        }

        h1 {
            text-align: center;
            color: #4CAF50;
        }

        .welcome-message {
            font-size: 1.2em;
            margin-bottom: 20px;
            text-align: center;
        }

        .menu {
            list-style-type: none;
            padding: 0;
            text-align: center;
        }

        .menu li {
            display: inline;
            margin: 0 15px;
        }

        .menu a {
            text-decoration: none;
            color: #4CAF50;
            font-weight: bold;
        }

        .menu a:hover {
            color: #333;
        }
    </style>
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
<div class="container">
    <h1>메인페이지</h1>
    <div class="welcome-message">
        <%
            String loginId = (String) session.getAttribute("loginId");
            if (loginId != null) {
        %>
        <%=loginId%>님 로그인 중이시네요. 환영합니다.<br/>
        <ul class="menu">
            <li><a href="<%=request.getContextPath()%>/logout">[로그아웃]</a></li>
            <li><a href="<%=request.getContextPath()%>/list">[게시판 목록]</a></li>
            <li><a href="<%=request.getContextPath()%>/list/write">[게시글 쓰기]</a></li>
        </ul>
        <%
        } else {
        %>
        <ul class="menu">
            <li><a href="<%=request.getContextPath()%>/login">[로그인]</a></li>
            <li><a href="<%=request.getContextPath()%>/register">[회원가입]</a></li>
            <li><a href="<%=request.getContextPath()%>/list">[게시판 목록]</a></li>
            <li><a href="<%=request.getContextPath()%>/list/write">[게시글 쓰기]</a></li>
        </ul>
        <%
            }
        %>
    </div>
</div>
</body>
</html>
