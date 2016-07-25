<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link rel="shortcut icon" href="assets/ico/favicon.png">

<title>聚浪</title>

<!-- Bootstrap core CSS -->
<link href="assets/css/bootstrap.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="assets/css/main.css" rel="stylesheet">
<link rel="stylesheet" href="assets/css/font-awesome.min.css">

<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/Chart.js"></script>

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="assets/js/html5shiv.js"></script>
      <script src="assets/js/respond.min.js"></script>
    <![endif]-->
</head>

<body data-spy="scroll" data-offset="0" data-target="#theMenu">

	<!-- Menu 左邊工具列-->
	<nav class="menu" id="theMenu">
	<div class="menu-wrap">
		<h1 class="logo">
			<a href="../index.jsp">聚浪</a>
		</h1>
		<a href="#home"
			class="smoothScroll">會員首頁</a> <a href="#services"
			class="smoothScroll">個人資料</a> 
<!-- 			<a href="#about" class="smoothScroll">訊息紀錄</a> -->
		<a href="#contact" class="smoothScroll">訂單紀錄</a> <a
			href="../index.jsp" class="smoothScroll">回到首頁</a>
	</div>

	<!-- Menu button -->
	<div id="menuToggle">
		<i class="icon-reorder"></i>
	</div>
	</nav>
