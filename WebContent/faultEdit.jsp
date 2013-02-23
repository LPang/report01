<%@page import="domain.Fault"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
	 <table width="100%" height="100%">
	 	<tr>
	 		<td valign="top" width="100%">
	 			<center> 
	     		<font size="6"> Fault information</font><br>
	      		</center>
	      		<font size="3" color="blue"> Description</font>
	      		<hr width="100%">
	      	</td>
	 	</tr>
	 </table>
	 <form  action="FaultSaveServlet?Savetype=Edit" method="post">
	 <table width="100%" height="100%">	
	 	<tr>
	 		<td valign="top" width="15%"><b><font color="#AE0000">* </font>Issue Id:</b></td>
	 		<td valign="top" width="90%"><input type="text" value='${faultinfo["id"]}' name="issueid" maxlength="60"size="15"></td>
	 	</tr>
	 	<tr>
	 		<td valign="top" width="15%"><b>&nbsp;&nbsp;Issue Type:</b></td>
	 		<td valign="top" width="90%"><input type="text" value='${faultinfo["type"]}' name="issuetype" size="15"></td>
	 	</tr>
	 	<tr>
	 		<td valign="top" width="15%"><b><font color="#AE0000">* </font>Summary:</b></td>
	 		<td valign="top" width="90%"><input type="text" value='${faultinfo["summary"]}' name="summary" size="68"></td>
	 	</tr>
	 	<tr>
	 		<td valign="top" width="10%"><b><font color="#AE0000">* </font>Detail:</b></td>
	 		<td valign="top" width="90%"><textarea rows="8" cols="60" name="detail" style="overflow-y:scroll">${faultinfo["detail"]}</textarea></td>
	 	</tr>
	 	<tr>
	 		<td valign="top" width="18%"><b><font color="#AE0000">* </font>Expected Results:</b></td>
	 		<td valign="top" width="90%"><textarea rows="8" cols="60" name="expectedres" style="overflow-y:scroll">${faultinfo["expresult"]}</textarea></td>
	 	</tr>
	 	<tr>
	 		<td valign="top" width="18%"><b><font color="#AE0000">* </font>Actual Results:</b></td>
	 		<td valign="top" width="90%"><textarea rows="8" cols="60" name="actualres" style="overflow-y:scroll">${faultinfo["actresult"]}</textarea></td>
	 	</tr>
	 	<tr>
	 		<td valign="top" width="18%"><b><font color="#AE0000">* </font>Project Name:</b></td>
	 		<td valign="top" width="90%"><select name="projectname"><option  <%if(fault.getproname().equals("Mr Fault project")) {out.print("selected");} %>>Mr Fault project</option><option  <%if(fault.getproname().equals("Dundee Database project")) {out.print("selected");} %>>Dundee Database project</option></select></td>
	 	</tr>
	 	<tr>
	 		<td valign="top" width="18%"><b><font color="#AE0000">* </font>Found in Release:</b></td>
	 		<td valign="top" width="90%"><select name="foundinrelease"><option <%if(fault.getrelease().equals("10.0.1")){out.print("selected");} %>>10.0.1</option><option <%if(fault.getrelease().equals("10.1.1")){out.print("selected");} %>>10.1.1</option><option <%if(fault.getrelease().equals("10.2.1")){out.print("selected");} %>>10.2.1</option></select></td>
	 	</tr>
	 	<tr>
	 		<td valign="top" width="18%"><b><font color="#AE0000">* State:</font></b></td>
	 		<td valign="top" width="90%">
	 		<select name="state"><option <%if(fault.getstate().equals("New")){out.print("selected");} %>>New</option><option <%if(fault.getstate().equals("In progress")){out.print("selected");} %>>In progress</option><option <%if(fault.getstate().equals("In Test")){out.print("selected");} %>>In Test</option>
	 		<option <%if(fault.getstate().equals("Deferred")){out.print("selected");} %>>Deferred</option><option <%if(fault.getstate().equals("Closed")){out.print("selected");} %>>Closed</option>
	 		</select></td>
	 	</tr>
	 	<tr>
	 		<td valign="top" width="18%"><b><font color="#AE0000">* Rational Status:</font></b></td>
	 		<td valign="top" width="90%">
	 		<select name="status"><option <%if(fault.getstatus().equals("None")){out.print("selected");} %>>None</option><option <%if(fault.getstatus().equals("Can Not Reproduce")){out.print("selected");} %>>Can Not Reproduce</option><option <%if(fault.getstatus().equals("As Intended")){out.print("selected");} %>>As Intended</option>
	 		<option <%if(fault.getstatus().equals("Fixed")){out.print("selected");} %>>Fixed</option><option <%if(fault.getstatus().equals("Duplicate")){out.print("selected");} %>>Duplicate</option><option <%if(fault.getstatus().equals("Third party problem")){out.print("selected");} %>>Third party problem</option><option <%if(fault.getstatus().equals("Awaiting info")){out.print("selected");} %>>Awaiting info</option>
	 		</select></td>
	 	</tr>
	 	<tr>
	 		<td valign="top" width="18%"><b><font color="#AE0000">* Severity:</font></b></td>
	 		<td valign="top" width="90%"><select name="severity"><option <%if(fault.getseverity().equals("High")){out.print("selected");} %>>High</option><option <%if(fault.getseverity().equals("Middle")){out.print("selected");} %>>Middle</option><option <%if(fault.getseverity().equals("Low")){out.print("selected");} %>>Low</option></select></td>
	 	</tr>
	 	<tr>
	 		<td valign="top" width="18%"><b><font color="#AE0000">* </font>Reproducibility:</b></td>
	 		<td valign="top" width="90%"><select name="reproducibility"><option <%if(fault.getrepro().equals("Yes")){out.print("selected");} %>>Yes</option><option <%if(fault.getrepro().equals("Not sure")){out.print("selected");} %>>Not sure</option><option <%if(fault.getrepro().equals("No")){out.print("selected");} %>>No</option></select></td>
	 	</tr>
	 	<tr>
	 		<td valign="top" width="15%"><b><font color="#AE0000">* </font>Reporter id:</b></td>
	 		<td valign="top" width="90%"><input type="text" value='${faultinfo["reporterid"]}' name="reporterid" size="15"></td>
	 	</tr>
	 	<tr>
	 		<td valign="top" width="15%"><b>&nbsp;&nbsp;Reporter Name:</b></td>
	 		<td valign="top" width="90%"><input type="text" value='${faultinfo["reportername"]}' name="reportname" size="15"></td>
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