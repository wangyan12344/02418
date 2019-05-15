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
@Entity(name = "zl_b_news_attach")
public class ZlBNewsAttach extends BaseEntity implements Serializable, Cloneable {
	
	private static final long serialVersionUID = 2771520536458495846L;
	
	public ZlBNewsAttach clone() {
		ZlBNewsAttach o = null;
		try {
			o = (ZlBNewsAttach) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return o;
	}
	
	/**
	 *新闻id
	 */
    @ID
	@Column(name = "attachid", comment = "新闻id")
	private String attachid;
	/**
	 *新闻标题
	 */
	@Column(name = "attachtype", comment = "新闻标题")
	private String attachtype;
	/**
	 *新闻内容
	 */
	@Column(name = "attachpath", comment = "新闻内容")
	private String attachpath;
	/**
	 *所属分类id
	 */
	@Column(name = "attachsize", comment = "所属分类id")
	private String attachsize;
	/**
	 *发布时间
	 */
	@Column(name = "newsid", comment = "发布时间")
	private String newsid;
	/**
	 *发布人id
	 */
	@Column(name = "ordernum", comment = "发布人id")
	private String ordernum;
	/**
	 *主图路径
	 */
	@Column(name = "attachtitle", comment = "主图路径")
	private String attachtitle;

	public String getAttachid() {
		return attachid;
	}
	public void setAttachid(String attachid) {
		this.attachid = attachid;
	}
	public String getAttachtype() {
		return attachtype;
	}
	public void setAttachtype(String attachtype) {
		this.attachtype = attachtype;
	}
	public String getAttachpath() {
		return attachpath;
	}
	public void setAttachpath(String attachpath) {
		this.attachpath = attachpath;
	}
	public String getAttachsize() {
		return attachsize;
	}
	public void setAttachsize(String attachsize) {
		this.attachsize = attachsize;
	}
	public String getNewsid() {
		return newsid;
	}
	public void setNewsid(String newsid) {
		this.newsid = newsid;
	}
	public String getOrdernum() {
		return ordernum;
	}
	public void setOrdernum(String ordernum) {
		this.ordernum = ordernum;
	}
	public String getAttachtitle() {
		return attachtitle;
	}
	public void setAttachtitle(String attachtitle) {
		this.attachtitle = attachtitle;
	}
	
}