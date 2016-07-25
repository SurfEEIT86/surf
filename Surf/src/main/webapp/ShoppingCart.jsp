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

 	.col-lg-12 img{ 
 		height:200px; 
 		width: 1032px; 
 	} 
 	
	.panel-footer {
		background-color:#d9edf7;	
	}
	
	.totalcost{
		font-weight: bold;
		float: right;  
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
	
	.photo {
		padding:0px;
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
			<!--信箱 -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-envelope fa-fw"></i>  <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-messages">
                        <li>
                            <a href="#">
                                <div>
                                    <strong>John Smith</strong>
                                    <span class="pull-right text-muted">
                                        <em>Yesterday</em>
                                    </span>
                                </div>
                                <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...</div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <strong>John Smith</strong>
                                    <span class="pull-right text-muted">
                                        <em>Yesterday</em>
                                    </span>
                                </div>
                                <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...</div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <strong>John Smith</strong>
                                    <span class="pull-right text-muted">
                                        <em>Yesterday</em>
                                    </span>
                                </div>
                                <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...</div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a class="text-center" href="#">
                                <strong>Read All Messages</strong>
                                <i class="fa fa-angle-right"></i>
                            </a>
                        </li>
                    </ul>
                    <!-- /.dropdown-messages -->
                </li>
                <!-- /.dropdown -->
                
                <!-- 鬧鐘 -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-bell fa-fw"></i>  <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-alerts">
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-comment fa-fw"></i> New Comment
                                    <span class="pull-right text-muted small">4 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-twitter fa-fw"></i> 3 New Followers
                                    <span class="pull-right text-muted small">12 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-envelope fa-fw"></i> Message Sent
                                    <span class="pull-right text-muted small">4 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-tasks fa-fw"></i> New Task
                                    <span class="pull-right text-muted small">4 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-upload fa-fw"></i> Server Rebooted
                                    <span class="pull-right text-muted small">4 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a class="text-center" href="#">
                                <strong>See All Alerts</strong>
                                <i class="fa fa-angle-right"></i>
                            </a>
                        </li>
                    </ul>
                    <!-- /.dropdown-alerts -->
                </li>
                <!-- /.dropdown -->       
                <!-- 購物車 -->
                <li class="dropdown">
                	<a href="/Surf/ShoppingCart.jsp">
                		<i class="glyphicon glyphicon-shopping-cart"></i> (<span id="qty">${fn:length(purchaselist)}</span>)
                	</a>
                </li>
                
                <!-- 使用者 -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i>  <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="#"><i class="fa fa-user fa-fw"></i> User Profile</a>
                        </li>
                        <li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="login.html"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                        </li>
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
			            <li>
                            <a href="#"><i class="fa fa-user fa-fw"></i>會員專區</a>  
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
                    <div class="col-lg-12">
                        <h1><img class="img-portfolio img-responsive" src="/Surf/img/cart.jpg" style="size:auto;"/></h1>
                    </div>
                </div>
                
                <div class="row">
                	<div class="col-lg-12">
	                    <div class="panel panel-success">
	                        <div class="panel-heading">
	                           	 <h4>購物車</h4>
	                        </div>
	                        <!-- /.panel-heading -->
	                        <div class="panel-body">
	                            <div class="table-responsive">
	                                <table class="table">
	                                    <thead>
	                                        <tr>
	                                            <th>#</th>
	                                            <th>圖片</th>                                         
	                                            <th>產品名稱</th>
	                                            <th>尺寸</th>
	                                            <th>數量</th>
	                                            <th>小計</th>
	                                            <th></th>	                                            
	                                        </tr>
	                                    </thead>
	                                    <tbody>	                                                            
	                                    <c:forEach var="purchaselist" items="${purchaselist}" varStatus="status">
	                                    	<c:if test="${status.count%4==0}">
	                                    		<tr class="success">
	                                    	</c:if>
	                                    	<c:if test="${status.count%4==1}">
	                                    		<tr class="info">
	                                    	</c:if>
	                                    	<c:if test="${status.count%4==2}">
	                                    		<tr class="warning">
	                                    	</c:if>
	                                    	<c:if test="${status.count%4==3}">
	                                    		<tr class="danger">
	                                    	</c:if>
	                                    		<td>${status.count} </td>
	                                    		<td class="photo"><a href="<c:url value="/ProductDetailServlet.do?productno=${purchaselist.bean.productno}"/>"><img class="img-portfolio img-responsive" src="/Surf/${purchaselist.bean.pic1}"/></a></td>                                   	             			
					                			<td>${purchaselist.bean.name} </td>
					                			<td>${purchaselist.bean.size} </td>
					                			<td>${purchaselist.quantity} </td>
					                			<c:set var="totalqty" scope="request" value="${totalqty + purchaselist.quantity}"/>					                			
					                			<td>NT$<fmt:formatNumber value="${purchaselist.bean.price*purchaselist.quantity}" pattern="#,###,###"/></td>
					                			<c:set var="price" scope="request" value="${purchaselist.bean.price*purchaselist.quantity}"/>
					                			<c:set var="totalprice" scope="request" value="${totalprice+price}"/>
					                			<td><a href="#" onclick="return false"><i id="${purchaselist.bean.productno}" class="glyphicon glyphicon-trash" onclick="cancel(this.id)"></i></a>					  				                				
				                			</tr>
				                			
				                 		</c:forEach>
	                                	</tbody>    	
	                                </table>
	                            </div>
	                            <!-- /.table-responsive -->
	                            <div class="totalcost">			                                                                                
	                            	總金額: NT$ <span id="total"><fmt:formatNumber value="${totalprice}" pattern="#,###,###"/></span> 	                                              
	                            </div>
	                        </div>               
	                        <!-- /.panel-body -->
	                    </div>
                    <!-- /.panel -->
                    </div>
                 </div>
	             <div class="row">
		       		<div class="col-lg-3"></div>           
		       		<div class="col-lg-3"></div>           
		       		<div class="col-lg-3"></div>           
		       		<div class="col-lg-3">
		       		<form action="OrderCheck.do" method="post">
		       			<input type="hidden" name="totalprice" value="${totalprice}"/>
		       			<input type="hidden" name="totalqty" value="${totalqty}"/>	       			
		       			<c:if test="${totalqty!=null}">
		       				<button type="submit" class="btn btn-success">&nbsp&nbsp&nbsp&nbsp結帳&nbsp&nbsp&nbsp&nbsp</button>
		       			</c:if>
		       			<a href="/Surf/Types.jsp"><button type="button" class="btn btn-primary">繼續購物</button></a>
		       		</form>	     			
		       		</div>
	       		</div>                          	  
                <!-- /.row --> 
                <div class="row">
                	<div class="col-lg-12">
                		
                	</div> 
                </div>              
        	</div>
	    </div> 
    </div>
    <script type="text/javascript" src="js/alertify.min.js"></script>
    <script>     		
    		function cancel(id){
	  			alertify.set({ labels : { ok: "確定", cancel: "取消" } });
	  			alertify.set({ buttonReverse: true });
	  			alertify.confirm("確定刪除此商品?", function (e) {
	  			  	if(e){		  
	  				  $.ajax({
	  					  'type':'post',
	  					  'url':'AddIntoCartServlet.do',
	  					  'data':{'prodno':id},
	  					  'dataType':'text',
	  					  'success':function(datas){
	  						  if(datas=="success"){
	  							  alertify.success("已刪除商品");
								  window.location.assign("/Surf/ShoppingCart.jsp");		 
	  						  }    						  
	  					  }    					  
	  				  });
	  			  	}else{		  		
	  			  	}
	  		  	});
	  		  }
    
    </script>      
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