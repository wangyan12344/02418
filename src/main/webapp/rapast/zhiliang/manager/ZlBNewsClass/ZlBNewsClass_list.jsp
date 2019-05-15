<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="IE=8,9,10" >
<title>新闻分类管理页面</title>
<%@ include file="/rapast/common/jsp/commonCss.jsp"%>
</head>

<script type="text/x-jsrender" id="dataListTemplate">

	<tr>	
		<td style="text-align:left;line-height: 25px;">
{{if level=="1"}}<b>{{:categoryname}} [{{transcode:permissions kind='NEWS_CLASS_TYPE'}}]</b>{{/if}}　
{{if level=="2"}}<img src="<%=request.getContextPath() %>/rapast/zhiliang/manager/ZlBNewsClass/tree_line1.gif">　{{:categoryname}} {{/if}}
{{if level=="3"}}<img src="<%=request.getContextPath() %>/rapast/zhiliang/manager/ZlBNewsClass/tree_line2.gif"><img src="<%=request.getContextPath() %>/rapast/zhiliang/manager/ZlBNewsClass/tree_line1.gif">　{{:categoryname}}{{/if}}  </td>
  		 
			<td style="text-align:center;line-height: 25px;">{{if status=='1'}}是{{else}}<span style="color:red">否</span>{{/if}}</td>
<td style="text-align:center;line-height: 25px;">{{if level=="1"}}{{:urlnum}}{{/if}}　</td>
 	<td style="text-align:center;line-height: 25px;">{{if level=="2"}}{{:ordernum}}{{/if}}　</td>	
		<td style="text-align:center;line-height: 25px;">{{if level<'2'}}<a href="javascript:addEntityDataFun('{{:categoryid}}','{{:parentid}}','{{:level}}');" class="tablelink">新增子分类</a>{{/if}}</td>
 		<td style="text-align:center;line-height: 25px;"><a href="javascript:updateEntityDataFun('{{:categoryid}}','{{:parentid}}');" class="tablelink">修改</a></td>
     	<td style="text-align:center;line-height: 25px;">{{if level>'1' }}<a href="javascript:deleteHandle('{{:categoryid}}');" class="tablelink">删除</a>{{/if}}</td>
  
</tr>
 
</script>
<body>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">新闻分类管理</a></li>
    <li><a href="<%=request.getContextPath() %>/manager/ZlBNewsClassController/list.do">新闻分类列表</a></li>
    </ul>
    </div>

    <div class="rightinfo">
    	<div class="tools">
	         <ul class="seachform" style="display:inline !important;" id="search_Form">
	        <!-- 查询条件form begin-->
			     
			 <!--     <li><label>新闻分类名称</label><input type='text' class='dfinput' VALUECONTEXTUUU name='zlBNewsCategory.categoryname' id='categoryname' dcrequired='请输入新闻分类名称' dc='true'  maxlength='200'/></li>
			 		
			 	 <li><label>新闻分类序号</label><input type='text' class='dfinput' VALUECONTEXTUUU name='zlBNewsCategory.ordernum' id='ordernum' dcrequired='请输入新闻分类序号' dc='true'  maxlength='32'/></li>
			 
			 
			<!-- 查询条件end -->   
			 <!--   <li><label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label><input name="" type="button" class="scbtn" id="search_btn" value="查询"/></li> -->
		    </ul>
		    
	    	<ul class="toolbar1">
	        <li><a href="<%=request.getContextPath() %>/manager/ZlBNewsClassController/add.do" target="rightFrame"><span><img src="<%=request.getContextPath() %>/rapast/common/images/t01.png" /></span>添加</a></li> 
	        </ul>
    	</div>
    	
    
    <table class="tablelist">
     <!-- 列表表头区 -->
    <thead>
    <tr>
     <th style="text-align:left;" >分类名称</th>
	    <!--<th style="text-align:center;">新闻分类编号</th>-->
		 <th style="text-align:center;width:10%;">是否启用</th>
		  <th style="text-align:center;width:10%;">一级导航排序</th>
		   <th style="text-align:center;width:10%;">二级分类排序</th>
		  <th style="text-align:center;width:10%;">增加子类</th>
		   <th style="text-align:center;width:10%;">修改</th>
		    <th style="text-align:center;width:10%;">删除</th>
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
<script type="text/javascript" src="<%=request.getContextPath() %>/rapast/zhiliang/manager/ZlBNewsClass/js/ZlBNewsClass_list.js"></script>
</html>


