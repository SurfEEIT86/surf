<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Aerial by HTML5 UP</title>
<meta name="description" content="" />
		<meta name="keywords" content="" />
        <link href="css/bootstrap.min.css" rel="stylesheet" />
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>

		<!--[if lte IE 8]><script src="css/ie/html5shiv.js"></script><![endif]-->
		<script src="js/skel.min.js"></script>
		<script src="js/init.js"></script>
        <script src="js/jquery.min.js"></script>
        <script src="js/Chart.js"></script>
		<noscript>
			<link rel="stylesheet" href="css/skel.css" />
			<link rel="stylesheet" href="css/style.css" />
            <link rel="stylesheet" href="css/style3.css" />
			<link rel="stylesheet" href="css/style-wide.css" />
			<link rel="stylesheet" href="css/style-noscript.css" />
		</noscript>
		<!--[if lte IE 9]><link rel="stylesheet" href="css/ie/v9.css" /><![endif]-->
		<!--[if lte IE 8]><link rel="stylesheet" href="css/ie/v8.css" /><![endif]-->

        <style>
            h3 {
            margin-top:8px;
            }

        </style>
</head>
<body class="loading">
		<div id="wrapper">
			<div id="bg"></div>
			<div id="overlay"></div>
			<div id="main">

				<!-- Header -->
                
					<header id="header">

					<h1> 聚 浪 </h1>
					<p>Security Chief &nbsp;&bull;&nbsp; Cyborg &nbsp;&bull;&nbsp; Never asked for this</p>
					<nav>
						<ul style="margin:auto">
                            <a href="https://www.google.com.tw/" title="浪點">
                                <img src="css/images/ac1.png" width="70" height="70" style="margin-right:20px;"/>
                            </a>
                            <a href="../forums/forums.jsp" title="討論">
                                <img src="css/images/ac2.png" width="70" height="70" style="margin-right:20px;"/>
                            </a>
                            <a href="/Surf/Types.jsp" title="購物">
                                <img src="css/images/ac3.png" width="70" height="70" style="margin-right:20px;"/>
                            </a>
                            <a id="menuToggle" onClick="login()" title="登入">
                                <img src="css/images/ac4.png" width="70" height="70" style="margin-right:20px;"/>
                            </a>
                            <a id="register" title="註冊">
                                <img src="css/images/ac5.png" width="70" height="70" style="margin-right:20px;"/>
                            </a>
						</ul>
					</nav>

					</header>

                <!-- Menu 左邊工具列-->
                <nav class="menu" id="theMenu">
	                <div class="menu-wrap">
                        <br />
                        <div id="menu" style="margin-left:20px" >
                        <form action="<c:url value='../secure/login.do' />" method="post">
                            <img src="css/images/ac7.png" style="margin-left:150px" width="10" height="10" button type="button" id="menuToggle"/>
                            <h3 style="font-size:30px">會員登入</h3>
                            <h3>帳號</h3>
                            <input type="text" class="form-control" name="username" value="${param.username}" style="width:150px;height:30px;background-color:black;color:#FFFFFF">
                            <h3>密碼</h3>
                            <input type="password" class="form-control" name="password" value="${param.password}" style="width:150px;height:30px;background-color:black;color:#FFFFFF">
                       	<input type="submit" style="width:50px;height:30px;background-color:black" value="確定" />
                        </form>
                        </div>

	                  </div>
                      </div> 
	                <!-- Menu button -->
	                <div><i class="icon-reorder"></i></div>        
        
				</nav>
				<!-- Footer -->
					<footer id="footer">
						<span class="copyright">&copy; Untitled. Design: <a href="http://html5up.net">HTML5 UP</a>.</span>
					</footer>

				<script type="text/javascript">

				    $(function () {

						$('#da-slider').cslider({
						    autoplay: true,
						    bgincrement: 450
						});

					});
                    // 顯示登入
				    function login() {
						
				    }

                    //顯示註冊
				    function register() {
				        
				    }

				    function submit() {
				        if ($($('#menu h3')[0]).text() == '登入') {
                            console.log('123')
				        } else if ($($('#menu h3')[0]).text() == '註冊') {
                            console.log('456')
				        }
				    }

			    </script>
                <script src="js/classie.js"></script>
                <script src="js/bootstrap.min.js"></script>
                <script src="js/smoothscroll.js"></script>
                <script src="js/main.js"></script>
                <script src="js/jquery.cslider.js"></script>
                
			</div>
		</div>
	</body>
</html>