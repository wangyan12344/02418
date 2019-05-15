package com.repast.core.entity;

public class EasemobUser {

	/**
	 * 环信用户名
	 */
	private String easemobusername;
	
	/**
	 * 巡店用户名
	 */
	private String csusername;

	/**
	 * 头像
	 */
	private String headimage;

	public String getEasemobusername() {
		return easemobusername;
	}

	public void setEasemobusername(String easemobusername) {
		this.easemobusername = easemobusername;
	}

	public String getCsusername() {
		return csusername;
	}

	public void setCsusername(String csusername) {
		this.csusername = csusername;
	}

	public String getHeadimage() {
		return headimage;
	}

	public void setHeadimage(String headimage) {
		this.headimage = headimage;
	}


	/**
	 * 重写equals方法
	 */
	public boolean equals(Object obj){
		if (this == obj) {
            return true;
        }
        if (obj instanceof EasemobUser) {
            if(this.easemobusername!=null&&this.easemobusername.equals(((EasemobUser) obj).getEasemobusername()))
            	return true;
        }
        return false;
	}
	
}
