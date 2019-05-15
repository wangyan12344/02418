$(function(){
	initPage();
});
/**
 * 根据parentid查询子分类
 */
function initPage(){
	
	$.ajax({
		url:getRequestUrl("/manager/ZlBNewsClassController/beforeAddEntitySelectterminal.json"),
		dataType:"json",
		data:{"zlBNewsCategory.categoryid":id,"zlBNewsCategory.parentid":parentid},	
		success:function(data){			
//				var typelevel=data.entity.level;
			if(data.entity.parentid=="0")
			{			
				// $("#urlnum").attr("disabled","true");
				 $("#classtype").show();
				 $("#urlnumid").show();	
			}else{
				$("#ordernumid").show();	
			}
			
			document.getElementById("classname").value=data.entity.categoryname;
			document.getElementById("typeparentid").value=data.entity.parentid;
			document.getElementById("typeid").value=data.entity.categoryid;	
			document.getElementById("levelid").value=data.entity.level;	
			
//			document.getElementById("imgurl1").src=data.entity.imgurl;	
			document.getElementById("urlnum").value=data.entity.urlnum;
			document.getElementById("ordernum").value=data.entity.ordernum;
//			document.getElementById("imgurl2").src=data.entity.indeximgurl;	
//			document.getElementById("indeximgurl").value=data.entity.indeximgurl;
			document.getElementById("content").value=data.entity.content;
//			$("#parentTypeCode").val(data.entity.parentTypeCode);	
//			$("#typeCode").val(data.entity.typeCode);
			createSelectByCodeList('status','YES_NO');
		    $("#status").val(data.entity.status);
		    createSelectByCodeList('permissions','NEWS_CLASS_TYPE');
//			createSelectByDB("permissions","sys_permissions_user","pname","id", "");
			$("#permissions").val(data.entity.permissions);
			bindevent();
		},
		error:function(error){
			alert("信息查询失败");
		}
	});
}


/**
 * 列表查询的回调渲染
 */
function renderListDataFun(result){
	//$("#dataListId").html($("#dataListTemplate").render(result));
	//奇偶行颜色不同
	$('.tablelist tbody tr:odd').addClass('odd');
}
function bindevent(){
	$(".select1").uedSelect({
		width : 230			  
	});
	bindValidateEvent("formId");
	$("#closeBtn").bind('click',function(){
		pageForward('/rapast/zhiliang/manager/ZlBNewsClass/ZlBNewsClass_list.jsp');
	});
	

	
	$("#submitBtn").bind('click',function(){
		//询问框 
		update();
	});
	

}
function update(){
	var checkfalg=	checkFormValue('formbody');
	if(checkfalg){
		$(this).unbind();
		//level=level+1;
		var userData = collectData("formbody");			
		var postData = $.extend({},userData);
		$.ajax({
			url:getRequestUrl("/manager/ZlBNewsClassController/saveUpdateZlBNewsCategory.json"),
			dataType:"json",
			data:postData,			
			success:function(result){
				if(result.opflag){
					layer.msg('修改成功', 2,1, function(){
						pageForward('/rapast/zhiliang/manager/ZlBNewsClass/ZlBNewsClass_list.jsp');
					});   	
					
				}else{
					layer.msg(result.opmessage, 2,1);
				}
				
				
			},
			error:function(error){
				alert("error");
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
				//modelForder:"SeedsInfo",
		};
	   ajaxFileUpload(parameterData);		  
}
function showresult(data){	
	  $("#imgurl").attr("value",data.opfileupload[0].filepath);//配置默认图片
	  $("#imgurl1").attr("src",data.opfileupload[0].filepath);//配置默认图片
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

function checkTypeCodeRepeatForupdate(obj){
	$.ajax({
		url:getRequestUrl("/ZlGoodTypeController/checkTypeCodeRepeatForupdate.json"),
		dataType:"json",
		data:{"zlGoodType.typeCode":$(obj).val(),"zlGoodType.id":id},			
		success:function(result){	
			if(result.checkflag){
				layer.msg("类别编码不可重复");
			}
										
		},
		error:function(error){
			alert("error");
		}
	});
}
