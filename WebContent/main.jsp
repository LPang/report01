<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Fault Report System</title>
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
	 <td>
	 </td>
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
	    <h3>${errorCheck}</h3>
	    	<font size="5"> Main Introduction</font><br><p>
	       <font size="4"> Good issue management can improve your products' performance.<br>
			This system provide fine issue management for the reporter, developer, administrator and guest.<br><p>
			Click the All Users link would see the users' information. Similarly does the All reporter, developer.<br>
			Click the Faults information link would see the faults' information.<br><p>
			A reporter can report a fault by clicking the Report a fault link.<br>
			A administrator can assign a fault by clicking the Assign faults link.<br>
			User can see the fault assigned information by open the Assigned information.<br>
			</font>
	    </td>
	   </tr>
	   
	  </table>
	  </td>
	  
	  </tr>
	
</table>
</body>
</html>