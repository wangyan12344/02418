<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<script src="<%=request.getContextPath()%>/rapast/common/js/jquery-1.8.3.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/rapast/common/js/jsrender.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/rapast/common/js/jquery.autocomplete.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/rapast/common/js/main.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/rapast/common/js/layer.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/rapast/common/js/tishi.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/rapast/common/js/jquery.datetimepicker.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/rapast/common/js/jquery.showLoading.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/rapast/common/js/ajaxmutfileupload.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/rapast/common/js/select-ui.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/rapast/common/js/editor/kindeditor.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/rapast/common/js/ztree/jquery.ztree.core-3.5.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/rapast/common/js/ztree/jquery.ztree.excheck-3.5.js" type="text/javascript"></script>
<script type="text/javascript">
	
	var path = '<%=request.getContextPath()%>';
	var serverPathURL = '<%=request.getSession().getAttribute("WEBSITE")%>';
	var codeListObj = {};
	window.UEDITOR_HOME_URL='<%=request.getContextPath()%>'+"/rapast/common/js/ueditor/";
	//appendLoadDiv();
	 $(window).ready(function() {
		 appendLoadDiv();
		 //清除上一个页面留下的tip信息
		 $(".xubox_layer").remove();
			
        });
</script>
<script src="<%=request.getContextPath()%>/rapast/common/js/commonJsRender.js" type="text/javascript"></script>

