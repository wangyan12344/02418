package com.zhiliang.persistence.entity;

import java.io.Serializable;

import com.repast.core.annotation.Column;
import com.repast.core.annotation.Entity;
import com.repast.core.annotation.ID;
import com.repast.core.annotation.Transient;
import com.repast.core.system.BaseEntity;


@Entity(name = "zl_b_app_activity")
public class ZlBAppActivity extends BaseEntity implements Serializable, Cloneable {
	
private static final long serialVersionUID = 2771520536458495846L;
	
	public ZlBAppActivity clone() {
		ZlBAppActivity o = null;
		try {
			o = (ZlBAppActivity) super.clone();
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
	

	
	@Column(name = "ishas", comment = "活动是否开启")
	private String ishas;
    

	@Column(name = "activityname", comment = "活动名")
	private String activityname;
    

	
	@Column(name = "activityurl", comment = "活动路径")
	private String activityurl;
    

	@Column(name = "ctime", comment = "创建时间")
	private String ctime;
    

	@Column(name = "remark", comment = "备注")
	private String remark;
    
	@Column(name = "remark1", comment = "备注1")
	private String remark1;
    
	@Column(name = "type", comment = "分类")
	private String type;
    @Transient
	@Column(name = "typename", comment = "分类")
	private String typename;
	
	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIshas() {
		return ishas;
	}

	public void setIshas(String ishas) {
		this.ishas = ishas;
	}

	public String getActivityname() {
		return activityname;
	}

	public void setActivityname(String activityname) {
		this.activityname = activityname;
	}

	public String getActivityurl() {
		return activityurl;
	}

	public void setActivityurl(String activityurl) {
		this.activityurl = activityurl;
	}

	public String getCtime() {
		return ctime;
	}

	public void setCtime(String ctime) {
		this.ctime = ctime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRemark1() {
		return remark1;
	}

	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}
    
	
}
