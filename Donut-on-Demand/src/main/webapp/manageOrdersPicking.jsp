<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manage Orders Picking</title>
</head>
<body>
<h2>Orders to Prepare  </h2>
		<table>
		 <tr>
		    <th>Customer first name</th>
		    <th>Customer last name</th>
		    <th>Customer phone</th>
		    <th>Customer email</th>
		    <th>Pick up date</th>
		    <th>Pick up time</th>
		</tr>
		<c:forEach items="${orders}" var="o">
			  <tr>
			    <td>${o.customer.firstname}</td>
			    <td>${o.customer.lastname}</td>
			    <td>${o.customer.phone}</td>
			    <td>${o.customer.email}</td>
			    <td>${o.pickUpDate}</td>
			    <td>${o.pickUpTime}</td>
			  </tr>
		</c:forEach>
		</table>
</body>
</html>