<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="IE=8,9,10" >
<title>电子行刊列表</title>
<%@ include file="/rapast/common/jsp/commonCss.jsp"%>
</head>

<script type="text/x-jsrender" id="dataListTemplate">
 	<tr>
  	
		<td>{{:title}}</td>
		<td><img src="{{:imgurl}}" width="100px" height="133px"></td>
    	<td>{{:url}}</td>
    
		<td><a href="javascript:updateHandle('{{:id}}');" class="tablelink">修改</a> <a href="javascript:deleteHandle('{{:id}}');" class="tablelink">删除</a></td>
    </tr>
</script>
<body>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">链接/图片管理</a></li>
    <!-- <li><a href="#">基础信息管理</a></li> -->
    <li><a href="#">电子行刊管理</a></li>
    </ul>
    </div>

    <div class="rightinfo">
    	<div class="tools">
	      
	    	<ul class="toolbar1">
	        <li><a href="<%=request.getContextPath() %>/ZlBMagazineController/add.do" target="rightFrame"><span><img src="<%=request.getContextPath() %>/rapast/common/images/t01.png" /></span>添加</a></li>
	        </ul>
    	</div>
    	
    
    <table class="tablelist">
     <!-- 列表表头区 -->
    <thead>
    <tr>
	     	
		 <th style="text-align:center;">标题<!-- <input type="checkbox" name="checkbox1" value="部门名称-D.departmentname" > --></th>
		 <th style="text-align:center;">图片<!-- <input type="checkbox" name="checkbox1" value="排序-D.num" > --></th>
		   <th style="text-align:center;">链接地址<!-- <input type="checkbox" name="checkbox1" value="排序-D.num" > --></th>
		  
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
<script type="text/javascript" src="<%=request.getContextPath() %>/rapast/zhiliang/manager/ZlBMagazine/js/ZlBMagazine_list.js"></script>
</html>


