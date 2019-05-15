//window.onerror=function(){return true;}
//var username =document.getElementById("sys_hidden_currentUserName").value;
//var userid=document.getElementById("sys_hidden_currentUserId").value;
//var syspermissions=document.getElementById("sys_hidden_permissions").value;
//if(syspermissions=="" || syspermissions ==null || syspermissions=='null'){
//	syspermissions=1;
//}
var signed="0";
var xuexipeixunp='1';
var tongzhip='1';
var noticep='1';
var dongtaip='1';
var xinxicangkup='1';
var dangjianzhichuangp='1';
var guizhangzhidup='1';
var lianzhengjianshep='1';
var tongzhigonggaotype='10';
var gongzuodongtaitopp='1';
var gongzuodongtaip='1';
String.prototype.trim = function() {
	return this.replace(/(^\s*)|(\s*$)/g, "");
}

$(document).ready(function() {
	
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

	return path + url + makeProcessor();
}

/**
 * 构造processor对象的提交数据 注意：分页相关的参数直接在pageBarFortable中进行了构造，其它参数在此方法中完成
 */
function makeProcessor() {
	var traderid = $("#sys_hidden_traderid").val();
	var currentUserId = $("#sys_hidden_currentUserId").val();
	var ipaddress = $("#sys_hidden_ipaddress").val();
	var deviceType = $("#sys_hidden_deviceType").val();
	var currentUserName = $("#sys_hidden_currentUserName").val();

	var isadmin = $("#sys_hidden_isadmin").val();
	var isfiance = $("#sys_hidden_isfinance").val();
	var istrader = $("#sys_hidden_istrader").val();
	var tradername = $("#sys_hidden_tradername").val();
	var tradertype = $("#sys_hidden_tradertype").val();
	
	var payscale = $("#sys_hidden_payscale").val();/*交易商支付保证金比例*/

	if (typeof (traderid) == 'undefined') {
		traderid = parent.parent.$("#sys_hidden_traderid").val();
		currentUserId = parent.parent.$("#sys_hidden_currentUserId").val();
		ipaddress = parent.parent.$("#sys_hidden_ipaddress").val();
		deviceType = parent.parent.$("#sys_hidden_deviceType").val();
		currentUserName = parent.parent.$("#sys_hidden_currentUserName").val();
		
		isadmin = parent.parent.$("#sys_hidden_isadmin").val();
		isfiance = parent.parent.$("#sys_hidden_isfinance").val();
		istrader = parent.parent.$("#sys_hidden_istrader").val();
		tradername = parent.parent.$("#sys_hidden_tradername").val();
		tradertype = parent.parent.$("#sys_hidden_tradertype").val();		
		payscale=parent.parent.$("#sys_hidden_payscale").val();
	}
	if (traderid == undefined)
		traderid = $('#sys_hidden_traderid', parent.document).val();
	if (currentUserId == undefined)
		currentUserId = $("#sys_hidden_currentUserId", parent.document).val();
	return "&processor.traderid=" + traderid + "&processor.currentUserId="
			+ currentUserId + "&processor.currentUserName=" + currentUserName
			+ "&processor.ipaddress=" + ipaddress + "&processor.deviceType="
			+ deviceType + "&processor.isAdmin=" + isadmin
			+ "&processor.isFinance=" + isfiance + "&processor.isTrader="
			+ istrader + "&processor.tradername=" + tradername
			+ "&processor.tradertype=" + tradertype+"&processor.payscale="+payscale;

}

/**
 * 分页方法封装
 */
function pageBarFortable(parameterData, doFlag) {
	var dataJson = '';
	var url = parameterData["url"];
	var customArray = parameterData["customArray"];
	var pageIndex = parameterData["pageIndex"];
	var successfunc = parameterData["successfunc"];
	var page = parameterData["pageller"] || "pageller";
	var checkedId = parameterData["checkedId"];
	var pageSize = parameterData["pageSize"] || 10;
	var maxpagesize = 0;
	var processor = {};
	if (doFlag == 1) {// 前进
		pageIndex = $("#" + page + "pageindex").val();
		maxpagesize = $("#" + page + "maxpagesize").val();
		if (parseInt(pageIndex) < parseInt(maxpagesize)) {
			pageIndex++;
		} else {
			return;
		}
	} else if (doFlag == 2) {// 后退
		pageIndex = $("#" + page + "pageindex").val();
		if (parseInt(pageIndex) > 1) {
			pageIndex--;
		}
	} else if (doFlag == 5) {// GO
		maxpagesize = $("#" + page + "maxpagesize").val();
		if (parseInt(pageIndex) > parseInt(maxpagesize)) {
			return;
		}
	}
	// 合并用户自定义json
	if (customArray != null && customArray != undefined) {
		// 加入自定义json
		dataJson = customArray;
	}

	// 全选按钮设置
	$("#" + checkedId).attr("checked", false);
	$("#" + checkedId).bind("click", function() {
		if ($("#" + checkedId).attr("checked")) {
			$("input[name='" + checkedId + "']").attr("checked", true);
		} else {
			$("input[name='" + checkedId + "']").attr("checked", false);
		}
	});
	processor["processor.pageSize"] = pageSize;
	processor["processor.pageIndex"] = pageIndex;
	// 构建数据模型
	dataJson = $.extend({}, processor, dataJson);
	// showLoading();
	$
			.ajax({
				url : url,
				dataType : 'json',
				data : dataJson,
				success : function(result) {
					var pagebar = result.data.pageBar;
					var barlen = pagebar.length;
					var _totalCount = result.data.totalCount;
					var _maxsize = result.data.pageMaxSize;
					var _pageindex = result.data.pageIndex;
					var renderPageHtml = '<div class="pagetext"><div>共<span>'
							+ _totalCount
							+ '</span>条</div></div>'
							+ '<ul class="paginList">'
							+ '<li class="paginItem"><a href="javascript:;" id="'
							+ page
							+ 'pageBarFortable2"><span class="pagepre"><</span></a></li>';
					if(barlen>=10){
						barlen=10;
					}
					for (var ib = 0; ib < barlen; ib++) {
						var current = "";
						if (_pageindex == pagebar[ib]) {
							current = " current";
						}
						renderPageHtml = renderPageHtml
								+ '<li class="paginItem'
								+ current
								+ ' '
								+ page
								+ 'jumpin"><input type="hidden" name="pindex" value="'
								+ pagebar[ib] + '" /><a href="javascript:;">'
								+ pagebar[ib] + '</a></li>';
					}
					renderPageHtml = renderPageHtml
							+ '<li class="paginItem"><a href="javascript:;" id="'
							+ page
							+ 'pageBarFortable1"><span class="pagenxt">></span></a></li>'
							+ '</ul>' + '<input type="hidden" id="' + page
							+ 'maxpagesize" value="' + result.data.pageMaxSize
							+ '"/><input type="hidden" id="' + page
							+ 'pageindex" value="' + result.data.pageIndex
							+ '"/>';
					if(barlen>0){
					$("#" + page).html(renderPageHtml);
					}else{
						$("#" + page).html('暂无数据');
					}
					pageBindClick(page, parameterData);// 绑定分页方法
					successfunc(result.data.records, result);
				},
				error : function(error) {
					//layer.alert("error", 3);
				}
			});
}



// 分页功能绑定click事件
function pageBindClick(page, parameterData) {

	$("#" + page + "pageBarFortable1").unbind().bind("click", function() {
		pageBarFortable(parameterData, 1);
	});
	$("#" + page + "pageBarFortable2").unbind().bind("click", function() {
		pageBarFortable(parameterData, 2);
	});
	$("." + page + "jumpin").unbind().bind("click", function() {
		var pageIndex = $(this).find('input[name="pindex"]').val();
		parameterData["pageIndex"] = pageIndex;
		pageBarFortable(parameterData, 5);
	});
}
/**
 * 数据收集 containerId 指定html容器下的数据
 */
function collectData(containerId) {
	if (containerId == null || "" == containerId)
		container = "*";
	var sel = "dc";
	var objs = $("#" + containerId + " [" + sel + "]");
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

			if (obj.type.trim() == "text" || obj.type.trim() == "hidden"
					|| obj.type.trim() == "password") {
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
			var val = $(obj).val(); // obj.options[obj.selectedIndex].value;
			postData[field] = val;
			continue;
		}
		if (nodeName == "img") {
			postData[field] = $(obj).attr("value");
			continue;
		}
		/**
		 * update by lingy 新增富文本编辑框 start 通过取得初始化时editor的ID，取得富文本中的值
		 */
		var ueditorid = $(obj).attr("ueditorid");
		if (isNotEmpty(ueditorid)) {
			var editorContent = UE.getEditor(ueditorid).getContent();
			postData[field] = editorContent;
			continue;
		}
		/** **********update by lingy 新增富文本编辑框 end ******************** */
		postData[field] = $(obj).html();

	}
	// 返回从表单获取数据的json数据

	return postData;
}

