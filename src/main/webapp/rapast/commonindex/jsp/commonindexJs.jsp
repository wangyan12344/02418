<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.repast.core.constant.SysConstant"%>
<%@ page import="com.repast.core.util.CommonUtil" %>    
<script src="<%=request.getContextPath()%>/rapast/commonindex/js/jquery-1.8.3.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/rapast/commonindex/js/jsrender.mini.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/rapast/commonindex/js/main.js" type="text/javascript"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/rapast/commonindex/layui/css/layui.css">
<script src="<%=request.getContextPath()%>/rapast/commonindex/layui/layui.js" type="text/javascript"></script>
<script type="text/javascript">
	var path = '<%=request.getContextPath()%>';
	var CsGlobalObj = {};
	CsGlobalObj.currentUserid ='';
	CsGlobalObj.sys_hidden_deviceType = 'PC';
	CsGlobalObj.sys_hidden_contact='';
	CsGlobalObj.sys_hidden_storeId='';
	CsGlobalObj.sys_hidden_shopid='';
	CsGlobalObj.sys_hidden_currentUsername = '';
	
</script>
	
	
	