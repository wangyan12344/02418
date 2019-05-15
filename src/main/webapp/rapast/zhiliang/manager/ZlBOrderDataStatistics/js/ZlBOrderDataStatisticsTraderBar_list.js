$(function(){
	initPage();
	search();
} );

var pageIndex;
var sort='COUNT(1) DESC';
/**
 *初始化页面
 */
function initPage() {
	bindevent();
	queryDataList();
	
}

/**
 * 查询订单列表
 * @param 
 */
function search(){
	$("#search_btn").bind('click',queryDataList);
}

function sorychang()
{
	var sortval = $("#sort").val();
	if(sortval =='0')
	{
		sort='COUNT(1) ASC';
	}else if(sortval =='1'){
		sort='SUM(B.ordertotalamount) ASC';
	}else if(sortval =='2'){
		sort='SUM(B.orderamount) ASC';
	}else if(sortval =='3'){
		sort='COUNT(1) DESC';
	}else if(sortval =='4'){
		sort='SUM(B.ordertotalamount) DESC';
	}else if(sortval =='5'){
		sort='SUM(B.orderamount) DESC';
	}else{
		sort='COUNT(1) DESC';
	}
}

/**
 * 根据表单分页条件查询
 */
function queryDataList(){
		pageIndex=1;
	var tradername = $("#tradername").val();
		var parameterData = {
				url:getRequestUrl("/ZlBOrderDataStatisticsControler/queryOrderDataTOTraderIDForPageList.json"),
				successfunc:renderListDataFun,
				customArray:{"tradername":tradername,"sort":sort},
				pageller:"pagefoot",
				pageIndex:pageIndex,
				pageSize:20,
				isAsync:false
		};
		pageBarFortable(parameterData)
				
	
}

/**
 * 列表查询的回调渲染
 */
function renderListDataFun(result){	
	$("#dataListId").html(
		$("#dataListTemplate").render(result)
	);
	$('.tablelist tbody tr:odd').addClass('odd');
}

/**
 * 初始化id为formbody的元素内的验证方法 下拉框样式 时间样式
 */
function bindevent(){
	bindValidateEvent("formbody");
	
  
	$("#gdtype").uedSelect({
		
		width:80
	});
	$(".select1").uedSelect({
		width :100			  
	});	
	$(".select2").uedSelect({
		width :230			  
	});	
	
	$('#tradername').bind('keyup', function(event) {  
		if (event.keyCode == "13") {  
			$("#search_btn").click();  
		}  
	});
	
}

function GoToTarderPage(traderid,tradername)
{
	var page = "/rapast/zhiliang/manager/ZlBOrderDataStatistics/ZlBOrderDataStatisticsTimeBarForTrader_list.jsp?traderid="+traderid+"&tradername="+tradername;
	pageForward(page);
}

