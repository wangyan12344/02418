$(function(){
	getadvlist();//获取横幅广告
	initpage();
	//更新新闻访问量+1
	$.get(path+"/ZlBNewsController/updateVisitnum.json?zlBNews.newsid="+opid);
});


function initpage(){
	
	getnewsdetailBynewsid();
		
}

function getnewsdetailBynewsid(){
	$.ajax({
		url:getRequestUrl("/ZlBNewsController/detailed.json"),
		dataType:"json",
		data:{"zlBNews.newsid":opid},
		success:function(data){	
			$("#categoryname").html(data.category.categoryname);
			var addHtml = $("#formTemplate").render(data.entity);
			$("#newsdate").html(addHtml);			
		},
		error:function(error){
			console.log("error");
		}
		
	});
	
}
/**
 * 跳转新闻详细
 * @param id
 */
function gotonewsdetail(id,p){
	if(p<=syspermissions){	
		var page="/ZlBNewsController/todetail.do?opid="+id;
		 pageForward(page);
		}else{
			layer.alert('阅读权限不足，请联系管理员',3);
		}
}
function tolistpage(){
	window.history.go( -1 );
		// pageForward("/ZlBNewsController/newslist.do");
	
}

//行业资讯链接
function goback(){
	pageForward("/ZlBNewsController/newslist.do?opid="+"");
}
//资讯链接
function goback2(){
	goback();
}

