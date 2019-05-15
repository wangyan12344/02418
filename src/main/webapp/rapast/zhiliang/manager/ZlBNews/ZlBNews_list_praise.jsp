<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="IE=8,9,10" >
<title>新闻点赞排行</title>
<%@ include file="/rapast/common/jsp/commonCss.jsp"%>
</head>
<script type="text/x-jsrender" id="dataListTemplate">
 	<tr>  	
<td>{{:newstitle}}</td> 
<td>{{:username}}</td>	
<td>{{:publishtime}}</td>
<td>{{:ordernum}}</td>
<td>{{:visitnum}}</td>
<td>{{:praisenum}}</td>
<td>{{transcode:isHomePage kind='YES_NO'}}</td>
<td>{{transcode:istop kind='YES_NO'}}</td>
<td>{{transcode:ishot kind='YES_NO'}}</td>

    </tr>
</script>

<script type="text/x-jsrender" id="formTemplate">

				<li><label>新闻题目</label><input type='text' class='dfinput' placeholder='请输入新闻标题' dc="true" name='zlBNews.newstitle' id='newstitle' /></li>
			 				
	  			<li><label>首页显示</label>
	  				<select   name="zlBNews.isHomePage"   class='select1'  dc="true" >
	  					{{renderOptionFun yeorno "codevalue" "codename" '' /}}
	  				</select> </li>	
<li><label>栏目内置顶</label>
	  				<select   name="zlBNews.ishot"   class='select1'  dc="true" >
	  					{{renderOptionFun yeorno "codevalue" "codename" '' /}}
	  				</select> </li>	
<!--<li><label>突出显示</label>
	  				<select   name="zlBNews.prominent"   class='select1'  dc="true" >
	  					{{renderOptionFun yeorno "codevalue" "codename" '' /}}
	  				</select> </li>	-->
	  			<li><label>一级类别</label>
	  				<select   id='fvalue'   class='select1'   onchange="firstchange()">
	  					{{renderOptionFun newscategory "categoryid" "categoryname" "" /}}
	  				</select> </li>		
<li><label>二级类别</label>
<select name="zlBNews.categoryid" dcrequired="请选择一级分类" dc="true"  class="select1" id="svalue">
        	 <option value="">请选择一级分类</option>
		</select>
	  				</li>		
	  			
			    

</script>
<body>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">统计管理</a></li>
    <!-- <li><a href="#">基础信息管理</a></li> -->
    <li><a href="#">新闻点赞排行</a></li>
    </ul>
    </div>

    <div class="rightinfo" id=" formbody">
    	<div class="tools">	
    		<ul class="seachform" style="display:inline !important;" id="search_Form">
	        <!-- 查询条件form begin-->
	         
			    
			<!-- 查询条件end -->   
			  
		    </ul> 
		    <ul class="seachform" style="display:inline !important;" id="search_Form">
		    <li><label>&nbsp;</label><input name="" type="button" class="scbtn" id="search_btn" value="查询"/></li> 	
		    <!-- <li><label>&nbsp;</label><input name="" type="button" class="scbtn" value="导出" onclick="exportExcel();"/></li>  -->
		   <!--  <li><label>共</label><label id="count"></label><label>条新闻</label></li>	
	    	<li><label>阅读量:</label><label id="visitcount"></label><label>次</label></li>
	    	<li><label>阅读百分比:</label><label id="percent"></label></li>  -->
		      </ul>   
	    	<%-- <ul class="toolbar1">	    	
	        <li><a href="<%=request.getContextPath() %>/manager/ZlBNewsController/add.do" target="rightFrame"><span><img src="<%=request.getContextPath() %>/rapast/common/images/t01.png" /></span>添加</a></li>
	        </ul> --%>
    	</div>
    	
    
    <table class="tablelist">
     <!-- 列表表头区 -->
    <thead>
    <tr>	     	
		  <th style="text-align:center;">新闻标题</th>
		  <th style="text-align:center;">发布者</th>		 	
		  <th style="text-align:center;">发布时间</th>	
		  <th style="text-align:center;">序号</th>	
		  <th style="text-align:center;">访问量(次)</th> 
		   <th style="text-align:center;">点赞量(次)</th> 
		  <th style="text-align:center;">是否首页显示</th>
		   <th style="text-align:center;">是否栏目内置顶</th> 
		   <th style="text-align:center;">图片新闻</th>
		<!--   <th style="text-align:center;">操作</th> -->
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
<script type="text/javascript" src="<%=request.getContextPath() %>/rapast/zhiliang/manager/ZlBNews/js/ZlBNews_list_praise.js"></script>
</html>


