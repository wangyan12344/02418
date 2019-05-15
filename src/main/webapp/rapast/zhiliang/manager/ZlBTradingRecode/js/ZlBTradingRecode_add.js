$(function(){
	
	bindevent();
});




/**
 * 绑定事件
 */
function bindevent(){
	
	
	$("#closeBtn").bind('click',function(){
		returnMainPage();
	});
	
	$(".datepicker").datetimepicker({
		timepicker:false,
		format:'Y-m-d'
	});	
}


function saveForm(){
	
		var postData = collectData("editForm");
		$.ajax({
			url:getRequestUrl("/ipm/ZlBTradingRecodeController/saveAddZlBTradingRecode.json"),
			dataType:"json",
			data:postData,
			success:function(result){
				if(result.opflag){
					layer.msg(result.opmessage);
					//关闭后的操作
					pageForward("/ipm/ZlBTradingRecodeController/list.do");
				}else{
					layer.msg(result.opmessage);
				}
			},
			error:function(error){
				alert("error");
			}
		});
	}


function returnMainPage(){
	pageForward("/ipm/ZlBTradingRecodeController/list.do");
}


