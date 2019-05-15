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
<!-- B端广告图 -->
<script type="text/x-jsrender" id="formTemplateB">
    <div class="formtitle"><span>B端广告页</span></div>
    <ul class="forminfo">
	    	 <input type='hidden' name='zlBIndexPic.id' id='id'  dc='true'  maxlength='64'  value='{{:id}}' />
	         <input type='hidden' name='zlBIndexPic.used' id='used'  dc='true'  maxlength='64'  value='{{:used}}' />
	         <input type='hidden' name='zlBIndexPic.position' id='position'  dc='true'  maxlength='64'  value='{{:position}}' />
	    
	 		<li id="pictureare"><label></label><input name="zlBIndexPic.imgurl"   id="imgurl"  type="hidden" dc="true" class="dfinput" value="{{:imgurl}}" dc=""   />
				<br>
				<div class="file" style="margin-left:20px;">选择图片
           <input type="file" id="uploadFile" dc="true" name="file" onchange="upload()"/>
				</div></li>
                <br>
			<li id="pictureare2"><label></label><img src="{{:imgurl}}"  id="imgurl1" dc="true" width="300px" height="200px"> </li>
			
    </ul>
</script>
<!-- C端广告图 -->
<script type="text/x-jsrender" id="formTemplateC">
    <div class="formtitle"><span>C端广告页</span></div>
    <ul class="forminfo">
	    	 <input type='hidden' name='zlBIndexPic.id' id='id'  dc='true'  maxlength='64'  value='{{:id}}' />
	    	 <input type='hidden' name='zlBIndexPic.used' id='used'  dc='true'  maxlength='64'  value='{{:used}}' />
	         <input type='hidden' name='zlBIndexPic.position' id='position'  dc='true'  maxlength='64'  value='{{:position}}' />
	    
	 		<li id="pictureare2"><label></label><input name="zlBIndexPic.imgurl"   id="imgurl2"  type="hidden" dc="true" class="dfinput" value="{{:imgurl}}" dc=""   />
				<br>
				<div class="file" style="margin-left:20px;">选择图片
           <input type="file" id="uploadFile2" dc="true" name="file" onchange="upload2()"/>
				</div></li>
                <br>
			<li id="pictureare3"><label></label><img src="{{:imgurl}}"  id="imgurl3" dc="true" width="300px" height="200px"> </li>
			
    </ul>
</script>

<body>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="javascript:;">B端，C端广告页</a></li>
   
    </ul>
    </div>
    <div class="formbody" id="formbody">
    </div>
    <div style="margin-bottom:10px;"></div>    

<div style="margin: 40px auto 0;padding-bottom: 20px;margin-left:210px;">
<input name="" type="button" id="submitBtn" class="btn" value="保存B端图"/>
</div>

  <div class="formbody" id="edmintbody">
    </div>
    <div style="margin-bottom:10px;"></div>    

<div style="margin: 40px auto 0;padding-bottom: 20px;margin-left:210px;">
<input name="" type="button" id="subBtn" class="btn" value="保存C端图"/>
</div>

<%@ include file="/rapast/common/jsp/commonJs.jsp"%>
<script type="text/javascript" src="<%=request.getContextPath() %>/rapast/zhiliang/manager/ZlBIndexPic/js/ZlBIndexPic_advertisement.js"></script>
</body>
</html>
