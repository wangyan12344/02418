package com.zhiliang.persistence.dto;

import java.util.List;

import com.repast.core.annotation.Column;

public class ZlMallActivitygoodsinfoDTO {
	/*
	 * 活动商品id
	 */
	private String activitygoodsid;
	
	/*
	 * 商品id
	 */
	
	private String goodsid;
 
	/*
	 * 商品类型(商品、服务)
	 */
	
	private String goodtypef;
	
	/*
	 * 商品名称
	 */
	
	private String goodname;
	/*
	 * 商品描述
	 */
	
	private String goodmemo;
	/*
	 * 上架日期
	 */
	
	private String createtime;
	/*
	 * 价格
	 */
	
	private String price;
	/*
	 * 店铺id
	 */
	
	private String shopid;
	/*
	 * 商品成交量
	 */
	
	private String volume;
	/*
	 *平台推荐商品(排序) 
	 */
	
	private String recommendation;
	/*
	 * 商品数量
	 */
	
	private String count;
	/*剩余数量
	 * 
	 */
	
	private String lastcount;
	/*
	 * 状态(上架或下架)
	 */
	
	private String status;
	/*
	 * 主图
	 */
	
	private String img;
	/*
	 *商品图文描述 
	 */
	
	private String goodmemoimg;
	/*
	 * 成交量
	 */
	
	private String succcount;
	/*
	 * 商品特点
	 */
	
	private String feature;
	/*
	 * 商品2级类别
	 */
	
	private String goodtypes;
	/*
	 * 商品三级类别
	 */
	
	private String goodtypet;
	/*
	 * 折扣价格
	 */
	
	private String discountprice;
	/*
	 * 是否团购(1.是 0.不是)
	 */
	
	private String groupon;
	/*
	 *团购路径 
	 */
	
	private String grouponurl;
	/*
	 * 抢购活动id
	 */
	
	private String activityid;
	/*
	 * 抢购商品状态（0 未开始 1 进行中 2已过期
	 */
	
	private String activitygoodsstatus;
 
	/**
	 * 附属图
	 */
	private List<String> attachimgpath;
	
	/*
	 * 抢购活动名
	 */
	@Column(name = "activityname", comment = "抢购活动名")
	private String activityname;
	/*
	 * 活动图片路径
	 */
	@Column(name = "activitypicurl", comment = "活动图片路径")
	private String activitypicurl;
	/*
	 * 活动描述
	 */
	@Column(name = "activityremark", comment = "活动描述")
	private String activityremark;
	/*
	 * 创建时间
	 */
	@Column(name = "creattime", comment = "创建时间")
	private String creattime;
	/*
	 * 活动开始时间
	 */
	@Column(name = "activitystarttime", comment = "活动开始时间")
	private String activitystarttime;
	/*
	 * 活动结束时间
	 */
	@Column(name = "activityendtime", comment = "活动结束时间")
	private String activityendtime;
	public String getActivitygoodsid() {
		return activitygoodsid;
	}
	public void setActivitygoodsid(String activitygoodsid) {
		this.activitygoodsid = activitygoodsid;
	}
	public String getGoodsid() {
		return goodsid;
	}
	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
	}
	public String getGoodtypef() {
		return goodtypef;
	}
	public void setGoodtypef(String goodtypef) {
		this.goodtypef = goodtypef;
	}
	public String getGoodname() {
		return goodname;
	}
	public void setGoodname(String goodname) {
		this.goodname = goodname;
	}
	public String getGoodmemo() {
		return goodmemo;
	}
	public void setGoodmemo(String goodmemo) {
		this.goodmemo = goodmemo;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getShopid() {
		return shopid;
	}
	public void setShopid(String shopid) {
		this.shopid = shopid;
	}
	public String getVolume() {
		return volume;
	}
	public void setVolume(String volume) {
		this.volume = volume;
	}
	public String getRecommendation() {
		return recommendation;
	}
	public void setRecommendation(String recommendation) {
		this.recommendation = recommendation;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getLastcount() {
		return lastcount;
	}
	public void setLastcount(String lastcount) {
		this.lastcount = lastcount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getGoodmemoimg() {
		return goodmemoimg;
	}
	public void setGoodmemoimg(String goodmemoimg) {
		this.goodmemoimg = goodmemoimg;
	}
	public String getSucccount() {
		return succcount;
	}
	public void setSucccount(String succcount) {
		this.succcount = succcount;
	}
	public String getFeature() {
		return feature;
	}
	public void setFeature(String feature) {
		this.feature = feature;
	}
	public String getGoodtypes() {
		return goodtypes;
	}
	public void setGoodtypes(String goodtypes) {
		this.goodtypes = goodtypes;
	}
	public String getGoodtypet() {
		return goodtypet;
	}
	public void setGoodtypet(String goodtypet) {
		this.goodtypet = goodtypet;
	}
	public String getDiscountprice() {
		return discountprice;
	}
	public void setDiscountprice(String discountprice) {
		this.discountprice = discountprice;
	}
	public String getGroupon() {
		return groupon;
	}
	public void setGroupon(String groupon) {
		this.groupon = groupon;
	}
	public String getGrouponurl() {
		return grouponurl;
	}
	public void setGrouponurl(String grouponurl) {
		this.grouponurl = grouponurl;
	}
	public String getActivityid() {
		return activityid;
	}
	public void setActivityid(String activityid) {
		this.activityid = activityid;
	}
	public String getActivitygoodsstatus() {
		return activitygoodsstatus;
	}
	public void setActivitygoodsstatus(String activitygoodsstatus) {
		this.activitygoodsstatus = activitygoodsstatus;
	}
	public List<String> getAttachimgpath() {
		return attachimgpath;
	}
	public void setAttachimgpath(List<String> attachimgpath) {
		this.attachimgpath = attachimgpath;
	}
	public String getActivityname() {
		return activityname;
	}
	public void setActivityname(String activityname) {
		this.activityname = activityname;
	}
	public String getActivitypicurl() {
		return activitypicurl;
	}
	public void setActivitypicurl(String activitypicurl) {
		this.activitypicurl = activitypicurl;
	}
	public String getActivityremark() {
		return activityremark;
	}
	public void setActivityremark(String activityremark) {
		this.activityremark = activityremark;
	}
	public String getCreattime() {
		return creattime;
	}
	public void setCreattime(String creattime) {
		this.creattime = creattime;
	}
	public String getActivitystarttime() {
		return activitystarttime;
	}
	public void setActivitystarttime(String activitystarttime) {
		this.activitystarttime = activitystarttime;
	}
	public String getActivityendtime() {
		return activityendtime;
	}
	public void setActivityendtime(String activityendtime) {
		this.activityendtime = activityendtime;
	}
	
	
	
	
}
