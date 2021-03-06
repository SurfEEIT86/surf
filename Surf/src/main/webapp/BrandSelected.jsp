<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.surf.products.model.dao.*, com.surf.products.model.*, javax.servlet.ServletContext " %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
    <!-- Bootstrap Core CSS -->
    <link href="bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- MetisMenu CSS -->
    <link href="bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="dist/css/sb-admin-2.css" rel="stylesheet">
    <!-- Custom Fonts -->
    <link href="bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <!-- Custom CSS -->
    <link href="css/3-col-portfolio.css" rel="stylesheet"> 
<title>聚浪</title>
<style type="text/css">
	
	body{
		padding:0px;
	}

	a {
		text-decoration: none;
		color: graytext;   
	}

 	.panel-body img{ 
 		width: 220px; 
 		height: 230px;
 		max-width: 100%; 
 		max-height:100%;
 		vertical-align: middle;
 		text-align:center;
 		margin: auto;
 		
	} 
 	.col-lg-12 img{ 
 		height:200px; 
 		width: 1000px; 
 	} 
	.panel-footer {
		background-color:#d9edf7;	
	}
	
	.panel-body{
		position: relative;
		width: 344px;
		height: 244px;
		max-width:100%;
		max-height:100%;
	}
	
	#prods img:hover{
		border:1px solid gray;
	}
		
</style>
</head>
<script src="js/jquery-2.2.4.min.js"></script>
<script src="js/jquery-ui.min.js"></script>
<script>
	$(function(){
		$('#prodtypes').click(function(){	
				$.ajax({					
					'type':'get',
					'url':'MainProductsServlet.do',
					'dataType':'JSON',
					'success':function(datas){	
						var ul = $('#productUL');					
						ul.empty();						
						var flag= $(document.createDocumentFragment());							
						$.each(datas, function(idx, types){				
	 						var link = $('<a></a>').append(types.type);	
	 						var url= "/Surf/ProductTypesServlet.do?type="+types.typeno;						
	 						link.attr("href", url);
	 						var col1 = $('<li></li>').append(link);
	 												
							flag.append(col1);							
						});											
						ul.append(flag);												
					}					
				});	
			});													
		});
