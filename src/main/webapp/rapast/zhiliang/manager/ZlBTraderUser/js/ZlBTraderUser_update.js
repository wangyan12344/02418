
$(function(){
	initPage();
});

/**
 * 初始化页面
 * */
function initPage(){
	$.ajax({
		url:getRequestUrl("/manager/ZlBTraderUserController/loadZlBTraderUser.json"),
		dataType:"json",
		data:{"zlBTraderUser.traderuserid":opid},
		success:function(data){
			var addHtml = $("#formTemplate").render(data.entity);
			$("#formbody").html(addHtml);
	        //登陆状态 下拉框数据绑定
			createSelectByCodeList('enable','YES_NO');
	        $("#enable").val(data.entity.enable);
	        createSelectByDB("permissions","sys_permissions_user","pname","id", "");
			$("#permissions").val(data.entity.permissions);
			bindevent();
		},
		error:function(error){
		}
	});
}

function bindevent(){
	bindValidateEvent("formbody");
	//下拉框样式
	$(".select1").uedSelect({
		width : 230			  
	});
	//返回
	$("#closeBtn").bind('click',function(){
		returnMainPage();
	});
	//日期
	$(".datepicker").datetimepicker({
		timepicker:false,
		format:'Y-m-d'
	});
	//保存
	$("#submitBtn").bind('click',function(){
		queryZlBTraderUserPageListForAccountAndMobile();
	});
	
}

function queryZlBTraderUserPageListForAccountAndMobile()
{
	var traderuserid =$("#traderuserid").val();
	var mobile =$("#mobile").val();
	var account =$("#account").val();
	$.ajax({
		url:getRequestUrl("/manager/ZlBTraderUserController/queryZlBTraderUserForList.json"),
		dataType:"json",
		data:{"zlBTraderUser.mobile":mobile,"zlBTraderUser.account":account,"zlBTraderUser.traderuserid":traderuserid},
		success:function(result){
			if(result.data!=""||result.data.length>0)
			{
				var judge;
				for(var a =0;a<result.data.length;a++){
					if(result.data[a].account==account){
						judge = 1;
					}else if(result.data[a].mobile==mobile)
					{
						judge = 2;
					}
				}
				if(judge=="1"){
					layer.alert("用户名已存在",2);
				}else if(judge=="2")
				{
					layer.alert("交易商电话已存在",2);
				}
				
			}else
			{
				saveUpdateZlBTraderUser();
			}
		},
		error:function(error){
			alert("error");
		}
	});
	
}

function saveUpdateZlBTraderUser()
{

	var checkfalg=	checkFormValue('formbody');
	if(checkfalg){
		$(this).unbind();
		var postData = collectData("formbody");

		$.ajax({
			url:getRequestUrl("/manager/ZlBTraderUserController/saveUpdateZlBTraderUser.json"),
			dataType:"json",
			data:postData,
			success:function(result){
				pageForward("/rapast/zhiliang/manager/ZlBTraderUser/ZlBTraderUser_list.jsp?pageIndexback="+pageIndex);
			},
			error:function(error){
				alert("error");
			}
		});
	}


}

function returnMainPage() {
	pageForward("/rapast/zhiliang/manager/ZlBTraderUser/ZlBTraderUser_list.jsp?pageIndexback="+pageIndex);
}
