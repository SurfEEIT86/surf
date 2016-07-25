<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Stylish Portfolio - Start Bootstrap Theme</title>

<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="css/stylish-portfolio.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">
<link
	href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700,300italic,400italic,700italic"
	rel="stylesheet" type="text/css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

	<!-- Navigation -->
	<a id="menu-toggle" href="#" class="btn btn-dark btn-lg toggle"><i
		class="fa fa-bars"></i></a>
	<nav id="sidebar-wrapper">
	<ul class="sidebar-nav">
		<a id="menu-close" href="#"
			class="btn btn-light btn-lg pull-right toggle"><i
			class="fa fa-times"></i></a>
		<li class="sidebar-brand"><a href="#top" onclick=$("#menu-close").click();>登入</a>
		</li>
		<li><a href="#top" onclick=$("#menu-close").click();>首頁</a></li>
		<li><a href="#about" onclick=$("#menu-close").click();>浪點</a></li>

		<li><a href="#portfolio" onclick=$("#menu-close").click();>美食</a>
		</li>
		<li><a href="#shop" onclick=$("#menu-close").click();>店家</a></li>
	</ul>
	</nav>

	<!-- Header -->
	<header id="top" class="header">

	<div class="text-vertical-center">

		<h1>聚浪幫您找尋最適合的衝浪天堂</h1>

		<form id="search" action='http://www.google.com/search'
			target="_blank" style="display: inline;" method="get">
			<input type="hidden" name="sitesearch" value="網址" /> <input
				onfocus="if(this.value==this.defaultValue)this.value='';"
				value="尋找專屬浪點..." type="text" class="form-control" />
		</form>


	</div>

	</header>

	<section id="about">
	<div class="container">
		<div class="row">
			<div class="col-lg-24 text-center">
				<h1 class="section-heading">熱門目的地</h1>
			</div>
		</div>
		<div class="row text-center">

			<c:forEach var="siteVO" items="${sitesList}">
				<div class="col-md-4">
					<a href='showSiteData?SiteNo=${siteVO.siteno}'><img
						class="img-portfolio img-responsive"
						src="SiteImg?SiteNo=${siteVO.siteno}"> </a> <a
						href='showSiteData?SiteNo=${siteVO.siteno}'>${siteVO.name}</a>
				</div>
			</c:forEach>

		</div>
	</div>

	<div class="col-lg-12 text-center">
		<!-- About -->


		<!--熱門浪點-->


	</div>
	</div>
	<!-- /.row -->
	</div>
	<!-- /.container --> </section>




	<!-- Portfolio -->
	<section id="portfolio" class="portfolio">
	<div class="container">
		<div class="row">
			<div class="col-lg-10 col-lg-offset-1 text-center">
				<h2>美食</h2>
				<hr class="small">
				<div class="row">

					<c:forEach var="ShopsVO" items="${shopList}">
						<div class="col-md-6">

							<a href="showShopData?ShopNo=${ShopsVO.shopno}"> <img
								class="img-portfolio img-responsive"
								src="ShopImg?ShopNo=${ShopsVO.shopno}">
							</a><a href='showShopData?ShopNo=${ShopsVO.shopno}'>${ShopsVO.name}</a>

						</div>
					</c:forEach>

				</div>
			</div>
			<!-- /.row (nested) -->


		</div>
		<!-- /.col-lg-10 -->
	</div>
	<!-- /.row -->
	</div>
	<!-- /.container --> </section>
	<!-- Weather -->
	<section id="shop" class="shop">
	<div class="container">
		<div class="row">
			<div class="col-lg-10 col-lg-offset-1 text-center">
				<h2>店家</h2>
				<hr class="small">
				<div class="row">
					<c:forEach var="ShopsVO" items="${shopList}">
						<div class="col-md-6">

							<a href="showShopData?ShopNo=${ShopsVO.shopno}"> <img
								class="img-portfolio img-responsive"
								src="ShopImg?ShopNo=${ShopsVO.shopno}">
							</a><a href='showShopData?ShopNo=${ShopsVO.shopno}'>${ShopsVO.name}</a>

						</div>
					</c:forEach>
				</div>
			</div>
			<!-- /.row (nested) -->

		</div>
		<!-- /.col-lg-10 -->
	</div>
	<!-- /.row -->
	</div>
	<!-- /.container --> <!-- Footer --> <footer>
	<div class="container">
		<div class="row">
			<div class="col-lg-10 col-lg-offset-1 text-center">
				<h4>
					<strong>Start Bootstrap</strong>
				</h4>
				<p>
					3481 Melrose Place <br>Beverly Hills, CA 90210
				</p>
				<ul class="list-unstyled">
					<li><i class="fa fa-phone fa-fw"></i> (123) 456-7890</li>
					<li><i class="fa fa-envelope-o fa-fw"></i> <a
						href="mailto:name@example.com">name@example.com</a></li>
				</ul>
				<br>
				<ul class="list-inline">
					<li><a href="#"><i class="fa fa-facebook fa-fw fa-3x"></i></a>
					</li>
					<li><a href="#"><i class="fa fa-twitter fa-fw fa-3x"></i></a>
					</li>
					<li><a href="#"><i class="fa fa-dribbble fa-fw fa-3x"></i></a>
					</li>
				</ul>
				<hr class="small">
				<p class="text-muted">Copyright &copy; Your Website 2014</p>
			</div>
		</div>
	</div>
	<a id="to-top" href="#top" class="btn btn-dark btn-lg"><i
		class="fa fa-chevron-up fa-fw fa-1x"></i></a> </footer> <!-- jQuery --> <script
		src="js/jquery.js"></script> <!-- Bootstrap Core JavaScript --> <script
		src="js/bootstrap.min.js"></script> <!-- Custom Theme JavaScript --> <script>
    // Closes the sidebar menu
    $("#menu-close").click(function(e) {
        e.preventDefault();
        $("#sidebar-wrapper").toggleClass("active");
    });
    // Opens the sidebar menu
    $("#menu-toggle").click(function(e) {
        e.preventDefault();
        $("#sidebar-wrapper").toggleClass("active");
    });
    // Scrolls to the selected menu item on the page
    $(function() {
        $('a[href*=#]:not([href=#])').click(function() {
            if (location.pathname.replace(/^\//, '') == this.pathname.replace(/^\//, '') || location.hostname == this.hostname) {
                var target = $(this.hash);
                target = target.length ? target : $('[name=' + this.hash.slice(1) + ']');
                if (target.length) {
                    $('html,body').animate({
                        scrollTop: target.offset().top
                    }, 1000);
                    return false;
                }
            }
        });
    });
    //#to-top button appears after scrolling
    var fixed = false;
    $(document).scroll(function() {
        if ($(this).scrollTop() > 250) {
            if (!fixed) {
                fixed = true;
                // $('#to-top').css({position:'fixed', display:'block'});
                $('#to-top').show("slow", function() {
                    $('#to-top').css({
                        position: 'fixed',
                        display: 'block'
                    });
                });
            }
        } else {
            if (fixed) {
                fixed = false;
                $('#to-top').hide("slow", function() {
                    $('#to-top').css({
                        display: 'none'
                    });
                });
            }
        }
    });
    // Disable Google Maps scrolling
    // See http://stackoverflow.com/a/25904582/1607849
    // Disable scroll zooming and bind back the click event
    var onMapMouseleaveHandler = function(event) {
        var that = $(this);
        that.on('click', onMapClickHandler);
        that.off('mouseleave', onMapMouseleaveHandler);
        that.find('iframe').css("pointer-events", "none");
    }
    var onMapClickHandler = function(event) {
            var that = $(this);
            // Disable the click handler until the user leaves the map area
            that.off('click', onMapClickHandler);
            // Enable scrolling zoom
            that.find('iframe').css("pointer-events", "auto");
            // Handle the mouse leave event
            that.on('mouseleave', onMapMouseleaveHandler);
        }
        // Enable map zooming with mouse scroll when the user clicks the map
    $('.map').on('click', onMapClickHandler);
    </script>
</body>

</html>
