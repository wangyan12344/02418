$(function(){
	initPage();
	bindevent();
});
var pageIndex;

/**
 * 初始化页面 
 */
function initPage() {
	 //登陆状态 下拉框数据绑定
	createSelectByCodeList('enable','YES_NO');
	queryDataList();
}

/**
 * 绑定事件
 */
function bindevent(){
	 bindValidateEvent("search_Form");
	 $(".select1").uedSelect({
			width : 100			  
		});
$("#search_btn").bind('click',queryDataList);
	
}

/**
 * 查询方法
 */
function queryDataList(){
	if(pageIndexback!="null"){
		pageIndex=pageIndexback;
	}else{
		pageIndex=1;
	}
	var postData = collectData("search_Form");
	var parameterData = {
			url:getRequestUrl("/manager/ZlBTraderUserController/queryZlBTraderUserPageList.json"),
			successfunc:renderListDataFun,
			customArray:postData,
			pageller:"pagefoot",
			pageIndex:pageIndex,
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
	var page = "/manager/ZlBTraderUserController/add.do";
	pageForward(page);
}

/**
 * 修改
 * @param id
 */
function updateHandle(id){
	pageIndex = $('#pagefoot .current  input').val();
	var page = "/rapast/zhiliang/manager/ZlBTraderUser/ZlBTraderUser_update.jsp?opid="+id+"&pageIndex="+pageIndex;
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
					url:getRequestUrl("/manager/ZlBTraderUserController/deleteZlBTraderUser.json"),
					dataType:"json",
					data:{"zlBTraderUser.traderuserid":id},
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
