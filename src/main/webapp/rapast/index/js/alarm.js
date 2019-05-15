$(function(){
//	var parentid="355db268a56f49a49f96abd977769071";
	queryIstopNewsListByParentid(parentid,6);// 置顶新闻
	queryNewsClassListByParentid(parentid,10);//遍历新闻分类
	getadvlistNews();
}); 
 var url="news";
 /**
  * 获取新闻图片轮播图
  * @param parentid
  * @param classnum
  * @param newsnum
  */
 function getadvlistNews(){
 	$.ajax({
   		url:getRequestUrl("/HomeController/queryNewsBannerOfhavepic.json"),
     	dataType:"json",
     	data:{"zlBNews.categoryid":parentid,num:10},
       	success:function(result){
       		if(result.data!=""){
       		var newslistHtml = $("#ad000Template").render(result.data);
       		$("#ad000").html(newslistHtml);
       		}
       	},
       	error:function(error){
       		console.log('Error...');
       	}
    })
 }
/**
 * 遍历新闻分类
 * @param parentid
 * @param num
 */
function queryNewsClassListByParentid(parentid,num)
{
	$.ajax({
  		url:getRequestUrl("/HomeController/queryNewsClassListByParentid.json"),
    	dataType:"json",
    	data:{"zlBNewsCategory.parentid":parentid,"num":num},
      	success:function(result){

      		var classname=result.entity.categoryname;
      		$("#classname").append(classname);
      		url=result.entity.url;
      		var newslistHtml = $("#classTemplate").render(result.data);
      		$("#classid").html(newslistHtml);
      	},
      	error:function(error){
      		console.log('Error...');
      	}
   })
}
/**
 * 置顶新闻
 * @param parentid
 * @param num
 */
function queryIstopNewsListByParentid(parentid,num)
{
	$.ajax({
  		url:getRequestUrl("/HomeController/queryIstopNewsListByParentid.json"),
    	dataType:"json",
    	data:{"zlBNewsCategory.parentid":parentid,"num":num},
      	success:function(result){
      		if(result.data.length>0){
      			var newslisttopHtml = $("#classistopTemplate").render(result.data[0]);
          		$("#classidistop").html(newslisttopHtml);
          		var newslistHtml = $("#classistoplistTemplate").render(result.data);
          		$("#classidistoplist").html(newslistHtml);
      		}
      		
      	},
      	error:function(error){
      		console.log('Error...');
      	}
   })
}
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
   })
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
 */
function gotopagebytype(id,type,p){
 
	 if(type=='1'){
//			if(tongzhip<=syspermissions){
				pageForward("/HomeController/notice.do?opid="+id);//通知公告
//			}else{
//				layer.alert('阅读权限不足，请联系管理员',3);
//			}
			
		}else if(type=='2'){
//			if(xuexipeixunp<=syspermissions){
				pageForward("/HomeController/training.do?opid="+id);//总行工作
//			}else{
//				layer.alert('阅读权限不足，请联系管理员',3);
//			}
			
		}else if(type=='3'){
//			if(p<=syspermissions){
				pageForward("/HomeController/news.do?opid="+id);//十九大学习专栏
//			}else{
//				layer.alert('阅读权限不足，请联系管理员',3);
//			}
			
		}else if(type=='4'){
//			if(p<=syspermissions){
				pageForward("/HomeController/integrity.do?opid="+id);//警钟长鸣
//			}else{
//				layer.alert('阅读权限不足，请联系管理员',3);
//			}
		}else if(type=='5'){
//			if(p<=syspermissions){
				pageForward("/HomeController/rules.do?opid="+id);//重要讲话
//			}else{
//				layer.alert('阅读权限不足，请联系管理员',3);
//			}
		}else if(type=='6'){
//			if(xinxicangkup<=syspermissions){
				pageForward("/HomeController/warehouse.do?opid="+id);//热点聚焦
//			}else{
//				layer.alert('阅读权限不足，请联系管理员',3);
//			}
		} else if(type=='7'){
//			if(p<=syspermissions){
				pageForward("/HomeController/speak.do?opid="+id);//讲话
//			}else{
//				layer.alert('阅读权限不足，请联系管理员',3);
//			}
		} 
	 
	
	
}

/**
 * 跳转新闻详细
 * @param id
 */
function gotonewsdetail(id){
		var page="/HomeController/newsdetail.do?opid="+id;
		 pageForward(page);
}
/**
 * 跳转新闻详细
 * @param id
 */
function gotonewslist(id){
		var page="/HomeController/"+url+"list.do?opid="+id;
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
/**
 * 获取横幅广告
 * @param parentid
 * @param classnum
 * @param newsnum
 */
function getadvlistIndex(){
	$.ajax({
  		url:getRequestUrl("/HomeController/queryadvlist.json"),
    	dataType:"json",
    	data:{},
      	success:function(result){
      		var newslistHtml = $("#ad1Template").render(result.list1);
      		$("#ad1").html(newslistHtml);
      		var newslistHtml = $("#ad2Template").render(result.list2);
      		$("#ad2").html(newslistHtml);
      		var newslistHtml = $("#ad3Template").render(result.list3);
      		$("#ad3").html(newslistHtml);
      		var newslistHtml = $("#ad3Template").render(result.list4);
      		$("#ad4").html(newslistHtml);
      		var newslistHtml = $("#ad3Template").render(result.list5);
      		$("#ad5").html(newslistHtml);
      		var newslistHtml = $("#ad3Template").render(result.list6);
      		$("#ad6").html(newslistHtml);
      		var newslistHtml = $("#ad3Template").render(result.list7);
      		$("#ad7").html(newslistHtml);
      		var newslistHtml = $("#ad3Template").render(result.list8);
      		$("#ad8").html(newslistHtml);
      		var newslistHtml = $("#ad4Template").render(result.list9);
      		$("#ad9").html(newslistHtml);
      	/*	var newslistHtml = $("#ad1Template").render(result.list10);
      		$("#ad10").html(newslistHtml);*/
      	},
      	error:function(error){
      		console.log('Error...');
      	}
   })
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
function gotoweb(type){
	var id;
  if(type=='1'){
	  id= $("#select_ld").val();
	  pageForward("/HomeController/search.do?newstitle="+id);
  }else if(type=='2'){
	  id= $("#select_bs").val();
	  pageForward("/HomeController/search.do?newstitle="+id);
  }else if(type=='3'){
	  id= $("#select_fh").val();
	  pageForward("/HomeController/search.do?newstitle="+id); 
  }
	
}

