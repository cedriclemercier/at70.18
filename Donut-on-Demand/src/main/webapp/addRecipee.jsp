<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add/Delete New Donut Recipee</title>
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
		    <th>Delete Recipee</th>
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
			    <td>
			    
			    <a
                   href="/deleteDonutRecipee?id=${donut.id}">
                       Delete</a></td>
			  </tr>
			  
		</c:forEach>
		
		</table>

		<h2> Add a new Donut Recipe </h2>
		<form:form method="POST" modelAttribute="newDonutRecipee" action="/addDonutRecipee">
			
			<spring:bind path="name">
				<div>
					<form:input type="text" path="name" class="form-control"
						placeholder="Name" autofocus="true"></form:input>
				</div>
			</spring:bind>
			
			Dough :
			<form:select name="dough" path="dough">
			    <form:options items="${doughs}"  />
			</form:select>
			
			Flavor : 
			<form:select name="flavor" path="flavor">
			    <form:options items="${flavors}"  />
			</form:select>
			
			Topping :
			<form:select name="topping" path="topping">
			    <form:options items="${toppings}"  />
			</form:select>
			
			Mix :
			<form:select name="mix" path="mix">
				<form:options items="${mixs}"  />
			</form:select>
			
			Cooking :
			<form:select path="cooking">
   				<form:options items="${cookings}"  />
			</form:select>
			
			
			<Input type="submit" name="submit" value="submit">
		</form:form>
</body>
</html>