<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="IE=8,9,10" >
    <meta name="viewport" content="width=device-width, initial-scale=1">
     <!--<link href="bootstrap-3.3.7/dist/css/bootstrap.css" rel="stylesheet">-->
     <link href="<%=request.getContextPath() %>/rapast/gsj/css/base.css" rel="stylesheet">
     <link href="<%=request.getContextPath() %>/rapast/gsj/css/index.css" rel="stylesheet">
     <link href="<%=request.getContextPath()%>/rapast/pageHtml/css/news.css" rel="stylesheet" type="text/css">
	 <link href="<%=request.getContextPath() %>/rapast/gsj/css/lrtk.css" rel="stylesheet" type="text/css" />
     <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/rapast/gsj/iconcss/iconfont.css">
	<%@ include file="/rapast/common/jsp/commonJs.jsp"%>
	<!--通道连接js模版  -->
 
	<!--滚动公告模版 -->
	<script type="text/x-jsrender" id="noticeTemplate">
	<li onclick="todetaildepage('{{:newsid}}','{{:permissions}}')">· {{:newstitle}} {{:ctime}}</li>
	</script>
<script type="text/x-jsrender" id="categoryTemplate">

<div class="subNav1" href="javascript:void(0)" onclick="queryDataList('{{:categoryid}}','0')">{{:categoryname}}</div>


</script>
<script type="text/x-jsrender" id="dataListTemplate">

		
	{{if templateid==='2'}}

	<li>
		<a href="javascript:todetaildepage('{{:newsid}}','{{:permissions}}');">{{:newstitle}}</a>
		<p>{{:newsintro}}<a class="newsmorepic" href="javascript:todetaildepage('{{:newsid}}','{{:permissions}}');">[详细]</a></p>
		<div class="clean"></div>
		<span>{{:publishtime}}</span>
		
        <strong>浏览量（{{:visitnum}}）</strong>
	</li>
	{{else}}

	<li>
		<img src="{{:mainimgpath}}" width="144" height="106">
		<a href="javascript:todetaildepage('{{:newsid}}','{{:permissions}}');">{{:newstitle}}</a>
		<p>{{if newsintro.length>=64}}{{:newsintro.replace(newsintro.substr(64,newsintro.length),"...")}}{{/if}}<a class="newsmorepic" href="javascript:todetaildepage('{{:newsid}}','{{:permissions}}');">[详细]</a></p>
		<div class="clean"></div>
		<span>{{:publishtime}}</span>
		
        <strong>浏览量（{{:visitnum}}）</strong>
	</li>
	{{/if}}
</script>
	<!--短左  -->
 
<script type="text/javascript" src="<%=request.getContextPath() %>/rapast/gsj/news/js/news.js"></script>
<script type="text/javascript">
	var opid = '<%=request.getParameter("opid") %>';
</script>
<title>国家税务总局绥中县税务局</title>
	</head>
	<body>
		<div class="container">
			<!--banner-->
			<%@ include file="/rapast/gsj/main/head_main.jsp"%>
	
			
			
			<!--  新闻列表-->
			<div class="news_list">
<!--新闻列表开始-->

<div class="newslist_left">
<div class="newslistL">

<!--tab-->
<script>

</script>



<div class="newslistL_title"  >
<ul>
<li><a href="javascript:void(0);" class="newstab" onclick="tolist();" id="list"></a></li>
</ul>

<div class="clean"></div>
</div>

<div class="newslistL_text" style=" display:block" id="categorylist">


<!-- 新闻分类 -->


</div>


 

</div>
<!--菜单结束-->

<div class="newslistR" style="min-height: 820px;">
<div class="newslistR_title"><a href="javascript:void(0)" id="sname"></a></div>

<div class="newslistr_text_pic" >
	<ul id="dataListId">
	
	<!-- 新闻列表区域 -->
	
	</ul>
</div>

<div class="pages" >
<!--分页  -->
    <div class="page"  id="pagefoot">  
      
    
         <div class="clean"></div>
      </div>
<!--分页  -->    
</div>


</div>
<!--新闻列表结束-->

</div>
<!--左侧结束-->

<div class="newslist_right">
<!--  
<div class="newslistr_top" >
<div class="newstop_title">通知</div>
<div class="newstop_text"  width="315" height="269">
<div class="Port_price_data" id="echarimage" style="width:350px;height:100%;" ></div>
</div>
</div> -->

<!-- 热点新闻区域 -->
<%@ include file="/rapast/gsj/news/hot_news.jsp" %>

</div>
<!--右侧结束-->


</div>
<!--新闻列表结束-->
			
		<div class="million_newslist" id="ad10">
		<div class="layui-carousel" id="test10">
			  <div carousel-item="">
			    <div><img src="<%=request.getContextPath() %>/rapast/gsj/img/adpic/pic01.png" /></div>
			    <div><img src="<%=request.getContextPath() %>/rapast/gsj/img/adpic/pic02.png" /></div>
			    <div><img src="<%=request.getContextPath() %>/rapast/gsj/img/adpic/pic03.png" /></div>
			  </div>
		</div>
			<%-- <img src="<%=request.getContextPath() %>/rapast/gsj/img/adpic/pic03.png" /> --%>
		</div>
	<%@ include file="/rapast/gsj/main/foot.jsp"%>
		</div>
	
	</body>
</html>
<script src="<%=request.getContextPath() %>/rapast/gsj/layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
layui.use(['carousel', 'form'], function(){
  var carousel = layui.carousel
  ,form = layui.form;
  //图片轮播
  carousel.render({elem: '#test10',width: '1200px' ,height: '95px' ,interval: 5000,anim:'updown',autoplay:false });
});
</script>
