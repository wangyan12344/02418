<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="IE=8,9,10" >
<title>添加</title>
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
	.forminfo li{
		display:inline-flex;
	}
	.forminfo li label{
		padding-left: 10px;
	}
	.dfinput{
		width:235px !important;
	}
	.file {
    position: relative;
    display: inline-block;
    background: #D0EEFF;
    border: 1px solid #99D3F5;
    border-radius: 4px;
    padding: 4px 12px;
    overflow: hidden;
    color: #1E88C7;
    text-decoration: none;
    text-indent: 0;
    line-height: 20px;
}
.file input {
    position: absolute;
    font-size: 100px;
    right: 0;
    top: 0;
    opacity: 0;
}
.file:hover {
    background: #AADFFD;
    border-color: #78C3F3;
    color: #004974;
    text-decoration: none;
    cursor: pointer;
}
</style>
<script type="text/x-jsrender" id="formTemplate">
    <div class="formtitle"><span>广告位图信息</span></div>
    <ul class="forminfo">
    
	  	    	
	    
			<input type='hidden' name='zlBAdvertisement.id' id='id'  dc='true'  maxlength='64'  value='{{:id}}' />
	    
	    
			<li><label>标题</label><input type='text' class='dfinput' dcrequired name='zlBAdvertisement.company' id='company' value='{{:company}}'  dc='true'    /></li>
	    <br>
			<li><label>图片位置</label>
<select name='zlBAdvertisement.tag'  id='tag'  dc='true'  class='select1'  ></select>
 </li><br>
			<li><label>链接地址</label><input type='text' class='dfinput' dcrequired name='zlBAdvertisement.imgurl' value="{{:imgurl}}"    dc='true'    /></li>
			<br>
	  	    <li><label>是否启用</label><select name='zlBAdvertisement.status' id='status'  dcrequired='请选择是否开始' dc='true'    class='select1'  ></select></li>
	    	<br>
	 		<li id="pictureare"><label>上传图片</label><input name="zlBAdvertisement.img" value='{{:img}}'  id="imgurl"  type="hidden" dc="true" class="dfinput" value=""  />
				<br>
				<div class="file" >选择图片
				<input type="file" id="uploadFile" dc="true" name="file" onchange="upload()"/>
				</div></li>
				<br>
			<li id="pictureare2" style="margin-left:95px;">
			{{if img!="null"&&img!=""}}
			<a href="{{:img}}" class="advanced" target="_blank" id="ad1">
			<img src="{{:img}}"  id="imgurl1" dc="true" width="200px" height="173px"> 
			</a>
			{{else}}
			<img src="<%=request.getContextPath() %>/rapast/common/images/zhiliang_log.png"  id="imgurl1" dc="true" width="200px" height="173px">
			{{/if}}
			</li>
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
    <div class="formbody" id="formbody">
    </div>
    <div style="margin-bottom:10px;"></div>    

<div style="margin: 40px auto 0;text-align: center;padding-bottom: 20px;">
<input name="" type="button" id="submitBtn" class="btn" value="保存"/>&nbsp;&nbsp;&nbsp;&nbsp;<input name="" id="closeBtn" type="button" class="btn" value="返回"/>
</div>
<%@ include file="/rapast/common/jsp/commonJs.jsp"%>
<script type="text/javascript" src="<%=request.getContextPath() %>/rapast/zhiliang/manager/ZlBAdvertisement/js/ZlBAdvertisement_update.js"></script>
</body>
</html>
