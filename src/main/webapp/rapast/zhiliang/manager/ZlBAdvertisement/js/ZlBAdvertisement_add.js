$(function(){

	bindevent();
});




/**
 * 绑定事件
 */
function bindevent(){
	bindValidateEvent("formbody");
	 createSelectByCodeList('status','YES_NO');
	createSelectByDB("tag","zl_advertisement_tag","pname","pid", "");
	$(".select1").uedSelect({
			width : 230			  
	});

	 var url = $('#imgurl1').attr("src");
	 if(url==""||url==null)
	 {
		 $('#imgurl1').attr("src","/zlm/rapast/common/images/zhiliang_log.png");
	 }
	
	
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
		//var userPost=$.extend({},postData,{"zlBIndexPic.newstitle":$("#newstitle").val()},{"zlBIndexPic.newscontent":$("#newscontent").val()});
		$.ajax({
			url:getRequestUrl("/zlb/ZlBAdvertisementController/saveAddZlBAdvertisement.json"),
			dataType:"json",
			data:postData,
			success:function(result){
		
					//关闭后的操作
					pageForward("/rapast/zhiliang/manager/ZlBAdvertisement/ZlBAdvertisement_list.jsp");
				
				
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

function returnMainPage(){
	pageForward("/rapast/zhiliang/manager/ZlBAdvertisement/ZlBAdvertisement_list.jsp");
}