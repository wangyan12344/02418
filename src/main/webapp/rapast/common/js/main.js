//window.onerror=function(){return true;}


String.prototype.trim=function()
{
     return this.replace(/(^\s*)|(\s*$)/g, "");
}


$(document).ready(function(){
	// 满屏高度
	var winheight = $(window).outerHeight();
	var contentheight = $(".content").outerHeight();
	var bktab = $(".bktab").outerHeight();
	var tbsearchbox = $(".tbsearchbox").outerHeight();
	var booktop = $(".booktop").outerHeight();
	var bkfood = $(".bkfood").outerWidth();
	var bktmenu = $(".bktmenu").outerHeight();
	var bookmain = winheight - booktop - 2;
	var bkrmenu = winheight - booktop - bktmenu;
	//$(".leftmenu ul").css({height:winheight});
	$(".loginbg").css({
		height : winheight
	});
	$(".left").css({
		height : winheight
	});
	$(".center").css({
		height : winheight
	});
	$(".dishesclass").css({
		height : winheight
	});
	$(".bookmain").css({
		height : bookmain - 28
	});
	$(".bookright").css({
		height : bookmain
	});
	$(".bookcon").css({
		height : bookmain
	});
	$(".bkfood").css({
		height : bookmain - 25
	});
	$(".bktotal").css({
		width : bkfood - 15
	});
	$(".bkrmenu").css({
		height : bkrmenu - 92
	});
	$(".bkfmenu").css({
		height : bkrmenu - 8
	})
	$(".opentable").css({
		height : bookmain - bktab - tbsearchbox
	});
	// 表格背景
	$(".tableone table tr:even td").css("background", "#f9f9f9");
	$(".showbox table tr td").css("background", "#f2f2f2");
	$(".plhfbox table tr td").css("background", "#f2f2f2");
	$(".fooddetail table tr td").css("background", "#f2f2f2");

	// 表头排序
	$(".arrnone").toggle(function() {
		$(this).addClass("arrdown").removeClass("arrnone");
	}, function() {
		$(this).addClass("arrup").removeClass("arrdown");
	});

	// input背景
	$("input").focus(function() {
		$(this).css("background-color", "#ffffdf");
	});
	$("input").blur(function() {
		$(this).css("background-color", "#fff");
	});

	// 勾选后文本框可编辑
	$(".yzckbox").click(function() {
		if (this.checked) {
			$(".yzbox").attr("disabled", false);
		} else {
			$(".yzbox").attr("disabled", true);
		}
	});
	// tab
	$(".tab_box:gt(0)").hide();
});





/**
 * 本地服务调用方法 URL处理方法，自动拼接应用名
 */
var getRequestUrl = function(url) {
	if (url.substr(0, 1) != '/')
		url = "/" + url;

	if (url.indexOf("?") == -1) {
		url += "?_call_rnd=" + new Date();
	} else {
		url += "&_call_rnd=" + new Date();
	}

	return path + url+makeProcessor();
}

/**
 * 构造processor对象的提交数据
 * 注意：分页相关的参数直接在pageBarFortable中进行了构造，其它参数在此方法中完成
 */
function makeProcessor(){
	
	var commonData = parent.CsGlobalObj||parent.parent.CsGlobalObj;
	var orgid = commonData.sys_hidden_orgid||"";
	var currentUserId = commonData.currentUserid||"";
	var ipaddress = commonData.sys_hidden_ipaddress||"";
	var deviceType = commonData.sys_hidden_deviceType||"";
	
	return "&processor.orgid="+orgid+"&processor.currentUserId="+currentUserId+"&processor.ipaddress="+ipaddress+"&processor.deviceType="+deviceType;
}



/**
 * 分页方法封装
 * */
