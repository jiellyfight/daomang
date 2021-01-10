<%@ page contentType="text/html; charset=utf-8" %>

<html>
<%
    String path = request.getContextPath();
%>
<head>
	<title>报错</title>
	<link rel = "stylesheet" type = "text/css" href = "<%=path %>/helloweb/css/errorjsp.css">
	
</head>
<body>
	<div class="main-container">
        <div class="img-container" >
            <img class="IMG" src="<%=path %>/helloweb/images/JMP2.png">
        </div>
        <div class="text-container">
            <div class="code">404</div>
            <div class="msg"> 该时间点不存在。</div>
            <a class="action" href="show.jsp"><div>返回</div></a>
        </div>
    </div>
</body>
</html>
