<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="IE=8,9,10" >
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
<title>修改</title>
<%@ include file="/rapast/common/jsp/commonCss.jsp"%>

</head>
<style type="text/css">
	.forminfo li{
		display:inline-flex;
	}
	.forminfo li label{
		padding-left: 10px;
	}
	.dfinput{
		width:235px !important;
	}
	
	.long{
		width:802px !important;
	}
		.packing{margin-top: 2px;margin-left: 20px;width:800px; float:left; margin-left: 113px;margin-bottom:10px;}
	.packing-ul{width:800px; overflow:hidden;position:relative}
	.packing-label{left: 27px;position: absolute; line-height: 34px;} 

</style>
<script type="text/x-jsrender" id="formTemplate">
    <div class="formtitle"><span>新闻信息</span></div>
    <ul class="forminfo">
	<!--新闻id--><input name="zlBNews.newsid"  id="newsid"  type="hidden" class="dfinput" value='{{:entity.newsid}}' dc=""  />	
    <li><label>新闻标题</label><input name="zlBNews.newstitle" id="newstitle" dcrequired="请输入新闻标题" type="text" class="long dfinput" value='{{:entity.newstitle}}' dc=""  /></li> <br/>
	<li><label>序号</label><input name="zlBNews.ordernum"  type="text" class="dfinput" value="{{:entity.ordernum}}" dc=""  /></li> 
	<li><label>发布时间</label><input name="zlBNews.publishtime"   type="text" class="dfinput datepicker" value="{{:entity.publishtime}}" dc=""  /></li> 
	<br>
	<li><label>新闻简介</label><textarea name="zlBNews.newsintro" dcrequired="请输入新闻简介" type="text" style=" height:117px; width:800px; line-height:32px; border-top:solid 1px #a7b5bc; border-left:solid 1px #a7b5bc; border-right:solid 1px #ced9df; border-bottom:solid 1px #ced9df; background:url(../images/inputbg.gif) repeat-x; text-indent:10px; "  dc="" >{{:entity.newsintro}}</textarea></li> 
	
	<br>
	<li><label>新闻内容</label><span id="memo"   style="display: inline-block;" dc="true">	</span></li>
	<br>  
	
	<li><label>新闻类别</label>
		<select name="zlBNews.parentid"  dcrequired="请选择新闻类别" dc="true" class="select1" id="fvalue" onchange="firstchange()">
        	{{renderOptionFun newscategory "categoryid" "categoryname" entity.parentid /}}
		</select>
		<span style='color:red;display:inline;'>&nbsp;</span>
<select name="zlBNews.categoryid" dcrequired="请选择一级分类" dc="true" class="select1" id="svalue">
        	 {{renderOptionFun newscategorychild "categoryid" "categoryname" entity.categoryid /}}
		</select>
	</li>
	
	
	<br>
	<li><label>投稿部门及作者</label>
<select name="zlBNews.department" dcrequired="请选择部门" dc="true"  class="select1" id="departmentid" onchange="selectdepartmentname()">
        	{{renderOptionFun zlBDepartmentlist "id" "departmentname" entity.department  /}}
		</select>
<select name="zlBNews.departmentuser" dcrequired="请选择部门" dc="true" class="select1" id="departmentuserid">
        	 {{renderOptionFun zlBDepartmentUserlist "id" "departmentuser" entity.departmentuser /}}
		</select>
	</li><br> 
    <li><label>是否首页显示</label>
		<select name="zlBNews.isHomePage" dc="" class="select1">
        	{{renderOptionFun yeorno "codevalue" "codename" entity.isHomePage /}}
		</select>
		<span style='color:red;display:inline;'>&nbsp;</span>
	</li>
	<br>
<li><label>是否栏目内置顶</label>
		<select name="zlBNews.istop" dc="" class="select1">
        	{{renderOptionFun yeorno "codevalue" "codename" entity.istop /}}
		</select>
		<label style="width:260px;">注：选择置顶后在本栏目顶部显示</label>
	</li>
	<br> 	<!--
<li><label>是否突出显示</label>
		<select name="zlBNews.prominent" dc="true" class="select1">
        	{{renderOptionFun yeorno "codevalue" "codename" entity.prominent /}}
		</select>
		<label style="width:260px;">注：选择突出显示后文字颜色会有变化</label>
	</li> 
	<br> -->
