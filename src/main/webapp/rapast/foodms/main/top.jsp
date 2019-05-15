<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="IE=8,9,10" >
<title>无标题文档</title>
<%@ include file="/rapast/common/jsp/commonCss.jsp"%>

</head>

<body style="background:url(<%=request.getContextPath() %>/rapast/common/images/topbg.gif) repeat-x;">

    <div class="topleft">
    <a href="main.html" target="_parent"><img src="<%=request.getContextPath() %>/rapast/common/images/loginlogo.png" title="系统首页" /></a>
    </div>
        
    <ul class="nav">
    <%-- <li><a href="default.html" target="rightFrame" class="selected"><img src="<%=request.getContextPath() %>/rapast/common/images/icon01.png" title="工作台" /><h2>工作台</h2></a></li>
    <li><a href="imglist.html"  target="rightFrame"><img src="<%=request.getContextPath() %>/rapast/common/images/icon03.png" title="平台广告" /><h2>平台广告</h2></a></li>
    <li><a href="left.html"  target="leftFrame"><img src="<%=request.getContextPath() %>/rapast/common/images/icon06.png" title="系统平台" /><h2>系统平台</h2></a></li>
    <li><a href="left_4S.html" target="leftFrame" ><img src="<%=request.getContextPath() %>/rapast/common/images/icon02.png" title="4S店模块" /><h2>4S店模块</h2></a></li>
    <li><a href="tools.html"  target="rightFrame"><img src="<%=request.getContextPath() %>/rapast/common/images/icon04.png" title="常用工具" /><h2>常用工具</h2></a></li> --%>
    </ul>
            
    <div class="topright">    
    <ul>
    <li><span><img src="<%=request.getContextPath() %>/rapast/common/images/help.png" title="帮助"  class="helpimg"/></span><a href="javascript:;">帮助</a></li>
    <!-- <li><a href="javascript:;">关于</a></li> -->
    <li><a target="_parent" href="<%=request.getContextPath()%>/loginManagerController/showLoginPage.do">退出</a></li>
    </ul>
     
    <div class="user">
    <span id="usernameId">admin</span>
    <!-- <i>消息</i>
    <b>5</b> -->
    </div>    
    
    </div>
<%@ include file="/rapast/common/jsp/commonJs.jsp"%>
<script type="text/javascript">
$(function(){	
	//顶部导航切换
	$(".nav li a").click(function(){
		$(".nav li a.selected").removeClass("selected")
		$(this).addClass("selected");
	})	
	
	var username = parent.CsGlobalObj.sys_hidden_currentUsername;
	$("#usernameId").html(username);
})	
</script>
</body>
</html>
