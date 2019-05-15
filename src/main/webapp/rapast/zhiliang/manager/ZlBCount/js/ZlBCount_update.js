
$(function(){
	initPage();
});

/**
 * 初始化页面
 * */
function initPage(){
	$.ajax({
		url:getRequestUrl("/manager/ZlBCountController/loadZlBCount.json"),
		dataType:"json",
		data:{"zlBCount.id":opid},
		success:function(data){
			var addHtml = $("#formTemplate").render(data.entity);
			$("#formbody").html(addHtml);
			
			
	
	 
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
		width : 235			  
	});
	
	$("#closeBtn").bind('click',function(){
		pageForward("/manager/ZlBCountController/list.do");
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
				url:getRequestUrl("/manager/ZlBCountController/saveUpdateZlBCount.json"),
				dataType:"json",
				data:postData,
				success:function(result){
					pageForward("/manager/ZlBCountController/list.do");
				},
				error:function(error){
					alert("error");
				}
			});
		}
	});
	
}

