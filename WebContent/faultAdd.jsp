<%@page import="java.util.List"%>
<%@page import="domain.User"%>
<%@page import="business.UserControl"%>
<%@page import="business.UserManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Report a fault</title>
</head>
<body bgcolor="#BEBEBE">
	<%
		String username=(String)request.getSession().getAttribute("user");
		System.out.print(username);
		UserManager um=new UserControl();
		List<User> list=um.listtype("Reporter");
		request.setAttribute("usertype", list);
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
	 		<td valign="top" width="100%">
	 			<center> 
	     		<font size="6"> Fault information</font><br>
	      		</center>
	      		<font size="3"> Reporter: <%= username  %> </font><br>
	      		<font size="3" color="blue"> Description</font>
	      		<hr width="100%">
	      	</td>
	 	</tr>
	 </table>
	 <form  action="FaultAddServlet" method="post">
	 <table width="100%" height="100%">	
	 	<tr>
	 		<td valign="top" width="15%"><b><font color="#AE0000">* </font>Issue Id:</b></td>
	 		<td valign="top" width="90%"><input type="text" name="issueid" maxlength="60"size="10"></td>
	 	</tr>
	 	<tr>
	 		<td valign="top" width="15%"><b>&nbsp;&nbsp;Issue Type:</b></td>
	 		<td valign="top" width="90%"><input type="text" name="issuetype" size="10"></td>
	 	</tr>
	 	<tr>
	 		<td valign="top" width="15%"><b><font color="#AE0000">* </font>Summary:</b></td>
	 		<td valign="top" width="90%"><input type="text" name="summary" size="68"></td>
	 	</tr>
	 	<tr>
	 		<td valign="top" width="10%"><b><font color="#AE0000">* </font>Detail:</b></td>
	 		<td valign="top" width="90%"><textarea rows="8" cols="60" name="detail" style="overflow-y:scroll"></textarea></td>
	 	</tr>
	 	<tr>
	 		<td valign="top" width="18%"><b><font color="#AE0000">* </font>Expected Results:</b></td>
	 		<td valign="top" width="90%"><textarea rows="8" cols="60" name="expectedres" style="overflow-y:scroll"></textarea></td>
	 	</tr>
	 	<tr>
	 		<td valign="top" width="18%"><b><font color="#AE0000">* </font>Actual Results:</b></td>
	 		<td valign="top" width="90%"><textarea rows="8" cols="60" name="actualres" style="overflow-y:scroll"></textarea></td>
	 	</tr>
	 	<tr>
	 		<td valign="top" width="18%"><b><font color="#AE0000">* </font>Project Name:</b></td>
	 		<td valign="top" width="90%"><select name="projectname"><option>Mr Fault project</option><option>Dundee Database project</option></select></td>
	 	</tr>
	 	<tr>
	 		<td valign="top" width="18%"><b><font color="#AE0000">* </font>Found in Release:</b></td>
	 		<td valign="top" width="90%"><select name="foundinrelease"><option>10.0.1</option><option>10.1.1</option><option>10.2.1</option></select></td>
	 	</tr>
	 	<tr>
	 		<td valign="top" width="18%"><b><font color="#AE0000">* State:</font></b></td>
	 		<td valign="top" width="90%">
	 		<select name="state"><option>New</option><option>In progress</option><option>In Test</option>
	 		<option>Deferred</option><option>Closed</option>
	 		</select></td>
	 	</tr>
	 	<tr>
	 		<td valign="top" width="18%"><b><font color="#AE0000">* Rational Status:</font></b></td>
	 		<td valign="top" width="90%">
	 		<select name="status"><option>None</option><option>Can Not Reproduce</option><option>As Intended</option>
	 		<option>Fixed</option><option>Duplicate</option><option>Third party problem</option><option>Awaiting info</option>
	 		</select></td>
	 	</tr>
	 	<tr>
	 		<td valign="top" width="18%"><b><font color="#AE0000">* Severity:</font></b></td>
	 		<td valign="top" width="90%"><select name="severity"><option>High</option><option>Middle</option><option>Low</option></select></td>
	 	</tr>
	 	<tr>
	 		<td valign="top" width="18%"><b><font color="#AE0000">* </font>Reproducibility:</b></td>
	 		<td valign="top" width="90%"><select name="reproducibility"><option>Yes</option><option>Not sure</option><option>No</option></select></td>
	 	</tr>
	 	<tr>
	 		<td valign="top" width="15%"><b><font color="#AE0000">* </font>Reporter id:</b></td>
	 		<td valign="top" width="90%"><select name="developerid">
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
	 	<tr>
	 		<td>
	 		<input type="hidden" >
	 		</td>
	 	</tr>
	 </table>
	 </form>
	 </td>
	</tr>
	</table>
</body>
</html>