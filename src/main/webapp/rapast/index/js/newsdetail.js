$(function(){
//	getadvlist();//获取横幅广告
	initpage();
	//更新新闻访问量+1
	$.get(path+"/HomeController/updateVisitnum.json?zlBNews.newsid="+opid);
	
});

var classid="";

function initpage(){
	
	getnewsdetailBynewsid();
	
}
/**
 * 点赞
 * @returns
 */
function addpraise(newsid){
	$.ajax({
		url:getRequestUrl("/HomeController/updatePraise.json"),
		dataType:"json",
		data:{"zlBNews.newsid":newsid},
		success:function(data){	
			queryPraiseByNewsid(newsid);
		},
		error:function(error){
			console.log("error");
		}
		
	});
	
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
function getnewsdetailBynewsid(){
	$.ajax({
		url:getRequestUrl("/HomeController/detailed.json"),
		dataType:"json",
		data:{"zlBNews.newsid":opid},
		success:function(data){	
			$("#categoryname").html("<img src='<%=request.getContextPath() %>/rapast/index/images/icon2.jpg' width='23' height='16' />"+data.category.categoryname);
			$("#parentcategoryname").html(data.parentcategory.categoryname);
			var addHtml = $("#newsdetailTemplate").render(data);
			$("#newsdetail").html(addHtml);			
			classid=data.entity.categoryid;
			queryPraiseByNewsid(data.entity.newsid);
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

