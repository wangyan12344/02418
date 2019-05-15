<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/rapast/commonindex/jsp/commonJs.jsp"%>
 
<script type="text/x-jsrender" id="adneiTemplate">
<a href="{{:imgurl}}" >
{{if img!=""}}
<img src="{{:img}}" width="1400" height="180" >
{{else}}
<img src="<%=request.getContextPath() %>/rapast/index/images/wutu1.png" width="1400"  height="180"  />
{{/if}}
</a>
</script>
<div class="nybanner layui-carousel" id="test11">
 <div carousel-item="" id="adnei"  style="display:none">
	 
	</div>
	</div>
 
<script type="text/javascript" src="<%=request.getContextPath() %>/rapast/index/js/adnei.js"></script>
