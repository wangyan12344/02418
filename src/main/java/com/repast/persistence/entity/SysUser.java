package com.repast.persistence.entity;

import java.io.Serializable;
import java.util.Date;

import com.repast.core.annotation.Column;
import com.repast.core.annotation.Entity;
import com.repast.core.annotation.ID;
import com.repast.core.system.BaseEntity;

/**
 * 
 * Application name: Application describing:实体类 Copyright:Copyright copy;
 * Company:
 * 
 * @author xxx
 */
@Entity(name = "SYS_USER")
public class SysUser extends BaseEntity implements Serializable, Cloneable {

	private static final long serialVersionUID = -8267243631010886426L;

	public SysUser clone() {

		SysUser o = null;

		try {
			o = (SysUser) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

		return o;
	}

	/**
      *
      *
     */
	@ID
	@Column(name = "ID", comment = "id")
	private String id;

	/**
	 * 用户名
	 *
	 */

	@Column(name = "USERNAME", comment = "用户名")
	private String username;

	/**
	 * 用户类别0系统用户1餐厅用户2食客
	 *
	 */

	@Column(name = "USERTYPE", comment = "用户类别")
	private String usertype;

	/**
	 * 餐厅id
	 *
	 */

	@Column(name = "RESTAURANTID", comment = "机构id")
	private String restaurantid;

	/**
	 * 性别0男1女
	 *
	 */

	@Column(name = "SEX", comment = "性别0男1女")
	private String sex;

	/**
	 * 联系电话
	 *
	 */

	@Column(name = "PHONE", comment = "联系电话")
	private String phone;

	/**
	 * 联系地址
	 *
	 */

	@Column(name = "ADDRESS", comment = "联系地址")
	private String address;

	/**
	 * 邮件
	 *
	 */

	@Column(name = "EMAIL", comment = "邮件")
	private String email;

	/**
	 * QQ
	 *
	 */

	@Column(name = "QQ", comment = "QQ")
	private String qq;

	/**
	 * 启用状态0未启用1启用
	 *
	 */

	@Column(name = "ENABLED", comment = "启用状态0未启用1启用")
	private String enabled;

	/**
	 * 账号
	 *
	 */

	@Column(name = "ACCOUNT", comment = "账号")
	private String account;

	/**
	 * 密码
	 *
	 */

	@Column(name = "PASSWORD", comment = "密码")
	private String password;

	/**
	 * 出生年月日
	 *
	 */
	@Column(name = "BIRTHDAY", comment = "出生年月日")
	private Date birthday;
	
	/**
	 * 角色id－－－店内员工冗余字段
	 * */
	@Column(name = "ROLEID", comment = "角色")
	private String roleid;
	
	/**
	 * 超级管理员－1为超级管理员
	 */
	@Column(name="SUPERADMIN")
	private String superadmin;
	
	
	public String getSuperadmin() {
		return superadmin;
	}

	public void setSuperadmin(String superadmin) {
		this.superadmin = superadmin;
	}
	
	
	public String getRoleid() {
		return roleid;
	}

	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	/**
	 * 
	 * id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return
	 */
	public String getId() {
		return id;
	}

	/**
	 * 用户名
	 * 
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return 用户名
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * 用户类别0系统用户1餐厅用户2食客
	 * 
	 */
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	/**
	 * @return 用户类别0系统用户1餐厅用户2食客
	 */
	public String getUsertype() {
		return usertype;
	}

	/**
	 * 餐厅id
	 * 
	 */
	public void setRestaurantid(String restaurantid) {
		this.restaurantid = restaurantid;
	}

	/**
	 * @return 餐厅id
	 */
	public String getRestaurantid() {
		return restaurantid;
	}

	/**
	 * 性别0男1女
	 * 
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * @return 性别0男1女
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * 联系电话
	 * 
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return 联系电话
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * 联系地址
	 * 
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return 联系地址
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * 邮件
	 * 
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return 邮件
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * QQ
	 * 
	 */
	public void setQq(String qq) {
		this.qq = qq;
	}

	/**
	 * @return QQ
	 */
	public String getQq() {
		return qq;
	}

	/**
	 * 启用状态0未启用1启用
	 * 
	 */
	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	/**
	 * @return 启用状态0未启用1启用
	 */
	public String getEnabled() {
		return enabled;
	}

	/**
	 * 密码
	 * 
	 */
	public void setAccount(String account) {
		this.account = account;
	}

	/**
	 * @return 密码
	 */
	public String getAccount() {
		return account;
	}

	/**
	 * 密码
	 * 
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return 密码
	 */
	public String getPassword() {
		return password;
	}

}
