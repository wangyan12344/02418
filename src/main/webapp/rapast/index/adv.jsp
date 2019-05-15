<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/rapast/commonindex/jsp/commonJs.jsp"%>
	<script type="text/x-jsrender" id="ad3Template">
<a href="{{:imgurl}}" >
        <dd><img src="{{:img}}" width="58" height="58" /></dd>
        <dt>{{:company}}</dt></a>
</script>
<script type="text/x-jsrender" id="ad4Template">
<a href="{{:imgurl}}" >
<img src="{{:img}}" width="300" height="85" /></a>
</script>
  <div class="left_menu">
      <dl id="ad3">
      </dl>
      <dl id="ad4">
      </dl>
      <dl id="ad5">
      </dl>
      <dl id="ad6">
      </dl>
      <dl id="ad7">
      </dl>
      <dl id="ad8">
      </dl>
    </div>
    <div class="gg2" id="ad9"></div>
<script type="text/javascript" src="<%=request.getContextPath() %>/rapast/index/js/adv.js"></script>