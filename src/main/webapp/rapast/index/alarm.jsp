<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="x-ua-compatible" content="IE=8,9,10" >
<title>葫芦岛银行</title>
<link href="<%=request.getContextPath() %>/rapast/index/css/style.css" rel="stylesheet" type="text/css" />
<%@ include file="/rapast/commonindex/jsp/commonJs.jsp"%>
<script type="text/javascript" src="<%=request.getContextPath() %>/rapast/index/js/alarm.js"></script>
<script type="text/x-jsrender" id="classTemplate">
 	  <div class="nybox2_1 {{if #index%2==0}}left{{else}}right{{/if}}"  >
      <div class="ny_bt" onclick=gotonewslist('{{:categoryid}}')><b><a href="javascript:void(0)">更多></a></b><span><img src="<%=request.getContextPath() %>/rapast/index/images/icon2.jpg" width="23" height="16" />{{:categoryname}}</span></div>
     {{if zlbnews!=""}}
 <div class="nybox2_1_1" onclick=gotonewsdetail("{{:newsid}}")>{{if zlbnews.mainimgpath!="" && zlbnews.mainimgpath!=null}}<img src="{{:zlbnews.mainimgpath}}" />{{else}}{{/if}}<h2>{{:zlbnews.newstitle.substring(0,24)}}</h2><b>{{:zlbnews.publishtime}}</b><span>{{:zlbnews.newsintro.substring(0,100)}}</span><kbd><a href="javascript:void(0)">查看详细></a></kbd></div>
   {{/if}} <div class="nybox2_1_2 clearfix">
        <ul>
{{if zlBNewslist!=""}}
{{for  zlBNewslist}}
          <li onclick=gotonewsdetail("{{:newsid}}")><span>{{:ctime}}</span><a href="javascript:void(0)">{{:newstitle.substring(0,24)}} </a></li>
{{/for}}   
{{/if}} 
        </ul>    
    </div>
  </div>
	</script>	
	<!--热点置顶新闻列表  -->
	<script type="text/x-jsrender" id="classistoplistTemplate">
 	   <li onclick=gotonewsdetail("{{:newsid}}")><span>{{:ctime}}</span><a href="javascript:void(0)">{{:newstitle.substring(0,24)}}  </a></li>
	</script>	
	<!-- 热点置顶新闻一条 -->
	<script type="text/x-jsrender" id="classistopTemplate">
 	 <h2 onclick=gotonewsdetail("{{:newsid}}") style="cursor: pointer;">{{:newstitle.substring(0,24)}}</h2>
      <span onclick=gotonewsdetail("{{:newsid}}")>{{:newsintro.substring(0,90)}}<a href="javascript:void(0)" > [查看详细]</a></span>
	</script>	
	<!-- 新闻轮播图  -->
	<script type="text/x-jsrender" id="ad000Template">
 	 <a href="javascript:void(0)" target="_blank" onclick=gotonewsdetail("{{:newsid}}")>
{{if mainimgpath!=""}}
<img src="{{:mainimgpath}}"  width="675" height="340"  >
{{else}}
<img src="<%=request.getContextPath() %>/rapast/index/images/wutu2.png"  width="675" height="340"  />
{{/if}}

</a>
	</script>	
	<script type="text/javascript">
	var parentid = '<%=request.getParameter("opid") %>';
	</script>
	<script src="<%=request.getContextPath() %>/rapast/index/layui/layui.js" charset="utf-8"></script>
</head>
	
<body>
<%@ include file="/rapast/index/top.jsp"%>
<%@ include file="/rapast/index/adneijzcm.jsp"%>

<div class="nymenu">
  <div class="nymenu1" id="classname"><img src="<%=request.getContextPath() %>/rapast/index/images/icon5.jpg" width="25" height="25" />您的当前位置是：<a href="<%=request.getContextPath() %>/HomeController/index.do">首页</a> - </div>
  <div class="nysearch"> 
    <div class="nysearch1">
    <input type="text" class="input" name="newstitle" id="newskey" placeholder="请输入关键字" />
    </div>
    <div class="nysearch2">
    <input type="submit" name="button" id="button"  class="butn" value="搜索" onclick="gotosearch()"/>
    </div>
  </div>
</div>
<div class="nybox1" style="display:none">
  <div class="nybox1_1 layui-carousel" id="test1">
  
   <div carousel-item="" id="ad000">
	 <img src="<%=request.getContextPath() %>/rapast/index/images/wutu2.png"  width="675" height="340"  />
	</div>
  
  </div>
  <div class="nybox1_2" >
      <div class="ny_bt"><b></b><span><img src="<%=request.getContextPath() %>/rapast/index/images/icon2.jpg" width="23" height="16" />热点新闻</span></div>
    
    <div class="nybox1_2_1" id="classidistop">
    
    </div>
      <div class="nybox1_2_2">
        <ul id="classidistoplist">
      
        </ul>
      </div>
      
  </div>
</div>
<div class="nybox2" id="classid">
 

</div>
<%@ include file="/rapast/index/foot.jsp"%>
</body>
</html>

<script type="text/javascript">
layui.use(['carousel', 'form'], function(){
  var carousel = layui.carousel
  ,form = layui.form;
   carousel.render({elem: '#test13',width: '1400px' ,height: '240px' ,interval: 5000 });
});
</script>