function pageBarFortable(parameterData,doFlag){
	var dataJson = '';
	var url=parameterData["url"];
	var customArray = parameterData["customArray"];
	var pageIndex=parameterData["pageIndex"];
	var successfunc = parameterData["successfunc"];
	var page=parameterData["pageller"]||"pageller";
	var checkedId = parameterData["checkedId"];
	var pageSize = parameterData["pageSize"]||10;
	var maxpagesize=0;
	var processor = {};
	if(doFlag==1){//前进
		pageIndex =$("#"+page+"pageindex").val();
		maxpagesize =$("#"+page+"maxpagesize").val();
		if(parseInt(pageIndex)<parseInt(maxpagesize)){
			pageIndex++;
		}else{
			return ;
		}
	}else if(doFlag==2){//后退
		pageIndex=$("#"+page+"pageindex").val();
		if(parseInt(pageIndex)>1){
			pageIndex--;
		}
	}else if(doFlag==5){//GO
		maxpagesize = $("#"+page+"maxpagesize").val();
		if(parseInt(pageIndex)>parseInt(maxpagesize)){
			return;
		}
	}
	//合并用户自定义json
	if(customArray!=null && customArray != undefined){
		//加入自定义json
		dataJson = customArray;
	}
	
	//全选按钮设置
	$("#"+checkedId).attr("checked",false);
	$("#"+checkedId).bind("click",function(){
		if($("#"+checkedId).attr("checked")){
			$("input[name='"+checkedId+"']").attr("checked",true);
		}else{
			$("input[name='"+checkedId+"']").attr("checked",false);
		}
	});
	processor["processor.pageSize"] = pageSize;
	processor["processor.pageIndex"] =pageIndex;
	//构建数据模型
	dataJson = $.extend({}, processor,dataJson);
	//showLoading();
	$.ajax({
		url:url,
		dataType:'json',
		data:dataJson,
		success:function(result){
			var pagebar = result.data.pageBar;
			var barlen = pagebar.length;
			var _totalCount = result.data.totalCount;
			var _maxsize = result.data.pageMaxSize;
			var _pageindex = result.data.pageIndex;
			var renderPageHtml = '<div class="message">共<i class="blue">'+_totalCount+'</i>条记录，当前显示第&nbsp;<i class="blue">'+_pageindex+'&nbsp;</i>页</div>'+
								'<ul class="paginList">'+
								'<li class="paginItem"><a href="javascript:;" id="'+page+'pageBarFortable2"><span class="pagepre"></span></a></li>';
			for(var ib = 0; ib < barlen; ib++){
				var current = "";
				if(_pageindex == pagebar[ib]){
					current = " current";
				}
				renderPageHtml = renderPageHtml + '<li class="paginItem'+current+' '+page+'jumpin"><input type="hidden" name="pindex" value="'+pagebar[ib]+'" /><a href="javascript:;">'+pagebar[ib]+'</a></li>';
			}
			renderPageHtml = renderPageHtml + '<li class="paginItem"><a href="javascript:;" id="'+page+'pageBarFortable1"><span class="pagenxt"></span></a></li>'+
											'</ul>'+
											'<input type="hidden" id="'+page+'maxpagesize" value="'+result.data.pageMaxSize+'"/><input type="hidden" id="'+page+'pageindex" value="'+result.data.pageIndex+'"/>';
			$("#"+page).html(renderPageHtml);
			pageBindClick(page,parameterData);//绑定分页方法
			successfunc(result.data.records,result);
		//	hideLoading();
		},
		error:function(error){
		//	 hideLoading();
			layer.alert("error",3);
		}
	});	
}

//分页功能绑定click事件
function pageBindClick(page,parameterData){
	
	$("#"+page+"pageBarFortable1").unbind().bind("click",function(){
		pageBarFortable(parameterData,1);
	});
	$("#"+page+"pageBarFortable2").unbind().bind("click",function(){
		pageBarFortable(parameterData,2);
	});
	$("."+page+"jumpin").unbind().bind("click",function(){
		var pageIndex = $(this).find('input[name="pindex"]').val();
		parameterData["pageIndex"] = pageIndex;
		pageBarFortable(parameterData,5);
	});	
}
/**
 * 数据收集
 * containerId 指定html容器下的数据
 * */
function collectData(containerId) {
	if(containerId==null||""==containerId)
		container = "*";
	var sel = "dc";
	var objs = $("#"+containerId+" [" + sel + "]");
	var postData = {};
	
	for (var i = 0, len = objs.length; i < len; i++) {
		
		var obj = objs[i];
		var nodeName = obj.nodeName.toLowerCase();
		var field = $(obj).attr("name");

		if (nodeName == "input") {
			if (obj.type.trim() == "radio"
					&& (obj.checked || obj.checked == "checked")) {

				postData[field] = $(obj).val();
				continue;
			}
			if (obj.type.trim() == "checkbox"
					&& (obj.checked || obj.checked == "checked")) {
				var ov = postData[field] || "";
				var nv = ov + "," + $(obj).val();
				postData[field] = nv.replace(/^,+/, "");
				continue;
			}

			if (obj.type.trim() == "text" || obj.type.trim() == "hidden" || obj.type.trim() == "password") {
				postData[field] = $(obj).val();
				continue;
			}
			continue;
		}

		if (nodeName == "textarea") {
			postData[field] = $(obj).val();
			continue;
		}
		if (nodeName == "select") {
			var val = $(obj).val(); //obj.options[obj.selectedIndex].value;
			postData[field] = val;
			continue;
		}
		if (nodeName == "img") {
			postData[field] = $(obj).attr("value");
			continue;
		}
		/**
		 * update by lingy 新增富文本编辑框 start
		 * 通过取得初始化时editor的ID，取得富文本中的值
		 */
		var ueditorid = $(obj).attr("ueditorid");
		if(isNotEmpty(ueditorid)){
			var editorContent = UE.getEditor(ueditorid).getContent();
			postData[field] = editorContent;
			continue;
		}
		/************update by lingy 新增富文本编辑框 end *********************/
		postData[field] = $(obj).html();

	}
	//返回从表单获取数据的json数据 
	
	return postData;
} 


