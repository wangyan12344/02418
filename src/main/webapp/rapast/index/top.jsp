<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/rapast/commonindex/jsp/commonJs.jsp"%>
<script type="text/javascript">
	var path = '<%=request.getContextPath()%>';
</script>
<script type="text/x-jsrender" id="linklistTemplate">
<span ><a href="{{:activityurl}}" target="_blank" >{{:activityname}}</a></span>
</script>
<script type="text/x-jsrender" id="tongdaoTemplate">
	<li><a href="{{:activityurl}}" target="_blank" >{{:activityname}}</a></li>
	</script>
	<!--hld通知公告模版 -->
	<script type="text/x-jsrender" id="tongzhigonggaoTemplate">
<li onclick="gotonewsdetail('{{:newsid}}','{{:classurl}}')">
<span>{{:ctime}}</span><a  onclick="return false;"  href="javascript:void(0)" title="{{:newstitle}}">{{:newstitle.substring(0,14)}} </a></li>
 
	</script>
		<!--短左  -->


<script type="text/x-jsrender" id="ad2Template">
<a href="{{:imgurl}}"><img src="{{:img}}"  width="760px" height="130px" ></a>
</script>
<script type="text/x-jsrender" id="classListTemplate">
<li onclick="showPage('/HomeController/index.do','000')"><a onclick="return false;"  href="javascript:void(0)">首页</a></li>
{{for data}}
<li onclick="showPage('{{:url}}','{{:categoryid}}')"><a  onclick="return false;"  href="javascript:void(0)">{{:categoryname}}</a></li>
{{/for}}
</script>

	<!--hld首页热点模版 -->
	<script type="text/x-jsrender" id="ishotTemplate">
	<div id="picshow">
		<div id="picshow_img">
			<ul>
{{for data }}
			  <li onclick="gotonewsdetail('{{:newsid}}','{{:classurl}}')" > 
<a  onclick="return false;" href="javascript:void(0)" title="{{:newstitle}}" target="_blank">
{{if mainimgpath!=""}}
<img src="{{:mainimgpath}}"  width="399" height="280">
{{else}}
<img src="<%=request.getContextPath() %>/rapast/index/images/wutu.png" width="399" height="280" />
{{/if}}
</a></li>
		
{{/for}}</ul>
		</div>
		<div id="picshow_tx">
			<ul>
			 {{for data }}
 <li onclick="gotonewsdetail('{{:newsid}}','{{:classurl}}')" >
				  <p><a onclick="return false;" href="javascript:void(0)" title="{{:newstitle}}"  target="_blank">{{:newstitle.substring(0,22)}}</a></p>
			  </li>
	{{/for}}
			</ul>
		</div>
	</div>
	<div id="select_btn">
		<ul>
{{for data }}		
  <li  onclick="gotonewsdetail('{{:newsid}}','{{:classurl}}')" ><a    onclick="return false;" href="javascript:void(0)" title="{{:newstitle}}" target="_blank" ><span class="select_text">{{:newstitle.substring(0,14)}}</span><span class="select_date">{{:ctime}}</span></a></li>
{{/for}}		</ul>
	</div>



 </script>
<div class="warp">
  <div class="warp1">
  <div class="logo"><img src="<%=request.getContextPath() %>/rapast/index/images/logo.jpg" width="459" height="100" /></div>
  <div class="menu">
    <ul id="classList">
  <!--     <li class="red"><a href="index.html">网站首页</a></li>
      <li><a href="index.html">总行要闻</a></li>
      <li><a href="index.html">部室动态</a></li>
      <li><a href="index.html">党团建设</a></li>
      <li><a href="index.html">经营信息</a></li>
      <li><a href="index.html">基层风采</a></li>
      <li><a href="index.html">行业观察</a></li>
      <li><a href="index.html">员工天地</a></li>
      <li><a href="index.html">培训之窗</a></li> -->
    </ul>
  </div>
</div>
</div>

<script type="text/javascript" src="<%=request.getContextPath() %>/rapast/index/js/top.js"></script>

