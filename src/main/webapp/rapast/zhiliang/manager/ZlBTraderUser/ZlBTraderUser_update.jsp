<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="IE=8,9,10" >
<title>用户信息修改</title>
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
    <div class="formtitle"><span>用户信息-修改</span></div>
    <ul class="forminfo">
			<!-- 交易商用户id --> <input type='hidden' name='zlBTraderUser.traderuserid' id='traderuserid'  dc='true'  maxlength='32'  value='{{:traderuserid}}' />
			<!-- 交易商用户id --> <input type='hidden' name='zlBTraderUser.traderid' id='traderid'  dc='true'  maxlength='32'  value='{{:traderid}}' />	    

			<li><label>注册用户</label><input type='text' class='dfinput' value='{{:username}}' name='zlBTraderUser.username' id='username'  dc='true'  maxlength='32'  /></li>

			<li><label>手机号</label><input type='text' class='dfinput' value='{{:mobile}}' name='zlBTraderUser.mobile' id='mobile'  dc='true'  maxlength='32' dctype='手机号'  /></li>
			<li><label>登录密码</label><input type='text' class='dfinput' value='{{:password}}' name='zlBTraderUser.password' id='password'  dc='true'  maxlength='32'  /></li>
			<li><label>注册日期</label><input type='text' class='dfinput ' value='{{:regdate}}' name='zlBTraderUser.regdate' id='regdate'  dc='true'  maxlength='32'  readonly/></li>	
			<li><label>电子邮箱</label><input type='text' class='dfinput' value='{{:email}}' name='zlBTraderUser.email' id='email'  dc='true'  maxlength='32' dctype='邮箱'  /></li>
			<li><label>是否启用</label>
<select name='zlBTraderUser.enable'  id='enable'  dc='true'    class='select1'  >{{renderOptionFun YES_NO  "codevalue"  "codename"  enable /}}</select></li>
 <li><label>阅读等级：</label>
					<select name='zlBTraderUser.permissions'  id='permissions'  dc='true'  class='select1'  ></select></li>
    
    
   </ul>
</script>


<script type="text/javascript">
	var opid = '<%=request.getParameter("opid") %>';
	var pageIndex = '<%=request.getParameter("pageIndex") %>';
</script>
<body>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="javascript:;">交易商用户信息-修改</a></li>
    </ul>
    </div>
    <div class="formbody" id="formbody">
    </div>
    <div style="margin-bottom:10px;"></div>    

<div style="margin: 40px auto 0;text-align: center;padding-bottom: 20px;">
<input name="" type="button" id="submitBtn" class="btn" value="保存"/>&nbsp;&nbsp;&nbsp;&nbsp;<input name="" id="closeBtn" type="button" class="btn" value="返回"/>
</div>
<%@ include file="/rapast/common/jsp/commonJs.jsp"%>
<script type="text/javascript" src="<%=request.getContextPath() %>/rapast/zhiliang/manager/ZlBTraderUser/js/ZlBTraderUser_update.js"></script>
</body>
</html>