/**
 * 连接多个收集对象的数值，方便进行统一提交
 * 
 * @param targetObj
 * @param obj
 * @returns
 */
function concatObj(targetObj, obj) {
	// 用来保存所有的属性名称和值
	var props = "";
	// 开始遍历
	for ( var p in obj) {
		// 方法
		if (typeof (obj[p]) == "function") {
			obj[p]();
		} else {
			// p 为属性名称，obj[p]为对应属性的值
			// props+= p + "=" + obj[p] + "\t";
			targetObj[p] = obj[p];
		}
	}

	return targetObj;
}

/**
 * luandong
 * 
 * @param containerId
 *            根据容器id绑定校验事件
 * @returns {___anonymous8746_8747}
 */
function bindValidateEvent(containerId) {
	// if(containerId==null||""==containerId)
	// container = "*";

	// 处理必填
	var sel = "dcrequired";
	var objs = $("#" + containerId + " [" + sel + "]");
	for (var i = 0, len = objs.length; i < len; i++) {
		var obj = objs[i];
		// 1 设置显示必填红星
		// $(obj).after("<span style='color:red;display:inline;'>*</span>");
		// 2 绑定bulr的事件，处理显示
		$(obj).bind("blur",function() {
							if ($(this).val() == "") {
								var requiredMsg = $(this).attr("dcrequired") == "" ? "此项目不能为空!"
										: $(this).attr("dcrequired");
								$(this).attr("dccheck", "false");
								$(this).css("background-color", "#ffffdf");

								layer.tips("&nbsp;&nbsp;" + requiredMsg,this,
												{
													guide : 2,
													shadeClose : true,
													time : 3,
													style : ['background-color:#F26C4F; color:#fff','#F26C4F' ],
													maxWidth : 150
												});
							} else {
								$(this).attr("dccheck", "true");
								$(this).css("background-color", "#ffffff");
							}
						})
				.bind("focus",function() {
							if ($(this).val() == "") {
								var requiredMsg = $(this).attr("dcrequired") == "" ? "此项目不能为空!": $(this).attr("dcrequired");
								layer.tips("&nbsp;&nbsp;" + requiredMsg,this,
												{
													guide : 2,
													shadeClose : true,
													time : 3,
													style : ['background-color:#F26C4F; color:#fff','#F26C4F' ],
													maxWidth : 150
												});
							}
						});
	}
	// 绑定控件类型
	sel = "dctype";
	objs = $("#" + containerId + " [" + sel + "]");
	for (var i = 0, len = objs.length; i < len; i++) {
		var obj = objs[i];
		switch ($(obj).attr(sel)) {
		case "数字":
			$(obj).keypress(
					function(event) {
						var keyCode = event.which;
						if (keyCode == 46 || (keyCode >= 48 && keyCode <= 57)
								|| keyCode == 8)
							return true;
						else
							return false;
					}).focus(function() {
				this.style.imeMode = 'disabled';
			});
			break;
		case "金额":
			$(obj).keyup(
					function(event) {
						//var regex = /^\d+\.?\d{0,2}$/;
						var regex ;
						//var index = this.value.indexOf("0"); 
						var index=this.value.substring(0,1);
						var length = this.value.length;  
						if(index == 0 && length>1){/*0开头的数字串*/  
							regex = /^[0]{1}[.]{1}[0-9]{0,2}$/;  						            
						}else if(length>1){/*非0开头的数字*/  
							regex = /^[1-9]{1}[0-9]{0,10}[.]{0,1}[0-9]{0,2}$/;  						           
						}             
						 
						if(regex!=null){
							if (!regex.test(this.value)) {
								layer.tips("&nbsp;&nbsp;请正确输入金额,且小数点后最多2位！", this, {
									guide : 2,
									shadeClose : true,
									time : 3,
									style : ['background-color:#F26C4F; color:#fff','#F26C4F' ],
									maxWidth : 350
								});
								this.value = "";
								this.focus();
							}
						}
						
					}).focus(function() {
				this.style.imeMode = 'disabled';
			});
			break;
		case "吨数":
			$(obj).keyup(
					function(event) {
						var regex = /^\d+\.?\d{0,3}$/;
				               
				   
				if (!regex.test(this.value)) {
					layer.tips("&nbsp;&nbsp;请正确输入,小数点后最多3位！", this, {
						guide : 2,
						shadeClose : true,
						time : 3,
						style : ['background-color:#F26C4F; color:#fff','#F26C4F' ],
						maxWidth : 250
					});
					this.value = "";
					this.focus();
				}

			}).focus(function() {
				this.style.imeMode = 'disabled';
			});
			break;
		case "字母":
			$(obj).keypress(
					function(event) {
						var eventObj = event || e;
						var keyCode = eventObj.keyCode || eventObj.which;
						if ((keyCode >= 65 && keyCode <= 90)
								|| (keyCode >= 97 && keyCode <= 122)
								|| keyCode == 8)
							return true;
						else {
							layer.tips("&nbsp;&nbsp;只能录入字母", this, {
								guide : 2,
								shadeClose : true,
								time : 3,
								style : [
										'background-color:#F26C4F; color:#fff',
										'#F26C4F' ],
								maxWidth : 150
							});
							return false;
						}
					}).focus(function() {
				this.style.imeMode = 'disabled';
			}).bind("paste", function() {
				var clipboard = window.clipboardData.getData("Text");
				if (/^[a-zA-Z]+$/.test(clipboard))
					return true;
				else
					return false;
			});
			break;
		case "数字或字母":
			$(obj).keypress(
					function(event) {
						var eventObj = event || e;
						var keyCode = eventObj.keyCode || eventObj.which;
						if ((keyCode >= 48 && keyCode <= 57)
								|| (keyCode >= 65 && keyCode <= 90)
								|| (keyCode >= 97 && keyCode <= 122)
								|| keyCode == 8)
							return true;
						else {
							layer.tips("&nbsp;&nbsp;只能录入数字或字母", this, {
								guide : 2,
								shadeClose : true,
								time : 3,
								style : [
										'background-color:#F26C4F; color:#fff',
										'#F26C4F' ],
								maxWidth : 150
							});
							return false;
						}
					}).focus(function() {
				this.style.imeMode = 'disabled';
			}).bind("paste", function() {
				var clipboard = window.clipboardData.getData("Text");
				if (/^(\d|[a-zA-Z])+$/.test(clipboard))
					return true;
				else
					return false;
			});
			break;
		case "身份证":
			$(obj)
					.bind(
							"blur",
							function() {
								if ($(this).val() != "") {
									if (!isIdCardNo($(this).val())) {
										var requiredMsg = "身份证号不合法";
										$(this).attr("dccheck", "false");
										$(this).css("background-color",
												"#ffffdf");

										layer
												.tips(
														"&nbsp;&nbsp;"
																+ requiredMsg,
														this,
														{
															guide : 2,
															shadeClose : true,
															time : 3,
															style : [
																	'background-color:#F26C4F; color:#fff',
																	'#F26C4F' ],
															maxWidth : 150
														});
									} else {
										$(this).attr("dccheck", "true");
										$(this).css("background-color",
												"#ffffff");
									}
								} else {
									$(this).attr("dccheck", "true");
									$(this).css("background-color", "#ffffff");
								}
							});
			break;
		case "手机号":
			$(obj)
					.bind(
							"blur",
							function() {
								if ($(this).val() != "") {
									if (!checkMobile($(this).val())) {
										var requiredMsg = "手机号不合法";
										$(this).attr("dccheck", "false");
										$(this).css("background-color",
												"#ffffdf");

										layer
												.tips(
														"&nbsp;&nbsp;"
																+ requiredMsg,
														this,
														{
															guide : 2,
															shadeClose : true,
															time : 5,
															style : [
																	'background-color:#F26C4F; color:#fff',
																	'#F26C4F' ],
															maxWidth : 150
														});
									} else {
										$(this).attr("dccheck", "true");
										$(this).css("background-color",
												"#ffffff");
									}
								} else {
									$(this).attr("dccheck", "true");
									$(this).css("background-color", "#ffffff");
								}
							});
			break;
		case "邮箱":
			$(obj)
					.bind(
							"blur",
							function() {
								if ($(this).val() != "") {
									if (!checkEmail($(this).val())) {
										var requiredMsg = "邮箱不合法";
										$(this).attr("dccheck", "false");
										$(this).css("background-color",
												"#ffffdf");

										layer
												.tips(
														"&nbsp;&nbsp;"
																+ requiredMsg,
														this,
														{
															guide : 2,
															shadeClose : true,
															time : 5,
															style : [
																	'background-color:#F26C4F; color:#fff',
																	'#F26C4F' ],
															maxWidth : 150
														});
									} else {
										$(this).attr("dccheck", "true");
										$(this).css("background-color",
												"#ffffff");
									}
								} else {
									$(this).attr("dccheck", "true");
									$(this).css("background-color", "#ffffff");
								}
							});
			break;
		/**
		 * lingy update 新增ajax异步校验
		 */
		case "ajax校验":
			$(obj)
					.bind(
							"blur",
							function() {
								if ($(this).val() != "") {
									var dcajax = $(this).attr("dcajax");
									if (isNotEmpty(dcajax)) {
										var ajaxParam = eval("(" + dcajax + ")");
										ajaxParam.checkval = $(this).val();
										var checkresult = checkAjax(ajaxParam);
										if (!checkresult.flag) {
											var requiredMsg = checkresult.msg;
											$(this).attr("dccheck", "false");
											$(this).css("background-color",
													"#ffffdf");

											layer
													.tips(
															"&nbsp;&nbsp;"
																	+ requiredMsg,
															this,
															{
																guide : 2,
																shadeClose : true,
																time : 5,
																style : [
																		'background-color:#F26C4F; color:#fff',
																		'#F26C4F' ],
																maxWidth : 150
															});
										} else {
											$(this).attr("dccheck", "true");
											$(this).css("background-color",
													"#ffffff");
										}
									} else {
										$(this).attr("dccheck", "true");
										$(this).css("background-color",
												"#ffffff");
									}
								} else {
									$(this).attr("dccheck", "true");
									$(this).css("background-color", "#ffffff");
								}
							});
			break;

			
		case "银行卡号":
			$(obj)
					.bind(
							"blur",
							function() {
								if ($(this).val() != "") {
									if (!checkBankCode($(this).val())) {
										var requiredMsg = "银行卡号不合法";
										$(this).attr("dccheck", "false");
										$(this).css("background-color",
												"#ffffdf");

										layer
												.tips(
														"&nbsp;&nbsp;"
																+ requiredMsg,
														this,
														{
															guide : 2,
															shadeClose : true,
															time : 5,
															style : [
																	'background-color:#F26C4F; color:#fff',
																	'#F26C4F' ],
															maxWidth : 150
														});
									} else {
										$(this).attr("dccheck", "true");
										$(this).css("background-color",
												"#ffffff");
									}
								} else {
									$(this).attr("dccheck", "true");
									$(this).css("background-color", "#ffffff");
								}
							});
			break;
			
		case "办公电话":
			$(obj)
					.bind(
							"blur",
							function() {
								if ($(this).val() != "") {
									if (!checkPhone($(this).val())) {
										var requiredMsg = "办公电话不合法";
										$(this).attr("dccheck", "false");
										$(this).css("background-color",
												"#ffffdf");

										layer
												.tips(
														"&nbsp;&nbsp;"
																+ requiredMsg,
														this,
														{
															guide : 2,
															shadeClose : true,
															time : 5,
															style : [
																	'background-color:#F26C4F; color:#fff',
																	'#F26C4F' ],
															maxWidth : 150
														});
									} else {
										$(this).attr("dccheck", "true");
										$(this).css("background-color",
												"#ffffff");
									}
								} else {
									$(this).attr("dccheck", "true");
									$(this).css("background-color", "#ffffff");
								}
							});
			break;
			
		case "邮编":
			$(obj)
					.bind(
							"blur",
							function() {
								if ($(this).val() != "") {
									if (!checkZipCode($(this).val())) {
										var requiredMsg = "邮编不合法";
										$(this).attr("dccheck", "false");
										$(this).css("background-color",
												"#ffffdf");

										layer
												.tips(
														"&nbsp;&nbsp;"
																+ requiredMsg,
														this,
														{
															guide : 2,
															shadeClose : true,
															time : 5,
															style : [
																	'background-color:#F26C4F; color:#fff',
																	'#F26C4F' ],
															maxWidth : 150
														});
									} else {
										$(this).attr("dccheck", "true");
										$(this).css("background-color",
												"#ffffff");
									}
								} else {
									$(this).attr("dccheck", "true");
									$(this).css("background-color", "#ffffff");
								}
							});
			break;
			
		case "姓名":
			$(obj)
					.bind(
							"blur",
							function() {
								if ($(this).val() != "") {
									if (!checkName($(this).val())) {
										var requiredMsg = "姓名不合法";
										$(this).attr("dccheck", "false");
										$(this).css("background-color",
												"#ffffdf");

										layer
												.tips(
														"&nbsp;&nbsp;"
																+ requiredMsg,
														this,
														{
															guide : 2,
															shadeClose : true,
															time : 5,
															style : [
																	'background-color:#F26C4F; color:#fff',
																	'#F26C4F' ],
															maxWidth : 150
														});
									} else {
										$(this).attr("dccheck", "true");
										$(this).css("background-color",
												"#ffffff");
									}
								} else {
									$(this).attr("dccheck", "true");
									$(this).css("background-color", "#ffffff");
								}
							});
			break;
		
		//验证出金账户名与子账户名是否相同
		case "账户名":
			$(obj)
					.bind(
							"blur",
							function() {
								if ($(this).val() != "") {
									if (!checkAccountName($(this).val())) {
										var requiredMsg = "与子账户名称不符";
										$(this).attr("dccheck", "false");
										$(this).css("background-color",
												"#ffffdf");

										layer
												.tips(
														"&nbsp;&nbsp;"
																+ requiredMsg,
														this,
														{
															guide : 2,
															shadeClose : true,
															time : 5,
															style : [
																	'background-color:#F26C4F; color:#fff',
																	'#F26C4F' ],
															maxWidth : 150
														});
									} else {
										$(this).attr("dccheck", "true");
										$(this).css("background-color",
												"#ffffff");
									}
								} else {
									$(this).attr("dccheck", "true");
									$(this).css("background-color", "#ffffff");
								}
							});
			break;
			
		case "社会信用代码":
			$(obj)
					.bind(
							"blur",
							function() {
								if ($(this).val() != "") {
									if (!checkCreditCode($(this).val())) {
										var requiredMsg = "社会信用代码不合法";
										$(this).attr("dccheck", "false");
										$(this).css("background-color",
												"#ffffdf");

										layer
												.tips(
														"&nbsp;&nbsp;"
																+ requiredMsg,
														this,
														{
															guide : 2,
															shadeClose : true,
															time : 5,
															style : [
																	'background-color:#F26C4F; color:#fff',
																	'#F26C4F' ],
															maxWidth : 150
														});
									} else {
										$(this).attr("dccheck", "true");
										$(this).css("background-color",
												"#ffffff");
									}
								} else {
									$(this).attr("dccheck", "true");
									$(this).css("background-color", "#ffffff");
								}
							});
			break;
		}
	}

}

