$(function(){
	getnowtime();
//	getLinkForIndex();//首页通道
//	getNewslistForNotice('6542ee711b584beab265dc4a5ed65618',10);//获取滚动公告
	getNewslistForZhiding('',9);//获取通知
	getNewslistForTongzhi('d05ff442c2e242fdbb98a0664deda708',4);//获取通知
	getNewslistForZonghang('a07eaa9bed9f41a79b84f427fc61e051',3);//获取总行工作
	getNewslistForZhongyao('7e0fd986a5904cc780657951dc57b214',3);//获取重要讲话
	getNewslistForZonghangyaowenByParentid('355db268a56f49a49f96abd977769071',7);//获取总行要闻
	getNewslistForBushidongtaiByParentid('ae6525efdadf4f9c8b0659fce6e4c795',7);//获取部室动态
	getSelectList();
	getNewslistForShijiuda('347c7d0f93ae4feea0abf4ead6b9f5bb',10);//获取十九大学习专栏
	getNewslistForJingzhong('8b4bec4083ae42dd94a091149da89bfe',10);//获取警钟长鸣
	getNewslistForRedian('5b6464cd663c4443bd2ea1abdb39eb38',6);//获取热点聚焦
	getNewslistForDangtuanjiansheByParentid('7c466e658310464c92f222b1e9d7b0df',7);//获取党团建设
	getNewslistForJicengfengcaiByParentid('ebb2b51008fc49b79a281f2234b6fb26',7);//获取基层风采
	getNewslistForHangyeguancaByParentid('23e7a3510f4a41d18cded1cf3bfdd670',7);//获取行业观察
	getNewslistForYuangongtiandiByParentid('2ea7bf0397104b6392a35a8023290023',7);//获取员工天地
	getadvlistIndex_1213();//获取横幅广告
	
	 
});
var sWeek = new Array("星期日","星期一","星期二","星期三","星期四","星期五","星期六");
var dNow = new Date();
var CalendarData=new Array(100);var madd=new Array(12);var tgString="甲乙丙丁戊己庚辛壬癸";var dzString="子丑寅卯辰巳午未申酉戌亥";var numString="一二三四五六七八九十";var monString="正二三四五六七八九十冬腊";var weekString="日一二三四五六";var sx="鼠牛虎兔龙蛇马羊猴鸡狗猪";var cYear,cMonth,cDay,TheDate;
CalendarData = new Array(        0xA4B,0x5164B,0x6A5,0x6D4,0x415B5,0x2B6,0x957,0x2092F,0x497,0x60C96,           0xD4A,0xEA5,0x50DA9,0x5AD,0x2B6,0x3126E, 0x92E,0x7192D,0xC95,0xD4A,            0x61B4A,0xB55,0x56A,0x4155B, 0x25D,0x92D,0x2192B,0xA95,0x71695,0x6CA,          0xB55,0x50AB5,0x4DA,0xA5B,0x30A57,0x52B,0x8152A,0xE95,0x6AA,0x615AA,           0xAB5,0x4B6,0x414AE,0xA57,0x526,0x31D26,0xD95,0x70B55,0x56A,0x96D,          0x5095D,0x4AD,0xA4D,0x41A4D,0xD25,0x81AA5, 0xB54,0xB6A,0x612DA,0x95B,
0x49B,0x41497,0xA4B,0xA164B, 0x6A5,0x6D4,0x615B4,0xAB6,0x957,0x5092F,
0x497,0x64B, 0x30D4A,0xEA5,0x80D65,0x5AC,0xAB6,0x5126D,0x92E,0xC96,          0x41A95,0xD4A,0xDA5,0x20B55,0x56A,0x7155B,0x25D,0x92D,0x5192B,0xA95,          0xB4A,0x416AA,0xAD5,0x90AB5,0x4BA,0xA5B, 0x60A57,0x52B,0xA93,0x40E95);
madd[0]=0;madd[1]=31;madd[2]=59;madd[3]=90;
madd[4]=120;madd[5]=151;madd[6]=181;madd[7]=212; 
madd[8]=243;madd[9]=273;madd[10]=304;madd[11]=334; 
function GetBit(m,n) { return (m>>n)&1; }
function e2c()
{ 
TheDate= (arguments.length!=3) ? new Date() : new Date(arguments[0],arguments[1],arguments[2]); 
var total,m,n,k; 
var isEnd=false; 
var tmp=TheDate.getFullYear(); 
total=(tmp-1921)*365+Math.floor((tmp-1921)/4)+madd[TheDate.getMonth()]+TheDate.getDate()-38; if (TheDate.getYear()%4==0&&TheDate.getMonth()>1) { total++;} for(m=0;;m++) {  k=(CalendarData[m]<0xfff)?11:12;  for(n=k;n>=0;n--)  {   if(total<=29+GetBit(CalendarData[m],n))   {    isEnd=true; break;   }   total=total-29-GetBit(CalendarData[m],n);  }  if(isEnd) break; } cYear=1921 + m; cMonth=k-n+1; cDay=total; if(k==12)  {  if(cMonth==Math.floor(CalendarData[m]/0x10000)+1) { cMonth=1-cMonth; }  if(cMonth>Math.floor(CalendarData[m]/0x10000)+1) { cMonth--; }  }}
function GetcDateString(){ var tmp=""; tmp+=tgString.charAt((cYear-4)%10); 
tmp+=dzString.charAt((cYear-4)%12); 
tmp+="年 "; 
if(cMonth<1) { tmp+="(闰)"; tmp+=monString.charAt(-cMonth-1); } else {tmp+=monString.charAt(cMonth-1);} tmp+="月"; tmp+=(cDay<11)?"初":((cDay<20)?"十":((cDay<30)?"廿":"三十")); 
if (cDay%10!=0||cDay==10) { tmp+=numString.charAt((cDay-1)%10); } return tmp;}

