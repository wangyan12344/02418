<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="x-ua-compatible" content="IE=8,9,10" >
<title>葫芦岛银行</title>
<link href="<%=request.getContextPath() %>/rapast/index/css/style.css" rel="stylesheet" type="text/css" />
<%@ include file="/rapast/commonindex/jsp/commonJs.jsp"%>
<script type="text/javascript" src="<%=request.getContextPath() %>/rapast/index/js/branch.js"></script>
 <script type="text/x-jsrender" id="categoryTemplate">

  <li   onclick="gotonewslist('{{:categoryid}}')" id="{{:categoryid}}"><a href="javascript:void(0)">{{:categoryname}}</a></li>

</script>
<script type="text/x-jsrender" id="dataListTemplate">
 
		
	{{if templateid==='2' || mainimgpath==''}}
 <div class="nybox2_nr_1" onclick="gotonewsdetail('{{:newsid}}')"><h2><b>{{:publishtime}}</b>{{:newstitle}}</h2><span>{{if newsintro.length>=114}}{{:newsintro.replace(newsintro.substr(114,newsintro.length),"...")}}{{else}}{{:newsintro}}{{/if}}</span><kbd><a href="javascript:gotonewsdetail('{{:newsid}}');">查看详细></a></kbd></div>
	{{else}}
 <div class="nybox2_nr_1" onclick="gotonewsdetail('{{:newsid}}')"><img src="{{:mainimgpath}}" /><h2><b>{{:publishtime}}</b>{{:newstitle}}</h2><span>{{if newsintro.length>=94}}{{:newsintro.replace(newsintro.substr(94,newsintro.length),"...")}}{{else}}{{:newsintro}}{{/if}}</span><kbd><a href="javascript:gotonewsdetail('{{:newsid}}');">查看详细></a></kbd></div>
	{{/if}}
</script>
		<script type="text/x-jsrender" id="classTemplate">


   <div class="ny_bt" onclick=gotonewslist('{{:categoryid}}')><b><a href="javascript:void(0)">更多></a></b><span><img src="<%=request.getContextPath() %>/rapast/index/images/icon2.jpg" width="23" height="16" />{{:categoryname}}</span></div>
      <div class="nybox2_right2">
        <ul>
{{if zlBNewslist!=""}}
{{for  zlBNewslist}}
          <li><a href="javascript:void(0)" onclick=gotonewsdetail("{{:newsid}}")><img src="<%=request.getContextPath() %>/rapast/index/images/icon8.jpg" width="17" height="17" />{{:newstitle.substring(0,24)}}</a></li>
   {{/for}}   
{{/if}}     
</ul>
      </div>
 
	</script>	
	<script type="text/javascript">
	var opid = '';
	var parentid='<%=request.getParameter("opid") %>';
</script>
<style>
/*分页*/
.page{ width:100%; margin:10px 0; clear:both;height:30px;}
.page .paginList{ width:auto; float:right; height:34px; color:#333333; font-size:12px;}
.page ul li{ width:auto; float:left; padding:0 10px; border:solid 1px #ededed; margin-right:8px; cursor:pointer; line-height:32px;}
.page ul li a{ color:#333; text-decoration:none;}

.page ul li:hover{border:solid 1px #d70010; background:#d70010; color:#ffffff;}
.page ul li:hover a{border:solid 1px #d70010; background:#d70010; color:#ffffff;}
.page .current{border:solid 1px #d70010; background:#d70010; color:#fff;}
.page .current a{color:#fff;}
.page .pagetext{ width:auto; float:left; height:34px;color:#333333;}
.page .pagetext div{ width:auto; float:left; padding:0 6px; line-height:34px;}
.page .pagetext div span{padding:0 6px;}
</style>
</head>
<body>
<%@ include file="/rapast/index/top.jsp"%>
<%@ include file="/rapast/index/adnei.jsp"%>
<div class="nymenu">
  <div class="nymenu1" id="menuclass"><img src="<%=request.getContextPath() %>/rapast/index/images/icon5.jpg" width="25" height="25" />您的当前位置是：<a href="<%=request.getContextPath() %>/HomeController/index.do">首页</a></div>
  <div class="nysearch"> 
    <div class="nysearch1">
        <input type="text" class="input" name="newstitle" id="newskey" placeholder="请输入关键字" />
    </div>
    <div class="nysearch2">
      <input type="submit" name="button" id="button" value="搜索" onclick="gotosearch()" class="butn" />
    </div>
  </div>
</div>
<div class="nybox2">
  <div class="nybox2_fl">
    <div class="nybox2_fl1" id="sname2"><img src="<%=request.getContextPath() %>/rapast/index/images/icon7.jpg" width="40" height="17" /></div>
    <div class="nybox2_fl2">
      <ul id="categorylist">
       <!--  <li class="red"><a href="#">每旬信息摘编</a></li>
        <li><a href="#">监管动态</a></li>
        <li><a href="#">每旬信息摘编</a></li>
        <li><a href="#">每旬信息摘编</a></li>
        <li><a href="#">每旬信息摘编</a></li> -->
      </ul>
    </div>
  </div>
   <div class="nybox2_right1" id="classid">
 
  </div>
</div>

<%@ include file="/rapast/index/foot.jsp"%>
</body>
</html>

