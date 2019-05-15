<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="IE=8,9,10" >
<title>链接管理</title>
<%@ include file="/rapast/common/jsp/commonCss.jsp"%>
</head>

<script type="text/x-jsrender" id="dataListTemplate">
 	<tr>
		<td>{{:activityname}}</td>
  		<td>{{:typename}}</td>
		<td>{{transcode:ishas kind='yesorno'}}</td>
  	
		<td>{{:activityurl }}</td>
  	
		<td>{{:ctime}}</td>
		
		<td>{{:remark}}</td>
    
		<td><a href="javascript:updateHandle('{{:id}}');" class="tablelink">查看/修改</a> <a href="javascript:deleteHandle('{{:id}}');" class="tablelink">删除</a></td>
    </tr>
</script>
<body>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">链接/图片管理</a></li>
    <li><a href="#">链接管理</a></li>
    </ul>
    </div>

    <div class="rightinfo">
    	<div class="tools">
	        <ul class="seachform" style="display:inline !important;" id="search_Form">
	        <!-- 查询条件form begin-->
	         <li><label>启用状态</label>
	  				<select name='zlBAppActivity.ishas' id='ishas' dc="true" class='select1'  >
	  				</select>
	  				<span style='color:red;display:inline;'>&nbsp;</span>
	  				</li>
	  				<li><label>所属分类</label>
	  				<select name='zlBAppActivity.type' id='tag' dc="true" class='select1'  >
	  				</select>
	  				<span style='color:red;display:inline;'>&nbsp;</span>
	  				</li>
			<!-- 查询条件end -->   
			    <li><label>&nbsp;</label><input name="" type="button" class="scbtn" id="search_btn" value="查询"/></li>
		    </ul>
		    
	    	<ul class="toolbar1">
	        <li><a href="<%=request.getContextPath() %>/ZlBAppActivityController/add.do" target="rightFrame"><span><img src="<%=request.getContextPath() %>/rapast/common/images/t01.png" /></span>添加</a></li>
	        </ul>
    	</div>
    	
    
    <table class="tablelist">
     <!-- 列表表头区 -->
    <thead>
    <tr>
	     	
		 <th style="text-align:center;">名称</th>
		 <th style="text-align:center;">分类</th>
		 <th style="text-align:center;">是否启用</th>
		 <th style="text-align:center;">链接地址</th>
		 <th style="text-align:center;">创建时间</th>
		 <th style="text-align:center;">备注</th>
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
<script type="text/javascript" src="<%=request.getContextPath()%>/rapast/zhiliang/manager/ZlBAppActivity/js/ZlBAppAvtivity_list.js"></script>
</html>


