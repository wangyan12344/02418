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
@Entity(name = "sys_role_menu")
public class SysRoleMenu extends BaseEntity implements Serializable, Cloneable {
	
	private static final long serialVersionUID = 2771520536458495846L;
	
	public SysRoleMenu clone() {
		SysRoleMenu o = null;
		try {
			o = (SysRoleMenu) super.clone();
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
	 *菜单编码
	 */
	@Column(name = "menucode", comment = "菜单编码")
	private String menucode;

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
	
	public String getMenucode() {
		 return menucode;
	}
	
	public void setMenucode(String menucode) {
		 this.menucode = menucode;
	}
	
}