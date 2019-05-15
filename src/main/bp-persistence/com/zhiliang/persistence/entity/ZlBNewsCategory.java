package com.zhiliang.persistence.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.repast.core.annotation.Column;
import com.repast.core.annotation.Entity;
import com.repast.core.annotation.ID;
import com.repast.core.annotation.Transient;
import com.repast.core.system.BaseEntity;

/**
 *
 */
@Entity(name = "zl_b_news_category")
public class ZlBNewsCategory extends BaseEntity implements Serializable, Cloneable {
	
	private static final long serialVersionUID = 2771520536458495846L;
	
	public ZlBNewsCategory clone() {
		ZlBNewsCategory o = null;
		try {
			o = (ZlBNewsCategory) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return o;
	}
	
	/**
	 *分类id
	 */
    @ID
	@Column(name = "categoryid", comment = "分类id")
	private String categoryid;
	/**
	 *分类名称
	 */
	@Column(name = "categoryname", comment = "分类名称")
	private String categoryname;
	/**
	 *序号
	 */
	@Column(name = "ordernum", comment = "序号")
	private String ordernum;
	/**
	 * 图片路径
	 * @return
	 */
	@Column(name = "picturepath", comment = "图片路径")
	private String picturepath;
	/**
	 * 新闻客户端
	 * @return
	 */
	@Column(name = "client", comment = "新闻客户端")
	private String client;
	
	
	/**
	 * 新闻客户端
	 * @return
	 */
	@Column(name = "level", comment = "新闻客户端")
	private String level;
	
	/**
	 * 新闻客户端
	 * @return
	 */
	@Column(name = "parentid", comment = "新闻客户端")
	private String parentid;
	
	/**
	 * 新闻客户端
	 * @return
	 */
	@Column(name = "imgurl", comment = "新闻客户端")
	private String imgurl;
	
	/**
	 * 新闻客户端
	 * @return
	 */
	@Column(name = "rootid", comment = "新闻客户端")
	private String rootid;
	
	/**
	 * 首页图标
	 * @return
	 */
	@Column(name = "indeximgurl", comment = "首页图标")
	private String indeximgurl;
	
	
	/**
	 * 是否启用0未启用1启用
	 * @return
	 */
	@Column(name = "status", comment = "是否启用0未启用1启用")
	private String status;
	/**
	 * 阅读级别，数越大权限越大
	 * @return
	 */
	@Column(name = "permissions", comment = "阅读级别，数越大权限越大")
	private String permissions;
	/**
	 * 阅读级别，数越大权限越大
	 * @return
	 */
	@Column(name = "content", comment = "阅读级别，数越大权限越大")
	private String content;
	/**
	 * 阅读级别，数越大权限越大
	 * @return
	 */
	@Column(name = "url", comment = "菜单地址")
	private String url;
	/**
	 * 阅读级别，数越大权限越大
	 * @return
	 */
	@Column(name = "urlnum", comment = "菜单排序")
	private String urlnum;
	
	/**
	 * 0不锁定 1 锁定,锁定不能删除，不能改排序
	 * @return
	 */
	@Column(name = "suoding", comment = "0不锁定 1 锁定,锁定不能删除，不能改排序")
	private String suoding;
	
	
	public String getSuoding() {
		return suoding;
	}

	public void setSuoding(String suoding) {
		this.suoding = suoding;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrlnum() {
		return urlnum;
	}

	public void setUrlnum(String urlnum) {
		this.urlnum = urlnum;
	}

	/**
	 *二级类别名称
	 */
	@Transient
	@Column(name = "sname", comment = "二级类别名称")
	private String sname;
	
	@Transient
	@Column(name = "zlBNewslist", comment = "新闻列表")
	private List<ZlBNews> zlBNewslist;
	
	/**
	 *阅读级别名称
	 */
	@Transient
	@Column(name = "pname", comment = "阅读级别名称")
	private String pname;
	
	
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<ZlBNews> getZlBNewslist() {
		return zlBNewslist;
	}
	/**
	 * 新闻实体
	 */
	@Transient
	@Column(name="zlbnews",comment="新闻实体")
	private ZlBNews zlbnews;
	
	
	public ZlBNews getZlbnews() {
		return zlbnews;
	}

	public void setZlbnews(ZlBNews zlbnews) {
		this.zlbnews = zlbnews;
	}

	public void setZlBNewslist(List<ZlBNews> zlBNewslist) {
		this.zlBNewslist = zlBNewslist;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPermissions() {
		return permissions;
	}

	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getCategoryid() {
		 return categoryid;
	}
	
	public void setCategoryid(String categoryid) {
		 this.categoryid = categoryid;
	}
	
	public String getCategoryname() {
		 return categoryname;
	}
	
	public void setCategoryname(String categoryname) {
		 this.categoryname = categoryname;
	}
	
	public String getOrdernum() {
		 return ordernum;
	}
	
	public void setOrdernum(String ordernum) {
		 this.ordernum = ordernum;
	}

	public String getPicturepath() {
		return picturepath;
	}

	public void setPicturepath(String picturepath) {
		this.picturepath = picturepath;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getParentid() {
		return parentid;
	}

	public void setParentid(String parentid) {
		this.parentid = parentid;
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	public String getRootid() {
		return rootid;
	}

	public void setRootid(String rootid) {
		this.rootid = rootid;
	}

	public String getIndeximgurl() {
		return indeximgurl;
	}

	public void setIndeximgurl(String indeximgurl) {
		this.indeximgurl = indeximgurl;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}