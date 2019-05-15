
var url="index";
$(function(){
	initpage();
	
});

function initpage(){

	queryDataList();
}
 
//初始化新闻列表
function queryDataList(){
	var parameterData = {
			url:getRequestUrl("/HomeController/queryZlBMagazinePageList.json"),
			successfunc:renderListDataFun,
			customArray:{},
			pageller:"pagefoot",
			pageIndex:1,
			pageSize:18
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
 
