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

}

/**
 * 查询方法
 */
function queryDataList(){
	var userData = collectData("search_Form");
	var parameterData = {
			url:getRequestUrl("/manager/ZlBNewsClassController/queryZlBNewsClassList.json"),
			successfunc:renderListDataFun,
			customArray:userData,
			pageller:"pagefoot",
			pageIndex:1,
			pageSize:1000,
			isAsync:false
	};
	pageBarFortable(parameterData)
}

/**
 * 列表查询的回调渲染
 */
function renderListDataFun(result){
	$("#dataListId").html($("#dataListTemplate").render(result));
	
	//奇偶行颜色不同
	$('.tablelist tbody tr:odd').addClass('odd');
}

/**
 * 新增
 */
function addCarBrandFun(){
	var page = "/manager/ZlBNewsClassController/add.do";
	pageForward(page);
}

/**
 * 修改
 * @param id
 */
function updateHandle(id){
	var page = "/manager/ZlBNewsClassController/update.do?opid="+id;
	pageForward(page);
}
/**
 * 新增
 */
function addEntityDataFun(id,pid,level){
	
	var page = "/rapast/zhiliang/manager/ZlBNewsClass/ZlBNewsClass_add.jsp?id="+id+"&parentid="+pid+"&level="+level+"";
	pageForward(page);
}
/**
 * 修改
 * @param id
 */
function updateEntityDataFun(id,parentid){
	var page = "/rapast/zhiliang/manager/ZlBNewsClass/ZlBNewsClass_update.jsp?id="+id+"&parentid="+parentid;
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
					url:getRequestUrl("/manager/ZlBNewsClassController/deleteZlBNewsCategory.json"),
					dataType:"json",
					data:{"zlBNewsCategory.categoryid":id},
					success:function(data){
						if(data.flag==1){
							layer.alert("删除成功",2);
							queryDataList();
						}else{
							layer.alert("",3);
						}
					},
					error:function(error){
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
