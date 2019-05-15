package com.zhiliang.persistence.dto;

import java.io.Serializable;

/**
 * 测试代码生成
 * Application name: Application describing:实体类 Copyright:Copyright copy;
 * WebSite:http://www.palacesun.com
 * 表ZlMallCouponLog 的实体类
 * @author zhiliang
 */
public class ZlMallCouponLogDTO implements Serializable {

	private static final long serialVersionUID = 2771520536458495846L;
	
	//@Column(name = "id", comment = "")
	private String id;
 
	//@Column(name = "openid", comment = "openid")
	private String openid;
 
	//@Column(name = "farmerid", comment = "农户id")
	private String farmerid;
 
	//@Column(name = "usingstatus", comment = "使用状态")
	private String usingstatus;
 
	//@Column(name = "receivestatus", comment = "领取状态")
	private String receivestatus;
 
	//@Column(name = "receivetime", comment = "领取时间")
	private String receivetime;
 
	//@Column(name = "sendtitme", comment = "发放时间")
	private String sendtitme;
 
	//@Column(name = "content", comment = "备注说明")
	private String content;
 
	//@Column(name = "createtitme", comment = "创建时间")
	private String createtitme;
 
	//@Column(name = "couponid", comment = "优惠券id")
	private String couponid;
 
	//@Column(name = "couponname", comment = "优惠券名称")
	private String couponname;
 
	//@Column(name = "couponcategory", comment = "优惠券种类")
	private String couponcategory;
 
	//@Column(name = "img", comment = "优惠券图片")
	private String img;
 
	//@Column(name = "price", comment = "优惠券金额")
	private String price;
 
	//@Column(name = "starttime", comment = "生效时间")
	private String starttime;
 
	//@Column(name = "endtitme", comment = "失效时间")
	private String endtitme;
 
	//@Column(name = "ispush", comment = "是否微信推送0不推送1推送")
	private String ispush;
 
	//@Column(name = "createtitme_coupon", comment = "优惠券创建时间")
	private String createtitme_coupon;
	
	////@Column(name = "coupon_id", comment = "优惠券id")
	private String coupon_id;
	
	////@Column(name = "couponnum", comment = "优惠券码")
	private String couponnum;
	
	//@Column(name = "coupontypes", comment = "优惠券二级分类")
	private String coupontypes;
	//@Column(name = "shopid", comment = "店铺id")
	private String shopid;
	
 	public String getShopid() {
		return shopid;
	}

	public void setShopid(String shopid) {
		this.shopid = shopid;
	}

	public String getCoupontypes() {
		return coupontypes;
	}

	public void setCoupontypes(String coupontypes) {
		this.coupontypes = coupontypes;
	}

	public String getCouponnum() {
		return couponnum;
	}

	public void setCouponnum(String couponnum) {
		this.couponnum = couponnum;
	}

	public String getCouponname() {
		return couponname;
	}

	public void setCouponname(String couponname) {
		this.couponname = couponname;
	}

	public String getCouponcategory() {
		return couponcategory;
	}

	public void setCouponcategory(String couponcategory) {
		this.couponcategory = couponcategory;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getEndtitme() {
		return endtitme;
	}

	public void setEndtitme(String endtitme) {
		this.endtitme = endtitme;
	}

	public String getIspush() {
		return ispush;
	}

	public void setIspush(String ispush) {
		this.ispush = ispush;
	}

	public String getCreatetitme_coupon() {
		return createtitme_coupon;
	}

	public void setCreatetitme_coupon(String createtitme_coupon) {
		this.createtitme_coupon = createtitme_coupon;
	}

	public String getCoupon_id() {
		return coupon_id;
	}

	public void setCoupon_id(String coupon_id) {
		this.coupon_id = coupon_id;
	}

	public  void setId(String id){
		this.id =  id;
	}
	
	public String getId(){
		return this.id;
	}
	
 
	public  void setOpenid(String openid){
		this.openid =  openid;
	}
	
	public String getOpenid(){
		return this.openid;
	}
 
	public  void setFarmerid(String farmerid){
		this.farmerid =  farmerid;
	}
	
	public String getFarmerid(){
		return this.farmerid;
	}
 
	public  void setUsingstatus(String usingstatus){
		this.usingstatus =  usingstatus;
	}
	
	public String getUsingstatus(){
		return this.usingstatus;
	}
 
	public  void setReceivestatus(String receivestatus){
		this.receivestatus =  receivestatus;
	}
	
	public String getReceivestatus(){
		return this.receivestatus;
	}
 
	public  void setReceivetime(String receivetime){
		this.receivetime =  receivetime;
	}
	
	public String getReceivetime(){
		return this.receivetime;
	}
 
	public  void setSendtitme(String sendtitme){
		this.sendtitme =  sendtitme;
	}
	
	public String getSendtitme(){
		return this.sendtitme;
	}
 
	public  void setContent(String content){
		this.content =  content;
	}
	
	public String getContent(){
		return this.content;
	}
 
	public  void setCreatetitme(String createtitme){
		this.createtitme =  createtitme;
	}
	
	public String getCreatetitme(){
		return this.createtitme;
	}
 
	public  void setCouponid(String couponid){
		this.couponid =  couponid;
	}
	
	public String getCouponid(){
		return this.couponid;
	}
 
}