/**
 * 连接多个收集对象的数值，方便进行统一提交
 * @param targetObj
 * @param obj
 * @returns
 */
function concatObj(targetObj,obj) {
    // 用来保存所有的属性名称和值
    var props = "";
    // 开始遍历
    for(var p in obj){
      // 方法
      if(typeof(obj[p])=="function"){
      	obj[p]();
      }else{
      // p 为属性名称，obj[p]为对应属性的值
      //	props+= p + "=" + obj[p] + "\t";
      	targetObj[p] = obj[p];
      }
     }

    return targetObj;
}

/**
 * luandong
 * @param containerId 根据容器id绑定校验事件
 * @returns {___anonymous8746_8747}
 */
function bindValidateEvent(containerId) {
	if(containerId==null||""==containerId)
		container = "*";
	
	//处理必填
	var sel = "dcrequired";
	var objs = $("#"+containerId+" [" + sel + "]");
	for (var i = 0, len = objs.length; i < len; i++) {
		var obj = objs[i];
		//1 设置显示必填红星 
		$(obj).after("<span style='color:red;display:inline;'>*</span>");
		//2 绑定bulr的事件，处理显示
		$(obj).bind("blur", function(){
			if($(this).val()==""){
				var requiredMsg = $(this).attr("dcrequired")==""?"此项目不能为空!":$(this).attr("dcrequired");
				$(this).attr("dccheck","false");
				$(this).css("background-color","#ffffdf");
				
			    layer.tips("&nbsp;&nbsp;"+requiredMsg, this, {
			        guide: 2,shadeClose: true,
			        time: 5,
			        style: ['background-color:#F26C4F; color:#fff', '#F26C4F'],
			        maxWidth:150
			    });
			}else{
				$(this).attr("dccheck","true");
				$(this).css("background-color","#ffffff");
			}
		}).bind("focus", function(){
			if($(this).val()==""){
				var requiredMsg = $(this).attr("dcrequired")==""?"此项目不能为空!":$(this).attr("dcrequired");
				 layer.tips("&nbsp;&nbsp;"+requiredMsg, this, {
				        guide: 2,shadeClose: true,
				        time: 5,
				        style: ['background-color:#F26C4F; color:#fff', '#F26C4F'],
				        maxWidth:150
				    });
			}
		});
	}
	//绑定控件类型

	sel = "dctype";
	objs = $("#"+containerId+" [" + sel + "]");
	for (var i = 0, len = objs.length; i < len; i++) {
		var obj = objs[i];
		switch($(obj).attr(sel)){
			case "数字":
				$(obj).keypress(function(event) {
					var keyCode = event.which;
					if (keyCode == 46 || (keyCode >= 48 && keyCode <=57) || keyCode == 8)
					return true;
					else
					return false;
					}).focus(function() {
					this.style.imeMode='disabled';
					});
		      break;
			case "金额":
				$(obj).keyup(function(event) {
					var regex = /^\d+\.?\d{0,2}$/;
		            if (!regex.test(this.value))
		            {
		            	layer.tips("&nbsp;&nbsp;请录入合法的金额", this, {
					        guide: 2,shadeClose: true,
					        time: 3,
					        style: ['background-color:#F26C4F; color:#fff', '#F26C4F'],
					        maxWidth:150
					    });
		                this.value = "";
		                this.focus();
		            }
		            
					}).focus(function() {
					this.style.imeMode='disabled';
					});
		      break;
			case "字母":
			    $(obj).keypress(function (event) {
			        var eventObj = event || e;
			        var keyCode = eventObj.keyCode || eventObj.which;
			        if ((keyCode >= 65 && keyCode <= 90) || (keyCode >= 97 && keyCode <= 122) || keyCode == 8 )
			            return true;
			        else{
			        	layer.tips("&nbsp;&nbsp;只能录入字母", this, {
					        guide: 2,shadeClose: true,
					        time: 3,
					        style: ['background-color:#F26C4F; color:#fff', '#F26C4F'],
					        maxWidth:150
					    });
			            return false;
			        }
			    }).focus(function () {
			        this.style.imeMode = 'disabled';
			    }).bind("paste", function () {
			        var clipboard = window.clipboardData.getData("Text");
			        if (/^[a-zA-Z]+$/.test(clipboard))
			            return true;
			        else
			            return false;
			    });
				break;
			case "数字或字母":
				 $(obj).keypress(function (event) {
				        var eventObj = event || e;
				        var keyCode = eventObj.keyCode || eventObj.which;
				        if ((keyCode >= 48 && keyCode <= 57) || (keyCode >= 65 && keyCode <= 90) || (keyCode >= 97 && keyCode <= 122) || keyCode == 8)
				            return true;
				        else{
				        	layer.tips("&nbsp;&nbsp;只能录入数字或字母", this, {
						        guide: 2,shadeClose: true,
						        time: 3,
						        style: ['background-color:#F26C4F; color:#fff', '#F26C4F'],
						        maxWidth:150
						    });
				            return false;
				        }
				    }).focus(function () {
				        this.style.imeMode = 'disabled';
				    }).bind("paste", function () {
				        var clipboard = window.clipboardData.getData("Text");
				        if (/^(\d|[a-zA-Z])+$/.test(clipboard))
				            return true;
				        else
				            return false;
				    });
				break;
			case "身份证":
				$(obj).bind("blur", function(){
				  if($(this).val()!=""){
						if(!checkIdCard($(this).val())){
							var requiredMsg ="身份证号不合法";
							$(this).attr("dccheck","false");
							$(this).css("background-color","#ffffdf");
							
						    layer.tips("&nbsp;&nbsp;"+requiredMsg, this, {
						        guide: 2,shadeClose: true,
						        time: 5,
						        style: ['background-color:#F26C4F; color:#fff', '#F26C4F'],
						        maxWidth:150
						    });
						}else{
							  $(this).attr("dccheck","true");
								$(this).css("background-color","#ffffff");
						}
				  }else{
					  $(this).attr("dccheck","true");
						$(this).css("background-color","#ffffff");
				  }
				});
				break;
			case "手机号":
				$(obj).bind("blur", function(){
				  if($(this).val()!=""){
						if(!checkMobile($(this).val())){
							var requiredMsg ="手机号不合法";
							$(this).attr("dccheck","false");
							$(this).css("background-color","#ffffdf");
							
						    layer.tips("&nbsp;&nbsp;"+requiredMsg, this, {
						        guide: 2,shadeClose: true,
						        time: 5,
						        style: ['background-color:#F26C4F; color:#fff', '#F26C4F'],
						        maxWidth:150
						    });
						}else{
							$(this).attr("dccheck","true");
							$(this).css("background-color","#ffffff");
						}
				  }else{
					  $(this).attr("dccheck","true");
						$(this).css("background-color","#ffffff");
				  }
				});
				break;	
			case "邮箱":
				$(obj).bind("blur", function(){
				  if($(this).val()!=""){
						if(!checkEmail($(this).val())){
							var requiredMsg ="邮箱不合法";
							$(this).attr("dccheck","false");
							$(this).css("background-color","#ffffdf");
							
						    layer.tips("&nbsp;&nbsp;"+requiredMsg, this, {
						        guide: 2,shadeClose: true,
						        time: 5,
						        style: ['background-color:#F26C4F; color:#fff', '#F26C4F'],
						        maxWidth:150
						    });
						}else{
							$(this).attr("dccheck","true");
							$(this).css("background-color","#ffffff");
						}
				  }else{
					  $(this).attr("dccheck","true");
						$(this).css("background-color","#ffffff");
				  }
				});
				break;	
			/**
			 * lingy update
			 * 新增ajax异步校验
			 */	
			case "ajax校验":
				$(obj).bind("blur", function(){
					if($(this).val()!=""){
						var dcajax = $(this).attr("dcajax");
						if(isNotEmpty(dcajax)){
							var ajaxParam = eval("("+dcajax+")");
							ajaxParam.checkval = $(this).val();
							var checkresult = checkAjax(ajaxParam);
							if(!checkresult.flag){
								var requiredMsg = checkresult.msg;
								$(this).attr("dccheck","false");
								$(this).css("background-color","#ffffdf");
								
							    layer.tips("&nbsp;&nbsp;"+requiredMsg, this, {
							        guide: 2,shadeClose: true,
							        time: 5,
							        style: ['background-color:#F26C4F; color:#fff', '#F26C4F'],
							        maxWidth:150
							    });
							}else{
								$(this).attr("dccheck","true");
								$(this).css("background-color","#ffffff");
							}
						}else{
							$(this).attr("dccheck","true");
							$(this).css("background-color","#ffffff");
						}
					}else{
						$(this).attr("dccheck","true");
						$(this).css("background-color","#ffffff");
					}
				});
				break;
		
		}
	}
	
} 


