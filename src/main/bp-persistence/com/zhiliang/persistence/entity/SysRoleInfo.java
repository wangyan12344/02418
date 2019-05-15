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
 * 表sys_role_info 的实体类
 * @author 齐建军
 */
@Entity(name = "sys_role_info")
public class SysRoleInfo extends BaseEntity implements Serializable, Cloneable {
	
	private static final long serialVersionUID = 2771520536458495846L;
	
	public SysRoleInfo clone() {
		SysRoleInfo o = null;
		try {
			o = (SysRoleInfo) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return o;
	}
	
	/**
	 *角色id
	 */
    @ID
	@Column(name = "roleid", comment = "角色id")
	private String roleid;
	/**
	 *角色名称
	 */
	@Column(name = "rolename", comment = "角色名称")
	private String rolename;
	/**
	 *所属机构id
	 */
	@Column(name = "orgid", comment = "所属机构id")
	private String orgid;
	
	/**
	 * 人员角色
	 */
	@Transient
	@Column(name="checked")
	private String checked;

	public String getRoleid() {
		 return roleid;
	}
	
	public void setRoleid(String roleid) {
		 this.roleid = roleid;
	}
	
	public String getRolename() {
		 return rolename;
	}
	
	public void setRolename(String rolename) {
		 this.rolename = rolename;
	}
	
	public String getOrgid() {
		 return orgid;
	}
	
	public void setOrgid(String orgid) {
		 this.orgid = orgid;
	}

	public String getChecked() {
		return checked;
	}

	public void setChecked(String checked) {
		this.checked = checked;
	}
	
	
}