package com.zhiliang.persistence.dto;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.List;

import com.repast.core.annotation.Column;
import com.repast.core.annotation.ID;


public class FarmerAndMallCouponDTO implements Serializable {
	
	/**
	 *农户id
	 */
	private String farmerid;
	/**
	 *姓名
	 */
	private String farmername;
	/**
	 *联系电话
	 */
	private String tel;
	
	/**
	 *身份证号
	 */
	private String cardid;
	
	/**
	 *农户
	 */
	private String province;
	/**
	 *农户城市
	 */
	private String city;
	
	/**
	 *农户县
	 */
	private String district;
	/**
	 * openid
	 */
	private String openid;
	/**
	 * 优惠券id
	 */
	private String id;
	/**
	 * 指定区域人员数量
	 * @return
	 */
	private String count;
	
	
	public String getFarmerid() {
		return farmerid;
	}
	public void setFarmerid(String farmerid) {
		this.farmerid = farmerid;
	}
	public String getFarmername() {
		return farmername;
	}
	public void setFarmername(String farmername) {
		this.farmername = farmername;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getCardid() {
		return cardid;
	}
	public void setCardid(String cardid) {
		this.cardid = cardid;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	
	
	
}