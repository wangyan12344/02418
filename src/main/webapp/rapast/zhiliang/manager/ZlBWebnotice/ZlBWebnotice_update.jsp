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
	.long{
		width:580px !important;
	}
</style>
<script type="text/x-jsrender" id="formTemplate">
    <div class="formtitle"><span>修改</span></div>
    <ul class="forminfo">
    
	  	    	
	    
			<!-- 主键id --> <input type='hidden' name='zlBWebNotice.id' id='id'  dc='true'  maxlength='64'  value='{{:id}}' />
	    
	  	    	
	    
			<li><label>标题</label><input type='text' class='long dfinput' value='{{:intro}}' name='zlBWebNotice.intro' id='intro' dcrequired='请输入简介' dc='true'  maxlength='500'  /></li>
		
	  	    	<br>
	    <li><label>发布时间</label><input type='text'  class="dfinput datepicker"  value='{{:publistime}}' name='zlBWebNotice.publistime' id='publistime' dc='true'   /></li>
	  	   <br>
		
	  	    <li><label>内容</label><span id="memo"   style="display: inline-block;" dc="true">	</span></li>
			
	    
		
	 
	
    </ul>
</script>


<script type="text/javascript">
	var opid = '<%=request.getParameter("opid") %>';
</script>
<body>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
   
    <li><a href="javascript:;">举报平台</a></li>
    </ul>
    </div>
    <div class="formbody" id="formbody">
    </div>
    <div style="margin-bottom:10px;"></div>    

<div style="margin: 40px auto 0;text-align: center;padding-bottom: 20px;">
<input name="" type="button" id="submitBtn" class="btn" value="保存"/>&nbsp;&nbsp;&nbsp;&nbsp;<input name="" id="closeBtn" type="button" class="btn" value="返回"/>
</div>
<script type="text/javascript" src="<%=request.getContextPath()%>/rapast/common/js/ueditor/ueditor.config.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/rapast/common/js/ueditor/ueditor.all.js"></script>
<%@ include file="/rapast/common/jsp/commonJs.jsp"%>
<script type="text/javascript" src="<%=request.getContextPath() %>/rapast/zhiliang/manager/ZlBWebnotice/js/ZlBWebnotice_update.js"></script>
</body>
</html>
