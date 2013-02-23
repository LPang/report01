<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<tr><%--this structure referenced from the book:Tomcat and java Web --%>
	<%--菜单部分下方 --%>
	  <td>
	    <font size="5">Links</font> <p>
	    <a href="main.jsp">Home</a><br>
	    <a href="showalluser?type=All">All Users</a><br>
	    <a href="showalluser?type=Reporter">All reporter</a><br>
	    <a href="showalluser?type=Developer">All developer</a><br>
	    <a href="userAdd.jsp">Add a user</a><br>
	    <a href="faultAdd.jsp">Report a fault</a><br>
	    <a href="showallfault?type=Default">Faults information</a><br>
	    <a href="assignissue">Assign faults</a><br>
	    <a href="showfaultAssignInfo">Assigned information</a><br>
	    <a href="Logout">Log out</a><br></p>
	    Time:<br>
	    <%=new Date().toLocaleString() %>
	  </td>
</tr>