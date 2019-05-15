package com.repast.core.spring.auth;

public enum CheckType {
	//不检查权限，可以访问
	NO_CHECK, 
	//检查是否登录，登录后可以访问
	CHECK_LOGIN, 
	//检查用户的角色是否有访问的权限
	CHECK_RESOURCE
}

