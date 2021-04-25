<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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

		<form:form method="POST" modelAttribute="newDonutRecipee" action="/addDonutRecipee">
			
			<form:select name="dough" path="dough">
			    <option value="0">CHOCOLATE</option>
			    <option value="Dough.OATMEAL">OATMEAL</option>
			    <option value="Dough.PEANUT_BUTTER">PEANUT_BUTTER</option>
			    <option value="Dough.PLAIN">PLAIN</option>
			</form:select>
			
			<form:select name="flavor" path="flavor">
			    <option value="CHILI">CHILI</option>
			    <option value="Flavor.CINNAMON">CINNAMON</option>
			    <option value="Flavor.VANILLA">VANILLA</option>
			</form:select>
			
			<form:select name="topping" path="topping">
			    <option value="Topping.MILK_CHOCOLATE">MILK_CHOCOLATE</option>
			    <option value="Topping.MNMS">MNMS</option>
			    <option value="Topping.REESES_BUTTERCUP">REESES_BUTTERCUP</option>
			    <option value="Topping.WHITE_CHOCOLATE">WHITE_CHOCOLATE</option>
			</form:select>
			
			<form:select name="mix" path="mix">
			    <option value="Mix.MIXED">MIXED</option>
			    <option value="Mix.TOPPED">TOPPED</option>
			</form:select>
			
			<form:select name="cooking" path="cooking">
			    <option value="Cooking.CHEWY">CHEWY</option>
			    <option value="Cooking.CRUNCHY">CRUNCHY</option>
			</form:select>
			
			
			<form:select name="cooking" path="cooking">
			    <option th:each="state : ${T(com.example.donutondemand.model.Cooking).values()}"
			            th:value="${state}"
			            th:text="${state}">
			    </option>
			</form:select>
			
			
			<Input type="submit" name="submit" value="submit">
		</form:form>
</body>
</html>