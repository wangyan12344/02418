<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="IE=8,9,10" >
<title>交易商银行子账号流水添加</title>
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
</style>
</head>
<body>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">列表</a></li>
    <li><a href="#">交易商银行子账号流水</a></li>
    </ul>
    </div>
    
    <div class="formbody" id="formbody">
    
    <div class="formtitle"><span>录入信息</span></div>
    
    <ul class="forminfo" id="editForm">
	  	    	
	    
			<!-- 流水id --> <input type='hidden' name='zlBCount.id' id='id'  dc='true'  maxlength='32'  VALUECONTEXTUUU />
	    
	  	    	
	    
			<li><label>访问总量</label><input type='text' class='dfinput' VALUECONTEXTUUU name='zlBCount.totalcount' id='totalcount' dcrequired='请输入访问总量' dc='true'  maxlength='100'  /></li>
		
	  	    	
	    
			<li><label>当日访问总量</label><input type='text' class='dfinput' VALUECONTEXTUUU name='zlBCount.daycount' id='daycount' dcrequired='请输入当日访问总量' dc='true'  maxlength='100'  /></li>
		
	  	    	
	    
			<li><label>在线人数，10分钟内视为在线</label><input type='text' class='dfinput' VALUECONTEXTUUU name='zlBCount.pcount' id='pcount' dcrequired='请输入在线人数，10分钟内视为在线' dc='true'  maxlength='255'  /></li>
		
	  	    	
	    
			<li><label>更新时间</label><input type='text' class='dfinput  timepicker' VALUECONTEXTUUU name='zlBCount.ctime' id='ctime' dcrequired='请输入更新时间' dc='true'  maxlength='100'  /></li>
		
	 
    </ul>
    
    </div>
    
<div style="margin: 40px auto 0;text-align: center;padding-bottom: 20px;">
<input name="" type="button" id="subBnt" class="btn" onclick="saveForm()" value="保存"/>&nbsp;&nbsp;&nbsp;&nbsp;<input name="" id="closeBtn" type="button" class="btn" value="返回"/>
</div>
<%@ include file="/rapast/common/jsp/commonJs.jsp"%>
<script type="text/javascript" src="<%=request.getContextPath() %>/rapast/zhiliang/manager/ZlBCount/js/ZlBCount_add.js"></script>
</body>
</html>