function GetLunarDay(solarYear,solarMonth,solarDay)
{
if (solarYear<1921 || solarYear>2020) {     return ""; 
}    else    {     solarMonth = (parseInt(solarMonth)>0) ? (solarMonth-1) : 11;     e2c(solarYear,solarMonth,solarDay); return GetcDateString();    }}
var D=new Date(); 
var yy=D.getFullYear(); 
var mm=D.getMonth()+1; 
var dd=D.getDate(); 
var ww=D.getDay(); 
var ss=parseInt(D.getTime() / 1000); 
function getFullYear(d){// 修正firefox下year错误
yr=d.getYear();if(yr<1000)
yr+=1900;return yr;}
function showDate() {
var sValue = getFullYear(dNow)+"年"+(dNow.getMonth()+1)+"月"+dNow.getDate()+"日"+"<br> "+sWeek[dNow.getDay()]+" ";
sValue+=GetLunarDay(yy,mm,dd);
return sValue
  //document.getElementById("pDate").innerHTML = sValue;
};
var t = null;
t = setTimeout(time,1000);//開始运行
function time()
{
   clearTimeout(t);//清除定时器
   dt = new Date();
   var h=dt.getHours();//获取时
   var m=dt.getMinutes();//获取分
   var s=dt.getSeconds();//获取秒
   $("#time").html(h+":"+m+":"+s+"");
   t = setTimeout(time,1000); //设定定时器，循环运行     
} 

var time = 500;
var h = 0;
function addCount()
{
    if(time>0)
    {
        time--;
        h = h+5;
    }
    else
    {
        return;
    }
    if(h>180)  //高度
    {
        return;
    }
    document.getElementById("ads").style.display = "";
    document.getElementById("ads").style.height = h+"px";
    setTimeout("addCount()",30); 
}
/**
 * 获取横幅广告
 * @param parentid
 * @param classnum
 * @param newsnum
 */
function getadvlistIndex_1213(){
	$.ajax({
  		url:getRequestUrl("/HomeController/queryadvlist.json"),
    	dataType:"json",
    	data:{},
      	success:function(result){
      		var newslistHtml = $("#ad1Template").render(result.list1);
      		$("#ad1").html(newslistHtml);
      		var newslistHtml = $("#ad2Template").render(result.list2);
      		$("#ad2").html(newslistHtml);
      		
      	   
      	},
      	error:function(error){
      		console.log('Error...');
      	}
   })
}


function showAds()
{
    addCount();
    setTimeout("noneAds()",4000); //停留时间自己适当调整
}
var T = 1400;
var N = 180; //高度
function noneAds()
{
    if(T>0)
    {
        T--;
        N = N-5;
    }
    else
    {
        return;
    }
    if(N<0)
    {
        document.getElementById("ads").style.display = "none";
        return;
    }
    
    document.getElementById("ads").style.height = N+"px";
    setTimeout("noneAds()",30); 
}
/**
 * 
 */
function getnowtime(){
	var myDate = new Date();
	$("#today").html(showDate());
}
function getNowFormatDate() {
    var date = new Date();
    var seperator1 = "-";
    var year = date.getFullYear();
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var currentdate = year + seperator1 + month + seperator1 + strDate;
    return currentdate;
}

/**
 * 通知
 * @param categoryid
 * @param num
 */
