<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Fault assigned information</title>
</head>
<body bgcolor="#BEBEBE">
	<%
		String username=(String)request.getSession().getAttribute("user");
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
	      <font size="6"> Welcome: <%= username  %> </font>
	      <hr>
	    </td>
	   </tr>
	  <tr>
	    <%--主体部分 --%>
	    <td valign="top">
	       <center>
			<h2>Fault List</h2>
			<table border="1">
			<tr>
			<th>Issue Id</th>
			<th>Type</th>
			<th>Summary</th>
			<th>Developerid</th>
			<th>Administratorid</th>
			<th>Operation</th>
			</tr>
			<c:forEach items="${faultassigninfo}" var="Fault">
			<tr>
			
			<td>${Fault["id"]}</td>
			<td>${Fault["type"]}</td>
			<td>${Fault["summary"]}</td>
			<td><a href='adminisassign?type=Developer&assignerid=${Fault["developerid"]}' target="_blank">${Fault["developerid"]}</a></td>
			<td><a href='adminisassign?type=Administrator&assignerid=${Fault["administratorid"]}' target="_blank">${Fault["administratorid"]}</a></td>
			<td><a href='showallfault?issueid=${Fault["id"]}' target="_parent">Detail</a>|<a href='saveassign?issueid=${Fault["id"]}' target="_blank">Edit</a>|<a href='FaultAssignDeleteServlet?issueid=${Fault["id"]}' target="_blank">Delete</a></td>
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