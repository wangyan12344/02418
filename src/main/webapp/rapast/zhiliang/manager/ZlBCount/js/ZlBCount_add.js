$(function(){
	initPage();
	bindevent();
});


/**
 * 初始化页面
 * */
function initPage(){
	 
}

/**
 * 绑定事件
 */
function bindevent(){
	bindValidateEvent("formbody");
	$(".select1").uedSelect({
			width : 237			  
	});
	
	$(".datepicker").datetimepicker({
		timepicker:false,
		format:'Y-m-d'
	});	
	
	$("#closeBtn").bind('click',function(){
		pageForward("/manager/ZlBCountController/list.do");
	});
}


function saveForm(){
	
	var checkfalg=	checkFormValue('editForm');
	if(checkfalg){
		var postData = collectData("editForm");
		$.ajax({
			url:getRequestUrl("/manager/ZlBCountController/saveAddZlBCount.json"),
			dataType:"json",
			data:postData,
			success:function(result){
				if(result.opflag){
					layer.msg(result.opmessage);
					//关闭后的操作
					pageForward("/manager/ZlBCountController/list.do");
				}else{
					layer.msg(result.opmessage);
				}
			},
			error:function(error){
				alert("error");
			}
		});
	}
}
