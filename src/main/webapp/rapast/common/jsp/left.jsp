<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="x-ua-compatible" content="IE=8,9,10" >
		<title>left</title>
		<link href="<%=request.getContextPath()%>/foodms/css/mainstyles.css" rel="stylesheet" type="text/css" />
		<script src="<%=request.getContextPath()%>/foodms/js/jquery-1.8.3.min.js" type="text/javascript"></script>
		
		<meta http-equiv="Content-Type" content="text/html ;charset=utf-8" />
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
	</head>
	<body>
			<div class="leftmenu">
		    	<h1 class="logo">Food Ordering</h1>
		        <ul id="ul">
		        	<li><a class="on" href="main.htm"><span class="lefticon lfhome"></span> <span>主页</span></a></li>
		            <li><a href="javascript:;"><span class="lefticon lfshop"></span> <span>我的餐厅</span></a></li>
		        	<li><a href="javascript:;"><span class="lefticon lffood"></span> <span>菜品管理</span></a></li>
		            <li><a href="javascript:;"><span class="lefticon lftable"></span> <span>桌台管理</span></a></li>
		            <li><a href="javascript:;"><span class="lefticon lforder"></span> <span>订单管理</span></a></li>
		            <li><a href="javascript:;"><span class="lefticon lfevalu"></span> <span>评价管理</span></a></li>
		            <li><a href="javascript:;" id="<%=request.getContextPath()%>/test/employeePage.do"><span class="lefticon lfgroup"></span> <span>员工管理</span></a></li>
		            <li><a href="javascript:;"><span class="lefticon lfsheet"></span> <span>报表</span></a></li>
		        </ul>
		    </div>
	</body>
</html>
