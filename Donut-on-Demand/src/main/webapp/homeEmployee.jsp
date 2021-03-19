<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee page</title>
</head>
</head>
<body>

	<h1> Welcome ${employee.username} </h1>

	<h3>Your Role : </h3>
		
	<span> ${employee.role.getName()} </span><br>
	
	<sec:authorize access="hasRole('MANAGER')">
		<h2>Employee list </h2>
		<table>
		 <tr>
		    <th>Username</th>
		    <th>Role</th>
		</tr>
		<c:forEach items="${employees}" var="e">
			  <tr>
			    <td>${e.username}</td>
			    <td>${e.role.getName()}</td>
			  </tr>
		</c:forEach>
		</table>
	 <a href="/createEmployee"> Create new employee account </a>
	</sec:authorize>

	<a href="/logout">Logout</a>
</body>
</html>