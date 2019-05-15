$(function(){
	//getLinkForFoot();//版权友情链接
	getCount();
});
/**
 * 获取统计数据
 * @returns
 */
function getCount(){
	$.ajax({
  		url:getRequestUrl("/HomeController/getCount.json"),
    	dataType:"json",
    	data:{},
      	success:function(result){
  			$("#totalcount").html(result.entity.totalcount);
  			$("#pcount").html(result.entity.pcount);
  			$("#daycount").html(result.entity.daycount);
  			 updateCount()
      	},
      	error:function(error){
      		console.log('Error...');
      	}
   })
}
/**
 * 更新在线时间，更新当日人数
 * @returns
 */
function updateCount(){
	$.get(path+"/HomeController/updateCount.json");
//	getCount();
}
//查询通道
function getLinkForFoot()
{
	$.ajax({
  		url:getRequestUrl("/ZlBAppActivityController/loadZlBAppActivityListByType.json"),
    	dataType:"json",
    	data:{"zlBAppActivity.type":'2'},
      	success:function(result){
  			var youqingHtml = $("#youqingTemplate").render(result.list3);
  			$("#youqing").html(youqingHtml);
      	},
      	error:function(error){
      		console.log('Error...');
      	}
   })
}