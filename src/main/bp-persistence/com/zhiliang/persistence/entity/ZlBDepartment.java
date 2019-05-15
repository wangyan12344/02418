package com.zhiliang.persistence.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.repast.core.annotation.Column;
import com.repast.core.annotation.Entity;
import com.repast.core.annotation.ID;
import com.repast.core.annotation.Transient;
import com.repast.core.system.BaseEntity;

/**
 * 
 * Application name: Application describing:B端app首页活动实体类 Copyright:Copyright copy;
 * Company:沈阳宸阳信息技术有限公司
 * WebSite:http://www.palacesun.com
 * 表ZlBDepartment 的实体类
 * @author 
 */
@Entity(name = "zl_b_department")
public class ZlBDepartment extends BaseEntity implements Serializable, Cloneable {

	private static final long serialVersionUID = 2771520536458495846L;
	
	public ZlBDepartment clone() {
		ZlBDepartment o = null;
		try {
			o = (ZlBDepartment) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return o;
	}
	
	@ID
	@Column(name = "id", comment = "")
	private String id;
	

 
	@Column(name = "departmentname", comment = "部门名称")
	private String departmentname;
 
	@Column(name = "num", comment = "排序")
	private String num;
	@Transient
	@Column(name = "newsnum", comment = "排序")
	private String newsnum;
	@Transient
	@Column(name = "stime", comment = "开始时间")
	private String stime;
	@Transient
	@Column(name = "etime", comment = "结束时间")
	private String etime;
	
	@Transient
	private List<ZlBDepartment> ZlBDepartmentlist;
	
 	public List<ZlBDepartment> getZlBDepartmentlist() {
		return ZlBDepartmentlist;
	}

	public void setZlBDepartmentlist(List<ZlBDepartment> zlBDepartmentlist) {
		ZlBDepartmentlist = zlBDepartmentlist;
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

	public String getNewsnum() {
		return newsnum;
	}

	public void setNewsnum(String newsnum) {
		this.newsnum = newsnum;
	}

	public  void setId(String id){
		this.id =  id;
	}
	
	public String getId(){
		return this.id;
	}
	
 
	public  void setDepartmentname(String departmentname){
		this.departmentname =  departmentname;
	}
	
	public String getDepartmentname(){
		return this.departmentname;
	}
 
	public  void setNum(String num){
		this.num =  num;
	}
	
	public String getNum(){
		return this.num;
	}
 
}