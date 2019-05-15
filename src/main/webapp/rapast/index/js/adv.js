$(function(){
	getadvlistIndex_right();//获取横幅广告
});
/**
 * 获取横幅广告
 * @param parentid
 * @param classnum
 * @param newsnum
 */
function getadvlistIndex_right(){
	$.ajax({
  		url:getRequestUrl("/HomeController/queryadvlist.json"),
    	dataType:"json",
    	data:{},
      	success:function(result){
//      		var newslistHtml = $("#ad1Template").render(result.list1);
//      		$("#ad1").html(newslistHtml);
//      		var newslistHtml = $("#ad2Template").render(result.list2);
//      		$("#ad2").html(newslistHtml);
      		var newslistHtml = $("#ad3Template").render(result.list3);
      		$("#ad3").html(newslistHtml);
      		var newslistHtml = $("#ad3Template").render(result.list4);
      		$("#ad4").html(newslistHtml);
      		var newslistHtml = $("#ad3Template").render(result.list5);
      		$("#ad5").html(newslistHtml);
      		var newslistHtml = $("#ad3Template").render(result.list6);
      		$("#ad6").html(newslistHtml);
      		var newslistHtml = $("#ad3Template").render(result.list7);
      		$("#ad7").html(newslistHtml);
      		var newslistHtml = $("#ad3Template").render(result.list8);
      		$("#ad8").html(newslistHtml);
      		var newslistHtml = $("#ad4Template").render(result.list9);
      		$("#ad9").html(newslistHtml);
      	   
      	},
      	error:function(error){
      		console.log('Error...');
      	}
   })
}

