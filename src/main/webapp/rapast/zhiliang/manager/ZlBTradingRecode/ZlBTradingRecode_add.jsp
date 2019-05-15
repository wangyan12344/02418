<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="IE=8,9,10" >
<title>成交记录添加</title>
<%@ include file="/rapast/common/jsp/commonCss.jsp"%>
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
#num{color:blue; font-size:0.1rem;}
textarea{resize:none;}
#word{color:red;}
</style>
</head>
<body>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="javascript:returnMainPage();">返回成交记录信息列表</a></li>
    <li><a href="#">添加成交记录</a></li>
    </ul>
    </div>
    
    <div class="formbody" id="formbody">
    
    <div class="formtitle"><span>成交记录</span></div>
    
    <ul class="forminfo" id="editForm">
	  	    	
			<li><label>交易商</label><input type='text' class='dfinput'  name='zlBTradingRecode.tradename' id='tradename'  dc='true'   maxlength='240'  /></li>
	  	    	    
			<li><label>交收地</label><input name='zlBTradingRecode.settlement' class='dfinput' id='settlement'  dc='true'  maxlength='140'  /></li>
		    
		    <li><label>成交量(吨)</label><input name='zlBTradingRecode.tradevolume' class='dfinput' id='tradevolume'  dc='true'  maxlength='140'  /></li>
		    <br>
		    <li><label>货物名称</label><input name='zlBTradingRecode.planttype' class='dfinput' id='planttype'  dc='true'  maxlength='140'  /></li>
		    
		    <li><label>价格(元/吨)</label><input name='zlBTradingRecode.price' class='dfinput' id='price'  dc='true'  maxlength='140'  /></li>
		    
		     <li><label>产地</label><input name='zlBTradingRecode.spareone' class='dfinput' id='spareone'  dc='true'    /></li>
		     <br>
 			 <li><label>货品等级</label><input name='zlBTradingRecode.levelcode' class='dfinput' id='levelcode'  dc='true'   /></li>
		    
			 <li><label>订单编号</label><input name='zlBTradingRecode.spareth' class='dfinput' id='spareth'  dc='true'  /></li>
		    
		    <li><label>成交日期</label><input name='zlBTradingRecode.recodetime' class='dfinput datepicker' id='recodetime'  dc='true'  maxlength='140'  /></li>
	 
    </ul>
    
     
    </div>
    
<div style="margin: 40px auto 0;text-align: center;padding-bottom: 20px;">
<input name="" type="button" id="subBnt" class="btn" onclick="saveForm()" value="保存"/>&nbsp;&nbsp;&nbsp;&nbsp;<input name="" id="closeBtn" type="button" class="btn" value="返回"/>
</div>
<%@ include file="/rapast/common/jsp/commonJs.jsp"%>
<script type="text/javascript" src="<%=request.getContextPath() %>/rapast/zhiliang/manager/ZlBTradingRecode/js/ZlBTradingRecode_add.js"></script>
</body>
</html>


