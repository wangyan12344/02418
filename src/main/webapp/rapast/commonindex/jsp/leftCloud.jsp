<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<div class="topmenubg">
		<span class="logo">Food Ordering</span>
        <span class="poweroff"><a class="icon-power-off" href="<%=request.getContextPath()%>/loginManagerController/showLoginPage.do"></a>
        <a href="<%=request.getContextPath()%>/loginManagerController/showLoginPage.do">退出</a></span> 
</div>
<div class="leftmenu">
	<ul>
	   <li class="menu1"><a href="<%=request.getContextPath() %>/LoginManagerCloudController/showManipage.do"><span class="icon-home" ></span><span>主<br/><br/>页</span></a></li>
	   <li class="menu2"><a href="customer.htm"><span class="icon-food2"></span><span>食客信息</span></a></li>
	   <li class="menu3"><a href="restaurant.htm"><span class="icon-store"></span><span>商户信息</span></a></li>
	   <li class="menu4"><a href="<%=request.getContextPath() %>/keyWordsManagerController/showKeywordspage.do" class="on"><span class="icon-loyalty"></span><span>关键字</span></a></li>
	   <li class="menu5"><a href="sheet.htm"><span class="icon-pie"></span><span>报<br/><br/>表</span></a></li>
	</ul>
</div>

