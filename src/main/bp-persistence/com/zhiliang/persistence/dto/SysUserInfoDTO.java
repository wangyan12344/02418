package com.zhiliang.persistence.dto;

import java.util.Date;


public class SysUserInfoDTO {
	/**
	 *用户id
	 */
	private String userid;
	/**
	 *用户姓名
	 */
	private String username;
	/**
	 *系统账号
	 */
	private String account;
	/**
	 *密码
	 */
	private String password;
	/**
	 *头像路径
	 */
	private String headpicpath;
	/**
	 *所属机构id
	 */
	private String orgid;
	/**
	 *所属机构名称
	 */
	private String orgname;
	/**
	 * 职位名称串
	 */
	private String rolenamestr;
	/**
	 *所属店铺id
	 */
	private String shopid;
	/**
	 *联系电话
	 */
	private String contacttelnumber;
	/**
	 *办公电话
	 */
	private String officetelnumber;
	/**
	 *电子邮箱
	 */
	private String email;
	/**
	 *性别码
	 */
	private String gender;
	/**
	 *生日
	 */
	private Date birthday;
	/**
	 *入职时间
	 */
	private Date entrytime;
	/**
	 *办公地址
	 */
	private String officeaddress;
	/**
	 *用户状态  1启用 0停用 
	 */
	private String userstatus;
	
	/**
	 * 是否可管理店铺
	 */
	private String isadmin;
	
	/**
	 * 是否店内成员
	 */
	private String ismember;
	
	/**
	 * 职位
	 */
	private String position;
	
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
	public String getOrgname() {
		return orgname;
	}
	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}
	public String getRolenamestr() {
		return rolenamestr;
	}
	public void setRolenamestr(String rolenamestr) {
		this.rolenamestr = rolenamestr;
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
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
	
}
