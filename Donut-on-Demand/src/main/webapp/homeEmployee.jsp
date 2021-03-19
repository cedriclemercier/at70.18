<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		
	<span> ${employee.role.getName()} </span>

	<a href="/logout">Logout</a>
</body>
</html>