function checkMobile(vtext) {
	//var isMobile = /^(?:13\d|15\d|18\d)\d{5}(\d{3}|\*{3})$/; // 手机号码验证规则
	var isMobile=/^(?:13\d|15\d|18\d|14\d|17\d|19\d)\d{5}(\d{3}|\*{3})$/; //手机号码验证规则
	if (!isMobile.test(vtext)) {
		return false;
	} else {
		return true;
	}
}

function checkEmail(vtext) {

	var re = /^([a-zA-Z0-9]+[_|_|.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|_|.]?)*[a-zA-Z0-9]+.[a-zA-Z]{2,3}$/ig;
	if (!re.test(vtext)) {
		return false;
	}
	return true;
}

/*function checkIdCard(idcard) {
	var reg = /^[1-9]{1}[0-9]{14}$|^[1-9]{1}[0-9]{16}([0-9]|[xX])$/;
	if (reg.test(idcard)) {
		return true;
	} else {
		return false;
	}
}*/


//============================================================================================


function isIdCardNo(num){
	num = num.toUpperCase();
	// 身份证号码为15位或者18位，15位时全为数字，18位前17位为数字，最后一位是校验位，可能为数字或字符X。
	if (!(/(^\d{15}$)|(^\d{17}([0-9]|X)$)/.test(num))){
		return false;
	}
	// 校验位按照ISO 7064:1983.MOD 11-2的规定生成，X可以认为是数字10。
	// 下面分别分析出生日期和校验位
	var len, re;
	len = num.length;
	if (len == 15){
		re = new RegExp(/^(\d{6})(\d{2})(\d{2})(\d{2})(\d{3})$/);
		var arrSplit = num.match(re);
		// 检查生日日期是否正确
		var dtmBirth = new Date('19' + arrSplit[2] + '/' + arrSplit[3] + '/'+ arrSplit[4]);
		var bGoodDay;
		bGoodDay = (dtmBirth.getYear() == Number(arrSplit[2]))
				&& ((dtmBirth.getMonth() + 1) == Number(arrSplit[3]))
				&& (dtmBirth.getDate() == Number(arrSplit[4]));
		if (!bGoodDay){
			return false;
		}else{
			/*// 将15位身份证转成18位
			// 校验位按照ISO 7064:1983.MOD 11-2的规定生成，X可以认为是数字10。
			var arrInt = new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5,8, 4, 2);
			var arrCh = new Array('1', '0', 'X', '9', '8', '7', '6', '5', '4','3', '2');
			var nTemp = 0, i;
			num = num.substr(0, 6) + '19' + num.substr(6, num.length - 6);
			for (i = 0; i < 17; i++){
				nTemp += num.substr(i, 1) * arrInt[i];
			}
			num += arrCh[nTemp % 11];*/
			return true;
		}
	}
	if (len == 18){
		re = new RegExp(/^(\d{6})(\d{4})(\d{2})(\d{2})(\d{3})([0-9]|X)$/);
		var arrSplit = num.match(re);
		// 检查生日日期是否正确
		var dtmBirth = new Date(arrSplit[2] + "/" + arrSplit[3] + "/"+ arrSplit[4]);
		var bGoodDay;
		bGoodDay = (dtmBirth.getFullYear() == Number(arrSplit[2]))
				&& ((dtmBirth.getMonth() + 1) == Number(arrSplit[3]))
				&& (dtmBirth.getDate() == Number(arrSplit[4]));
		if (!bGoodDay){
			return false;
		}else{
			// 检验18位身份证的校验码是否正确。
			// 校验位按照ISO 7064:1983.MOD 11-2的规定生成，X可以认为是数字10。
			var valnum;
			var arrInt = new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5 , 8, 4, 2);
			var arrCh = new Array('1', '0', 'X', '9', '8', '7', '6', '5', '4' , '3', '2');
			var nTemp = 0, i;
			for (i = 0; i < 17; i++){
				nTemp += num.substr(i, 1) * arrInt[i];
			}
			valnum = arrCh[nTemp % 11];
			if (valnum != num.substr(17, 1))
			{
				return false;
			}
			return true;
		}
	}
	return false;
}  


