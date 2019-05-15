/**
 * 验证货币合法性，最多2位小数
 * @autor wy
 */
function isPriceNumber(_keyword) {

	if (_keyword == "0" || _keyword == "0." || _keyword == "0.0"
			|| _keyword == "0.00") {
		_keyword = "0";
		layer.alert("请正确输入,小数点后最多2位");
		$("#price").val("");
		return false;
	} else {
		var index = _keyword.indexOf("0");
		var length = _keyword.length;
		if (index == 0 && length > 1) {/* 0开头的数字串 */
			var reg = /^[0]{1}[.]{1}[0-9]{1,2}$/;
			if (!reg.test(_keyword)) {
				layer.alert("请正确输入,小数点后最多2位");
				$("#price").val("");
				return false;
			}
		} else {/* 非0开头的数字 */
			var reg = /^[1-9]{1}[0-9]{0,10}[.]{0,1}[0-9]{0,2}$/;
			if (!reg.test(_keyword)) {
				layer.alert("请正确输入,小数点后最多2位");
				$("#price").val("");
				return false;
			}
		}
	}
}
/**
 * 验证货币合法性，最多2位小数
 * @autor wy
 */
function isPriceNumberid(_keyword,id) {

	if (_keyword == "0" || _keyword == "0." || _keyword == "0.0"
			|| _keyword == "0.00") {
		_keyword = "0";
		//layer.alert("请正确输入金额,小数点后最多2位");
		$("#"+id+"").val("");
		return false;
	} else {
		var index = _keyword.indexOf("0");
		var length = _keyword.length;
		if (index == 0 && length > 1) {/* 0开头的数字串 */
			var reg = /^[0]{1}[.]{1}[0-9]{1,2}$/;
			if (!reg.test(_keyword)) {
				//layer.alert("请正确输入金额,小数点后最多2位");
				$("#"+id+"").val("");
				return false;
			}
		} else {/* 非0开头的数字 */
			var reg = /^[1-9]{1}[0-9]{0,10}[.]{0,1}[0-9]{0,2}$/;
			if (!reg.test(_keyword)) {
				//layer.alert("请正确输入金额,小数点后最多2位");
				$("#"+id+"").val("");
				return false;
			}
		}
	}
}
/**
 * 验证吨数合法性，最多3位小数
 * 
 */
function isDunNumber(_keyword,id) {

	if (_keyword == "0" || _keyword == "0." || _keyword == "0.0"
			|| _keyword == "0.00") {
		_keyword = "0";
		layer.alert("请正确输入,小数点后最多3位");
		$("#"+id+"").val("");
		return false;
	} else {
		var index = _keyword.indexOf("0");
		var length = _keyword.length;
		if (index == 0 && length > 1) {/* 0开头的数字串 */
			var reg = /^[0]{1}[.]{1}[0-9]{1,3}$/;
			if (!reg.test(_keyword)) {
				layer.alert("请正确输入,小数点后最多3位");
				$("#"+id+"").val("");
				return false;
			}
		} else {/* 非0开头的数字 */
			var reg = /^[1-9]{1}[0-9]{0,10}[.]{0,1}[0-9]{0,3}$/;
			if (!reg.test(_keyword)) {
				layer.alert("请正确输入,小数点后最多3位");
				$("#"+id+"").val("");
				return false;
			}
		}
	}
}
/**
 * 验证吨数合法性，最多3位小数
 * 
 */
function isDunNumber_only(_keyword,id) {
	var fl=true;
	if (_keyword == "0" || _keyword == "0." || _keyword == "0.0"
			|| _keyword == "0.00") {
		_keyword = "0";
		//layer.alert("请正确输入,小数点后最多3位");
		$("#"+id+"").val("");
		fl= false;
	} else {
		var index = (_keyword).indexOf('0');
		var length = _keyword.length;
		if (index == 0 && length > 1) {/* 0开头的数字串 */
			var reg = /^[0]{1}[.]{1}[0-9]{1,3}$/;
			if (!reg.test(_keyword)) {
			//	layer.alert("请正确输入,小数点后最多3位");
				$("#"+id+"").val("");
				fl= false;
			}
		} else {/* 非0开头的数字 */
			var reg = /^[1-9]{1}[0-9]{0,10}[.]{0,1}[0-9]{0,3}$/;
			if (!reg.test(_keyword)) {
			//	layer.alert("请正确输入,小数点后最多3位");
				$("#"+id+"").val("");
				fl= false;
			}
		}
	}
	return fl;
}
/**
 * 验证大于0的整数
 * 
 */
function isNumNumber(_keyword) {
	var reg = /^[1-9]\d*$/;
	if (!reg.test(_keyword)) {
		layer.alert("请输入大于0的整数");
		$("#minvolume").val("");
		return false;
	}
}