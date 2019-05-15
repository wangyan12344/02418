
$(function(){
	initPage();
});

/**
 * 初始化页面
 * */
function initPage(){
	$.ajax({
		url:getRequestUrl("/ipm/ZlBWebnoticeController/loadZlBWebnotice.json"),
		dataType:"json",
		data:{"zlBWebNotice.id":opid},
		success:function(data){
			var addHtml = $("#formTemplate").render(data.entity);
			$("#formbody").html(addHtml);
			
			initUEditor({
				"editorid":"memo",
				"width":800,
				"height":200,
				"propertyname":"zlBWebNotice.comment",
				"content":data.entity.comment
			});
			$(".datepicker").datetimepicker({
				timepicker:true,
				format:'Y-m-d H:i:s'
			});
			bindevent();
		},
		error:function(error){
			alert("error");
		}
	});
}

function bindevent(){
	bindValidateEvent("formbody");
	
	
	$("#closeBtn").bind('click',function(){
		returnMainPage();
	});
	
	
	$("#submitBtn").bind('click',function(){
		var checkfalg=	checkFormValue('formbody');
		if(checkfalg){
			$(this).unbind();
			var postData = collectData("formbody");

			$.ajax({
				url:getRequestUrl("/ipm/ZlBWebnoticeController/saveUpdateZlBWebnotice.json"),
				dataType:"json",
				data:postData,
				success:function(result){
					pageForward("/ipm/ZlBWebnoticeController/list.do");
				},
				error:function(error){
					alert("error");
				}
			});
		}
	});
	
}

function returnMainPage(){
	pageForward("/ipm/ZlBWebnoticeController/list.do");
}

