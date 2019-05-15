<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="IE=8,9,10" >
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
<title>新闻新增</title>
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

    <li><label>新闻标题</label><input name="zlBNews.newstitle" dcrequired="请输入新闻标题" type="text" class="long dfinput" value="" dc=""  /></li> <br/>
	<li><label>序号</label><input name="zlBNews.ordernum" dcrequired="请输入序号" type="text" class="dfinput" value="" dc=""  /></li>
	<li><label>发布时间</label><input name="zlBNews.publishtime"   type="text" class="dfinput datepicker" dc=""  /></li> 
	<br> 
	<li><label>新闻简介</label><textarea name="zlBNews.newsintro" dcrequired="请输入新闻简介" style=" height:117px; width:800px; line-height:32px; border-top:solid 1px #a7b5bc; border-left:solid 1px #a7b5bc; border-right:solid 1px #ced9df; border-bottom:solid 1px #ced9df; background:url(../images/inputbg.gif) repeat-x; text-indent:10px;"  value="" dc="" ></textarea></li> 
	
	<br>
	<li><label>新闻内容</label><span id="memo"   style="display: inline-block;" dc="true">	</span></li>
	<br>  
		<li><label>新闻类别</label>
		<select name="zlBNews.parentid" dcrequired="请选择一级分类" dc="true"  class="select1" id="fvalue" onchange="firstchange()">
        	{{renderOptionFun newscategory "categoryid" "categoryname" "0" /}}
		</select>
		<span style='color:red;display:inline;'>&nbsp;</span>

<select name="zlBNews.categoryid" dcrequired="请选择一级分类" dc="true" class="select1" id="svalue">
        	 <option value="">请选择一级分类</option>
		</select>
	</li>
	<br>  
		<li><label>投稿部门及作者</label>
<select name="zlBNews.department" dcrequired="请选择部门" dc="true"  class="select1" id="departmentid" onchange="selectdepartmentname()">
        	{{renderOptionFun zlBDepartmentlist "id" "departmentname" "" /}}
		</select>
<select name="zlBNews.departmentuser" dcrequired="请选择部门" dc="true" class="select1" id="departmentuserid">
        	 <option value="">请选择一级分类</option>
		</select>
	</li><br>  
	<!--<li><label>粮食品类</label>
		<select name="zlBNews.graintype" id="graintype" dcrequired="请选择粮食品类" dc="true" class="select1">
        	{{renderOptionFun graintype "codevalue" "codename"  /}}
		</select>
		<span style='color:red;display:inline;'>&nbsp;</span>
	</li>-->
	<br>
    <li><label>是否首页显示</label>
		<select name="zlBNews.isHomePage" dc="true" class="select1">
        	{{renderOptionFun yeorno "codevalue" "codename" "1" /}}
		</select>
	</li><br>
	<li><label>是否栏目内置顶</label>
		<select name="zlBNews.istop" dc="true" class="select1"  >
        	{{renderOptionFun yeorno "codevalue" "codename" "0" /}}
		</select>
		<label style="width:260px;">注：选择置顶后在本栏目顶部显示</label>
	</li>
		<br> 
<!--
<li><label>是否突出显示</label>
		<select name="zlBNews.prominent" dc="true" class="select1">
        	{{renderOptionFun yeorno "codevalue" "codename" "0" /}}
		</select>
		<label style="width:260px;">注：选择突出显示后文字颜色会有变化</label>
	</li> 
	<br> -->
<li><label>首页滚动图片</label>
		<select name="zlBNews.ishot" dc="true" class="select1">
        	{{renderOptionFun yeorno "codevalue" "codename" "0" /}}
		</select>
		<label style="width:260px;">注：图片在首页图片新闻处显示</label>
	</li>
	 
	<br> 
	<li><label>新闻模板</label>
		<select id="picture" name="zlBNews.templateid" dc="true" dcrequired="请选择模板类型" class="select1">
        	{{renderOptionFun newsmodel "codevalue" "codename" "0" /}}
		</select>
		<span style='color:red;display:inline;'>&nbsp;</span>
	</li>


 
 	<br>
    <li id="pictureare"><label>图片</label>
     <input name="zlBNews.mainimgpath"   id="imgurl"  type="hidden" dc="true" class="dfinput" value="" dc=""   />
	<a href="#" class="uploada_pic" title=""><input type="file" id="uploadFile" class="uploadinput" dc="true" name="file" onchange="upload()"/></a><span style="text-align: center;line-height:35px "> &nbsp;&nbsp;&nbsp;&nbsp;图片尺寸：宽高比例 3：2  （宽最小675像素）</span> </li>
	<br>
	<li id="pictureare2"><label></label>
	
	<img src=""  id="imgurl1" dc="true" width="300px"  height="200px"  style="display:none">
 	</li>
 </ul>
<ul id="packing" class="packing-ul">
</ul>
<ul>
<li > 	<b onclick="addPackprice()"  class='tablelink' style="padding-left: 114px;  font-size: 16px;cursor: pointer;">点击此处添加附件</b></li>
</ul>
		

</script>

<body>
	<div class="place">
       	<span>位置：</span>
     	<ul class="placeul">
       		<li><a href="javascript:;">添加</a></li><li>
     	</ul>
    </div>
    
    <div class="formbody" id="formId">
    </div>

<div style="margin:0 auto;text-align: center;padding-bottom: 20px;">
<input name="" type="button" id="submitBtn" class="btn" value="新增"/>&nbsp;&nbsp;&nbsp;&nbsp;<input name="" id="closeBtn" type="button" class="btn" value="返回列表"/>
</div>
</body>


<script type="text/javascript" src="<%=request.getContextPath()%>/rapast/common/js/ueditor/ueditor.config.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/rapast/common/js/ueditor/ueditor.all.js"></script>
<%@ include file="/rapast/common/jsp/commonJs.jsp"%>
<script type="text/javascript" src="<%=request.getContextPath() %>/rapast/zhiliang/manager/ZlBNews/js/ZlBNews_add.js"></script>
</html>
