<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="IE=8,9,10" >
<title>列表页面</title>
<%@ include file="/rapast/common/jsp/commonCss.jsp"%>
</head>

<script type="text/x-jsrender" id="dataListTemplate">
 	<tr>
  	
		<td>{{transcode:used kind='piccategory'}}</td>
  	
		<td>{{transcode:position kind='picposition' }}</td>
  	
		<td>{{:ordernum}}</td>

		<td>{{:newstitle}}</td>
  	
		 <td>{{transcode:isstop kind='yesorno'}}</td> 
 
		<td>{{if isstop==1}}<a href="javascript:isstopHandle('{{:id}}','0');" class="tablelink">停用</a>{{else}}<a href="javascript:isstopHandle('{{:id}}','1');" class="tablelink">启用</a>{{/if}}&nbsp;&nbsp;<a href="javascript:updateHandle('{{:id}}');" class="tablelink">查看/修改</a>&nbsp;&nbsp; <a href="javascript:deleteHandle('{{:id}}');" class="tablelink">删除</a></td>
    </tr>
</script>
<body>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <!-- <li><a href="#">基础信息管理</a></li> -->
    <li><a href="#">占位图片列表</a></li>
    </ul>
    </div>

    <div class="rightinfo">
    	<div class="tools">
	        <ul class="seachform" style="display:inline !important;" id="search_Form">
	        <!-- 查询条件form begin-->
	         <li><label>用于</label>
	  				<select name='zlBIndexPic.used' id='used' dc="true" class='select1'  >
	  					
	  				</select>
	  				<span style='color:red;display:inline;'>&nbsp;</span>
	  				</li>
			<!-- 查询条件end -->   
			    <li><label>&nbsp;</label><input name="" type="button" class="scbtn" id="search_btn" value="查询"/></li>
		    </ul>
		    
	    	<ul class="toolbar1">
	        <li><a href="<%=request.getContextPath() %>/zlb/ZlBIndexPicController/add.do" target="rightFrame"><span><img src="<%=request.getContextPath() %>/rapast/common/images/t01.png" /></span>添加</a></li>
	        </ul>
    	</div>
    	
    
    <table class="tablelist">
     <!-- 列表表头区 -->
    <thead>
    <tr>
	     	
		 <th style="text-align:center;">用于何处</th>
		 	
		 <th style="text-align:center;">位置</th>
		 	
		 <th style="text-align:center;">序号</th>
		 
		  <th style="text-align:center;">新闻标题</th>
		  
		 <th style="text-align:center;">是否启用</th>	
		  
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
<script type="text/javascript" src="<%=request.getContextPath() %>/rapast/zhiliang/manager/ZlBIndexPic/js/ZlBIndexPic_list.js"></script>
</html>


