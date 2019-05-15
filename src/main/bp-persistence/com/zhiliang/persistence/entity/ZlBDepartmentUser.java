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
 * 
 * Application name: Application describing:B端app首页活动实体类 Copyright:Copyright copy;
 * Company:沈阳宸阳信息技术有限公司
 * WebSite:http://www.palacesun.com
 * 表ZlBDepartmentUser 的实体类
 * @author 
 */
@Entity(name = "zl_b_department_user")
public class ZlBDepartmentUser extends BaseEntity implements Serializable, Cloneable {

	private static final long serialVersionUID = 2771520536458495846L;
	
	public ZlBDepartmentUser clone() {
		ZlBDepartmentUser o = null;
		try {
			o = (ZlBDepartmentUser) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return o;
	}
	
	@ID
	@Column(name = "id", comment = "")
	private String id;
	

 
	@Column(name = "departmentid", comment = "部门名称")
	private String departmentid;
 
	@Column(name = "num", comment = "排序")
	private String num;
 
	@Column(name = "departmentuser", comment = "")
	private String departmentuser;
	@Transient
	@Column(name = "departmentname", comment = "")
	private String departmentname;
	
	@Transient
	@Column(name = "newsnum", comment = "")
	private String  newsnum;
	@Transient
	@Column(name = "months", comment = "")
	private String  months;
	
  

	public String getMonths() {
		return months;
	}

	public void setMonths(String months) {
		this.months = months;
	}

	public String getNewsnum() {
		return newsnum;
	}

	public void setNewsnum(String newsnum) {
		this.newsnum = newsnum;
	}

	public String getDepartmentname() {
		return departmentname;
	}

	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}

	public  void setId(String id){
		this.id =  id;
	}
	
	public String getId(){
		return this.id;
	}
	
 
	public  void setDepartmentid(String departmentid){
		this.departmentid =  departmentid;
	}
	
	public String getDepartmentid(){
		return this.departmentid;
	}
 
	public  void setNum(String num){
		this.num =  num;
	}
	
	public String getNum(){
		return this.num;
	}
 
	public  void setDepartmentuser(String departmentuser){
		this.departmentuser =  departmentuser;
	}
	
	public String getDepartmentuser(){
		return this.departmentuser;
	}
 
}