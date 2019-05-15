var MenuTree = null;
$(function(){
	initPage();
});

/**
 * 初始化页面
 * */
function initPage(){
	$.ajax({
		url:getRequestUrl("/SysRoleInfoController/beforeAddEntity.json"),
		dataType:"json",
		data:[],
		success:function(data){
			var addHtml = $("#formTemplate").render(data);
			$("#formId").html(addHtml);
			var setting = {
				check: {
					enable: true
				},
				data: {
					simpleData: {
						enable: true
					}
				}
			};
			var zNodes = data.zNodes;
			MenuTree = $.fn.zTree.init($("#treeDemo"), setting, zNodes);
			bindevent();
		},
		error:function(error){
			alert("error");
		}
	});
}

function bindevent(){
	bindValidateEvent("formId");

	$("#closeBtn").bind('click',function(){
		pageForward('/SysRoleInfoController/defaultJsp.do');
	});
	
	$("#submitBtn").bind('click',function(){
		var checkfalg=	checkFormValue('formId');
		if(checkfalg){
			$(this).unbind();
			var formData = collectData("formId");
			var menuData = getAllCheckedMenucode();
			var postData = $.extend({},formData,menuData);
			$.ajax({
				url:getRequestUrl("/SysRoleInfoController/addEntityData.json"),
				dataType:"json",
				data:postData,
				success:function(result){
					pageForward('/SysRoleInfoController/defaultJsp.do');
				},
				error:function(error){
					alert("error");
				}
			});
		}
	});
	
}

/**
 * 
 * @returns {___anonymous1471_1472}
 */
function getAllCheckedMenucode(){
	var allCheckedNodes = MenuTree.getCheckedNodes(true);
	var checkedMenucode = {};
	for(var i = 0; i < allCheckedNodes.length; i++){
		checkedMenucode["roleMenuList["+i+"].menucode"] = allCheckedNodes[i].id;
	}
	return checkedMenucode;
}

