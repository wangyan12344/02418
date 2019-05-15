<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
		<!--底部菜单栏开始-->
	 	 <div data-am-widget="navbar" class="am-navbar am-cf am-navbar-default " id="">
	      	<ul class="am-navbar-nav am-cf am-avg-sm-4"  style="border-top: 1px solid #dedede;background-color: #F8F8F8;">
	          <li>
	            <a href="<%=request.getContextPath()%>/rapast/zhiliangshoppage/GoodsIndex/goods_index.jsp" class="" id="f_icon012" value="f_icon01.png">
	                <img src="<%=request.getContextPath()%>/rapast/zhiliangshoppage/images/footer/f_icon01.png" alt="首页"/>
	                <span class="am-navbar-label">首页</span>
	            </a>
	          </li>
	          <li>
	            <a href="<%=request.getContextPath()%>/rapast/zhiliangshoppage/GoodsType/goodstype.jsp" class="" id="f_icon022" value="f_icon02.png">
	                <img src="<%=request.getContextPath()%>/rapast/zhiliangshoppage/images/footer/f_icon02.png" alt="分类"/>
	                <span class="am-navbar-label">分类</span>
	            </a>
	          </li>
	          <li >
	            <a href="<%=request.getContextPath()%>/rapast/zhiliangshoppage/GoodsCart/goodscart_list.jsp" class="" id="f_icon032" value="f_icon03.png">
	                <img src="<%=request.getContextPath()%>/rapast/zhiliangshoppage/images/footer/f_icon03.png"alt="购物车"/>
	                <span class="am-navbar-label">购物车</span>
	            </a>
	          </li>
	          <li >
	            <a href="<%=request.getContextPath()%>/rapast/zhiliangshoppage/MyOrder/myorder.jsp" class="" id ="f_icon042" value="f_icon04.png">
	                <img src="<%=request.getContextPath()%>/rapast/zhiliangshoppage/images/footer/f_icon04.png"alt="我的"/>
	                <span class="am-navbar-label">我的</span>
	            </a>
	          </li>
	       </ul>
	  </div>
	 <!--底部菜单栏结束--> 
	<script type="text/javascript">
		$(function(){
			$(".am-navbar-nav a").each(function(){
				$(this).click(function(){
					makeChangeImg(this);
				});
			});
			
			defaultimg();
		});
		
		
		var pathimg = '<%=request.getContextPath()%>';
		function makeChangeImg(em){
			$(".am-navbar-nav a").each(function(){
				$(this).find("span").attr("class","am-navbar-label");
				$(this).find("img").attr("src",pathimg+"/rapast/zhiliangshoppage/images/footer/"+$(this).attr("value"));
			});
			
			$(em).find("img").attr("src",pathimg+"/rapast/zhiliangshoppage/images/footer/"+$(em).attr("id")+".png");
			$(em).find("span").attr("class","am-navbar-label label_current");
		}
		
		function GetPageName(){
			var url = window.location.href;
			var tmp = new Array();
			var newtmp = new Array();    
			tmp = url.split("/");  
			var pp = tmp[tmp.length-1];
			tmp = pp.split("?");
			tmp = tmp[0].split(".");
			return tmp[0];	
		}
		
		/*给定默认图标*/
		function defaultimg(){
			var thename = GetPageName();
			switch(thename)
			{
				case 'goods_index':
					$("#f_icon012").find("img").attr("src",pathimg+"/rapast/zhiliangshoppage/images/footer/f_icon012.png");
					$("#f_icon012").find("span").attr("class","am-navbar-label label_current");

				  break;
				case 'shopPage':
					$("#f_icon012").find("img").attr("src",pathimg+"/rapast/zhiliangshoppage/images/footer/f_icon012.png");
					$("#f_icon012").find("span").attr("class","am-navbar-label label_current");

				  break;
				case 'goodstype':
					$("#f_icon022").find("img").attr("src",pathimg+"/rapast/zhiliangshoppage/images/footer/f_icon022.png");
					$("#f_icon022").find("span").attr("class","am-navbar-label label_current");
				  break;
				case 'goodscart_list':
					$("#f_icon032").find("img").attr("src",pathimg+"/rapast/zhiliangshoppage/images/footer/f_icon032.png");
					$("#f_icon032").find("span").attr("class","am-navbar-label label_current");
					
					  break;
				case 'cartempty':
					$("#f_icon032").find("img").attr("src",pathimg+"/rapast/zhiliangshoppage/images/footer/f_icon032.png");
					$("#f_icon032").find("span").attr("class","am-navbar-label label_current");
					
					  break;
				case 'myorder':
					$("#f_icon042").find("img").attr("src",pathimg+"/rapast/zhiliangshoppage/images/footer/f_icon042.png");
					$("#f_icon042").find("span").attr("class","am-navbar-label label_current");
					
					  break;
				default:
				  break;
			}
		}
	</script>
