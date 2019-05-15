
var SHORT_INTERVAL_TIME = 5000;

var LONG_INTERVAL_TIME = 1000*60*60*2;  //2小时
var timeFn = null;
var mapStack = [];
var provincearea = [];
var cityarea = [];
$(function(){
	//设置当前时间
	setInterval(function(){
		var date = getCurHourAndMinute().split("&&");
		$("#hour").html(date[0]);
		$("#minute").html(date[1]);
	},1000);
	
	//查询各省交易商数量
	queryOrderDataForMapBar();
	
	
	
});


//查询各省份交易商数量

//省级信息
var traderarr=[];
var orderarr=[];
var ordersummoneyforprovince=[];
var ordersumtonnageforprovince=[];
//市级信息
var citytraderarr=[];
var cityorderarr=[];
var ordersummoney=[];
var ordersumtonnage=[];
 
 

//市级信息 柱状图
var tradernum=[];
var ordernum=[];
var ordersummoneyforbar=[];
var ordersumtonnageforbar=[];
/**
 * 市级交易订单相关信息 柱状图
 * @param areaname
 * @returns
 */
function queryOrderDataForMapBar() {
	$.ajax({
		url:getRequestUrl("/ZlBDepartmentController/queryOrderDataForMapBar.json"),
		dataType:"json",
		data:{},
		success:function(data){
			if(data.zlBDepartmentList.length>0){
				for (var i=0,len=data.zlBDepartmentList.length;i<len;i++) {
					tradernum[i]={name:data.zlBDepartmentList[i].departmentname,value:data.zlBDepartmentList[i].newsnum}
//					ordernum[i]={name:data.zlBDepartmentList[i].departmentname,value:data.zlBDepartmentList[i].newsnum}
					cityarea[i]=data.zlBDepartmentList[i].departmentname;
					ordersummoneyforbar[i]={name:data.zlBDepartmentList[i].departmentname,value:data.zlBDepartmentList[i].newsnum}
//					ordersumtonnageforbar[i]={name:data.zlBDepartmentList[i].departmentname,value:data.zlBDepartmentList[i].newsnum}
				}
			}
			initMainAreaBar('部门投稿数量统计',cityarea,tradernum);
			selectTraderDistributeProvinceEchar('部门投稿数量统计',cityarea,ordersummoneyforbar);
//			initMainzhexianBar('部门投稿数量统计',cityarea,ordersummoneyforbar);
		},
		error:function(error){
			alert("error");
		}
	});
}



/**
 * 饼状图
 * @param title
 * @param area
 * @param osummoney
 * @returns
 */
function selectTraderDistributeProvinceEchar(title,area,osummoney){
	var myChart1 = echarts.init(document.getElementById('traderDistribute'));
	option1 = {
		    title : {
		        text: title,
		        x:'center'
		    },
		    tooltip : {
		        trigger: 'item',
		        formatter: "{a} {b} <br/> {c} ({d}%)"
		    },   toolbox: {
		        show : true,
		        feature : {
		            mark : {show: true},
		            dataView : {show: true, readOnly: false},
		            magicType : {
		                show: true, 
		                type: ['pie', 'funnel'],
		                option: {
		                    funnel: {
		                        x: '25%',
		                        width: '50%',
		                        funnelAlign: 'left',
		                        max: 1548
		                    }
		                }
		            },
		            restore : {show: true},
		            saveAsImage : {show: true}
		        }
		    },
		    legend: {
		        orient: 'vertical',
		        left: 'left',
		        data: area
		    },
		    series : [{
		            name: '投稿数量',
		            type: 'pie',
		            radius : '55%',
		            center: ['50%', '60%'],
		            data:osummoney,
		            itemStyle: {
		                emphasis: {
		                    shadowBlur: 10,
		                    shadowOffsetX: 0,
		                    shadowColor: 'rgba(0, 0, 0, 0.5)'
		                }
		            }
		        }]
};
	myChart1.setOption(option1);
}
/**
 * 初始化交易订单柱形图
 */

