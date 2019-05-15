<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="IE=8,9,10" >
<title>交易商用户信息列表页面</title>
<%@ include file="/rapast/common/jsp/commonCss.jsp"%>
</head>

<script type="text/x-jsrender" id="dataListTemplate">
 	<tr>
		<td>{{:username}}</td>
		<td>{{:mobile}}</td>		
		<td>{{:regdate}}</td>
		<td>{{transcode:enable  kind='YES_NO'}}</td>
		<td> <a href="javascript:updateHandle('{{:traderuserid}}');" class="tablelink">查看/修改</a> <a href="javascript:deleteHandle('{{:traderuserid}}');" class="tablelink">删除</a></td>
    </tr>
</script>
<script type="text/javascript">
	var pageIndexback = '<%=request.getParameter("pageIndexback") %>';
</script>
<body>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <!-- <li><a href="#">基础信息管理</a></li> -->
    <li><a href="<%=request.getContextPath() %>/manager/ZlBTraderUserController/list.do">个人账户管理</a></li>
    </ul>
    </div>

    <div class="rightinfo">
    	<div class="tools">
	        <ul class="seachform" style="display:inline !important;" id="search_Form">
	        <!-- 查询条件form begin-->
	         <li><label>注册用户</label><input type='text' class='dfinput'  name='zlBTraderUser.username' id='username' placeholder="请输入注册用户"  dc='true'  maxlength='100'/></li>
			 		
			 <li><label>手机</label><input type='text' class='dfinput'  name='zlBTraderUser.mobile' id='mobile' placeholder="请收入手机号"  dc='true'  maxlength='100'/></li>
			 
			 <li><label>是否启用</label><select class='select1'  name='zlBTraderUser.enable' id='enable' dc='true'    ></select></li>
			<!-- 查询条件end -->   
			    <li><label>&nbsp;</label><input name="" type="button" class="scbtn" id="search_btn" value="查询"/></li>
		    </ul>
		    
	    	<ul class="toolbar1">
	       <!--  <li><a href="<%=request.getContextPath() %>/manager/ZlBTraderUserController/add.do" target="rightFrame"><span><img src="<%=request.getContextPath() %>/rapast/common/images/t01.png" /></span>添加</a></li>-->
	        </ul>
    	</div>
    	
    
    <table class="tablelist">
     <!-- 列表表头区 -->
    <thead>
    <tr>
		 <th style="text-align:center;">注册用户</th>
		 <th style="text-align:center;">手机号</th>
		 <th style="text-align:center;">注册时间</th>
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
<script type="text/javascript" src="<%=request.getContextPath() %>/rapast/zhiliang/manager/ZlBTraderUser/js/ZlBTraderUser_list.js"></script>
</html>


