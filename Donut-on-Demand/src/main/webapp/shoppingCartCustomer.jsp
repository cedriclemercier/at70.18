<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>

<head>
  <!-- Basic -->
  <meta charset="utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <!-- Mobile Metas -->
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
  <!-- Site Metas -->
  <meta name="keywords" content="" />
  <meta name="description" content="" />
  <meta name="author" content="" />

  <title>Order Information</title>

  <!-- slider stylesheet -->
  <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.1.3/assets/owl.carousel.min.css" />

  <!-- bootstrap core css -->
  <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />

  <!-- fonts style -->
  <link href="https://fonts.googleapis.com/css?family=Baloo+Chettan|Dosis:400,600,700|Poppins:400,600,700&display=swap" rel="stylesheet" />
  <!-- Custom styles for this template -->
  <link href="css/style.css" rel="stylesheet" />
  <!-- responsive style -->
  <link href="css/responsive.css" rel="stylesheet" />
</head>

<body>
  <div class="hero_area">
    <!-- header section strats -->
    <div class="brand_box">
      <a class="navbar-brand" href="index.html">
        <span>
          Donut on Demand
        </span>
      </a>
    </div>
    <!-- end header section -->
    <!-- slider section -->
    <section class=" slider_section position-relative">
      <div id="carouselExampleControls" class="carousel slide " data-ride="carousel">
        <div class="carousel-inner">
          <div class="carousel-item active">
            <div class="img-box">
              <img src="images/slider-img.jpg" alt="">
            </div>
          </div>
          <div class="carousel-item">
            <div class="img-box">
              <img src="images/slider-img.jpg" alt="">
            </div>
          </div>
          <div class="carousel-item">
            <div class="img-box">
              <img src="images/slider-img.jpg" alt="">
            </div>
          </div>
        </div>
        <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
          <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
          <span class="sr-only">Next</span>
        </a>
      </div>
    </section>
    <!-- end slider section -->
  </div>

  <!-- nav section -->

  <section class="nav_section">
    <div class="container">
      <div class="custom_nav2">
        <nav class="navbar navbar-expand custom_nav-container ">
          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>

          <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <div class="d-flex  flex-column flex-lg-row align-items-center">
              <ul class="navbar-nav  ">
                <li class="nav-item active">
                  <a class="nav-link" href="/" id="go-home">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="/donutList">Doughnuts </a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="/shoppingCart">Shopping Cart </a>
                </li>
                <sec:authorize access="hasRole('ORDER_SUPERVISOR')">
                    <li class="nav-item">
                      <a class="nav-link" href="/manageOrdersPicking">Manage Orders</a>
                    </li>
                  </sec:authorize>
                <li class="nav-item">
                  <a class="nav-link" href="/homeEmployee">My Account</a>
                </li>
                <li class="nav-item">
                  <sec:authorize access="!isAuthenticated()">
                    <a class="nav-link" href="/login"> Log In </a>
                  </sec:authorize>
                  <sec:authorize access="isAuthenticated()">
                    <a class="nav-link" href="/logout"> Log Out </a>
                  </sec:authorize>
                </li>
              </ul>
            </div>
          </div>
        </nav>
      </div>
    </div>
  </section>

  <!-- end nav section -->


<!-- shop section -->
<section class="contact_section layout_padding">
    <div class="container-fluid">

      <div class="layout_padding2-top">
        <div class="row">
          <div class="col-lg-4 offset-lg-3 col-md-5 offset-md-3">
              
            <div class="page-title">
                <h2>
                Enter Order Information
            </h2>
        </div>
 
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
               <td><input type="submit" value="Validate" id="submitOrderInfo" /> </td>
           </tr>
       </table>
 
   </form:form>

          </div>
        </div>
      </div>
    </div>
  </section>
  <!-- end shop section -->

  


  <!-- footer section -->
  <section class="container-fluid footer_section ">
    <p>
      &copy; <span id="displayYear"></span> All Rights Reserved. 
    </p>
  </section>
  <!-- footer section -->

  <script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
  <script type="text/javascript" src="js/bootstrap.js"></script>
  <script type="text/javascript" src="js/custom.js"></script>

</body>

</html>

<!-- 
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
</html> -->