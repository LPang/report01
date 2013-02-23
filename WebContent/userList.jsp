<%@page import="domain.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User List</title>
</head>
<body bgcolor="#BEBEBE">
	<%
		String username=(String)request.getSession().getAttribute("user");
		System.out.print(username);
	%>
	<%--最外层Table --%>
	<table width="100%" height="100%">
	<tr><%--第一行 --%>
	<%--左侧菜单部分 --%>
	<td width="15%" height="100%" valign="top" align="left" bgcolor="#CCFFCC">
	<table>
	 <tr>
	 <%--菜单部分上方 可放图片--%>
	 </tr>
	 <tr>
	 <%--菜单部分下方 --%>
	  <%@ include file="leftherf.jsp" %>
	 </tr>
	 </table>
	</td>
	 
	 <%--网页右边部分 --%>
	 <td valign="top" height="100%" width="85%">
	  <table width="100%" height="100%">
	   <tr>
	    <%--头部 --%>
	    <td valign="top" height="15%">
	      <font size="6"> Welcome: <%=username %> </font>
	      <hr>
	    </td>
	   </tr>
	  <tr>
	    <%--主体部分 --%>
	    <td valign="top">
	    <h3>${errorCheck}</h3>
	      <center>
			<h2>User List</h2>
			<table border="1">
			<tr>
			<th>User ID</th>
			<th>User Name</th>
			<th>Email</th>
			<th>Type</th>
			<th>Operation</th>
			</tr>
		<c:forEach items="${userList}" var="row">
			<tr>
			<td>${row["id"]}</td>
			<td>${row["name"]}</td>
			<td>${row["email"]}</td>
			<td>${row["type"]}</td>
			<td><a href='UserDeleteServlet?type=All&userid=${row["id"]}'>Delete</a>|<a href='UserEditServlet?userid=${row["id"]}'>Modify</a></td>
			</tr>
		</c:forEach>
		</table>
		</center>
	    </td>
	   </tr>
	   
	  </table>
	  </td>
	  
	  </tr>
	
</table>
</body>
</html>