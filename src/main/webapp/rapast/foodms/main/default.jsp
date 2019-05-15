<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="IE=8,9,10" >
<title>无标题文档</title>
<%@ include file="/rapast/common/jsp/commonCss.jsp"%>
</head>


<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">数据统计</a></li>
    </ul>
    </div>
    
    
    <div class="mainbox">
    
    <div class="mainleft">
    
    
    <div class="leftinfo">
    <div class="listtitle"><a href="#" class="more1">更多</a>当日预约统计</div>
        
    <div class="maintj">  
    <table id='myTable5'>
				<caption></caption>
				<thead>
					<tr>
						<th></th>
						<th>维修</th>
						<th>保养</th>
						<th>车辆检测</th>
						<th>试驾</th>
					</tr>
				</thead>
					<tbody>
					<tr>
						<th>2015-08</th>
						<td>125</td>
						<td>185</td>
						<td>327</td>
						<td>359</td>
					</tr>
				</tbody>
			</table>  
    </div>
    
    </div>
    <!--leftinfo end-->
    
    
    <div class="leftinfos">
    
   
    <div class="infoleft">
    
    <div class="listtitle"><a href="#" class="more1">更多</a>待办事项</div>    
    <ul class="newlist">
    <li><a href="#">张三上午9:30预约本店维修服务</a><b>10-09</b></li>
    <li><a href="#">李四下午2:30预约本店车保养服务</a><b>10-08</b></li>
    <li><a href="#">王五上午9:00预约本店购车服务</a><b>10-09</b></li>
    <li><a href="#">马六上午9:30预约本店维修服务</a><b>10-06</b></li>
    <li><a href="#">王小红上午9:00预约本店购车服务</a><b>10-05</b></li>
    <li><a href="#">张小丽下午3:30预约本店车保养服务</a><b>10-04</b></li>
    <li><a href="#">王小明 下午2:00预约本店车保养服务</a><b>10-03</b></li>
    </ul>   
    
    </div>
    
    
    <div class="inforight">
    <div class="listtitle"><a href="#" class="more1">添加</a>常用工具</div>
    
    <ul class="tooli">
    <li><span onclick="alertInput()"><img src="<%=request.getContextPath() %>/rapast/common/images/d01.png" /></span><p><a href="#">预约扫描</a></p></li>
    <li><span><img src="<%=request.getContextPath() %>/rapast/common/images/d03.png" /></span><p><a href="clxx.html">客户及车辆</a></p></li>
    <li><span><img src="<%=request.getContextPath() %>/rapast/common/images/d06.png" /></span><p><a href="repairm/order_list.html">维修</a></p></li>
    <li><span><img src="<%=request.getContextPath() %>/rapast/common/images/d07.png" /></span><p><a href="maintenancem/order_list.html">保养</a></p></li>
    <li><span><img src="<%=request.getContextPath() %>/rapast/common/images/d04.png" /></span><p><a href="wzjl.html">违章查询</a></p></li>
    </ul>
    
    </div>
    
    
    </div>
    
    
    </div>
    <!--mainleft end-->
    
    
    <div class="mainright">
    
    
    <div class="dflist">
    <div class="listtitle"><a href="#" class="more1">更多</a>最新信息</div>    
    <ul class="newlist">
    <li><a href="#">中大型SUV安全排行榜：本田Pilot获得冠军</a></li>
    <li><a href="#">众泰Z700将于四季度生产 1.8T搭载双离合</a></li>
    <li><a href="#">时尚兼顾家用 新起亚K5将推出旅行版车型</a></li>
    <li><a href="#">冲劲挡不住 绅宝X65靠实力“冲上云霄”</a></li>
    <li><a href="#">迈巴赫S500 4MATIC上市 219.8万/4.0T引擎</a></li>
    <li><a href="#">新款陆风X7专利图曝光 外观改变比较明显</a></li>
    <li><a href="#">这次真的是友情价 试驾2016款斯柯达Yeti</a></li>
    <li><a href="#">苹果挖角特斯拉高级工程师 或将造纯电动车</a></li>
    <li><a href="#">全新一代奔驰G级假想图曝光 造型十分夸张</a></li> 
    </ul>        
    </div>
    
    
    <div class="dflist1">
    <div class="listtitle"><a href="#" class="more1">更多</a>当月数据统计</div>    
    <ul class="newlist">
    <li><i>新车销售：</a></i>769 辆</li>
    <li><i>保养：</a></i>152 辆</li>
    <li><i>维修：</a></i>100 辆</li>
    <li><i>检测：</a></i>122 辆</li>
    <li><i>试驾：</a></i>825 辆</li>    
    </ul>        
    </div>
    
    

    
    
    </div>
    <!--mainright end-->
    
    <div class="tip" id="alertInputId">
    	<div class="tiptop"><span>扫描二维码</span><a></a></div>
      <div class="tipinfo">
        <!-- <span><img src="<%=request.getContextPath() %>/rapast/common/images/ticon.png" /></span> -->
        <div class="tipright">
        <p> </p>
        <ul class="seachform" style="display:inline !important;">
		    <li><input name="" type="text" class="scinput" style="width:200px" placeholder="车架号/车牌号/扫码"/><img src="<%=request.getContextPath() %>/rapast/common/images/erweima.png" width="35px" height="35px" style="float:right;"/></li>
		    <li><a href="yygl_detail.html"><label></label><input name="" type="button" class="scbtn" value="查询"/></a></li>
		    <div style="color:#858686;height:50px">&nbsp;&nbsp;输入 车架号 、车牌号 或 扫码 进行预约查询</div>
	    </ul>
        </div>
        </div>
    </div>
    
    </div>



</body>
<%@ include file="/rapast/common/jsp/commonJs.jsp"%>
<script type="text/javascript" src="<%=request.getContextPath()%>/rapast/common/js/jsapi.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/rapast/common/js/format+zh_CN,default,corechart.I.js"></script>		
<script type="text/javascript" src="<%=request.getContextPath()%>/rapast/common/js/jquery.gvChart-1.0.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/rapast/common/js/jquery.ba-resize.min.js"></script>
<script type="text/javascript">
		gvChartInit();
		jQuery(document).ready(function(){

		jQuery('#myTable5').gvChart({
				chartType: 'PieChart',
				gvSettings: {
					vAxis: {title: 'No of players'},
					hAxis: {title: 'Month'},
					width: 650,
					height: 250
					}
			});
		
		$(".scbtn").click(function(){
			  $(".tip").fadeIn(200);
		});
			  
			  $(".tiptop a").click(function(){
			  $(".tip").fadeOut(200);
			});

			  $(".sure").click(function(){
			  $(".tip").fadeOut(100);
			});

			  $(".cancel").click(function(){
			  $(".tip").fadeOut(100);
			});
		});
		
		function alertInput(){
			$("#alertInputId").fadeIn(200);
		}
		</script>
<script type="text/javascript">
	setWidth();
	$(window).resize(function(){
		setWidth();	
	});
	function setWidth(){
		var width = ($('.leftinfos').width()-12)/2;
		$('.infoleft,.inforight').width(width);
	}
</script>
</html>


