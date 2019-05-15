$(function(){
	initPage();
	bindevent();
});


/**
 * 初始化页面
 * */
function initPage(){
	  	
	    //是否开始
	    createSelectByCodeList('ishas','yesorno');
	    createSelectByDB("tag","zl_b_app_activity_tag","pname","pid", "");
	    
}

/**
 * 绑定事件
 */
function bindevent(){
	bindValidateEvent("formbody");
	$(".select1").uedSelect({
			width : 230			  
	});
	
	$(".datepicker").datetimepicker({
		timepicker:false,
		format:'Y-m-d'
	});	
	
	$("#closeBtn").bind('click',function(){
		returnMainPage();
	});
}


function saveForm(){
	
	var checkfalg=	checkFormValue('editForm');
	if(checkfalg){
		var postData = collectData("editForm");
		$.ajax({
			url:getRequestUrl("/ZlBAppActivityController/saveAddZlBAppActivity.json"),
			dataType:"json",
			data:postData,
			success:function(result){
				if(result.opflag){
					layer.msg(result.opmessage);
					//关闭后的操作
					pageForward("/ZlBAppActivityController/list.do");
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
	pageForward("/ZlBAppActivityController/list.do");
}