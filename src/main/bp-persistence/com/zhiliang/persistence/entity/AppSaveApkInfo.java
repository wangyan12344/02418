package com.zhiliang.persistence.entity;

import java.io.Serializable;

import com.repast.core.annotation.Column;
import com.repast.core.annotation.Entity;
import com.repast.core.annotation.ID;
import com.repast.core.system.BaseEntity;

@Entity(name = "app_mall_apk")
public class AppSaveApkInfo extends BaseEntity implements Serializable, Cloneable {
	
	
	public AppSaveApkInfo clone() {
		AppSaveApkInfo o = null;
		try {
			o = (AppSaveApkInfo) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return o;
	}
	
	/**
	 *appid
	 */
    @ID
	@Column(name = "appid", comment = "appid")
	private String appid;
	/**
	 *安装包更新细节描述
	 */
	@Column(name = "newAPKContent", comment = "安装包更新细节描述")
	private String newAPKContent;
	

	/**
	 *安装版本号
	 */
	@Column(name = "newAPKCode", comment ="安装版本号")
	private String newAPKCode;
	
	/**
	 *安装包大小
	 */
	@Column(name = "newAPKSize", comment ="安装包大小")
	private String newAPKSize;
	
	/**
	 *安装包上传服务器时间
	 */
	@Column(name = "newAPKUploadTime", comment ="安装包上传服务器时间")
	private String newAPKUploadTime;

	/**
	 *安装包路径
	 */
	@Column(name = "newAPKURL", comment ="安装包路径")
	private String newAPKURL;
	
	/**
	 *安装包类型
	 */
	@Column(name = "appType", comment ="安装包类型 0置粮网B端 1经纪人端")
	private String appType;
	
	public String getNewAPKURL() {
		return newAPKURL;
	}

	public void setNewAPKURL(String newAPKURL) {
		this.newAPKURL = newAPKURL;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getNewAPKContent() {
		return newAPKContent;
	}

	public void setNewAPKContent(String newAPKContent) {
		this.newAPKContent = newAPKContent;
	}

	public String getNewAPKCode() {
		return newAPKCode;
	}

	public void setNewAPKCode(String newAPKCode) {
		this.newAPKCode = newAPKCode;
	}

	public String getNewAPKSize() {
		return newAPKSize;
	}

	public void setNewAPKSize(String newAPKSize) {
		this.newAPKSize = newAPKSize;
	}

	public String getNewAPKUploadTime() {
		return newAPKUploadTime;
	}

	public void setNewAPKUploadTime(String newAPKUploadTime) {
		this.newAPKUploadTime = newAPKUploadTime;
	}

	public String getAppType() {
		return appType;
	}

	public void setAppType(String appType) {
		this.appType = appType;
	}
	
}
