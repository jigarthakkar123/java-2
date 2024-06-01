<%@page import="com.bean.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Carbook - Free Bootstrap 4 Template by Colorlib</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
    <link href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,500,600,700,800&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="css/open-iconic-bootstrap.min.css">
    <link rel="stylesheet" href="css/animate.css">
    
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/owl.theme.default.min.css">
    <link rel="stylesheet" href="css/magnific-popup.css">

    <link rel="stylesheet" href="css/aos.css">

    <link rel="stylesheet" href="css/ionicons.min.css">

    <link rel="stylesheet" href="css/bootstrap-datepicker.css">
    <link rel="stylesheet" href="css/jquery.timepicker.css">

    
    <link rel="stylesheet" href="css/flaticon.css">
    <link rel="stylesheet" href="css/icomoon.css">
    <link rel="stylesheet" href="css/style.css">
  </head>
  <body>
    <%
    	User u=null;
    	if(session!=null)
    	{
    		if(session.getAttribute("u")!=null)
    		{
    			u=(User)session.getAttribute("u");
    		}
    	}
    %>
	  <nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
	    <div class="container">
	      <a class="navbar-brand" href="index.jsp">Car<span>Book</span></a>
	      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
	        <span class="oi oi-menu"></span> Menu
	      </button>

	      <div class="collapse navbar-collapse" id="ftco-nav">
	        <ul class="navbar-nav ml-auto">
	          <li class="nav-item active"><a href="index.jsp" class="nav-link">Home</a></li>
	          <li class="nav-item"><a href="about.jsp" class="nav-link">About</a></li>
	          <li class="nav-item"><a href="pricing.jsp" class="nav-link">My Booking</a></li>
	          <li class="nav-item"><a href="car.jsp" class="nav-link">Cars</a></li>
	          <li class="nav-item"><a href="contact.jsp" class="nav-link">Contact</a></li>
	          <%
	          	if(u==null)
	          	{
	          %>
		          <li class="nav-item"><a href="signup.jsp" class="nav-link">Sign Up</a></li>
		          <li class="nav-item"><a href="login.jsp" class="nav-link">Login</a></li>
		      <%
	          	}
	          	else
	          	{
		      %>
		      <li class="nav-item"><a href="change-password.jsp" class="nav-link">Change Password</a></li>
		      <li class="nav-item"><a href="logout.jsp" class="nav-link">Logout</a></li>
		      <%
	          	}
		      %>
	        </ul>
	      </div>
	    </div>
	  </nav>
    <!-- END nav -->
    
        
  </body>
</html>