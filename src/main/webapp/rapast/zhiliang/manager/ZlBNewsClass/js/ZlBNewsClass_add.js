
$(function(){
	
	initPage();
	bindevent();
	
});


/**
 * 初始化页面
 * */
/**
 * 根据parentid查询子分类
 */
function initPage(){
	createSelectByCodeList('status','YES_NO');
	createSelectByCodeList('permissions','NEWS_CLASS_TYPE');
	$.ajax({
		url:getRequestUrl("/manager/ZlBNewsClassController/beforeAddEntitySelectterminal.json"),
		dataType:"json",
		data:{"zlBNewsCategory.categoryid":id},	
		success:function(data){	
				if(data.entity!=null && data.entity!=""){
						document.getElementById("typename").innerText=data.entity.categoryname;
						 $("#permissions").val(data.entity.permissions);
				}else{
					document.getElementById("typename").innerText="顶级分类";
					document.getElementById("levelid").value=level;
					
					$("#urlnumid").show();
					$("#classtype").show();
					}
		},
		error:function(error){
			
		}
	});
}

function bindevent(){
//	bindValidateEvent("formbody");
	
//	 var url = $('#imgurl1').attr("src");
//	 if(url==""||url==null)
//	 {
//		 $('#imgurl1').attr("src","/zlm/rapast/common/images/zhiliang_log.png");
//	 }
	
	
//	createSelectByDB("permissions","sys_permissions_user","pname","id", "");
	$(".select1").uedSelect({
		width : 235			  
	});
	//返回
	$("#closeBtn").bind('click',function(){
		returnMainPage();
	});
	
	//保存
	$("#submitBtn").bind('click',function(){
		var checkfalg=	checkFormValue('formbody');
		if(checkfalg){
			$(this).unbind();
			var postData = collectData("formbody");
			postData = $.extend({"zlBNewsCategory.categoryid":id,"zlBNewsCategory.parentid":parentid,"zlBNewsCategory.level":level},postData);
			$.ajax({
				url:getRequestUrl("/manager/ZlBNewsClassController/saveAddZlBNewsCategory.json"),
				dataType:"json",
				data:postData,
				success:function(result){
					pageForward("/manager/ZlBNewsClassController/list.do");
				},
				error:function(error){
//					alert("error");
				}
			});
		}
	});
	
}
/**
 * 上传图片信息
 */
function upload2(){
	   var parameterData = {
				successfunc:showresult2,
				uploadId:"uploadFile2",
				//modelForder:"SeedsInfo",
		};
	   ajaxFileUpload(parameterData);		  
}
function showresult2(data){	
	  $("#indeximgurl").attr("value",data.opfileupload[0].filepath);//配置默认图片
	  $("#imgurl2").attr("src",data.opfileupload[0].filepath);//配置默认图片
}
/**
 * 上传图片信息
 */
function upload1(){
	   var parameterData = {
				successfunc:showresult1,
				uploadId:"uploadFile1",
				modelForder:"SeedsInfo"
		};
	   ajaxFileUpload(parameterData);	
	  
}
function showresult1(data){	
	
	  $("#imgurla").attr("value",data.opfileupload[0].filepath);//配置默认图片
	  $("#imgurl1").attr("src",data.opfileupload[0].filepath);//配置默认图片
}

function returnMainPage(){
	pageForward("/manager/ZlBNewsClassController/list.do");
}
/**
 * 上传图片信息
 */
function upload(){
	   var parameterData = {
				successfunc:showresult,
				uploadId:"uploadFile",
				//modelForder:"SeedsInfo",
		};
	   ajaxFileUpload(parameterData);		  
}
function showresult(data){	
	  $("#imgurl").attr("value",data.opfileupload[0].filepath);//配置默认图片
	  $("#imgurl1").attr("src",data.opfileupload[0].filepath);//配置默认图片
}