//============================================================================================


//银行卡
function checkBankCode(bankcode){
	var reg =/^[1-9]{1}[0-9]{3}\s[0-9]{4}\s[0-9]{4}\s[0-9]{4}\s[0-9]{3}$/ ; //有空格19位
	var reg1=/^[1-9]{1}[0-9]{3}\s[0-9]{4}\s[0-9]{4}\s[0-9]{4}$/;  //有空格16位
	var reg2=/^[1-9]{1}[0-9]{18}$/ ;  //无空格19位
	var reg3=/^[1-9]{1}[0-9]{15}$/; //无空格16位
	if (reg.test(bankcode) || reg1.test(bankcode) || reg2.test(bankcode) || reg3.test(bankcode)) {
		return true;
	} else {
		return false;
	}
}


//固定电话
function checkPhone(phone){
	var reg =/^(0\d{2,3}-?)?\d{7,8}$/ ;
	if (reg.test(phone)) {
		return true;
	} else {
		return false;
	}
}

//邮编
function checkZipCode(zipcode){
	var reg =/^[1-9]\d{5}(?!\d)$/ ;
	if (reg.test(zipcode)) {
		return true;
	} else {
		return false;
	}
}
	
//姓名
function checkName(name){
	var reg =/^([a-zA-z]|[\u4e00-\u9eff])+([\s·]([a-zA-z]|[\u4e00-\u9eff])+)?$/ ;
	if (reg.test(name)) {
		return true;
	} else {
		return false;
	}
}



