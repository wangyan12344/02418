
$(function(){
	initPage();
});

/**
 * 初始化页面
 * */
function initPage(){
	$.ajax({
		url:getRequestUrl("/zlb/ZlBIndexPicController/loadZlBIndexPic.json"),
		dataType:"json",
		data:{"zlBIndexPic.id":opid},
		success:function(data){
			var addHtml = $("#formTemplate").render(data.entity);
			$("#formbody").html(addHtml);
			
			
	 	
	        //用于何处 下拉框数据绑定
	        createSelectByCodeList('used','piccategory');
	        $("#used").val(data.entity.used);
	        //页面的位置
		    createSelectByCodeList('position','picposition');
		    $("#position").val(data.entity.position);
	 
		   //富文本生成
			initUEditor({
				"editorid":"memo",
				"width":1200,
				"height":1000,
				"propertyname":"zlBIndexPic.newscontent",
				"content":data.entity.newscontent  
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
				url:getRequestUrl("/zlb/ZlBIndexPicController/saveUpdateZlBIndexPic.json"),
				dataType:"json",
				data:postData,
				success:function(result){
					pageForward("/zlb/ZlBIndexPicController/list.do");
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
	pageForward("/zlb/ZlBIndexPicController/list.do");
}
