<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome to the fault reporting system</title>
</head>
<body bgcolor="#BEBEBE">
<center>
<h2>Welcome to the fault reporting system</h2>
<br />
${errorCheck}
<hr />
<form action="LoginServlet" method="post">
Account:<input type="text" name="username" /> <br/><p>
Password:<input type="password" name="password" /> <br><p>
Identity:<select name="identity"><option>Reporter</option><option>Developer</option><option>Administrator</option><option>Guest</option></select><br/><p>
<input type="submit" value="Login" />&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="Reset">&nbsp;&nbsp;&nbsp;&nbsp;<a href="register.jsp">Register</a>
</form>
<h2>Note</h2><br>
If you are a new user, you must register a guest first.<br><p>
If you are a reporter, you can report a new fault and see all the issues existed information.<br> <p>
If you are a developer, you can see all the issues but can not report or edit a fault. <br><p>
If you are a administrator you almost can do all the operations.<br><p>
Do not be hesitate, just use it!!!<br><p>
</center>
</body>
</html>