function checkAccountName(accountname){
	var checkedname=$("#tradernameKH").val();
	if(checkedname!=null && checkedname.length>0){
		if(checkedname==accountname){
			return true;
		}else{
			return false;
		}
	}else{
		return false;
	}
}


//统一社会信用代码
function checkCreditCode(creditcode){
	var reg =/^[A-Za-z0-9]{18}$/ ;
	if (reg.test(creditcode)) {
		return true;
	} else {
		return false;
	}
}

/**
 * add by lingy ajax校验
 * 
 * @param ajaxParam
 * 
 * @param checkattr
 *            后台接受参数
 * @param url
 *            请求路径
 */
function checkAjax(ajaxParam) {
	// 获取ajax参数
	var url = ajaxParam["url"] || "";
	var checkval = ajaxParam["checkval"] || "";
	var checkattr = ajaxParam["checkattr"] || "";
	// 返回结果数据
	var result = {};
	result.flag = false;
	// 创建传入后台得参数
	var postDataStr = "{'" + checkattr + "':'" + checkval + "'}";
	var postData = eval("(" + postDataStr + ")");
	for ( var property in ajaxParam) {
		if (property == "url" || property == "checkattr"
				|| property == "checkval") {
			continue;
		}
		if (property == "otherNameParam") {
			var otherParam = ajaxParam[property];
			var otherParamVal = $("[name='" + otherParam + "']").val();
			postData[otherParam] = otherParamVal;
			continue;
		}
		postData[property] = ajaxParam[property];
	}
	$.ajax({
		url : getRequestUrl(url),
		dataType : "json",
		data : postData,
		async : false,
		success : function(data) {
			if (data.opflag == true) {
				result.flag = true;
			} else {
				result.msg = data.opmessage || "数据不合法";
			}
		},
		error : function(error) {
		//	alert("error");
		}
	});
	return result;
}

