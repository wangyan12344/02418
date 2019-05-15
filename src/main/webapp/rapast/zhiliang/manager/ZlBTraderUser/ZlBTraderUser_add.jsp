<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="IE=8,9,10" >
<title>交易商(个人)信息添加</title>
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
    <li><a href="#">列表</a></li>
    <li><a href="#">用户管理添加</a></li>
    </ul>
    </div>
    
    <div class="formbody" id="formbody">
    
    <div class="formtitle"><span>录入信息</span></div>
    
      <ul class="forminfo" id="editForm">
      
			<!-- 交易商用户id --> <input type='hidden' name='zlBTraderUser.traderuserid' id='traderuserid'  dc='true'  maxlength='32'  />
			<!-- 交易商用户id --> <input type='hidden' name='zlBTraderUser.traderid' id='traderid'  dc='true'  maxlength='32'   />	    

			<li><label>交易商姓名</label><input type='text' class='dfinput'  name='zlBTraderUser.username' id='username' dcrequired='请输入姓名' dc='true'  maxlength='32'  /></li>

			<li><label>登录用户名</label><input type='text' class='dfinput'  name='zlBTraderUser.account' id='account' dcrequired='请输入登录用户名' dc='true'  maxlength='32'  /></li>
		
			<li><label>登录密码</label><input type='text' class='dfinput' name='zlBTraderUser.password' id='password' dcrequired='请输入登录密码' dc='true'  maxlength='32'  /></li>
	    
			<li><label>支付密码</label><input type='text' class='dfinput'  name='zlBTraderUser.paypassword' id='paypassword' dcrequired='请输入支付密码' dc='true'  maxlength='32'  /></li>
	    
			<li><label>注册日期</label><input type='text' class='dfinput timepicker datepicker' name='zlBTraderUser.regdate' id='regdate' dcrequired='请输入注册日期' dc='true'  maxlength='32'  /></li>	

			<li><label>证件类型</label>
<select name='zlBTraderUser.cardtype'  id='cardtype'  dc='true'    class='select1'  ></select></li>
			
			<li><label>证件号码</label><input type='text' class='dfinput'  name='zlBTraderUser.cardnumber' id='cardnumber' dcrequired='请输入证件号码' dc='true'  maxlength='32' dctype='数字'  /></li>
		
			<li><label>交易商电话</label><input type='text' class='dfinput'  name='zlBTraderUser.mobile' id='mobile' dcrequired='请输入手机号码' dc='true'  maxlength='32' dctype='手机号'  /></li>
	    
			<li><label>电子邮箱</label><input type='text' class='dfinput'  name='zlBTraderUser.email' id='email' dcrequired='请输入电子邮箱' dc='true'  maxlength='32' dctype='邮箱'  /></li>
	    
			<li><label>交易商地址</label><input type='text' class='dfinput'  name='zlBTraderUser.address' id='address' dcrequired='请输入地址' dc='true'  maxlength='500'  /></li>
	    
			<li><label>是否管理员</label>
<select name='zlBTraderUser.isadmin' id='isadmin'  dc='true'  maxlength='100'  class='select1' ></select></li>
		
			<li><label>是否财务员</label>&nbsp;&nbsp;
<select name='zlBTraderUser.isfinance'  id='isfinance'  dc='true'  class='select1'  ></select></li>
	    
			<li><label>是否交易员</label>
<select name='zlBTraderUser.istrader'  id='istrader'  dc='true'  class='select1'  ></select></li>
			
			<li><label>是否启用</label>&nbsp;&nbsp;
<select name='zlBTraderUser.enable'  id='enable'  dc='true'    class='select1'  ></select></li>
    </ul>
    
    </div>
    
<div style="margin: 40px auto 0;text-align: center;padding-bottom: 20px;">
<input name="" type="button" id="submitBtn" class="btn"  value="保存"/>&nbsp;&nbsp;&nbsp;&nbsp;<input name="" id="closeBtn" type="button" class="btn" value="返回"/>
</div>
<%@ include file="/rapast/common/jsp/commonJs.jsp"%>
<script type="text/javascript" src="<%=request.getContextPath() %>/rapast/zhiliang/manager/ZlBTraderUser/js/ZlBTraderUser_add.js"></script>
</body>
</html>