<li><label>首页滚动图片</label>
		<select name="zlBNews.ishot" dc="" class="select1">
        	{{renderOptionFun yeorno "codevalue" "codename" entity.ishot /}}
		</select>
		<label style="width:260px;">注：图片在首页图片新闻处显示</label>
	</li>
	<br> 
	<li><label>新闻模板</label>
		<select id="picture" name="zlBNews.templateid" dc="true" dcrequired="请选择模板类型" class="select1">
        	{{renderOptionFun newsmodel "codevalue" "codename" entity.templateid /}}
		</select>
		<span style='color:red;display:inline;'>&nbsp;</span>
	</li> 
   {{if entity.templateid==="1"}} 
	<div id="pictureinfo" >
 		<br>
    		<li id="pictureare"><label>图片</label><input name="zlBNews.mainimgpath"  dc="" id="imgurl"  type="hidden"  class="dfinput" value="{{:entity.mainimgpath}}" dc=""   />
			<a href="#" class="uploada_pic" title=""><input type="file" id="uploadFile" class="uploadinput" dc="true" name="file" onchange="upload()"/></a><span style="text-align: center;line-height:35px "> &nbsp;&nbsp;&nbsp;&nbsp;图片尺寸：宽高比例 3：2  （宽最小675像素</span> </li>
		<br>
			<li id="pictureare2"><label></label>

			{{if entity.mainimgpath!=""||entity.mainimgpath!=null}}
				<img src="{{:entity.mainimgpath}}" dc="" id="imgurl1"  width="300px"  height="200px"   style="cursor: pointer"> 
			{{else}}
				<img src="/zlm/rapast/common/images/zhiliang_log.png" id="imgurl1" dc="true"  width="300px"  height="200px" >
			{{/if}}
			</li>
	<br>
	</div>
	{{else}}
	<div id="pictureinfo" style="display:none">
  	<br>
    <li  id="pictureare"><label>图片</label><input name="zlBNews.mainimgpath"  dc="" id="imgurl"  type="hidden"  class="dfinput" dc=""   />
	<a href="#" class="uploada" title=""><input type="file" id="uploadFile" class="uploadinput" dc="true" name="file" onchange="upload()"/></a><span style="text-align: center;line-height:35px "> &nbsp;&nbsp;&nbsp;&nbsp;图片尺寸： 199*135像素</span> </li>
	<br>
	<li id="pictureare2"><label>{{:entity.mainimgpath}}</label>
	{{if entity.mainimgpath!="" && entity.mainimgpath!=null}}
	<img src="{{:entity.mainimgpath}}" dc="" id="imgurl11" width="200px"   onclick="showImg('{{:entity.mainimgpath}}')" style="cursor: pointer"> 
	{{else}}
		<img src="<%=request.getContextPath()%>/rapast/index/images/wutu2.png" id="imgurl1" dc="true" width="200px" height="173px">
	{{/if}}
	</li>
	<br>
	</div>
	{{/if}}
 </ul>
<ul id="packing" class="packing-ul">
</ul>
<ul>
<li > 	<b onclick="addPackprice()"  class='tablelink' style="padding-left: 114px;  font-size: 16px;cursor: pointer;">点击此处添加附件</b></li>
</ul>
</script>
<script type="text/javascript">
	var opid = '<%=request.getParameter("opid") %>';
</script>
<body>
	<div class="place">
       	<span>位置：</span>
     	<ul class="placeul">
       		<li><a href="javascript:;">修改</a></li>
     	</ul>
    </div>
    
    <div class="formbody" id="formId">
    </div>

<div style="margin:0 auto;text-align: center;padding-bottom: 20px;">
<input name="" type="button" id="submitBtn" class="btn" value="修改"/>&nbsp;&nbsp;&nbsp;&nbsp;<input name="" id="closeBtn" type="button" class="btn" value="返回列表"/>
</div>
 
</body>
<script type="text/javascript" src="<%=request.getContextPath()%>/rapast/common/js/ueditor/ueditor.config.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/rapast/common/js/ueditor/ueditor.all.js"></script>
<%@ include file="/rapast/common/jsp/commonJs.jsp"%>
<script type="text/javascript" src="<%=request.getContextPath() %>/rapast/zhiliang/manager/ZlBNews/js/ZlBNews_update.js"></script>
</html>
