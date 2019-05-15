package com.zhiliang.persistence.entity;

import java.io.Serializable;

import com.repast.core.annotation.Column;
import com.repast.core.annotation.Entity;
import com.repast.core.annotation.ID;
import com.repast.core.system.BaseEntity;

/**
 * 
 * Application name: Application describing:实体类 Copyright:Copyright copy;
 * Company:
 * 表sys_role_menu 的实体类
 * @author 齐建军
 */
@Entity(name = "sys_userid_categoryid")
public class SysUseridCategoryid extends BaseEntity implements Serializable, Cloneable {
	
	private static final long serialVersionUID = 2771520536458495846L;
	
	public SysUseridCategoryid clone() {
		SysUseridCategoryid o = null;
		try {
			o = (SysUseridCategoryid) super.clone();
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
	@Column(name = "userid", comment = "角色id")
	private String userid;
	/**
	 *菜单编码
	 */
	@Column(name = "categoryid", comment = "菜单编码")
	private String categoryid;

	public String getId() {
		 return id;
	}
	
	public void setId(String id) {
		 this.id = id;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(String categoryid) {
		this.categoryid = categoryid;
	}
 
	
}