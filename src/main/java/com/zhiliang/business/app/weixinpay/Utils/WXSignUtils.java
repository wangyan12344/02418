package com.zhiliang.business.app.weixinpay.Utils;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import com.repast.core.util.CommonUtil;

/**
 * 签名算法sign
 * @author superma
 */
public class WXSignUtils {
	
	private static String Key = "W7IvC8FYCmUlsigWks48PDhpc4sUZaNR";
    
	public static final String APPID="wx06440c988c3f7bdd";
	
	public static final String MCH_ID="1422372902";
	
	public static final String NOTIFY_URL=CommonUtil.WEBSITE+"GetWxNotifyUrlController/payNotifyUrl.json";
	
	public static final String TRADE_TYPE="APP";
	
	public static final String WXURL="https://api.mch.weixin.qq.com/pay/unifiedorder";
	
	public static final String METHOD="POST";
	/**
	 * 微信支付签名算法sign
	 * @param characterEncoding
	 * @param parameters
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static String createSign(String characterEncoding,SortedMap<Object,Object> parameters){
		StringBuffer sb = new StringBuffer();
		Set es = parameters.entrySet();//所有参与传参的参数按照accsii排序（升序）
		Iterator it = es.iterator();
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry)it.next();
			String k = (String)entry.getKey();
			Object v = entry.getValue();
			if(null != v && !"".equals(v) 
					&& !"sign".equals(k) && !"key".equals(k)) {
				sb.append(k + "=" + v + "&");
			}
		}
		sb.append("key=" + Key);
		System.out.println("字符串拼接后是:"+sb.toString());
		String sign = MD5Util.MD5Encode(sb.toString(), characterEncoding).toUpperCase();
		return sign;
	}

	

}
