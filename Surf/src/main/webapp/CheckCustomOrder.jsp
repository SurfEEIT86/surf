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
	<link rel="stylesheet" href="css/alertify.core.css" />
	<link rel="stylesheet" href="css/alertify.default.css" />
	<script src="js/modernizr-2.8.3.min.js"></script>  <!-- Modernizr /-->	
	<style type="text/css">	
					
	#loadingIMG {
    	padding:100px 200px 100px 200px;
    	max-width:1000px;
    	max-height:800px;
    	position:fixed;
     	text-align:center; 
     	vertical-align:middle; 
     	right:400px; 
     	top:200px; 
    	z-index: 1;
    	border:1px solid white;
    	background-color: #F5F5F5;
    	opacity: 0.7; 	
    	border-radius:10px;
    }
    
	.photo img{
		position:relative;
		width:180px;
/* 		height:200px; */
		min-width:100px;
		max-height:100%;
		margin:0px;
		text-align: center
	}
	
	.totalcost{
		font-weight: bold;
		float: right;  
	} 	
	
	.table tbody tr{
		height:100px;	
	}
	
	.photo {
		padding:0px;
	}
	
	#form span{
    	color:red;
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
	                           	 <h4>您的客製化浪板</h4>
	                        </div>
	                        <!-- /.panel-heading -->
	                        <div class="panel-body">
	                            <div class="table-responsive">
	                                <table class="table">
	                                    <thead>
	                                        <tr>                                         
	                                            <th>照片</th>                                         	                                                                                    
	                                            <th>板型</th>
	                                            <th>材質</th>
	                                            <th>尺寸</th>
	                                            <th>板色</th>	                                           
	                                            <th>尾舵系統</th>	                                           
	                                            <th>備註</th>	                                            
	                                        </tr>
	                                    </thead>
	                                    <tbody>	                                                                                          
	                                    	<tr class="success">	                                    		                                    		
	                                    		<td class="photo"><img class="img-portfolio img-responsive" src="${boardpic}"/></td>                                   	             				                                 		                                   	             			
					                			<td>${model.name}</td>
					                			<td>${material}</td>
					                			<td>${dimension}</td>
					                			<c:if test="${boardcolor=='Original'}">
					                				<td>${boardcolor}</td>
					                			</c:if>
					                			<c:if test="${boardcolor!='Original'}">
					                				<td>RGB:${boardcolor}</td>
					                			</c:if>
					                			<td>${finsys}</td>					                							                							                							  				                				
					                			<td>${remark}</td>					                							                							                							  				                				
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
                 <div class="row">
                 <div id="loadingIMG" style="display:none"><img src="/Surf/img/load.gif" width="100px"/></div>
                 	<div class="col-lg-12">
			            	<div class="panel panel-success">
					           <div class="panel-heading">
					              <h4>確認付款與收件人資訊</h4>
					           </div>
					           
					           <div class="panel-body">
					           <div class="form">
					           <form id="form" role="form">
					           	 <fieldset>
						           	<div class="row">
							           <div class="col-md-6">					           	  
									           	  <div class="form-group">
							                              <label class="control-label" for="inputWarning">收件人:</label>
							                              <input id="receiver" type="text" class="form-control" style="width:100px" value="${user.name}" />
						                          		  <span id="name"></span>
						                          </div>
						                          
						                          <div class="form-group">
							                              <label class="control-label" for="inputWarning">連絡電話:</label>
							                              <input type="text" class="form-control" style="width:150px" value="${user.tel}" />
						                          </div>
						                          	                     						                          						                          	                    
									           	  <div class="row">
										           	  <div class="col-lg-6">
											           	  <div class="form-group">
								                              <label class="control-label" for="inputWarning">郵遞區號(選填):</label>
								                              <input id="zip" type="text" class="form-control" style="max-width:100px" maxlength="5"/>
							                              	  <span id="zipspan"></span>
							                              </div>
							                          </div>                          							          
						                          </div>				                          
						                          <div class="row">
							                          <div class="col-md-12">                                         
							                              <div class="form-group">
								                              <label class="control-label" for="inputWarning">地址:</label>
								                              <input id="address" name="address" type="text" class="form-control" style="max-width:250px" value="${user.address }"/>
							                              	  <span id="add"></span>
							                              </div>
							                          </div>    		                                                       		                              	                          
						                          </div>    		                                                       		                              	                          
				                       		</div>	                       	                     
							                <div class="col-md-6">
							                      	<div class="row">   
							                           <div class="panel panel-success">
						                                    <div class="panel-heading">
						                                        <h4 class="panel-title">
						                                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">信用卡資訊</a>
						                                        </h4>
						                                    </div>
						                                    <div id="collapseOne" class="panel-collapse collapse in">
						                                        <div class="panel-body">
						                                        	<div class="col-md-12">
							                                            <div class="form-group">
							                                				<label class="control-label" for="inputWarning">信用卡卡號:</label>
							                              					<input id="creditcard" type="text" class="form-control" id="inputWarning" maxlength="16" style="max-width:200px;" />
							                              					<span id="card"></span>
						                              					</div>
						                              				</div>	
						                              				<div class="col-md-12">
															           	  <div class="form-group">
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
															    </div>
															</div>  
							                 	 </div>
			                         		 </div>   			                  
						                </fieldset>
						            </form>         						                   	                           
			                        </div>			                        		                        
		                        </div>   <!-- panel-body -->		                       
	                        </div>  <!-- panel warning -->	                          	                          				           	  
					     </div> <!-- col-lg-12 -->
					</div>
					<input id="createorder" type="button" name="確定送出" class="btn btn-success" value="確定送出" style="float:right"/>           			
            </div>          	
       </div>
        <!-- /.container -->	

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
    <script type="text/javascript" src="js/alertify.min.js"></script>
	<script type="text/javascript">
	
	  jQuery(function($) {
		$(document).ready(function() {
		  $('.navbar-default').stickUp();	  
		});			
	  });
	  
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
							'url':'CreateCustomOrderServlet.do',
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
