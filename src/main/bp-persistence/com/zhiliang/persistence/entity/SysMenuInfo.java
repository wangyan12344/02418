package com.zhiliang.persistence.entity;

import java.io.Serializable;
import java.util.List;

import com.repast.core.annotation.Column;
import com.repast.core.annotation.Entity;
import com.repast.core.annotation.ID;
import com.repast.core.annotation.Transient;
import com.repast.core.system.BaseEntity;

/**
 * 
 * Application name: Application describing:实体类 Copyright:Copyright copy;
 * Company:
 * 表sys_menu_info 的实体类
 * @author 齐建军
 */
@Entity(name = "sys_menu_info")
public class SysMenuInfo extends BaseEntity implements Serializable, Cloneable {
	
	private static final long serialVersionUID = 2771520536458495846L;
	
	public SysMenuInfo clone() {
		SysMenuInfo o = null;
		try {
			o = (SysMenuInfo) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return o;
	}
	
	/**
	 *菜单id
	 */
    @ID
	@Column(name = "menuid", comment = "菜单id")
	private String menuid;
	/**
	 *菜单编码
	 */
	@Column(name = "menucode", comment = "菜单编码")
	private String menucode;
	/**
	 *菜单名称
	 */
	@Column(name = "menuname", comment = "菜单名称")
	private String menuname;
	/**
	 *菜单类型 1为web端菜单 2 为app端菜单
	 */
	@Column(name = "menutype", comment = "菜单类型 1为web端菜单 2 为app端菜单")
	private String menutype;
	/**
	 *上级菜单编码
	 */
	@Column(name = "parentmenucode", comment = "上级菜单编码")
	private String parentmenucode;
	/**
	 *菜单路径
	 */
	@Column(name = "menupath", comment = "菜单路径")
	private String menupath;
	/**
	 *序号
	 */
	@Column(name = "ordernum", comment = "序号")
	private String ordernum;

	/**
	 * 下级菜单
	 */
	@Transient
	private List<SysMenuInfo> childrenMenu;
	
	public String getMenuid() {
		 return menuid;
	}
	
	public void setMenuid(String menuid) {
		 this.menuid = menuid;
	}
	
	public String getMenucode() {
		 return menucode;
	}
	
	public void setMenucode(String menucode) {
		 this.menucode = menucode;
	}
	
	public String getMenuname() {
		 return menuname;
	}
	
	public void setMenuname(String menuname) {
		 this.menuname = menuname;
	}
	
	public String getMenutype() {
		 return menutype;
	}
	
	public void setMenutype(String menutype) {
		 this.menutype = menutype;
	}
	
	public String getParentmenucode() {
		 return parentmenucode;
	}
	
	public void setParentmenucode(String parentmenucode) {
		 this.parentmenucode = parentmenucode;
	}
	
	public String getMenupath() {
		 return menupath;
	}
	
	public void setMenupath(String menupath) {
		 this.menupath = menupath;
	}
	
	public String getOrdernum() {
		 return ordernum;
	}
	
	public void setOrdernum(String ordernum) {
		 this.ordernum = ordernum;
	}

	public List<SysMenuInfo> getChildrenMenu() {
		return childrenMenu;
	}

	public void setChildrenMenu(List<SysMenuInfo> childrenMenu) {
		this.childrenMenu = childrenMenu;
	}
	
	
	
}