function checkMobile(vtext){
	//var isMobile=/^(?:13\d|15\d|18\d)\d{5}(\d{3}|\*{3})$/; //手机号码验证规则
	var isMobile=/^(?:13\d|15\d|18\d|14\d|17\d|19\d)\d{5}(\d{3}|\*{3})$/; //手机号码验证规则		
	if(!isMobile.test(vtext)){ 
	    return false;
	}else{
		return true;
	}
}

function checkEmail(vtext){
	
	
	var re = /^([a-zA-Z0-9]+[_|_|.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|_|.]?)*[a-zA-Z0-9]+.[a-zA-Z]{2,3}$/ig;
    if(!re.test(vtext)){
        return false;
    }
    return true;
}

function checkIdCard(idcard){
	var reg=/^[1-9]{1}[0-9]{14}$|^[1-9]{1}[0-9]{16}([0-9]|[xX])$/;
	if(reg.test(idcard)){
	    return true;
	}
	else{
	    return false;
	}
}

/**
 * add by lingy
 * ajax校验
 * @param ajaxParam
 * 
 * @param checkattr 后台接受参数
 * @param url 请求路径
 */
function checkAjax(ajaxParam){
	//获取ajax参数
	var url = ajaxParam["url"]||"";
	var checkval = ajaxParam["checkval"]||"";
	var checkattr = ajaxParam["checkattr"]||"";
	//返回结果数据
	var result = {};
	result.flag = false;
	//创建传入后台得参数
	var postDataStr = "{'" + checkattr + "':'" + checkval +"'}";
	var postData = eval("("+postDataStr+")");
	for(var property in ajaxParam){
		if(property=="url"||property=="checkattr"||property=="checkval"){
			continue;
		}
		if(property=="otherNameParam"){
			var otherParam = ajaxParam[property];
			var otherParamVal = $("[name='"+otherParam+"']").val();
			postData[otherParam] = otherParamVal;
			continue;
		}
		postData[property] = ajaxParam[property];
	}
	$.ajax({
		url:getRequestUrl(url),
		dataType:"json",
		data:postData,
		async:false,
		success:function(data){
			if(data.opflag==true){
				result.flag = true;
			}else{
				result.msg = data.opmessage||"数据不合法";
			}
		},
		error:function(error){
			alert("error");
		}
	});
	return result;
}

