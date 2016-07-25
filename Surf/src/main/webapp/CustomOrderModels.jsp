<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0">
    <meta name="description" content="Flatfy Free Flat and Responsive HTML5 Template ">
    <meta name="author" content="">

    <title>聚浪 – 客製化浪板</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
 
    <!-- Custom Google Web Font -->
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Lato:100,300,400,700,900,100italic,300italic,400italic,700italic,900italic' rel='stylesheet' type='text/css'>
	<link href='http://fonts.googleapis.com/css?family=Arvo:400,700' rel='stylesheet' type='text/css'>
	
    <!-- Custom CSS-->
    <link href="css/general.css" rel="stylesheet">
	
	 <!-- Owl-Carousel -->
    <link href="css/custom.css" rel="stylesheet">
	<link href="css/owl.carousel.css" rel="stylesheet">
    <link href="css/owl.theme.css" rel="stylesheet">
	<link href="css/style.css" rel="stylesheet">
	<link href="css/animate.css" rel="stylesheet">
	
	<!-- Magnific Popup core CSS file -->
	<link rel="stylesheet" href="css/magnific-popup.css"> 
	
	<script src="js/modernizr-2.8.3.min.js"></script>  <!-- Modernizr /-->
	<style type="text/css">	
		#whatis{
			background-image:url("/Surf/img/wave.jpg");								
		}
	</style>
</head>

<body id="home">

	<!-- Preloader -->
	<div id="preloader">
		<div id="status"></div>
	</div>		
	<nav class="navbar-default" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="/Surf/Types.jsp">聚浪商品區</a>
			</div>

			<div class="collapse navbar-collapse navbar-right navbar-ex1-collapse">
				<ul class="nav navbar-nav">									
					<li class="menuItem"><a href="/Surf/CustomOrderServlet.do?typeno=1">回上頁</a></li>
				</ul>
			</div>
		   
		</div>
	</nav> 
	
	<!-- What is -->
	<div id="whatis" class="content-section-b" style="border-top: 0">
		
		<div class="container">
			<div class="row">	
				<img src="/Surf${brandbean.pic}" style="float:left"/>
			</div>
			<div class="row">		
				<div class="col-md-6 col-md-offset-3 text-center wrap_title">
					<h2>選擇板型</h2>
					<p class="lead" style="margin-top:0">Originally Designed & Shaped</p>					
				</div>
			</div>
		<!-- 頁面內容 -->	
		
			<c:forEach var="models" items="${models}" varStatus="status">	
			<c:if test="${status.count%3==1}">
				<div class="row">
			</c:if>					
				<div class="col-sm-4 wow fadeInDown text-center" style="padding:10px">
				  <h4 style="margin:0px"> ${models.name} </h4>
				  <a href="/Surf/CustomModelServlet.do?modelno=${models.modelno}"><img src="/Surf${models.pic}" alt="Generic placeholder image" style="text-align:left"></a>				  					  
				</div><!-- /.col-lg-4 -->
			<c:if test="${status.count%3==0}">
				</div>
			</c:if>												
			</c:forEach>										
		</div>
	</div>


    <!-- JavaScript -->
    <script src="js/jquery-1.10.2.js"></script>
    <script src="js/bootstrap.js"></script>
	<script src="js/owl.carousel.js"></script>
	<script src="js/script.js"></script>
	<!-- StikyMenu -->
	<script src="js/stickUp.min.js"></script>
	<script type="text/javascript">
	  jQuery(function($) {
		$(document).ready( function() {
		  $('.navbar-default').stickUp();
		  
		});
	  });
	
	</script>
	<!-- Smoothscroll -->
	<script type="text/javascript" src="js/jquery.corner.js"></script> 
	<script src="js/wow.min.js"></script>
	<script>
	 new WOW().init();
	</script>
	<script src="js/classie.js"></script>
	<script src="js/uiMorphingButton_inflow.js"></script>
	<!-- Magnific Popup core JS file -->
	<script src="js/jquery.magnific-popup.js"></script> 
</body>

</html>
