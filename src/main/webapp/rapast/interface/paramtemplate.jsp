<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!-- 酒店信息列表查询条件 -->
<script type="text/x-jsrender" id="oriPaginationTemplate">
<div>
<span>酒店名称：</span><span>omsRestaurantInfo.restaurantname</span>&nbsp;&nbsp;&nbsp;&nbsp;
<input name="omsRestaurantInfo.restaurantname" type="text" dc="true" />
</div>
<div>
<span>当前设备经度：</span><span>omsRestaurantInfo.longitude</span>&nbsp;&nbsp;&nbsp;&nbsp;
<input name="omsRestaurantInfo.longitude" type="text" dc="true" />
</div>
<div>
<span>当前设备纬度：</span><span>omsRestaurantInfo.latitude</span>&nbsp;&nbsp;&nbsp;&nbsp;
<input name="omsRestaurantInfo.latitude" type="text" dc="true" />
</div>
<div>
<span>所属城市：</span><span>omsRestaurantInfo.city</span>&nbsp;&nbsp;&nbsp;&nbsp;
<select name="omsRestaurantInfo.city" dc="true" >
	<option value="110100">北京市</option>
	<option value="210100" selected="selected" >沈阳市</option>
</select>
</div>
<div>
<span>所属商圈：</span><span>omsRestaurantInfo.businessarea</span>&nbsp;&nbsp;&nbsp;&nbsp;
<select name="omsRestaurantInfo.businessarea" dc="true" >
	<option value="" selected="selected" >--请选择--</option>
	<option value="7">奥体</option>
	<option value="2">王府井</option>
	<option value="3">公主坟</option>
</select>
</div>
<div>
<span>是否按喜好查询（1是，0否）：</span><span>likeflag</span>&nbsp;&nbsp;&nbsp;&nbsp;
<input name="likeflag" type="text" dc="true" />
</div>
</script>