<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="IE=8,9,10" >
<title>欢迎登录葫芦岛银行管理平台</title>
<%@ include file="/rapast/common/jsp/commonCss.jsp"%>
</head>

<body style="background-color: #1c77ac; background-image: url(<%=request.getContextPath() %>/rapast/common/images/light.png); background-repeat: no-repeat; background-position: center top; overflow: hidden;">
	<div id="mainBody">
		<div id="cloud1" class="cloud"></div>
		<div id="cloud2" class="cloud"></div>
	</div>
	<div class="logintop">
		<span>欢迎登录葫芦岛银行管理平台</span>
		<ul>
			<li><a href="<%=request.getContextPath() %>">回首页</a></li>
		<!-- 	<li><a href="javascript:;">帮助</a></li>
			<li><a href="javascript:;">关于</a></li> -->
		</ul>
	</div>
	<div class="loginbody">
		<span class="systemlogo"></span>
		<div class="loginbox" id="loginbox">
			<ul>
				<li><input type="text" class="loginuser" placeholder="用户名" id="loginname" name="sysUserInfo.account" dc="true" value=''/></li>
				<li><input type="password" class="loginpwd" placeholder="密码" id="password" name="sysUserInfo.password" dc="true" value=''/></li>
				<li><input type="button" class="loginbtn" value="登录" onclick="login();" />
<!-- 				<label><input name="" type="checkbox" value="" checked="checked" />记住密码</label><label><a href="javascript:;">忘记密码？</a></label> -->
				</li>
			</ul>
		</div>
	</div>
	<div class="loginbm">
		版权所有 2018 葫芦岛市山区澎盛网络科技有限公司
	</div>
</body>
<%@ include file="/rapast/common/jsp/commonJs.jsp"%>
<script type="text/javascript">
	$(function() {
		$('.loginbox').css({
			'position' : 'absolute',
			'left' : ($(window).width() - 692) / 2
		});
		$(window).resize(function() {
			$('.loginbox').css({
				'position' : 'absolute',
				'left' : ($(window).width() - 692) / 2
			});
		})
	});
</script>
<script src="<%=request.getContextPath()%>/rapast/foodms/login/js/login.js" type="text/javascript"></script>
</html>
