
/**
 * 登录
 * **/
function login(){
	var userId = "";
	var restaurantid = "";
	var postData = collectData("loginbox");
	$.ajax({
		url:path+"/loginManagerController/checkSysUserInfo.json",
		dataType:"json",
		data:postData,
		success:function(result){
			if(result.opflag){
				if(result.sysUserinfo){
					var userstatus = result.sysUserinfo.userstatus;
					if(userstatus=="1"){
						shopid = result.sysUserinfo.shopid;//店铺ID
						currentUserId = result.sysUserinfo.userid;
						orgid = result.sysUserinfo.orgid;//角色id
						window.location=path+"/loginManagerController/showManipage.do?currentUserId="+currentUserId+"&shopid="+shopid+"&orgid="+orgid;
					}else{
						layer.alert("该登陆账号已停用!",3);
					}
				}
			}else{
				layer.alert("用户名或密码错误！",3);
			}
		},
		error:function(error){
			layer.alert("error",3);
		}
	});
}