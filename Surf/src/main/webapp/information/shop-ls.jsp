<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="chrome=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=0">
<meta name="keywords" content="">
<meta name="description" content="">
<title>聚浪</title>
<link rel="shortcut icon" type="image/x-icon" href="images/favicon.ico">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css" >
<link rel="stylesheet" type="text/css" href="css/style.css" />
<script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="js/custom.js"></script>
</head>

<body>

	<header>
		<div class="container">
			<a href="../members/index.jsp" class="logo">
				<img src="images/logo.svg" alt="聚浪">
				<h1>聚浪</h1>
			</a>	
		</div>
	</header>
	<div class="gmap">
		<div id="map" style="width:1400px;height:350px;"></div>
	</div>
	<div class="info-center">
				
			<script src="../forums/js/jquery-2.2.4.js" type="text/javascript"></script>
			<script>
						var service;
						var map;
						var infowindow;
			function initMap() {
				var sitesLength= 1;
				var size;
				var la;
				var ln;
				var pyrmont ;
				size=15;
				la=${la};
				ln=${ln};
				pyrmont={lat: la, lng: ln};
			   map = new google.maps.Map(document.getElementById('map'), {
				    zoom: size,
				    center: pyrmont
			  });
			 
				
				  var lat=${la};
				  var lon=${ln}
				  var myLatLng = {lat: lat, lng: lon};
					var markers= new google.maps.Marker({
				    position: myLatLng,
				    map: map,
				  });
				
				
				  infowindow = new google.maps.InfoWindow();
				  service = new google.maps.places.PlacesService(map);
				  service.nearbySearch({
				    location: pyrmont,
				    radius: 15000,
				    types: ['${type}']
				  }, callback);
			}
			   function callback(results, status) {
				  if (status === google.maps.places.PlacesServiceStatus.OK) {
				    for (var i = 0; i < results.length; i++) {
				      	var shopName=results[i].name
				      	var imgSrc=results[i].photos[0].getUrl({
				      		maxWidth: 320,
				      	});
				      	var id=results[i].place_id;
				      	var ul=document.getElementById('list');
				      	var li=document.createElement("li");
				      	var a=document.createElement("a");
				      	var divI1=document.createElement("div");
				      	divI1.className="img-wrap";
				      	var divI2=document.createElement("div");
				      	divI2.className="td";
				      	var img=document.createElement("img");
				      	
				      	var divh=document.createElement("div");
				      	divh.className="text-wrap";
				      	
				      	
				      	a.href='ShopDetail?id='+id;
				      	img.src=imgSrc;
				      	
				      	

						     
				      	divh.innerHTML="<h2>"+shopName+"</h2>"+"<div class='area'> <i class='fa fa-map-marker'></i> "+results[i].vicinity+"</div>";

				      	divI2.appendChild(img);
				      	divI1.appendChild(divI2);
				      	a.appendChild(divI1);
				      	a.appendChild(divh);
				      	li.appendChild(a);
				      	ul.appendChild(li);
				    }
				  }
				}
    </script>
    	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCbWLbyJ23RHTaz95zCrIclvbxpE6IMmHQ&signed_in=true&libraries=places&callback=initMap" async defer></script>
		<script type="text/javascript" scr="http://maps.google.com/maps/api/js?sensor=false&callback=get_longlat"></script>
	<section class="shop-wrap">
		<div class="container">
			<div class="row">
				<div class="col-sm-12">
					<h3 class="text-center big-title"><a  href="SearchSitesOrCity?sitesearch=${site}">${site}</a> - 附近${typeName}</h3>
					<ul class="info-list clearfix" id="list">
<!-- 						<li> -->
<!-- 							<a href="shop-dt.html" class="clearfix"> -->
<!-- 								<div class="img-wrap"> -->
<!-- 									<div class="td"><img src="images/info02.jpg"></div> -->
<!-- 								</div> -->
<!-- 								<div class="text-wrap"> -->
<!-- 									<h2>烏石港北堤衝浪民宿Wushih Surf Hostel</h2> -->
<!-- 									<div class="area"> <i class="fa fa-map-marker"></i> 261宜蘭縣頭城鎮港口路103號 </div> -->
<!-- 									<div class="area"> <i class="fa fa-phone"></i> 0988 004 800 </div> -->
<!-- 								</div> -->
<!-- 							</a> -->
<!-- 						</li> -->
					</ul>

					<div class="text-center">
						<br><br>
						<a href="#" onClick="history.back()" class="btn">回上一頁</a>
					</div>
				</div>
			</div>
		</div>
	</section>


</body>
</html>
