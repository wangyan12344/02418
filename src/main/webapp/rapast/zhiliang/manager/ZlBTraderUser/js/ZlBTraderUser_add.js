
$(function(){
	initPage();
	
});

/**
 * 初始化页面
 * */
function initPage(){
//	$.ajax({
//		url:getRequestUrl("/manager/ZlBTraderUserController/loadZlBTraderUser.json"),
//		dataType:"json",
//		data:{"zlBTraderUser.traderuserid":opid},
//		success:function(data){
//			var addHtml = $("#formTemplate").render(data.entity);
//			$("#formbody").html(addHtml);
			
			//证件类型 下拉框数据绑定
			createSelectByCodeList('cardtype','SF_TYPE');
	      //  $("#cardtype").val(data.entity.cardtype);
	        
	      //是否管理员 下拉框数据绑定
			createSelectByCodeList('isadmin','YES_NO');
	     //   $("#isadmin").val(data.entity.isadmin);
	        
	      //是否财务 下拉框数据绑定
			createSelectByCodeList('isfinance','YES_NO');
	      //  $("#isfinance").val(data.entity.isfinance);
	        
	        //是否交易员 下拉框数据绑定
			createSelectByCodeList('istrader','YES_NO');
	     //   $("#istrader").val(data.entity.istrader);
	        
	        //是否启用 下拉框数据绑定
			createSelectByCodeList('enable','YES_NO');
	      //  $("#enable").val(data.entity.enable);
	        
			bindevent();
//		},
//		error:function(error){
//			alert("error");
//		}
//	});
}

function bindevent(){
	bindValidateEvent("formbody");
	//下拉框样式
	$(".select1").uedSelect({
		width : 235			  
	});
	
	
	//返回
	$("#closeBtn").bind('click',function(){
		pageForward("/manager/ZlBTraderUserController/list.do");
	});
	//日期
	$(".datepicker").datetimepicker({
		timepicker:false,
		format:'Y-m-d'
	});
	//保存
	$("#submitBtn").bind('click',function(){
		var checkfalg=	checkFormValue('editForm');
		if(checkfalg){
			$(this).unbind();
			var postData = collectData("editForm");
			$.ajax({
				url:getRequestUrl("/manager/ZlBTraderUserController/saveAddZlBTraderUser.json"),
				dataType:"json",
				data:postData,
				
				success:function(result){
					pageForward("/manager/ZlBTraderUserController/list.do");
				},
				error:function(error){
					alert("error");
				}
			});
		}
	});
	
}

