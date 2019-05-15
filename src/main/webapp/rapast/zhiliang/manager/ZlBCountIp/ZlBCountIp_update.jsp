<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="IE=8,9,10" >
<title>添加</title>
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
    <div class="formtitle"><span>交易商银行子账号流水</span></div>
    <ul class="forminfo">
    
	  	    	
	    
			<!-- 流水id --> <input type='hidden' name='zlBCountIp.id' id='id'  dc='true'  maxlength='32'  value='{{:id}}' />
	    
	  	    	
	    
			<li><label>ip地址</label><input type='text' class='dfinput' value='{{:ipaddress}}' name='zlBCountIp.ipaddress' id='ipaddress' dcrequired='请输入ip地址' dc='true'  maxlength='100'  /></li>
		
	  	    	
	    
			<li><label>最后更新时间</label><input type='text' class='dfinput' value='{{:updatetime}}' name='zlBCountIp.updatetime' id='updatetime' dcrequired='请输入最后更新时间' dc='true'  maxlength='100'  /></li>
		
	 
	
    </ul>
</script>


<script type="text/javascript">
	var opid = '<%=request.getParameter("opid") %>';
</script>
<body>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="javascript:;">列表</a></li>
    <li><a href="javascript:;">交易商银行子账号流水-修改</a></li>
    </ul>
    </div>
    <div class="formbody" id="formbody">
    </div>
    <div style="margin-bottom:10px;"></div>    

<div style="margin: 40px auto 0;text-align: center;padding-bottom: 20px;">
<input name="" type="button" id="submitBtn" class="btn" value="保存"/>&nbsp;&nbsp;&nbsp;&nbsp;<input name="" id="closeBtn" type="button" class="btn" value="返回"/>
</div>
<%@ include file="/rapast/common/jsp/commonJs.jsp"%>
<script type="text/javascript" src="<%=request.getContextPath() %>/rapast/zhiliang/manager/ZlBCountIp/js/ZlBCountIp_update.js"></script>
</body>
</html>
