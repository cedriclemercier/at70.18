<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Information</title>
</head>
<body>

<div class="page-title">Enter Order Information</div>
 
   <form:form method="POST" modelAttribute="orderInfoForm" action="/shoppingCartCustomer">
 
       <table>
           <tr>
               <td>Firstname :</td>
               <td><form:input path="firstname" /></td>
               <td><form:errors path="firstname" class="error-message" /></td>
           </tr>
           
           <tr>
               <td>Lastname :</td>
               <td><form:input path="lastname" /></td>
               <td><form:errors path="lastname" class="error-message" /></td>
           </tr>
 
           <tr>
               <td>Email :</td>
               <td><form:input path="email" /></td>
               <td><form:errors path="email" class="error-message" /></td>
           </tr>
 
           <tr>
               <td>Phone :</td>
               <td><form:input path="phone" /></td>
               <td><form:errors path="phone" class="error-message" /></td>
           </tr>
	 		<tr>
	 		
		 		<td>Pick-up Shop : </td>
		 		<c:forEach items="${shops}" var="s">
		 			
		 			<td>
			 			<form:radiobutton path="shop" value="${s.id}" />
			 			${s.name}<br/>
					</td>
					
				</c:forEach>
					
				<td></td>
			</tr>
			
			<tr>
				<td>Pick-up Date :</td>
				<td>		 			
					<form:input path="pickUpDate" type="date" />				
				</td>
				<td>
					
				</td>
			</tr>
			
			<tr>
				<td>Pick-up Hour :</td>
				<td>		 			
					<form:input path="pickUpTime" type="time" />					
				</td>
				<td>
					
				</td>
			</tr>
			
           <tr>
               <td>&nbsp;</td>
               <td><input type="submit" value="Validate" /> </td>
           </tr>
       </table>
 
   </form:form>
</body>
</html>