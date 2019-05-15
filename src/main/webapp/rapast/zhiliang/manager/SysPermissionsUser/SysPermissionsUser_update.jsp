<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="IE=8,9,10" >
<title>阅读级别管理</title>
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
    <div class="formtitle"><span>阅读级别修改</span></div>
    <ul class="forminfo">
    
	  	    	
	    
			<!-- id --> <input type='hidden' name='sysPermissionsUser.id' id='id'  dc='true'  maxlength='32'  value='{{:id}}' />
	    
	  	    	
	    
			<li><label>阅读级别</label><input type='text' class='dfinput' value='{{:pname}}' name='sysPermissionsUser.pname' id='pname' dcrequired='请输入角色id' dc='true'  maxlength='100'  /></li>
		
	  	    	
	    
			<li><label>阅读级别id</label><input type='text' class='dfinput' value='{{:pid}}' name='sysPermissionsUser.pid' id='pid' dcrequired='请输入用户id' dc='true'  maxlength='64'  /></li>
		
	  	    	
	
    </ul>
</script>


<script type="text/javascript">
	var opid = '<%=request.getParameter("opid") %>';
</script>
<body>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="javascript:;">阅读级别管理</a></li>
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
<script type="text/javascript" src="<%=request.getContextPath() %>/rapast/zhiliang/manager/SysPermissionsUser/js/SysPermissionsUser_update.js"></script>
</body>
</html>
