<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh_TW">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>聚浪 - 討論區</title>
	
    <!-- Bootstrap Core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    
    <!-- Custom Style -->
    <link href="css/rico-style.css" rel="stylesheet">
    
    <!-- jQuery -->
    <script src="vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
    
    <!-- Custom script -->
    <script src="js/rico-script.js"></script>

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
	<style>	
	.figure-box { position: relative; display: inline-table;}
	.figure-box .figure-dropdown { 
		position: absolute;
		opacity: 0; 
		z-index: 10;
		background: rgba(255, 255, 255, 0.94);
		width:120px;
		left:-60px;
		margin-left:-60px;
		overflow: hidden;
		-webkit-transition: all 0.3s ease;
		-moz-transition: all 0.3s ease;
		-o-transition: all 0.3s ease;
		transition: all 0.3s ease;
		-webkit-box-shadow: 0 0 10px rgba(0, 0, 0, 0.32);
		-moz-box-shadow: 0 0 10px rgba(0, 0, 0, 0.32);
		-o-box-shadow: 0 0 10px rgba(0, 0, 0, 0.32);
		box-shadow: 0 0 10px rgba(0, 0, 0, 0.32);
		border-radius: 5px;
	}
	.figure-box:hover .figure-dropdown { 
		opacity: 1; 
		left:50%; 
	}
	.figure-dropdown .name { 
		font-size: 14px; 
		text-align: center; 
		overflow: hidden;  text-overflow: ellipsis;  white-space: nowrap;
		width:100%;
		padding: 3px 6px;
	}
	.figure-dropdown .follow-btn { 
		display: block; 
		padding: 3px 6px; 
		color:#fff; 
		text-decoration: none; 
		font-size: 12px; 
		text-align: center; 
	}
	.figure-dropdown .follow-btn:hover { opacity: .8; }
	.figure-dropdown .follow-btn.follow-f { background: #444; }
	.figure-dropdown .follow-btn.follow-t { background: red; }
	div.inline { float:left; }
</style>
</head>

<body>



<header class="topbar">
        
        <div class="ttop clearfix">
            <div class="container">
                <div class="top-l">
<!--                     <a href="#"><img src="" width="100%" alt=""></a> -->
                </div>
                <div class="top-r">
                    <a href="CreateArticle.jsp"><i class="fa fa-pencil"></i> 發佈</a>
                    <div class="username">
                        <div class="dropdown">
                          <button id="dLabel" type="button" data-toggle="dropdown" aria-haspopup="true" role="button" aria-expanded="false">
                            <span class="name">${user.name}, Hello !</span>
                            <span class="caret"></span>
                          </button>
                          <ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
                            <li><a href="TrackArticlesMng.jsp">文章追蹤</a></li>
                            <li><a href="ArticlesMng.jsp">文章管理</a></li>
                            <li><a href="login.do">登出</a></li>
                          </ul>
                        </div>
                        <img src="/Surf/Service/forums/getMemberPhoto/${user.memberno}" class="img-circle">
                    </div>
                </div>
            </div>
        </div>

    </header>