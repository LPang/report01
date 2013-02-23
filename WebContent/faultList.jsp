<%@page import="domain.Fault"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>All faults list</title>
</head>
<body bgcolor="#BEBEBE">
	<%
		String username=(String)request.getSession().getAttribute("user");
		String type=request.getParameter("type");
		System.out.print(username);
	%>
	<%--最外层Table --%>
	<table width="100%" height="100%" >
	<tr height="100%"><%--第一行 --%>
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
	 <td valign="top" height="100" width="85%">
	  <table width="100%" height="100%">
	   <tr>
	    <%--头部 --%>
	    <td valign="top" height="100%">
	      <font size="6"> Welcome: <%=username %> </font>
	      <hr>
	    </td>
	   </tr>
	  <tr height="100%">
	    <%--主体部分 --%>
	    <td valign="top" height="100%">
	    <h3>${errorCheck}</h3>
	      <iframe frameborder="1" name="summary" scrolling="yes" width=100% height=250 src="showfaultsimple" >
	      	
	      </iframe>
	    </td>
	   </tr>
	  
	  </table>
	  </td>
</tr>

<tr height="100%"><%--第二行 --%>
	<%--左侧菜单部分 --%>
	<td width="15%" height="100%" valign="top" align="left" >
	<table>
	 <tr>
	 <%--菜单部分上方 可放图片--%>
	 </tr>
	 <tr>
	 <%--菜单部分下方 --%>
	  <td>
	   
	  </td>
	 </tr>
	 </table>
	</td>
	
	 <%--网页右边部分 --%>
	 <td valign="top" height="100" width="85%">
	  <table width="100%" height="100%">
	   <tr>
	    <%--头部 --%>
	    <td valign="top" height="15%">
	      <font size="6"> DESCRIPTION </font>
	      <hr color="red">
	    </td>
	   </tr>
	  <tr>
	    <%--主体部分 --%>
	    <td valign="top" height="80%">
	      <iframe frameborder="1" name="detail" scrolling="yes" width=100% height=300 src="showfaultdetail?type=<%=type %>" >
	      	
	      </iframe>
	    </td>
	   </tr>
	   
	  </table>
	  </td>
</tr>

</table>
</body>
</html>