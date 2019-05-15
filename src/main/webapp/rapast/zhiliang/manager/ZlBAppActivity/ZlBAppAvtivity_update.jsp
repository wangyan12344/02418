<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="IE=8,9,10" >
<title>修改</title>
<%@ include file="/rapast/common/jsp/commonCss.jsp"%>
</head>
<style type="text/css">
	.forminfo li{
		display:inline-flex;
	}
	.forminfo li label{
		padding-left: 10px;
	}
	.dfinput{
		width:235px !important;
	}
</style>
<script type="text/x-jsrender" id="formTemplate">
    <div class="formtitle"><span>修改</span></div>
    <ul class="forminfo">
    		 <input type='hidden' name='zlBAppActivity.id' id='id'  dc='true'  maxlength='64' value="{{:id}}" /> 
	    	<li><label>标题</label><input type='text' class='dfinput'  name='zlBAppActivity.activityname' id='activityname' dcrequired='请输入标题' dc='true' value="{{:activityname}}"   /></li>
		<br>
			<li><label>分类</label><select name='zlBAppActivity.type' id='tag'  dcrequired='请选择分类' dc='true'   class='select1'  ></select></li>
		<br>
	  	    <li><label>链接</label><input type='text' class='dfinput'  name='zlBAppActivity.activityurl' id='activityurl' dcrequired='请输链接' dc='true' value="{{:activityurl}}"   /></li>
			<br>
			<li><label>是否启用</label><select name='zlBAppActivity.ishas' id='ishas'  dcrequired='请选择是否开始' dc='true'    class='select1'  ></select></li>
	    <br>
			<li><label>备注</label><input type='text' class='dfinput'  name='zlBAppActivity.remark' id='remark'  dc='true' value="{{:remark}}"  />&nbsp;</li>
    </ul>
</script>


<script type="text/javascript">
	var opid = '<%=request.getParameter("opid") %>';
</script>
<body>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="javascript:;">修改</a></li>
    </ul>
    </div>
    <div class="formbody" id="formbody">
    </div>
    <div style="margin-bottom:10px;"></div>    

<div style="margin: 40px auto 0;text-align: center;padding-bottom: 20px;">
<input name="" type="button" id="submitBtn" class="btn" value="保存"/>&nbsp;&nbsp;&nbsp;&nbsp;<input name="" id="closeBtn" type="button" class="btn" value="返回"/>
</div>
<%@ include file="/rapast/common/jsp/commonJs.jsp"%>
<script type="text/javascript" src="<%=request.getContextPath() %>/rapast/zhiliang/manager/ZlBAppActivity/js/ZlBAppAvtivity_update.js"></script>
</body>
</html>
