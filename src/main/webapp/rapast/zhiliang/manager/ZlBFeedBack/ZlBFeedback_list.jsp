<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="IE=8,9,10" >
<title>意见反馈列表页面</title>
<%@ include file="/rapast/common/jsp/commonCss.jsp"%>
</head>

<script type="text/x-jsrender" id="dataListTemplate">
 	<tr>
  	
		<td>{{:name}}</td>
  	
		<td>{{:tel}}</td>

		<td>{{:comment}}</td>
  	
		<td>{{:createtime}}</td>
    
		<td><a href="javascript:deleteHandle('{{:id}}');" class="tablelink">删除</a></td>
    </tr>
</script>
<body>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <!-- <li><a href="#">基础信息管理</a></li> -->
    <li><a href="#">意见反馈</a></li>
    </ul>
    </div>

    <div class="rightinfo">
    
    <table class="tablelist">
     <!-- 列表表头区 -->
    <thead>
    <tr>
	   
	   	<th style="text-align:center;">姓名</th>
		 	
		 <th style="text-align:center;">电话</th>
		 
		 <th style="text-align:center;">意见内容</th>
		 	
		 <th style="text-align:center;">生成时间</th>
		  
		  <th style="text-align:center;">操作</th>
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
<script type="text/javascript" src="<%=request.getContextPath() %>/rapast/zhiliang/manager/ZlBFeedBack/js/ZlBFeedback_list.js"></script>
</html>


