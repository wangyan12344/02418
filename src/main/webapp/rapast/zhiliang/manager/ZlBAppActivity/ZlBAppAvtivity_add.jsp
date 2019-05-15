<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="IE=8,9,10" >
<title>添加</title>
<%@ include file="/rapast/common/jsp/commonCss.jsp"%>
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
</head>
<body>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">添加信息</a></li>
    </ul>
    </div>
    
    <div class="formbody" id="formbody">
    
    <div class="formtitle"><span>添加</span></div>
    
    <ul class="forminfo" id="editForm">
	  	    	
	    
			<!--  <input type='hidden' name='zlBAppActivity.id' id='id'  dc='true'  maxlength='64'   /> -->
	    
	    <li><label>标题</label><input type='text' class='dfinput'  name='zlBAppActivity.activityname' id='activityname' dcrequired='请输活动名' dc='true'    /></li>
	   <br> <li><label>分类</label><select name='zlBAppActivity.type' id='tag' dcrequired='请选择分类' dc='true'    class='select1'  ></select></li>
	  	<br>    <li><label>链接地址</label><input type='text' class='dfinput'  name='zlBAppActivity.activityurl' id='activityurl' dcrequired='请输活动路径' dc='true'  /></li>
		<br>	<li><label>是否启用</label><select name='zlBAppActivity.ishas' id='ishas' dcrequired='请选择是否启用' dc='true'    class='select1'  ></select></li>
		<br>	<li><label>备注</label><input type='text' class='dfinput'  name='zlBAppActivity.remark' id='remark'  dc='true'     /></li>
		
    </ul>
    
    </div>
    
<div style="margin: 40px auto 0;text-align: center;padding-bottom: 20px;">
<input name="" type="button" id="subBnt" class="btn" onclick="saveForm()" value="保存"/>&nbsp;&nbsp;&nbsp;&nbsp;<input name="" id="closeBtn" type="button" class="btn" value="返回"/>
</div>
<%@ include file="/rapast/common/jsp/commonJs.jsp"%>
<script type="text/javascript" src="<%=request.getContextPath() %>/rapast/zhiliang/manager/ZlBAppActivity/js/ZlBAppAvtivity_add.js"></script>
</body>
</html>


