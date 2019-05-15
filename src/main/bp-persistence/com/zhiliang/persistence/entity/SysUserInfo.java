package com.zhiliang.persistence.entity;

import java.io.Serializable;
import java.util.Date;

import com.repast.core.annotation.Column;
import com.repast.core.annotation.Entity;
import com.repast.core.annotation.ID;
import com.repast.core.annotation.Transient;
import com.repast.core.system.BaseEntity;

/**
 * 
 * Application name: Application describing:实体类 Copyright:Copyright copy;
 * Company:
 * 表sys_user_info 的实体类
 * @author 齐建军
 */
@Entity(name = "sys_user_info")
public class SysUserInfo extends BaseEntity implements Serializable, Cloneable {
	
	private static final long serialVersionUID = 2771520536458495846L;
	
	public SysUserInfo clone() {
		SysUserInfo o = null;
		try {
			o = (SysUserInfo) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return o;
	}
	
	/**
	 *用户id
	 */
    @ID
	@Column(name = "userid", comment = "用户id")
	private String userid;
	/**
	 *用户姓名
	 */
	@Column(name = "username", comment = "用户姓名")
	private String username;
	/**
	 *系统账号
	 */
	@Column(name = "account", comment = "系统账号")
	private String account;
	/**
	 *密码
	 */
	@Column(name = "password", comment = "密码")
	private String password;
	/**
	 *头像路径
	 */
	@Column(name = "headpicpath", comment = "头像路径")
	private String headpicpath;
	/**
	 *所属机构id
	 */
	@Column(name = "orgid", comment = "所属机构id")
	private String orgid;
	/**
	 *所属店铺id
	 */
	@Column(name = "shopid", comment = "所属店铺id")
	private String shopid;
	/**
	 *联系电话
	 */
	@Column(name = "contacttelnumber", comment = "联系电话")
	private String contacttelnumber;
	/**
	 *办公电话
	 */
	@Column(name = "officetelnumber", comment = "办公电话")
	private String officetelnumber;
	/**
	 *电子邮箱
	 */
	@Column(name = "email", comment = "电子邮箱")
	private String email;
	/**
	 *性别码
	 */
	@Column(name = "gender", comment = "性别码")
	private String gender;
	/**
	 *生日
	 */
	@Column(name = "birthday", comment = "生日")
	private Date birthday;
	/**
	 *入职时间
	 */
	@Column(name = "entrytime", comment = "入职时间")
	private Date entrytime;
	/**
	 *办公地址
	 */
	@Column(name = "officeaddress", comment = "办公地址")
	private String officeaddress;
	/**
	 *用户状态  1启用 0停用 
	 */
	@Column(name = "userstatus", comment = "用户状态")
	private String userstatus;
	/**
	 *用户状态  1启用 0停用 
	 */
	@Column(name = "usertype", comment = "用户状态")
	private String usertype;
	@Transient
	@Column(name = "newscount", comment = "用户状态")
	private String newscount;
	
	
	public String getNewscount() {
		return newscount;
	}

	public void setNewscount(String newscount) {
		this.newscount = newscount;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public String getUserid() {
		 return userid;
	}
	
	public void setUserid(String userid) {
		 this.userid = userid;
	}
	
	public String getUsername() {
		 return username;
	}
	
	public void setUsername(String username) {
		 this.username = username;
	}
	
	public String getAccount() {
		 return account;
	}
	
	public void setAccount(String account) {
		 this.account = account;
	}
	
	public String getPassword() {
		 return password;
	}
	
	public void setPassword(String password) {
		 this.password = password;
	}
	
	public String getHeadpicpath() {
		 return headpicpath;
	}
	
	public void setHeadpicpath(String headpicpath) {
		 this.headpicpath = headpicpath;
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
	
	public String getContacttelnumber() {
		 return contacttelnumber;
	}
	
	public void setContacttelnumber(String contacttelnumber) {
		 this.contacttelnumber = contacttelnumber;
	}
	
	public String getOfficetelnumber() {
		 return officetelnumber;
	}
	
	public void setOfficetelnumber(String officetelnumber) {
		 this.officetelnumber = officetelnumber;
	}
	
	public String getEmail() {
		 return email;
	}
	
	public void setEmail(String email) {
		 this.email = email;
	}
	
	public String getGender() {
		 return gender;
	}
	
	public void setGender(String gender) {
		 this.gender = gender;
	}
	
	public Date getBirthday() {
		 return birthday;
	}
	
	public void setBirthday(Date birthday) {
		 this.birthday = birthday;
	}
	
	public Date getEntrytime() {
		 return entrytime;
	}
	
	public void setEntrytime(Date entrytime) {
		 this.entrytime = entrytime;
	}
	
	public String getOfficeaddress() {
		 return officeaddress;
	}
	
	public void setOfficeaddress(String officeaddress) {
		 this.officeaddress = officeaddress;
	}

	public String getUserstatus() {
		return userstatus;
	}

	public void setUserstatus(String userstatus) {
		this.userstatus = userstatus;
	}
	
	
}