function getNewslistForZhiding(categoryid,num)
{
	$.ajax({
  		url:getRequestUrl("/HomeController/queryNewsListTopOfhavepic.json"),
    	dataType:"json",
    	data:{"num":num},
      	success:function(result){
//      		 $("#ishotname").html(result.category.categoryname);
      		var newslistHtml = $("#ishotTemplate").render(result);
      		$("#zSlider").html(newslistHtml);
      		$('#select_btn li:first').css('border','none');
      		if ($('#zSlider').length) {
      			zSlider();
      			$('#h_sns').find('img').hover(function(){
      				$(this).fadeTo(200,0.5);
      			}, function(){
      				$(this).fadeTo(100,1);
      			});
      		}
      	},
      	error:function(error){
      		console.log('Error...');
      	}
   })
}
function zSlider(ID, delay){
	var ID=ID?ID:'#zSlider';
	var delay=delay?delay:5000;
	var currentEQ=0, picnum=$('#picshow_img li').size(), autoScrollFUN;
	$('#select_btn li').eq(currentEQ).addClass('current');
	$('#picshow_img li').eq(currentEQ).show();
	$('#picshow_tx li').eq(currentEQ).show();
	autoScrollFUN=setTimeout(autoScroll, delay);
	function autoScroll(){
		clearTimeout(autoScrollFUN);
		currentEQ++;
		if (currentEQ>picnum-1) currentEQ=0;
		$('#select_btn li').removeClass('current');
		$('#picshow_img li').hide();
		$('#picshow_tx li').hide().eq(currentEQ).slideDown(400);
		$('#select_btn li').eq(currentEQ).addClass('current');
		$('#picshow_img li').eq(currentEQ).show();
		autoScrollFUN = setTimeout(autoScroll, delay);
	}
	$('#picshow').hover(function(){
		clearTimeout(autoScrollFUN);
	}, function(){
		autoScrollFUN = setTimeout(autoScroll, delay);
	});
	$('#select_btn li').hover(function(){
		var picEQ=$('#select_btn li').index($(this));
		if (picEQ==currentEQ) return false;
		currentEQ = picEQ;
		$('#select_btn li').removeClass('current');
		$('#picshow_img li').hide();
		$('#picshow_tx li').hide().eq(currentEQ).slideDown(100);
		$('#select_btn li').eq(currentEQ).addClass('current');
		$('#picshow_img li').eq(currentEQ).show();
		return false;
	});
};
/**
 * 通知
 * @param categoryid
 * @param num
 */
function getNewslistForTongzhi(categoryid,num)
{
	$.ajax({
  		url:getRequestUrl("/HomeController/queryNewsListByCategoryid.json"),
    	dataType:"json",
    	data:{"zlBNews.categoryid":categoryid,"num":num},
      	success:function(result){
      		 $("#tongzhigonggaoname").html(result.category.categoryname);
      		var newslistHtml = $("#tongzhigonggaoTemplate").render(result.data);
      		$("#tongzhigonggao").html(newslistHtml);
      	},
      	error:function(error){
      		console.log('Error...');
      	}
   })
}

/**
 * 公告
 * @param categoryid
 * @param num
 */
function getNewslistForGonggao(categoryid,num)
{
	$.ajax({
  		url:getRequestUrl("/HomeController/queryNewsListByCategoryid.json"),
    	dataType:"json",
    	data:{"zlBNews.categoryid":categoryid,"num":num},
      	success:function(result){
      		$("#ggclass").html(result.category.categoryname);
      		tongzhigonggaop=result.category.permissions;
      		if(result.data.length>0){
      			var newslistHtml = $("#tongzhigonggaoTemplate").render(result.data);
          		$("#tongzhigonggao").html(newslistHtml);
      		} 
      		
      	},
      	error:function(error){
      		console.log('Error...');
      	}
   })
}
function showgonggao(id){
	if(id=='1'){
		 $("#ggclass").removeClass("leftnotice_one_head_active").addClass('leftnotice_one_head_over');
		 $("#tzclass").removeClass("leftnotice_one_head_over").addClass('leftnotice_one_head_active');
		getNewslistForTongzhi('4bce6fdb33264e90a714d706bd60a226',4);//获取通知
		tongzhigonggaotype='4bce6fdb33264e90a714d706bd60a226';
		
	}
	if(id=='2'){
		 $("#ggclass").removeClass("leftnotice_one_head_over").addClass('leftnotice_one_head_active');
		 $("#tzclass").removeClass("leftnotice_one_head_active").addClass('leftnotice_one_head_over');
		getNewslistForGonggao('080656444e314571bcc95cb8768fa83c',4);//获取公告
		tongzhigonggaotype='080656444e314571bcc95cb8768fa83c';
	}
}
/**
 * 总行工作
 * @param categoryid
 * @param num
 */
