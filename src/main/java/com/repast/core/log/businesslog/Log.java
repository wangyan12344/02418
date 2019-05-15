package com.repast.core.log.businesslog;

import java.util.ArrayList;
import java.util.List;

import com.repast.core.system.Processor;


public class Log {
	
	// 业务名称
	private String businessName;
	
	// 操作人ID
	private String operationUserId;
	
	// 操作人名称
	private String operationUserName;
	
	// 操作时间
	private java.sql.Timestamp operationTime;
	
	// 设备类型
	private String deviceType;
	
	// 操作的IP地址
	private String ipAddress;
	
	// 操作类型
	private String operationType;
	
	// 原值对象
	private List<Object> oldEntiyList;
	
	// 新值对象
	private List<Object> newEntiyList;
	
	// 商户编号
	private String restaurantid;
	
	// 操作说明
	private String memo;
	
	public Log(String businessName,String operationType,Processor processor){
		this.businessName = businessName;
		this.operationType = operationType;
		this.setRestaurantid(processor.getShopid());
		this.deviceType = processor.getDeviceType();
		
		this.operationUserId = processor.getCurrentUserId();
		this.ipAddress = processor.getIpaddress();
	}
	
	/**
	 * 实例化日志表
	 * @param businessName    功能模块名称
	 * @param operationType   操作类型
	 * @param memo   		  操作说明
	 * @param processor       
	 */
	public Log(String businessName,String operationType,String memo,Processor processor){
		this.businessName = businessName;
		this.operationType = operationType;
		this.setRestaurantid(processor.getShopid());
		this.deviceType = processor.getDeviceType();
		
		this.operationUserId = processor.getCurrentUserId();
		this.ipAddress = processor.getIpaddress();
		this.setMemo(memo);
	}
	
	public Log(String businessName,String operationType,String operationUserId){
		this.businessName = businessName;
		this.operationUserId = operationUserId;
		this.operationType = operationType;
	}
	
	
	public void putOldAndNewObj(Object oldEntity,Object newEntity){
		if(oldEntiyList==null)
			oldEntiyList = new ArrayList<Object>();
		oldEntiyList.add(oldEntity);
		
		if(newEntiyList==null)
			newEntiyList = new ArrayList<Object>();
		newEntiyList.add(newEntity);
	}
	
	/**
	 * 添加原值对象
	 * @param oldEntity
	 */
	public void addOldEntity(Object oldEntity){
		if(oldEntiyList==null)
			oldEntiyList = new ArrayList<Object>();
		oldEntiyList.add(oldEntity);
	}
	

	/**
	 * 添加新值对象
	 * @param newEntity
	 */
	public void addNewEntity(Object newEntity){
		if(newEntiyList==null)
			newEntiyList = new ArrayList<Object>();
		newEntiyList.add(newEntity);
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

	public java.sql.Timestamp getOperationTime() {
		return operationTime;
	}

	public void setOperationTime(java.sql.Timestamp operationTime) {
		this.operationTime = operationTime;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getOperationType() {
		return operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}

	public List<Object> getOldEntiyList() {
		return oldEntiyList;
	}

	public void setOldEntiyList(List<Object> oldEntiyList) {
		this.oldEntiyList = oldEntiyList;
	}

	public List<Object> getNewEntiyList() {
		return newEntiyList;
	}

	public void setNewEntiyList(List<Object> newEntiyList) {
		this.newEntiyList = newEntiyList;
	}
	
	
	public void saveLog(){
		new Thread(new LogUtils(this)).start();
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public String getRestaurantid() {
		return restaurantid;
	}

	public void setRestaurantid(String restaurantid) {
		this.restaurantid = restaurantid;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}
	
}
