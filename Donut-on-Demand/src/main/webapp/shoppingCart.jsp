<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shopping Cart</title>
</head>
<body>

	<h1>My Cart</h1>
 
   <c:if test="${empty cartForm or empty cartForm.cartLines}">
       <h2>There is no items in Cart</h2>
       <a href="/donutList">Show Donut List</a>
   </c:if>
   
   <c:if test="${not empty cartForm and not empty cartForm.cartLines   }">
       <form:form method="POST" modelAttribute="cartForm" action="/shoppingCart">
 
           <c:forEach items="${cartForm.cartLines}" var="cartLineInfo"
               varStatus="varStatus">
               <div class="product-preview-container">
                   <ul>
        
                       <li>Name: ${cartLineInfo.donutRecipe.name}
                       <form:hidden path="cartLines[${varStatus.index}].donutRecipe.id" />
                       </li>
                       
                       <li>Price: <span class="price">
                      
                         <fmt:formatNumber value="${cartLineInfo.donutRecipe.price}" type="currency"/>
                        
                       </span></li>
                       <li>Quantity: <form:input
                               path="cartLines[${varStatus.index}].quantity" /></li>
                       <li>Subtotal:
                         <span class="subtotal">
                        
                            <fmt:formatNumber value="${cartLineInfo.amount}" type="currency"/>
                      
                         </span>
                       </li>
                       <li><a href="/shoppingCartRemoveProduct?id=${cartLineInfo.donutRecipe.id}">
                             Delete </a></li>
                  
                   </ul>
               </div>
           </c:forEach>
          <input class="button-update-sc" type="submit" value="Update Quantity" />
          <a class="navi-item"
               href="/shoppingCartCustomer">Enter Customer Info</a>
          <a class="navi-item"
               href="/donutList">Continue Add</a>
       </form:form>
       
       </c:if>
</body>
</html>