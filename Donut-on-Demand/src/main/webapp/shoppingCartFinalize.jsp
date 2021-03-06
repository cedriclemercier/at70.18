<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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

    <title>Order Completed</title>

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
                <form
                  class="form-inline my-2 my-lg-0 ml-0 ml-lg-4 mb-3 mb-lg-0"
                >
                  <button
                    class="btn my-2 my-sm-0 nav_search-btn"
                    type="submit"
                  ></button>
                </form>
              </div>
            </div>
          </nav>
        </div>
      </div>
    </section>

    <!-- end nav section -->

    <!-- shop section -->

    <section class="shop_section layout_padding">
      <div class="container">
        <div class="box">
          <div class="detail-box">
            <h2>Order Completed</h2>
            <p>Thank you very much for your order in our Shop !</p>
            <p>Check your email to see your order information.</p>
          </div>
          <div class="img-box">
            <img src="images/shop-img.jpg" alt="" />
          </div>
          <div class="btn-box">
            <a href="/donutList"> Browse More Products </a>
          </div>
        </div>
      </div>
    </section>

    <!-- end shop section -->

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

<!-- 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Completed </title>
</head>
<body>
	<h1> Thank you very much for your order in our Shop ! </h1>
	<h1> Check your email to see your order information. </h1>
	
</body>
</html> -->
