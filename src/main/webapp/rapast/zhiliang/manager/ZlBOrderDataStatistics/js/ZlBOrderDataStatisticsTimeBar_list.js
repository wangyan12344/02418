
var SHORT_INTERVAL_TIME = 5000;

var LONG_INTERVAL_TIME = 1000*60*60*2;  //2小时

var XaxisForYear = [];
var XaxisForMonth = [];

var chart =  null;
$(function(){
	bindevent();
	
	var startmonth = $("#smonth").val();
	var endmonth = $("#emonth").val();
	//查询各省交易商数量
	queryOrderDataByMonth(startmonth,endmonth);
	choiceTime();
	graphselection();
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
					queryOrderDataByMonth(startmonth,endmonth);
				}
				else{
					queryOrderDataByYear(startyear,endyear);
				}
			
			}else
			{
				if(choice==0)
				{
					queryOrderDataByYear(startyear,endyear);
				}else if(choice==1)
				{
					queryOrderDataByMonth(startmonth,endmonth);
				}else
				{
					queryOrderDataByMonth(startmonth,endmonth);
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
	}else if(choice==1)
	{
		$("#year").css("display","none");
		$("#month").css("display","block");
		$("#syear").val("");
		$("#eyear").val("");
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

//按月查询信息
var ordernumtomonth=[];
var ordersummonytomonth=[];
var ordersumtonnagetomonth=[];

function queryOrderDataByYear(startyear,endyear)
{

	$.ajax({
		url:getRequestUrl("/ZlBOrderDataStatisticsControler/queryOrderDataByYear.json"),
		dataType:"json",
		data:{"startTime":startyear,"endTime":endyear},
		success:function(data){
			
			
			for (var i=0,len=data.OrderNumToYearList.length;i<len;i++) {
				ordernumtoyear[i]={name:data.OrderNumToYearList[i].name,value:data.OrderNumToYearList[i].value};
				XaxisForYear[i]=data.OrderNumToYearList[i].name;
			}
			for (var i=0,l=data.OrderSumMonyToYearList.length;i<l;i++){
				ordersummonytoyear[i]={name:data.OrderSumMonyToYearList[i].name,value:data.OrderSumMonyToYearList[i].value}
			}
			
			for (var i=0,len=data.OrderSumTonnageToYearList.length;i<len;i++) {
				ordersumtonnagetoyear[i]={name:data.OrderSumTonnageToYearList[i].name,value:data.OrderSumTonnageToYearList[i].value}
			}
			initMainTimeBar('年',XaxisForYear,ordernumtoyear,ordersummonytoyear,ordersumtonnagetoyear);
		},
		error:function(error){
			alert("error");
		}
	});
}

function queryOrderDataByMonth(startmonth,endmonth) {
		
		$.ajax({
			url:getRequestUrl("/ZlBOrderDataStatisticsControler/queryOrderDataByMonth.json"),
			dataType:"json",
			data:{"startTime":startmonth,"endTime":endmonth},
			success:function(data){
				
				for (var i=0,len=data.OrderNumToMonthList.length;i<len;i++) {
					ordernumtomonth[i]={name:data.OrderNumToMonthList[i].name,value:data.OrderNumToMonthList[i].value}
					
					XaxisForMonth[i]=data.OrderNumToMonthList[i].name;
				}
				for (var i=0,l=data.OrderSumMonyToMonthList.length;i<l;i++){
					ordersummonytomonth[i]={name:data.OrderSumMonyToMonthList[i].name,value:data.OrderSumMonyToMonthList[i].value}
				}
				
				for (var i=0,len=data.OrderSumTonnageToMonthList.length;i<len;i++) {
					ordersumtonnagetomonth[i]={name:data.OrderSumTonnageToMonthList[i].name,value:data.OrderSumTonnageToMonthList[i].value}
				}

				initMainTimeBar('月',XaxisForMonth,ordernumtomonth,ordersummonytomonth,ordersumtonnagetomonth);
			},
			error:function(error){
				alert("error");
			}
		});
		
		
	
}



/**
 * 初始化置粮网整体情况柱形图
 */

function initMainTimeBar(time,XaxisForTime,ordernumtotime,ordersummonytotime,ordersumtonnagetotime){
	
	var myChart = echarts.init(document.getElementById('saleroomEchar'));
	option = {
		    color: ['#003366', '#4cabce', '#e5323e'],
			title: {
                text: time+'份交易订单信息柱状图',
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
			    	name: time+'份',
		            axisTick: { 
		            		alignWithLabel: true
		            	},
		            data : XaxisForTime,
		    },
		    yAxis : {
			    	type: 'value',
		            name: '交易金额',
		            position: 'left',
		            axisLine: {
		                lineStyle: {
		                    color: '#675bba'
		                }
		            },
		            axisLabel: {
		                formatter: '{value} 万元'
		            }
	            },
            series: [

		        {
		            name:time+'交易订单数',
		            type:chart,
		            barGap: 0,
		            data:ordernumtotime
		        },
		        {
		            name:time+'交易金额(万元)',
		            type: chart,
		            yAxisIndex: 0,
		            data:ordersummonytotime
		        },
		        {
		            name:time+'交易吨数(万吨)',
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

	//按月查询信息
	ordernumtomonth=[];
	ordersummonytomonth=[];
	ordersumtonnagetomonth=[];
}
//除法函数，用来得到精确的除法结果
//说明：javascript的除法结果会有误差，在两个浮点数相除的时候会比较明显。这个函数返回较为精确的除法结果。
//调用：accDiv(arg1,arg2)
//返回值：arg1除以arg2的精确结果
function accDiv(arg1, arg2) {
	var s1 = arg1.toString();
	var s2 = arg2.toString();
	var m = 0;
	try {
		m = s2.split('.')[1].length;
	} catch (e) {
	}
	try {
		m -= s1.split('.')[1].length;
	} catch (e) {
	}

	return (s1.replace('.', '') - 0) / (s2.replace('.', '') - 0)
			* Math.pow(10, m);
}