function getNewslistForZonghang(categoryid,num)
{
	$.ajax({
  		url:getRequestUrl("/HomeController/queryNewsListByCategoryid.json"),
    	dataType:"json",
    	data:{"zlBNews.categoryid":categoryid,"num":num},
      	success:function(result){
      		$("#zonghangname").html("<img src='"+path+"/rapast/index/images/icon2.jpg' width='23' height='16' />"+result.category.categoryname);
//      		gongzuodongtaitopp=result.category.permissions;
//      		var newslisttopHtml = $("#gongzuodongtaitopTemplate").render(result.newslisttop);
//      		$("#gongzuodongtaitop").html(newslisttopHtml);
      		
      		var newslistHtml = $("#tongzhigonggaoTemplate").render(result.data);
      		$("#zonghanggongzuo").html(newslistHtml);
      	},
      	error:function(error){
      		console.log('Error...');
      	}
   })
}
/**
 * 十九大专栏
 * @param categoryid
 * @param num
 */
function getNewslistForShijiuda(categoryid,num)
{
	$.ajax({
  		url:getRequestUrl("/HomeController/queryNewsListByCategoryid.json"),
    	dataType:"json",
    	data:{"zlBNews.categoryid":categoryid,"num":num},
      	success:function(result){
      		$("#shijiudaname").html("<img src='"+path+"/rapast/index/images/icon2.jpg' width='23' height='16' />"+result.category.categoryname);
//      		gongzuodongtaitopp=result.category.permissions;
//      		var newslisttopHtml = $("#gongzuodongtaitopTemplate").render(result.newslisttop);
//      		$("#gongzuodongtaitop").html(newslisttopHtml);
      		
      		var newslistHtml = $("#tongzhigonggaoTemplate").render(result.data);
      		$("#shijiuda").html(newslistHtml);
      	},
      	error:function(error){
      		console.log('Error...');
      	}
   })
}
/**
 * 警钟长鸣
 * @param categoryid
 * @param num
 */
function getNewslistForJingzhong(categoryid,num)
{
	$.ajax({
  		url:getRequestUrl("/HomeController/queryNewsListByParentCategoryid.json"),
    	dataType:"json",
    	data:{"zlBNews.categoryid":categoryid,"num":num},
      	success:function(result){
      		$("#jingzhongname").html("<img src='"+path+"/rapast/index/images/icon2.jpg' width='23' height='16' />"+result.category.categoryname);
      		var newslistHtml = $("#tongzhigonggaoTemplate").render(result.data);
      		$("#jingzhong").html(newslistHtml);
      	},
      	error:function(error){
      		console.log('Error...');
      	}
   })
/*	$.ajax({
  		url:getRequestUrl("/HomeController/queryNewsListByCategoryid.json"),
    	dataType:"json",
    	data:{"zlBNews.categoryid":categoryid,"num":num},
      	success:function(result){
      		$("#jingzhongname").html("<img src='"+path+"/rapast/index/images/icon2.jpg' width='23' height='16' />"+result.category.categoryname);
//      		gongzuodongtaitopp=result.category.permissions;
//      		var newslisttopHtml = $("#gongzuodongtaitopTemplate").render(result.newslisttop);
//      		$("#gongzuodongtaitop").html(newslisttopHtml);
      		
      		var newslistHtml = $("#tongzhigonggaoTemplate").render(result.data);
      		$("#jingzhong").html(newslistHtml);
      	},
      	error:function(error){
      		console.log('Error...');
      	}
   })*/
}
/**
 * 重要讲话
 * @param categoryid
 * @param num
 */
function getNewslistForZhongyao(categoryid,num)
{
	$.ajax({
  		url:getRequestUrl("/HomeController/queryNewsListByCategoryid.json"),
    	dataType:"json",
    	data:{"zlBNews.categoryid":categoryid,"num":num},
      	success:function(result){
      		$("#zhongyaoname").html("<img src='"+path+"/rapast/index/images/icon2.jpg' width='23' height='16' />"+result.category.categoryname);
      		var newslistHtml = $("#tongzhigonggaoTemplate").render(result.data);
      		$("#zhongyao").html(newslistHtml);
      	},
      	error:function(error){
      		console.log('Error...');
      	}
   })
}
/**
 * 热点聚焦
 * @param categoryid
 * @param num
 */
function getNewslistForRedian(categoryid,num)
{
	$.ajax({
  		url:getRequestUrl("/HomeController/queryNewsListByCategoryid.json"),
    	dataType:"json",
    	data:{"zlBNews.categoryid":categoryid,"num":num},
      	success:function(result){
      		$("#redianname").html("<img src='"+path+"/rapast/index/images/icon2.jpg' width='23' height='16' />"+result.category.categoryname);
      		var newslistHtml = $("#tongzhigonggaoTemplate").render(result.data);
      		$("#redian").html(newslistHtml);
      	},
      	error:function(error){
      		console.log('Error...');
      	}
   })
}
/**
 * 总行要闻
 * @param categoryid
 * @param num
 */
