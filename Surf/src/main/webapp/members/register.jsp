<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link rel="shortcut icon" href="assets/ico/favicon.png">

<title>Onassis - Bootstrap 3 Theme</title>

<!-- Bootstrap core CSS -->
<link href="Theme/assets/css/bootstrap.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="Theme/assets/css/main.css" rel="stylesheet">
<link rel="stylesheet" href="Theme/assets/css/font-awesome.min.css">

<script src="Theme/assets/js/jquery.min.js"></script>
<script src="Theme/assets/js/Chart.js"></script>

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="assets/js/html5shiv.js"></script>
      <script src="assets/js/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<script type="text/javascript">
	$(function(){
		document.getElementById("lastName").onkeyup = chkLastName;
	    document.getElementById("lastName").onblur = chkLastName;
		document.getElementById("firstName").onkeyup = chkFirstNameName;
	    document.getElementById("firstName").onblur = chkFirstNameName;
	    document.getElementById("C").onkeyup = chkId;
	    document.getElementById("C").onblur = chkId;
	    document.getElementById("password").onkeyup = chkPassword;
	    document.getElementById("password").onblur = chkPassword;
	    document.getElementById("password2").onblur = chkPassword2;
	    document.getElementById("email").onblur = chkEmail;
	    document.getElementById("birthday").onblur = chkDate;
	    document.getElementById("address").onblur = chkAddress;	    
	    document.getElementById("tel").onblur = chkTel;
// 	    document.getElementById("text").onblur = chkText;
	    
		function chkLastName() {
	        var name = document.getElementById("lastName").value;
	        var reg = /[^\u4E00-\u9FA5]/;
	        if (name.length == 0) {
	            document.getElementById("chklast").innerHTML = "<img src='Images/error.png' />不可為空白";
	        } else {  
	            if (!reg.test(name)) {
	                document.getElementById("chklast").innerHTML = "<img src='Images/check1.jpg' />";
	            } else {
	                document.getElementById("chklast").innerHTML = "<img src='Images/error.png' />請輸入中文字";
	            }
	        }
	    }
	    
	    function chkFirstNameName() {
	        var name = document.getElementById("firstName").value;
	        var reg = /[^\u4E00-\u9FA5]/;
	        if (name.length == 0) {
	            document.getElementById("chkfirst").innerHTML = "<img src='Images/error.png' />不可為空白";
	        } else {  
	            if (!reg.test(name)) {
	                document.getElementById("chkfirst").innerHTML = "<img src='Images/check1.jpg' />";
	            } else {
	                document.getElementById("chkfirst").innerHTML = "<img src='Images/error.png' />請輸入中文字";
	            }
	        }
	    }
	    
	    function chkId() {
	        var id = document.getElementById("C").value;
	        var reg = /^(?!.*[^a-zA-Z0-9])(?=.*\d)(?=.*[a-zA-Z]).{5,12}$/;
	        if (id.length == 0) {
	            document.getElementById("chkid").innerHTML = "<img src='Images/error.png' />不可為空白";
	        } else {  
	            if (reg.test(id)) {
	                document.getElementById("chkid").innerHTML = "<img src='Images/check1.jpg' />";
	            } else {
	                document.getElementById("chkid").innerHTML = "<img src='Images/error.png' />必須介於5~12字元，包含數字及英文且不包含中文";
	            }
	        }
	    }
	    function chkPassword() {
	        var psw = document.getElementById("password").value;
	        var noSpecialCharRegEx = /^[0-9a-zA-Z]+$/;
	        //注音+中文
	        var reg = /^.*[\u4e00-\u9fa5]+.*$/;
	        var reg2 = /^.*[\u3105-\u3129\u02CA\u02C7\u02CB\u02D9\u311A\u311B\u311C\u311D\u311E\u311F\u3120\u3121\u3122\u3123\u3124\u3125\u3126].*$/;
	        //flag1英文字母 flag2數字 flag3特殊字元 flag4中文字
	        var flag1 = false, flag2 = false, flag3 = false, flag4 = false;
	        if (psw.length == 0) {
	            //document.getElementById("labelname").style.color = "red";
	            document.getElementById("cpwd").innerHTML = "<img src='Images/error.png' />不可為空白";
	        } else if (!reg.test(psw) && !reg2.test(psw)) {
	            flag4 = true;
	            if (psw.length >= 6) {
	                for (i = 0; i < psw.length; i++) {
	                    var theChar = psw.substr(i, 1).toUpperCase();
	                    if (theChar >= "A" && theChar <= "Z") {
	                        flag1 = true;
	                    } else if (theChar >= "0" && theChar <= "9") {
	                        flag2 = true;
	                    } else if (!noSpecialCharRegEx.test(theChar)) {
	                        flag3 = true;
	                    }
	                    if (flag1 && flag2 && flag3) break;
	                }
	            } else {
	                document.getElementById("cpwd").innerHTML = "<img src='Images/error.png' />Password length<6";
	            }
	        } else {
	            document.getElementById("cpwd").innerHTML = "<img src='Images/error.png' />不能包含中文及注音";
	        }
	        if (psw.length >= 6) {
	            if (flag1 && flag2 && flag3 && flag4) {
	                document.getElementById("cpwd").innerHTML = "<img src='Images/check1.jpg' />";
	            }
	            else if (flag4) {

	                if (!flag1) {
	                    document.getElementById("cpwd").innerHTML = "<img src='Images/error.png' />須包含英文";
	                } else if (!flag2) {
	                    document.getElementById("cpwd").innerHTML = "<img src='Images/error.png' />須包含數字";
	                } else if (!flag3) {
	                    document.getElementById("cpwd").innerHTML = "<img src='Images/error.png' />須包含特殊字元";
	                }
	            }
	        }
	    }
	    function chkPassword2(){
	    	var pw2=document.getElementById("password2").value;
	    	var pw=document.getElementById("password").value;
	    	if(pw==pw2){
	    		document.getElementById("cpwd2").innerHTML = "<img src='Images/check1.jpg' />";
	    	}else{
	    		document.getElementById("cpwd2").innerHTML = "<img src='Images/error.png' />密碼不相符";
	    	}
	    }
	    function chkEmail(){
	    	var reg = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;	   
	    	var email=document.getElementById("email").value;
	    	if(reg.test(email)){
	    		document.getElementById("chkemail").innerHTML = "<img src='Images/check1.jpg' />";
	    	}else{
	    		document.getElementById("chkemail").innerHTML = "<img src='Images/error.png' />請符合email格式，例如:Surf@suft.com";
	    	}
	    }
	    
	    
		
	    function chkDate() {
	        var regDate = /^(\d{1,4})(\/)(\d{1,2})\2(\d{1,2})$/;
	        var date = document.getElementById("birthday").value;
	        if (regDate.test(date)) {
	            date.substring(0, date.indexOf("/"))
	            var day = new Date(date);
	            var year = date.substring(0, date.indexOf("/"));
	            var month = date.substring(date.indexOf("/") + 1, date.lastIndexOf("/"));
	            var dd = date.substring(date.lastIndexOf("/") + 1);
	            if (parseInt(year) == day.getFullYear() && parseInt(month) == day.getMonth() + 1 && parseInt(dd) == day.getDate()) {
	                document.getElementById("cdate").innerHTML = "<img src='Images/check1.jpg' />";
	            } else {
	                document.getElementById("cdate").innerHTML = "<img src='Images/error.png' />必須是有效日期";
	            }

	        } else {
	            document.getElementById("cdate").innerHTML = "<img src='Images/error.png' />必須符合格式";
	        }
	    }
		
	    function chkAddress(){
	    	var address=document.getElementById("address").value;
	    	if(address.length==0){
	    		document.getElementById("caddress").innerHTML = "<img src='Images/error.png' />不可為空白";
	    	}else{
	    		document.getElementById("caddress").innerHTML = "<img src='Images/check1.jpg' />";
	    	}
	    	
	    }
	    
	    function chkTel(){
	    	var reg=/^\d{8,}$/;
	    	var tel=document.getElementById("tel").value;
	    	if(reg.test(tel)){
	    		document.getElementById("ctel").innerHTML = "<img src='Images/check1.jpg' />";
	    	}else if(tel.length==0){
	    		document.getElementById("ctel").innerHTML = "<img src='Images/error.png' />不可為空白";
	    	}else if(tel.length<8){
	    		document.getElementById("ctel").innerHTML = "<img src='Images/error.png' />請符合電話號碼的長度";
	    	}else{
	    		document.getElementById("ctel").innerHTML = "<img src='Images/error.png' />請符合電話的格式，列如：0912345678";
	    	}
	    }
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
		$("#fileUpload").change(function(){
	        if (this.files && this.files[0]) {
	                var reader = new FileReader();
	                
	                reader.onload = function (e) {
	                        $('#userPic').attr('src', e.target.result);
	                }
	                
	                reader.readAsDataURL(this.files[0]);
	        }
	});
	})
