package com.repast.core.entity;

import com.repast.core.tool.UrlOperationTool;


/**
 * 
 * @author lingy
 *
 */
public class TokenThread implements Runnable {
	
	public final static String CLIENT_ID = "YXA61nj5IJtBEeWSdr83MiH-yg";
	public final static String CLIENT_SECRET = "YXA6lR7IrIQQb3ODg_OHwPhsNl4DVLI";

	/**
	 * 环信token
	 */
	public static AccessToken EasemobManAccessToken = null;

	public void run() {
		while (true) {
			try {
				EasemobManAccessToken = UrlOperationTool.getInstance().getAccessToken(CLIENT_ID,CLIENT_SECRET);
//				System.out.println("获得的环信token是："+EasemobManAccessToken.getAccesstoken());
				if (null != EasemobManAccessToken) {
					// 休眠
					Thread.sleep((EasemobManAccessToken.getExpiresin() - 1000) * 1000);
				} else {
					// 如果access_token为null，10秒后再获取
					Thread.sleep(5 * 1000);
				}
			} catch (InterruptedException e) {
				try {
					Thread.sleep(5 * 1000);
				} catch (InterruptedException e1) {
				}
			}
		}
	}
}