function getNewslistForZonghangyaowenByParentid(categoryid,num)
{
	$.ajax({
  		url:getRequestUrl("/HomeController/queryNewsListByParentCategoryid.json"),
    	dataType:"json",
    	data:{"zlBNews.categoryid":categoryid,"num":num},
      	success:function(result){
      		$("#zonghangyaowenname").html("<img src='"+path+"/rapast/index/images/icon2.jpg' width='23' height='16' />"+result.category.categoryname);
      		var newslistHtml = $("#tongzhigonggaoTemplate").render(result.data);
      		$("#zonghangyaowen").html(newslistHtml);
      	},
      	error:function(error){
      		console.log('Error...');
      	}
   })
}
/**
 * 部室动态
 * @param categoryid
 * @param num
 */
function getNewslistForBushidongtaiByParentid(categoryid,num)
{
	$.ajax({
  		url:getRequestUrl("/HomeController/queryNewsListByParentCategoryid.json"),
    	dataType:"json",
    	data:{"zlBNews.categoryid":categoryid,"num":num},
      	success:function(result){
      		$("#bushidongtainame").html("<img src='"+path+"/rapast/index/images/icon2.jpg' width='23' height='16' />"+result.category.categoryname);
      		var newslistHtml = $("#tongzhigonggaoTemplate").render(result.data);
      		$("#bushidongtai").html(newslistHtml);
      	},
      	error:function(error){
      		console.log('Error...');
      	}
   })
}
/**
 * 党团建设
 * @param categoryid
 * @param num
 */
function getNewslistForDangtuanjiansheByParentid(categoryid,num)
{
	$.ajax({
  		url:getRequestUrl("/HomeController/queryNewsListByParentCategoryid.json"),
    	dataType:"json",
    	data:{"zlBNews.categoryid":categoryid,"num":num},
      	success:function(result){
      		$("#dangtuanjianshename").html("<img src='"+path+"/rapast/index/images/icon2.jpg' width='23' height='16' />"+result.category.categoryname);
      		var newslistHtml = $("#tongzhigonggaoTemplate").render(result.data);
      		$("#dangtuanjianshe").html(newslistHtml);
      	},
      	error:function(error){
      		console.log('Error...');
      	}
   })
}
/**
 * 基层风采
 * @param categoryid
 * @param num
 */
function getNewslistForJicengfengcaiByParentid(categoryid,num)
{
	$.ajax({
  		url:getRequestUrl("/HomeController/queryNewsListByParentCategoryid.json"),
    	dataType:"json",
    	data:{"zlBNews.categoryid":categoryid,"num":num},
      	success:function(result){
      		$("#jicengfengcainame").html("<img src='"+path+"/rapast/index/images/icon2.jpg' width='23' height='16' />"+result.category.categoryname);
      		var newslistHtml = $("#tongzhigonggaoTemplate").render(result.data);
      		$("#jicengfengcai").html(newslistHtml);
      	},
      	error:function(error){
      		console.log('Error...');
      	}
   })
}
/**
 * 行业观察
 * @param categoryid
 * @param num
 */
function getNewslistForHangyeguancaByParentid(categoryid,num)
{
	$.ajax({
  		url:getRequestUrl("/HomeController/queryNewsListByParentCategoryid.json"),
    	dataType:"json",
    	data:{"zlBNews.categoryid":categoryid,"num":num},
      	success:function(result){
      		$("#hangyeguancaname").html("<img src='"+path+"/rapast/index/images/icon2.jpg' width='23' height='16' />"+result.category.categoryname);
      		var newslistHtml = $("#tongzhigonggaoTemplate").render(result.data);
      		$("#hangyeguanca").html(newslistHtml);
      	},
      	error:function(error){
      		console.log('Error...');
      	}
   })
}
/**
 * 员工天地
 * @param categoryid
 * @param num
 */
function getNewslistForYuangongtiandiByParentid(categoryid,num)
{
	$.ajax({
  		url:getRequestUrl("/HomeController/queryNewsListByParentCategoryid.json"),
    	dataType:"json",
    	data:{"zlBNews.categoryid":categoryid,"num":num},
      	success:function(result){
      		$("#yuangongtiandiname").html("<img src='"+path+"/rapast/index/images/icon2.jpg' width='23' height='16' />"+result.category.categoryname);
      		var newslistHtml = $("#tongzhigonggaoTemplate").render(result.data);
      		$("#yuangongtiandi").html(newslistHtml);
      	},
      	error:function(error){
      		console.log('Error...');
      	}
   })
}
/**
 * 工作动态
 * @param categoryid
 * @param num
 */
