package com.zhiliang.persistence.entity;

import java.io.Serializable;

import com.repast.core.annotation.Column;
import com.repast.core.annotation.Entity;
import com.repast.core.annotation.ID;
import com.repast.core.annotation.Transient;
import com.repast.core.system.BaseEntity;
/**
 * 测试代码生成
 * Application name: Application describing:实体类 Copyright:Copyright copy;
 * Company:沈阳宸阳信息技术有限公司
 * WebSite:http://www.palacesun.com
 * 表ZlBIndexPic 的实体类
 * @author zhouhaifeng
 */
@Entity(name = "zl_b_index_pic")
public class ZlBIndexPic extends BaseEntity implements Serializable, Cloneable {

	private static final long serialVersionUID = 2771520536458495846L;
	
	public ZlBIndexPic clone() {
		ZlBIndexPic o = null;
		try {
			o = (ZlBIndexPic) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return o;
	}
	
	@ID
	@Column(name = "id", comment = "")
	private String id;
	

 
	@Column(name = "imgurl", comment = "图片路径")
	private String imgurl;
 
	@Column(name = "used", comment = "用于何处")
	private String used;
 
	@Column(name = "position", comment = "位置")
	private String position;
 
	@Column(name = "ordernum", comment = "序号")
	private String ordernum;
 
	@Column(name = "remark", comment = "备注")
	private String remark;
 
	@Column(name = "visiturl", comment = "点击图片跳转的路径")
	private String visiturl;
 
	@Column(name = "newscontent", comment = "新闻内容")
	private String newscontent;
 
	@Column(name = "newstitle", comment = "新闻标题")
	private String newstitle;
	
	@Column(name = "publishtime", comment = "新闻发布时间")
	private String publishtime;
	
	@Column(name = "readnum", comment = "阅读量")
	private String readnum;
	
	@Column(name = "introduction", comment = "简介")
	private String introduction;
	
	@Column(name = "isstop", comment = "是否停用 0停用 1启用")
	private String isstop;
	
	
	
	
 	public String getIsstop() {
		return isstop;
	}

	public void setIsstop(String isstop) {
		this.isstop = isstop;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getReadnum() {
		return readnum;
	}

	public void setReadnum(String readnum) {
		this.readnum = readnum;
	}

	public String getPublishtime() {
		return publishtime;
	}

	public void setPublishtime(String publishtime) {
		this.publishtime = publishtime;
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

	public  void setId(String id){
		this.id =  id;
	}
	
	public String getId(){
		return this.id;
	}
	
 
	public  void setImgurl(String imgurl){
		this.imgurl =  imgurl;
	}
	
	public String getImgurl(){
		return this.imgurl;
	}
 
	public  void setUsed(String used){
		this.used =  used;
	}
	
	public String getUsed(){
		return this.used;
	}
 
	public  void setPosition(String position){
		this.position =  position;
	}
	
	public String getPosition(){
		return this.position;
	}
 
	public  void setOrdernum(String ordernum){
		this.ordernum =  ordernum;
	}
	
	public String getOrdernum(){
		return this.ordernum;
	}
 
	public  void setRemark(String remark){
		this.remark =  remark;
	}
	
	public String getRemark(){
		return this.remark;
	}
 
	public  void setVisiturl(String visiturl){
		this.visiturl =  visiturl;
	}
	
	public String getVisiturl(){
		return this.visiturl;
	}
 
}