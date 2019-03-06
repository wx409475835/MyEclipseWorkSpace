//使用定时器设置显示时间
var t = null;
t = setTimeout(TimeShow, 1000);
function TimeShow() {
	clearTimeout(t); // 清楚定时器
	dt = new Date();
	var Y = dt.getFullYear(); // 获得年
	var M = dt.getMonth() + 1; // 获得月
	var D = dt.getDate(); // 获得日
	var d = dt.getDay(); // 用于判断周
	var week; // 用于获得星期
	var h = dt.getHours(); // 获取小时
	var m = dt.getMinutes(); // 获取分钟
	var s = dt.getSeconds(); // 获取秒
	var today;
	switch (d) {
	case 0:
		week = "星期日";
		break;
	case 1:
		week = "星期一";
		break;
	case 2:
		week = "星期二";
		break;
	case 3:
		week = "星期三";
		break;
	case 4:
		week = "星期四";
		break;
	case 5:
		week = "星期五";
		break;
	case 6:
		week = "星期六";
		break;
	}
	today = Y + "年" + M + "月" + D + "日 " + week + " " + h + ":" + m + ":" + s;
	document.getElementById("TimeShow").innerHTML = today;
	t = setTimeout(TimeShow, 1000);
}

