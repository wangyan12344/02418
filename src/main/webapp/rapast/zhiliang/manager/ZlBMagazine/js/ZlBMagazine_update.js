
$(function(){
	initPage();
});

/**
 * 初始化页面
 * */
function initPage(){
	debugger;
	$.ajax({
		url:getRequestUrl("/ZlBMagazineController/loadZlBMagazine.json"),
		dataType:"json",
		data:{"zlBMagazine.id":opid},
		success:function(data){
			var addHtml = $("#formTemplate").render(data.entity);
			$("#formbody").html(addHtml);
			
			
	
	 
			bindevent();
		},
		error:function(error){
		}
	});
}

function bindevent(){
	bindValidateEvent("formbody");
	
	$(".select1").uedSelect({
		width : 235			  
	});
	
	$("#closeBtn").bind('click',function(){
		pageForward("/ZlBMagazineController/list.do");
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
				url:getRequestUrl("/ZlBMagazineController/saveUpdateZlBMagazine.json"),
				dataType:"json",
				data:postData,
				success:function(result){
					pageForward("/ZlBMagazineController/list.do");
				},
				error:function(error){
				}
			});
		}
	});
	
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
