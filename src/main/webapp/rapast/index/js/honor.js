
var url="index";
$(function(){
//	getadvlist();//获取横幅广告
	initpage();
	
});

function initpage(){

	
	if(opid=="" || opid==null){
			queryDataList(parentid,'1','');
			getNewsCategorylistByParentid(parentid,'100','1');
		}else{
			queryDataList(opid,'0','');
			getNewsCategorylistByParentid(opid,'100','0');//需要查询父级别id
		}
	
		
}

/**
 * 根据parentid获取子分类
 * @param categoryid
 * @param num，
 */
function getNewsCategorylistByParentid(categoryid,num,type)
{
	$.ajax({
  		url:getRequestUrl("/HomeController/queryNewsCategoryListByParentCategoryid.json"),
    	dataType:"json",
    	data:{"zlBNewsCategory.categoryid":categoryid,"num":100,"type":type},
      	success:function(result){
//      		var newslisttopHtml = $("#xinxicangku2Template").render(result.data);
      		var addHtml = $("#categoryTemplate").render(result.data);
			$("#categorylist").html(addHtml);
     		$("#list").html(result.category.categoryname);
     		$("#sname").append(result.category.categoryname);
     		$("#sname2").append(result.category.categoryname);
     		$("#menuclass").append(" - "+result.category.categoryname);
     		if(result.category.url!=null && result.category.url!=""){
     			url=result.category.url;	
     		}
     		
     		
     		
		//新闻种类列表动态效果
		$("#categorylist li").each(function(index) {
			$(this).click(function(){			
			$(this).addClass("red")
			$(this).siblings("li").removeClass("red")
			})
			});
		$("#"+opid).click();
		
      	},
      	error:function(error){
      		console.log('Error...');
      	}
   })
}
//初始化新闻列表
function queryDataList(id,type,classname){
	$("#sname").html(classname);
	var parameterData = {
			url:getRequestUrl("/HomeController/queryNewsList.json"),
			successfunc:renderListDataFun,
			customArray:{"zlBNews.categoryid":id,"zlBNews.type":type},
			pageller:"pagefoot",
			pageIndex:1,
			pageSize:9
	};
	pageBarFortable(parameterData)
}

function renderListDataFun(result){
	 
		$( "#dataListId" ).html(
			$("#dataListTemplate").render(result)
		);
	 
	//奇偶行颜色不同
	$('.tablelist tbody tr:odd').addClass('odd');
}

//跳转新闻详细页
function todetaildepage(id,permissions){
	if(permissions<=syspermissions){	
	var page="/HomeController/todetail.do?opid="+id;
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
/**
 * 跳转新闻详细
 * @param id
 */
function gotonewsdetail(id){
		var page="/HomeController/"+url+"detail.do?opid="+id;
		 pageForward(page);
}

