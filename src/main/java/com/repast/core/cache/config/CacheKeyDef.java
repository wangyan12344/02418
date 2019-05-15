package com.repast.core.cache.config;

import java.util.List;

public class CacheKeyDef {

	private String cachekeyid;
	private String description;
	
	private List<MethodDef> methoddefList;

	
	public String getDescription() {
		return description;
	}

	public List<MethodDef> getMethoddefList() {
		return methoddefList;
	}

	public void setMethoddefList(List<MethodDef> methoddefList) {
		this.methoddefList = methoddefList;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCachekeyid() {
		return cachekeyid;
	}

	public void setCachekeyid(String cachekeyid) {
		this.cachekeyid = cachekeyid;
	}

	

}
