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
@Entity(name = "zl_b_count")
public class ZlBCount extends BaseEntity implements Serializable, Cloneable {

	private static final long serialVersionUID = 2771520536458495846L;
	
	public ZlBCount clone() {
		ZlBCount o = null;
		try {
			o = (ZlBCount) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return o;
	}
	
	@ID
	@Column(name = "id", comment = "流水id")
	private String id;
	

 
	@Column(name = "totalcount", comment = "访问总量")
	private String totalcount;
 
	@Column(name = "daycount", comment = "当日访问总量")
	private String daycount;
 
	@Column(name = "pcount", comment = "在线人数，10分钟内视为在线")
	private String pcount;
 
	@Column(name = "ctime", comment = "更新时间")
	private String ctime;
 
 
 	public  void setId(String id){
		this.id =  id;
	}
	
	public String getId(){
		return this.id;
	}
	
 
	public  void setTotalcount(String totalcount){
		this.totalcount =  totalcount;
	}
	
	public String getTotalcount(){
		return this.totalcount;
	}
 
	public  void setDaycount(String daycount){
		this.daycount =  daycount;
	}
	
	public String getDaycount(){
		return this.daycount;
	}
 
	public  void setPcount(String pcount){
		this.pcount =  pcount;
	}
	
	public String getPcount(){
		return this.pcount;
	}
 
	public  void setCtime(String ctime){
		this.ctime =  ctime;
	}
	
	public String getCtime(){
		return this.ctime;
	}
 
}