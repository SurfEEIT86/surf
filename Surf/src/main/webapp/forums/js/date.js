window.onload = function() {
	/* date */
	/* 新增年 */
	for (var year = 2010; year <= 2020; year++) {
		var option = document.createElement("option");
		option.innerHTML = "西元" + year + "年";
		option.value = year;

		document.getElementById("year").add(option);
	}
	/* 新增月 */
//	for (var month = 1; month <= 12; month++) {
//		var option = document.createElement("option");
//		option.innerHTML = month + "月";
//		option.value = (month - 1);
//		document.getElementById("month").add(option);
//	}
	/* 新增日 */
//	var year = parseInt(document.getElementById("year").value);
//	var month = parseInt(document.getElementById("month").value);
//	var maxday = new Date(year, month, "0");
//	maxday = maxday.getDate();
//
//	for (var day = 1; day <= maxday; day++) {
//		var option = document.createElement("option");
//		option.innerHTML = day + "日";
//		option.value = day;
//
//		document.getElementById("day").add(option);
//	}
//	var nowyear = document.getElementById("year").value;
//	var nowmonth = parseInt(document.getElementById("month").value) + 1;
//	var nowday = document.getElementById("day").value;

	document.getElementById("year").onchange = checkdate;
	document.getElementById("month").onchange = checkdate;
}
var yearOld
function checkdate() {
	/* 先刪除全部的天數 */
	var child = document.getElementById("day").childNodes;
	/* 新增月數 */
	for (var i = child.length - 1; i >= 0; i--) {
		document.getElementById("day").removeChild(child[i]);
	}
	/* 刪除月 */
	var year = document.getElementById("year").value;
	var mom = document.getElementById("month").value;
	if (parseInt(year) == -1) {
		var mom = document.getElementById("month");
		while (mom.hasChildNodes()) {
			mom.removeChild(mom.firstChild);
		}
		var option = document.createElement("option");
		option.innerHTML = "未選擇";
		option.value = -1;
		document.getElementById("month").add(option);
	} else if (parseInt(mom) == -1 || year != yearOld) {
		var mom = document.getElementById("month");
		while (mom.hasChildNodes()) {
			mom.removeChild(mom.firstChild);
		}
		var option = document.createElement("option");
		option.innerHTML = "未選擇";
		option.value = -1;
		option.selected = "selected";
		document.getElementById("month").add(option);
		for (var month = 1; month <= 12; month++) {
			var option = document.createElement("option");
			option.innerHTML = month + "月";
			option.value = (month - 1);
			document.getElementById("month").add(option);
		}
	}
	yearOld = document.getElementById("year").value;
	var year = parseInt(document.getElementById("year").value);
	var month = parseInt(document.getElementById("month").value);
	/* ex 2016,2,0 (mon範圍0~11)會被解析為2016/3/0=>2016/2/29 */
	var maxday;
	if (year == -1) {
		maxday = 0;
	} else {
		maxday = new Date(year, month + 1, "0");
		maxday = maxday.getDate();
	}
	if (parseInt(year) == -1 || parseInt(month) == -1) {
		var day = document.getElementById("day");
		while (day.hasChildNodes()) {
			day.removeChild(day.firstChild);
		}
		var option = document.createElement("option");
		option.innerHTML = "未選擇";
		option.value = -1;
		document.getElementById("day").add(option);

	} else {
		var option = document.createElement("option");
		option.innerHTML = "未選擇";
		option.value = -1;
		document.getElementById("day").add(option);
		for (var day = 1; day <= maxday; day++) {
			var option = document.createElement("option");
			option.innerHTML = day + "日";
			option.value = day;
			document.getElementById("day").add(option);
		}
	}
}
//function date1() {
//	var year = document.getElementById("year").value;
//	var month = parseInt(document.getElementById("month").value) + 1;
//	var day = document.getElementById("day").value;
//
//	if (parseInt(year) == -1 || parseInt(month) == 0) {
//		var node = document.getElementById('showdate');
//		while (node.hasChildNodes()) {
//			node.removeChild(node.firstChild);
//		}
//	}
//}