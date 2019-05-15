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
<script type="text/javascript" src="<%=request.getContextPath()%>/rapast/gsj/news/js/newsdetail.js"></script>

<!-- 新闻详细 -->
<script type="text/x-jsrender" id="formTemplate">
	{{if templateid==='2'}}
	<div class="newslistR_title">>  {{:categoryname}} </div>
  
<div class="clean"></div>
<div class="newsdeta_title"><h3>{{:newstitle}}</h3></div>
<div class="newsdeta_time">
	<div class="messdeta_times">时间：{{:publishtime}} 浏览次数：{{:visitnum}}</div>

</div>
<div class="clean"></div>
<div class="newsdeta_hr"></div>
<div class="newsdeta_text">
	{{:newscontent}}
</div>

<div class="newsdeta_fanhui" id="back">
	<a  href="javascript:tolistpage();">返回上一页</a>
</div>

	{{else}}
<div class="newslistR_title">>  {{:categoryname}} </div>

<div class="clean"></div>
<div class="newsdeta_title"><h3>{{:newstitle}}</h3></div>
<div class="newsdeta_time">
	<div class="messdeta_times">时间：{{:publishtime}} 浏览次数：{{:visitnum}}</div>
	
</div>
<div class="clean"></div>
<div class="newsdeta_hr"></div>
<!--<div class="newsdeta_pic"><img src="{{:mainimgpath}}" width="824" height="320"></div>-->
<div class="newsdeta_text">
	{{:newscontent}}
</div>

<div class="newsdeta_fanhui" id="back">
	<a  href="javascript:tolistpage();">返回上一页</a>
</div>
	
	{{/if}}
</script>
<script type="text/javascript">
	var opid = '<%=request.getParameter("opid") %>';
</script>
<title>国家税务总局绥中县税务局</title>
	</head>
	<body>
		<div class="container">
			<!--banner-->
			<%@ include file="/rapast/gsj/main/head_main.jsp"%>
<div class="news_list">
<!--新闻列表开始-->

<div class="newslist_left newslist_left_detailed" id="newsdate">




</div>
<!--左侧结束-->

<div class="newslist_right">
 

<!--右侧中置粮数据-->
<%@ include file="/rapast/gsj/news/hot_news.jsp" %>


</div>
<!--右侧结束-->


</div>
			
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
