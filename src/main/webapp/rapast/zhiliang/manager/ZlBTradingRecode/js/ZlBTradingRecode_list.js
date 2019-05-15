$(function(){
	initPage();
});


/**
 * 初始化页面 
 */
function initPage() {
	$("#search_btn").bind('click',queryDataList);
    
	queryDataList();
}


/**
 * 查询方法
 */
function queryDataList(){
	var postData = collectData("search_Form");
	var parameterData = {
			url:getRequestUrl("/ipm/ZlBTradingRecodeController/queryTradingRecodeList.json"),
			successfunc:renderListDataFun,
			customArray:postData,
			pageller:"pagefoot",
			pageIndex:1,
			pageSize:20,
			isAsync:false
	};
	pageBarFortable(parameterData)
}

/**
 * 列表查询的回调渲染
 */
function renderListDataFun(result){
	$( "#dataListId" ).html(
		$("#dataListTemplate").render(result)
	);
	//奇偶行颜色不同
	$('.tablelist tbody tr:odd').addClass('odd');
}

/**
 * 新增
 */
function addCarBrandFun(){
	var page = "/ipm/ZlBTradingRecodeController/add.do";
	pageForward(page);
}
/**
 * 修改
 */
function updateHandle(id){
	pageForward("/ipm/ZlBTradingRecodeController/update.do?opid="+id);
}

/**
 * 删除信息
 * @param id
 */
function deleteHandle(id){
	var message = "确认删除？";
	layer.confirm(
			message,
			function(index){
				$.ajax({
					url:getRequestUrl("/ipm/ZlBTradingRecodeController/deleteZlBTradingRecode.json"),
					dataType:"json",
					data:{"zlBTradingRecode.tradingid":id},
					success:function(data){
						if(data.flag==1){
							layer.alert("删除成功",1);
							queryDataList();
						}else{
							layer.alert("删除失败",3);
						}
					},
					error:function(error){
						alert("error");
					}
				});
				layer.close(index);
			},
			"删除信息",
			function(index){
				layer.close(index);
				return;
			}
	);
}
