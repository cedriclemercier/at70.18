<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
  <head>
    <!-- Basic -->
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <!-- Mobile Metas -->
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
    <!-- Site Metas -->
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <meta name="author" content="" />

    <title>Add/Delete New Donut Recipes</title>

    <!-- slider stylesheet -->
    <link
      rel="stylesheet"
      type="text/css"
      href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.1.3/assets/owl.carousel.min.css"
    />

    <!-- bootstrap core css -->
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />

    <!-- fonts style -->
    <link
      href="https://fonts.googleapis.com/css?family=Baloo+Chettan|Dosis:400,600,700|Poppins:400,600,700&display=swap"
      rel="stylesheet"
    />
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
          <span> Donut on Demand </span>
        </a>
      </div>
      <!-- end header section -->
      <!-- slider section -->
      <section class="slider_section position-relative">
        <div
          id="carouselExampleControls"
          class="carousel slide"
          data-ride="carousel"
        >
          <div class="carousel-inner">
            <div class="carousel-item active">
              <div class="img-box">
                <img src="images/slider-img.jpg" alt="" />
              </div>
            </div>
            <div class="carousel-item">
              <div class="img-box">
                <img src="images/slider-img.jpg" alt="" />
              </div>
            </div>
            <div class="carousel-item">
              <div class="img-box">
                <img src="images/slider-img.jpg" alt="" />
              </div>
            </div>
          </div>
          <a
            class="carousel-control-prev"
            href="#carouselExampleControls"
            role="button"
            data-slide="prev"
          >
            <span class="sr-only">Previous</span>
          </a>
          <a
            class="carousel-control-next"
            href="#carouselExampleControls"
            role="button"
            data-slide="next"
          >
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
          <nav class="navbar navbar-expand custom_nav-container">
            <button
              class="navbar-toggler"
              type="button"
              data-toggle="collapse"
              data-target="#navbarSupportedContent"
              aria-controls="navbarSupportedContent"
              aria-expanded="false"
              aria-label="Toggle navigation"
            >
              <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
              <div class="d-flex flex-column flex-lg-row align-items-center">
                <ul class="navbar-nav">
                  <li class="nav-item active">
                    <a class="nav-link" href="/" id="go-home">Home <span class="sr-only">(current)</span></a
                    >
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="/donutList">Doughnuts </a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="/shoppingCart">Shopping Cart </a>
                  </li>
                  <sec:authorize access="hasRole('ORDER_SUPERVISOR')">
                    <li class="nav-item">
                      <a class="nav-link" href="/manageOrdersPicking"
                        >Manage Orders</a
                      >
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

    <!-- contact section -->
    <section class="shop_section layout_padding">
      <div class="container-fluid">

        <div class="layout_padding2-top statistics">
          <div class="row">
            <div class="col-md-6 offset-md-3">
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

        <br/>
        <div class="box-grey-bg">
		<h2> Add a new Donut Recipe </h2>
		<form:form method="POST" modelAttribute="newDonutRecipee" action="/addDonutRecipee">
			
			<spring:bind path="name">
				<div>
					<form:input type="text" path="name" class="form-control"
						placeholder="Name" autofocus="true"></form:input>
				</div>
			</spring:bind>

			<br />

			<spring:bind path="imageUrl">
			<div>
			<form:input type="text" path="imageUrl" class="form-control" placeholder="Image URL e.g 'https://i.ibb.co/c1pCwbz/5.jpg'" autofocus="true"></form:input>
			</div>
			</spring:bind>

			<br />
			
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
			<br />
			<br />
			
			<Input type="submit" name="submit" value="submit">
		</form:form>
		</div>
            </div>
          </div>
        </div>
      </div>
    </section>
    <!-- end contact section -->

    <!-- footer section -->
    <section class="container-fluid footer_section">
      <p>&copy; <span id="displayYear"></span> All Rights Reserved.</p>
    </section>
    <!-- footer section -->

    <script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.js"></script>
    <script type="text/javascript" src="js/custom.js"></script>
  </body>
</html>



<!-- <!DOCTYPE html>
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
</html> -->