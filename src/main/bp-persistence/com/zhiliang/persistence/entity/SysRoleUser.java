package com.zhiliang.persistence.entity;

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
 * 表sys_role_user 的实体类
 * @author 齐建军
 */
@Entity(name = "sys_role_user")
public class SysRoleUser extends BaseEntity implements Serializable, Cloneable {
	
	private static final long serialVersionUID = 2771520536458495846L;
	
	public SysRoleUser clone() {
		SysRoleUser o = null;
		try {
			o = (SysRoleUser) super.clone();
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
	 *角色id
	 */
	@Column(name = "roleid", comment = "角色id")
	private String roleid;
	/**
	 *用户id
	 */
	@Column(name = "userid", comment = "用户id")
	private String userid;
	/**
	 *分配时间
	 */
	@Column(name = "optime", comment = "分配时间")
	private Date optime;

	public String getId() {
		 return id;
	}
	
	public void setId(String id) {
		 this.id = id;
	}
	
	public String getRoleid() {
		 return roleid;
	}
	
	public void setRoleid(String roleid) {
		 this.roleid = roleid;
	}
	
	public String getUserid() {
		 return userid;
	}
	
	public void setUserid(String userid) {
		 this.userid = userid;
	}

	public Date getOptime() {
		return optime;
	}

	public void setOptime(Date optime) {
		this.optime = optime;
	}
	
}