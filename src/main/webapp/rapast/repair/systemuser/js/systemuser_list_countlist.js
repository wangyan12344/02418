$(function(){
	initPage();
	bindevent();
});


/**
 * 初始化页面
 * */
function initPage(){
	queryDataList();
}

/**
 * 绑定事件
 */
function bindevent(){
	$("#search_btn").bind('click',queryDataList);
}
var pageIndex;
/**
 * 查询方法
 */
function queryDataList(){
	if(pageIndexback!="null"){
		pageIndex=pageIndexback;
	}else{
		pageIndex=1;
	}
	var postData = collectData("search_area");
	var parameterData = {
			url:getRequestUrl("/SysUserInfoController/queryCountDataList.json"),
			successfunc:renderListDataFun,
			customArray:postData,
			pageller:"pagefoot",
			pageIndex:pageIndex,
			pageSize:50,
			checkedId:"checkboxGroupId",
			isAsync:false
	};
	pageBarFortable(parameterData)
}

//回调
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
function addEntityDataFun(){
	var page = "/rapast/repair/systemuser/systemuser_add.jsp";
	pageForward(page);
}

/**
 * 修改
 * @param id
 */
function updateEntityDataFun(id){
	pageIndex = $('#pagefoot .current  input').val();
	var page = "/rapast/repair/systemuser/systemuser_update.jsp?userid="+id+"&pageIndex="+pageIndex;
	pageForward(page);
}

/**
 * 删除信息
 * @param id
 */
function deleteDataFun(id){
	var message = "确认删除？";
	layer.confirm(
			message,
			function(index){
				$.ajax({
					url:getRequestUrl("/SysUserInfoController/deleteEntityData.json"),
					dataType:"json",
					data:{"sysUserInfo.userid":id},
					success:function(result){
						layer.alert("删除成功",1);
						queryDataList();
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

/**
 * 
 * @param id
 */
function stopEntityDataFun(id){
	var message = "确认停用？";
	layer.confirm(
			message,
			function(index){
				$.ajax({
					url:getRequestUrl("/SysUserInfoController/stopEntityData.json"),
					dataType:"json",
					data:{"sysUserInfo.userid":id},
					success:function(result){
						layer.alert("操作成功",1);
						queryDataList();
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