function getNewslistForDongtai(categoryid,num)
{
	$.ajax({
  		url:getRequestUrl("/HomeController/queryNewsListByCategoryid.json"),
    	dataType:"json",
    	data:{"zlBNews.categoryid":categoryid,"num":num},
      	success:function(result){
      		$("#dtclass").html(result.category.categoryname);
      		gongzuodongtaitopp=result.category.permissions;
      		var newslisttopHtml = $("#gongzuodongtaitopTemplate").render(result.newslisttop);
      		$("#gongzuodongtaitop").html(newslisttopHtml);
      		
      		var newslistHtml = $("#gongzuodongtaiTemplate").render(result.data);
      		$("#gongzuodongtai").html(newslistHtml);
      	},
      	error:function(error){
      		console.log('Error...');
      	}
   })
}
/**
 * 情况通报
 * @param categoryid
 * @param num
 */
function getNewslistForTongbao(categoryid,num)
{
	$.ajax({
  		url:getRequestUrl("/HomeController/queryNewsListByCategoryid.json"),
    	dataType:"json",
    	data:{"zlBNews.categoryid":categoryid,"num":num},
      	success:function(result){
      		$("#tbclass").html(result.category.categoryname);
      		gongzuodongtaip=result.category.permissions;
      		var newslisttopHtml = $("#gongzuodongtaitopTemplate").render(result.newslisttop);
      		$("#gongzuodongtaitop").html(newslisttopHtml);
      		var newslistHtml = $("#gongzuodongtaiTemplate").render(result.data);
      		$("#gongzuodongtai").html(newslistHtml);
      	},
      	error:function(error){
      		console.log('Error...');
      	}
   })
}
function showdongtai(id){
	if(id=='1'){
		 $("#tbclass").removeClass("million_right_one_head_active").addClass('million_right_one_head_over');
		 $("#dtclass").removeClass("million_right_one_head_over").addClass('million_right_one_head_active');
		getNewslistForDongtai('b448b7b267764ceabe3e56aa1902eec6',16);//获取通知
		
	}
	if(id=='2'){
		 $("#tbclass").removeClass("million_right_one_head_over").addClass('million_right_one_head_active');
		 $("#dtclass").removeClass("million_right_one_head_active").addClass('million_right_one_head_over');
		 getNewslistForTongbao('dcb988404e514938a5426d44ce3d7f2b',16);//获取公告
	}
}
/**
 * 学习培训
 * @param categoryid
 * @param num
 */
function getNewslistForXuexipeixun(categoryid,num)
{
	$.ajax({
  		url:getRequestUrl("/HomeController/queryNewsListByParentCategoryid.json"),
    	dataType:"json",
    	data:{"zlBNews.categoryid":categoryid,"num":num},
      	success:function(result){
      		$("#xuexipeixunclass").html(result.category.categoryname);
      		xuexipeixunp=result.category.permissions;
      		var newslistHtml = $("#xuexipeixunTemplate").render(result.data);
      		$("#xuexipeixun").html(newslistHtml);
      	},
      	error:function(error){
      		console.log('Error...');
      	}
   })
}
/**
 * 税务文化
 * @param categoryid
 * @param num
 */
function getNewslistForXinxicangku(categoryid,num)
{
	$.ajax({
  		url:getRequestUrl("/HomeController/queryNewsListByParentCategoryid.json"),
    	dataType:"json",
    	data:{"zlBNews.categoryid":categoryid,"num":num},
      	success:function(result){
      		$("#xinxicangkuclass").html(result.category.categoryname);
      		xinxicangkup=result.category.permissions;
      		var newslisttopHtml = $("#xinxicangkutopTemplate").render(result.newslisttop);
      		$("#xinxicangkutop").html(newslisttopHtml);
      		
      		var newslistHtml = $("#xinxicangkuTemplate").render(result.data);
      		$("#xinxicangku").html(newslistHtml);
      	},
      	error:function(error){
      		console.log('Error...');
      	}
   })
}

/**
 * 根据parentid获取子分类
 * @param categoryid
 * @param num，
 */
function getNewsCategorylistByParentidForSpeak(categoryid,num)
{
	$.ajax({
  		url:getRequestUrl("/HomeController/queryNewsCategoryListByParentCategoryid.json"),
    	dataType:"json",
    	data:{"zlBNewsCategory.categoryid":categoryid,"num":num},
      	success:function(result){
      		var newslisttopHtml = $("#speaklistTemplate").render(result.data);
      		$("#speaklist").html(newslisttopHtml);
      		 
      	},
      	error:function(error){
      		console.log('Error...');
      	}
   })
}
/**
 * 根据parentid获取子分类
 * @param categoryid
 * @param num，
 */
