var AddUserObj = {};
var MenuTree = null;
AddUserObj.shopsize = 0;
$(function(){
	initPage();
	
});

/**
 * 初始化页面
 * */
function initPage(){
	$.ajax({
		url:getRequestUrl("/SysUserInfoController/beforeAddEntity.json"),
		dataType:"json",
		data:[],
		success:function(data){
			var addHtml = $("#formTemplate").render(data);
			$("#formId").html(addHtml);
			iloadTree();
			
		},
		error:function(error){
			alert("error");
		}
	});
}
function showclassmenu(){
	var usertype=$('#usertype option:selected') .val();
	if(usertype!='1'){
		$("#classmenu").show();
	}else{
		$("#classmenu").hide();
	}
}
/**
 * 初始化菜单
 * */
function iloadTree(){
	$.ajax({
		url:getRequestUrl("/SysRoleInfoController/getNewsClassTree.json"),
		dataType:"json",
		data:[],
		success:function(data){
//			var addHtml = $("#formTemplate").render(data);
//			$("#formId").html(addHtml);
			
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

	$(".select1").uedSelect({
		width : 237			  
	});
	$(".select2").uedSelect({
		width : 230			  
	});
	$("#closeBtn").bind('click',function(){
		pageForward('/SysUserInfoController/defaultJsp.do');
	});
	
	$(".datepicker").datetimepicker({
		timepicker:false,
		format:'Y-m-d'
	});
	
	$("#submitBtn").bind('click',function(){
		var checkfalg=	checkFormValue('formId');
		if(checkfalg){
			$(this).unbind();
			var userData = collectData("formId");
			var userShopData = collectData("userMshopAddId");
			var menuData = getAllCheckedMenucode();
			debugger;
			var postData = $.extend({},userData,userShopData,menuData);
			$.ajax({
				url:getRequestUrl("/SysUserInfoController/addEntityData.json"),
				dataType:"json",
				data:postData,
				success:function(result){
					pageForward('/SysUserInfoController/defaultJsp.do');
				},
				error:function(error){
					alert("error");
				}
			});
		}
	});
	
	$(".deleteshop").die().live('click',function(){
		$(this).parent().parent().remove();
		$('.tablelist tbody tr:odd').addClass('odd');
		$('.tablelist tbody tr:even').removeClass('odd');
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
		checkedMenucode["roleMenuList["+i+"].categoryid"] = allCheckedNodes[i].id;
	}
	return checkedMenucode;
}



