package com.zhiliang.persistence.dto;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.List;

import com.repast.core.annotation.Column;
import com.repast.core.annotation.ID;


/**
 * 
 * Application name: Application describing:实体类 Copyright:Copyright copy;
 * Company:
 * 表zl_shop_order   zl_good_order 的实体类
 * @author Wy
 */
public class ZlShopCartDTO implements Serializable {
	
	/**
	 * 店铺订单字段
	 * 
	 */
	private static final long serialVersionUID = 1552444L;
	/**
	 *id
	 */
    @ID
	private String orderid;
	/**
	 *店铺订单编号
	 */
	private String ordernum;

	/**
	 *店铺实际成交价格
	 */
	private String sellprice;
	
	/**
	 *店铺订单状态
	 */
	private String orderstatus;
	
	/**
	 *店铺交易时间
	 */
	private String pricetime;
	
	/**
	 *店铺商品数量
	 */
	private String count;
	/**
	 *店铺订单总价（不包括运费）
	 */
	private String totalprice;
	
	/**
	 *店铺shopid
	 */
	private String shopid;
	
	/**
	 *店铺订单生成时间
	 */
	private String createtime;
	
	/**
	 *店铺订单运费
	 */
	private String sentprice;
	
	/**
	 *店铺用户id
	 */
	private String userid;
	
 
	

	/**
	 * 店铺列表
	 */
	private String shoplist;
	

	/**
	 * 商品列表
	 */
	private String productlist;	
	/**
	 * 优惠券列表
	 */
	private String couponlist;	

	/**
	 * 店铺id
	 */
	private String pshopid;
	/**
	 * 店铺名称
	 */
    private String shopname;
    
	/**
	 * 收货地址
	 */
    private String orderaddress;
	/**
	 * 商品订单字段
	 * 
	 */

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
	 * 流水号，支付凭证
	 * @return
	 */	

	private String serial;
	
	/**
	 * 地址id
	 * @return
	 */
	private String aid;
	/**
	 * 补充描述
	 * @return
	 */
	private String memo;
	
	public String getCouponlist() {
		return couponlist;
	}
	public void setCouponlist(String couponlist) {
		this.couponlist = couponlist;
	}
	public String getShoplist() {
		return shoplist;
	}
	public String getProductlist() {
		return productlist;
	}
	public void setShoplist(String shoplist) {
		this.shoplist = shoplist;
	}
	public void setProductlist(String productlist) {
		this.productlist = productlist;
	}
    
	public String getSerial() {
		return serial;
	}
	public void setSerial(String serial) {
		this.serial = serial;
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
	public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}

    
    public String getOrderaddress() {
		return orderaddress;
	}
	public void setOrderaddress(String orderaddress) {
		this.orderaddress = orderaddress;
	}

	
	
}