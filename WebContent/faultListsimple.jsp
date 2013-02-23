<%@page import="java.util.List"%>
<%@page import="domain.Fault"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	
	%>
<center>
			<h2>Fault List</h2>
			<table border="1">
			<tr>
			<th>Issue Id</th>
			<th>Summary</th>
			<th>State</th>
			<th>Rational Status</th>
			<th>Operation</th>
			</tr>
			<c:forEach items="${faultList}" var="Fault">
			<tr>
			
			<td>${Fault["id"]}</td>
			<td>${Fault["summary"]}</td>
			<td>${Fault["state"]}</td>
			<td>${Fault["status"]}</td>
			<td><a href='showallfault?issueid=${Fault["id"]}&type=Simple' target="_parent">Detail</a>|<a href='FaultEditServlet?issueid=${Fault["id"]}' target="_blank">Edit</a>|<a href='FaultDeleteServlet?issueid=${Fault["id"]}' target="_parent">Delete</a></td>
			</tr>
		</c:forEach>
		</table>
		</center>
</body>
</html>