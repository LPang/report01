<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>
</head>
<body bgcolor="#BEBEBE">
<center>
<h2>Welcome to the fault reporting system</h2>
<br />
<hr /><%--reference from some website which has similar function --%>
<form action="UserAddServlet?type=Register" method="post">
Account:&nbsp;<input type="text" name="account"/> <br/><p>
UserName:<input type="text" name="username" /> <br/><p>
Password:<input type="password" name="password" /> <br/><p>
Email:&nbsp;&nbsp;&nbsp;<input type="text" name="email"/> <br><p>
Identity:<select name="identity"><option>Guest</option></select><p>
<input type="submit" value="Register" />&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="reset"/>
</form>
</center>
</body>
</html>