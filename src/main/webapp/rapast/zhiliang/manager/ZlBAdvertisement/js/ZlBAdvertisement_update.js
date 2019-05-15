
$(function(){
	initPage();
});

/**
 * 初始化页面
 * */
function initPage(){
	$.ajax({
		url:getRequestUrl("/zlb/ZlBAdvertisementController/loadZlBAdvertisement.json"),
		dataType:"json",
		data:{"zlBAdvertisement.id":opid},
		success:function(data){
			var addHtml = $("#formTemplate").render(data.entity);
			$("#formbody").html(addHtml);
			 createSelectByDB("tag","zl_advertisement_tag","pname","pid", "");
			 $("#tag").val(data.entity.tag);
			 createSelectByCodeList('status','YES_NO');
			 $("#status").val(data.entity.status);
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
				url:getRequestUrl("/zlb/ZlBAdvertisementController/saveUpdateZlBAdvertisement.json"),
				dataType:"json",
				data:postData,
				success:function(result){
					pageForward("/rapast/zhiliang/manager/ZlBAdvertisement/ZlBAdvertisement_list.jsp");
				},
				error:function(error){
					alert("error");
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

function returnMainPage(){
	pageForward("/rapast/zhiliang/manager/ZlBAdvertisement/ZlBAdvertisement_list.jsp");
}