function ValidateNumber(e, pnumber){
	if (!/^\d+$/.test(pnumber)){

	$(e).val(/^\d+/.exec($(e).val()));

	}

	return false;

}

function checkFormValue(containerId){
	var falg = true;
	if(containerId==null||""==containerId)
		container = "*";
	//1 检查必填项目
	var sel = "dcrequired";
	var objs = $("#"+containerId+" [" + sel + "]");
	var postData = {};
	for (var i = 0, len = objs.length; i < len; i++) {
		var obj = objs[i];
		if($(obj).val()==""){
			
			var requiredMsg = $(obj).attr(sel)==""?"此项目不能为空!":$(obj).attr(sel);
			if(falg)
				$(obj).focus();
			falg = false;
		    layer.tips("&nbsp;&nbsp;"+requiredMsg, obj, {
		        guide: 2,shadeClose: true,follow:"#"+obj.id,
		        time: 5,
		        style: ['background-color:#F26C4F; color:#fff', '#F26C4F'],
		        maxWidth:150
		    });
		    return falg;
		}
	}
	//2 直接读取dccheck属性
	sel = "dccheck";
	objs = $("#"+containerId+" [" + sel + "]");
	for (var i = 0, len = objs.length; i < len; i++) {
		var obj = objs[i];
		if($(obj).attr("dccheck")=='false'){
			falg = false;
			$(obj).focus();
			break;
		}
	}
	
	
	return falg;
}

/** 毫秒转日期 */
function formatDate(ms){
	var now = new Date(ms);
    var year=now.getFullYear();
    var month=now.getMonth()+1;     
    var date=now.getDate();
    if(month<10)month="0"+month;
    if(date<10)date="0"+date;
    return year+"/"+month+"/"+date;     
}

/**
 * 加载店内职位下拉框
 */
function queryUserRole(selectId){
	
	$.ajax({
		url:getRequestUrl("/sysRoleController/queryUserRole.json"),
		dataType:"json",
		async:false,
		success:function(result){
			if(result.roleList){
				$("#"+selectId).html("<option value=''>请选择</option>");
				for(var i=0;i<result.roleList.length;i++){
					$("#"+selectId).append("<option value='"+result.roleList[i].id+"'>"+result.roleList[i].rolename+"</option>");
				}
			}
		},
		error:function(error){
			layer.alert("error",3);
		}
	});
}

/**
 * 加载店内职位复选框
 * rolechecked为上级元素id
 * checkedname为复选框name
 * disable设置复选框是否可选
 */
