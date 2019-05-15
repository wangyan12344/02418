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
 * 表zl_b_news 的实体类
 * @author 齐建军
 */
@Entity(name = "zl_b_news")
public class ZlBNews extends BaseEntity implements Serializable, Cloneable {
	
	private static final long serialVersionUID = 2771520536458495846L;
	
	public ZlBNews clone() {
		ZlBNews o = null;
		try {
			o = (ZlBNews) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return o;
	}
	
	/**
	 *新闻id
	 */
    @ID
	@Column(name = "newsid", comment = "新闻id")
	private String newsid;
	/**
	 *新闻标题
	 */
	@Column(name = "newstitle", comment = "新闻标题")
	private String newstitle;
	/**
	 *新闻内容
	 */
	@Column(name = "newscontent", comment = "新闻内容")
	private String newscontent;
	/**
	 *所属分类id
	 */
	@Column(name = "categoryid", comment = "所属分类id")
	private String categoryid;
	/**
	 *发布时间
	 */
	@Column(name = "publishtime", comment = "发布时间")
	private String publishtime;
	/**
	 *发布人id
	 */
	@Column(name = "publisherid", comment = "发布人id")
	private String publisherid;
	/**
	 *主图路径
	 */
	@Column(name = "mainimgpath", comment = "主图路径")
	private String mainimgpath;
	/**
	 *是否首页显示
	 */
	@Column(name = "isHomePage", comment = "是否首页显示")
	private String isHomePage;
	/**
	 *是否置顶
	 */
	@Column(name = "istop", comment = "是否置顶")
	private String istop;
	/**
	 *新闻模板id
	 */
	@Column(name = "templateid", comment = "新闻模板id")
	private String templateid;
	/**
	 *序号
	 */
	@Column(name = "ordernum", comment = "序号")
	private String ordernum;
	/**
	 *简介
	 */
	@Column(name = "newsintro", comment = "简介")
	private String newsintro;
	
	/**
	 * 0.玉米
	 * 1.水稻
	 * 2.大豆
	 */
	@Column(name = "graintype", comment = "粮食种类")
	private String graintype;
	
	/**
	 * 新闻访问量
	 */
	@Column(name = "visitnum", comment = "新闻访问量")
	private String visitnum;
	
	/**
	 *是否app推送
	 */
	@Column(name = "ispush", comment = "是否app推送")
	private String ispush;
	/**
	 *父级别id
	 */
	@Column(name = "parentid", comment = "父级别id")
	private String parentid;
	/**
	 *父级别id
	 */
	@Column(name = "ishot", comment = "是否热点")
	private String ishot;
	/**
	 *阅读百分比
	 */
	@Transient
	@Column(name="percent",comment="阅读百分比")
	private String percent;
	/**
	 *创建者id
	 */
	@Column(name = "adduserid", comment = "创建者id")
	private String adduserid;
	/**
	 *是否突出显示
	 */
	@Column(name = "prominent", comment = "是否突出显示")
	private String prominent;
	
	/**
	 *最后更新者
	 */
	@Column(name = "updateuserid", comment = "最后更新者")
	private String updateuserid;
	
	
	/**
	 *最后更新者
	 */
	@Column(name = "department", comment = "部门id")
	private String department;
	
	
	/**
	 *最后更新者
	 */
	@Column(name = "departmentuser", comment = "部门投稿人id")
	private String departmentuser;
	/**
	 *最后更新者
	 */
	@Transient
	@Column(name = "departmentname", comment = "部门名称")
	private String departmentname;
	
	
	/**
	 *最后更新者
	 */
	@Transient
	@Column(name = "departmentusername", comment = "部门投稿人名称")
	private String departmentusername;
	/**
	 *总数量
	 */
	@Transient
	@Column(name="count",comment="总数量")
	private String count;
	
	/**
	 *type 1父级别id 0 子类
	 */
	@Transient
	@Column(name="type",comment="类别")
	private String type;
	
	/**
	 *总阅读量
	 */
	@Transient
	@Column(name="visitcount",comment="总阅读量")
	private String visitcount;
	/**
	 *分类名称
	 */
	@Transient
	@Column(name="categoryname",comment="分类名称")
	private String categoryname;
	/**
	 * 发布时间
	 */
	@Transient
	@Column(name="ctime",comment="发布时间")
	private String ctime;
	/**
	 * 月
	 */
	@Transient
	@Column(name="mm",comment=" 月")
	private String mm;
	
	/**
	 * 日
	 */
	@Transient
	@Column(name="dd",comment="日")
	private String dd;
	/**
	 * 分类跳转标签
	 */
	@Transient
	@Column(name="classurl",comment="分类跳转标签")
	private String classurl;
	/**
	 * 父级别分类名称
	 */
	@Transient
	@Column(name="parentidclassname",comment="父级别分类名称")
	private String parentidclassname;
	/**
	 * 阅读级别，数越大权限越大
	 */
	@Transient
	@Column(name="permissions",comment="阅读级别，数越大权限越大")
	private String permissions;
	
	/**
	 * ipaddress
	 */
	@Transient
	@Column(name="ipaddress",comment="ipaddress")
	private String ipaddress;
	/**
	 * username
	 */
	@Transient
	@Column(name="username",comment="username")
	private String username;
	
	@Transient
	@Column(name = "packtypes", comment = "附件名称")
	private String packtypes;
	
	@Transient
	@Column(name = "packprices", comment = "附件文件")
	private String packprices;
	
	@Transient
	@Column(name = "List<ZlBNewsAttach>", comment = "附件文件")
	private List<ZlBNewsAttach> zlbnewsattachlist;
	
	
	@Transient
	@Column(name = "praisenum", comment = "点赞数")
	private String praisenum;
	
	@Transient
	@Column(name = "stime", comment = "开始时间")
	private String stime;
	@Transient
	@Column(name = "etime", comment = "结束时间")
	private String etime;
	
	@Transient
	@Column(name = "parentname", comment = "parentname")
	private String  parentname;
	
	
	@Transient
	@Column(name = "sysname", comment = "sysname")
	private String  sysname;
	
	
	
	public String getSysname() {
		return sysname;
	}

	public void setSysname(String sysname) {
		this.sysname = sysname;
	}

	public String getParentname() {
		return parentname;
	}

	public void setParentname(String parentname) {
		this.parentname = parentname;
	}

	public String getStime() {
		return stime;
	}

	public void setStime(String stime) {
		this.stime = stime;
	}

	public String getEtime() {
		return etime;
	}

	public void setEtime(String etime) {
		this.etime = etime;
	}

	public String getPraisenum() {
		return praisenum;
	}

	public void setPraisenum(String praisenum) {
		this.praisenum = praisenum;
	}

	public List<ZlBNewsAttach> getZlbnewsattachlist() {
		return zlbnewsattachlist;
	}

	public void setZlbnewsattachlist(List<ZlBNewsAttach> zlbnewsattachlist) {
		this.zlbnewsattachlist = zlbnewsattachlist;
	}

	public String getPacktypes() {
		return packtypes;
	}

	public void setPacktypes(String packtypes) {
		this.packtypes = packtypes;
	}

	public String getPackprices() {
		return packprices;
	}

	public void setPackprices(String packprices) {
		this.packprices = packprices;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getIpaddress() {
		return ipaddress;
	}

	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}

	public String getClassurl() {
		return classurl;
	}

	public void setClassurl(String classurl) {
		this.classurl = classurl;
	}

	public String getParentidclassname() {
		return parentidclassname;
	}

	public void setParentidclassname(String parentidclassname) {
		this.parentidclassname = parentidclassname;
	}

	public String getProminent() {
		return prominent;
	}

	public void setProminent(String prominent) {
		this.prominent = prominent;
	}

	public String getIshot() {
		return ishot;
	}

	public void setIshot(String ishot) {
		this.ishot = ishot;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPermissions() {
		return permissions;
	}

	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}

	public String getMm() {
		return mm;
	}

	public void setMm(String mm) {
		this.mm = mm;
	}

	public String getDd() {
		return dd;
	}

	public void setDd(String dd) {
		this.dd = dd;
	}

	public String getCtime() {
		return ctime;
	}

	public void setCtime(String ctime) {
		this.ctime = ctime;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public String getParentid() {
		return parentid;
	}

	public void setParentid(String parentid) {
		this.parentid = parentid;
	}

	public String getPercent() {
		return percent;
	}

	public void setPercent(String percent) {
		this.percent = percent;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getVisitcount() {
		return visitcount;
	}

	public void setVisitcount(String visitcount) {
		this.visitcount = visitcount;
	}

	public String getIspush() {
		return ispush;
	}

	public void setIspush(String ispush) {
		this.ispush = ispush;
	}
	
	
	public String getVisitnum() {
		return visitnum;
	}

	public void setVisitnum(String visitnum) {
		this.visitnum = visitnum;
	}

	public String getGraintype() {
		return graintype;
	}

	public void setGraintype(String graintype) {
		this.graintype = graintype;
	}

	public String getNewsintro() {
		return newsintro;
	}

	public void setNewsintro(String newsintro) {
		this.newsintro = newsintro;
	}

	public String getNewsid() {
		 return newsid;
	}
	
	public void setNewsid(String newsid) {
		 this.newsid = newsid;
	}
	
	public String getNewstitle() {
		 return newstitle;
	}
	
	public void setNewstitle(String newstitle) {
		 this.newstitle = newstitle;
	}
	
	public String getNewscontent() {
		 return newscontent;
	}
	
	public void setNewscontent(String newscontent) {
		 this.newscontent = newscontent;
	}
	
	public String getCategoryid() {
		 return categoryid;
	}
	
	public void setCategoryid(String categoryid) {
		 this.categoryid = categoryid;
	}
	
	public String getPublishtime() {
		 return publishtime;
	}
	
	public void setPublishtime(String publishtime) {
		 this.publishtime = publishtime;
	}
	
	public String getPublisherid() {
		 return publisherid;
	}
	
	public void setPublisherid(String publisherid) {
		 this.publisherid = publisherid;
	}
	
	public String getMainimgpath() {
		 return mainimgpath;
	}
	
	public void setMainimgpath(String mainimgpath) {
		 this.mainimgpath = mainimgpath;
	}
	
	public String getIsHomePage() {
		 return isHomePage;
	}
	
	public void setIsHomePage(String isHomePage) {
		 this.isHomePage = isHomePage;
	}
	
	public String getIstop() {
		 return istop;
	}
	
	public void setIstop(String istop) {
		 this.istop = istop;
	}
	
	public String getTemplateid() {
		 return templateid;
	}
	
	public void setTemplateid(String templateid) {
		 this.templateid = templateid;
	}
	
	public String getOrdernum() {
		 return ordernum;
	}
	
	public void setOrdernum(String ordernum) {
		 this.ordernum = ordernum;
	}

	public String getAdduserid() {
		return adduserid;
	}

	public void setAdduserid(String adduserid) {
		this.adduserid = adduserid;
	}

	public String getUpdateuserid() {
		return updateuserid;
	}

	public void setUpdateuserid(String updateuserid) {
		this.updateuserid = updateuserid;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDepartmentuser() {
		return departmentuser;
	}

	public void setDepartmentuser(String departmentuser) {
		this.departmentuser = departmentuser;
	}

	public String getDepartmentname() {
		return departmentname;
	}

	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}

	public String getDepartmentusername() {
		return departmentusername;
	}

	public void setDepartmentusername(String departmentusername) {
		this.departmentusername = departmentusername;
	}
	
}