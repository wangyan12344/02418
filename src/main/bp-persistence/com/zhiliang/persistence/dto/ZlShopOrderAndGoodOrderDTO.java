package com.zhiliang.persistence.dto;

import java.io.Serializable;
import java.util.List;

import com.repast.core.annotation.Column;
import com.repast.core.annotation.ID;


/**
 * 
 * Application name: Application describing:实体类 Copyright:Copyright copy;
 * Company:
 * 表zl_shop_order 的实体类
 * @author 马骞
 */
public class ZlShopOrderAndGoodOrderDTO implements Serializable {
	
	/**
	 *id
	 */
    @ID
	private String orderid;
	/**
	 *订单编号
	 */
	private String ordernum;

	/**
	 *实际成交价格
	 */
	private String sellprice;
	
	/**
	 *订单状态
	 */
	private String orderstatus;
	
	/**
	 *订单状态
	 */
	private String orderstatusname;
	
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
	 *订单生成时间
	 */
	private String createtime;
	
	/**
	 *运费
	 */
	private String sentprice;
	
	/**
	 *用户id
	 */
	private String userid;
	
	/**
	 * 店铺id
	 */
	private String pshopid;
	/**
	 * 订单补充说明
	 */
	private String memo;
	/**
	 * 订单流水账号
	 */
	private String serial;
	
	/**
	 * 店铺名称
	 */
    private String shopname;
    
    /**
	 *订单id
	 */
	private String ordergoodid;
	/**
	 *商品数量
	 */
	private String gcount;
	/**
	 *状态－（退货、正常）
	 */
	private String status;
	/**
	 *订单编号
	 */
	private String dordernum;
	/**
	 *订单单价价
	 */
	private String price;
	/**
	 *折扣价格
	 */
	private String discountprice;	
	/**
	 *商品id
	 */
	private String goodid;
	
	/**
	 * 物流id
	 */
	private String deliveryid;
	/**
	 *快递单号
	 */
	private String delivernum;
	/**
	 *生成日期
	 */
	private String dcreatetime;
	/**
	 *启用状态
	 */
	private String dstatus;
	
	/**
	 *物流公司名称code
	 */
	private String deliverncode;
	/**
	 * 物流订单id
	 * @return
	 */
    private String dordergoodid;
    /**
     * shop_address id
     * @return
     */
    private String auserid;
    /**
     * 收货人姓名
     * @return
     */
    private String contactsuser;
    /**
     * 收货人电话
     * @return
     */
    private String contactstel;
    /**
     * 收货人地址
     * @return
     */
    private String address;
    /**
     * goodsid
     * @return
     */
    private String goodsid;
    /**
     * 货品名称
     * @return
     */
    private String goodname;
    /**
     * 商品图片
     * @return
     */
    private String img;
    /**
     * 商品特点
     * @return
     */
    private String feature;
    /**
     * 待付款 数量
     * @return
     */
    private String waitpaycount;
    /**
     * 待发货 数量
     * @return
     */
    private String waittakeovercount;
    /**
     * 订单下的商品数量
     */
    private String ordercount;
    /**
     * 订单状态描述
     * @return
     */
    private String orderstatusmemo;
   
    /**
     * 发货时间
     */
    private String sendtime;

    private String orderaddress;  
 /**
  * 订单评论状态
  */
    private String bbsstatus;
   
    /**
     * 订单类型1正常2限时抢购
     */
    
	private String ordertype;
	

    /**
     * 微信价格
     */
    
	private String weixinprice; 
  
	/**
     * 订购商品失效状态（0 未开始 1 进行中 2已过期）
     * */
	private String activitygoodsstatus;

	/**
     * 商品集合
     * @return
     */
    private List<ZlShopOrderAndGoodOrderDTO> goodorder;
    
    /**
     * 昵称
     * @return
     */
    private String nickname;
    /**
     * 头像
     * @return
     */
    private String headimg;
    
    /**
     * 订单生成时间 起始
     * @return
     */
    private String cbegintime;
    /**
     * 订单生成时间 结束
     * @return
     */
    private String cendtime;
    
