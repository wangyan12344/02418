$(function(){
	getadvlistIndex();//获取横幅广告
});
/**
 * 获取横幅广告
 * @param parentid
 * @param classnum
 * @param newsnum
 */
function getadvlistIndex(){
	$.ajax({
  		url:getRequestUrl("/HomeController/queryadvlist.json"),
    	dataType:"json",
    	data:{},
      	success:function(result){
      		debugger
      		if(result.list11 !=""){
      			
      		  var newslistHtml = $("#adneiTemplate").render(result.list11);
        		  $("#adnei").html(newslistHtml);
        		  $("#adnei").show();
      		}
      	   
      	},
      	error:function(error){
      		console.log('Error...');
      	}
   })
}

