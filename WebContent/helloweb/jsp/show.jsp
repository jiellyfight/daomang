<%@ page contentType = "text/html;charest=UTF-8" pageEncoding = "UTF-8" %>
<%@ page import="java.util.*,com.model.Meta" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>参数界面</title>
<%
    String path = request.getContextPath();
%>
<script src = "<%=path %>/helloweb/js/displayjsp.js" type = "text/javascript"></script>
<link rel = "stylesheet" type = "text/css" href = "<%=path %>/helloweb/css/showjsp.css">

</head>

</html>
<body>
<% String user=(String)session.getAttribute("username");
     java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	   java.util.Date currentTime = new java.util.Date();  
	   String time = simpleDateFormat.format(currentTime).toString();
%>
<p class="biaoti">
	<td>欢迎：</td>
	<td><%= user %></td></tr>
	<td>现在的时间为：</td>
	<td><%= time %></td>
</p>
<div id="box1">
<table border="1">

<!-- 查询一个时间点 -->
<form action = "/daomang/QueryServlet" method="post" name = "form">
  <p>  
  	请输入需要查看的时间点：
  	<input type = "text" name="time" size="15">
  	<input type = "submit" value = "确定" id="bu">
 	<input type="button"   value="新增时间点"  onclick = "window.location.href = 'helloweb/jsp/add.jsp'" >
  </p>
</form>
<!-- 列表 -->
<tr class="biaoti"><td>时间</td><td>温度（℃）</td><td>空气湿度(%)</td>
<td>土壤湿度(%)</td><td>ph值</td><td>光照强度(klux)</td><td>光照时间(h)</td><td>是否删除</td></tr>
<c:forEach var="meta" items="${metaList.pageRow}" >
   <tr><td><font color="white">${meta.time}</font></td>
   <td><c:if test="${meta.tem>'25'||meta.tem<'10'}">
   		<font color="red">${meta.tem}</font>
   </c:if>
   <c:if test="${meta.tem<='25'&&meta.tem>='10'}">
      <font color="white">${meta.tem}</font>
   </c:if>
   </td>
   <td><c:if test="${meta.airhum>'60'||meta.airhum<'50'}">
   		<font color="red">${meta.airhum}</font>
   </c:if>
   <c:if test="${meta.airhum<='60'&&meta.airhum>='50'}">
      <font color="white">${meta.airhum}</font>
   </c:if>
   </td>
   <td><c:if test="${meta.soilhum<'15.5'}">
   		<font color="red">${meta.soilhum}</font>
   </c:if>
   <c:if test="${meta.soilhum>='15.5'}">
      <font color="white">${meta.soilhum}</font>
   </c:if>
   </td>
   <td><c:if test="${meta.ph>'7.5'||meta.ph<6}">
   		<font color="red">${meta.ph}</font>
   </c:if>
   <c:if test="${meta.ph<='7.5'&&meta.ph>=6}">
   		<font color="white">${meta.ph}</font>
   </c:if>
   </td>
   <td><c:if test="${meta.lux>'80'||meta.lux<'40'}">
   		<font color="red">${meta.lux}</font>
   </c:if>
   <c:if test="${meta.lux<='80'&&meta.lux>='40'}">
      <font color="white">${meta.lux}</font>
   </c:if>
   </td>
   <td><font color="white">${meta.ltime}</font></td>
	   <td><a  class="wei"
	   href="/daomang/DeleteServlet?time=${meta.time}">删除</a></td>
	  <!--  <td><a href="/daomang/AlterServlet?time=${meta.time}">修改标准值</a></td> -->
       </tr>
</c:forEach>
</table>
<br>
<!-- 分页 -->

<font color="white">第${metaList.pageNow}页/共${metaList.pageCount}页</font>
	<a class="wei"
	href="<c:url value="/ShowServlet?pageNow=${1}" />"
		id="numberPage">首页</a>
	<c:if test="${metaList.pageNow > 1}">
		<a class="wei"
			href="<c:url value="/ShowServlet?pageNow=${metaList.pageNow-1}" />"
			id="numberPage">上一页</a>
	</c:if>
	<!-- 
		总页数小于要显示的页数（5页）
			begin = 1；
			end = ${userList.pageCount}；
		总页数大于要显示的页数（5页）
			begin = ${userList.pageNow - 2 }；
			end = ${userList.pageNow - 2 }；
	 -->
	<c:choose>
		<c:when test="${metaList.pageCount < metaList.pageSize }">
			<c:set var="begin" value="1" />
			<c:set var="end" value="${metaList.pageCount}" />
		</c:when>
		<c:otherwise>
			<c:set var="begin" value="${metaList.pageNow - 2 }" />
			<c:set var="end" value="${metaList.pageNow + 2 }" />
			<c:if test="${begin < 1 }">
				<c:set var="begin" value="${1}" />
				<c:set var="end" value="${5}" />
			</c:if>
			<c:if test="${end > metaList.pageCount }">
				<c:set var="begin" value="${metaList.pageCount-4}" />
				<c:set var="end" value="${metaList.pageCount}" />
			</c:if>
		</c:otherwise>
	</c:choose>
	<c:forEach var="i" begin="${begin }" end="${end }">
		<c:choose>
			<c:when test="${i eq metaList.pageNow }">
				${i}
			</c:when>
			<c:otherwise>
				<a class="shuzi"
				href="<c:url value="/ShowServlet?pageNow=${i}" />"
					id="numberPage">${i}</a>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	<c:if test="${metaList.pageNow < metaList.pageCount}">
		<a	class="wei"
			href="<c:url value="/ShowServlet?pageNow=${metaList.pageNow+1}" />"
			id="numberPage">下一页</a>
	</c:if>
	<a class="wei"
		href="<c:url value="/ShowServlet?pageNow=${metaList.pageCount}" />"
		id="numberPage">尾页</a> 
</div>
</body>
</html>

