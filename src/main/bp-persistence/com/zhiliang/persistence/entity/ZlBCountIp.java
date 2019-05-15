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
 * @author wy
 */
@Entity(name = "zl_b_count_ip")
public class ZlBCountIp extends BaseEntity implements Serializable, Cloneable {

	private static final long serialVersionUID = 2771520536458495846L;
	
	public ZlBCountIp clone() {
		ZlBCountIp o = null;
		try {
			o = (ZlBCountIp) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return o;
	}
	
	@ID
	@Column(name = "id", comment = "流水id")
	private String id;
	

 
	@Column(name = "ipaddress", comment = "ip地址")
	private String ipaddress;
 
	@Column(name = "updatetime", comment = "最后更新时间")
	private String updatetime;
 
 
 	public  void setId(String id){
		this.id =  id;
	}
	
	public String getId(){
		return this.id;
	}
	
 
	public  void setIpaddress(String ipaddress){
		this.ipaddress =  ipaddress;
	}
	
	public String getIpaddress(){
		return this.ipaddress;
	}
 
	public  void setUpdatetime(String updatetime){
		this.updatetime =  updatetime;
	}
	
	public String getUpdatetime(){
		return this.updatetime;
	}
 
}