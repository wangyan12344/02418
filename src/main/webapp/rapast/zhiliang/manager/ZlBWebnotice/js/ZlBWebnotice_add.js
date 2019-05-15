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
	
	$("#closeBtn").bind('click',function(){
		returnMainPage();
	});
	
	initUEditor({
		"editorid":"memo",
		"width":800,
		"height":200,
		"propertyname":"zlBWebNotice.comment",
		"content":"  "
	});
	$(".datepicker").datetimepicker({
		timepicker:true,
		format:'Y-m-d H:i:s'
	});
}


function saveForm(){
	
	var checkfalg=	checkFormValue('editForm');
	if(checkfalg){
		var postData = collectData("editForm");
		$.ajax({
			url:getRequestUrl("/ipm/ZlBWebnoticeController/saveAddZlBWebnotice.json"),
			dataType:"json",
			data:postData,
			success:function(result){
				if(result.opflag){
					layer.msg(result.opmessage);
					//关闭后的操作
					pageForward("/ipm/ZlBWebnoticeController/list.do");
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

function returnMainPage(){
	pageForward("/ipm/ZlBWebnoticeController/list.do");
}