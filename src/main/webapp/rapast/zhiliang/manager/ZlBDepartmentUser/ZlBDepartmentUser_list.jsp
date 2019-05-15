<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="IE=8,9,10" >
<title>部门人员管理</title>
<%@ include file="/rapast/common/jsp/commonCss.jsp"%>
</head>

<script type="text/x-jsrender" id="dataListTemplate">
 	<tr>
  	
		<td>{{:departmentname}}</td>
	
  		<td>{{:departmentuser}}</td>
<td>{{:newsnum}}</td>
		<td>{{:num}}</td>
  	
	
    
		<td><a href="javascript:updateHandle('{{:id}}');" class="tablelink">修改</a> <a href="javascript:deleteHandle('{{:id}}');" class="tablelink">删除</a></td>
    </tr>
</script>
<body>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">用户及权限管理</a></li>
    <!-- <li><a href="#">基础信息管理</a></li> -->
    <li><a href="#">部门人员 管理</a></li>
    </ul>
    </div>

    <div class="rightinfo">
    	<div class="tools">
	        <ul class="seachform" style="display:inline !important;" id="search_Form">
	        <!-- 查询条件form begin-->
	         
			    <li><label>部门名称</label>
			    <select name='zlBDepartmentUser.departmentid'   id='departmentid' dc="true" class='select1' dc='true'   >
	  				</select>
	  				</li>
			 
			<!-- 查询条件end -->   
			    <li><label>&nbsp;</label><input name="" type="button" class="scbtn" id="search_btn" value="查询"/></li>
		    <li><label>&nbsp;</label><input name="" type="button" class="scbtn" value="导出Excel信息" onclick="exportExcel()" style="width:150px"></li>
		     </ul>
		    
	    	<ul class="toolbar1">
	        <li><a href="<%=request.getContextPath() %>/ZlBDepartmentUserController/add.do" target="rightFrame"><span><img src="<%=request.getContextPath() %>/rapast/common/images/t01.png" /></span>添加</a></li>
	        </ul>
    	</div>
    	
    
    <table class="tablelist">
     <!-- 列表表头区 -->
    <thead>
    <tr>
	     	
		 <th style="text-align:center;">部门名称<input type="checkbox" name="checkbox1" value="部门名称-D.departmentname" ></th>
		
		 	 <th style="text-align:center;">姓名<input type="checkbox" name="checkbox1" value="姓名-D.departmentuser" ></th>
		 	   <th style="text-align:center;">投稿数量<input type="checkbox" name="checkbox1" value="投稿数量-D.newsnum" ></th>
		 <th style="text-align:center;">排序<input type="checkbox" name="checkbox1" value="排序-D.num" ></th>
		  
		<th style="text-align:center;">操作<input onclick="selectAll()" type="checkbox"   name="checkbox"  id="controlAll" ></th>
    </tr>
    </thead>
    
    <!-- 列表数据区 -->
    <tbody  id="dataListId">
    </tbody>
    
    </table>
    
    
   <!-- 分页页码 -->
    <div class="pagin" id="pagefoot">
    </div>
    
    </div>

</body>
<%@ include file="/rapast/common/jsp/commonJs.jsp"%>
<script type="text/javascript" src="<%=request.getContextPath() %>/rapast/zhiliang/manager/ZlBDepartmentUser/js/ZlBDepartmentUser_list.js"></script>
</html>


