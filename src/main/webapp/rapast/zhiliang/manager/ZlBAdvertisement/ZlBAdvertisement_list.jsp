<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="IE=8,9,10" >
<title>轮播图管理</title>
<%@ include file="/rapast/common/jsp/commonCss.jsp"%>
</head>

<script type="text/x-jsrender" id="dataListTemplate">
 	<tr>
  	
		<td>{{:company}}</td>
  	
		<td>{{:pname}}</td>
  	
		<td>{{transcode:status kind='yesorno'}}</td> 

	 <td><a href="{{:imgurl}}" class="tablelink" target="_blank"><img src="{{:img}}" width="100px"   style ="padding-top:10px;"></a></td>  
 
		<td>{{if status==1}}<a href="javascript:isstopHandle('{{:id}}','0','{{:tag}}');" class="tablelink">停用</a>{{else}}<a href="javascript:isstopHandle('{{:id}}','1','{{:tag}}');" class="tablelink">启用</a>{{/if}}&nbsp;&nbsp;<a href="javascript:updateHandle('{{:id}}');" class="tablelink">查看/修改</a>&nbsp;&nbsp; <a href="javascript:deleteHandle('{{:id}}');" class="tablelink">删除</a></td>
    </tr>
</script>
<body>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">链接/图片管理</a></li>
    <!-- <li><a href="#">基础信息管理</a></li> -->
    <li><a href="#">轮播图管理</a></li>
    </ul>
    </div>

    <div class="rightinfo">
    	<div class="tools">
	        <ul class="seachform" style="display:inline !important;" id="search_Form">
	        <!-- 查询条件form begin-->
		    </ul>
		    
	    	<ul class="toolbar1">
	        <li><a href="<%=request.getContextPath() %>/rapast/zhiliang/manager/ZlBAdvertisement/ZlBAdvertisement_add.jsp" target="rightFrame"><span><img src="<%=request.getContextPath() %>/rapast/common/images/t01.png" /></span>添加</a></li>
	        </ul>
    	</div>
    	
    
    <table class="tablelist">
     <!-- 列表表头区 -->
    <thead>
    <tr>
	     	
		 <th style="text-align:center;">标题</th>
		 	
		 <th style="text-align:center;">图片位置</th>
		 	
		  
		 <th style="text-align:center;">是否启用</th>	
		  
		 <th style="text-align:center;">查看图片</th>	 
		  
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
<script type="text/javascript" src="<%=request.getContextPath() %>/rapast/zhiliang/manager/ZlBAdvertisement/js/ZlBAdvertisement_list.js"></script>
</html>


