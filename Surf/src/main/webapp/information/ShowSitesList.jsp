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
			<a href="../members/index.jsp" class="logo pull-left">
				<img src="images/logo.svg" alt="聚浪">
				<h1>聚浪</h1>
			</a>	
			<div class="search-wrap pull-right">
				<form action="SearchSitesOrCity" method="get">
				<input type="search" name="sitesearch">
				<button type="submit"><i class="fa fa-search" ></i></button>
				</form>
			</div>
		</div>
	</header>


	<section class="home-info-ls">
		<div class="container">
			<div class="row">
				<div class="col-sm-4">
					<div id="map" style="width:370px;height:370px;"></div>
					
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
			    radius: 10000,
			    types: ['lodging']
			  }, callback);
		}
		   function callback(results, status) {
			  if (status === google.maps.places.PlacesServiceStatus.OK) {
			    for (var i = 0; i < results.length; i++) {
			      	var shopName=results[i].name
			      	var imgSrc=results[i].photos[0].getUrl({
			      	    maxWidth: 320
			      	});
// 			      	var id=results[i].id;
// 			      	console.log(imgSrc);
// 			      	var div=document.getElementById('lodging');
// 			      	var div6=document.createElement("div");
// 			      	var a1=document.createElement("a");
// 			      	a1.href=id;
// 			      	div.className="col-md-6";
// 			      	var img=document.createElement("img");
			      	
// 			      	var aP=document.createElement("a");
// 			      	aP.href=id;
// 			      	aP.innerText=shopName;
			      	
			      	
// 			      	img.src=imgSrc;
// 			      	img.alt=shopName;
// 			      	a1.appendChild(img);
// 			      	div6.appendChild(a1);
// 			      	div.appendChild(aP);
// 			      	div.appendChild(div6);
			    }
			  }
			}
    </script>
    
		<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCbWLbyJ23RHTaz95zCrIclvbxpE6IMmHQ&signed_in=true&libraries=places&callback=initMap" async defer></script>
		<script type="text/javascript" scr="http://maps.google.com/maps/api/js?sensor=false&callback=get_longlat"></script>
				<div class="col-sm-8">
					<h1 class="big-title">搜尋結果：${SearchKey}</h1>
					<div class="inner">
						<ul class="info-list info-list2 clearfix">
							<c:forEach items="${SiteVO}" var="siteVO" varStatus="var">
								<li>
									<a href="SearchSitesOrCity?sitesearch=${siteVO.name}" class="clearfix">
										<div class="img-wrap">
											<img src="SiteImg?SiteNo=${siteVO.siteno}">	
										</div>
										<div class="text-wrap">
											<h2>${siteVO.name}</h2>
											<div class="area"> <i class="fa fa-map-marker"></i>${cityNameList[var.index]}</div>	
											<div class="deco">
												${siteVO.description}
											</div>
										</div>
									</a>
								</li>
							</c:forEach>
						</ul>		
					</div>
					<div class="text-right">
						<a href="#" onClick="history.back()" class="btn">回上一頁</a>
					</div>
				</div>
			</div>
			
		</div>
	</section>

</body>
</html>
