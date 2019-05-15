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
		pageForward("/ZlBMagazineController/list.do");
	});
}


function saveForm(){
	
	var checkfalg=	checkFormValue('editForm');
	if(checkfalg){
		var postData = collectData("editForm");
		$.ajax({
			url:getRequestUrl("/ZlBMagazineController/saveAddZlBMagazine.json"),
			dataType:"json",
			data:postData,
			success:function(result){
				if(result.opflag){
					layer.msg(result.opmessage);
					//关闭后的操作
					pageForward("/ZlBMagazineController/list.do");
				}else{
					layer.msg(result.opmessage);
				}
			},
			error:function(error){
			}
		});
	}
}
/**
 * 上传图片信息
 */
function upload(){
	   var parameterData = {
				successfunc:showresult,
				uploadId:"uploadFile",
				modelForder:"indexpic"
		};
	   ajaxFileUpload(parameterData);		  
}
function showresult(data){	
	  $("#imgurl").attr("value",data.opfileupload[0].filepath);//配置默认图片
	  $("#imgurl1").attr("src",data.opfileupload[0].filepath);//配置默认图片
}