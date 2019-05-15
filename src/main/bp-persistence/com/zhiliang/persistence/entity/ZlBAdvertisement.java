package com.zhiliang.persistence.entity;

import java.io.Serializable;
import java.util.Date;
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
@Entity(name = "zl_advertisement")
public class ZlBAdvertisement extends BaseEntity implements Serializable, Cloneable {

	private static final long serialVersionUID = 2771520536458455846L;
	
	public ZlBAdvertisement clone() {
		ZlBAdvertisement o = null;
		try {
			o = (ZlBAdvertisement) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return o;
	}
	
	@ID
	@Column(name = "id", comment = "主键id")
	private String id;
 
	@Column(name = "starttime", comment = "开始时间")
	private String starttime;
 
	@Column(name = "endtime", comment = "截止时间")
	private String endtime;
 
	@Column(name = "company", comment = "公司")
	private String company;
 
	@Column(name = "second", comment = "显示时长")
	private String second;

	@Column(name = "status", comment = "启用状态")
	private String status;
	
	@Column(name = "tag", comment = "显示端区别")
	private String tag;
	
	@Column(name = "img", comment = "图片")
	private String img;
	@Column(name = "imgurl", comment = "图片跳转地址")
	private String imgurl;
	@Transient
	@Column(name = "pname", comment = "分类名称")
	private String pname;
	
	
	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStarttime() {
		return starttime;
	}

	public String getEndtime() {
		return endtime;
	}

	public String getCompany() {
		return company;
	}

	public String getSecond() {
		return second;
	}

	public String getStatus() {
		return status;
	}

	public String getTag() {
		return tag;
	}

	public String getImg() {
		return img;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public void setSecond(String second) {
		this.second = second;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public void setImg(String img) {
		this.img = img;
	}

	
 
	
	
}