function queryUserRoleChecked(rolecheckedid,checkedname,disable){
	
	$.ajax({
		url:getRequestUrl("/sysResourceController/querySysResource.json"),
		dataType:"json",
		data:{type:"0"},
		async:false,
		success:function(result){
			if(result.sysResourceList){
				var j=0;
				var k=0;
				for(var i=0;i<result.sysResourceList.length;i++){
					if(result.sysResourceList[i].type=="1"){
						j++;
						if(j%6==0){
							$("#"+rolecheckedid+"Phone").append("<br><label><input type='checkbox' name='"+checkedname+"' value='"+result.sysResourceList[i].id+"' dc='true'/> "+result.sysResourceList[i].resourcename+"</label>");
						}else{
							$("#"+rolecheckedid+"Phone").append("<label><input type='checkbox' name='"+checkedname+"' value='"+result.sysResourceList[i].id+"' dc='true'/> "+result.sysResourceList[i].resourcename+"</label>");
						}
					}else{
						k++;
						if(k%6==0){
							$("#"+rolecheckedid).append("<br><label><input type='checkbox' name='"+checkedname+"' value='"+result.sysResourceList[i].id+"' dc='true'/> "+result.sysResourceList[i].resourcename+"</label>");
						}else{
							$("#"+rolecheckedid).append("<label><input type='checkbox' name='"+checkedname+"' value='"+result.sysResourceList[i].id+"' dc='true'/> "+result.sysResourceList[i].resourcename+"</label>");
						}
					}
				}
				if(disable!=false&&disable!=undefined){
					$("input[name='"+checkedname+"']").attr('disabled',true);
				}
			}
		},
		error:function(error){
			layer.alert("error",3);
		}
	});
}

/**
 * 让复选框打勾
 * data中为需要打勾的复选框值域
 */
function makeCheckEd(name,data){
	if(data)
		for(var i=0;i<data.length;i++){
		  $("input[name='"+name+"'][value='"+data[i].id+"']").prop("checked", true);
		}
}

/**
 * 复选框全选\取值处理
 * 当flag为false时只进行取值－
 * 要求全选复选框id值与列表复选name属性值相同
 */
function checkControl(checkedId,flag){
	var s=''; 
	if(flag){
		$("#"+checkedId).click(function(){
			if($("#"+checkedId).attr("checked")){
				$("input[name='"+checkedId+"']").attr("checked",true);
			}else{
				$("input[name='"+checkedId+"']").attr("checked",false);
			}
		});
	}else{
		$('input[name="'+checkedId+'"]:checked').each(function(){ 
			   s+=$(this).val()+','; 
		});
		//得到选中的checkbox值序列 
		if (s.length > 0)
			s = s.substring(0,s.length - 1);
	}
	return s;
}

var loadi;
/**
 * 增加loading处理，此方法有问题，同layer插件有些冲突，暂时不使用
 */
function appendLoadDiv()
{
	//layer.close(_loadi_layer);
	$(document).ajaxStart(function () {
		showLoading();
		//loadi = layer.load('加载中…'); 
	}).ajaxStop(function () {
		hideLoading();
		//layer.close(loadi);
	}); 
	
}

function showLoading(){
	if($("#mainbody").length>0){
	
		jQuery('#mainbody').showLoading();
	}
}

function hideLoading(){
	if($("#mainbody").length>0){
		jQuery('#mainbody').hideLoading();
	}
}


/**
 * 根据codelist生成下拉列表
 */
function createSelectByCodeList(objID,kind){
	$.ajax({
		url:getRequestUrl("/transcodeController/selectTable.json"),
		dataType:"json",
		data:{kind:kind},
		async:false,
		success:function(result){
			if(result.opflag){
				$("#"+objID).empty();
				var opObject = new Option("请选择", "");
				$("#"+objID)[0].options.add(opObject);
				var respData = result.data.options;
				if(respData!=null){
					var olenk = respData.length;
					for (var x = 0; x < olenk; x++) {
						var opObject = new Option(respData[x]['text'], respData[x]['value']);
						$("#"+objID)[0].options.add(opObject);
					}
				}
			}
		},
		error:function(error){
			layer.alert("error",3);
		}
	});
}

/**
 * 根据后台的controllerURL生成下拉列表
 */
function createSelectByQuery(controllerURL,objID,textcol,valuecol){
	$.ajax({
		url:getRequestUrl(controllerURL),
		dataType:"json",
		data:{type:"0"},
		async:false,
		success:function(result){
			if(result.opflag){
				$("#"+objID).empty();
				var opObject = new Option("请选择", "");
				$("#"+objID)[0].options.add(opObject);
				
				var respData = result.data.options;
				if(respData!=null){
					var olenk = respData.length;
					for (var x = 0; x < olenk; x++) {
						var opObject = new Option(respData[x][''+textcol], respData[x][''+valuecol]);
						$("#"+objID)[0].options.add(opObject);
					}
				}
			}
		},
		error:function(error){
			layer.alert("error",3);
		}
	});
}

