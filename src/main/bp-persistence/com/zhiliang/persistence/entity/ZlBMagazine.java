package com.zhiliang.persistence.entity;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.repast.core.annotation.Column;
import com.repast.core.annotation.Entity;
import com.repast.core.annotation.ID;
import com.repast.core.annotation.Transient;
import com.repast.core.system.BaseEntity;

/**
 * @author wy
 */
@Entity(name = "zl_b_magazine")
public class ZlBMagazine extends BaseEntity implements Serializable, Cloneable {

	private static final long serialVersionUID = 2771520536458495846L;
	
	public ZlBMagazine clone() {
		ZlBMagazine o = null;
		try {
			o = (ZlBMagazine) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return o;
	}
	
	@ID
	@Column(name = "id", comment = "id")
	private String id;
	

 
	@Column(name = "title", comment = "标题")
	private String title;
 
	@Column(name = "intro", comment = "简介")
	private String intro;
 
	@Column(name = "imgurl", comment = "图片路径")
	private String imgurl;
 
	@Column(name = "ctime", comment = "更新时间")
	private String ctime;
	 
	@Column(name = "url", comment = "链接地址")
	private String url;
	
	@Column(name = "status", comment = "是否启用")
	private String status;
	
	@Column(name = "num", comment = "是否启用")
	private String num;
	
	
 	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public  void setId(String id){
		this.id =  id;
	}
	
	public String getId(){
		return this.id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
 

	public String getCtime() {
		return ctime;
	}

	public void setCtime(String ctime) {
		this.ctime = ctime;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
  
 
}