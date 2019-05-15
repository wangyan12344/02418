<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="IE=8,9,10" >
<title>添加</title>
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
    
	  	    	
	    
			<!--  --> <input type='hidden' name='zlBDepartmentUser.id' id='id'  dc='true'  maxlength='64'  value='{{:id}}' />
	  
	  	    	
	    
			<li><label>部门名称</label><select name='zlBDepartmentUser.departmentid' id='departmentid' dcrequired='请输入部门名称' dc='true'  maxlength='100'  class='select1'  >{{renderOptionFun YES_NO "codevalue" "codename" departmentid /}}</select></li>
		  <li><label>姓名</label><input type='text' class='dfinput' value='{{:departmentuser}}' name='zlBDepartmentUser.departmentuser' id='departmentuser' dcrequired='请输入' dc='true'  maxlength='255'  /></li>
		
	  	    	
	    
			<li><label>排序</label><input type='text' class='dfinput' value='{{:num}}' name='zlBDepartmentUser.num' id='num' dcrequired='请输入排序' dc='true'  maxlength='32'  /></li>
		
	  	    	
	    
			
	 
	
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
    <li><a href="#">部门人员管理</a></li>
    </ul>
    </div>
    <div class="formbody" id="formbody">
    </div>
    <div style="margin-bottom:10px;"></div>    

<div style="margin: 40px auto 0;text-align: center;padding-bottom: 20px;">
<input name="" type="button" id="submitBtn" class="btn" value="保存"/>&nbsp;&nbsp;&nbsp;&nbsp;<input name="" id="closeBtn" type="button" class="btn" value="返回"/>
</div>
<%@ include file="/rapast/common/jsp/commonJs.jsp"%>
<script type="text/javascript" src="<%=request.getContextPath() %>/rapast/zhiliang/manager/ZlBDepartmentUser/js/ZlBDepartmentUser_update.js"></script>
</body>
</html>
