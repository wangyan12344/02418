<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<meta http-equiv="x-ua-compatible" content="IE=8,9,10" >
<title>账户列表</title>
<%@ include file="/rapast/common/jsp/commonCss.jsp"%>
</head>
<script type="text/x-jsrender" id="dataListTemplate">
        <tr>
       <!-- <td><input name="checkboxGroupId" type="checkbox" value="{{:userid}}" /></td>-->
        <td>{{:username}}</td>
        <td>{{:account}}</td>
        <!-- <td>{{:orgid}}</td> -->
        <td>{{:contacttelnumber}}</td>
       <td>{{transcode:usertype kind='USER_TYPE'}}</td>
        <td>{{:entrytime}}</td>
        <td>{{:userstatus}}</td>
        <td><a href="javascript:stopEntityDataFun('{{:userid}}');" class="tablelink">停用</a>&nbsp;&nbsp;<a href="javascript:updateEntityDataFun('{{:userid}}');" class="tablelink">修改</a>&nbsp;&nbsp;<a href="javascript:deleteDataFun('{{:userid}}');" class="tablelink"> 删除</a></td>
        </tr>
</script>
<script type="text/javascript">
	var pageIndexback = '<%=request.getParameter("pageIndexback") %>';
</script>
<body>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="javascript:;">系统用户管理</a></li>
    <li><a href="javascript:;">用户信息</a></li>
    </ul>
    </div>
    <div class="rightinfo">
    <div class="tools">
    <ul class="seachform" style="display:inline !important;" id="search_area">
    <li><label>搜索内容</label><input name="sysUserInfo.username" type="text" class="dfinput" placeholder="用户名  / 账号" dc="true"/></li>
    <li><label>&nbsp;</label><input name="" type="button" class="scbtn" id="search_btn" value="查询"/></li>
    </ul>
    	<ul class="toolbar1">
        <li><a href="javascript:addEntityDataFun();" target="rightFrame" ><span><img src="<%=request.getContextPath() %>/rapast/common/images/t01.png" /></span>新增用户</a></li>
        </ul>
    </div>
    <table class="tablelist">
    	<thead>
    	<tr>
        <!-- <th style="text-align:center;"><input  type="checkbox" value="" id="checkboxGroupId"/></th> -->
        <th style="text-align:center;">用户名</th>
        <th style="text-align:center;">账号</th>
        <!-- <th>所属机构</th> -->
        <th style="text-align:center;">联系电话</th>
        <th style="text-align:center;">账户身份</th>
        <th style="text-align:center;">创建时间</th>
        <th style="text-align:center;">是否可用</th>
        <th style="text-align:center;">操作</th>
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
<script type="text/javascript" src="<%=request.getContextPath() %>/rapast/repair/systemuser/js/systemuser_list.js"></script>
</html>