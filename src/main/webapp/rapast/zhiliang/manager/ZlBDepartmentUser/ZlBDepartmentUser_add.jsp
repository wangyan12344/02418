<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="IE=8,9,10" >
<title>B端app首页活动添加</title>
<%@ include file="/rapast/common/jsp/commonCss.jsp"%>
<style type="text/css">
	.forminfo li{
		display:inline-flex;
		    width: 100%;
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
    <li><a href="#">用户及权限管理</a></li>
    <li><a href="#">部门人员管理</a></li>
    </ul>
    </div>
    
    <div class="formbody" id="formbody">
    
    <div class="formtitle"><span>添加</span></div>
    
    <ul class="forminfo" id="editForm">
	  	    	
	    
		 
	    
	  	    	
	    
			<li><label>部门名称</label><select name='zlBDepartmentUser.departmentid' id='departmentid' dcrequired='请输入部门名称' dc='true'  maxlength='100'  class='select1'  >VALUECONTEXTUUU</select></li>
		
	  	    	
			<li><label>姓名</label><input type='text' class='dfinput' VALUECONTEXTUUU name='zlBDepartmentUser.departmentuser' id='departmentuser' dcrequired='请输入' dc='true'  maxlength='255'  /></li>
		
	    
			<li><label>排序</label><input type='text' class='dfinput' VALUECONTEXTUUU name='zlBDepartmentUser.num' id='num' dcrequired='请输入排序' dc='true'  maxlength='32'  /></li>
		
	  	    	
	    
	 
    </ul>
    
    </div>
    
<div style="margin: 40px auto 0;text-align: center;padding-bottom: 20px;">
<input name="" type="button" id="subBnt" class="btn" onclick="saveForm()" value="保存"/>&nbsp;&nbsp;&nbsp;&nbsp;<input name="" id="closeBtn" type="button" class="btn" value="返回"/>
</div>
<%@ include file="/rapast/common/jsp/commonJs.jsp"%>
<script type="text/javascript" src="<%=request.getContextPath() %>/rapast/zhiliang/manager/ZlBDepartmentUser/js/ZlBDepartmentUser_add.js"></script>
</body>
</html>


