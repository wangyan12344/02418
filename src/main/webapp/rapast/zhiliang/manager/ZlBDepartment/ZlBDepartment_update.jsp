<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="IE=8,9,10" >
<title>修改</title>
<%@ include file="/rapast/common/jsp/commonCss.jsp"%>
</head>
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
<script type="text/x-jsrender" id="formTemplate">
    <div class="formtitle"><span>修改</span></div>
    <ul class="forminfo">
    
	  	    	
	    
			<!--  --> <input type='hidden' name='zlBDepartment.id' id='id'  dc='true'  maxlength='64'  value='{{:id}}' />
	    
	  	    	
	    
			<li><label>部门名称</label><input type='text' class='dfinput' value='{{:departmentname}}' name='zlBDepartment.departmentname' id='departmentname' dcrequired='请输入部门名称' dc='true'  maxlength='100'  /></li>
		
	  	    	
	    
			<li><label>排序</label><input type='text' class='dfinput' value='{{:num}}' name='zlBDepartment.num' id='num' dcrequired='请输入排序' dc='true'  maxlength='32'  /></li>
		
	 
	
    </ul>
</script>


<script type="text/javascript">
	var opid = '<%=request.getParameter("opid") %>';
</script>
<body>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
       <li><a href="#">用户及权限管理</a></li>
    <li><a href="#">部门管理</a></li>
    </ul>
    </div>
    <div class="formbody" id="formbody">
    </div>
    <div style="margin-bottom:10px;"></div>    

<div style="margin: 40px auto 0;text-align: center;padding-bottom: 20px;">
<input name="" type="button" id="submitBtn" class="btn" value="保存"/>&nbsp;&nbsp;&nbsp;&nbsp;<input name="" id="closeBtn" type="button" class="btn" value="返回"/>
</div>
<%@ include file="/rapast/common/jsp/commonJs.jsp"%>
<script type="text/javascript" src="<%=request.getContextPath() %>/rapast/zhiliang/manager/ZlBDepartment/js/ZlBDepartment_update.js"></script>
</body>
</html>
