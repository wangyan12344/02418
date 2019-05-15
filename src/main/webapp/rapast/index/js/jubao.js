$(function(){
//	getadvlist();//获取横幅广告
	initpage();
	//更新新闻访问量+1
//	$.get(path+"/HomeController/updateVisitnum.json?zlBNews.newsid="+opid);
	
});

var classid="";

function initpage(){
	
	loadZlBWebnoticeForlast();
	
}
/**
 * 点赞
 * @returns
 */
function addpraise(newsid){
	$.get(path+"/HomeController/updatePraise.json?zlBNews.newsid="+newsid);
	queryPraiseByNewsid(newsid);
}
function queryPraiseByNewsid(newsid){
	$.ajax({
		url:getRequestUrl("/HomeController/queryPraiseByNewsid.json"),
		dataType:"json",
		data:{"zlBNews.newsid":newsid},
		success:function(data){	
			$("#newspraise").html("("+data.flag+")");	
			if(data.flag1>0){
				$("#parisehidden").show();
				$("#pariseshow").hide();
			}else{
				$("#parisehidden").hide();
				$("#pariseshow").show();
			}
		},
		error:function(error){
			console.log("error");
		}
		
	});
}
function loadZlBWebnoticeForlast(){
	$.ajax({
		url:getRequestUrl("/ipm/ZlBWebnoticeController/loadZlBWebnoticeForlast.json"),
		dataType:"json",
		data:{},
		success:function(data){	
			var addHtml = $("#newsdetailTemplate").render(data);
			$("#newsdetail").html(addHtml);			
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
		var page="/HomeController/todetail.do?opid="+id;
}
function tolistpage(){
	window.history.go( -1 );
		// pageForward("/ZlBNewsController/newslist.do");
}
function gotonewsdetail(id){
	var page="/HomeController/newsdetail.do?opid="+id;
	 pageForward(page);
}
//行业资讯链接
function goback(url,categoryid){
	if(url==''){
		pageForward("/HomeController/indexlist.do?opid="+categoryid);
	}else{
		pageForward("/HomeController/"+url+"list.do?opid="+categoryid);	
	}
	
}
//资讯链接
function goback2(){
	goback();
}