function ValidateNumber(e, pnumber) {
	if (!/^\d+$/.test(pnumber)) {

		$(e).val(/^\d+/.exec($(e).val()));

	}

	return false;

}

function checkFormValue(containerId) {
	var falg = true;
	if (containerId == null || "" == containerId)
		container = "*";
	// 1 检查必填项目
	var sel = "dcrequired";
	var objs = $("#" + containerId + " [" + sel + "]");
	var postData = {};
	for (var i = 0, len = objs.length; i < len; i++) {
		var obj = objs[i];
		if ($(obj).val() == "") {

			var requiredMsg = $(obj).attr(sel) == "" ? "此项目不能为空!" : $(obj)
					.attr(sel);
			if (falg)
				$(obj).focus();
			falg = false;
			layer.tips("&nbsp;&nbsp;" + requiredMsg, obj, {
				guide : 2,
				shadeClose : true,
				follow : "#" + obj.id,
				time : 5,
				style : [ 'background-color:#F26C4F; color:#fff', '#F26C4F' ],
				maxWidth : 150
			});
			return falg;
		}
	}
	// 2 直接读取dccheck属性
	sel = "dccheck";
	objs = $("#" + containerId + " [" + sel + "]");
	for (var i = 0, len = objs.length; i < len; i++) {
		var obj = objs[i];
		if ($(obj).attr("dccheck") == 'false') {
			falg = false;
			$(obj).focus();
			break;
		}
	}

	return falg;
}

/** 毫秒转日期 */
function formatDate(ms) {
	var now = new Date(ms);
	var year = now.getFullYear();
	var month = now.getMonth() + 1;
	var date = now.getDate();
	if (month < 10)
		month = "0" + month;
	if (date < 10)
		date = "0" + date;
	return year + "/" + month + "/" + date;
}

/**
 * 加载店内职位下拉框
 */
function queryUserRole(selectId) {

	$.ajax({
		url : getRequestUrl("/sysRoleController/queryUserRole.json"),
		dataType : "json",
		async : false,
		success : function(result) {
			if (result.roleList) {
				$("#" + selectId).html("<option value=''>请选择</option>");
				for (var i = 0; i < result.roleList.length; i++) {
					$("#" + selectId)
							.append(
									"<option value='" + result.roleList[i].id
											+ "'>"
											+ result.roleList[i].rolename
											+ "</option>");
				}
			}
		},
		error : function(error) {
			//layer.alert("error", 3);
		}
	});
}

/**
 * 加载店内职位复选框 rolechecked为上级元素id checkedname为复选框name disable设置复选框是否可选
 */
function queryUserRoleChecked(rolecheckedid, checkedname, disable) {

	$
			.ajax({
				url : getRequestUrl("/sysResourceController/querySysResource.json"),
				dataType : "json",
				data : {
					type : "0"
				},
				async : false,
				success : function(result) {
					if (result.sysResourceList) {
						var j = 0;
						var k = 0;
						for (var i = 0; i < result.sysResourceList.length; i++) {
							if (result.sysResourceList[i].type == "1") {
								j++;
								if (j % 6 == 0) {
									$("#" + rolecheckedid + "Phone")
											.append(
													"<br><label><input type='checkbox' name='"
															+ checkedname
															+ "' value='"
															+ result.sysResourceList[i].id
															+ "' dc='true'/> "
															+ result.sysResourceList[i].resourcename
															+ "</label>");
								} else {
									$("#" + rolecheckedid + "Phone")
											.append(
													"<label><input type='checkbox' name='"
															+ checkedname
															+ "' value='"
															+ result.sysResourceList[i].id
															+ "' dc='true'/> "
															+ result.sysResourceList[i].resourcename
															+ "</label>");
								}
							} else {
								k++;
								if (k % 6 == 0) {
									$("#" + rolecheckedid)
											.append(
													"<br><label><input type='checkbox' name='"
															+ checkedname
															+ "' value='"
															+ result.sysResourceList[i].id
															+ "' dc='true'/> "
															+ result.sysResourceList[i].resourcename
															+ "</label>");
								} else {
									$("#" + rolecheckedid)
											.append(
													"<label><input type='checkbox' name='"
															+ checkedname
															+ "' value='"
															+ result.sysResourceList[i].id
															+ "' dc='true'/> "
															+ result.sysResourceList[i].resourcename
															+ "</label>");
								}
							}
						}
						if (disable != false && disable != undefined) {
							$("input[name='" + checkedname + "']").attr(
									'disabled', true);
						}
					}
				},
				error : function(error) {
					//layer.alert("error", 3);
				}
			});
}

/**
 * 让复选框打勾 data中为需要打勾的复选框值域
 */
function makeCheckEd(name, data) {
	if (data)
		for (var i = 0; i < data.length; i++) {
			$("input[name='" + name + "'][value='" + data[i].id + "']").prop(
					"checked", true);
		}
}

/**
 * 复选框全选\取值处理 当flag为false时只进行取值－ 要求全选复选框id值与列表复选name属性值相同
 */
function checkControl(checkedId, flag) {
	var s = '';
	if (flag) {
		$("#" + checkedId).click(function() {
			if ($("#" + checkedId).attr("checked")) {
				$("input[name='" + checkedId + "']").attr("checked", true);
			} else {
				$("input[name='" + checkedId + "']").attr("checked", false);
			}
		});
	} else {
		$('input[name="' + checkedId + '"]:checked').each(function() {
			s += $(this).val() + ',';
		});
		// 得到选中的checkbox值序列
		if (s.length > 0)
			s = s.substring(0, s.length - 1);
	}
	return s;
}

var loadi;
/**
 * 增加loading处理，此方法有问题，同layer插件有些冲突，暂时不使用
 */
function appendLoadDiv() {
	// layer.close(_loadi_layer);
	$(document).ajaxStart(function() {
		showLoading();
		// loadi = layer.load('加载中…');
	}).ajaxStop(function() {
		hideLoading();
		// layer.close(loadi);
	});

}

function showLoading() {
	if ($("#mainbody").length > 0) {

		jQuery('#mainbody').showLoading();
	}
}

function hideLoading() {
	if ($("#mainbody").length > 0) {
		jQuery('#mainbody').hideLoading();
	}
}

