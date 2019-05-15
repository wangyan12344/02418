<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="IE=8,9,10" >
<title>修改</title>
<%@ include file="/rapast/common/jsp/commonCss.jsp"%>
<link href="<%=request.getContextPath()%>/rapast/common/css/zTreeStyle/zTreeStyle.css" rel="stylesheet" type="text/css" />
</head>
<style type="text/css">
	.forminfo li{
	line-height: 30px;
	}
	.forminfo li label{
		padding-left: 10px;
	}
	.dfinput{
		width:235px !important;
	}
</style>
<script type="text/x-jsrender" id="formTemplate">
    <div class="formtitle"><span>用户信息</span></div>
    <ul class="forminfo">
<input name="sysUserInfo.gender"  type="hidden" class="dfinput" value="1" dc="" />
    <li><label>用户姓名</label><input name="sysUserInfo.username" dcrequired="请输入姓名" type="text" class="dfinput" value="{{:entity.username}}" dc="" /></li>
    <li><label>系统账号</label><input name="sysUserInfo.account" dcrequired="请输入账号" type="text" class="dfinput" value="{{:entity.account}}" dc=""  dctype="ajax校验" dcajax="{'url':'/SysUserInfoController/checkAccountUnique.json','checkattr':'sysUserInfo.account','sysUserInfo.userid':'{{:entity.userid}}'}" /></li>
    <li><label>密码</label><input name="sysUserInfo.password" dcrequired="请输入密码" type="password" class="dfinput" value="{{:entity.password}}" dc="" /></li>
  
    <li><label>是否启用</label>
		<select name="sysUserInfo.userstatus" class="select2" dc="" dcrequired="请选择">
			{{renderOptionFun yesorno "codevalue" "codename" entity.userstatus /}}
		</select>
    </li>

    <li><label>联系电话</label><input name="sysUserInfo.contacttelnumber" type="text" class="dfinput" value="{{:entity.contacttelnumber}}" dc="" /><span style="display:inline;">&nbsp;&nbsp;</span></li>
    <li><label>开通时间</label><input name="sysUserInfo.entrytime" type="text" class="dfinput datepicker" value="{{:entity.entrytime}}" dc="" /><span style="display:inline;">&nbsp;&nbsp;</span></li>
	<li style="display:block"><label>角色选择</label>
		<div style="float:left;line-height: 34px;">
		{{for roleList}}
			<span style="display:inline;padding:5px 10px 5px 0px;"><input name="roleUserList[{{:#index}}].roleid" type="checkbox" {{if checked!=""&&checked!=null}}checked="checked"{{/if}} value="{{:roleid}}" dc="" />{{:rolename}}</span>
		{{/for}}
		</div>
	</li>
 <li><label>账户身份</label>
		<select name="sysUserInfo.usertype" class="select2" dc="" dcrequired="请选择"  onchange="showclassmenu()" id="usertype">
			{{renderOptionFun USERTYPE "codevalue" "codename" entity.usertype /}}
		</select>
    </li>
  <li style="display:block" id="classmenu"><label>新闻权限</label>
		<div>
			<ul id="treeDemo" style="width:335px !important;" class="ztree"></ul>
		</div>
	</li>
    </ul>
<input type="hidden" value="{{:entity.userid}}" name="sysUserInfo.userid" dc="true" />
</script>


<script type="text/javascript">
	var userid = '<%=request.getParameter("userid") %>';
	var pageIndex = '<%=request.getParameter("pageIndex") %>';
</script>
<body>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="javascript:;">用户及权限管理</a></li>
    <li><a href="javascript:;">用户信息修改</a></li>
    </ul>
    </div>
    <div class="formbody" id="formId">
    </div>
    <div style="margin-bottom:10px;"></div>    
<!-- 可管理店铺 --> 
<%-- <div class="rightinfo">
    <div class="formtitle" style="margin-bottom:5px;"><span>可管理店铺信息</span></div>
    <div class="tools">
	    <ul class="toolbar1">
	        <li class=""><span><img src="<%=request.getContextPath() %>/rapast/common/images/t01.png"></span><a href="javascript:addManageShop();">添加</a></li>
		</ul>
    </div>
</div> --%>
<div style="margin: 40px auto 0;text-align: center;padding-bottom: 20px;">
<input name="" type="button" id="submitBtn" class="btn" value="创建"/>&nbsp;&nbsp;&nbsp;&nbsp;<input name="" id="closeBtn" type="button" class="btn" value="返回"/>
</div>
</body>
<%@ include file="/rapast/common/jsp/commonJs.jsp"%>
<script type="text/javascript" src="<%=request.getContextPath() %>/rapast/repair/systemuser/js/systemuser_update.js"></script>
</html>