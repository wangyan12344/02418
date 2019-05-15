package com.zhiliang.persistence.dto;

import java.io.Serializable;

import com.repast.core.system.BaseEntity;

/**
 * 构建ZTree结构
 * @author lingy
 * MenuTreeDTO.java
 */
public class MenuTreeDTO extends BaseEntity implements Serializable, Cloneable {
	
	private static final long serialVersionUID = 2771520536458495846L;
	
	public MenuTreeDTO clone() {
		MenuTreeDTO o = null;
		try {
			o = (MenuTreeDTO) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return o;
	}
	
	private String id;
	
	private String pId;
	
	private String name;
	
	private String open;
	
	private String checked;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOpen() {
		return open;
	}

	public void setOpen(String open) {
		this.open = open;
	}

	public String getChecked() {
		return checked;
	}

	public void setChecked(String checked) {
		this.checked = checked;
	}
	
	
	
	
	
	
}