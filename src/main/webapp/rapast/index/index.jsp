<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="x-ua-compatible" content="IE=8,9,10" >
<title>葫芦岛银行</title>
<link href="<%=request.getContextPath() %>/rapast/index/css/lrtk.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/rapast/index/css/style.css" rel="stylesheet" type="text/css" />
<%@ include file="/rapast/commonindex/jsp/commonJs.jsp"%>
<script type="text/javascript" src="<%=request.getContextPath() %>/rapast/index/js/index.js"></script>
<script src="<%=request.getContextPath() %>/rapast/index/layui/layui.js" charset="utf-8"></script>
<script type="text/x-jsrender" id="newspicTemplate">
 	<div  onclick="gotonewsdetail('{{:newsid}}','{{:classurl}}')"><img src="{{:mainimgpath}}" ></div>
</script>	
<script type="text/x-jsrender" id="ad10Template">
<a href="{{:imgurl}}" >
{{if img!=""}}
<img src="{{:img}}" width="1400" height="180" >
{{else}}
<img src="<%=request.getContextPath() %>/rapast/index/images/wutu1.png" width="1400" height="180"  />
{{/if}}
</a>
</script>
<script type="text/x-jsrender" id="ad1Template">
<a href="{{:imgurl}}"><img src="{{:img}}"  width="1077" height="278" ></a>
</script>
</head>

<body>
<div id="ads" style="margin:auto; display:none; width:1400px; top:0px; height:0px; border:solid 0px #000; background-color:#fafafa; overflow:hidden; text-align:center;">
</div>
<%@ include file="/rapast/index/top.jsp"%>
<div class="banner_box">
  <div class="banner layui-carousel"   id="testbanner">
  					<div carousel-item  id="ad1"  >
				 	 </div>
 </div>
   
 
  <div class="notice">
    <div class="notice1"> 您好！<br />
      今天是<span id="today"></span><br />
    <span id="time"></span></div>
  
  </div>
</div>
<div class="box">
  <div class="box_left">
    <div class="ldfl">
      <dl>
        <dd><img src="<%=request.getContextPath() %>/rapast/index/images/icon2.jpg" width="23" height="16" />行领导分工</dd>
        <dt>
        <select class="butn1"  id="select_ld"  onchange="gotoweb('1',this.value)">
        </select>
        </dt>
      </dl>
      <dl>
        <dd><img src="<%=request.getContextPath() %>/rapast/index/images/icon2.jpg" width="23" height="16" />各部室网页</dd>
        <dt><select class="butn1" id="select_bs" onchange="gotoweb('2',this.value)">
        </select></dt>
      </dl>
      <dl>
        <dd><img src="<%=request.getContextPath() %>/rapast/index/images/icon2.jpg" width="23" height="16" />分支行网页</dd>
        <dt><select class="butn1" id="select_fh" onchange="gotoweb('3',this.value)">
        </select></dt>
      </dl>
    </div>
    <div class="left_public">
      <div class="left_public_bt" onclick="gotopagebytype('','5','')" ><b><a onclick="return false;"  href="javascript:void(0)">更多></a></b><span id="zhongyaoname"></span></div>
      <div class="left_public_nr height115">
        <ul id="zhongyao">
   
        </ul>
      </div>
    </div>
    <div class="left_public">
      <div class="left_public_bt" onclick="gotopagebytype('','6','')"><b><a  onclick="return false;"  href="javascript:void(0)">更多></a></b><span id="redianname"></span></div>
      <div class="left_public_nr height175">
        <ul id="redian">
       
        </ul>
      </div>
    </div>
  <%@ include file="/rapast/index/advindex.jsp"%>
  </div>
  <div class="box_middle">
    <div class="jdt_box">
      
      <div class="jdt_news">
      <div id="zSlider">
		</div>
       <!--  <ul id="ishot">

        </ul> -->
      </div>
    </div>
    <div class="news_box">
      <div class=" news_public left">
      <div class="news_public_bt" onclick="gotopagebytype('','7','')"><b><a href="javascript:void(0)">更多></a></b><span id="zonghangyaowenname"></span></div>
      <div class="news_public_nr height115">
        <ul id="zonghangyaowen">
         
        </ul>
      </div>
    </div>
      <div class=" news_public right">
      <div class="news_public_bt" onclick="gotopagebytype('','8','')"><b><a href="javascript:void(0)">更多></a></b><span id="bushidongtainame"></span></div>
      <div class="news_public_nr height115">
        <ul id="bushidongtai">
         
        </ul>
      </div>
    </div>
    </div>
    <div class="banner2 layui-carousel"  id="testbanner760">
    <div carousel-item=""    id="ad2">
  <%--   <img src="<%=request.getContextPath() %>/rapast/index/images/gg1.jpg" width="760" height="165" /> --%>
    </div>
    </div>
    <div class="news_box">
      <div class=" news_public left">
      <div class="news_public_bt" onclick="gotopagebytype('','9','')"><b><a href="javascript:void(0)">更多></a></b><span id="dangtuanjianshename"></span></div>
      <div class="news_public_nr height115">
        <ul id="dangtuanjianshe">
        
        </ul>
      </div>
    </div>
      <div class=" news_public right">
      <div class="news_public_bt" onclick="gotopagebytype('','10','')"><b><a href="javascript:void(0)">更多></a></b><span  id="jicengfengcainame"><img src="<%=request.getContextPath() %>/rapast/index/images/icon2.jpg" width="23" height="16" />基层风采</span></div>
      <div class="news_public_nr height115">
        <ul id="jicengfengcai">
         
        </ul>
      </div>
    </div>
    </div>
    <div class="news_box">
      <div class=" news_public left">
      <div class="news_public_bt" onclick="gotopagebytype('','11','')"><b><a href="javascript:void(0)">更多></a></b><span  id="hangyeguancaname"></span></div>
      <div class="news_public_nr height115">
        <ul id="hangyeguanca">
        </ul>
      </div>
    </div>
      <div class=" news_public right">
      <div class="news_public_bt" onclick="gotopagebytype('','12','')"><b><a href="javascript:void(0)">更多></a></b><span  id="yuangongtiandiname"></span></div>
      <div class="news_public_nr height115">
        <ul id="yuangongtiandi">
        </ul>
      </div>
    </div>
    </div>
    
  </div>
  <div class="box_right">
    <div class="search"><input type="text" class="input" name="newstitle" id="newskey" placeholder="请输入关键字" />
        <input type="" name="button" id="button"  class="butn"  onclick="gotosearch()"/>
    </div>
    <div class="r_notice">
      <div class="r_notice_bt" id="tongzhigonggaoname">通知公告</div>
      <div class="r_notice_nr1">
        <ul id="tongzhigonggao">
          
