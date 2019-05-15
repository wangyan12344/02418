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
 * 初始化查询
 */
function queryDataList(){
	var parameterData = {
			url:getRequestUrl("/ipm/ZlBWebnoticeController/queryZlBWebnoticePageList.json"),
			successfunc:renderListDataFun,
			customArray:"",
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
	cutStr(200);
	//奇偶行颜色不同
	$('.tablelist tbody tr:odd').addClass('odd');
}

function cutStr(len){
    var obj=document.getElementById('table1').getElementsByTagName('td');
    for (i=0;i<obj.length;i++){
        obj[i].innerHTML=obj[i].innerHTML.substring(0,len);
    }
}


/**
 * 新增
 */
function addCarBrandFun(){
	var page = "/ipm/ZlBWebnoticeController/add.do";
	pageForward(page);
}

/**
 * 修改
 * @param id
 */
function updateHandle(id){
	var page = "/ipm/ZlBWebnoticeController/update.do?opid="+id;
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
					url:getRequestUrl("/ipm/ZlBWebnoticeController/deleteZlBWebnotice.json"),
					dataType:"json",
					data:{"zlBWebNotice.id":id},
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
