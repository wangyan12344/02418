package com.zhiliang.persistence.dto;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.List;

import com.repast.core.annotation.Column;
import com.repast.core.annotation.ID;
import com.repast.core.annotation.Transient;


/**
 * 
 * Application name: Application describing:实体类 Copyright:Copyright copy;
 * Company:
 * 表zl_shop_order   zl_good_order 的实体类
 * @author Wy
 */
public class ZlMallShopStatisticsDTO implements Serializable {
	
	private static final long serialVersionUID = 15524414L;

	
	private String orderid;
		/**
		 *订单编号
		 */
		private String shopordernum;

		/**
		 *实际成交价格
		 */
		private String sellprice;
		
		/**
		 *订单状态
		 */
		private String orderstatus;
		
		/**
		 *交易时间
		 */
		private String pricetime;
		
		/**
		 *商品数量
		 */
		private String count;
		/**
		 *订单总价（不包括运费）
		 */
		private String totalprice;
		
		/**
		 *店铺id
		 */
		private String shopid;
		
		/**
		 *店铺名称
		 */
		private String shopname;
		
		
		/**
		 *订单生成时间
		 */
		private String createtitme;
		
		/**
		 *运费
		 */
		private String sentprice;
		
		/**
		 *用户id
		 */
		private String userid;
		
		/**
		 * 订单状态描述
		 * @return
		 */
		private String orderstatusmemo;
		
		/**
		 * 流水号，支付凭证
		 * @return
		 */	
		private String serial;
		
		
		/**
		 * 订单发货时间
		 * @return
		 */	
		private String sendtime;
		
		/**
		 * 订单编号
		 */
		private String ordernum;
		
		/**
		 *折扣价格
		 */
		private String discountprice;	
			
		/**
		 *商品id
		 */
		private String goodid;
		
		/**
		 * 订单类型1正常2限时抢购
		 */
		private String ordertype;
		
		/**
		 * 商品名称
		 * @return
		 */
		private String goodname;
		
		/**
		 * 商品规格
		 * @return
		 */
		private String feature;
		
		/**
		 * 商品剩余量
		 * @return
		 */
		private String lastcount;
		
		/**
		 * 商品销量
		 * @return
		 */
		private String volume;
		
		/**
		 * 微信金额
		 * @return
		 */
		private String weixinprice;
		
		/**
		 * 优惠券id
		 */
		private String couponid;
		/**
		 * 支付状态
		 * @return
		 */
		private String paystatus;
		
	  /**
	   * 消耗积分数	
	   * @return
	   */
		private String integral;
		/**
		 * 优惠券面值
		 */
		private String coupon;
		
		/**
		 * 流水号状态
		 * @return
		 */
		private String serialstatus;
		
		/**
		 * 总价
		 * @return
		 */
		private String price;
		
		
		
		public String getWeixinprice() {
			return weixinprice;
		}

		public void setWeixinprice(String weixinprice) {
			this.weixinprice = weixinprice;
		}

		public String getCouponid() {
			return couponid;
		}

		public void setCouponid(String couponid) {
			this.couponid = couponid;
		}

		public String getPaystatus() {
			return paystatus;
		}

		public void setPaystatus(String paystatus) {
			this.paystatus = paystatus;
		}

		public String getOrderid() {
			return orderid;
		}

		public void setOrderid(String orderid) {
			this.orderid = orderid;
		}

		public String getShopordernum() {
			return shopordernum;
		}

		public void setShopordernum(String shopordernum) {
			this.shopordernum = shopordernum;
		}

		public String getSellprice() {
			return sellprice;
		}

		public void setSellprice(String sellprice) {
			this.sellprice = sellprice;
		}

		public String getOrderstatus() {
			return orderstatus;
		}

		public void setOrderstatus(String orderstatus) {
			this.orderstatus = orderstatus;
		}

		public String getPricetime() {
			return pricetime;
		}

		public void setPricetime(String pricetime) {
			this.pricetime = pricetime;
		}

		public String getCount() {
			return count;
		}

		public void setCount(String count) {
			this.count = count;
		}

		public String getTotalprice() {
			return totalprice;
		}

		public void setTotalprice(String totalprice) {
			this.totalprice = totalprice;
		}

		public String getShopid() {
			return shopid;
		}

		public void setShopid(String shopid) {
			this.shopid = shopid;
		}


		public String getSentprice() {
			return sentprice;
		}

		public void setSentprice(String sentprice) {
			this.sentprice = sentprice;
		}

		public String getUserid() {
			return userid;
		}

		public void setUserid(String userid) {
			this.userid = userid;
		}

		public String getOrderstatusmemo() {
			return orderstatusmemo;
		}

		public void setOrderstatusmemo(String orderstatusmemo) {
			this.orderstatusmemo = orderstatusmemo;
		}

		public String getSerial() {
			return serial;
		}

		public void setSerial(String serial) {
			this.serial = serial;
		}

		public String getSendtime() {
			return sendtime;
		}

		public void setSendtime(String sendtime) {
			this.sendtime = sendtime;
		}

		public String getOrdernum() {
			return ordernum;
		}

		public void setOrdernum(String ordernum) {
			this.ordernum = ordernum;
		}

		public String getDiscountprice() {
			return discountprice;
		}

		public void setDiscountprice(String discountprice) {
			this.discountprice = discountprice;
		}

		public String getGoodid() {
			return goodid;
		}

		public void setGoodid(String goodid) {
			this.goodid = goodid;
		}

		public String getOrdertype() {
			return ordertype;
		}

		public void setOrdertype(String ordertype) {
			this.ordertype = ordertype;
		}

		public String getGoodname() {
			return goodname;
		}

		public void setGoodname(String goodname) {
			this.goodname = goodname;
		}

		public String getLastcount() {
			return lastcount;
		}

		public void setLastcount(String lastcount) {
			this.lastcount = lastcount;
		}

		public String getIntegral() {
			return integral;
		}

		public void setIntegral(String integral) {
			this.integral = integral;
		}

		public String getCoupon() {
			return coupon;
		}

		public void setCoupon(String coupon) {
			this.coupon = coupon;
		}

		public String getSerialstatus() {
			return serialstatus;
		}

		public void setSerialstatus(String serialstatus) {
			this.serialstatus = serialstatus;
		}

		public String getShopname() {
			return shopname;
		}

		public void setShopname(String shopname) {
			this.shopname = shopname;
		}

		public String getFeature() {
			return feature;
		}

		public void setFeature(String feature) {
			this.feature = feature;
		}

		public String getPrice() {
			return price;
		}

		public void setPrice(String price) {
			this.price = price;
		}

		public String getCreatetitme() {
			return createtitme;
		}

		public void setCreatetitme(String createtitme) {
			this.createtitme = createtitme;
		}

		public String getVolume() {
			return volume;
		}

		public void setVolume(String volume) {
			this.volume = volume;
		}
		
		
	
}