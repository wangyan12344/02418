<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>接口</title>
<%@ include file="/rapast/interface/paramtemplate.jsp"%>
</head>
<body>
	<div>
		<select id="selectinterfaceno">
			<option value="0" selected="selected" >请选择</option>
			<option value="1">（2、3）查询酒店列表</option>
		</select>
		<input type="button" value="execute" id="executeInterfaceId" />
	</div>
	<div>
		<div style="color: blue;font-weight: bold;margin-top: 10px;">
			parameters：
		</div>
		<div id="allparamsArea">
			<div id="publicparams">
				<div style="font-weight: bold;float: left;">公共参数--></div>
				<div style="float: left;margin-left:10px;">
					<div>
						<span>页码：</span><span>processor.pageIndex</span>&nbsp;&nbsp;&nbsp;&nbsp;
						<input name="processor.pageIndex" type="text" dc="true" value="1"/>
					</div>
					<div>
						<span>每页条数：</span><span>processor.pageSize</span>&nbsp;&nbsp;&nbsp;&nbsp;
						<input name="processor.pageSize" type="text" dc="true" value="-1"/>
					</div>
					<div>
						<span>当前用户ID：</span><span>processor.currentUserId</span>&nbsp;&nbsp;&nbsp;&nbsp;
						<input name="processor.currentUserId" type="text" dc="true" />
					</div>
					<div>
						<span>业务ID：</span><span>processor.restaurantid</span>&nbsp;&nbsp;&nbsp;&nbsp;
						<input name="processor.restaurantid" type="text" dc="true" />
					</div>
					<div>
						<span>设备类型：</span><span>processor.deviceType</span>&nbsp;&nbsp;&nbsp;&nbsp;
						<input name="processor.deviceType" type="text" dc="true" />
					</div>
				</div>
				<div style="clear: both;"></div>
			</div>
			<div style="margin-top:15px;">
				<div style="font-weight: bold;float: left;">业务参数--></div>
				<div id="parametersId" style="float: left;margin-left:10px;">
					
				</div>
				<div style="clear: both;"></div>
			</div>
		</div>
	</div>
	<div>
		<div style="color: blue;font-weight: bold;margin-top: 10px;">
			ajaxurl：
		</div>
		<div id="ajaxurlId">
			
		</div>
	</div>
	<div>
		<div style="color: blue;font-weight: bold;margin-top: 10px;">
			result：
		</div>
		<div id="resultId">
			
		</div>
	</div>
<%@ include file="/rapast/common/jsp/commonJs.jsp"%>
<script type="text/javascript">
var interfaObject = {
	"1" : {//by lingy
		template : "oriPaginationTemplate",
		handlerfun : "successHandler",
		ajaxurl : "/restaurantInfoController/queryRestaurantInfoPagination.json"
	}
};
</script>
<script type="text/javascript">

$(function(){
	
	$("#selectinterfaceno").change(function(){
		$("#parametersId").html("");
		$("#ajaxurlId").html("");
		$("#resultId").html("");
		var interfaceno = $(this).val();
		if(interfaceno=="0"){
			return;
		}
		var ajaxUrl = interfaObject[interfaceno].ajaxurl;
		$("#ajaxurlId").html(ajaxUrl);
		var templateid = interfaObject[interfaceno].template;
		if($("#"+templateid+"").length<=0){
			return;
		}
		var renderHtml = $("#"+templateid+"").render("");
		$("#parametersId").html(renderHtml);
	});
	
	$("#executeInterfaceId").click(function(){
		var interfaceno = $("#selectinterfaceno").val();
		var handlerFun = interfaObject[interfaceno].handlerfun;
		var ajaxUrl = interfaObject[interfaceno].ajaxurl;
		if(interfaceno=="0"||checkEmpty(handlerFun)||checkEmpty(ajaxUrl)) return;
		var paramsData = collectData("allparamsArea");
		$.ajax({
			url:path+ajaxUrl,
			dataType:"json",
			data:paramsData,
			success:function(result){
				eval(handlerFun+"(result)");
			},
			error:function(error){
				alert("error");
			}
		});
	});
	
});

function checkEmpty(checkparam){
	if(typeof checkparam=='undefined' || checkparam=="" || checkparam==null || checkparam==undefined){
		return true;
	}else{
		return false;
	}
}
</script>
<script src="<%=request.getContextPath()%>/rapast/interface/suchandler.js" type="text/javascript"></script>
</body>
</html>
