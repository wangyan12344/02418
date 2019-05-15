$(function(){
	initPage();
	bindevent();
});


/**
 * 初始化页面
 * */

function initPage(){
	  	
	    //用于何处 下拉框数据绑定
	    createSelectByCodeList('used','piccategory');
	    //页面的位置
	    createSelectByCodeList('position','picposition');
	    
	  var  timestamp = Date.parse(new Date());   //生成时间戳
	    $("#picid").val(timestamp);
	    
	    $("#visiturl").val('https://www.zhiliangwang.com/rapast/pageHtml/jsp/newDome/news_detail.jsp?opid='+timestamp);
	    
	    //生成一个800-1500之间随机数
	    Math.random()*700
	    var num = Math.random()*700 + 800;
	    num = parseInt(num, 10);
	    $("#readnum").val(num);

	    
	   
}
//按点击次数判断，奇数次隐藏，偶数次显示
var checkval=0;
function SelectedCheck () {
	checkval++;
	
	    if (checkval%2==1) {
	    	$("#visiturl").hide();
	    } else {
	    	$("#visiturl").show();
	    }
}

/**
 * 绑定事件
 */
function bindevent(){
	bindValidateEvent("formbody");
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
	//富文本生成
	initUEditor({
		"editorid":"memo",
		"width":1200,
		"height":1000,
		"propertyname":"zlBIndexPic.newscontent",
		"content":"  "
	});
	
}


function saveForm(){
	if (checkval%2==1) {
		$("#visiturl").val("");
	}
	var checkfalg=	checkFormValue('editForm');
	
	if(checkfalg){
		var postData = collectData("editForm");
		//var userPost=$.extend({},postData,{"zlBIndexPic.newstitle":$("#newstitle").val()},{"zlBIndexPic.newscontent":$("#newscontent").val()});
		$.ajax({
			url:getRequestUrl("/zlb/ZlBIndexPicController/saveAddZlBIndexPic.json"),
			dataType:"json",
			data:postData,
			success:function(result){
		
					//关闭后的操作
					pageForward("/zlb/ZlBIndexPicController/list.do");
				
				
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
