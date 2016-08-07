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
			<a href="../members/index.jsp" class="logo">
				<img src="images/logo.svg" alt="聚浪">
				<h1>聚浪</h1>
			</a>	
		</div>
	</header>
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
// 		      	var imgSrc=place.photos[0].getUrl({

// 		      		maxWidth: 320,
// 		      	});
// 		      	img.src=imgSrc;
		      	for(var i=0;i<5;i++){
		      		if(i==0){
			      		var imgSrc=place.photos[i].getUrl({
	
				      		maxWidth: 320,
				      	});
			      		img.src=imgSrc;
		      		}

			      var img2=document.getElementById("pic"+(i+1));
			      img2.src=place.photos[i].getUrl({
				      maxWidth: 320,
				  });
		      	
		      	}
		    }
		  });
		}
    </script>
    <script
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCbWLbyJ23RHTaz95zCrIclvbxpE6IMmHQ&signed_in=true&libraries=places&callback=initMap" async defer></script>
	<div class="gmap">
		<div id="map" style="width:100%;height:370px;"></div>
	</div>
	<script src="../forums/js/jquery-2.2.4.js" type="text/javascript"></script>
	<script type="text/javascript">
		$(function(){
			$('#tumb>a>img').click(function(){
				var imgLittle=$(this);
				var temp=imgLittle.attr('src');
				var bigPic=$('#pic').attr('src');
				$('#pic').attr('src',temp);
				
			})
		})
	</script>

	<section class="shop-wrap shop-dt-wrap">
		<div class="container">
			<div class="row">
				<div class="col-sm-12">
					<h1 class="big-title" id="shopName"></h1>
				</div>
				<div class="col-sm-5">
					<div class="img-wrap"><div class="td"><img id="pic"></div></div>
					<!-- <div class="row dt-album">
						<img id="pic" width="100%">
						
					</div> -->
				</div>
				<div class="col-sm-7">
					<div class="inner">
						<div class="text-wrap">
							<div class="area" id="address"></div>
							<div class="area" id="tel"></div>
<!-- 							<div class="area"> <i class="fa fa-clock-o"></i> 09:00~23:00 </div> -->
						</div>	
					</div>
					<div class="tumb" id="tumb">
						<a href="javascript:;"><img id="pic1" width="100%"></a>
						<a href="javascript:;"><img id="pic2" width="100%"></a>
						<a href="javascript:;"><img id="pic3" width="100%"></a>
						<a href="javascript:;"><img id="pic4" width="100%"></a>
						<a href="javascript:;"><img id="pic5" width="100%"></a>
					</div>
					<div class="text-right">
						<br>
						<a href="#" onClick="history.back()" class="btn">回上一頁</a>
					</div>	
				</div>

			</div>
			
		</div>
	</section>

</body>
</html>