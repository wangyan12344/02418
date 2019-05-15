package com.repast.persistence.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.repast.core.annotation.Column;
import com.repast.core.annotation.Entity;
import com.repast.core.annotation.ID;
import com.repast.core.annotation.Transient;
import com.repast.core.system.BaseEntity;

@Entity(name="Sys_LogOperation")
public class SysLogOperation extends BaseEntity implements Serializable, Cloneable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -6279771341046144998L;

	public SysLogOperation clone() {

		SysLogOperation o = null;

		try {
			o = (SysLogOperation) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

		return o;
	}
	
	
	@ID
	@Column(name="LOGID",comment="主键")
	private String logid;
	
    @Column(name="businessName",comment="业务功能")
	private String businessName;
	
    @Column(name="operationUserId",comment="操作人员编号")
	private String operationUserId;
	
    @Column(name="operationUserName",comment="操作人员姓名")
	private String operationUserName;
	
    @Column(name="operationTime",comment="操作时间")
	private Date operationTime;
	
    @Column(name="deviceType",comment="设备类型")
	private String deviceType;
	
    @Column(name="operationType",comment="操作类型")
	private String operationType;
    
    @Column(name="restaurantid",comment="商户信息")
    private String restaurantid;
    
    @Column(name="ipaddress",comment="IP地址")
    private String ipaddress;
    
    @Column(name="memo",comment="说明")
    private String memo;

    @Transient
    private List<SysLogOperationDetail> logDetailList;
    
    
	public String getLogid() {
		return logid;
	}

	public void setLogid(String logid) {
		this.logid = logid;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getOperationUserId() {
		return operationUserId;
	}

	public void setOperationUserId(String operationUserId) {
		this.operationUserId = operationUserId;
	}

	public String getOperationUserName() {
		return operationUserName;
	}

	public void setOperationUserName(String operationUserName) {
		this.operationUserName = operationUserName;
	}





	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public String getOperationType() {
		return operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}

	public Date getOperationTime() {
		return operationTime;
	}

	public void setOperationTime(Date operationTime) {
		this.operationTime = operationTime;
	}

	public String getRestaurantid() {
		return restaurantid;
	}

	public void setRestaurantid(String restaurantid) {
		this.restaurantid = restaurantid;
	}

	public List<SysLogOperationDetail> getLogDetailList() {
		return logDetailList;
	}

	public void setLogDetailList(List<SysLogOperationDetail> logDetailList) {
		this.logDetailList = logDetailList;
	}

	public String getIpaddress() {
		return ipaddress;
	}

	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}
    
    

}