<script type="text/javascript">
	$(function(){
		$('#update').click(function(){
			$('#displayMember').attr('style',"display:none");
			$('#updateMember').attr('style',"");
			$(window).scrollTo($('#services'))
		})
		$('#discard').click(function(){
			$('#updateMember').attr('style',"display:none");
			$('#displayMember').attr('style',"");
		})
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


	<!-- ========== 首頁========== -->
	<section id="home" name="home"></section>
	<div id="headerwrap">
		<div class="container">
			<br>
			<h1>聚浪</h1>
			<h2>個人資料</h2>
			<div class="row">
				<br> <br> <br>
				<div class="col-lg-6 col-lg-offset-3"></div>
			</div>
		</div>
		<!-- /container -->
	</div>
	<!-- /headerwrap -->


	<!-- ========== 個人資料========== -->
	<section id="services" name="services">
		<div class="container">
			<div class="base-box">
				<h3 class="section-title">個人資料</h3>
				<div id="displayMember" class="row">
					<div class="col-sm-3">
						<img src="/Surf/Service/forums/getMemberPhoto/${user.memberno}" width="100%" />
						<p class="text-center name">${user.username}</p>
					</div>
					<div class="col-sm-9">
						
						<p class="text-item">姓名：${user.name}</p>
						<p class="text-item">
							性別：
							<c:if test="${user.gender==1}">男</c:if>
							<c:if test="${user.gender==2}">女</c:if>
						</p>
						<p class="text-item">生日：${user.birthday}</p>
						<p class="text-item">地址：${user.address}</p>
						<p class="text-item">信箱：${user.email}</p>
						<p class="text-item">電話：${user.tel}</p>
						<p class="text-item">
							自我介紹：<br>
							${user.intro}
						</p>
						<button id="update" class="btn" value="修改">修改</button>
					</div>
					
					
				</div>
				<div id="updateMember" class="row" style="display: none">
					<form enctype="multipart/form-data" method="POST" action="<c:url value='../Register' />">
						<div class="col-sm-3">
							<div class="img-upload-wrap">
								<img id="userPic" src="/Surf/Service/forums/getMemberPhoto/${user.memberno}" width="100%" />
								<label class="file" title="">
	                                <input name="pic" type="file" onchange="this.parentNode.setAttribute('title', this.value.replace(/^.*[\\/]/, ''))" id="fileUpload">
	                            </label>	
							</div>
							<p class="text-center name">${user.username}</p>
						</div>
						<div class="col-sm-9">
							
							<p class="text-item">姓名：<input type="text" name="name" value="${user.name}"></p>
							<p class="text-item">地址：<input type="text" name="address" value="${user.address}"></p>
							<p class="text-item">信箱：<input type="text" name="email" value="${user.email}"></p>
							<p class="text-item">電話：<input type="text" name="tel" value="${user.tel}"></p>
							<p class="text-item">
								自我介紹：<br>
								<textarea  name="intro">${user.intro}</textarea>
							</p>
							<input id="submit" type="submit" class="btn" value="送出資料">
							<input id="discard" type="button" class="btn" value="放棄修改">
						</div>
						
					</form>
				</div>
			</div>
		</div>
	</section>
	

	<!-- ========== WHITE SECTION ========== -->
	<div id="slogan">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-lg-offset-2">
					<h3>
						WE WORK HARD TO DELIVER A
						<bold>HIGH QUALITY SERVICE</bold>
						. OUR AIM IS YOUR COMPLETE
						<bold>SATISFACTION</bold>
						.
					</h3>
				</div>
			</div>
		</div>
		<!-- /container -->
	</div>
	<!-- /w -->

	<!-- ========== 訊息紀錄 ========== -->
<!-- 	<section id="about" name="about"> -->
<!-- 		<div class="container"> -->
<!-- 			<div class="base-box"> -->
<!-- 				<h3 class="section-title">訊息紀錄</h3> -->
<!-- 				<div class="panel-group" id="accordion"> -->
<!-- 					<div class="panel panel-default" id="panel1"> -->
<!-- 						<div class="panel-heading"> -->
<!-- 							<h4 class="panel-title"> -->
<!-- 								<a data-toggle="collapse" href="#collapseOne">2016/07/12 -->
<!-- 									&nbsp 詹姆斯·加勒德 &nbsp wiki123 </a>  -->
<!-- 								<input id="AA" type="checkbox" value="1" name="Product_1" > -->
<!-- 								<label for="AA"><span><div></div></span></label> -->
<!-- 							</h4> -->
<!-- 						</div> -->
<!-- 						<div id="collapseOne" class="panel-collapse collapse in"> -->
<!-- 							<div class="panel-body">詹姆斯·加勒德（英語：James -->
<!-- 								Garrard，1749年1月14日－1822年1月19日 -->
<!-- 								）是一位曾於1796至1804年擔任第2任肯塔基州州長的農民兼浸信會牧師。1799年，肯塔基州通 -->
<!-- 								過新憲法規定州長不得連任，因此直到1992年該州通過憲法修正案放寬這一限制前，他都是僅有 -->
<!-- 								的一位獲得連任的州長。美國革命戰爭結束後，加勒特同家人向西行進，搬到了當時屬維吉尼亞 -->
<!-- 								州，如今已是肯塔基州波旁郡的地方。他在當地出任多份政治公職，並且是該地區在維吉尼亞州 -->
<!-- 								議會的代表。肯塔基州共計召開了10次建州大會，加勒德是其中5次的代表，幫助起草了第一部 -->
<!-- 								肯塔基州憲法。雖然自己就擁有許多奴隸，但他卻其他多位代表一起試圖從憲法中禁止奴隸制， -->
<!-- 								但沒能成功。1795年，加勒德出馬競選州長，選舉人的首輪投票結果是班傑明·洛根獲得多數票 -->
<!-- 								，但沒有超過總票數的一半。州憲法中雖然沒有明確規定需要多數還是過半數票勝出，但眾選舉 -->
<!-- 								人還是在首輪得票最多的洛根和加勒德兩位候選人之間舉行了第二輪投票，最終加勒德成功勝出 -->
<!-- 								，洛根對此向州檢察長約翰·布雷肯里奇和州參議院提出抗議，但兩者都表示自己沒有插手干預的 憲法權力。</div> -->
<!-- 							<br /> -->


<!-- 						</div> -->
<!-- 					</div> -->



<!-- 					<div class="panel panel-default" id="panel2"> -->
<!-- 						<div class="panel-heading"> -->
<!-- 							<h4 class="panel-title"> -->
<!-- 								<a data-toggle="collapse" href="#collapseTwo" -->
<!-- 									class="collapsed"> 1950/01/01 &nbsp 史密斯威森M36左輪手槍 &nbsp -->
<!-- 									wiki123 </a>  -->
<!-- 								<input id="AA2" type="checkbox" value="1" name="Product_1" > -->
<!-- 								<label for="AA2"><span><div></div></span></label> -->
<!-- 							</h4> -->
<!-- 						</div> -->
<!-- 						<div id="collapseTwo" class="panel-collapse collapse"> -->
<!-- 							<div class="panel-body">當二戰之後的時代，史密斯威森停止生產戰備物資，恢復正常生產模式時， -->
<!-- 								設計了M36。關於M36的設計概念，他們試圖設計一把尺寸短小而可輕易包裝隱藏的左輪手槍，發射 -->
<!-- 								火力相對而言更為強大的.38特種彈。因為舊式的「I型底把」無法承受該彈藥的裝藥量，因而設計 -->
<!-- 								了一個新型底把，這成為史密斯威森「J型底把」。1950年，該新型設計在警察局長的國際協會 -->
<!-- 								（IACP）會議推出，並受到好評。他倆還舉行一場表決為新型的左輪手槍命名，並且獲命名為「總 督察特種型」（Chiefs -->
<!-- 								Special）。[2]由於需求量大，這種設計的3英寸槍管版本隨即投產。該版 -->
<!-- 								本還可分別選用烤藍或是鍍光亮鎳兩種表面處理。[3]它以「總督察特種型」手槍之名生產，直到 -->
<!-- 								1957年，當它後來成為了M36。而「總督察特種型」則作為一個獨立的衍生型繼續生產。</div> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<div class="panel panel-default" id="panel3"> -->
<!-- 						<div class="panel-heading"> -->
<!-- 							<h4 class="panel-title"> -->
<!-- 								<a data-toggle="collapse" href="#collapseThree" -->
<!-- 									class="collapsed"> 1946/10/31 &nbsp 紅毛城 &nbsp wiki123 </a> -->
<!-- 								<input id="AA3" type="checkbox" value="1" name="Product_1" > -->
<!-- 								<label for="AA3"><span><div></div></span></label> -->
<!-- 							</h4> -->
<!-- 						</div> -->
<!-- 						<div id="collapseThree" class="panel-collapse collapse"> -->
<!-- 							<div class="panel-body">紅毛城（閩南語：Âng-mn̂g-siâⁿ），古稱安東尼堡，位於台灣新北市淡水區 -->
<!-- 								。最早建城是在1628年統治台灣北部的西班牙人所興建的聖多明哥城，但後來聖多明哥城遭到摧毀， -->
<!-- 								1644年荷蘭人於聖多明哥城原址附近予以重建，又命名為「聖安東尼堡」。而由於當時漢人稱呼荷蘭 -->
<!-- 								人為紅毛，因此這個城就被他們稱作紅毛城。1724年，臺灣府淡水補盜同知王汧開始整修紅毛城，增 -->
<!-- 								闢了四座外圍城門。1867年以後，紅毛城開始由英國政府租用，作為其英國領事館，並於其旁興建領 -->
<!-- 								事官邸。太平洋戰爭期間，日本向英美宣戰，並曾短暫查封紅毛城，但於戰後即被交還與英方。爾後 -->
<!-- 								，英國雖於1950年和中華民國斷交，但仍持續使用紅毛城作為其領事館直至1972年，並在其後依序由 -->
<!-- 								澳大利亞與美國代為管理。一直到1980年，該城的產權才轉到中華民國政府手中，指定為一級古蹟並 -->
<!-- 								開放供民眾參觀。紅毛城被視為台灣現存最古老的建築之一，也是中華民國內政部所頒訂的國定古蹟 -->
<!-- 								。紅毛城古蹟區包含紅毛城主堡、前英國領事官邸以及清治時期所建造的南門。其中紅毛城主堡是臺 -->
<!-- 								灣最古老的完整建築物，前方置有四尊嘉慶18年製成的古砲；前英國領事官邸在主堡東側，為兩層式 -->
<!-- 								洋樓；南門則為古蹟區內唯一的中國式建築，使用觀音石砌成。另外，園區內也有一座從山腳下移上 來的「D&C.1866 -->
<!-- 								寶順行」界碑。全園區由新北市政府淡水古蹟博物館負責營運。</div> -->
<!-- 						</div> -->

<!-- 					</div> -->

<!-- 					<button type="button" class="btn">刪除</button> -->

<!-- 				</div> -->
<!-- 				Post Info -->
<!-- 			</div> -->
<!-- 		</div> -->
<!-- 	</section> -->

	<!-- ========== FOOTER SECTION 訂單紀錄========== -->
	<section id="contact" name="contact">
		<div class="container">
			<h3 class="section-title">訂單紀錄</h3>

			<div class="divcss5-right">

				<table border="1" width="100%" class="order-ls-table">
					<tr>
						<th>訂單編號</th>
						<th>訂單時間</th>
						<th>商品狀態</th>
						<th>總計金額</th>
						<th>詳細內容</th>
					</tr>
				<c:forEach var="order" items="${orderList}">
					<tr class="toggle-dt">
						<td>${order.orderno}</td>
						<td>${order.datetime}</td>
						<td>${order.status}</td>
						<td>${order.totalprice}</td>
						<td><a href="MemberOrderDetail?orderNo=${order.orderno}" class="btn more-btn">查看</a></td>
					</tr>
				</c:forEach>
			</table>

			<div />	
		</div>
	</section>



					<!-- Bootstrap core JavaScript
    ================================================== -->
					<!-- Placed at the end of the document so the pages load faster -->
					<script src="assets/js/classie.js"></script>
					<script src="assets/js/bootstrap.min.js"></script>
					<script src="assets/js/smoothscroll.js"></script>
					<script src="assets/js/main.js"></script>
</body>
</html>
