
$(function(){
	initPage();
});

/**
 * 初始化页面
 * */
function initPage(){
	$.ajax({
		url:getRequestUrl("/ZlBDepartmentUserController/loadZlBDepartmentUser.json"),
		dataType:"json",
		data:{"zlBDepartmentUser.id":opid},
		success:function(data){
			var addHtml = $("#formTemplate").render(data.entity);
			$("#formbody").html(addHtml);
			
			
	 	
	        //部门名称 下拉框数据绑定
			createSelectByDB('departmentid','zl_b_department','departmentname','id', ' order by num+0 asc ');
	        $("#departmentid").val(data.entity.departmentid);
	
	 
			bindevent();
		},
		error:function(error){
			alert("error");
		}
	});
}

function bindevent(){
	bindValidateEvent("formbody");
	
	$(".select1").uedSelect({
		width : 180			  
	});
		
	
	$("#closeBtn").bind('click',function(){
		pageForward("/ZlBDepartmentUserController/list.do");
	});
	
	$(".datepicker").datetimepicker({
		timepicker:false,
		format:'Y-m-d'
	});
	
	$("#submitBtn").bind('click',function(){
		var checkfalg=	checkFormValue('formbody');
		if(checkfalg){
			$(this).unbind();
			var postData = collectData("formbody");

			$.ajax({
				url:getRequestUrl("/ZlBDepartmentUserController/saveUpdateZlBDepartmentUser.json"),
				dataType:"json",
				data:postData,
				success:function(result){
					pageForward("/ZlBDepartmentUserController/list.do");
				},
				error:function(error){
					alert("error");
				}
			});
		}
	});
	
}

