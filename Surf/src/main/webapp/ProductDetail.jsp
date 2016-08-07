<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.surf.products.model.dao.*, com.surf.products.model.*, javax.servlet.ServletContext " %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <!-- Custom CSS -->
    <link href="css/scrolling-nav.css" rel="stylesheet">  
    <!-- Custom Fonts -->
    <link href="bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="css/alertify.core.css" />
	<link rel="stylesheet" href="css/alertify.default.css" />
     
<title>聚浪</title>
<style type="text/css">
	a {
		text-decoration: none;
		color: graytext;    
	}
	.container-fluid{
		padding:0px;	
	}
	#page-wrapper{
		padding:0px;
	}
	
	.page-header{
		margin-top: 0px;	
	}

 	.col-lg-12 img{ 
 		height:200px; 
 		width: 1000px; 
 	} 
	
	.panel-body{
		position: relative;
		width: 344px;
		max-width:100%;
		max-height:100%;
	}	
	
	.panel-body img{ 
 		position:absolute;
 		max-width: 100%; 
 		max-height:100%;
 		margin: auto;
 		top:0;
 		left:0;
 		bottom:0;
 		right:0;
	} 
	
	.front{
		padding: 20px;
		text-align: center;
		vertical-align: middle;
	}
	
	.back{
		padding: 20px;
		text-align: center;
		vertical-align: middle;
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
                		<i class="glyphicon glyphicon-shopping-cart"></i> <span id="qty">(${fn:length(purchaselist)})</span>
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
	    <div id="page-wrapper" class="pd-dt-wrap">
	    	<div class="container-fluid">
	    		 <!-- Intro Section -->
			    <section id="intro" class="intro-section">
			    	<div class="row">  	
			        	<div class="col-lg-12">
<%-- 			        	<c:if test="${brandbean!=null}"> --%>
<%-- 			        		<a href="<c:url value="/BrandServlet.do?brand=${brandno}"/>"> --%>
<%-- 			        			<img class="img-portfolio img-responsive" src="/Surf${brandbean.pic}" style="max-width:200px; height:auto; border:5px outset gray"> --%>
<!-- 			                </a> -->
<%-- 			            </c:if>	 --%>
							<div class="brand">
								<a href="<c:url value="/BrandServlet.do?brand=${productdetail.brandvo.brandno}"/>">
				        			<img class="img-portfolio img-responsive" src="/Surf${productdetail.brandvo.pic}" style="max-width:200px; height:auto;">
				                </a>	
							</div>
			            		                
			                <h1 class="page-header"><a href="<c:url value="/BrandServlet.do?brand=${productdetail.brandvo.brandno}"/>" style="text-decoration:underline">${productdetail.brandvo.name}</a>
			                <small><a href="${productdetail.link}">${productdetail.name}</a></small></h1>
	          			</div>
	          		</div>		
			        <div class="row">
			                <div class="col-sm-3" >
			                   <img class="img-portfolio img-responsive" src="<c:url value="${productdetail.pic1}"/>"/>
			                </div>
			                <div class="col-sm-3" >
			                   <img class="img-portfolio img-responsive" src="<c:url value="${productdetail.pic2}"/>"/>
			                </div>
			                <div class="col-sm-3" >
			                   <img class="img-portfolio img-responsive" src="<c:url value="${productdetail.pic3}"/>"/>
			                </div>
			                <div class="col-sm-3" >
			                   <div class="panel panel-yellow">
					            	<div class="panel-heading">
					                	<h5>尺寸</h5>
					                </div>
					                <div class="panel-body">
					                	<h2 style="margin:0"><small>${productdetail.size}</small></h2>
					                </div>							               
			                    </div>
			                    <!-- /.panel -->
			                    <div class="panel panel-yellow">
		                        	<div class="panel-heading">
		                            	<h5>庫存</h5>
		                        	</div>
		                        	<div class="panel-body">
		                            	<h2 style="margin:0"><small>${productdetail.stock}</small></h2>
		                        	</div>				                        	
		                        </div>  
		                        <!-- /.panel -->

		                        <h2 class="price">NT$<fmt:formatNumber value="${productdetail.price}" pattern="#,###,###"/></h2> 

		                        <div class="qty">	
									<label for="number">請選擇/修改數量</label>
									<select name="number" id="number">						      
									   <option selected="selected">1</option>
									   <c:forEach var="i" begin="2" end="${productdetail.stock}">
										   	<option>${i}</option>						      
									   </c:forEach>     
									</select>
								</div> 	

		                        <div id="card-4" class="clearfix" style="height:110px"> 
									<div class="front"> 
									    <button id="flip-btn" type="button" class="btn btn-warning btn-circle btn-xl" title="加入購物車"><i class="glyphicon glyphicon-shopping-cart"></i>
							 	        </button>
								    </div> 
								    <div class="back">
								    	<button id="unflip-btn" type="button" class="btn btn-success btn-circle btn-xl" title="自購物車移除"><i class="fa fa-check"></i>
								 	        </button>
								    </div>						    
								</div>
									

			                </div>
			        </div>        
			    </section>

			    <div class="row">

			    	<div class="col-sm-12">
			    		 <!-- About Section -->
					    <section id="about" class="about-section">
			             	<h2 style="font-weight:bold; color: white">商品描述</h2>
			                <h2 style="text-align:justify; color: white"><small style="color: white; line-height:150%">${productdetail.description}</small></h2>
				                                    
					    </section>
			    	</div>

			    	

			    </div>
					    	
			    
			    
	    	</div>
	     </div>
	      
    </div>
    <script src="js/jquery.flip.min.js"></script>
    <script type="text/javascript" src="js/alertify.min.js"></script>
    <script>
	    $("#card-4").flip({
	      trigger: "manual"
	    });
	    
	    $(document).on("click", "#flip-btn", function() {
	    	alertify.set({ labels : { ok: "確定", cancel: "取消" } });
	    	alertify.set({ buttonReverse: true });
	    	alertify.confirm("確定加入購物車?", function (e) {
				if (e) {		
					$.ajax({
						'type':'get',
						'url':'AddIntoCartServlet.do?product='+${productdetail.productno}+'&quantity='+$('#number').val(),
						'dataType':'text',
						'success':function(datas){
							if (datas == "success"){
								alertify.success("已加入購物車");
								$("#card-4").flip(true);
								$('#qty').empty();
								$('#qty').append("("+${fn:length(purchaselist)+1}+")");
							}
							else if(datas=="modified"){
								alertify.success("已修改購買數量");
								$("#card-4").flip(true);
							}
							else if(datas=="nologin"){
								window.location.assign("/Surf/members/index.jsp");					
							}
						}
					});						
				} else {
					
				}
			});
			return false;	    	            
	    });
	    
	    $(document).on("click", "#unflip-btn", function() {
	        $("#card-4").delay(3000).flip(false);
	    });
	</script>
    <!-- Bootstrap Core JavaScript -->
    <script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- Metis Menu Plugin JavaScript -->
    <script src="bower_components/metisMenu/dist/metisMenu.min.js"></script>
    <!-- Custom Theme JavaScript -->
    <script src="dist/js/sb-admin-2.js"></script>
    <!-- Scrolling Nav JavaScript -->
    <script src="js/jquery.easing.min.js"></script>
    <script src="js/scrolling-nav.js"></script> 
</body>
</html>