function getNewsCategorylistByParentid(categoryid,num)
{
	$.ajax({
  		url:getRequestUrl("/HomeController/queryNewsCategoryListByParentCategoryid.json"),
    	dataType:"json",
    	data:{"zlBNewsCategory.categoryid":categoryid,"num":100},
      	success:function(result){
      		var newslisttopHtml = $("#xinxicangku2Template").render(result.data);
      		$("#xinxicangku2").html(newslisttopHtml);
      		if(result.data.length>0){
      			getNewslistByCategoryid(result.data[0].categoryid);
      		}
      		
      	  $(".newstabar_head ul li ").each(function(index) {
				$(this).click(function(){
				$(this).addClass("crr")
				$(this).siblings("li").removeClass("crr")
				})
      	});
      	},
      	error:function(error){
      		console.log('Error...');
      	}
   })
}
/**
 * 根据分类查询新闻列表
 * @param categoryid
 */
function getNewslistByCategoryid(categoryid){
	$.ajax({
  		url:getRequestUrl("/HomeController/queryNewsListByCategoryid.json"),
    	dataType:"json",
    	data:{"zlBNews.categoryid":categoryid,"num":12},
      	success:function(result){
      		var newslistHtml = $("#xinxicangkunews2Template").render(result.data);
      		$("#xinxicangkunews2").html(newslistHtml);
      	},
      	error:function(error){
      		console.log('Error...');
      	}
   })
}
/**
 * 根据父级别id查询子分类及子分类下新闻【党建之窗】
 * @param parentid
 * @param classnum
 * @param newsnum
 */
function getNewslistByParentidForDangjianzhichuang(parentid,classnum,newsnum){
	$.ajax({
  		url:getRequestUrl("/HomeController/queryNewsCategoryListAndNewslistByParentCategoryid.json"),
    	dataType:"json",
    	data:{"zlBNewsCategory.categoryid":parentid,"classnum":classnum,"newsnum":newsnum},
      	success:function(result){
      		var newslistHtml = $("#dangjianzhichuangTemplate").render(result);
      		$("#dangjianzhichuang").html(newslistHtml);
      	},
      	error:function(error){
      		console.log('Error...');
      	}
   })
}
/**
 * 根据父级别id查询子分类及子分类下新闻【廉政建设】
 * @param parentid
 * @param classnum
 * @param newsnum
 */
function getNewslistByParentidForLianzhengjianshe(parentid,classnum,newsnum){
	$.ajax({
  		url:getRequestUrl("/HomeController/queryNewsCategoryListAndNewslistByParentCategoryid.json"),
    	dataType:"json",
    	data:{"zlBNewsCategory.categoryid":parentid,"classnum":classnum,"newsnum":newsnum},
      	success:function(result){
      		var newslistHtml = $("#lianzhengjiansheTemplate").render(result);
      		$("#lianzhengjianshe").html(newslistHtml);
      	},
      	error:function(error){
      		console.log('Error...');
      	}
   })
}
/**
 * 根据父级别id查询子分类及子分类下新闻【规章制度】
 * @param parentid
 * @param classnum
 * @param newsnum
 */
function getNewslistByParentidForGuizhangzhidu(parentid,classnum,newsnum){
	$.ajax({
  		url:getRequestUrl("/HomeController/queryNewsCategoryListAndNewslistByParentCategoryid.json"),
    	dataType:"json",
    	data:{"zlBNewsCategory.categoryid":parentid,"classnum":classnum,"newsnum":newsnum},
      	success:function(result){
      		var newslistHtml = $("#guizhangzhiduTemplate").render(result);
      		$("#guizhangzhidu").html(newslistHtml);
      	},
      	error:function(error){
      		console.log('Error...');
      	}
   })
}
function gotodisclosure(id){
	pageForward("/HomeController/disclosure.do?opid="+id);//通知公告
}
/**
 * 跳转
 * 	getNewslistForTongzhi('d05ff442c2e242fdbb98a0664deda708',6);//获取通知
//	getNewslistForZonghang('a07eaa9bed9f41a79b84f427fc61e051',3);//获取总行工作
//	getNewslistForShijiuda('347c7d0f93ae4feea0abf4ead6b9f5bb',10);//获取十九大学习专栏
//	getNewslistForJingzhong('400e5a6a9bc04e9cb7567dd51999f70e',10);//获取警钟长鸣
//	getNewslistForZhongyao('7e0fd986a5904cc780657951dc57b214',3);//获取重要讲话
//	getNewslistForRedian('5b6464cd663c4443bd2ea1abdb39eb38',5);//获取热点聚焦
 */
