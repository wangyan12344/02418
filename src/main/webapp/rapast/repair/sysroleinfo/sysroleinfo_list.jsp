<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="IE=8,9,10" >
<title>角色管理</title>
<%@ include file="/rapast/common/jsp/commonCss.jsp"%>
</head>
<script type="text/x-jsrender" id="dataListTemplate">
        <tr>
        <td>{{:rolename}}</td>
        <td>{{if roleid=="adminroleid"}}超级管理员不能操作{{else}}<a href="javascript:updateEntityDataFun('{{:roleid}}');" class="tablelink">修改</a>&nbsp;&nbsp;<a href="javascript:deleteDataFun('{{:roleid}}');" class="tablelink"> 删除</a>{{/if}}</td>
        </tr>
</script>
<body>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="javascript:;">系统用户管理</a></li>
    <li><a href="javascript:;">角色信息</a></li>
    </ul>
    </div>
    <div class="rightinfo">
    <div class="tools">
    <ul class="seachform" style="display:inline !important;" id="search_area">
    <li><label>搜索内容</label><input name="sysRoleInfo.rolename" type="text" class="dfinput" placeholder="角色名称" dc="true"/></li>
    <li><label>&nbsp;</label><input name="" type="button" class="scbtn" id="search_btn" value="查询"/></li>
    </ul>
    	<ul class="toolbar1">
        <li><a href="javascript:addEntityDataFun();" target="rightFrame" ><span><img src="<%=request.getContextPath() %>/rapast/common/images/t01.png" /></span>新增角色</a></li>
        </ul>
    </div>
    <table class="tablelist">
    	<thead>
    	<tr>
        <th>角色名称</th>
        <th>操作</th>
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
<script type="text/javascript" src="<%=request.getContextPath() %>/rapast/repair/sysroleinfo/js/sysroleinfo_list.js"></script>
</html>