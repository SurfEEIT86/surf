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
	
	#loadingIMG {
    	padding:100px 200px 100px 200px;
    	max-width:1000px;
    	max-height:800px;
    	position:fixed;
     	text-align:center; 
     	vertical-align:middle; 
     	right:400px; 
     	top:350px; 
    	z-index: 1;
    	border:1px solid white;
    	background-color: #F5F5F5;
    	opacity: 0.7; 	
    	border-radius:10px;
    }
	
	.panel-warning{
		margin-bottom: 0px;
	}
	
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
	
	.panel-body{
		position: relative;
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
	
	.sum{
		font-weight: bold;
	}
	#bot {
		height: 40px;
	    box-sizing: border-box;    
	    position: absolute;
	    right:20px;
	    bottom:20px;
	    width: 50%;
	    margin-top: 20px;
    }
    
    #form span{
    	color:red;
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
                        	<a href="/Surf/Types.jsp"><i class="fa fa-star fa-fw"></i>商品首頁</a>
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
		        	<div class="col-lg-12">
		            	<h1><img class="img-portfolio img-responsive" src="/Surf/img/checkout.jpg" style="size:auto;"/></h1>
		            </div>
                    <!-- /.col-lg-12 -->
                </div>
                <div class="row">
                    <div class="col-lg-8">
		            	<div class="panel panel-warning">
				           <div class="panel-heading">
				              <h4>購物明細</h4>
				           </div>
				           <div class="panel-body">
				           	  <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover">
                                    <thead>                                     
                                        <tr>
                                            <th>#</th>                                         
                                            <th>產品名稱</th>
                                            <th>數量</th>
                                            <th>小計</th>
                                        </tr>                                 
                                    </thead>
                                    <tbody>
                                        <c:forEach var="purchaselist" items="${purchaselist}" varStatus="status">                               	
	                                    	<c:if test="${status.count%2==1}">
	                                    		<tr class="warning">
	                                    	</c:if>
	                                    	<c:if test="${status.count%2==0}">
	                                    		<tr>
	                                    	</c:if>
	                                    		<td>${status.count} </td>                                   	             			
					                			<td>${purchaselist.bean.name} </td>				                			
					                			<td>${purchaselist.quantity} </td>				                			
					                			<td>NT$<fmt:formatNumber value="${purchaselist.bean.price*purchaselist.quantity}" pattern="#,###,###"/></td>
				                			</tr>
			                 		</c:forEach>
                                    </tbody>
                                    <tr>
                                    	<td></td>
                                    	<td></td>
                                    	<td><span class="sum">總數量:${finalqty}</span></td>
                                    	<td><span class="sum">總金額:NT$<fmt:formatNumber value="${finalprice}" pattern="#,###,###"/></span></td>
                                    </tr>
                                </table>
                            </div>
				           </div>				           
		                </div>
		            </div>
                    <!-- /.col-lg-12 -->
                </div>            
                <!-- /.row -->
                
                 <div class="row">
                 <div id="loadingIMG" style="display:none"><img src="/Surf/img/load.gif" width="100px"/></div>	      	
		          	<div class="col-lg-8">
			            	<div class="panel panel-warning">
					           <div class="panel-heading">
					              <h4>確認付款與收件人資訊</h4>
					           </div>
					           
					           <div class="panel-body">
					           <div class="form">
					           <form id="form" role="form">
					           	 <fieldset>
						           	<div class="row">
							           <div class="col-md-6">					           	  
									           	  <div class="form-group has-warning">
							                              <label class="control-label" for="inputWarning">收件人:</label>
							                              <input id="receiver" type="text" class="form-control" style="width:100px" value="${user.name}" />
						                          		  <span id="name"></span>
						                          </div>
						                          
						                          <div class="form-group has-warning">
							                              <label class="control-label" for="inputWarning">連絡電話:</label>
							                              <input type="text" class="form-control" style="width:150px" value="${user.tel}" />
						                          </div>
						                          	                     						                          						                          	                    
									           	  <div class="row">
										           	  <div class="col-lg-6">
											           	  <div class="form-group has-warning">
								                              <label class="control-label" for="inputWarning">郵遞區號(選填):</label>
								                              <input id="zip" type="text" class="form-control" style="max-width:100px" maxlength="5"/>
							                              	  <span id="zipspan"></span>
							                              </div>
							                          </div>                          							          
						                          </div>				                          
						                          <div class="row">
							                          <div class="col-md-12">                                         
							                              <div class="form-group has-warning">
								                              <label class="control-label" for="inputWarning">地址:</label>
								                              <input id="address" name="address" type="text" class="form-control" style="max-width:250px" value="${user.address }"/>
							                              	  <span id="add"></span>
							                              </div>
							                          </div>    		                                                       		                              	                          
						                          </div>    		                                                       		                              	                          
				                       		</div>	                       	                     
							                <div class="col-md-6">
							                      	<div class="row">   
							                           <div class="panel panel-warning">
						                                    <div class="panel-heading">
						                                        <h4 class="panel-title">
						                                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">信用卡資訊</a>
						                                        </h4>
						                                    </div>
						                                    <div id="collapseOne" class="panel-collapse collapse in">
						                                        <div class="panel-body">
						                                        	<div class="col-md-12">
							                                            <div class="form-group has-warning">
							                                				<label class="control-label" for="inputWarning">信用卡卡號:</label>
							                              					<input id="creditcard" type="text" class="form-control" id="inputWarning" maxlength="16" style="max-width:200px;" />
							                              					<span id="card"></span>
						                              					</div>
						                              				</div>	
						                              				<div class="col-md-12">
															           	  <div class="form-group has-warning">
												                              <label class="control-label" for="inputWarning">驗證碼(CID):</label>
												                              <input id="cid" type="text" class="form-control" style="max-width:100px" maxlength="3"/>
											                              	  <span id="cidno"></span>
											                              </div>
											                        </div>         							                              										                              						
						                                        </div>
						                                    </div>
						                               </div>
						                            </div>			                             			                             			                             
						                     </div>
						                     </div>
						                     <div class="row">
				                        		 <div id="bot" class="col-md-6">
							                            	<div class="row">  
							                               		<div class="col-md-8"></div> 
								                               	<div class="col-md-4">	                                                     
							 	                              		<input id="createorder" type="button" name="確定送出" class="btn btn-warning" value="確定送出"/>                                    
															    </div>
															</div>  
							                 	 </div>
			                         		 </div>   			                  
						                </fieldset>
						            </form>         						                   	                           
			                        </div>			                        		                        
		                        </div>   <!-- panel-body -->
		                        <div class="panel-footer" style="background-color:#fcf8e3">                            
				         		</div>
	                        </div>  <!-- panel warning -->	                          	                          				           	  
					     </div> <!-- col-lg-8 -->
					     
		             </div> <!-- /.outer row -->
		          </div><!-- /.container-fluid -->
		          
              </div> <!-- /.page-wrapper -->             
                <!-- /.row -->               
            </div><!-- /.wrapper -->                 
    	
    <script type="text/javascript" src="js/alertify.min.js"></script>	
    <script>  
 	
	    function checkform() {
	        var creditcard = document.getElementById("creditcard").value;	        	               
	        var address = document.getElementById("address").value;
	        var name=document.getElementById("receiver").value;
	        var cid = document.getElementById("cid").value;	
	        var checkcard = /^\d{16}$/; 
			var checkcid = /^\d{3}$/; 
			var checkadd = /(?=.*[\u4e00-\u9fa5])/;							
	        
		        if(name==null || name.trim()==""){
		        	$('#name').text("請輸入收件人名稱");
		        	return false;
		        }		        
		    
		        else if(address==null || address.trim()==""){
		        	$('#add').text("請輸入地址");
		        	return false;
		        }
		        
		        else if(!checkadd.test(address)){
		        	$('#add').text("地址格式不正確");
		        	return false;
		        }
		        
		        else if(creditcard==null || creditcard.trim()=="") {
		        	$('#card').text("請輸入信用卡卡號");
		        	return false;
		        }	        
		        
		        else if(!checkcard.test(creditcard)){
		        	$('#card').text("信用卡格式不正確(卡號請輸入16位數字)");
		        	return false;
		        }
		        else if(cid==null || cid.trim()==""){
		        	$('#cidno').text("請輸入驗證碼");
		        	return false;	        
		        }
		        else if(!checkcid.test(cid)){
		        	$('#cidno').text("驗證碼格式不正確(驗證碼請輸入3位數字)");
		        	return false;
		        }
	        
		        else{
		        	return true;
		        }
	    }			
    
    	$('#createorder').click(function(){
    		$('#add').empty();
    		$('#card').empty();
    		$('#name').empty();
    		if(checkform()){
	    		alertify.set({ labels : { ok: "確定", cancel: "取消" } });
	    		alertify.set({ buttonReverse: true });
		    	alertify.confirm("您的訂單即將送出。您已確認購買明細與收件人資訊?", function (e) {
					if (e) {
						$.ajax({
							'type':'post',
							'url':'CreateOrderServlet.do',
							'data':{'zip':$('#zip').val(), 'address':$('#address').val(), 'creditcard':$('#creditcard').val()},
							'dataType':'text',
							'success':function(datas){
								if (datas == "success"){
									alertify.alert("已收到您的訂單，我們將盡快為您出貨。<br>您可至本網站會員專區或Email查詢訂單資訊，再次感謝您的購買。<br><br>", function(){
										window.location.assign("/Surf/Types.jsp");			
									});								
								}
								else if(datas=="modified"){
									
								}
							},  beforeSend:function(){
				                    $('#loadingIMG').fadeIn();
				             }, complete:function(){
				                    $('#loadingIMG').fadeOut();
				                }
						});						
					} else {
						
					}
				});
				return false;
    		}else{
    			
    		}
    	});
    	
    	
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
