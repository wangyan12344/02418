$(function(){
	initPage();
	bindevent();
});


/**
 * 初始化页面 
 */
function initPage() {

     	
    //用于何处 下拉框数据绑定
    createSelectByCodeList('used','piccategory');
    
	queryDataList();
}

/**
 * 绑定事件
 */
function bindevent(){
	$("#search_btn").bind('click',queryDataList);
	
	$(".select1").uedSelect({
		width : 135			  
	});
}

/**
 * 查询方法
 */
function queryDataList(){
	var postData = collectData("search_Form");
	var parameterData = {
			url:getRequestUrl("/zlb/ZlBIndexPicController/queryZlBIndexPicPageList.json"),
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
	var page = "/zlb/ZlBIndexPicController/add.do";
	pageForward(page);
}

/**
 * 修改
 * @param id
 */
function updateHandle(id){
	var page = "/zlb/ZlBIndexPicController/update.do?opid="+id;
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
					url:getRequestUrl("/zlb/ZlBIndexPicController/deleteZlBIndexPic.json"),
					dataType:"json",
					data:{"zlBIndexPic.id":id},
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
/**
 * 是否启用
 * @param id
 * @param tag
 */
function isstopHandle(id,tag){
	var message = "是否操作启停状态？";
	layer.confirm(
			message,
   function(index){
	$.ajax({
		url:getRequestUrl("/zlb/ZlBIndexPicController/isStopZlBIndexPic.json"),
		dataType:"json",
		data:{"zlBIndexPic.id":id,"zlBIndexPic.isstop":tag},
		success:function(data){
			queryDataList();
		},
		error:function(error){
			alert("error");
		}
	});
	layer.close(index);
			},
			"状态信息",
			function(index){
				layer.close(index);
				return;
			}
	);
}
