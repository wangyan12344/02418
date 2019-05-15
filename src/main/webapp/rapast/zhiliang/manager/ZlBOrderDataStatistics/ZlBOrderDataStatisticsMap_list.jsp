<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="IE=8,9,10" >
<link href="<%=request.getContextPath() %>/rapast/zhiliang/manager/ZlBOrderDataStatistics/css/base.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath() %>/rapast/common/css/style.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath() %>/rapast/zhiliang/manager/ZlBOrderDataStatistics/css/stylenew.css" rel="stylesheet" type="text/css">
<title>订单信息统计</title>
<style type="text/css">
{font-size:9pt;border:0;margin:0;padding:0;}
body{font-family:'微软雅黑'; margin:0 auto;min-width:980px;}
ul{display:block;margin:0;padding:0;list-style:none;}
li{display:block;margin:0;padding:0;list-style: none;}
img{border:0;}
dl,dt,dd,span{margin:0;padding:0;display:block;}
a,a:focus{text-decoration:none;color:#000;outline:none;blr:expression(this.onFocus=this.blur());}
a:hover{color:#00a4ac;text-decoration:none;}
table{border-collapse:collapse;border-spacing: 0;}
cite{font-style:normal;}
h2{font-weight:normal;}
.place{height:40px;}
.place span{line-height:40px; font-weight:bold;float:left; margin-left:12px;}
.placeul li{float:left; line-height:40px; padding-left:7px; padding-right:12px; }
.placeul li:last-child{background:none;}
</style>
<%@ include file="/rapast/common/jsp/commonJs.jsp"%>
<script type="text/javascript" src="<%=request.getContextPath() %>/rapast/zhiliang/manager/ZlBOrderDataStatistics/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/rapast/zhiliang/manager/ZlBOrderDataStatistics/js/echarts-3.4.0-src.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/rapast/zhiliang/manager/ZlBOrderDataStatistics/js/china.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/rapast/zhiliang/manager/ZlBOrderDataStatistics/js/dataTool.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/rapast/zhiliang/manager/ZlBOrderDataStatistics/js/common.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/rapast/zhiliang/manager/ZlBOrderDataStatistics/js/bmap.min.js"></script>
</head>
<body class="home_bg">
	<div class="place">
    
    </div>
				 
					<div id="traderDistribute" style="width: 45%;height:500px; float: left;"></div>
    				<div id="saleroomEchar" style="width: 45%;height:500px; float: left;"></div>
    				<!-- 	<div id="zhexianEchar" style="width: 100%;height:200px; float: left;"></div> -->
				
</body>
<script type="text/javascript" src="<%=request.getContextPath() %>/rapast/zhiliang/manager/ZlBOrderDataStatistics/js/ZlBOrderDataStatisticsMap_list.js"></script>
</html>


