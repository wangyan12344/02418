var AddUserObj = {};
AddUserObj.shopsize = 0;
$(function(){
	initPage();
});

/**
 * 初始化页面
 * */
function initPage(){
	$.ajax({
		url:getRequestUrl("/SysUserInfoController/beforeUpdateEntity.json"),
		dataType:"json",
		data:{"sysUserInfo.userid":userid},
		success:function(data){
			var addHtml = $("#formTemplate").render(data);
			$("#formId").html(addHtml);
//			showclassmenu();
//			var setting = {
//					check: {
//						enable: true
//					},
//					data: {
//						simpleData: {
//							enable: true
//						}
//					}
//				};
//			var zNodes = data.zNodes;
//			MenuTree = $.fn.zTree.init($("#treeDemo"), setting, zNodes);
			bindevent();
		},
		error:function(error){
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
		width : 235			  
	});
	$(".select2").uedSelect({
		width : 230			  
	});
	$("#closeBtn").bind('click',function(){
		pageForward('/rapast/repair/systemuser/systemuser_list_user.jsp?pageIndexback='+pageIndex);
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
//			var menuData = getAllCheckedMenucode();
			var postData = $.extend({},userData,userShopData);
			$.ajax({
				url:getRequestUrl("/SysUserInfoController/updateEntityDataPassword.json"),
				dataType:"json",
				data:postData,
				success:function(result){
					pageForward('/rapast/repair/systemuser/systemuser_list_user.jsp?pageIndexback='+pageIndex);
				},
				error:function(error){
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