</script>	
<body>
	<div id="wrapper">
		<!-- Navigation -->
		<nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
		 	<div class="navbar-header"> 
		 		 <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>   

			    <a class="navbar-brand" href="/Surf/members/index.jsp" style="font-weight: bold">聚浪</a>

			</div>
			 <!-- /.navbar-header -->	 
            <ul class="nav navbar-top-links navbar-right">			
                
                <!-- 購物車 -->
                <li class="dropdown">
                	<a href="/Surf/ShoppingCart.jsp">
                		<i class="glyphicon glyphicon-shopping-cart"></i>(${fn:length(purchaselist)})
                	</a>
                </li>
                
                <!-- 使用者 -->
               <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i>  <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                   
                    <c:if test="${not empty user}">
                        <li><a href="/Surf/members/ShowMemberData"><i class="fa fa-user fa-fw"></i> 會員專區</a>
                        </li>
                        <li><a href="/Surf/members/ShowMemberData#contact"><i class="fa fa-gear fa-fw"></i> 訂單查詢 </a>
                        </li>
                    </c:if>
                        <li class="divider"></li> 
                         <c:if test="${empty user}">
                       		<li><a href="/Surf/members/index.jsp"><i class="fa fa-sign-in fa-fw"></i> 登入</a>
	                        </li>
                       		<li><a href="/Surf/members/register.jsp"><i class="fa fa-pencil-square-o fa-fw"></i> 註冊</a>
	                        </li>
                   		 </c:if>                       
                        <c:if test="${not empty user}">
	                        <li><a href="/Surf/secure/login.do"><i class="fa fa-sign-out fa-fw"></i> 登出</a>
	                        </li>
                        </c:if>
                    </ul>
                    <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
            </ul>
            <!-- /.navbar-top-links -->
            
		    <div class="navbar-default sidebar" role="navigation">
		    	<div class="sidebar-nav navbar-collapse">
			        <ul class="nav" id="side-menu">
			        	<li>
                        	<a href="/Surf/Types.jsp"><i class="fa fa-star fa-fw"></i>商品區首頁</a>
                        </li> 
                        <li>			        	
                        	<a href="/Surf/ProductTypesServlet.do?type=0"><i class="fa fa-th fa-fw"></i>所有商品</a>
                        </li>       
			        	<li id="prodtypes">
			            	<a href="#"><i class="fa fa-bars fa-fw"></i>商品種類<span class="fa arrow"></span></a>
			                <ul class="nav nav-second-level" id="productUL">
			                  
			                </ul>			      
			            </li>
			            <li>			        	
                        	<a href="/Surf/CustomOrderType.jsp"><i class="fa fa-delicious fa-fw"></i>客製化浪板</a>
                        </li>     
			                         	                                      
			         </ul>
			         
		         </div>
		                <!-- /.sidebar-collapse -->
		   	 </div>
		            <!-- /.navbar-static-side -->
	    </nav>  
	    
	    <!-- 頁面內容 -->
	    <div id="page-wrapper">
            <div class="container-fluid">      
            	<div class="row">
            		<c:choose>
            			<c:when test="${typeno==1}">
		                    <div class="col-lg-12">
		                        <h1><img class="img-portfolio img-responsive" src="/Surf/img/shortboards.jpg" style="size:auto;"/></h1>
		                    </div>
                   		</c:when>
						<c:when test="${typeno==2}">
 		                    <div class="col-lg-12"> 
 		                        <h1><img class="img-portfolio img-responsive" src="/Surf/img/longboards.jpg" style="size:auto;"/></h1>
 		                    </div> 
 	                    </c:when> 
	                    <c:otherwise>
		                    <div class="col-lg-12">
		                        <h1><img class="img-portfolio img-responsive" src="/Surf/img/Products.jpg" style="size:auto;"/></h1>
		                    </div>
                    	</c:otherwise>
                    </c:choose>
                </div>        
				<div class="col-lg-12">
		                <h1 class="page-header"><a href="/Surf/ProductTypesServlet.do?type=${typeno}" style="text-decoration:underline;">${typename}</a> 
		                <span style="color:graytext">- ${brandname} 			               
			                <c:if test="${typeno==1 || typeno==2}">
			                	Surfboards
			                </c:if>
			            </span>    
		                    <small>Premium quality</small>                    	
		                </h1>		            			            	            		                			           
		        </div>           
                <!-- /.row -->
                 <div id="prods" class="row">	
		         	<c:forEach var="products" items="${products}">
		         		<c:if test="${products.stock != 0}">
					 	<div class="col-md-3 portfolio-item" style="height:400px;max-height:400px; padding:10px;">
							<a href="<c:url value="/ProductDetailServlet.do?productno=${products.productno}"/>">
							<img class="img-portfolio img-responsive" style="height:314px; max-height:314px;" src="<c:url value="${products.pic1}" />">
							</a>
							<h3><a href="<c:url value="/ProductDetailServlet.do?productno=${products.productno}"/>">${products.name}</a></h3>
							<span>${products.size}</span>			
						</div>
						</c:if>
					</c:forEach>      
                </div>
                <!-- /.row -->            
            </div>
            <!-- /.container-fluid -->
        </div>      
    </div>
    <!-- /#wrapper -->
    <!-- jQuery -->
<!--     <script src="bower_components/jquery/dist/jquery.min.js"></script> -->
    <!-- Bootstrap Core JavaScript -->
    <script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- Metis Menu Plugin JavaScript -->
    <script src="bower_components/metisMenu/dist/metisMenu.min.js"></script>
    <!-- Custom Theme JavaScript -->
    <script src="dist/js/sb-admin-2.js"></script>
</body>
</html>
