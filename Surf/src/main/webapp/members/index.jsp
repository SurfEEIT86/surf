<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>聚浪</title>
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
		<link href="css/home.css" rel="stylesheet" />
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
                            <a href="../information/index-surf.jsp" title="浪點">
                                <img src="css/images/ac1.png" width="70" height="70" style="margin-right:20px;"/>
                            </a>
                            <a href="../forums/forums.jsp" title="討論">
                                <img src="css/images/ac2.png" width="70" height="70" style="margin-right:20px;"/>
                            </a>
                            <a href="/Surf/Types.jsp" title="購物">
                                <img src="css/images/ac3.png" width="70" height="70" style="margin-right:20px;"/>
                            </a>
                            <c:if test="${empty user}">
                            <a id="menuToggle" title="登入">
                                <img src="css/images/ac4.png" width="70" height="70" style="margin-right:20px;"/>
                            </a>
                            </c:if>
                            <c:if test="${not empty user}">
                            <a id="logout" href="../secure/login.do" title="登出">
                                <img src="css/images/sign-out-option.png" width="70" height="70" style="margin-right:20px;"/>
                            </a>
                            </c:if>
                            <c:if test="${empty user}">
                            <a href="register.jsp" id="register" title="註冊">
                                <img src="css/images/ac5.png" width="70" height="70" style="margin-right:20px;"/>
                            </a>
                            </c:if>
                            <c:if test="${not empty user}">
                            <a href="ShowMemberData" id="updaateMember" title="修改資料">
                                <img src="css/images/nsjadnsa.png" width="70" height="70" style="margin-right:20px;"/>
                            </a>
                            </c:if>
						</ul>
					</nav>

					</header>

                <!-- Menu 左邊工具列-->
			<nav class="menu" id="theMenu">
			<div class="menu-wrap">
				<br />
				<div id="menu">
					<form action="<c:url value='../secure/login.do' />" method="post">
						<img src="css/images/ac7.png" style="margin-left: 150px"
							width="10" height="10" button type="button" id="menuToggle" />
						<h3 class="title">會員登入</h3>
						<h3>帳號</h3>
						<input type="text" class="form-control" name="username"
							value="${param.username}">
						<h3>密碼</h3>
						<input type="password" class="form-control" name="password"
							value="${param.password}">
						<input type="submit" class="btn" value="確定" />
					</form>
				</div>
			</div>
			</nav>
			<!-- Footer -->
					<footer id="footer">
						<span class="copyright">&copy; Untitled. Design: <a href="http://html5up.net">HTML5 UP</a>.</span>
					</footer>
                <script src="js/classie.js"></script>
                <script src="js/bootstrap.min.js"></script>
                <script src="js/smoothscroll.js"></script>
                <script src="js/main.js"></script>
                <script src="js/jquery.cslider.js"></script>
                
			</div>
		</div>
	</body>
</html>
