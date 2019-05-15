
$(function(){
	initPage();
});

/**
 * 初始化页面
 * */
function initPage(){
	$.ajax({
		url:getRequestUrl("/ipm/ZlBTradingRecodeController/loadZlBTradingRecode.json"),
		dataType:"json",
		data:{"zlBTradingRecode.tradingid":opid},
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
	
	$(".datepicker").datetimepicker({
		timepicker:false,
		format:'Y-m-d'
	});	
		
	$("#closeBtn").bind('click',function(){
		returnMainPage();
	});
	
		
	$("#submitBtn").bind('click',function(){
		var checkfalg=	checkFormValue('formbody');
		if(checkfalg){
			$(this).unbind();
			var postData = collectData("formbody");

			$.ajax({
				url:getRequestUrl("/ipm/ZlBTradingRecodeController/saveUpdateZlBTradingRecode.json"),
				dataType:"json",
				data:postData,
				success:function(result){
					pageForward("/ipm/ZlBTradingRecodeController/list.do");
				},
				error:function(error){
					alert("error");
				}
			});
		}
	});
	
}

function returnMainPage(){
	pageForward("/ipm/ZlBTradingRecodeController/list.do");
}