/**
 * 根据数据中的表名及字段生成下拉框
 * @param tableName
 * @param textcol
 * @param valuecol
 */
function createSelectByDB(objID,tableName,textcol,valuecol,sql){
	$.ajax({
		url:getRequestUrl("/UIController/selectTable.json"),
		dataType:"json",
		data:{"selectConfig.tableName":tableName,"selectConfig.textCol":textcol,"selectConfig.valueCol":valuecol,"selectConfig.sql":sql},
		async:false,
		success:function(result){
			if(result.opflag){
				$("#"+objID).empty();
				var opObject = new Option("请选择", "");
				$("#"+objID)[0].options.add(opObject);
				
				var respData = result.data.options;
				var olenk = respData.length;
				for (var x = 0; x < olenk; x++) {
					var opObject = new Option(respData[x]['text'], respData[x]['value']);
					$("#"+objID)[0].options.add(opObject);
				}
			}
		},
		error:function(error){
			layer.alert("error",3);
		}
	});
}


/**
 * 根据数据中的表名及字段生成checkbox
 * @param objID
 * @param tableName
 * @param textcol
 * @param valuecol
 * @param sql
 */
function createCheckBoxByDB(objID,checkboxName,tableName,textcol,valuecol,sql,checkValues){
	$.ajax({
		url:getRequestUrl("/UIController/selectTable.json"),
		dataType:"json",
		data:{"selectConfig.tableName":tableName,"selectConfig.textCol":textcol,"selectConfig.valueCol":valuecol,"selectConfig.sql":sql},
		async:false,
		success:function(result){
			if(result.opflag){
				
				var html="";
				
				var respData = result.data.options;
				var olenk = respData.length;
				for (var x = 0; x < olenk; x++) {
				//	var opObject = new Option(respData[x]['text'], respData[x]['value']);
				//	$("#"+objID)[0].options.add(opObject);
					var checkedStr = "";
					if(checkValues!=null&&checkValues!="")
					{
						if((checkValues+",").indexOf(respData[x]['value'])!=-1)
						checkedStr="checked";
					}
					html += "<input type='checkbox'  text='"+respData[x]['text']+"'  "+checkedStr+"  name='"+checkboxName+"' id='"+checkboxName+"_"+respData[x]['value']+"' value='"+respData[x]['value']+"'/>"+"<label for='"+checkboxName+"_"+respData[x]['value']+"'>"+respData[x]['text']+"&nbsp;&nbsp;"+"</label>";
				}
				
				$("#"+objID).html(html);
			}
		},
		error:function(error){
			layer.alert("error",3);
		}
	});
}


/**
 * 根据codelist生成checkbox
 */
function createCheckboxByCodeList(objID,checkboxName,kind,checkValues){
	$.ajax({
		url:getRequestUrl("/transcodeController/selectTable.json"),
		dataType:"json",
		data:{kind:kind},
		async:false,
		success:function(result){
			if(result.opflag){
				
				
				var html="";
				var respData = result.data.options;
				if(respData!=null){
					var olenk = respData.length;
					for (var x = 0; x < olenk; x++) {
						var checkedStr = "";
						if(checkValues!=null&&checkValues!="")
						{
							if((checkValues+",").indexOf(respData[x]['value'])!=-1)
							checkedStr="checked";
						}
						html += "<input type='checkbox'  text='"+respData[x]['text']+"' "+checkedStr+" name='"+checkboxName+"' id='"+checkboxName+"_"+respData[x]['value']+"' value='"+respData[x]['value']+"'/>"+"<label for='"+checkboxName+"_"+respData[x]['value']+"'>"+respData[x]['text']+"&nbsp;&nbsp;"+"</label>";
						
					}
					$("#"+objID).html(html);
				}
				
				
			
			}
		},
		error:function(error){
			layer.alert("error",3);
		}
	});
}

/**
 * 上传文件方法
 * @param formid
 */
function ajaxFileUpload(parameterData) {
	
	
	var uploadId = parameterData["uploadId"];
	var modelForder = parameterData["modelForder"] == undefined ? "foodms" : parameterData["modelForder"];
	var successfunc = parameterData["successfunc"];
	
	var filenameimg = $("#"+uploadId).val();
//		if(checkPic(filenameimg))
//		{
			var postdata = {};
			postdata["modelForder"] = modelForder;
			$.ajaxMutFileUpload({
				url:getRequestUrl("/UIController/upload.json?uploadId="+uploadId),
		        files:[$("#"+uploadId)],//多个文件上传(String 或 Jquery对象均可)
		        secureuri:false,
		        dataType:'json',
		        data:postdata,
		        success:function(data){
		        	successfunc(data);
		        },
		        error:function(data,status,e){
		        	alert('error:'+e);
		        }
			});
//		}else{
//			$("#"+uploadId).val("");
//		}
}
/**
 * 上传文件方法
 * @param formid
 */
