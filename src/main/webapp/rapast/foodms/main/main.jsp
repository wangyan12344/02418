<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="IE=8,9,10" >
<title>葫芦岛银行管理平台</title>
<script type="text/javascript">
var CsGlobalObj = {};
CsGlobalObj.currentUserid = '${sys_hidden_currentUserId}';
CsGlobalObj.sys_hidden_shopid = '${sys_hidden_shopid}';
CsGlobalObj.sys_hidden_orgid = '${sys_hidden_orgid}';
CsGlobalObj.sys_hidden_deviceType = 'PC';
CsGlobalObj.sys_hidden_ipaddress = '${sys_hidden_ipaddress}';
CsGlobalObj.sys_hidden_currentUsername = '${sys_hidden_currentUsername}';
</script>
</head>
<frameset rows="88,*" cols="*" frameborder="no" border="0" framespacing="0">
	<frame src="<%=request.getContextPath() %>/rapast/foodms/main/top.jsp" name="topFrame" scrolling="no"
		noresize="noresize" id="topFrame" title="topFrame" />
	<frameset cols="187,*" frameborder="no" border="0" framespacing="0">
		<frame src="<%=request.getContextPath() %>/rapast/foodms/main/left.jsp" name="leftFrame" scrolling="no"
			noresize="noresize" id="leftFrame" title="leftFrame" />
		<frame src="" name="rightFrame" id="rightFrame"
			title="rightFrame" />
	</frameset>
</frameset>
<noframes>
	<body>
	</body>
</noframes>
</html>
