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
 * 表zl_b_news 的实体类
 * @author 齐建军
 */
@Entity(name = "zl_b_news_praise")
public class ZlBNewsPraise extends BaseEntity implements Serializable, Cloneable {
	
	private static final long serialVersionUID = 2771520536458495846L;
	
	public ZlBNewsPraise clone() {
		ZlBNewsPraise o = null;
		try {
			o = (ZlBNewsPraise) super.clone();
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
	 *新闻id
	 */
	@Column(name = "newsid", comment = "新闻id")
	private String newsid;
	/**
	 *ip地址
	 */
	@Column(name = "ipaddress", comment = "ip地址")
	private String ipaddress;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNewsid() {
		return newsid;
	}
	public void setNewsid(String newsid) {
		this.newsid = newsid;
	}
	public String getIpaddress() {
		return ipaddress;
	}
	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}
	
	
}