function gotopagebytype(id,type,p){
 
	 if(type=='1'){
//			if(tongzhip<=syspermissions){
				pageForward("/HomeController/indexlist.do?opid=d05ff442c2e242fdbb98a0664deda708");//通知公告
//			}else{
//				layer.alert('阅读权限不足，请联系管理员',3);
//			}
			
		}else if(type=='2'){
//			if(xuexipeixunp<=syspermissions){
				pageForward("/HomeController/indexlist.do?opid=a07eaa9bed9f41a79b84f427fc61e051");//总行工作
//			}else{
//				layer.alert('阅读权限不足，请联系管理员',3);
//			}
			
		}else if(type=='3'){
//			if(p<=syspermissions){
				pageForward("/HomeController/indexlist.do?opid=347c7d0f93ae4feea0abf4ead6b9f5bb");//十九大学习专栏
//			}else{
//				layer.alert('阅读权限不足，请联系管理员',3);
//			}
			
		}else if(type=='4'){
//			if(p<=syspermissions){
				pageForward("/HomeController/alarm.do?opid=8b4bec4083ae42dd94a091149da89bfe");//警钟长鸣
//			}else{
//				layer.alert('阅读权限不足，请联系管理员',3);
//			}
		}else if(type=='5'){
//			if(p<=syspermissions){
				pageForward("/HomeController/indexlist.do?opid=7e0fd986a5904cc780657951dc57b214");//重要讲话
//			}else{
//				layer.alert('阅读权限不足，请联系管理员',3);
//			}
		}else if(type=='6'){
//			if(xinxicangkup<=syspermissions){
				pageForward("/HomeController/indexlist.do?opid=5b6464cd663c4443bd2ea1abdb39eb38");//热点聚焦
//			}else{
//				layer.alert('阅读权限不足，请联系管理员',3);
//			}
		} else if(type=='7'){
				pageForward("/HomeController/news.do?opid=355db268a56f49a49f96abd977769071");//讲话
		} else if(type=='8'){
				pageForward("/HomeController/officedynamic.do?opid=ae6525efdadf4f9c8b0659fce6e4c795");//讲话
		} else if(type=='9'){
				pageForward("/HomeController/party.do?opid=7c466e658310464c92f222b1e9d7b0df");//讲话
		} else if(type=='10'){
				pageForward("/HomeController/basicstyle.do?opid=ebb2b51008fc49b79a281f2234b6fb26");//讲话
		} else if(type=='11'){
				pageForward("/HomeController/industryobserve.do?opid=23e7a3510f4a41d18cded1cf3bfdd670");//讲话
		} else if(type=='12'){
				pageForward("/HomeController/employees.do?opid=2ea7bf0397104b6392a35a8023290023");//讲话
		} 
	 
	
	
}

/**
 * 跳转新闻详细
 * @param id
 */
function gotonewsdetail(id,p){
		var page="/HomeController/indexdetail.do?opid="+id;
		if(p!=''){
			page="/HomeController/"+p+"detail.do?opid="+id;
		}
		 pageForward(page);
}
//跳转注册页
function toLogin_reg(){
	pageForward("/bclient/ZlBTraderUserController/login_reg.do");
}
//找回密码页面   周海峰
function topasswordpage(){
	pageForward('/rapast/pageHtml/jsp/index/password.jsp');
}
//找回密码页面   周海峰
function tiaozhuan(url){
	window.location.href =url;
}
function getnewspiclist(){
	$.ajax({
  		url:getRequestUrl("/HomeController/queryNewsListTopOfhavepic.json"),
    	dataType:"json",
    	data:{"num":10},
      	success:function(result){
      		var newslistHtml = $("#newspicTemplate").render(result.data);
      		$("#ad0").html(newslistHtml);
      	},
      	error:function(error){
      		console.log('Error...');
      	}
   })
}

/**
 * 浏览记录
 */
function gotoweb(type,value){
	var id=value;
  if(type=='1'){
	  pageForward("/HomeController/leader.do?opid="+id);
  }else if(type=='2'){
	  pageForward("/HomeController/branch.do?opid="+id);
  }else if(type=='3'){
	  pageForward("/HomeController/branch.do?opid="+id);
  }
	
}
/**
 * 
 * @returns
 */
function getSelectList(){
	createSelectByDB("select_ld","zl_b_news_category","categoryname","categoryid", " and parentid='c4ec893a0c7f43039d2bd0ca644bb697' and status='1' order by ordernum asc");
	createSelectByDB("select_bs","zl_b_news_category","categoryname","categoryid", " and parentid='0' and permissions='2' and status='1' order by rootid asc");
	createSelectByDB("select_fh","zl_b_news_category","categoryname","categoryid", " and parentid='0' and permissions='3' and status='1' order by rootid asc");
}

