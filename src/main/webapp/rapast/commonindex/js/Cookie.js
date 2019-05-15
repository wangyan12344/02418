 
/**
 * @author 周海峰
 * 设置cookie
 * @param name
 * @param value
 * @param expiresHours
 */

/*function addCookie(name,value,expiresHours){ 
	var cookieString=name+"="+escape(value); 
	//判断是否设置过期时间 
	if(expiresHours>0){ 
	var date=new Date(); 
	date.setTime(date.getTime+expiresHours*3600*1000); 
	cookieString=cookieString+"; expires="+date.toGMTString()+';path=/'; 
	} 
	document.cookie=cookieString; 
	} 

function getCookie(name){ 
	var strCookie=document.cookie; 
	var arrCookie=strCookie.split("; "); 
	for(var i=0;i<arrCookie.length;i++){ 
	var arr=arrCookie[i].split("="); 
	if(arr[0]==name)return arr[1]; 
	} 
	return ""; 
	} 


function deleteCookie(name){ 
	var date=new Date(); 
	date.setTime(date.getTime()-10000); 
	document.cookie=name+"=v; expires="+date.toGMTString()+';path=/'; 
	}
*/


/**
 * 获取uid
 * @returns
 */
function getCookie(name){
	var value=null;
	var arr = document.cookie.split('; ');
    for(var i = 0; i < arr.length; i++){ 
        var temp = arr[i].split('=');
        if(temp[0] == name){
        	if(temp[1]!="notLogin"){
        		value=temp[1];
        	}
        }
    }	
	return value;
}




/**
 * 触发登录
 */
function triggerLogin(){
	
	//alert("跳登录")
	var u = navigator.userAgent;
	var isAndroid = u.indexOf('Android') > -1 || u.indexOf('Adr') > -1; //android终端
	var isiOS = !!u.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/); //ios终端
	if(isAndroid){ 
		window.android.zh_toLogin();
	}else if(isiOS){
		window.location.href = 'ios://zh_toLogin';
		
	} 
	
}


function getNowFormatDate() {
    var date = new Date();
    var seperator1 = "-";
    var seperator2 = ":";
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
            /*+ " " + date.getHours() + seperator2 + date.getMinutes()
            + seperator2 + date.getSeconds();*/
    return currentdate;
}

