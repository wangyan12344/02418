<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="IE=8,9,10" >
<title>修改</title>
<%@ include file="/rapast/common/jsp/commonCss.jsp"%>
</head>
<style type="text/css">
	.forminfo li{
		display:inline-flex;
	}
	.forminfo li label{
		padding-left: 10px;
	}
	.dfinput{
		width:235px !important;
	}
</style>
<script type="text/x-jsrender" id="formTemplate">
    <div class="formtitle"><span>成交记录修改</span></div>
    <ul class="forminfo">
    
	  	    	
	    <!-- 主键 --> <input type='hidden' name='zlBTradingRecode.tradingid' id='tradingid'  value='{{:tradingid}}'   dc='true'  maxlength='32'   />
	    
	    
			<li><label>交易商</label><input type='text' class='dfinput'  name='zlBTradingRecode.tradename' id='tradename'  dc='true'   value='{{:tradename}}'  /></li>
	  	    	    
			<li><label>交收地</label><input name='zlBTradingRecode.settlement' class='dfinput' id='settlement'  dc='true'  value='{{:settlement}}'  /></li>
		    
		    <li><label>成交量(吨)</label><input name='zlBTradingRecode.tradevolume' class='dfinput' id='tradevolume'  dc='true'  value='{{:tradevolume}}'  /></li>
		    <br>
		    <li><label>货物名称</label><input name='zlBTradingRecode.planttype' class='dfinput' id='planttype'  dc='true' value='{{:planttype}}'  /></li>
		    
		    <li><label>价格(元/吨)</label><input name='zlBTradingRecode.price' class='dfinput' id='price'  dc='true'  value='{{:price}}'  /></li>
		    
			 <li><label>产地</label><input name='zlBTradingRecode.spareone' class='dfinput' id='spareone'  dc='true'  value='{{:spareone}}'  /></li>
		    <br>
 			 <li><label>货品等级</label><input name='zlBTradingRecode.levelcode' class='dfinput' id='levelcode'  dc='true'  value='{{:levelcode}}'  /></li>
		    
			 <li><label>订单编号</label><input name='zlBTradingRecode.spareth' class='dfinput' id='spareth'  dc='true'  value='{{:spareth}}'  /></li>
		    
		     <li><label>成交日期</label><input name='zlBTradingRecode.recodetime' class='dfinput datepicker' id='recodetime'  dc='true'  value='{{:recodetime}}'  /></li>
		    
	 
	
    </ul>
</script>


<script type="text/javascript">
	var opid = '<%=request.getParameter("opid") %>';
</script>
<body>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="javascript:returnMainPage();">返回成交记录信息列表</a></li>
    <li><a href="javascript:;">成交记录-修改</a></li>
    </ul>
    </div>
    <div class="formbody" id="formbody">
    </div>
    <div style="margin-bottom:10px;"></div>    

<div style="margin: 40px auto 0;text-align: center;padding-bottom: 20px;">
<input name="" type="button" id="submitBtn" class="btn" value="保存"/>&nbsp;&nbsp;&nbsp;&nbsp;<input name="" id="closeBtn" type="button" class="btn" value="返回"/>
</div>
<%@ include file="/rapast/common/jsp/commonJs.jsp"%>
<script type="text/javascript" src="<%=request.getContextPath() %>/rapast/zhiliang/manager/ZlBTradingRecode/js/ZlBTradingRecode_update.js"></script>
</body>
</html>
