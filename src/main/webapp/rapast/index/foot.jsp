<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/rapast/commonindex/jsp/commonJs.jsp"%>
	<script type="text/x-jsrender" id="youqingTemplate">
	<li><a href="{{:activityurl}}" target="_blank" >{{:activityname}}</a></li>
	</script>
<div class="foot">版权所有： 葫芦岛银行 <br/> 
总访问<span id="totalcount"></span>次  在线人数<span id="pcount"></span>人  当日访问量<span id="daycount"></span>次   <a href="<%=request.getContextPath() %>/loginManagerController/showLoginPage.do">管理入口</a></div>
<script type="text/javascript" src="<%=request.getContextPath() %>/rapast/index/js/foot.js"></script>

<script type="text/javascript">
layui.use(['carousel', 'form'], function(){
  var carousel = layui.carousel
  ,form = layui.form;
  //图片轮播
   carousel.render({elem: '#test1',width: '500px' ,height: '333px' ,interval: 5000 });
   carousel.render({elem: '#test11',width: '1400px' ,height: '180px' ,interval: 5000 });
});
</script>