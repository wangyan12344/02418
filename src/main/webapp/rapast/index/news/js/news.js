var parentid='cdf808c5cfdc418884a2125c4b432b8f';
$(function(){
	getadvlist();//获取横幅广告
	initpage();
	
});

function initpage(){
	getNewsCategorylistByParentid(parentid,100);
	if(opid=="" || opid==null || opid=="null"){
		queryDataList(parentid,'1');
	}else{
	queryDataList(opid,'0');
	}
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
//      		var newslisttopHtml = $("#xinxicangku2Template").render(result.data);
     		$("#list").html(result.category.categoryname);
     		$("#sname").html(result.category.categoryname);
      		var addHtml = $("#categoryTemplate").render(result.data);
			$("#categorylist").html(addHtml);
      		/*if(result.data.length>0){
      			getNewslistByCategoryid(result.data[0].categoryid);
      		}*/
			/*$(".subNav").click(function(){
				$(this).toggleClass("currentDd").siblings(".subNav").removeClass("currentDd")
				$(this).toggleClass("currentDt").siblings(".subNav").removeClass("currentDt")
				
				// 修改数字控制速度， slideUp(500)控制卷起速度
				$(this).next(".navContent").slideToggle(500).siblings(".navContent").slideUp(500);
		})*/
		//新闻种类列表动态效果
		$("#categorylist div").each(function(index) {
			$(this).click(function(){			
			$(this).addClass("newslist")
			$(this).siblings("div").removeClass("newslist")
			})
			});
		$("#categorylist div:last").addClass("bordernone");
		
      	},
      	error:function(error){
      		console.log('Error...');
      	}
   })
}
//初始化新闻列表
 
function queryDataList(id,type){
	
	var parameterData = {
			url:getRequestUrl("/ZlBNewsController/queryNewsList.json"),
			successfunc:renderListDataFun,
			customArray:{"zlBNews.categoryid":id,"zlBNews.type":type},
			pageller:"pagefoot",
			pageIndex:1,
			pageSize:5
	};
	pageBarFortable(parameterData)
}

function renderListDataFun(result){
	/*if(result.category==null){
	 $("#classname").html(result.category.categoryname);
	}*/
		$( "#dataListId" ).html(
			$("#dataListTemplate").render(result)
		);
	 
	//奇偶行颜色不同
	$('.tablelist tbody tr:odd').addClass('odd');
}

//跳转新闻详细页
function todetaildepage(id,permissions){
	if(permissions<=syspermissions){	
	var page="/ZlBNewsController/todetail.do?opid="+id;
	 pageForward(page);
	}else{
		layer.alert('阅读权限不足，请联系管理员',3);
	}
	 
}
//返回列表
function tolist(){
	queryDataList();
	//$("#list").bind("click",function(){
	// pageForward("/ZlBNewsController/newslist.do");
	//});
}

