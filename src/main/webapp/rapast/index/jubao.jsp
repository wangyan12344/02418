<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="x-ua-compatible" content="IE=8,9,10" >
<title>葫芦岛银行</title>
<link href="<%=request.getContextPath() %>/rapast/index/css/style.css" rel="stylesheet" type="text/css" />
<%@ include file="/rapast/commonindex/jsp/commonJs.jsp"%>
<script type="text/javascript" src="<%=request.getContextPath() %>/rapast/index/js/jubao.js"></script>
</head>
	<script type="text/x-jsrender" id="newsdetailTemplate">
    <p>　{{:entity.comment}}</p> 
	</script>	
	
 
<body>
<%@ include file="/rapast/index/top.jsp"%>
<%@ include file="/rapast/index/adnei.jsp"%>
<div class="nymenu">
  <div class="nymenu1"><img src="<%=request.getContextPath() %>/rapast/index/images/icon5.jpg" width="25" height="25" />您的当前位置是：<a href="<%=request.getContextPath() %>/HomeController/index.do">首页</a> - <span id="parentcategoryname" >举报平台</span></div>
  <div class="nysearch"> 
    <div class="nysearch1">
      <input type="text" class="input" name="newstitle" id="newskey" placeholder="请输入关键字" />
    </div>
    <div class="nysearch2">
      <input type="submit" name="button" id="button" value="搜索" class="butn" onclick="gotosearch()" />
    </div>
  </div>
</div>
 
<div class="nybox2" >
    <div class="ny_bt"><span><img src="<%=request.getContextPath() %>/rapast/index/images/icon2.jpg" width="23" height="16" />举报平台</span></div>
  <div class="nynr" id="newsdetail">
   
      </div>
</div>
<%@ include file="/rapast/index/foot.jsp"%>
</body>
</html>