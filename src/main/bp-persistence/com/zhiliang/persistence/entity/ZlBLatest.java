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
@Entity(name = "zl_b_latest")
public class ZlBLatest extends BaseEntity implements Serializable, Cloneable {

	private static final long serialVersionUID = 2731520336458455846L;
	
	public ZlBLatest clone() {
		ZlBLatest o = null;
		try {
			o = (ZlBLatest) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return o;
	}
	
	@ID
	@Column(name = "id", comment = "主键id")
	private String id;
 
	@Column(name = "comment", comment = "内容")
	private String comment;
 
	@Column(name = "intro", comment = "标题")
	private String intro;
 
	@Column(name = "publistime", comment = "发布日期")
	private String publistime;
 

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

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getPublistime() {
		return publistime;
	}

	public void setPublistime(String publistime) {
		this.publistime = publistime;
	}

 
 
	
	
}