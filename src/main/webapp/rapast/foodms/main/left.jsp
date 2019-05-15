<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="IE=8,9,10" >
<title>无标题文档</title>
<%@ include file="/rapast/common/jsp/commonCss.jsp"%> 

<script type="text/x-jsrender" id="leftMenuTemplate">
{{for menuList}}
   	<dd>
	    <div class="title"><span><img src="{{rootpath /}}/rapast/common/images/leftico04.png" /></span>{{:menuname}}</div>
	    <ul class="menuson">
		{{for childrenMenu}}
	        <li><cite></cite><a href="{{rootpath /}}{{:menupath}}" target="rightFrame">{{:menuname}}</a><i></i></li>
		{{/for}}
     	</ul>
    </dd>
{{/for}}
</script>
<script type="text/javascript">
	var parentmenucode = '<%=request.getParameter("parentmenucode") %>';
</script>
</head>

<body style="background:#f0f9fd;">
	<div class="lefttop"><span></span>系统平台</div>
    
    <dl class="leftmenu" id="leftMenuId">
   
    
    </dl>


<%@ include file="/rapast/common/jsp/commonJs.jsp"%> 
<script type="text/javascript">
$(function(){	
	var parentcode=parentmenucode;
	var userid = parent.CsGlobalObj.currentUserid;
	$.ajax({
		url:getRequestUrl("/loginManagerController/querySysResourceBytype.json"),
		dataType:"json",
		data:{"userid":userid,"menutype":1,"parentmenucode":parentcode},
		success:function(data){
			var leftMenuHtml = $("#leftMenuTemplate").render(data);
			$("#leftMenuId").html(leftMenuHtml);
			
			//导航切换
			$(".menuson li").click(function(){
				$(".menuson li.active").removeClass("active")
				$(this).addClass("active");
			});
			$('.title').click(function(){
				var $ul = $(this).next('ul');
				$('dd').find('ul').slideUp();
				if($ul.is(':visible')){
					$(this).next('ul').slideUp();
				}else{
					$(this).next('ul').slideDown();
				}
			});
			
			var triggerHref = $(".menuson li").filter(":first").find("a").attr("href");
			if(isNotEmpty(triggerHref)){
				parent.rightFrame.location.href=triggerHref;
			}
		},
		error:function(error){
			alert("error");
		}
	});
	
	
})	
</script>    
</body>
</html>

