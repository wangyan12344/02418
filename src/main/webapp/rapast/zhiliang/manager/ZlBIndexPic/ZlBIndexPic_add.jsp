<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="IE=8,9,10" >
<title>添加</title>
<%@ include file="/rapast/common/jsp/commonCss.jsp"%>
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
</head>
<body>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="javascript:returnMainPage();">返回占位图片列表</a></li>
    <li><a href="#">添加占位图片信息</a></li>
    </ul>
    </div>
    
    <div class="formbody" id="formbody">
    
    <div class="formtitle"><span>录入信息</span></div>
    
    <ul class="forminfo" id="editForm">
	  	    	
	    
			 <input type='hidden' name='zlBIndexPic.id' id='picid'  dc='true'   /> 
	         <input type='hidden' name='zlBIndexPic.readnum' id='readnum'  dc='true'    />
	    
			<li><label>用于何处</label><select name='zlBIndexPic.used' id='used' dcrequired='请输入用于何处' dc='true'  maxlength='64'  class='select1'  ></select></li>
		
	  	    	
	    
			<li><label>位置</label><select name='zlBIndexPic.position' id='position' dcrequired='请选择位置' dc='true'  maxlength='64'  class='select1'  ></select></li>
		
			<br>
	    
			<li><label>序号</label><input type='text' class='dfinput'  name='zlBIndexPic.ordernum' id='ordernum'  dc='true'  maxlength='64'  />&nbsp;</li>
	  	    	
	    
			<li><label>网页标题</label><input type='text' class='dfinput'  name='zlBIndexPic.remark' id='remark'  dc='true'  maxlength='100'  /></li>
	  	    <br>	
			<li style="line-height: 100%;"><label><input name="Visiturl" type="checkbox" value="1" id="checkbox" onclick="SelectedCheck()"/>隐藏跳转路径</label>&nbsp;&nbsp;&nbsp;<input type='text' class=''  name='zlBIndexPic.visiturl' id='visiturl'  dc='true'  maxlength='100' style="width:1000px;" readonly /></li>
	  	    <br/>	
	 		<li id="pictureare"><label>图片</label><input name="zlBIndexPic.imgurl"   id="imgurl"  type="hidden" dc="true" class="dfinput" value=""  />
				<br>
				<div class="file" style="margin-left:20px;">选择图片
				<input type="file" id="uploadFile" dc="true" name="file" onchange="upload()"/>
				</div></li>
				<br>
			<li id="pictureare2" style="margin-left:97px;"><img src=""  id="imgurl1" dc="true" width="200px" height="173px"> </li>
	        <br>
	        <li style="margin-left:0px;"><label>新闻标题</label><input type='text' class='dfinput' name='zlBIndexPic.newstitle' id='newstitle'  dc='true'/></li>
		    <br> 
	       <li style="margin-left:0px;"><label>新闻简介</label><textarea name="zlBIndexPic.introduction"  style=" height:117px; width:800px; line-height:32px; border-top:solid 1px #a7b5bc; border-left:solid 1px #a7b5bc; border-right:solid 1px #ced9df; border-bottom:solid 1px #ced9df;  text-indent:10px;"  value="" dc="" ></textarea></li> 
	
	       <li style="margin-left:0px;"><label>新闻内容</label>
           <span id="memo" style="display: inline-block;" dc="true"></span></li>
    </ul>
    </div>
    
    
<div style="margin: 40px auto 0;text-align: center;padding-bottom: 20px;">
<input name="" type="button" id="subBnt" class="btn" onclick="saveForm()" value="保存"/>&nbsp;&nbsp;&nbsp;&nbsp;<input name="" id="closeBtn" type="button" class="btn" value="返回"/>
</div>
<script type="text/javascript" src="<%=request.getContextPath()%>/rapast/common/js/ueditor/ueditor.config.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/rapast/common/js/ueditor/ueditor.all.js"></script>
<%@ include file="/rapast/common/jsp/commonJs.jsp"%>
<script type="text/javascript" src="<%=request.getContextPath() %>/rapast/zhiliang/manager/ZlBIndexPic/js/ZlBIndexPic_add.js"></script>
</body>
</html>


