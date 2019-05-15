
$(function(){
	initBPage();
	initCPage();
});

/**
 * B端广告图初始化页面
 * */
function initBPage(){
	$.ajax({
		url:getRequestUrl("/zlb/ZlBIndexPicController/loadZlBIndexPic.json"),
		dataType:"json",
		data:{"zlBIndexPic.id":"B201703201058"},
		success:function(data){
			var addHtml = $("#formTemplateB").render(data.entity);
			$("#formbody").html(addHtml);
	 	
		  
			bindevent();
		},
		error:function(error){
			alert("error");
		}
	});
}

function bindevent(){
	
	$("#submitBtn").bind('click',function(){
			var postData = collectData("formbody");

			$.ajax({
				url:getRequestUrl("/zlb/ZlBIndexPicController/saveUpdateZlBIndexPic.json"),
				dataType:"json",
				data:postData,
				success:function(result){
					layer.alert("B端广告图保存成功！",1);
				},
				error:function(error){
					alert("error");
				}
			});
	});
	
}


/**
 * C端广告图初始化页面
 * */
function initCPage(){
	$.ajax({
		url:getRequestUrl("/zlb/ZlBIndexPicController/loadZlBIndexPic.json"),
		dataType:"json",
		data:{"zlBIndexPic.id":"C201703201059"},
		success:function(data){
			var addHtml = $("#formTemplateC").render(data.entity);
			$("#edmintbody").html(addHtml);
		  
			bindeventC();
		},
		error:function(error){
			alert("error");
		}
	});
}

function bindeventC(){
	
	$("#subBtn").bind('click',function(){
			var postData = collectData("edmintbody");

			$.ajax({
				url:getRequestUrl("/zlb/ZlBIndexPicController/saveUpdateZlBIndexPic.json"),
				dataType:"json",
				data:postData,
				success:function(result){
					layer.alert("C端广告图保存成功！",1);
				},
				error:function(error){
					alert("error");
				}
			});
	});
	
}


/**
 * B端上传图片信息
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
/**
 * C端上传图片信息
 */
function upload2(){
	   var parameterData = {
				successfunc:showresult2,
				uploadId:"uploadFile2",
				modelForder:"indexpic"
		};
	   ajaxFileUpload(parameterData);		  
}
function showresult2(data){	
	  $("#imgurl2").attr("value",data.opfileupload[0].filepath);//配置默认图片
	  $("#imgurl3").attr("src",data.opfileupload[0].filepath);//配置默认图片
}
