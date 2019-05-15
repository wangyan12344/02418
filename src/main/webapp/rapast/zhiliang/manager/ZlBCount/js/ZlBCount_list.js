$(function(){
	initPage();
	bindevent();
});


/**
 * 初始化页面 
 */
function initPage() {

    
	queryDataList();
}

/**
 * 绑定事件
 */
function bindevent(){
	$("#search_btn").bind('click',queryDataList);
	$(".timepicker").datetimepicker({
		timepicker:false,
		format:'Y-m-d'
	});
}

/**
 * 查询方法
 */
function queryDataList(){
	var postData = collectData("search_Form");
	var parameterData = {
			url:getRequestUrl("/manager/ZlBCountController/queryZlBCountPageList.json"),
			successfunc:renderListDataFun,
			customArray:postData,
			pageller:"pagefoot",
			pageIndex:1,
			pageSize:10,
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
	var page = "/manager/ZlBCountController/add.do";
	pageForward(page);
}

/**
 * 修改
 * @param id
 */
function updateHandle(id){
	var page = "/manager/ZlBCountController/update.do?opid="+id;
	pageForward(page);
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
					url:getRequestUrl("/manager/ZlBCountController/deleteZlBCount.json"),
					dataType:"json",
					data:{"zlBCount.id":id},
					success:function(data){
						if(data.flag==1){
							layer.alert("删除成功",2);
							queryDataList();
						}else{
							layer.alert("请先删除品牌下车系",3);
						}
					},
					error:function(error){
						alert("error");
					}
				});
				layer.close(index);
			},
			"信息",
			function(index){
				layer.close(index);
				return;
			}
	);
}
