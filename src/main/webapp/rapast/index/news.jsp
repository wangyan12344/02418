<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="x-ua-compatible" content="IE=8,9,10" >
<title>葫芦岛银行</title>
<link href="<%=request.getContextPath() %>/rapast/index/css/style.css" rel="stylesheet" type="text/css" />
<%@ include file="/rapast/commonindex/jsp/commonJs.jsp"%>
<script type="text/javascript" src="<%=request.getContextPath() %>/rapast/index/js/news.js"></script>
<script src="<%=request.getContextPath() %>/rapast/index/layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->

	<script type="text/x-jsrender" id="classTemplate">
 	  <div class="nybox2_1 {{if #index%2==0}}left{{else}}right{{/if}}"  >
      <div class="ny_bt" onclick=gotonewslist('{{:categoryid}}')><b><a href="javascript:void(0)">更多></a></b><span><img src="<%=request.getContextPath() %>/rapast/index/images/icon2.jpg" width="23" height="16" />{{:categoryname}}</span></div>
     {{if zlbnews!=""}}
 <div class="nybox2_1_1" onclick=gotonewsdetail("{{:zlbnews.newsid}}")>{{if zlbnews.mainimgpath!="" && zlbnews.mainimgpath!=null}}<img src="{{:zlbnews.mainimgpath}}" />{{else}}{{/if}}<h2>{{:zlbnews.newstitle.substring(0,24)}}</h2><b>{{:zlbnews.publishtime}}</b><span>{{:zlbnews.newsintro.substring(0,100)}}</span><kbd><a href="javascript:void(0)">查看详细></a></kbd></div>
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
<img src="{{:mainimgpath}}"  width="500" height="333"  >
{{else}}
<img src="<%=request.getContextPath() %>/rapast/index/images/wutu2.png"  width="500" height="333"  />
{{/if}}

</a>
	</script>	
	<script type="text/javascript">
	var parentid = '<%=request.getParameter("opid") %>';
	</script>
</head>
<body>
<%@ include file="/rapast/index/top.jsp"%>
<%@ include file="/rapast/index/adnei.jsp"%>

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
<div class="nybox1">
      <div class="nybox1_3" >
       <div class="r_notice">
      <div class="r_notice_bt" id="tongzhigonggaoname">通知公告</div>
      <div class="r_notice_nr1" style="    height: 262px;">
        <ul id="tongzhigonggao">
          
 <!--            <li><span>2018-07-02</span><a href="javascript:void(0)">绥中支行冠名绥中县第二届</a></li>
          <li><span>2018-07-02</span><a href="javascript:void(0)">总行全面开展集中诉讼工作 </a></li>
          <li><span>2018-07-02</span><a href="javascript:void(0)">总行举办“十九大后的宏观... </a></li>
          <li><span>2018-07-02</span><a href="javascript:void(0)">市银监局相关领导到我行进... </a></li>
          <li><span>2018-07-02</span><a href="javascript:void(0)">绥中支行冠名绥中县第二届“...</a></li>  
           <li><span>2018-07-02</span><a href="javascript:void(0)">市银监局相关领导到我行进... </a></li>
          <li><span>2018-07-02</span><a href="javascript:void(0)">绥中支行冠名绥中县第二届“...</a></li>  
           <li><span>2018-07-02</span><a href="javascript:void(0)">绥中支行冠名绥中县第二届“...</a></li>  --> 
        </ul>
      </div>
      <div class="r_notice_nr2"></div>
    </div>
      
  </div> 
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

