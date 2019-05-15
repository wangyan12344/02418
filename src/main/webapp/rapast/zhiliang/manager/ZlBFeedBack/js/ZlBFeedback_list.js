$(function(){
	initPage();

});


/**
 * 初始化页面 
 */
function initPage() {

	queryDataList();
}


/**
 * 查询方法
 */
function queryDataList(){
	
	var parameterData = {
			url:getRequestUrl("/ipm/ZlBFeedbackController/queryZlBFeedbackPageList.json"),
			successfunc:renderListDataFun,
			customArray:"",
			pageller:"pagefoot",
			pageIndex:1,
			pageSize:40,
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
 * 删除信息
 * @param id
 */
function deleteHandle(id){
	var message = "确认删除？";
	layer.confirm(
			message,
			function(index){
				$.ajax({
					url:getRequestUrl("/ipm/ZlBFeedbackController/deleteZlBFeedback.json"),
					dataType:"json",
					data:{"zlBFeedBack.id":id},
					success:function(data){
						if(data.flag==1){
							layer.alert("删除成功",1);
							queryDataList();
						}else{
							layer.alert("删除失败",2);
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
