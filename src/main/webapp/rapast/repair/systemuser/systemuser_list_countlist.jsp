<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="IE=8,9,10" >
<title>新闻发布统计</title>
<%@ include file="/rapast/common/jsp/commonCss.jsp"%>
</head>
<script type="text/x-jsrender" id="dataListTemplate">
        <tr>
       <!-- <td><input name="checkboxGroupId" type="checkbox" value="{{:userid}}" /></td>-->
        <td>{{:username}}</td>
        <td>{{:account}}</td>
        <td>{{:newscount}}</td> 
        <td>{{:contacttelnumber}}</td>
       <td>{{transcode:usertype kind='USER_TYPE'}}</td>
        <td>{{:entrytime}}</td>
        <td>{{:userstatus}}</td>
       </tr>
</script>
<script type="text/javascript">
	var pageIndexback = '<%=request.getParameter("pageIndexback") %>';
</script>
<body>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="javascript:;">统计管理</a></li>
    <li><a href="javascript:;">新闻发布统计</a></li>
    </ul>
    </div>
    <div class="rightinfo">
    <div class="tools">
    <ul class="seachform" style="display:inline !important;" id="search_area">
    <li><label>搜索内容</label><input name="sysUserInfo.username" type="text" class="dfinput" placeholder="用户名  / 账号" dc="true"/></li>
    <li><label>&nbsp;</label><input name="" type="button" class="scbtn" id="search_btn" value="查询"/></li>
    </ul>
    	 
    </div>
    <table class="tablelist">
    	<thead>
    	<tr>
        <!-- <th style="text-align:center;"><input  type="checkbox" value="" id="checkboxGroupId"/></th> -->
        <th style="text-align:center;">用户名</th>
        <th style="text-align:center;">账号</th>
         <th style="text-align:center;">新闻数量</th> 
        <th style="text-align:center;">联系电话</th>
        <th style="text-align:center;">账户身份</th>
        <th style="text-align:center;">创建时间</th>
        <th style="text-align:center;">是否可用</th>
        
        </tr>
        </thead>
         <tbody id="dataListId">
        </tbody>
    </table>
    <div class="pagin" id="pagefoot">
    </div>
    </div>
</body>
<%@ include file="/rapast/common/jsp/commonJs.jsp"%>
<script type="text/javascript" src="<%=request.getContextPath() %>/rapast/repair/systemuser/js/systemuser_list_countlist.js"></script>
</html>