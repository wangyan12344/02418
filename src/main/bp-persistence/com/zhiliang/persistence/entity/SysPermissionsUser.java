package com.zhiliang.persistence.entity;

import java.io.Serializable;

import com.repast.core.annotation.Column;
import com.repast.core.annotation.Entity;
import com.repast.core.annotation.ID;
import com.repast.core.annotation.Transient;
import com.repast.core.system.BaseEntity;

/**
 * @author 
 */
@Entity(name = "sys_permissions_user")
public class SysPermissionsUser extends BaseEntity implements Serializable, Cloneable {

	private static final long serialVersionUID = 2771520536458495846L;
	
	public SysPermissionsUser clone() {
		SysPermissionsUser o = null;
		try {
			o = (SysPermissionsUser) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return o;
	}
	
	@ID
	@Column(name = "id", comment = "id")
	private String id;
	

 
	@Column(name = "pname", comment = "角色id")
	private String pname;
 
	@Column(name = "pid", comment = "用户id")
	private String pid;
 
	@Column(name = "num", comment = "分配时间")
	private String num;
 
 
 	public  void setId(String id){
		this.id =  id;
	}
	
	public String getId(){
		return this.id;
	}
	
 
	public  void setPname(String pname){
		this.pname =  pname;
	}
	
	public String getPname(){
		return this.pname;
	}
 
	public  void setPid(String pid){
		this.pid =  pid;
	}
	
	public String getPid(){
		return this.pid;
	}
 
	public  void setNum(String num){
		this.num =  num;
	}
	
	public String getNum(){
		return this.num;
	}
 
}