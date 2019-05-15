<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="IE=8,9,10" >
<title>新闻信息列表</title>
<%@ include file="/rapast/common/jsp/commonCss.jsp"%>
</head>
<script type="text/x-jsrender" id="dataListTemplate">
 	<tr>  
<td>{{:ordernum}}</td>	
<td style="width:20%:font-size:16px;">{{:newstitle}}<br>
<div style="font-size:12px;color:#6a6a6a;line-height: 18px;">
首页显示:【{{transcode:isHomePage kind='YES_NO'}}】 
栏目内置顶【 {{transcode:istop kind='YES_NO'}}】 
首页滚动图片：【{{transcode:ishot kind='YES_NO'}}】</div/.</td> 
<td>{{:departmentusername}}</td>	
<td>{{:departmentname}}</td>
<td>{{:sysname}}</td>
<td>{{:parentname}} </td>
<td>{{:categoryname}}</td>

<td>{{:visitnum}}</td>
<td>{{:praisenum}}</td>
 
<td>{{:publishtime}}</td>
<td>
	<a href="javascript:updateHandle('{{:newsid}}');" class="tablelink">查看/修改</a> 
	<a href="javascript:deleteHandle('{{:newsid}}');" class="tablelink">删除</a></td>
    </tr>
</script>

<script type="text/x-jsrender" id="formTemplate">

				<li><label>新闻题目</label><input type='text'   class='dfinput' placeholder='请输入新闻标题' dc="true" name='zlBNews.newstitle' id='newstitle' /></li>
			 				
	  			<li><label>首页显示</label>
	  				<select   name="zlBNews.isHomePage" id="isHomePage"  class='select1'  dc="true" >
	  					{{renderOptionFun yeorno "codevalue" "codename" '' /}}
	  				</select> </li>	
<li><label>栏目内置顶</label>
	  				<select   name="zlBNews.istop"  id="istop"  class='select1'  dc="true" >
	  					{{renderOptionFun yeorno "codevalue" "codename" '' /}}
	  				</select> </li>	
 <li><label>首页滚动图片</label>
	  				<select   name="zlBNews.ishot"  id="ishot"  class='select1'  dc="true" >
	  					{{renderOptionFun yeorno "codevalue" "codename" '' /}}
	  				</select> </li>	
	<li><label>发布时间</label>
			 		<input type="text" class="dfinput datepicker" name="zlBNews.stime" id="stime" placeholder="始" dc="true" style="background-color: rgb(255, 255, 255);">
			 		至 <input type="text" class="dfinput datepicker" name="zlBNews.etime" id="etime" placeholder="末" dc="true" style="background-color: rgb(255, 255, 255);">
			 	</li>
<li style="width:100%;height:10px"></li>
<li><label>类别种类</label>
<select name="zlBNews.permissions" id="permissions" dc="true" class="select1" dcrequired="请选择" style="width: 235px;"  onchange="permissionschange()">
<option value="">请选择</option>
<option value="1">常规页面</option>
<option value="2">部室网页</option>
<option value="3">分支行网页</option></select> </li>		
	  			<li style="display:none" id="firstid"><label>一级分类</label>
	  				<select   id='fvalue'   class='select1' name="zlBNews.parentid" dc="true"   onchange="firstchange()">
 					 <option value="">请选择</option>
	  				</select> </li>		
<li style="display:none" id="secondid"><label>二级分类</label>
<select name="zlBNews.categoryid" dcrequired="请选择一级分类" dc="true"  class="select1" id="svalue">
        	<option value="">请选择</option> 
		</select>
	  				</li>	
	  			
			 
		    <li><label>&nbsp;</label><input name="" type="button" class="scbtn" id="search_btn" value="查询"/></li> 	
		    <li><label>&nbsp;</label><input name="" type="button" class="scbtn" value="导出" onclick="exportExcel();"/></li>     
<li style="width:100%;height:10px"></li>
</script>
<body>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">新闻管理</a></li>
    <!-- <li><a href="#">基础信息管理</a></li> -->
    <li><a href="#">新闻列表</a></li>
    </ul>
    </div>

    <div class="rightinfo" id=" formbody">
    	<div class="tools">	
    		<ul class="seachform" style="display:inline !important;" id="search_Form">
		      </ul>   
	    	<ul class="toolbar1">	    	
	        <li><a href="<%=request.getContextPath() %>/manager/ZlBNewsController/add.do" target="rightFrame"><span><img src="<%=request.getContextPath() %>/rapast/common/images/t01.png" /></span>添加</a></li>
	        </ul>
    	</div>
    	
 
    <table class="tablelist">
     <!-- 列表表头区 -->
    <thead>
    <tr>	
    <th style="text-align:center;">序号<input type="checkbox" name="checkbox1" value="序号-D.ordernum" ></th>     	
		  <th style="text-align:center;">新闻标题<input type="checkbox" name="checkbox1" value="新闻标题-D.newstitle" ></th>		 	
		  <th style="text-align:center;" style="width:15%">作者<input type="checkbox" name="checkbox1" value="作者-D.departmentusername" ></th>
		   <th style="text-align:center;" style="width:15%">单位<input type="checkbox" name="checkbox1" value="单位-D.departmentname" ></th>
		    <th style="text-align:center;" style="width:15%">编辑<input type="checkbox" name="checkbox1" value="编辑-D.sysname" ></th>
		  <th style="text-align:center;">一级<input type="checkbox" name="checkbox1" value="一级栏目-D.parentname" ></th>	
		  <th style="text-align:center;">二级<input type="checkbox" name="checkbox1" value="二级栏目-D.categoryname" ></th>	
		  <th style="text-align:center;">访问(次)<input type="checkbox" name="checkbox1" value="访问量(次)-D.visitnum" ></th> 
		  <th style="text-align:center;">点赞(次)<input type="checkbox" name="checkbox1" value="点赞量(次)-D.praisenum" ></th> 
 
		  <th style="text-align:center;">发布时间<input type="checkbox" name="checkbox1" value="发布时间-D.publishtime" ></th>
		  <th style="text-align:center;">操作 <input onclick="selectAll()" type="checkbox"   name="checkbox"  id="controlAll" ></th>
    </tr>
    </thead>
    
    <!-- 列表数据区 -->
    <tbody  id="dataListId">
    </tbody>
    
    </table>
    
    
   <!-- 分页页码 -->
    <div class="pagin" id="pagefoot">
    </div>
    
    </div>

</body>
<%@ include file="/rapast/common/jsp/commonJs.jsp"%>
<script type="text/javascript" src="<%=request.getContextPath() %>/rapast/zhiliang/manager/ZlBNews/js/ZlBNews_list.js"></script>
</html>


