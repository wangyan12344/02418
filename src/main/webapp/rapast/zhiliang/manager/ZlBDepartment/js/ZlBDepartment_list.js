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
	var postData = collectData("search_Form");
	var parameterData = {
			url:getRequestUrl("/ZlBDepartmentController/queryZlBDepartmentPageList.json"),
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
	$(".datepicker").datetimepicker({
		timepicker:false,
		format:'Y-m-d'
	});	
}

/**
 * 新增
 */
function addCarBrandFun(){
	var page = "/ZlBDepartmentController/add.do";
	pageForward(page);
}

/**
 * 修改
 * @param id
 */
function updateHandle(id){
	var page = "/ZlBDepartmentController/update.do?opid="+id;
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
					url:getRequestUrl("/ZlBDepartmentController/deleteZlBDepartment.json"),
					dataType:"json",
					data:{"zlBDepartment.id":id},
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
function selectAll(){
	var checklist = document.getElementsByName ("checkbox1");
	   if(document.getElementById("controlAll").checked)
	   {
	   for(var i=0;i<checklist.length;i++)
	   {
	      checklist[i].checked = 1;
	   } 
	 }else{
	  for(var j=0;j<checklist.length;j++)
	  {
	     checklist[j].checked = 0;
	  }
	 }
}
//获取复选框被选中的值
function checkval(){ 
	var obj=document.getElementsByName('checkbox1'); //选择所有name="'test'"的对象，返回数组 
	//取到对象数组后，我们来循环检测它是不是被选中 
	rowname=''; 
	for(var i=0; i<obj.length; i++){ 
	if(obj[i].checked) rowname+=obj[i].value+','; //如果选中，将value添加到变量rowname中 
	} 
	} 
/**
 * 导出列表信息到execl
 */
var rowname =''; 
function exportExcel(){
	var stime=$("#stime").val();
	var etime=$("#etime").val();
 
	checkval();
	if (rowname!='') {
	location.href=path+"/ZlBDepartmentController/exportProject.json?etime="+etime+"&stime="+stime+"&rowname="+encodeURI(encodeURI(rowname));
	} else {
		layer.alert("请选择需要导出的列，再次点击导出！");
	}
}

/**
 * 未付款-导出列表信息到execl
 */
function exportExcelNoPay(){
	var data = collectExportdata("search_Form");
	data=data+"&userid="+currentUserId;
	window.location = getRequestUrl("/zhiliang/ZlFarmerOrderstorageController/exportProjectNonPayment.do?"+data);
}