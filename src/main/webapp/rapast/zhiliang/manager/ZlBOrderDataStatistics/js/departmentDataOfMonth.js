
var SHORT_INTERVAL_TIME = 5000;

var LONG_INTERVAL_TIME = 1000*60*60*2;  //2小时
var timeFn = null;
var mapStack = [];
var provincearea = [];
var deptmentname = [];
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



 
 

 


/**
 * @param areaname
 * @returns
 */
function queryOrderDataForMapBar(id) {
	$.ajax({
		url:getRequestUrl("/ZlBDepartmentUserController/queryOrderDataForMapBar.json"),
		dataType:"json",
		data:{},
		success:function(data){
			if(data.zlBDepartmentList.length>0){
				var timelist=[];
			
				for (var i=0,len=data.zlBDepartmentList.length;i<len;i++) {
					deptmentname[i]=data.zlBDepartmentList[i].departmentname;//
				}
				for (var j=0,lend	=data.monthslist.length;j<lend;j++) {
					timelist[j]=data.monthslist[j].months;
				}
				var datas=[];
				for (var m=0,lent=data.zlBDepartmentList.length;m<lent;m++) {
					
				
					var datan = {};
					datan["name"] =data.zlBDepartmentList[m].departmentname;
					datan["type"] ='bar';
					var deparry=[];
					var v='0';
					for (var ss=0,lenss=data.monthslist.length;ss<lenss;ss++) {
						
						for (var n=0,lenm=data.zlBDepartmentList[m].zlBDepartmentlist.length;n<lenm;n++) {
							if(data.monthslist[ss].months==data.zlBDepartmentList[m].zlBDepartmentlist[n].stime){
								v=data.zlBDepartmentList[m].zlBDepartmentlist[n].newsnum;
							} 
							 
						}
						deparry[ss]=v;
						n=0;
						v='0';
					}
					
					datan["data"] =deparry;
					
					
					deparry=[];
					datas.push(datan);
					datan = {};
				}
			
			
					
				
				
			}
			selectTraderDistributeProvinceEchar('投稿数量统计',deptmentname,timelist,datas);
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
function selectTraderDistributeProvinceEchar(title,deptmentnames,datatime,datasseries){
	var myChart1 = echarts.init(document.getElementById('traderDistribute'));
	option1 = {
		    color: ['#003366', '#006699', '#4cabce', '#e5323e'],
		    tooltip: {
		        trigger: 'axis',
		        axisPointer: {
		            type: 'shadow'
		        }
		    },
		    legend: {
		        data: deptmentnames
		      
		    },
		  
		    toolbox: {
		        show: true,
		        orient: 'vertical',
		        left: 'right',
		        top: 'center',
		        feature: {
		            magicType: {show: true, type: ['line', 'bar', 'stack', 'tiled']},
		            restore: {show: true},
		            saveAsImage: {show: true}
		        }
		    },
		    dataZoom: [{
	            startValue: datatime[0]
	        }, {
	            type: 'inside'
	        }],
		    calculable: true,
		    xAxis: [
		        {
		            type: 'category',
		            axisTick: {show: false},
		            data: datatime
		        }
		    ],
		    yAxis: [
		        {
		            type: 'value'
		        }
		    ],
		    series: datasseries
		};
	myChart1.setOption(option1);
}




