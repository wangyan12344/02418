var i=1;
$(function(){
	
	initPage();
	
	
});

/**
 * 初始化页面
 * */
function initPage(){
	
	$.ajax({
		url:getRequestUrl("/manager/ZlBNewsController/loadZlBNews.json"),
		dataType:"json",
		data:{"zlBNews.newsid":opid},
		success:function(data){			
			var addHtml = $("#formTemplate").render(data);
			$("#formId").html(addHtml);	
			
			
			bindevent();
			initUEditor({
				"editorid":"memo",
				"width":800,
				"height":200,
				"propertyname":"zlBNews.newscontent",
				"content":data.entity.newscontent
			});
			if (data.entity.zlbnewsattachlist.length > 0) {
				i=data.entity.zlbnewsattachlist.length+1;
				for (var n=0; n <= data.entity.zlbnewsattachlist.length+1; n++) {
					var packtype = data.entity.zlbnewsattachlist[n].attachtitle;
					var packprice = data.entity.zlbnewsattachlist[n].attachpath;
					$("#packing").append("<li class='packing' id='price"+n+"'>"+
							"<input type='text' class='dfinput type' name='type' value='"+ packtype+ "' placeholder='请输入附件名称' dc=''  />"+
							"<input type='text' class='dfinput price' name='price' value='"+ packprice+ "' readonly='true' dc='' style='margin-left:6px;'  id='imgfj"+n+"'/>"+
							"<a href='#' class='uploada_fj'  ><input type='file' id='uploadFile"+n+"' class='uploadinput' dc='true' name='file' onchange='uploadByid("+n+")'/></a><a href='javascript:deletePrice("+n+");' class='tablelink' style='margin-top:6px;margin-left:4px;'>删除</a>"+
							"</li>");
					}
			} 
			
			
		},
		error:function(error){
		}
		
	});
	
	
	
}
/**
 * 根据一级分类、获取二级分类联动加载下拉框
 */
function firstchange(){
	var id=$("#fvalue").val();
	$.ajax({
		url:getRequestUrl("/manager/ZlBNewsController/getZlBNewsCategoryListByParentid.json"),
		dataType:"json",
		data:{"zlBNewsCategory.categoryid":id,"zlBNewsCategory.parentid":id},
		success:function(data){
			$("#svalue").empty();
			$("#svalue").append("<option selected='selected' value=''>请选择</option>");
			for(var i=0;i<data.zlBNewsCategoryList.length;i++){
				var svalue=data.zlBNewsCategoryList[i].categoryid;
				var sname=data.zlBNewsCategoryList[i].categoryname;
				$("#svalue").append("<option value="+svalue+">"+sname+"</option>");
			}
			//secondchange();			
		},
		error:function(error){
			alert("error");
		}
		
	});
}
function bindevent(){
	
	
	bindValidateEvent("formId");

	$(".select1").uedSelect({
		width : 230			  
	});
	
	$("#closeBtn").bind('click',function(){
		returnMainPage();
	});
	
	$(".datepicker").datetimepicker({
		timepicker:true,
		format:'Y-m-d H:i:s'
	});
	
	$("#submitBtn").bind('click',function(){
		var type=$(".type")
		var price=$(".price");
		var packtypes="";
		var packprices="";
		var typestatus=true;
		var pricestatus=true;
		for(var i=0;i<type.length;i++){
			if(type.eq(i).val()==""){
				typestatus=false;
			}
		}
		for(var i=0;i<price.length;i++){
			if(price.eq(i).val()==""){
				pricestatus=false;
			}
		}
		if(!typestatus){
			layer.alert("请输入附件名称",3);	
			return;
		}else if(!pricestatus){
			layer.alert("请上传附件",3);	
			return;
		}else{
			for(var i=0;i<type.length;i++){
				packtypes+=","+type.eq(i).val()
			}
			for(var i=0;i<price.length;i++){
				packprices+=","+price.eq(i).val();
			}
		}
		
		var checkfalg=	checkFormValue('formId');
		if(checkfalg){
			$(this).unbind();
			var userData = collectData("formId");
			//var userShopData = collectData("userMshopAddId");
//			var postData = $.extend({},userData);
			var postData = $.extend({"zlBNews.packtypes":packtypes,"zlBNews.packprices":packprices},userData);
			
			$.ajax({
				url:getRequestUrl("/manager/ZlBNewsController/update.json"),
				dataType:"json",
				data:postData,
				success:function(result){
					pageForward('/manager/ZlBNewsController/list.do');
				},
				error:function(error){
				}
			});
		}
	});
	
	$(".deleteshop").die().live('click',function(){
		$(this).parent().parent().remove();
		$('.tablelist tbody tr:odd').addClass('odd');
		$('.tablelist tbody tr:even').removeClass('odd');
	});
	
	//选择新闻模板
	$("#picture").change(function(){  
		var p1=$(this).children("option:selected").val();//这就是selected的值 
		if(p1==2){
			$("#pictureinfo").css("display","none");
			$("#imgurl").val("");
			
			
		}else if(p1==1){			
			$("#pictureinfo").css("display","block");
					
		}
		
		
	});
	
	
/*	$("#imgurl1").hover(function(){
		
		$("#deopt_imgbox").show(500);
		$("#imgbox").attr("src",$("#imgurl1")[0].src);
		
	},function(){
		$("#deopt_imgbox").hide(500);
	
	});*/
}

/**
 * 上传图片信息
 */
function upload(){
	   var parameterData = {
				successfunc:showresult,
				uploadId:"uploadFile",
				modelForder:"news",
		};
	   ajaxFileUpload(parameterData);		  
}
function showresult(data){	
	  $("#imgurl").attr("value",data.opfileupload[0].filepath);//配置默认图片
	  $("#imgurl1").attr("src",data.opfileupload[0].filepath);//配置默认图片
}
/**
 * 上传图片信息
 */
function uploadByid(id){
	   var parameterData = {
				successfunc:showresultid,
				uploadId:"uploadFile"+id,
				modelForder:"news"
		};
	   ajaxFileUploadByid(parameterData,id);		  
}
function showresultid(data,id){	
	  $("#imgfj"+id).attr("value",data.opfileupload[0].filepath);//配置默认图片
}
function returnMainPage(){
	pageForward('/manager/ZlBNewsController/list.do');
}

function addPackprice(){
	
	$("#packing").append("<li class='packing' id='price"+i+"'>"+
						"<input type='text' class='dfinput type' name='type' value='' placeholder='请输入附件名称' dc=''  />"+
						"<input type='text' class='dfinput price' name='price' value='' readonly='true' dc='' style='margin-left:6px;'  id='imgfj"+i+"'/>"+
						"<a href='#' class='uploada_fj'  ><input type='file' id='uploadFile"+i+"' class='uploadinput' dc='true' name='file' onchange='uploadByid("+i+")'/></a><a href='javascript:deletePrice("+i+");' class='tablelink' style='margin-top:6px;margin-left:4px;'>删除</a>"+
						"</li>");
	i++;
}

//删除属性
function deletePrice(index){
	var id="price"+index;
	var parentlength=$("#packing").children().length;
		$("#"+id).remove();
	
}
/**
 * 根据一级分类、获取二级分类联动加载下拉框
 */
function selectdepartmentname(){
	var departmentid=$("#departmentid").val();
	   //部门名称 下拉框数据绑定
	createSelectByDB('departmentuserid','zl_b_department_user','departmentuser','id', ' and departmentid="'+departmentid+'"');
}

