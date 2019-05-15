package com.zhiliang.persistence.entity;

import java.io.Serializable;

import com.repast.core.annotation.Column;
import com.repast.core.annotation.Entity;
import com.repast.core.annotation.ID;
import com.repast.core.annotation.Transient;
import com.repast.core.system.BaseEntity;

/**
 * 
 * Application name: Application describing:实体类 Copyright:Copyright copy;
 * Company:
 * 表sys_user_shop 的实体类
 * @author 齐建军
 */
@Entity(name = "sys_user_shop")
public class SysUserShop extends BaseEntity implements Serializable, Cloneable {
	
	private static final long serialVersionUID = 2771520536458495846L;
	
	public SysUserShop clone() {
		SysUserShop o = null;
		try {
			o = (SysUserShop) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return o;
	}
	
	/**
	 *id
	 */
    @ID
	@Column(name = "id", comment = "id")
	private String id;
	/**
	 *机构id
	 */
	@Column(name = "orgid", comment = "机构id")
	private String orgid;
	/**
	 *店铺id
	 */
	@Column(name = "shopid", comment = "店铺id")
	private String shopid;
	/**
	 *用户id
	 */
	@Column(name = "userid", comment = "用户id")
	private String userid;
	/**
	 *是否可管理  0为否，1为是
	 */
	@Column(name = "isadmin", comment = "是否可管理  0为否，1为是")
	private String isadmin;
	/**
	 *是否该店成员  0为否，1为是
	 */
	@Column(name = "ismember", comment = "是否该店成员  0为否，1为是")
	private String ismember;
	
	@Transient
	@Column(name="shopname")
	private String shopname;

	public String getId() {
		 return id;
	}
	
	public void setId(String id) {
		 this.id = id;
	}
	
	public String getOrgid() {
		 return orgid;
	}
	
	public void setOrgid(String orgid) {
		 this.orgid = orgid;
	}
	
	public String getShopid() {
		 return shopid;
	}
	
	public void setShopid(String shopid) {
		 this.shopid = shopid;
	}
	
	public String getUserid() {
		 return userid;
	}
	
	public void setUserid(String userid) {
		 this.userid = userid;
	}
	
	public String getIsadmin() {
		 return isadmin;
	}
	
	public void setIsadmin(String isadmin) {
		 this.isadmin = isadmin;
	}
	
	public String getIsmember() {
		 return ismember;
	}
	
	public void setIsmember(String ismember) {
		 this.ismember = ismember;
	}

	public String getShopname() {
		return shopname;
	}

	public void setShopname(String shopname) {
		this.shopname = shopname;
	}
	
	
	
}