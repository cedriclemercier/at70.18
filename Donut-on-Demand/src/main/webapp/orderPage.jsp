<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Page</title>
</head>
<body>
	<h2> Donut Recipes Available : </h2>
		<table>
		 <tr>
		    <th>Name</th>
		    <th>Dough</th>
		    <th>Flavor</th>
		    <th>Topping</th>
		    <th>Cooking</th>
		    <th>Mix</th>
		    <th>Price</th>
		</tr>
		<c:forEach items="${donuts}" var="donut">
			  <tr>
			    <td>${donut.name}</td>
			    <td>${donut.dough}</td>
			    <td>${donut.flavor}</td>
			    <td>${donut.topping}</td>
			    <td>${donut.cooking}</td>
			    <td>${donut.mix}</td>
			    <td>${donut.price}</td>
			  </tr>
		</c:forEach>
		</table>

</body>
</html>