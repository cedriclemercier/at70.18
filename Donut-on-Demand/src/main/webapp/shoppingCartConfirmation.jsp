<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shopping Cart Confirmation</title>
</head>
<body>

	<h1> Your Order Information </h1>
	<h2> 
		${cartInfo.orderInfo.firstname }<br>
		${cartInfo.orderInfo.lastname }<br>
		${cartInfo.orderInfo.email }<br>
		${cartInfo.orderInfo.phone }<br>
		Shop : ${cartInfo.orderInfo.shop.name }<br>
		Shop Address : <br>
		${cartInfo.orderInfo.shop.address.houseNo } ${cartInfo.orderInfo.shop.address.streetAddress }<br>
		${cartInfo.orderInfo.shop.address.city } ${cartInfo.orderInfo.shop.address.zipcode }<br>
		${cartInfo.orderInfo.pickUpDate }<br>
		${cartInfo.orderInfo.pickUpTime }<br>
		
		<c:forEach items="${cartInfo.cartLines}" var="cartLineInfo">
               <div class="product-preview-container">
                   <ul>
                       <li>Name: ${cartLineInfo.donutRecipe.name}</li>
                       <li>Price: ${cartLineInfo.donutRecipe.price}</li>
                       <li>Quantity: ${cartLineInfo.quantity}</li>
                       <li>Subtotal: ${cartLineInfo.amount}</li>
                   </ul>
               </div>
         </c:forEach>
         Total Amount : ${cartInfo.getAmountTotal()}
	</h2>
	
	<form method="POST" action="/shoppingCartConfirmation">
		<input type="submit" value="Confirm my Order" /> 
	</form>
</body>
</html>