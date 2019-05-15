package com.repast.core.entity;

/**
 * 类描述：获取accesstoken(公众号的全局唯一票据) 
 * @author lingy
 * AccessToken.java
 */
public class AccessToken {
 	// 获取到的凭证
	private String accesstoken;
	// 凭证有效时间，单位：秒  有效期为7200秒
	private int expiresin;
	
	public String getAccesstoken() {
		return accesstoken;
	}
	public void setAccesstoken(String accesstoken) {
		this.accesstoken = accesstoken;
	}
	public int getExpiresin() {
		return expiresin;
	}
	public void setExpiresin(int expiresin) {
		this.expiresin = expiresin;
	}
}
