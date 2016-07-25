<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="css/3-col-portfolio.css" rel="stylesheet">

<title>聚浪</title>
</head>
<body>
 <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="<c:url value="/Types.jsp"/>">商品區</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="#">About</a>
                    </li>
                    <li>
                        <a href="#">Services</a>
                    </li>
                    <li>
                        <a href="#">Contact</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
    <!-- Page Content -->
	<div class="container">
	<!-- Page Header -->
		 <div class="row">
	            <div class="col-lg-12">
	                <h1 class="page-header">${brandname} Surfboards
	                    <small>Premium quality</small>
	                </h1>
	            </div>
	     </div>
	<!-- /.row -->
	
	<!-- Products Row -->
		 <div class="row">
		 		<c:forEach var="products" items="${products}">
		 			<div class="col-md-4 portfolio-item">
			 			<a href="">
						<img src="<c:url value="${products.pic1}" />">
						</a>
						<h3><a href="">${products.name}</a></h3>
						<span>${products.size}</span>			
					</div>
				</c:forEach>
	       </div>
      <hr>
	       
	       <!-- Footer -->
	       <footer>
	            <div class="row">
	                <div class="col-lg-12">
	                    <p>Copyright &copy; 聚浪商品網</p>
	                </div>
	            </div>
	            <!-- /.row -->
	       </footer>
	</div>
	<!-- /.container -->
       <!-- jQuery -->	
	   <script src="js/jquery.js"></script>
	   <!-- Bootstrap Core JavaScript -->
	   <script src="js/bootstrap.min.js"></script>
</body>
</html>