<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="x-ua-compatible" content="IE=8,9,10" >
<title>葫芦岛银行</title>
<link href="<%=request.getContextPath() %>/rapast/index/css/style.css" rel="stylesheet" type="text/css" />
<%@ include file="/rapast/commonindex/jsp/commonJs.jsp"%>
<script type="text/javascript" src="<%=request.getContextPath() %>/rapast/index/js/newsdetail.js"></script>
<script type="text/x-jsrender"  id="newsdetailTemplate">
<div class="ny_bt"><span id="categoryname"></span></div>
<div class="newsbt">{{:entity.newstitle}}</div>
  <div class=" time"> 时间：{{:entity.publishtime}} 浏览次数：{{:entity.visitnum}} 发布者：{{:entity.username}} <br>投稿部门：{{:entity.departmentname}} 投稿人：{{:entity.departmentusername}}</div>
  <div class="nynr">
          <p>　{{:entity.newscontent}}</p> 
 
{{if entity.zlbnewsattachlist!="" && entity.zlbnewsattachlist!=null}}
 <p style="color: #d70010;padding-top: 20px">附件：(请点击浏览或下载)</p>
{{for entity.zlbnewsattachlist}}
 ({{:#index+1}}) <a href="{{:attachpath}}" style="color:#4a40e0;text-decoration: underline;" >{{:attachtitle}}</a> <br>
{{/for}}
{{/if}}
</div>
     
      <div class="nyfh"><a  href="javascript:goback('{{:entity.classurl}}','{{:entity.categoryid}}');">【返回列表】</a></div>

<div class="nyfh">已赞<b id="newspraise"></b></div>
 
<a onclick="addpraise('{{:entity.newsid}}')"  onclick="return false;"  href="javascript:void(0)" > 
<div class="nydz1" id="pariseshow" style="display:none"  >
<img src="<%=request.getContextPath() %>/rapast/index/images/dz1.png"  /><span >点赞</span>
</div>
</a>


     <div class="nydz2" id="parisehidden" style="display:none">
	<img src="<%=request.getContextPath() %>/rapast/index/images/dz2.png"  /><span>已赞</span>
	</div>
 
  <div class="next_fy">
{{if entity_up.newsid!=null &&  entity_up.newsid!=""}}
    <a href="javascript:void(0)" onclick="gotonewsdetail('{{:entity_up.newsid}}')"> > {{:entity_up.newstitle}}</a><br/>
{{/if}} 
{{if entity_down.newsid!=null &&  entity_down.newsid!=""}}
    <a href="javascript:void(0)" onclick="gotonewsdetail('{{:entity_down.newsid}}')"> > {{:entity_down.newstitle}}</a></div>  
{{/if}}
	</script>	
<script type="text/javascript">
	var opid = '<%=request.getParameter("opid") %>';
</script>
</head>
<body>
<%@ include file="/rapast/index/top.jsp"%>
<%@ include file="/rapast/index/adnei.jsp"%>
<div class="nymenu">
  <div class="nymenu1"><img src="<%=request.getContextPath() %>/rapast/index/images/icon5.jpg" width="25" height="25" />您的当前位置是：<a href="<%=request.getContextPath() %>/HomeController/index.do">首页</a> - <span id="parentcategoryname" ></span></div>
  <div class="nysearch"> 
    <div class="nysearch1">
      <input type="text" class="input" name="newstitle" id="newskey" placeholder="请输入关键字" />
    </div>
    <div class="nysearch2">
      <input type="submit" name="button" id="button" value="搜索" class="butn" onclick="gotosearch()" />
    </div>
  </div>
</div>
<div class="nybox2" id="newsdetail">

</div>
<%@ include file="/rapast/index/foot.jsp"%>
</body>
</html>