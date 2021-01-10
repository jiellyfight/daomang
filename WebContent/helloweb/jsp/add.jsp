<%@ page contentType="text/html; charset=UTF-8" %>
<html><head> <title>添加时间点</title>
<%
    String path = request.getContextPath();
%>
<script src= "<%=path %>/helloweb/js/addjsp.js" type = "text/javascript"></script>
<link rel = "stylesheet" type = "text/css" href = "<%=path %>/helloweb/css/adddjsp.css">
</head>
<body>
<div id="box1">
<font color=red>${result}</font>
<p class="class1">请输入一个时间点：</p>
<form action = "/daomang/AddTimeServlet" method = "post"name="mform">
 <table class="class1">
  <tr><td>温度：</td> <td><input class="input1" type="text" name="tem" ></td></tr>
   <tr><td>空气湿度：</td><td><input class="input1"type="text" name="airhum"></td></tr>      
   <tr><td>土壤湿度：</td><td><input class="input1" type="text" name="soilhum" ></td></tr>
   <tr><td>ph值：</td><td><input class="input1" type="text" name="ph" ></td></tr>
   <tr><td>光照强度：</td><td><input class="input1" type="text" name="lux" ></td></tr>
   <tr><td>光照时间：</td><td><input class="input1" type="text" name="ltime" ></td></tr>
   <tr><td><input type="submit" class="btn1" value="确定" id="add"></td>
      <td><input type="reset"class="btn1" value="重置" ></td>
      <td><input type="button" class="btn1"value="返回"  onclick = "window.location.href = '/daomang/ShowServlet'" ></td>
  </tr>
</table>
</form>
</div>
</body></html>
