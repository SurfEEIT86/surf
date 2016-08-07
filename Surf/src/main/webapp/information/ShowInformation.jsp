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

	<section class="info-dt-wrap">
		<div class="container">
			
			<div class="row info-center">
				<div class="col-sm-4">
					<div class="top-pic">
						<img src="SiteImg?SiteNo=${SiteVO[0].siteno}" alt="">
					</div>	
				</div>
				<div class="col-sm-8">
					<div class="top-text">
						<h1>${SiteVO[0].name}</h1>
						<div class="area"> <i class="fa fa-map-marker"></i>${CityName}</div>	
					</div>
					<div class="deco">
						${SiteVO[0].description}
					</div>
				</div>
			</div>
			<div class="row info-center">
				<div class="gmap col-sm-6">
					<div id="map" style="width:500px;height:370px;"></div>
				</div>
				<script src="../forums/js/jquery-2.2.4.js" type="text/javascript"></script>
			<script>
						var map;
						var infowindow;
			function initMap() {
				var sitesLength= ${Length};
				var size;
				var la;
				var ln;
				var pyrmont ;
				if(sitesLength>1||sitesLength==0){
					size=7;
					pyrmont={lat: 23.753, lng: 121.004};
				}else if(sitesLength==1){
					size=15;
					la=${SiteVO[0].latitude};
					ln=${SiteVO[0].longitude};
					pyrmont={lat: la, lng: ln};
				}
			   map = new google.maps.Map(document.getElementById('map'), {
				    zoom: size,
				    center: pyrmont
			  });
			 
				<c:forEach items="${SiteVO}" var="Site" varStatus="status">
				  var lat=${Site.latitude};
				  var lon=${Site.longitude}
				  var myLatLng = {lat: lat, lng: lon};
					var markers= new google.maps.Marker({
				    position: myLatLng,
				    map: map,
				    title:'${Site.name}'
				  });
				</c:forEach>
				
				  infowindow = new google.maps.InfoWindow();
				  var service = new google.maps.places.PlacesService(map);
				  service.nearbySearch({
				    location: pyrmont,
				    radius: 15000,
				    types: ['lodging']
				  }, callbackLodaing);
				  var service = new google.maps.places.PlacesService(map);
				  service.nearbySearch({
				    location: pyrmont,
				    radius: 15000,
				    types: ['food']
				  }, callbackFood);
			}
			   function callbackLodaing(results, status) {
				  if (status === google.maps.places.PlacesServiceStatus.OK) {
				    for (var i = 0; i < 5; i++) {
				      	var shopName=results[i].name
				      	var imgSrc=results[i].photos[0].getUrl({
				      		maxWidth: 320,
				      	});
				      	var id=results[i].place_id;
				      	var ul=document.getElementById('loading');
				      	var li=document.createElement("li");
				      	var a=document.createElement("a");
				      	var div1=document.createElement("div");
				      	var div2=document.createElement("div");
				      	var div3=document.createElement("div");
				      	var img=document.createElement("img");
				      	var p=document.createElement("p");
				      	a.href="ShopDetail?id="+id;
				      	img.src=imgSrc;
				      	p.className="name";
				      	p.innerText=shopName;
				      	div1.className="img-wrap";
				      	div2.className="td";
				      	div3.className="text-wrap";
				      	div2.appendChild(img);
				      	div1.appendChild(div2);
				      	div3.appendChild(p);
				      	a.appendChild(div1);
				      	a.appendChild(div3);
				      	li.appendChild(a);
				      	ul.appendChild(li);
				    }
				    var div=document.getElementById('loading');
				    var li=document.createElement("li");
				    var a=document.createElement("a");
				    var img=document.createElement("img");
				    var p=document.createElement("p");
				    li.className="more";
				    a.href="showStoreList?site=${SiteVO[0].name}&type=lodging&la="+${SiteVO[0].latitude}+"&ln="+${SiteVO[0].longitude};
				    img.src="images/info01.jpg";
				    p.innerText="+ MORE";
				    a.appendChild(img);
			      	a.appendChild(p);
			      	li.appendChild(a);
			      	div.appendChild(li);
				  }
				}
			   function callbackFood(results, status) {
					  if (status === google.maps.places.PlacesServiceStatus.OK) {
					    for (var i = 0; i < 5; i++) {
					      	var shopName=results[i].name
					      	var imgSrc=results[i].photos[0].getUrl({

					      		maxWidth: 320,
					      	});
					      	var id=results[i].place_id;
					      	var ul=document.getElementById('food');
					      	var li=document.createElement("li");
					      	var a=document.createElement("a");
					      	var div1=document.createElement("div");
					      	var div2=document.createElement("div");
					      	var div3=document.createElement("div");
					      	var img=document.createElement("img");
					      	var p=document.createElement("p");
					      	a.href="ShopDetail?id="+id;
					      	img.src=imgSrc;
					      	p.className="name";
					      	p.innerText=shopName;
					      	div1.className="img-wrap";
					      	div2.className="td";
					      	div3.className="text-wrap";
					      	div2.appendChild(img);
					      	div1.appendChild(div2);
					      	div3.appendChild(p);
					      	a.appendChild(div1);
					      	a.appendChild(div3);
					      	li.appendChild(a);
					      	ul.appendChild(li);
					    }
					    var div=document.getElementById('food');
					    var li=document.createElement("li");
					    var a=document.createElement("a");
					    var img=document.createElement("img");
					    var p=document.createElement("p");
					    li.className="more";
					    a.href="showStoreList?site=${SiteVO[0].name}&type=food&la="+${SiteVO[0].latitude}+"&ln="+${SiteVO[0].longitude};
					    img.src="images/info01.jpg";
					    p.innerText="+ MORE";
					    a.appendChild(img);
				      	a.appendChild(p);
				      	li.appendChild(a);
				      	div.appendChild(li);
					  }
					}
    </script>
    	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCbWLbyJ23RHTaz95zCrIclvbxpE6IMmHQ&signed_in=true&libraries=places&callback=initMap" async defer></script>
		<script type="text/javascript" scr="http://maps.google.com/maps/api/js?sensor=false&callback=get_longlat"></script>
				<div class="col-sm-6">
					<link href="//www.surf-forecast.com/stylesheets/feed.css"
						media="screen" rel="stylesheet" type="text/css" />
					<div id="wf-weatherfeed">
						<iframe style="overflow: hidden; border: none;"
							allowtransparency="true" height="272" width="469"
							src="//www.surf-forecast.com/breaks/${SiteVO[0].seaArea}/forecasts/feed/a"
							scrolling="no" frameborder="0" marginwidth="0" marginheight="0">
							<p>Your browser does not support iframes.</p>
						</iframe>
						<div id="wf-link">
							<a href="http://www.surf-forecast.com/"><img
								alt="Surf Forecast"
								src="//www.surf-forecast.com/images/feed/surflogo-150.jpg" /></a>
							<p id="cmt">
								View detailed surf forecast for <a
									href="//www.surf-forecast.com/breaks/Barrels">Barrels</a>.
								Visit <a href="//www.surf-forecast.com/breaks/Barrels">surf-forecast.com</a>
								for more details, long range forecasts, surf reports, swell and
								weather maps.
							</p>
							<div style="clear: both;"></div>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12">
					<h3 class="sm-title">附近住宿</h3>
					<ul class="shop-pav-list clearfix" id="loading">
					</ul>	
				</div>
				<div class="col-sm-12">
					<h3 class="sm-title">附近美食</h3>
					<ul class="shop-pav-list clearfix" id="food">
				
					</ul>		
				</div>
				<div class="col-sm-12 text-center">
					<br><br>
					<a href="#" onClick="history.back()" class="btn">回上一頁</a>
				</div>
			</div>
		</div>
	</section>


</body>
</html>