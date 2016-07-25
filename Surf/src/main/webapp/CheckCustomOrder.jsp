<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
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
	<link rel="stylesheet" href="slider/css/jquery-ui.min.css">	
	<script src="js/modernizr-2.8.3.min.js"></script>  <!-- Modernizr /-->	
	<style type="text/css">					
	
	.photo img{
		position:relative;
		width:100px;
		height:100px;
		min-width:100px;
		max-height:100%;
		margin:0px;
		text-align: center
	} 	
	
	.table tbody tr{
		height:100px;	
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
					<li class="menuItem"><a href="/Surf/CustomModelServlet.do?modelno=${model.modelno}">重新設定</a></li>
				</ul>
			</div>	   
		</div>
	</nav>
	
	<!-- 頁面內容 --> 

	<div id ="useit" class="content-section-a">
        <div class="container">			
            <div class="row"> 
              <div class="col-lg-12">
	                    <div class="panel panel-success">
	                        <div class="panel-heading">
	                           	 <h4>客製化訂單</h4>
	                        </div>
	                        <!-- /.panel-heading -->
	                        <div class="panel-body">
	                            <div class="table-responsive">
	                                <table class="table">
	                                    <thead>
	                                        <tr>                                         
	                                            <th>正面</th>                                         
	                                            <th>背面</th>                                         
	                                            <th>產品名稱</th>
	                                            <th>尺寸</th>	                                           
	                                            <th>尾舵系統</th>	                                           
	                                            <th></th>	                                            
	                                        </tr>
	                                    </thead>
	                                    <tbody>	                                                                                          
	                                    	<tr class="info">	                                    	
	                                    		
	                                    		<td class="photo"><img class="img-portfolio img-responsive" src="${frontpic}"/></td>                                   	             			
	                                    		<td class="photo"><img class="img-portfolio img-responsive" src="${backpic}"/></td>                                   	             			
					                			<td>${model.name}</td>
					                			<td>${dimension}</td>
					                			<td>${finsys}</td>					                							                							                							  				                				
				                			</tr>
				                							                 		
	                                	</tbody>    	
	                                </table>
	                            </div>
	                            <!-- /.table-responsive -->
	                            <div class="totalcost">			                                                                                
	                            	總金額: NT$ <span id="total"><fmt:formatNumber value="${price}" pattern="#,###,###"/></span> 	                                              
	                            </div>
	                        </div>               
	                        <!-- /.panel-body -->
	                    </div>
                    <!-- /.panel -->
                    </div>
           
            </div>
        </div>
        <!-- /.container -->
             	
    </div>			

    <!-- JavaScript -->
    <script src="js/jquery-2.2.4.min.js"></script>
<!--     <script src="js/jquery-1.12.3.min.js"></script> -->
<!--     <script src="js/jquery-1.10.2.js"></script> -->
    <script src="js/bootstrap.js"></script>
	<script src="js/owl.carousel.js"></script>
	<script src="js/script.js"></script>
	<!-- StikyMenu -->
	<script src="js/stickUp.min.js"></script>
	<script src="js/html2canvas.js"></script>
    <script src="slider/js/jquery-ui.min.js"></script>
	<script type="text/javascript">
	
	  jQuery(function($) {
		$(document).ready(function() {
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
	 <!-- Bootstrap Core JavaScript -->
    <script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- Metis Menu Plugin JavaScript -->
    <script src="bower_components/metisMenu/dist/metisMenu.min.js"></script>
    <!-- Custom Theme JavaScript -->
    <script src="dist/js/sb-admin-2.js"></script>
</body>

</html>
