//展示区域高度
var  G_HEIGHT = $(window).height();
//展示区域宽度
var  G_WIDTH = $(window).width();
//数据刷新时间间隔 
var SHORT_INTERVAL_TIME = 5000;
var LONG_INTERVAL_TIME = 500000;

var Default_BackgroundColor='rgba(19, 74, 134, 0.6)';

//地图数据为空时默认颜色
var Map_Default_Color = "#b6e4f9";
//地图颜色可选数组
var Map_Legend_Color_Array = ["#eaca1e","#6eb5ee","#8fcaf3","#53a4ea"];
//柱图颜色可选数组
var Bar_Color_Array = ["#3495ea","#4b86b2","#8ab8c5","#eb8060","#f86a1e","#d14142"];
//线图颜色可选数组
var Line_Color_Array = ["#e24747","#3eb5d6","#95b371","#f9a931","#f86a1e","#d14142","#00a9ee","#7616e1","#d141cf"];
//饼图颜色可选数组
var Pie_Color_Array = Bar_Color_Array;

$(function(){
	$("#BIndexButton").bind("click",function(){
		window.location = path + "/rapast/datacenter/screen/v3.1/B/jsp/b_center.jsp";
	});
	$("#CIndexButton").bind("click",function(){
		window.location = path + "/rapast/datacenter/screen/v3.1/C/jsp/c_province.jsp";
	});
	$("#IndexButton").bind("click",function(){
		window.location = path + "/rapast/datacenter/screen/v3.1/index.jsp";
	});
	
	
	$(".timebox_button").click(function(){
	    $(".timebox_button>img").toggle();
	});
	$(".logo").mouseover(function(e){  
		$(".page_menu").show(); 
	});  
	$("#page_menuin").mouseleave(function(){
	    $(".page_menu").fadeOut();
	});
	
	//设置当前时间
	setInterval(function(){
		var date = getCurHourAndMinute().split("&&");
		$("#hour").html(date[0]);
		$("#minute").html(date[1]);
	},1000);
});

/**
 * 获取当前系统时间 yyy-MM-dd hh:mm:ss
 * @returns {String}
 */
function getNowFormatDate() {
    var date = new Date();
    var seperator1 = "-";
    var seperator2 = ":";
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    var hour = date.getHours();
    var minu = date.getMinutes();
    var sec = date.getSeconds();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    if(hour >= 0 && hour <= 9){
    	hour = "0" + hour;
    }
    if(minu >= 0 && minu <= 9){
    	minu = "0" + minu;
    }
    if(sec >= 0 && sec <= 9){
    	sec = "0" + sec;
    }
    var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
            + " " + hour + seperator2 + minu
            + seperator2 + sec;
    return currentdate;
} 
/**
 * 获取系统当前时间的小时和分
 */
function getCurHourAndMinute()
{
	 var date = new Date();
	 var seperator1 = "-";
	 var seperator2 = ":";
	 //var month = date.getMonth() + 1;
	 //var strDate = date.getDate();
	 var hour = date.getHours();
	 var minu = date.getMinutes();
	 //var sec = date.getSeconds();
	 if(hour >= 0 && hour <= 9){
	   hour = "0" + hour;
	 }
	 if(minu >= 0 && minu <= 9){
	   minu = "0" + minu;
	 }
	 return hour+"&&"+minu;
}
