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
 * Company: 表zl_b_trader_user 的实体类
 * 
 * @author 齐建军
 */
@Entity(name = "zl_b_trader_user")
public class ZlBTraderUser extends BaseEntity implements Serializable,
		Cloneable {

	private static final long serialVersionUID = 2771520536458495846L;

	public ZlBTraderUser clone() {
		ZlBTraderUser o = null;
		try {
			o = (ZlBTraderUser) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return o;
	}

	/**
	 * 交易商用户id
	 */
	@ID
	@Column(name = "traderuserid", comment = "交易商用户id")
	private String traderuserid;
	/**
	 * 交易商id
	 */
	@Column(name = "traderid", comment = "交易商id")
	private String traderid;
	/**
	 * 姓名
	 */
	@Column(name = "username", comment = "姓名")
	private String username;
	/**
	 * 登录用户名
	 */
	@Column(name = "account", comment = "登录用户名")
	private String account;
	/**
	 * 登录密码
	 */
	@Column(name = "password", comment = "登录密码")
	private String password;
	/**
	 * 支付密码
	 */
	@Column(name = "paypassword", comment = "支付密码")
	private String paypassword;
	/**
	 * 0没修改过，1修改过
	 */
	@Column(name = "paypasswordstatus", comment = "支付密码状态")
	private String paypasswordstatus;
	/**
	 * 证件类型
	 */
	@Column(name = "cardtype", comment = "证件类型")
	private String cardtype;
	/**
	 * 证件号码
	 */
	@Column(name = "cardnumber", comment = "证件号码")
	private String cardnumber;
	/**
	 * 注册时间
	 */
	@Column(name = "regdate", comment = "注册时间")
	private String regdate;
	/**
	 * 手机号码
	 */
	@Column(name = "mobile", comment = "手机号码")
	private String mobile;
	/**
	 * 电子邮箱
	 */
	@Column(name = "email", comment = "电子邮箱")
	private String email;
	/**
	 * 地址
	 */
	@Column(name = "address", comment = "地址")
	private String address;
	/**
	 * 是否管理员(1为是，0为否)
	 */
	@Column(name = "isadmin", comment = "是否管理员(1为是，0为否)")
	private String isadmin;
	/**
	 * 是否财务员(1为是，0为否)
	 */
	@Column(name = "isfinance", comment = "是否财务员(1为是，0为否)")
	private String isfinance;
	/**
	 * 是否交易员(1为是，0为否)
	 */
	@Column(name = "istrader", comment = "是否交易员(1为是，0为否)")
	private String istrader;
	/**
	 * 是否启用(1启用 0禁用)
	 */
	@Column(name = "enable", comment = "是否启用(1启用 0禁用)")
	private String enable;
	/**
	 * 阅读级别
	 */
	@Column(name = "permissions", comment = "阅读级别")
	private String permissions;
	// 交易商名称
	@Transient
	@Column(name = "tradername", comment = "交易商名称")
	private String tradername;
	// 交易商类别
	@Transient
	@Column(name = "tradertype", comment = "交易商类型")
	private String tradertype;
	// 交易商认证状态
	@Transient
	@Column(name = "certifiedstatus", comment = "交易商认证状态")
	private String certifiedstatus;
	
	// 交易商联系方式
	@Transient
	@Column(name = "contactphone", comment = "交易商联系电话")
	private String contactphone;
	// 交易商联系人
	@Transient
	@Column(name = "contact", comment = "交易商联系电人")
	private String contact;
	
	@Transient
	@Column(name = "payscale", comment = "保证金比例")
	private String payscale;
	
	@Transient
	@Column(name = "creditcode", comment = " 企业统一社会信用代码")
	private String creditcode;
	
	
	@Transient
	@Column(name = "password1", comment = "新密码")
	private String password1;
	
	@Transient
	@Column(name = "password2", comment = "确认新密码")
	private String password2;
	
	
	
	public String getPermissions() {
		return permissions;
	}

	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}

	public String getCreditcode() {
		return creditcode;
	}

	public String getPaypasswordstatus() {
		return paypasswordstatus;
	}

	public void setPaypasswordstatus(String paypasswordstatus) {
		this.paypasswordstatus = paypasswordstatus;
	}

	public void setCreditcode(String creditcode) {
		this.creditcode = creditcode;
	}

	public String getPassword1() {
		return password1;
	}

	public void setPassword1(String password1) {
		this.password1 = password1;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	@Column(name = "pushid", comment = "推送标识")
	private String pushid;
	
	
		
	public String getPushid() {
		return pushid;
	}

	public void setPushid(String pushid) {
		this.pushid = pushid;
	}

	public String getPayscale() {
		return payscale;
	}

	public void setPayscale(String payscale) {
		this.payscale = payscale;
	}

	public String getContactphone() {
		return contactphone;
	}

	public void setContactphone(String contactphone) {
		this.contactphone = contactphone;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getTraderuserid() {
		return traderuserid;
	}

	public void setTraderuserid(String traderuserid) {
		this.traderuserid = traderuserid;
	}

	public String getTraderid() {
		return traderid;
	}

	public void setTraderid(String traderid) {
		this.traderid = traderid;
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

	public String getPaypassword() {
		return paypassword;
	}

	public void setPaypassword(String paypassword) {
		this.paypassword = paypassword;
	}

	public String getCardtype() {
		return cardtype;
	}

	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}

	public String getCardnumber() {
		return cardnumber;
	}

	public void setCardnumber(String cardnumber) {
		this.cardnumber = cardnumber;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIsadmin() {
		return isadmin;
	}

	public void setIsadmin(String isadmin) {
		this.isadmin = isadmin;
	}

	public String getIsfinance() {
		return isfinance;
	}

	public void setIsfinance(String isfinance) {
		this.isfinance = isfinance;
	}

	public String getIstrader() {
		return istrader;
	}

	public void setIstrader(String istrader) {
		this.istrader = istrader;
	}

	public String getEnable() {
		return enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}

	public String getTradername() {
		return tradername;
	}

	public void setTradername(String tradername) {
		this.tradername = tradername;
	}

	public String getTradertype() {
		return tradertype;
	}

	public void setTradertype(String tradertype) {
		this.tradertype = tradertype;
	}

	public String getCertifiedstatus() {
		return certifiedstatus;
	}

	public void setCertifiedstatus(String certifiedstatus) {
		this.certifiedstatus = certifiedstatus;
	}

}