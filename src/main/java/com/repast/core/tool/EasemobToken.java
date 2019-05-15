package com.repast.core.tool;

import com.repast.core.entity.TokenThread;

public class EasemobToken {

	/**
	 * 初始化启动token
	 */
	public void init(){
		System.out.println("----------------获取环信token----------------");
		new Thread(new TokenThread()).start();
	}
	
}
