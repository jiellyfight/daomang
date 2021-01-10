<%@ page contentType="text/html; charset=utf-8" %>
<jsp:useBean id="meta" type="com.model.Meta"
 scope="session"></jsp:useBean>
<html>
<head><title>一个时间点的信息</title>
<%
    String path = request.getContextPath();
%>
<link rel = "stylesheet" type = "text/css" href = "<%=path %>/helloweb/css/displayjsp.css">
</head>
<body>
<div class="box1">

<table border="0">
<tr><td>时间点：</td>
<td><jsp:getProperty name="meta" property="time" /></td>
</tr>	
<tr><td>温度： </td>
<td><jsp:getProperty name="meta" property="tem" /></td>
</tr>
<tr><td>空气湿度： </td>
<td><jsp:getProperty name="meta" property="airhum" /></td>
</tr>

<tr><td>土壤湿度：</td>
<td><jsp:getProperty name="meta" property="soilhum" /></td>
</tr>
<tr><td>ph值：</td>
<td><jsp:getProperty name="meta" property="ph" /></td>
</tr>
<tr><td>光照强度：</td>
<td><jsp:getProperty name="meta" property="lux" /></td>
</tr>
<tr><td>光照时间：</td>
<td><jsp:getProperty name="meta" property="ltime" /></td>
</tr>
</table>
<tr><input  class="btn1"type="button" value="返回"  onclick = "window.location.href = '/daomang/ShowServlet'" ></tr>

</div>
</body></html>
