<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			<a href="index.html" class="logo">
				<img src="images/logo.svg" alt="聚浪">
				<h1>聚浪</h1>
			</a>	
		</div>
	</header>

	
	
  </head>
  	<script>
		function initMap() {
		  var infowindow = new google.maps.InfoWindow();
		  var service = new google.maps.places.PlacesService(map);
		
		  service.getDetails({
		    placeId: '${place_id}'
		  }, function(place, status) {
		    if (status === google.maps.places.PlacesServiceStatus.OK) {
		    	var map = new google.maps.Map(document.getElementById('map'), {
				    center: {lat: place.geometry.location.lat(), lng: place.geometry.location.lng()},
				    zoom: 15
				  });
		    	var lat=place.geometry.location.lat();
				  var lon=place.geometry.location.lng();
				  var myLatLng = {lat: lat, lng: lon};
					var markers= new google.maps.Marker({
				    position: myLatLng,
				    map: map,
				    title:place.name
				  });
		      	var shopName=document.getElementById('shopName');
		      	shopName.innerText=place.name;
		      	var address=document.getElementById('address');
		      	address.innerHTML="<i class='fa fa-map-marker'></i>"+" "+place.formatted_address;
		      	var tel=document.getElementById('tel');
		      	tel.innerHTML="<i class='fa fa-phone'></i>"+" "+place.international_phone_number;
// 		      	var open=document.getElementById('open');
// 		      	open.innerHTML="<i class='fa fa-clock-o'></i>"+" "+place.opening_hours.weekday_text[0];
		      	var img=document.getElementById('pic');
		      	var imgSrc=place.photos[0].getUrl({

		      		maxWidth: 320,
		      	});
		      	img.src=imgSrc;
		    }
		  });
		}
    </script>
    
    
    <div class="gmap">
<!-- 		<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d7239.848429137453!2d121.83258367512298!3d24.866437836204284!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3467f712798bb8bf%3A0x43f941250a72bf3f!2z54OP55-z5ryB5riv!5e0!3m2!1szh-TW!2stw!4v1469954248806" width="100%" height="250" frameborder="0" style="border:0" allowfullscreen></iframe> -->
		<div id="map" style="width:100%;height:370px;"></div>
	</div>

	<section class="shop-wrap shop-dt-wrap">
	
		<div class="container">
			<div class="row">
				<div class="col-sm-12">
					<h1 class="big-title" id="shopName"></h1>
				</div>
				<div class="col-sm-5">
					<img id="pic" width="100%">
				</div>
				<div class="col-sm-7">
					<div class="inner">
						<div class="text-wrap">
							<div class="area" id="address"> <i class="fa fa-map-marker"></i>  </div>
							<div class="area" id="tel"> <i class="fa fa-phone"></i>  </div>
							<div class="area" id="open"> <i class="fa fa-clock-o"></i> </div>
						</div>	
					</div>
					<div class="text-right">
						<br>
						
						<a href="#" onClick="history.back()" class="btn">回上一頁</a>
					</div>	
				</div>

			</div>
			
		</div>
		
	</section>
		<script
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCbWLbyJ23RHTaz95zCrIclvbxpE6IMmHQ&signed_in=true&libraries=places&callback=initMap" async defer></script>

</body>
</html>