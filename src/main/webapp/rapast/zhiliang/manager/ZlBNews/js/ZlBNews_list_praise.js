$(function(){
	initseachform();
	initPage();	
	
} );

function initseachform(){
	$.ajax({
		url:getRequestUrl("/manager/ZlBNewsController/beforeAddEntity.json"),
		dataType:"json",
		data:{},
		success:function(data){			
			var addHtml = $("#formTemplate").render(data);
			$("#search_Form").html(addHtml);
			bindevent();
			
		},
		error:function(error){
			alert("error");
		}
		
	});
}

/**
 *初始化页面
 */
function initPage() {
	queryDataList();
	queryCount();
	queryVisitcount();
	queryPercent();
}

/**
 * 查询新闻列表
 * @param 
 */
function search(){
	$("#search_btn").bind('click',initPage);
}


/**
 * 根据表单分页条件查询
 */
function queryDataList(){
	
	var userData = collectData("search_Form");
		var parameterData = {
				url:getRequestUrl("/manager/ZlBNewsController/queryZlBNewsPageListByPraise.json"),
				successfunc:renderListDataFun,
				customArray:userData,
				pageller:"pagefoot",
				pageIndex:1,
				pageSize:50,
				isAsync:false
		};
		pageBarFortable(parameterData)
				
	
}


function bindevent(){
	bindValidateEvent("formId");

	$(".select1").uedSelect({
		width : 180			  
	});
			
	$(".datepicker").datetimepicker({
		timepicker:false,
		format:'Y-m-d'
	});
	
	$('#search_Form').bind('keyup', function(event) {  
		if (event.keyCode == "13") {  
			$("#search_btn").click();  
		}  
	}); 
	search();
}
/**
 * 列表查询的回调渲染
 */
function renderListDataFun(result){	
	$("#dataListId").html(
		$("#dataListTemplate").render(result)
	);
	$('.tablelist tbody tr:odd').addClass('odd');	
	
}

/**
 * 修改新闻
 * @param  
 */
function updateHandle(id){
	var page = "/manager/ZlBNewsController/update.do?opid="+id;
	pageForward(page);
}


/**
 * 删除新闻
 * @param id
 */
function deleteHandle(id){
	var message = "确认删除？";
	layer.confirm(
			message,
			function(index){
				$.ajax({
					url:getRequestUrl("/manager/ZlBNewsController/deleteZlBNews.json"),
					dataType:"json",
					data:{"zlBNews.newsid":id},						
					success:function(data){
						if(data.flag==1){
							layer.alert("删除成功",2);
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


function pushnews(id){
	
	var message = "确认要向所有用户提送此消息？";
	layer.confirm(
			message,
			function(index){
				$.ajax({
					url:getRequestUrl("/manager/ZlBNewsController/pushZlBNews.json"),
					dataType:"json",
					data:{"zlBNews.newsid":id},						
					success:function(data){
						if(data.opflag){
							layer.alert("操作成功",1);
							queryDataList();
						}else{
							layer.alert("操作失败",3);
						}
					},
					error:function(error){
						alert("网络原因操作失败！");
					}
				});
				layer.close(index);
			},
			"推送信息",
			function(index){
				layer.close(index);
				return;
			}
	);
	
}

/**
 * 导出列表信息到execl
 */
function exportExcel(){
/*	var newstitle=$("#newstitle").val();
	var categoryid=$("#categoryid").val();
	location.href=path+"/zlw/ZlCommissionerController/exportProject.do?newstitle="+newstitle+"&categoryid="+categoryid;

*/
}

//总数量
function queryCount(){
	var postData = collectData("search_Form");
	$.ajax({
		url:getRequestUrl("/manager/ZlBNewsController/queryZlBNewsCount.json"),
		dataType:"json",
		data:postData,
		success:function(data){
			$("#count").html(data.entity.count);
		},
		error:function(error){
			alert("error");
		}
	});
}

//总阅读量
function queryVisitcount(){
	var postData = collectData("search_Form");
	$.ajax({
		url:getRequestUrl("/manager/ZlBNewsController/queryZlBNewsVisitcount.json"),
		dataType:"json",
		data:postData,
		success:function(data){
			$("#visitcount").html(data.entity.visitcount);
		},
		error:function(error){
			alert("error");
		}
	});
}

//阅读百分比
function queryPercent(){
	var postData = collectData("search_Form");
	$.ajax({
		url:getRequestUrl("/manager/ZlBNewsController/queryZlBNewsPercent.json"),
		dataType:"json",
		data:postData,
		success:function(data){
			$("#percent").html(data.entity.percent+"%");
		},
		error:function(error){
			alert("error");
		}
	});
}
/**
 * 根据一级分类、获取二级分类联动加载下拉框
 */
function firstchange(){
	var id=$("#fvalue").val();
	$.ajax({
		url:getRequestUrl("/manager/ZlBNewsController/getZlBNewsCategoryListByParentid.json"),
		dataType:"json",
		data:{"zlBNewsCategory.categoryid":id,"zlBNewsCategory.parentid":id},
		success:function(data){
			$("#svalue").empty();
			$("#svalue").append("<option selected='selected' value=''>请选择</option>");
			for(var i=0;i<data.zlBNewsCategoryList.length;i++){
				var svalue=data.zlBNewsCategoryList[i].categoryid;
				var sname=data.zlBNewsCategoryList[i].categoryname;
				$("#svalue").append("<option value="+svalue+">"+sname+"</option>");
			}
			//secondchange();			
		},
		error:function(error){
			alert("error");
		}
		
	});
}
