
$(function(){
	initPage();
});

/**
 * 初始化页面
 * */
function initPage(){
	$.ajax({
		url:getRequestUrl("/ZlBAppActivityController/loadZlBAppActivity.json"),
		dataType:"json",
		data:{"zlBAppActivity.id":opid},
		success:function(data){
			var addHtml = $("#formTemplate").render(data.entity);
			$("#formbody").html(addHtml);
			
			
	 	
	        //用于何处 下拉框数据绑定
	        createSelectByCodeList('ishas','yesorno');
	        $("#ishas").val(data.entity.ishas);
	        createSelectByDB("tag","zl_b_app_activity_tag","pname","pid", "");
	        $("#tag").val(data.entity.type);
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
		width : 230			  
	});
	
	$("#closeBtn").bind('click',function(){
		returnMainPage();
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
				url:getRequestUrl("/ZlBAppActivityController/saveUpdateZlBAppActivity.json"),
				dataType:"json",
				data:postData,
				success:function(result){
					pageForward("/ZlBAppActivityController/list.do");
				},
				error:function(error){
					alert("error");
				}
			});
		}
	});
	
}

function returnMainPage(){
	pageForward("/ZlBAppActivityController/list.do");
}
