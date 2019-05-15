/**
 * 导航跳转
 * */
 
 $(document).ready(function() {
/*	document.onkeydown = function(e)
	{ 
		var ev = document.all ? window.event : e; 
		if(ev.keyCode==13) { 
			gotologin();
		} 
	} */
});
$(function(){
//	getLinkByType();
//	getLinkForIndex();//首页通道
//	getNewslistForNotice('6542ee711b584beab265dc4a5ed65618',3);//获取滚动公告、
	getNewsClassListByParentid();
});

	
// JavaScript Document
function GetPageName(){
	var url = window.location.href;
	var tmp = new Array();
	var newtmp = new Array();    
	tmp = url.split("/");  
	var pp = tmp[tmp.length-1];
	tmp = pp.split("?");
	tmp = tmp[0].split(".");
	return tmp[0];	
}

function showPage(url,opid){
	if(opid=="000"){
		pageForward(url);
	}else{
		pageForward("/HomeController/"+url+".do?opid="+opid);
	}
	
}
function waitingPage(){	
	//pageForward("/HomeController/waiting.do");
}
/**
 * 跳转注册
 */
function gotoreg(){	
	pageForward("/HomeController/reg.do");
}
/**
 * 修改密码
 */
function password(){	
	pageForward("/HomeController/password.do");
}
/**
 * 浏览记录
 */
function recode(){	
	pageForward("/HomeController/recode.do");
}
function BuyHomeDataFun(){
	if (username==null  ||  username=="")
	{
		$("#dabox").show();
	}	
	else
		{		
				pageForward("/rapast/pageHtml/jsp/gd/salesgd_add.jsp");
		}
	
}
$("#login").click(function () {
    $(".hide-center").fadeIn("slow");
    $(".overCurtain").fadeIn("slow");
})
$("#close").click(function () {
    $(".hide-center").fadeOut("slow")
    $(".overCurtain").fadeOut("slow")
})

/**
 * 登录
 * **/
function gotologin(){
	
	if($("#account").val()=="")
	{
		layer.msg("请输入手机号！");
		return false;
	}
	else if($("#password").val()=="")
	{
		layer.msg("请输入密码！");
		return false;
	}
	else
	{
		var traderuserid = "";
		var traderid = "";
//		var flag=$('input:checkbox[name="checkbox"]:checked').val();
		var postData = collectData("formbody");
//		var userData=$.extend({},postData,{"flag":flag});
		$.ajax({
			url:getRequestUrl("/loginController/Login.json"),
			dataType:"json",
			data:postData,
			success:function(result){
				if(result.opflag)
				{
					layer.alert('成功登录', 3, function(){
						window.location=path+"/HomeController/index.do";
						  $(".hide-center").fadeOut("slow")
						  $(".overCurtain").fadeOut("slow")
					});
					 
					
				}
				else{
					layer.msg(result.opmessage);
				}
			},
			error:function(error){
				layer.alert("error",3);
			}
		});
	}
}

//查询友情链接
function getLinkByType()
{
	$.ajax({
  		url:getRequestUrl("/ZlBAppActivityController/loadZlBAppActivityListByType.json"),
    	dataType:"json",
    	data:{"zlBAppActivity.type":'1'},
      	success:function(result){
      		//详细信息
  			var detailHtml = $("#linklistTemplate").render(result.list);
  			$("#linklist").html(detailHtml);
//  			bindevent();
      	},
      	error:function(error){
      		console.log('Error...');
      	}
   })
}
//打开链接地址
function openurl(url){
	
}

/**
 * 获取滚动公告
 */
function getNewslistForNotice(categoryid,num)
{
	$.ajax({
  		url:getRequestUrl("/HomeController/queryNewsListByCategoryid.json"),
    	dataType:"json",
    	data:{"zlBNews.categoryid":categoryid,"num":num},
      	success:function(result){
      		var newslistHtml = $("#noticeTemplate").render(result.data);
      		noticep=result.category.permissions;
      		$("#notice").html(newslistHtml);
      	},
      	error:function(error){
      		console.log('Error...');
      	}
   })
}
//查询通道友情链接
function getLinkForIndex()
{
	$.ajax({
  		url:getRequestUrl("/ZlBAppActivityController/loadZlBAppActivityListByType.json"),
    	dataType:"json",
    	data:{"zlBAppActivity.type":'2'},
      	success:function(result){
      		//详细信息
      		var tongdaoHtml = $("#tongdaoTemplate").render(result.list2);
      		$("#tongdao").html(tongdaoHtml);
      	},
      	error:function(error){
      		console.log('Error...');
      	}
   })
   
   
}
/**
 * 获取横幅广告
 * @param parentid
 * @param classnum
 * @param newsnum
 */
function getadvlist(){
	$.ajax({
  		url:getRequestUrl("/HomeController/queryadvlist.json"),
    	dataType:"json",
    	data:{},
      	success:function(result){
      		var newslistHtml = $("#ad1Template").render(result.list10);
      		$("#ad10").html(newslistHtml);
      	},
      	error:function(error){
      		console.log('Error...');
      	}
   })
}
function showpicfromnews(imgurl){
	var element = document.getElementById('showpic');
	 element.src = imgurl;
}
/**
 * 浏览记录
 */
function gotosearch(){
	var newstitle=$("#newskey").val();
	if(newstitle=="")
	{
		alert("请输入关键字！");
//		layer.msg("请输入关键字！");
		return false;
	}
	pageForward("/HomeController/search.do?newstitle="+encodeURI(encodeURI(newstitle)));
}
/**
 * 根据parentid获取子分类
 * @param categoryid
 * @param num，
 */
function getNewsClassListByParentid()
{
	$.ajax({
  		url:getRequestUrl("/HomeController/queryNewsCategoryListByParentCategoryidForMenu.json"),
    	dataType:"json",
    	data:{"zlBNewsCategory.categoryid":'0',"num":8},
      	success:function(result){
      		var addHtml = $("#classListTemplate").render(result);
			$("#classList").html(addHtml);
			var thename = GetPageName();

			switch (thename)       
			{
			    case 'index':
			    case 'indexlist':
			    case 'indexdetail':
					$('.menu ul li').eq(0).addClass('red');
			        break;                                      
					
			    case 'news':  
			    case 'newslist':
			    case 'newsdetail':
					$('.menu ul li').eq(1).addClass('red');
					break; 
			    case 'officedynamic': 
			    case 'officedynamiclist':
			    case 'officedynamicdetail':
					$('.menu ul li').eq(2).addClass('red');
					break;
			    case 'party':  
			    case 'partylist':
			    case 'partydetail':
					$('.menu ul li').eq(3).addClass('red');
					break;	
				
				case 'business':  
				case 'businesslist':
				case 'businessdetail':
					$('.menu ul li').eq(4).addClass('red');
					break; 
				case 'basicstyle':  
				case 'basicstylelist': 
				case 'basicstyledetail': 
					$('.menu ul li').eq(5).addClass('red');
					break; 
				case 'industryobserve': 
				case 'industryobservelist':
				case 'industryobservedetail':
					$('.menu ul li').eq(6).addClass('red');
				break;	
				
				case 'employees':  
				case 'employeeslist': 
				case 'employeesdetail': 
					$('.menu ul li').eq(7).addClass('red');
					break; 	
				case 'training': 
				case 'traininglist':
				case 'trainingdetail':
					$('.menu ul li').eq(8).addClass('red');
					break; 
			   default:
				   $('.menu ul li').eq(0).addClass('red');
			       break;   
			}
      	},
      	error:function(error){
      		console.log('Error...');
      	}
   })
}