    /**
     * 支付时间 起始
     * @return
     */
    private String paybegintime;
    /**
     * 支付时间 结束
     * @return
     */
    private String payendtime;
    /**
     * 实际成交总价
     */
    private String sumsellprice;
    
    
    public String getCbegintime() {
		return cbegintime;
	}
	public void setCbegintime(String cbegintime) {
		this.cbegintime = cbegintime;
	}
	public String getCendtime() {
		return cendtime;
	}
	public void setCendtime(String cendtime) {
		this.cendtime = cendtime;
	}
	public String getPaybegintime() {
		return paybegintime;
	}
	public void setPaybegintime(String paybegintime) {
		this.paybegintime = paybegintime;
	}
	public String getPayendtime() {
		return payendtime;
	}
	public void setPayendtime(String payendtime) {
		this.payendtime = payendtime;
	}
	public String getWeixinprice() {
  		return weixinprice;
  	}
  	public void setWeixinprice(String weixinprice) {
  		this.weixinprice = weixinprice;
  	}
	public String getActivitygoodsstatus() {
		return activitygoodsstatus;
	}
	public void setActivitygoodsstatus(String activitygoodsstatus) {
		this.activitygoodsstatus = activitygoodsstatus;
	}
	public String getOrdertype() {
		return ordertype;
	}
	public void setOrdertype(String ordertype) {
		this.ordertype = ordertype;
	}
	public String getBbsstatus() {
	return bbsstatus;
}
public void setBbsstatus(String bbsstatus) {
	this.bbsstatus = bbsstatus;
}
	public String getSendtime() {
		return sendtime;
	}
	public void setSendtime(String sendtime) {
		this.sendtime = sendtime;
	}
	public String getWaitpaycount() {
		return waitpaycount;
	}
	public void setWaitpaycount(String waitpaycount) {
		this.waitpaycount = waitpaycount;
	}
	public String getWaittakeovercount() {
		return waittakeovercount;
	}
	public void setWaittakeovercount(String waittakeovercount) {
		this.waittakeovercount = waittakeovercount;
	}
	public String getGoodsid() {
		return goodsid;
	}
	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
	}
	public String getGoodname() {
		return goodname;
	}
	public void setGoodname(String goodname) {
		this.goodname = goodname;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
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
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
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
	public String getShopname() {
		return shopname;
	}
	public void setShopname(String shopname) {
		this.shopname = shopname;
	}
	public String getOrdergoodid() {
		return ordergoodid;
	}
	public void setOrdergoodid(String ordergoodid) {
		this.ordergoodid = ordergoodid;
	}
	public String getGcount() {
		return gcount;
	}
	public void setGcount(String gcount) {
		this.gcount = gcount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getOrdernum() {
		return ordernum;
	}
	public void setOrdernum(String ordernum) {
		this.ordernum = ordernum;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
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
	public String getDeliveryid() {
		return deliveryid;
	}
	public void setDeliveryid(String deliveryid) {
		this.deliveryid = deliveryid;
	}
	public String getDelivernum() {
		return delivernum;
	}
	public void setDelivernum(String delivernum) {
		this.delivernum = delivernum;
	}
	public String getDcreatetime() {
		return dcreatetime;
	}
	public void setDcreatetime(String dcreatetime) {
		this.dcreatetime = dcreatetime;
	}
	public String getDstatus() {
		return dstatus;
	}
	public void setDstatus(String dstatus) {
		this.dstatus = dstatus;
	}
	public String getDeliverncode() {
		return deliverncode;
	}
	public void setDeliverncode(String deliverncode) {
		this.deliverncode = deliverncode;
	}
	public String getAuserid() {
		return auserid;
	}
	public void setAuserid(String auserid) {
		this.auserid = auserid;
	}
	public String getContactsuser() {
		return contactsuser;
	}
	public void setContactsuser(String contactsuser) {
		this.contactsuser = contactsuser;
	}
	public String getContactstel() {
		return contactstel;
	}
	public void setContactstel(String contactstel) {
		this.contactstel = contactstel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPricetime() {
		return pricetime;
	}
	public void setPricetime(String pricetime) {
		this.pricetime = pricetime;
	}
	public String getDordernum() {
		return dordernum;
	}
	public void setDordernum(String dordernum) {
		this.dordernum = dordernum;
	}
	public String getPshopid() {
		return pshopid;
	}
	public void setPshopid(String pshopid) {
		this.pshopid = pshopid;
	}
	public String getDordergoodid() {
		return dordergoodid;
	}
	public void setDordergoodid(String dordergoodid) {
		this.dordergoodid = dordergoodid;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getFeature() {
		return feature;
	}
	public void setFeature(String feature) {
		this.feature = feature;
	}
	public String getOrderstatusmemo() {
		return orderstatusmemo;
	}
	public void setOrderstatusmemo(String orderstatusmemo) {
		this.orderstatusmemo = orderstatusmemo;
	}
	public List<ZlShopOrderAndGoodOrderDTO> getGoodorder() {
		return goodorder;
	}
	public void setGoodorder(List<ZlShopOrderAndGoodOrderDTO> goodorder) {
		this.goodorder = goodorder;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getSerial() {
		return serial;
	}
	public void setSerial(String serial) {
		this.serial = serial;
	}
	public String getOrdercount() {
		return ordercount;
	}
	public void setOrdercount(String ordercount) {
		this.ordercount = ordercount;
	}
	public String getOrderaddress() {
		return orderaddress;
	}
	public void setOrderaddress(String orderaddress) {
		this.orderaddress = orderaddress;
	}
	public String getOrderstatusname() {
		return orderstatusname;
	}
	public void setOrderstatusname(String orderstatusname) {
		this.orderstatusname = orderstatusname;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getHeadimg() {
		return headimg;
	}
	public void setHeadimg(String headimg) {
		this.headimg = headimg;
	}
	public String getSumsellprice() {
		return sumsellprice;
	}
	public void setSumsellprice(String sumsellprice) {
		this.sumsellprice = sumsellprice;
	}
	
    
    
	
	
}