/**
 * 根据codelist生成下拉列表
 */
function createSelectByCodeList(objID, kind) {
	$.ajax({
		url : getRequestUrl("/transcodeController/selectTable.json"),
		dataType : "json",
		data : {
			kind : kind
		},
		async : false,
		success : function(result) {
			if (result.opflag) {
				$("#" + objID).empty();
				var opObject = new Option("请选择", "");
				$("#" + objID)[0].options.add(opObject);
				var respData = result.data.options;
				if (respData != null) {
					var olenk = respData.length;
					for (var x = 0; x < olenk; x++) {
						var opObject = new Option(respData[x]['text'],
								respData[x]['value']);
						$("#" + objID)[0].options.add(opObject);
					}
				}
			}
		},
		error : function(error) {
			//layer.alert("error", 3);
		}
	});
}

/**
 * 根据后台的controllerURL生成下拉列表
 */
function createSelectByQuery(controllerURL, objID, textcol, valuecol) {
	$.ajax({
		url : getRequestUrl(controllerURL),
		dataType : "json",
		data : {
			type : "0"
		},
		async : false,
		success : function(result) {
			if (result.opflag) {
				$("#" + objID).empty();
				var opObject = new Option("请选择", "");
				$("#" + objID)[0].options.add(opObject);

				var respData = result.data.options;
				if (respData != null) {
					var olenk = respData.length;
					for (var x = 0; x < olenk; x++) {
						var opObject = new Option(respData[x]['' + textcol],
								respData[x]['' + valuecol]);
						$("#" + objID)[0].options.add(opObject);
					}
				}
			}
		},
		error : function(error) {
			//layer.alert("error", 3);
		}
	});
}

/**
 * 根据数据中的表名及字段生成下拉框
 * 
 * @param tableName
 * @param textcol
 * @param valuecol
 */
function createSelectByDB(objID, tableName, textcol, valuecol, sql) {
	$.ajax({
		url : getRequestUrl("/UIController/selectTable.json"),
		dataType : "json",
		data : {
			"selectConfig.tableName" : tableName,
			"selectConfig.textCol" : textcol,
			"selectConfig.valueCol" : valuecol,
			"selectConfig.sql" : sql
		},
		async : false,
		success : function(result) {
			if (result.opflag) {
				$("#" + objID).empty();
				var opObject = new Option("请选择", "");
				$("#" + objID)[0].options.add(opObject);

				var respData = result.data.options;
				var olenk = respData.length;
				for (var x = 0; x < olenk; x++) {
					var opObject = new Option(respData[x]['text'],
							respData[x]['value']);
					$("#" + objID)[0].options.add(opObject);
				}
			}
		},
		error : function(error) {
			//layer.alert("error", 3);
		}
	});
}

/**
 * 根据数据中的表名及字段生成checkbox
 * 
 * @param objID
 * @param tableName
 * @param textcol
 * @param valuecol
 * @param sql
 */
function createCheckBoxByDB(objID, checkboxName, tableName, textcol, valuecol,
		sql, checkValues) {
	$
			.ajax({
				url : getRequestUrl("/UIController/selectTable.json"),
				dataType : "json",
				data : {
					"selectConfig.tableName" : tableName,
					"selectConfig.textCol" : textcol,
					"selectConfig.valueCol" : valuecol,
					"selectConfig.sql" : sql
				},
				async : false,
				success : function(result) {
					if (result.opflag) {

						var html = "";

						var respData = result.data.options;
						var olenk = respData.length;
						for (var x = 0; x < olenk; x++) {
							// var opObject = new Option(respData[x]['text'],
							// respData[x]['value']);
							// $("#"+objID)[0].options.add(opObject);
							var checkedStr = "";
							if (checkValues != null && checkValues != "") {
								if ((checkValues + ",")
										.indexOf(respData[x]['value']) != -1)
									checkedStr = "checked";
							}
							html += "<input type='checkbox'  text='"
									+ respData[x]['text'] + "'  " + checkedStr
									+ "  name='" + checkboxName + "' id='"
									+ checkboxName + "_" + respData[x]['value']
									+ "' value='" + respData[x]['value']
									+ "'/>" + "<label for='" + checkboxName
									+ "_" + respData[x]['value'] + "'>"
									+ respData[x]['text'] + "&nbsp;&nbsp;"
									+ "</label>";
						}

						$("#" + objID).html(html);
					}
				},
				error : function(error) {
					//layer.alert("error", 3);
				}
			});
}

function createBatchSelectByCodeList(objIDs,kinds,selectArray){
	$.ajax({
		url:getRequestUrl("/transcodeController/batchSelectTable.json"),
		dataType:"json",
		data:{kinds:kinds,objIDs:objIDs},
		async:false,
		success:function(result){
			if(result.opflag){

				var objArray = objIDs.split(",");
				for(var idx=0;idx<objArray.length;idx++)
				{
					
					var objID = objArray[idx];
					$("#"+objID).empty();
					var opObject = new Option("请选择", "");
					$("#"+objID)[0].options.add(opObject);
					eval('var respData = result.'+objArray[idx]+'.options;');
					if(respData!=null){
						var olenk = respData.length;
						for (var x = 0; x < olenk; x++) {
							var opObject = new Option(respData[x]['text'], respData[x]['value']);
							if(selectArray!=null&&selectArray[idx]!=null&&selectArray[idx]==respData[x]['value']){
								opObject.selected="selected";
							}
							
							$("#"+objID)[0].options.add(opObject);
						}
					}
					
				}
				
			}
		},
		error:function(error){
			//layer.alert("error",3);
		}
	});
}
/**
 * 根据codelist生成checkbox
 */
function createCheckboxByCodeList(objID, checkboxName, kind, checkValues) {
	$.ajax({
		url : getRequestUrl("/transcodeController/selectTable.json"),
		dataType : "json",
		data : {
			kind : kind
		},
		async : false,
		success : function(result) {
			if (result.opflag) {

				var html = "";
				var respData = result.data.options;
				if (respData != null) {
					var olenk = respData.length;
					for (var x = 0; x < olenk; x++) {
						var checkedStr = "";
						if (checkValues != null && checkValues != "") {
							if ((checkValues + ",")
									.indexOf(respData[x]['value']) != -1)
								checkedStr = "checked";
						}
						html += "<input type='checkbox'  text='"
								+ respData[x]['text'] + "' " + checkedStr
								+ " name='" + checkboxName + "' id='"
								+ checkboxName + "_" + respData[x]['value']
								+ "' value='" + respData[x]['value'] + "'/>"
								+ "<label for='" + checkboxName + "_"
								+ respData[x]['value'] + "'>"
								+ respData[x]['text'] + "&nbsp;&nbsp;"
								+ "</label>";

					}
					$("#" + objID).html(html);
				}

			}
		},
		error : function(error) {
			//layer.alert("error", 3);
		}
	});
}