<!--           <li><span>2018-07-02</span><a href="javascript:void(0)">绥中支行冠名绥中县第二届</a></li>
          <li><span>2018-07-02</span><a href="javascript:void(0)">总行全面开展集中诉讼工作 </a></li>
          <li><span>2018-07-02</span><a href="javascript:void(0)">总行举办“十九大后的宏观... </a></li>
          <li><span>2018-07-02</span><a href="javascript:void(0)">市银监局相关领导到我行进... </a></li>
          <li><span>2018-07-02</span><a href="javascript:void(0)">绥中支行冠名绥中县第二届“...</a></li> -->
        </ul>
      </div>
      <div class="r_notice_nr2"></div>
    </div>
    <div class="left_public">
      <div class="left_public_bt" onclick="gotopagebytype('','2','')"><b><a href="javascript:void(0)">更多></a></b><span id="zonghangname"></span></div>
      <div class="left_public_nr height115">
        <ul id="zonghanggongzuo">
         
        </ul>
      </div>
    </div>
    <div class="left_public">
      <div class="left_public_bt" onclick="gotopagebytype('','3','')"><b><a href="javascript:void(0)">更多></a></b><span id="shijiudaname"></span></div>
      <div class="left_public_nr height340">
        <ul id="shijiuda">
          
        </ul>
      </div>
    </div>
    <!--警钟长鸣  -->
    <div class="left_public">
      <div class="left_public_bt" onclick="gotopagebytype('','4','')"><b><a href="javascript:void(0)">更多></a></b><span id="jingzhongname"></span></div>
      <div class="left_public_nr height255">
        <ul id="jingzhong">
        </ul>
      </div>
      <div class="gg2" id="ad13"></div>
    </div>
  
  </div>
</div>
<%@ include file="/rapast/index/foot.jsp"%>
</body>
</html>
<script type="text/javascript">
layui.use(['carousel', 'form'], function(){
  var carousel = layui.carousel
  ,form = layui.form;
  //图片轮播
   carousel.render({elem: '#testbanner760',width: '760px' ,height: '130px' ,interval: 5000 });
   carousel.render({elem: '#testbanner',width: '1077px' ,height: '214px' ,interval: 5000 });
});
</script>
