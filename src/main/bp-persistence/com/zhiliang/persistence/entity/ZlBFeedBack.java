package com.zhiliang.persistence.entity;

import java.io.Serializable;

import com.repast.core.annotation.Column;
import com.repast.core.annotation.Entity;
import com.repast.core.annotation.ID;
import com.repast.core.annotation.Transient;
import com.repast.core.system.BaseEntity;
/**
 * 意见反馈
 * @author superma
 */
@Entity(name = "zl_b_feedback")
public class ZlBFeedBack extends BaseEntity implements Serializable, Cloneable {

	private static final long serialVersionUID = 2771520536458455846L;
	
	public ZlBFeedBack clone() {
		ZlBFeedBack o = null;
		try {
			o = (ZlBFeedBack) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return o;
	}
	
	@ID
	@Column(name = "id", comment = "主键id")
	private String id;
 
	@Column(name = "comment", comment = "意见内容")
	private String comment;
 
	@Column(name = "name", comment = "姓名")
	private String name;
 
	@Column(name = "tel", comment = "电话")
	private String tel;
 
	@Column(name = "createtime", comment = "创建时间")
	private String createtime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
 
 
	
	
}