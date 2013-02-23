<%@page import="domain.Fault"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Fault assign</title>
</head>
<body bgcolor="#BEBEBE">
	<%	
	Fault fault=(Fault)request.getAttribute("faultinfo");
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
	 <form action="FaultSaveServlet?Savetype=Assign" method="post">
	 <%-- --%>
	 <table width="100%" height="100%">
	 	<tr>
	 		<td valign="top" width="100%">
	 			<center> 
	     		<font size="6"> Assign a fault</font><br>
	      		</center>
	      		<hr width="100%">
	      	</td>
	 	</tr>
	 	<tr>
	 		<td valign="top" width="15"><b><font color="#AE0000"></font>Issue Id: ${faultinfo["id"]}</b>&nbsp;&nbsp;
	 		<input type="hidden" value='${faultinfo["id"]}' name="issueid"></td>
	 	</tr>
	 	<tr>
	 		<td valign="top" width="15%"><b>Issue Type:  ${faultinfo["type"]}</b>
	 		<input type="hidden" value='${faultinfo["type"]}' name="issuetype"></td>
	 	</tr>
	 	<tr>
	 		<td valign="top" width="15%"><b>Summary:${faultinfo["summary"]}</b>&nbsp;&nbsp;&nbsp;
	 		<input type="hidden" value='${faultinfo["summary"]}' name="summary"></td>
	 	</tr>
	 	
	 	<tr>
	 		<td valign="top" width="15%"><b>Severity:
	 		<%
	 			if(fault.getseverity().equals("High")){{out.print("High");}}
	 			if(fault.getseverity().equals("Middle")){out.print("Middle");}
	 			if(fault.getseverity().equals("Low")){out.print("Low");}
	 		%>
	 		</b>&nbsp;&nbsp;
	 		</td>
	 	</tr>
	 	<tr>
	 		<td valign="top" width="15%"><b><font color="#AE0000">Developer:</font></b>&nbsp;
	 		<select name="developerid">
	 			<c:forEach items="${usertype}" var='row'>
	 			<option value=${row["id"]}>${row["id"]}</option>
	 			</c:forEach>
	 		</select></td>
	 	</tr>
	 	
	 	<tr>
	 		<td><input type="submit" value="Submit">
	 		<input type="reset" value="Reset">
	 		</td>
	 	</tr>
	 </table>
	</form>
	 </td>
	</tr>
	</table>
</body>
</html>