</script>
	<section id="header">
		<div class="container">
			<a href="index.jsp" class="logo">
				<img src="Theme/assets/img/logo.svg" alt="聚浪">
				<h1>聚浪</h1>
			</a>
		</div>
	</section>

	<!-- ========== 個人資料========== -->
	<section id="services" name="services" class="register-wrap">
		<div class="container">
			<div class="base-box">
				<h3 class="section-title">會員註冊</h3>
				<div id="updateMember" class="row">
					<form enctype="multipart/form-data" method="POST" action="<c:url value='Register' />">
						<div class="col-sm-3">
							<div class="img-upload-wrap">
								<img id="userPic" src="Theme/assets/img/noimage.png" width="100%" />
								<label class="file" title="">
	                                <input id="fileUpload" type="file" name="pic" onchange="this.parentNode.setAttribute('title', this.value.replace(/^.*[\\/]/, ''))">
	                            </label>	
							</div>
						</div>
						<div class="col-sm-9">
							<dl class="text-item dl-horizontal" >
								<dt><label for="A">姓：</label></dt>
								<dd>
									<input id="lastName" name="lastName" id="A" type="text" /> 
									<span id="chklast" class="error"></span>
								</dd>
							</dl>
							<dl class="text-item dl-horizontal" >
								<dt><label for="B">名：</label></dt>
								<dd>
									<input id="firstName" id="firstName" name="firstName" id="B" type="text" /> 
									<span id="chkfirst" class="error"></span>
								</dd>
							</dl>
							<dl class="text-item dl-horizontal" >
								<dt><label for="C">使用者名稱：</label></dt>
								<dd>
									<input name="id" id="C" type="text" placeholder="此為登入帳號"/>
									<span id="chkid" class="error"></span>
								</dd>
							</dl>
							<dl class="text-item dl-horizontal" >
								<dt><label for="D">密碼：</label></dt>
								<dd>
									<input id="password" name="password" id="D" type="text" /> 
									<span id="cpwd" class="error"></span>
								</dd>
							</dl>
							<dl class="text-item dl-horizontal" >
								<dt><label for="E">確認密碼：</label></dt>
								<dd>
									<input id="password2" name="password2" id="E" type="text" /> 
									<span id="cpwd2" class="error"></span>
								</dd>
							</dl>
							<dl class="text-item dl-horizontal" >
								<dt>性別：</dt>
								<dd>
									<input id="gender1" name="gender" type="radio" value="1" >
									<label for="gender1"><span><div></div></span>男</label>

									<input id="gender2" name="gender" type="radio" value="2" >
									<label for="gender2"><span><div></div></span>女</label>
								</dd>
							</dl>
							<dl class="text-item dl-horizontal" >
								<dt><label for="F">E-mail：</label></dt>
								<dd>
									<input id="email" name="email" id="F" type="text" /> 
									<span id="chkemail" class="error"></span>
								</dd>
							</dl>
							<dl class="text-item dl-horizontal" >
								<dt><label for="G">出生日期：</label></dt>
								<dd>
									<input id="birthday" name="birthday" id="G" type="text" /> 
									<span id="cdate" class="error"></span>
								</dd>
							</dl>
							<dl class="text-item dl-horizontal" >
								<dt><label for="H">地址：</label></dt>
								<dd>
									<input id="address" name="address" id="H" type="text" />
									<span id="caddress" class="error"></span> 
								</dd>
							</dl>
							<dl class="text-item dl-horizontal" >
								<dt><label for="I">電話：</label></dt>
								<dd>
									<input id="tel" name="tel" id="I" type="text" /> 
									<span id="ctel" class="error"></span> 
								</dd>
							</dl>
							<dl class="text-item dl-horizontal" >
								<dt><label for="J">描述：</label></dt>
								<dd>
									<textarea id="text" type="text" name="intro" id="J"></textarea>
								</dd>
							</dl>
							<input id="submit" type="submit" class="btn" value="確定送出">
						</div>
						
					</form>
				</div>
			</div>
		</div>
	</section>

	<!-- footer -->
	<section id="footer">
		<div class="container">
			<p class="text-center">© G-surf Group</p>
		</div>
	</section>



					<!-- Bootstrap core JavaScript
    ================================================== -->
					<!-- Placed at the end of the document so the pages load faster -->
					<script src="Theme/assets/js/classie.js"></script>
					<script src="Theme/assets/js/bootstrap.min.js"></script>
					<script src="Theme/assets/js/smoothscroll.js"></script>
					<script src="Theme/assets/js/main.js"></script>
</body>
</html>
