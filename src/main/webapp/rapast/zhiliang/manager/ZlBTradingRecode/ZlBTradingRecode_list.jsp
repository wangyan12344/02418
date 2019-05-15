<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="IE=8,9,10" >
<title>浏览记录</title>
<%@ include file="/rapast/common/jsp/commonCss.jsp"%>
</head>

<script type="text/x-jsrender" id="dataListTemplate">
 	<tr>
  	
		<td>{{:username}}</td>
		<td>{{:newstitle}}</td>
  	
  	
		<td>{{:ctime}}</td>

		<td>{{:num}}</td>

		 

		<!--<td> <a href="javascript:updateHandle('{{:tradingid}}');" class="tablelink">查看/修改</a>&nbsp;&nbsp;<a href="javascript:deleteHandle('{{:tradingid}}');" class="tablelink">删除</a></td>-->
    </tr>
</script>
<body>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">浏览记录</a></li>
    </ul>
    </div>

    <div class="rightinfo">
    	<div class="tools">
	    	
	    	<ul class="seachform" style="display:inline !important;" id="search_Form">
	        <!-- 查询条件form begin-->
	         
			    <li><label>搜索</label><input type='text' class='dfinput'  name='zlBTradingRecode.username' id='username'  dc='true' placeholder="浏览者 / 新闻标题"  style="width:300px;" /></li>
			 
			 
			<!-- 查询条件end -->   
			    <li><label>&nbsp;</label><input name="" type="button" class="scbtn" id="search_btn" value="查询"/></li>
		    </ul>
		    
 
    	</div>
    	
    
    <table class="tablelist">
     <!-- 列表表头区 -->
    <thead>
    <tr>
	     	
		 <th style="text-align:center;">浏览者</th>
		 	
		 <th style="text-align:center;">新闻标题</th>
		 	
		 <th style="text-align:center;">最后浏览时间</th>
		 
		 <th style="text-align:center;">累积浏览次数</th>
		 
		  
		 <!--  <th style="text-align:center;">操作</th> -->
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
<script type="text/javascript" src="<%=request.getContextPath() %>/rapast/zhiliang/manager/ZlBTradingRecode/js/ZlBTradingRecode_list.js"></script>
</html>


