<%@ page contentType = "text/html;charest=UTF-8" pageEncoding = "UTF-8" %>
<html>
<head>
<title>登录界面</title>
<%
    String path = request.getContextPath();
%>
<script src = "<%=path %>/helloweb/js/check.js" type = "text/javascript"></script>
<link rel = "stylesheet" type = "text/css" href = "<%=path %>/helloweb/css/action.css">
</head>
<body>
<div id="box1">
<form action="/daomang/LoginServlet" method = "post" name = "mform">
    <div class="image">
        <img src="<%=path %>/helloweb/images/JMP1.jpg" alt="">
    </div>
    <div class="login">
        <div class="header">
            LOGIN
        </div>
        <div class="input">
            <div class="input-border">
                <input type="text" class="border" name="username" placeholder="username">
            </div>
            <div class="input-border">
                <input type="password" class="border" name="password" placeholder="password">
            </div>
        </div>
        <div class="action">
            <div class="btn-login">
            <input type = "submit" class = "sm" value = "登录" id = "sb" >
            </div>
        </div>
            <h5>${errorInfo}</h5>
    </div>

</form>
</div>
</body>
</html>