/**
 * 上传文件方法
 * 
 * @param formid
 */
function ajaxFileUpload(parameterData) {

	var uploadId = parameterData["uploadId"];
	var modelForder = parameterData["modelForder"] == undefined ? "foodms": parameterData["modelForder"];
	var successfunc = parameterData["successfunc"];

	var filenameimg = $("#" + uploadId).val();
	
	 if(checkPic(filenameimg))
	 {
		var postdata = {};
		postdata["modelForder"] = modelForder;
		$.ajaxMutFileUpload({
			url : getRequestUrl("/UIController/upload.json?uploadId=" + uploadId),
			files : [ $("#" + uploadId) ],// 多个文件上传(String 或 Jquery对象均可)
			secureuri : false,
			dataType : 'json',
			data : postdata,
			success : function(data) {
				successfunc(data);
			},
			error : function(data, status, e) {
			}
		});
	 }else{
		 $("#"+uploadId).val("");
	 }
}

/**
 * 同时多选上传文件方法
 * 
 * @param formid
 */
function ajaxMultipleFileUpload(parameterData,checkval) {

	var uploadId = parameterData["uploadId"];
	var modelForder = parameterData["modelForder"] == undefined ? "foodms": parameterData["modelForder"];
	var successfunc = parameterData["successfunc"];
	var filenameimg = $("#" + uploadId).val();
	var files = parameterData["files"];
	 if(checkPic(filenameimg))
	 {
		var postdata = {};
		postdata["modelForder"] = modelForder;
		$.ajaxMutFileUpload({
			url : getRequestUrl("/UIController/upload.json?uploadId=" + uploadId),
			files : files,// 多个文件上传(String 或 Jquery对象均可)
			secureuri : false,
			dataType : 'json',
			data : postdata,
			success : function(data) {
				successfunc(data,checkval);
			},
			error : function(data, status, e) {
			}
		});
	 }else{
		 $("#"+uploadId).val("");
	 }
}

function checkPic(picFormvalue) {
	var location = picFormvalue;
	if (location == "") {
		alert("请先选择图片文件");
		return false;
	}
	var point = location.lastIndexOf(".");
	var type = location.substr(point);
	if (type == ".jpg" || type == ".gif" || type == ".JPG" || type == ".pdf"
			|| type == ".png") {
		return true;
	} else {
		alert("支持上传jpg或者png格式的图片及pdf文件");
		return false;
	}
	return true;

}



/**
 * 初始化富文本编辑器
 * 
 * @param editorid
 * @param widthval
 * @param heigthval
 * @param propertyname
 * @returns {String}
 */
function initUEditor(ueditorObj) {
	// 取得参数值
	var editorid = ueditorObj["editorid"];
	var width = ueditorObj["width"];
	var height = ueditorObj["height"];
	var propertyname = ueditorObj["propertyname"];
	var content = ueditorObj["content"];
	// 初始化编辑器位置
	var postfix = getRandomStr();
	var ueditorid = editorid + postfix;
	var editorHtml = '<script type="text/plain" id="' + ueditorid + '" name="'
			+ propertyname + '" style="width:' + width + 'px;height:' + height
			+ 'px;">' + '</script>';
	$("#" + editorid).html(editorHtml);
	$("#" + editorid).attr("ueditorid", ueditorid).attr("name", propertyname);
	// 生成编辑器
	var initUEditorObj = {};
	initUEditorObj.autoHeightEnabled = false;
	if (isNotEmpty(content)) {
		initUEditorObj.initialContent = content;
	}
	var ue = UE.getEditor("" + ueditorid + "", initUEditorObj);
	return ue;
}

/**
 * @description 生成一个六位随机串
 * @author lingyong
 * @updateAuthor lingyong
 * @returns
 */
function getRandomStr() {
	var chars = [ '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B',
			'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
			'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' ];
	var res = "";
	for (var i = 0; i < 6; i++) {
		var id = Math.ceil(Math.random() * 35);
		res += chars[id];
	}
	return res;
}

/**
 * 数据有效可用的时候返回true，否则返回false
 * 
 * @param checkData
 * @returns {Boolean}
 */
function isNotEmpty(checkData) {
	if (typeof checkData == "string")
		checkData = $.trim(checkData);
	if (typeof checkData != "undefined" && checkData != null && checkData != ""
			&& checkData != undefined) {
		return true;
	} else {
		return false
	}
}

/**
 * 页面转向--带左侧菜单
 * 
 * @param page
 */
function pageForward(page) {
	window.location.href = path + page;
}



/**
 * 页面转向
 * 
 * @param page
 */
function parentPageForward(page) {
	window.parent.location.href = path + page;
}

/**
 * 
 * @param fileName
 */
function downLoadFile(fileName) {
	var downLoadurl = path + "/UIController/download.do";
	var form = $("<form>");// 定义一个form表单
	form.attr("style", "display:none");
	form.attr("target", "_blank");
	form.attr("method", "post");
	form.attr("action", downLoadurl);
	var inputFileName = $("<input>");
	inputFileName.attr("type", "hidden");
	inputFileName.attr("name", "fileName");
	inputFileName.attr("value", fileName);
	$("body").append(form);
	form.append(inputFileName);
	form.submit();// 表单提交
	form.remove();
}
/**
*根据userid获取信息
 */

function getuserinfobyuserid(userid) {
	$.ajax({
				url : getRequestUrl("/bclient/ZlBGdInforController/getZlBTraderByTraderuser.json"),
				dataType : "json",
				data : {
					"traderuserid" : userid
				},
				success : function(result) {
					if (result.opflag) {
					  usercertifiedstatus = result.entity.certifiedstatus;
					  signed= result.entity.signed;
					  usertype = result.entity.usertype;
					}
				},
				error : function(error) {
					console.log('Error...');
				}
			});
	// 根据userid查询用户是否为自营企业end
}
