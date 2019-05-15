package com.repast.persistence.entity;

public class TraderPauUrl {
	//支付路径	
	private String url;

	//支付明细路径
	private String payDetailRecordurl;
	
	//支付校验路径
	private String checkPayURL;
	
	//支付通知路径
	private String noticeURL;
	
	//请求地址地址
	private String httpurl;
	
	//余额支付回写	
	private String balancePayCallbackUrl;
	
	
	
	public String getBalancePayCallbackUrl() {
		return balancePayCallbackUrl;
	}

	public void setBalancePayCallbackUrl(String balancePayCallbackUrl) {
		this.balancePayCallbackUrl = balancePayCallbackUrl;
	}

	public String getHttpurl() {
		return httpurl;
	}

	public void setHttpurl(String httpurl) {
		this.httpurl = httpurl;
	}

	public String getCheckPayURL() {
		return checkPayURL;
	}

	public void setCheckPayURL(String checkPayURL) {
		this.checkPayURL = checkPayURL;
	}

	public String getNoticeURL() {
		return noticeURL;
	}

	public void setNoticeURL(String noticeURL) {
		this.noticeURL = noticeURL;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPayDetailRecordurl() {
		return payDetailRecordurl;
	}

	public void setPayDetailRecordurl(String payDetailRecordurl) {
		this.payDetailRecordurl = payDetailRecordurl;
	}
	
	
}