function initMainAreaBar(bartitle,area,tnum){
	var myChart3 = echarts.init(document.getElementById('saleroomEchar'));
	var option3 = {
			legend: {
		        data: ['投稿数量']
		    },
			 
		    tooltip: {/*
		        trigger: 'item',
                formatter:function(params){
               	 var res = params.name+'<br/>';  
                    var myseries = option.series;  
                    for (var i = 0; i < myseries.length; i++) {  
                        for(var j=0;j<myseries[i].data.length;j++){  
                            if(myseries[i].data[j].name==params.name){  
                                res+=myseries[i].name +' : '+myseries[i].data[j].value+'</br>';  
                            }  
                        }  
                    }  
                    return res;  
               },
		    */},   toolbox: {
		        show : true,
		        feature : {
		            mark : {show: true},
		            dataView : {show: true, readOnly: false},
		            magicType : {
		                show: true, 
		                type: ['pie', 'funnel'],
		                option: {
		                    funnel: {
		                        x: '25%',
		                        width: '50%',
		                        funnelAlign: 'left',
		                        max: 1548
		                    }
		                }
		            },
		            restore : {show: true},
		            saveAsImage : {show: true}
		        }
		    },
		    grid: {
		        left: '3%',
		        right: '4%',
		        bottom: '3%',
		        containLabel: true
		    },
		    xAxis : {
			    	type: 'category',
		            axisTick: {
	            		alignWithLabel: true
	            	},
		            data : area
		    },
		    yAxis : [{
		    	type: 'value',
	            position: 'left',
	            axisLine: {
	                lineStyle: {
	                    color: '#675bba'
	                }
	            }
            }],
            series: [
            	{
		            name:'投稿数量',
		            type:'bar',
		            stack: '总量',
					color:['#eb8060'],
		            label: {
		                normal: {
		                    position: 'insideRight'
		                }
		            },
		            data:tnum
		        }
		    
            	]
        };
	myChart3.setOption(option3, true);
}

/**
 * 初始化交易订单柱形图
 */

function initMainzhexianBar(bartitle,area,tnum){
	var myChart4 = echarts.init(document.getElementById('zhexianEchar'));
	option4 = {
		    tooltip : {
		        trigger: 'axis'
		    },
		    legend: {
		        data:area
		    },
		    toolbox: {
		        show : true,
		        feature : {
		            mark : {show: true},
		            dataView : {show: true, readOnly: false},
		            magicType : {show: true, type: ['line', 'bar', 'stack', 'tiled']},
		            restore : {show: true},
		            saveAsImage : {show: true}
		        }
		    },
		    calculable : true,
		    xAxis : [
		        {
		            type : 'category',
		            boundaryGap : false,
		            data : ['周一','周二','周三','周四','周五','周六','周日']
		        }
		    ],
		    yAxis : [
		        {
		            type : 'value'
		        }
		    ],
		    series : [
		        {
		            name:'邮件营销',
		            type:'line',
		            stack: '总量',
		            data:[120, 132, 101, 134, 90, 230, 210]
		        },
		        {
		            name:'联盟广告',
		            type:'line',
		            stack: '总量',
		            data:[220, 182, 191, 234, 290, 330, 310]
		        },
		        {
		            name:'视频广告',
		            type:'line',
		            stack: '总量',
		            data:[150, 232, 201, 154, 190, 330, 410]
		        },
		        {
		            name:'直接访问',
		            type:'line',
		            stack: '总量',
		            data:[320, 332, 301, 334, 390, 330, 320]
		        },
		        {
		            name:'搜索引擎',
		            type:'line',
		            stack: '总量',
		            data:[820, 932, 901, 934, 1290, 1330, 1320]
		        }
		    ]
		};
	myChart4.setOption(option4, true);
}


