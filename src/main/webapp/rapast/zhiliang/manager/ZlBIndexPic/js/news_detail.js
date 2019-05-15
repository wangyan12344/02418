$(function(){
	
	initPage();	
	
} );



/**
 *初始化页面
 */
function initPage() {
	
	queryDataList();
	
}



function queryDataList(){
	$.ajax({
		url:getRequestUrl("/zlb/ZlBIndexPicController/loadZlBIndexPic.json"),
		dataType:"json",
		data:{"zlBIndexPic.id":opid},
		success:function(data){	
			var addHtml = $("#formTemplate").render(data.entity);
			$("#newsdetail").html(addHtml);		
			
		},
		error:function(error){
			alert("error");
		}
		
	});
	
}