function ajaxFileUploadByid(parameterData,id) {
	
	
	var uploadId = parameterData["uploadId"];
	var modelForder = parameterData["modelForder"] == undefined ? "foodms" : parameterData["modelForder"];
	var successfunc = parameterData["successfunc"];
	
	var filenameimg = $("#"+uploadId).val();
//		if(checkPic(filenameimg))
//		{
			var postdata = {};
			postdata["modelForder"] = modelForder;
			$.ajaxMutFileUpload({
				url:getRequestUrl("/UIController/upload.json?uploadId="+uploadId),
		        files:[$("#"+uploadId)],//多个文件上传(String 或 Jquery对象均可)
		        secureuri:false,
		        dataType:'json',
		        data:postdata,
		        success:function(data){
		        	successfunc(data,id);
		        },
		        error:function(data,status,e){
		        	alert('error:'+e);
		        }
			});
//		}else{
//			$("#"+uploadId).val("");
//		}
}
function checkPic(picFormvalue){   
	 var location=picFormvalue;   
	 if(location==""){   
	  alert("请先选择图片文件");   
	  return false;   
	 }   
	 var point = location.lastIndexOf(".");   
	 var type = location.substr(point);   
	 if(type==".jpg"||type==".gif"||type==".JPG"||type==".GIF"||type==".png"){  
	     return true;   
	 }   
	 else{   
	  alert("只能输入jpg或者gif格式的图片");   
	  return false;   
	 }   
	 return true;   
   
} 

/**
 * 初始化富文本编辑器
 * @param editorid
 * @param widthval
 * @param heigthval
 * @param propertyname
 * @returns {String}
 */
function initUEditor(ueditorObj){
	//取得参数值
	var editorid = ueditorObj["editorid"];
	var width = ueditorObj["width"];
	var height = ueditorObj["height"];
	var propertyname = ueditorObj["propertyname"];
	var content = ueditorObj["content"];
	//初始化编辑器位置
	var postfix = getRandomStr();
	var ueditorid = editorid+postfix;
	var editorHtml = '<script type="text/plain" id="'+ueditorid+'" name="'+propertyname+'" style="width:'+width+'px;height:'+height+'px;">'+'</script>';
	$("#"+editorid).html(editorHtml);
	$("#"+editorid).attr("ueditorid",ueditorid).attr("name",propertyname);
	//生成编辑器
	var initUEditorObj = {};
	initUEditorObj.autoHeightEnabled = false;
	if(isNotEmpty(content)){
		initUEditorObj.initialContent = content;
	}
	var ue = UE.getEditor(""+ueditorid+"",initUEditorObj);
	return ue;
}

/**
 * @description 生成一个六位随机串
 * @author lingyong
 * @updateAuthor lingyong
 * @returns
 */
function getRandomStr(){
	var chars = ['0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'];
	var res = "";
    for(var i = 0; i < 6 ; i ++) {
        var id = Math.ceil(Math.random()*35);
        res += chars[id];
    }
    return res;
}

/**
 * 数据有效可用的时候返回true，否则返回false
 * @param checkData
 * @returns {Boolean}
 */
function isNotEmpty(checkData){
	if(typeof checkData=="string")
		checkData = $.trim(checkData);
	if(typeof checkData!="undefined" && checkData!=null && checkData!="" && checkData!=undefined){
		return true;
	}else{
		return false
	}
}

/**
 * 页面转向
 * @param page
 */
function pageForward(page){
	window.location.href= path+page;
}

/**
 * 
 * @param fileName
 */
function downLoadFile(fileName){
	var downLoadurl = path + "/UIController/download.do";
	var form=$("<form>");//定义一个form表单
	form.attr("style","display:none");
	form.attr("target","_blank");
	form.attr("method","post");
	form.attr("action",downLoadurl);
	var inputFileName=$("<input>");
	inputFileName.attr("type","hidden");
	inputFileName.attr("name","fileName");
	inputFileName.attr("value",fileName);
	$("body").append(form);
	form.append(inputFileName);
	form.submit();//表单提交
	form.remove();
}


/**
 * 根据id
 * 搜集导出excel参数String
 */
function CollectgetData(containerId){
	
	var sel = "name";
	var objs = $("#"+containerId+" [" + sel + "]");
	var getData ="";
	
	for (var i = 0, len = objs.length; i < len; i++) {
		
		var obj = objs[i];
		var name=$(obj).attr("name");
		var value=$(obj).val();
		getData+="&"+name+"="+value+"&";
	}

	return getData;

}