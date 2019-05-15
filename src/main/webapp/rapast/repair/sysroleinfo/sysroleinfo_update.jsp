<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="IE=8,9,10" >
<title>添加</title>
<%@ include file="/rapast/common/jsp/commonCss.jsp"%>
<link href="<%=request.getContextPath()%>/rapast/common/css/zTreeStyle/zTreeStyle.css" rel="stylesheet" type="text/css" />
</head>
<style type="text/css">
</style>
<script type="text/x-jsrender" id="formTemplate">
    <div class="formtitle"><span>角色信息信息</span></div>
    <ul class="forminfo">
    <li><label>角色名称</label><input name="sysRoleInfo.rolename" dcrequired="请输入角色名称" type="text" class="dfinput" value="{{:entity.rolename}}" dc="" /></li>
    <li><label>角色权限</label>
		<div>
			<ul id="treeDemo" style="width:335px !important;" class="ztree"></ul>
		</div>
	</li>
    </ul>
	<input type="hidden" value="{{:entity.roleid}}" name="sysRoleInfo.roleid" dc="true" />
</script>

<script type="text/javascript">
	var roleid = '<%=request.getParameter("roleid") %>';
</script>
<body>
	<div class="place">
	    <span>位置：</span>
	    <ul class="placeul">
		    <li><a href="javascript:;">用户及权限管理</a></li>
		    <li><a href="javascript:;">角色信息添加</a></li>
	    </ul>
    </div>
    <div class="formbody" id="formId">
    </div>
<div style="margin:0 auto;text-align: center;padding-bottom: 20px;">
<input name="" type="button" id="submitBtn" class="btn" value="修改"/>&nbsp;&nbsp;&nbsp;&nbsp;<input name="" id="closeBtn" type="button" class="btn" value="返回"/>
</div>
</body>
<%@ include file="/rapast/common/jsp/commonJs.jsp"%>
<script type="text/javascript" src="<%=request.getContextPath() %>/rapast/repair/sysroleinfo/js/sysroleinfo_update.js"></script>
</html>