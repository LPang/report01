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
	      <font size="6"> Welcome: <%=username  %> </font>
	      <hr>
	    </td>
	   </tr>
	  <tr>
	    <%--主体部分 --%>
	    <td valign="top">
	      <h2>Edit User</h2>
			<form action="UserSaveServlet" method="post">
			<input type="hidden" name="userid" value='${userinfo["id"]}' />
			UserName:<input type="text" name="username" value='${userinfo["name"]}' align="right"/><br/><p>
			Password:<input type="text" name="password" value='${userinfo["password"]}' align="right"/><br/><p>
			Email:&nbsp;&nbsp;&nbsp;<input type="text" value='${userinfo["email"]}' name="email"/> <br><p>
			Identity:<select name="identity"><option>Reporter</option><option>Developer</option><option>Administrator</option><option>Guest</option></select><br><p>
			<input type="submit" value="Confirm" />&nbsp;&nbsp;
			<input type="reset" value="Reset" />
			</form>
	    </td>
	   </tr>
	   
	  </table>
	  </td>
	  
	  </tr>
	
</table>
</body>
</html>