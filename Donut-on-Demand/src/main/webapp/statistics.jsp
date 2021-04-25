<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Statistics</title>
</head>
<body>
	<h1> Statistics of your shop</h1>
	<h2> Number total of sales : ${totalNbOrderLines}</h2>
	<ul>
		<c:forEach var="entry" items="${donutsMap}">
			
				<li>
					Donut : <c:out value="${entry.key}"/><br>
		            Number of sales : <c:out value="${entry.value.get(0)}"/><br>
		            Percentage of sales : <c:out value="${entry.value.get(1)}"/>%
	          	</li>
			         
	   </c:forEach>
	</ul>
	
</body>
</html>