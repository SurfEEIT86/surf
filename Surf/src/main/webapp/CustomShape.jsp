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
	<link rel="stylesheet" href="slider/css/jquery-ui.min.css">
	
	<script src="js/modernizr-2.8.3.min.js"></script>  <!-- Modernizr /-->	
	<style type="text/css">	
		
		#whatis{
			background-image:url("/Surf/img/wave.jpg");								
		}
		
		#useit{
			background-color: #D0D0D0;
		}		
		
		.panel-title{
			font-style: oblique;
			margin-left: 50px;
			color: graytext;
			text-decoration: underline;			
		}	
		
		.fcs {
			position:absolute;
			bottom:50px;
			left:75px;
		}
		
		.future {
			position:absolute;
			bottom:50px;
			left:70px;
		}
		
		.s1{
			max-width:50px;
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
					<li class="menuItem"><a href="/Surf/CustomBrandServlet.do?brandno=${brandbean.brandno}">回上頁</a></li>
				</ul>
			</div>
		   
		</div>
	</nav>
	
	<!-- 頁面內容 --> 
	<div id ="useit" class="content-section-a">
        <div class="container">			
            <div class="row">         							
				<div class="col-sm-3 pull-right wow fadeInRightBig">                                  
                	 <img id="back" class="img-responsive" style="opacity:0.7" src="img/board/poly-back.png" alt="">
                	 <img id="FCS3" class="img-responsive fcs" style="opacity:1; display:none" src="img/fins/FCS3.png">  
                	 <img id="FCS4" class="img-responsive fcs" style="opacity:1; display:none" src="img/fins/FCS4.png">  
                	 <img id="FCS5" class="img-responsive fcs" style="opacity:1; display:none" src="img/fins/FCS5.png">  
                	 <img id="Future3" class="img-responsive future" style="opacity:1; display:none" src="img/fins/future3.png">  
                	 <img id="Future4" class="img-responsive future" style="opacity:1; display:none" src="img/fins/future4.png">  
                	 <img id="Future5" class="img-responsive future" style="opacity:1; display:none" src="img/fins/future5.png">               	 
                	 <div><span style="font-style: oblique">Bottom</span></div>             	 
                </div>  
                              
                <div class="col-sm-3 pull-right wow fadeInRightBig">
                     <img id="front" class="img-responsive" style="opacity:0.7" src="img/board/poly-front.png" alt="">
                     <img id="brand" class="img-responsive s1" src="/Surf${brandbean.pic}" style="display:none">
                	 <img id="model" class="img-responsive s1" src="/Surf${model.pic}" style="display:none">
                     <div><span style="font-style: oblique">Deck</span></div>                                                    	  
                </div>	
                								
                <div class="col-sm-5 wow fadeInLeftBig" data-animation-delay="200">
                	<img src="/Surf/${model.pic}">   
                    <h3 class="section-heading">${model.name}</h3>
					<div class="sub-title lead3"></div>
                  	       
                  	    <div class="panel-group" id="accordion"> 
                  	    
                  	    <!-- 材質 -->
                  	    
                  	       <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h2 class="panel-title">
                                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">材質 - Materials</a>
                                        </h2>
                                    </div>
                                    <div id="collapseOne" class="panel-collapse collapse">
                                        <div class="panel-body">
                                            <div class="row">
                                            	<div class="col-xs-6" style="text-align:center;">
                                            		<a class="texture" href="#" onclick="return false">
	                                            		<img id="poly" src="/Surf/img/materials/poly.png"/>	                                            		
                                            			<span style="font-style: oblique">Polyester</span>                                         			
                                            		</a>                                            		
                                            	</div>                                          	
                                            	<div class="col-xs-6" style="text-align:center;">
                                            		<a class="texture" href="#" onclick="return false">
		                                            	<img id="eps" src="/Surf/img/materials/EPS.png"/>
		                                            	<span style="font-style: oblique">EPS</span>	                                            	
	                                            	</a>	                                          	
                                            	</div>
                                            	<input id="materials" type="hidden"/>
                                            </div>
                                        </div>
                                    </div>
                           </div>
                           	
                  	    <!-- 尺寸 -->	      	      
                  	       <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h2 class="panel-title">
                                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">尺寸 - Dimension</a>
                                        </h2>
                                    </div>
                                    <div id="collapseTwo" class="panel-collapse collapse">
                                        <div class="panel-body">
                                             <p>
											   <label for="width" style="font-style: oblique">寬度:</label>
									   		   <input type="text" id="width" readonly style="border:0; font-weight:bold; max-width:100px;">
										   	 </p>
										    <div id="slider-width"></div>
						
											<p>
											   <label for="length" style="font-style: oblique">長度:</label>
											   <input type="text" id="length" readonly style="border:0; font-weight:bold; max-width:100px;">
											</p>
									 		<div id="slider-length"></div>				
										
											<p>
											   <label for="thick" style="font-style: oblique">厚度:</label>
											   <input type="text" id="thick" readonly style="border:0; font-weight:bold; max-width:100px;">
											</p>
											<div id="slider-thick"></div>
                                        </div>
                                    </div>
                           </div>
                           
                           <!--  尾舵系統 -->
                            <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h2 class="panel-title">
                                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseThree">尾舵系統 - Fins</a>
                                        </h2>
                                    </div>
                                    <div id="collapseThree" class="panel-collapse collapse">
                                        <div class="panel-body">
                                            <div class="row">
                                            	<div class="col-xs-6" style="text-align:center;">
                                            		<a class="texture" href="#" onclick="return false">
	                                            		<img id="future" src="/Surf/img/fins/Future.png"/>
		                                            	<br><span style="font-style: oblique">Future</span>
                                            		</a>                                            		
                                            	</div>                                          	
                                            	<div class="col-xs-6" style="text-align:center;">
                                            		<a class="texture" href="#" onclick="return false">
		                                            	<img id="fcs" src="/Surf/img/fins/FCS2.png"/>
		                                            	<br><span style="font-style: oblique">FCSII</span>                                            	
	                                            	</a>	                                          	
                                            	</div>
                                            	<input id="finsys" type="hidden"/>
                                            </div>
                                            <br>
                                            <div class="row">
	                                            	<div id="setup" class="widget" style="text-align: center">                                           	
	                                            		<h4 style="font-style: oblique">設定</h4>
														  <fieldset>												   
														    <label for="tri">3 Fins</label> <small></small>
														    <input type="radio" name="radio-1" id="tri" value="3"> <br>
														    <label for="quad">4 Fins</label>
														    <input type="radio" name="radio-1" id="quad" value="4"> <br>
														    <label for="five">5 Fins</label>
														    <input type="radio" name="radio-1" id="five" value="5"> <br>
														    <small>(+NT$1000)</small>
														  </fieldset>
	                                            	</div>
                                            </div>
                                            	<input id="fins" type="hidden"/>                                          
                                        </div>
                                    </div>
                           </div>
                           
                        <!-- Logo -->   
                           <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h2 class="panel-title">
                                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseFour">Logo</a>
                                        </h2>
                                    </div>
                                    <div id="collapseFour" class="panel-collapse collapse">
                                        <div class="panel-body">
                                        	<div class="row" style="margin:5px; text-align:center">
                                              <button id="s1" type="button" class="btn btn-default btn-circle" style="margin:10px;">1</button>
                                              <button id="s2" type="button" class="btn btn-default btn-circle" style="margin:10px;">2</button>                           
                           					</div>                                  
                                        </div>
                                    </div>
                           </div>	
                         <!-- 顏色 -->	                                                  
                           <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h2 class="panel-title">
                                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseFive">顏色 - color</a>
                                        </h2>
                                    </div>
                                    <div id="collapseFive" class="panel-collapse collapse">
                                        <div class="panel-body">
                                        	<div class="row" style="margin:5px; text-align:center">
                                             	<fieldset>
												    <label for="speed">選擇顏色</label>
												    <select name="color" id="color">
												      <option value="0, 0, 255">藍</option>
												      <option value="255, 0, 0">紅</option>
												      <option value="0, 255, 128">綠</option>
												      <option value="255, 255, 0">黃</option>
												    </select>
												</fieldset>
                           					</div>                                  
                                        </div>
                                    </div>
                           </div>
                           		                                                  
                  	  	</div>				
					 				              					   													  						                   							
					 <p><a class="btn btn-embossed btn-info" href="#" role="button">結帳</a></p>
					 					 
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
    <script src="slider/js/jquery-ui.min.js"></script>
	<script type="text/javascript">
	
	  jQuery(function($) {
		$(document).ready( function() {
		  $('.navbar-default').stickUp();	  
		});			
	  });
	  
	  //顏色
	        
      $('#color').change(function(){
    	  var canvas = document.createElement("canvas");
    	  var canvas2 = document.createElement("canvas");
          ctx = canvas.getContext("2d");
          ctx2 = canvas2.getContext("2d");
          
          image = document.getElementById("back");
    	  image2 = document.getElementById("front");

          ctx.drawImage(image,0,0);
          ctx2.drawImage(image2,0,0);

          var imgd = ctx.getImageData(0, 0, 128, 128);
          var imgd2 = ctx.getImageData(0, 0, 128, 128);
          pix = imgd.data;
          pix2 = imgd2.data;
    	  var uniqueColor= [];    	    
    	  
    	  for (var i = 0, n = pix.length; i <n; i += 4) {
    	      pix[i] = uniqueColor[0];   // Red component
    	      pix[i+1] = uniqueColor[1]; // Blue component
    	      pix[i+2] = uniqueColor[2]; // Green component
    	      //pix[i+3] is the transparency.
          }
    	  
    	  for (var j = 0, n = pix2.length; j <n; j += 4) {
    	      pix2[j] = uniqueColor[0];   // Red component
    	      pix2[j+1] = uniqueColor[1]; // Blue component
    	      pix2[j+2] = uniqueColor[2]; // Green component
    	      //pix[i+3] is the transparency.
          }

    	  ctx.putImageData(imgd, 0, 0);
    	  ctx2.putImageData(imgd2, 0, 0);	  
    	  image.src = canvas.toDataURL("image/png");  
      });
               			  	  
	  //logo
	  var model = $('#model');
	  var brand =$('#brand');
	  
	  $('#s1').click(function(){
		  model.css({
			  'position':'absolute',
			  'bottom':'150px',
			  'left':'70px',
		  });
		  brand.css({
			  'position':'absolute',
			  'top':'150px',
			  'left':'140px',			  
		  });
		  model.fadeIn();
		  brand.fadeIn();	  
	  });
	  
	  $('#s2').click(function(){
		  model.css({
			  'position':'absolute',
			  'bottom':'150px',
			  'left':'70px',
		  });
		  brand.css({
			  'position':'absolute',
			  'top':'590px',
			  'left':'110px',			  
		  });
		  model.fadeIn();
		  brand.fadeIn();	  
	  });
	  
	  //材質
	  $('#eps').click(function(){
		  $(this).css({			  
			  'border': '3px inset gray' 
		  });
		  $('#poly').css({			  
			  'border': 'none' 
		  });
		  $('#back').attr("src", "img/board/back.png");
		  $('#front').attr("src", "img/board/front.png");
		  $('#materials').val("EPS");
	  });
	  
	  $('#poly').click(function(){
		  $(this).css({			  
			  'border': '3px inset gray' 
		  });
		  $('#eps').css({			  
			  'border': 'none' 
		  });
		  $('#back').attr("src", "img/board/poly-back.png");
		  $('#front').attr("src", "img/board/poly-front.png");
		  $('#materials').val("Polyester");
	  });
	  
	  //尾舵
	  
	  var finsys = $('#finsys');
	  var setup = $('#setup');
	  
	  setup.hide();

	  $('#future').click(function(){	  
		  $('.fcs').hide();	
		  $(this).css({			  
			  'border': '3px inset gray' 
		  });
		  $('#fcs').css({			  
			  'border': 'none' 
		  });
		  setup.slideDown();
		  finsys.val('Future');
		  if(finsys.val().trim()!=""){			  
			  showFins();
		  }
	  });
	  
	  $('#fcs').click(function(){	  
		  $('.future').hide();
		  $(this).css({			  
			  'border': '3px inset gray' 
		  });
		  $('#future').css({			  
			  'border': 'none' 
		  });
		  setup.slideDown();
		  finsys.val('FCSII');
		  if(finsys.val().trim()!=""){		  
			  showFins();
		  }
	  });
	  
	  $(':radio').click(showFins); 
		  
	  function showFins(){		  
		  if(finsys.val()=='FCSII'){
			if($(':checked').val()==3){
				$('#FCS3').fadeIn();
				$('#FCS4').hide();
				$('#FCS5').hide();
			}else if($(':checked').val()==4){
				$('#FCS4').fadeIn();
				$('#FCS3').hide();
				$('#FCS5').hide();
			}else if($(':checked').val()==5){
				$('#FCS5').fadeIn();
				$('#FCS4').hide();
				$('#FCS3').hide();
			}	
		  }else{
			 if($(':checked').val()==3){
				$('#Future3').fadeIn();
				$('#Future4').hide();
				$('#Future5').hide();
			}else if($(':checked').val()==4){
				$('#Future4').fadeIn();
				$('#Future3').hide();
				$('#Future5').hide();
			}else if($(':checked').val()==5){
				$('#Future5').fadeIn();
				$('#Future4').hide();
				$('#Future3').hide();
			}	  		  
		  }
		}
	  
	    	  
	  //尺寸	  
	  function toFeet(n) {
		    return Math.floor(n / 12) + "'" + (n % 12) + '"';
	  }
	  
	  function toInch(n){	  
		  num = String(n).split('.')[0];
		  frac = String(n).split('.')[1];
		  
		  if (String(n).includes('.')){
			  switch(frac){ 	
			  	case "125":
					return (num +' 1/8"');
			  		break;
			  	case "25":
					return (num +' 1/4"');
			  		break;
			  	case "375":
					return (num +' 3/8"');
			  		break;
			  	case "5":
					return (num +' 1/2"');
			  		break;
			  	case "625":
					return (num +' 5/8"');
			  		break;
			  	case "75":
			  		return (num +' 3/4"');
			  		break;
			  	case "875":
			  		return (num +' 7/8"');
			  		break;	
			  }
		  }
		  else{
			  return n+'"';
		  }	  	  
	  }
  
	  $( "#slider-width" ).slider({
	        min: 60,
	        max: 76,
	        value: 65,
	        range: "max",
	        slide: function(event, ui) {				
	            $( "#width" ).val(toFeet(ui.value));
	        }
	    });
  	  $( "#width" ).val(toFeet($( "#slider-width" ).slider("value")));
  	  
	  $( "#slider-length" ).slider({
	        min: 18,
	        max: 20,
	        value: 19,
	        step: 1/8,
	        range: "max",
	        slide: function(event, ui) {		        	
 	            $( "#length" ).val(toInch(ui.value));                                    
	        }
	    });
   	 $( "#length" ).val(toInch($( "#slider-length" ).slider("value")));
	  
  	 $( "#slider-thick" ).slider({
	        min: 1,
	        max: 3,
	        value: 2,
	        step:1/8,
	        range: "max",
	        slide: function(event, ui) {				
	            $( "#thick" ).val(toInch(ui.value));
	        }
	    });
	  $( "#thick" ).val(toInch($( "#slider-thick" ).slider("value")));
   

  	   
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
