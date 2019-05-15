
var SHORT_INTERVAL_TIME = 5000;

var LONG_INTERVAL_TIME = 1000*60*60*2;  //2小时

var XaxisForYear = [];

var timeformat = null;
var chart =  null;
$(function(){
	bindevent();
	
	var startmonth = $("#smonth").val();
	var endmonth = $("#emonth").val();
	//查询交易商信息
	choiceTime();
	graphselection();
	
	timeformat='yyyy-MM';

	queryTraderData(startmonth,endmonth);
});
function bindevent(){
	
	$("#syear").jeDate({
		format: "YYYY"
	});
	$("#smonth").jeDate({
		format: "YYYY-MM"
	});
	    
	$("#eyear").jeDate({
		format: "YYYY"
	});
	$("#emonth").jeDate({
		format: "YYYY-MM"
	});
	
	
	$("#reset_btn").bind('click',function(){
		chart='bar';
		timeformat = 'yyyy-MM';
		
	});
	
	
	$("#search_btn").bind('click',function(){

		var startyear = $("#syear").val();
		var endyear = $("#eyear").val();

		var startmonth = $("#smonth").val();
		var endmonth = $("#emonth").val();
		var choice = $("#choice").val();
		
			if(startyear != ""||endyear != "")
			{
			
				if(startmonth != ""||endmonth != "")
				{
					queryTraderData(startmonth,endmonth);
				}
				else{
					queryTraderData(startyear,endyear);
				}
			
			}else
			{
				if(choice==0)
				{
					queryTraderData(startyear,endyear);
				}else if(choice==1)
				{
					queryTraderData(startmonth,endmonth);
				}else
				{
					queryTraderData(startmonth,endmonth);
				}
				
			}
		});
	
}

function choiceTime()
{
	var choice = $("#choice").val();
	if(choice==0)
	{
		$("#month").css("display","none");
		$("#year").css("display","block");
		$("#smonth").val("");
		$("#emonth").val("");
		timeformat = 'yyyy';
	}else if(choice==1)
	{
		$("#year").css("display","none");
		$("#month").css("display","block");
		$("#syear").val("");
		$("#eyear").val("");
		timeformat = 'yyyy-MM';
	}else{
		timeformat = 'yyyy-MM';
	}
}

function graphselection()
{

	var selection = $("#selection").val();
	if(selection==0)
	{
		chart='line';
	}else if(selection==1)
	{
		chart='bar';
	}else
	{
		chart='bar';
	}
		
}




//按时间查询交易订单
//按年查询信息
var ordernumtoyear=[];
var ordersummonytoyear=[];
var ordersumtonnagetoyear=[];

function queryTraderData(startyear,endyear)
{

	$.ajax({
		url:getRequestUrl("/ZlBOrderDataStatisticsControler/queryOrderDataForTime.json"),
		dataType:"json",
		data:{"traderid":traderid,"timeformat":timeformat,"startTime":startyear,"endTime":endyear},
		success:function(data){
			
			
			for (var i=0,len=data.OrderNumToTimeList.length;i<len;i++) {
				ordernumtoyear[i]={name:data.OrderNumToTimeList[i].name,value:data.OrderNumToTimeList[i].value};
				XaxisForYear[i]=data.OrderNumToTimeList[i].name;
			}
			for (var i=0,l=data.OrderSumMoneyToTimeList.length;i<l;i++){
				ordersummonytoyear[i]={name:data.OrderSumMoneyToTimeList[i].name,value:data.OrderSumMoneyToTimeList[i].value}
			}
			
			for (var i=0,len=data.OrderSumTonnageToTimeList.length;i<len;i++) {
				ordersumtonnagetoyear[i]={name:data.OrderSumTonnageToTimeList[i].name,value:data.OrderSumTonnageToTimeList[i].value}
			}
			initMainTimeBar(tradername,XaxisForYear,ordernumtoyear,ordersummonytoyear,ordersumtonnagetoyear);
		},
		error:function(error){
			alert("error");
		}
	});
}



/**
 * 初始化置粮网整体情况柱形图
 */

function initMainTimeBar(tradername,XaxisForTime,ordernumtotime,ordersummonytotime,ordersumtonnagetotime){
	
	var myChart = echarts.init(document.getElementById('saleroomEchar'));
	option = {
			
			title: {
                text: tradername+'交易商信息柱状图',
		        textStyle:{color:'#708090',fontSize:'10',fontWeight:'lighter'}
            },
		    tooltip : {
		        trigger: 'axis',
		        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
		            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
		        }
		    }, 
		    xAxis : {
			    	type: 'category',
			    	name: '时间',
		            axisTick: { 
		            		alignWithLabel: true
		            	},
		            data : XaxisForTime,
		    },
		    yAxis : {
			    	type: 'value',
		            position: 'left',
		            axisLine: {
		                lineStyle: {
		                    color: '#675bba'
		                }
		            }
	            },
            series: [

		        {
		            name:tradername+'的交易订单数',
		            type:chart,
		            data:ordernumtotime
		        },
		        {
		            name:tradername+'的交易金额(万元)',
		            type: chart,
		            yAxisIndex: 0,
		            data:ordersummonytotime
		        },
		        {
		            name:tradername+'的交易吨数(万吨)',
		            type:chart,
		            data:ordersumtonnagetotime
		        }
		    
            	]
        };
	myChart.clear();
	myChart.setOption(option, true);
	XaxisForYear = [];
	XaxisForMonth = [];
	//按年查询信息
	ordernumtoyear=[];
	ordersummonytoyear=[];
	ordersumtonnagetoyear=[];
}



function GoToTarderPage()
{
	var page = "/rapast/zhiliang/manager/ZlBOrderDataStatistics/ZlBOrderDataStatisticsTraderBar_list.jsp";
	pageForward(page);
}


