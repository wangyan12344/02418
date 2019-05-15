<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="IE=8,9,10" >
<title>修改</title>
<%@ include file="/rapast/common/jsp/commonCss.jsp"%>
</head>
<style type="text/css">
	.forminfo li{
		display:inline-flex;
		    width: 100%;
	}
	.forminfo li label{
		padding-left: 10px;
	}
	.dfinput{
		width:235px !important;
	}
</style>
<script type="text/x-jsrender" id="formTemplate">
   
</script>


<script type="text/javascript">
	var id = '<%=request.getParameter("id") %>';
	var parentid = '<%=request.getParameter("parentid") %>';
</script>
<body>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="javascript:;">修改</a></li>
    </ul>
    </div>
    <div class="formbody" id="formbody">
   
    <ul class="forminfo">
      <input type="hidden" value=""  name="zlBNewsCategory.parentid"  dc="true" id="typeparentid">
		    <input type="hidden" value=""  name="zlBNewsCategory.categoryid"  dc="true" id="typeid">
		    <input type="hidden" value=""  name="zlBNewsCategory.level"  dc="true" id="levelid">
		    <!-- <li><label>父级分类：</label><label><div id="typename"></div></label></li>    --> 
		    <li style="height:30px"><label>分类名称：</label><input name="zlBNewsCategory.categoryname" dcrequired="请输入分类名称" type="text" class="dfinput " value="" dc=""  style="width:200px;" id="classname" /></li>   
			<li style="height:30px"><label>是否启用：</label>
			<select name='zlBNewsCategory.status'  id='status'  dc='true'    class='select1'  ></select></li>
	 <li id="classtype" style="display:none" style="height:30px"><label>栏目类型：</label>
					<select name='zlBNewsCategory.permissions'  id='permissions'  dc='true'  class='select1'  ></select></li> <br>
		<li  ><label>分类介绍</label><textarea name="zlBNewsCategory.content" dcrequired="请输入分类说明" id="content" style=" height:117px; width:800px; line-height:32px; border-top:solid 1px #a7b5bc; border-left:solid 1px #a7b5bc; border-right:solid 1px #ced9df; border-bottom:solid 1px #ced9df;  text-indent:10px;"  value="" dc="" ></textarea></li> 
	<li style="height:30px;display:none" id="urlnumid"><label>导航菜单排序：</label><input name="zlBNewsCategory.urlnum" dcrequired="请输入" type="text" id="urlnum" class="dfinput " value="" dc=""  /></li>
    	<li style="height:30px;display:none" id="ordernumid"><label>二级分类排序：</label><input name="zlBNewsCategory.ordernum" dcrequired="请输入" type="text" id="ordernum" class="dfinput " value="" dc="" oninput='this.value=this.value.replace(/^[0]+[0-9]*$/gi,"")'  /><span style="line-height: 30px;
    padding-left: 10px;
    color: #ff0202;">(只能输入大于0的数字)</span></li>
    	
    	<!-- <li><label>小图标：</label><input name="zlBNewsCategory.imgurl"   id="imgurl"  type="hidden"  class="dfinput" value="" dc="" /><a href="#" class="uploada" title=""><input type="file" id="uploadFile"  class="uploadinput" name="file" onchange="upload()"></a></li>
					<li><label>图片尺寸：</label><label style="width:154px;">32*32像素，背景透明或白色</label> </li>
					<li><label></label><img src=""  id="imgurl1" width="154px" height="154px"> </li>
					<li><label>首页分类图片：</label><input name="zlBNewsCategory.indeximgurl"   id="indeximgurl"  type="hidden"  class="dfinput" value="" dc=""   />	
					<a href="#" class="uploada" title=""><input type="file" id="uploadFile2"  class="uploadinput" name="file" onchange="upload2()"></a></li>
					<li><label>图片尺寸：</label> 100*123像素</li>
					<li><label></label><img src=""  id="imgurl2" width="154px" height="154px"> </li>	 -->
    </ul>
    </div>
    <div style="margin-bottom:10px;"></div>    

<div style="margin: 40px auto 0;text-align: center;padding-bottom: 20px;">
<input name="" type="button" id="submitBtn" class="btn" value="保存"/>&nbsp;&nbsp;&nbsp;&nbsp;<input name="" id="closeBtn" type="button" class="btn" value="返回"/>
</div>
<%@ include file="/rapast/common/jsp/commonJs.jsp"%>
<script type="text/javascript" src="<%=request.getContextPath() %>/rapast/zhiliang/manager/ZlBNewsClass/js/ZlBNewsClass_update.js"></script>
</body>
</html>
