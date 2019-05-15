package com.wenxi.alipay.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.wenxi.alipay.config.AlipayConfig;
import com.wenxi.alipay.sign.RSA;

public class RequestUtils {

	public static final Map<String, String> getStringParams(HttpServletRequest request) {

		Map<String, String[]> rawParam = request.getParameterMap();

		Map<String, String> underScoreKeyMap = new HashMap<String, String>();

		for (String key : rawParam.keySet()) {
			if (rawParam.get(key) != null) {

				String[] value = rawParam.get(key);
				if (value != null && value.length == 1) {
					underScoreKeyMap.put(key, value[0]);
				}
			}
		}
		return underScoreKeyMap;
		
	}
	
	
	public static final Map<String ,String> getMapfromRequest(HttpServletRequest request){
		
		//获取支付宝POST过来反馈信息
		Map<String,String> params = new HashMap<String,String>();
		Map<String, String[]> requestParams = request.getParameterMap();
		for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]
						: valueStr + values[i] + ",";
			}
			//乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
			try {
				valueStr = new String(valueStr.getBytes("utf-8"), "utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			System.out.println(name+" = "+valueStr);
			params.put(name, valueStr);
		}
		return params;
	}
	
    /**
     * 验证消息是否是支付宝发出的合法消息
     * @param params 通知返回来的参数数组
     * @return 验证结果
     */
    public static boolean verify(Map<String, String> params) {

        //判断responsetTxt是否为true，isSign是否为true
        //responsetTxt的结果不是true，与服务器设置问题、合作身份者ID、notify_id一分钟失效有关
        //isSign不是true，与安全校验码、请求时的参数格式（如：带自定义参数等）、编码格式有关
    	String responseTxt = "true";
		if(params.get("notify_id") != null) {
			String notify_id = params.get("notify_id");
			responseTxt = verifyResponse(notify_id);
		}
	    String sign = "";
	    if(params.get("sign") != null) {sign = params.get("sign");}
	    boolean isSign = getSignVeryfy(params, sign);

        //写日志记录（若要调试，请取消下面两行注释）
        //String sWord = "responseTxt=" + responseTxt + "\n isSign=" + isSign + "\n 返回回来的参数：" + AlipayCore.createLinkString(params);
	    //AlipayCore.logResult(sWord);

        if (isSign && responseTxt.equals("true")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 根据反馈回来的信息，生成签名结果
     * @param Params 通知返回来的参数数组
     * @param sign 比对的签名结果
     * @return 生成的签名结果
     */
	private static boolean getSignVeryfy(Map<String, String> Params, String sign) {
    	//过滤空值、sign与sign_type参数
    	Map<String, String> sParaNew = AlipayCore.paraFilter(Params);
        //获取待签名字符串
        String preSignStr = AlipayCore.createLinkString(sParaNew);
		//String preSignStr = AlipaySignature.getSignContent(sParaNew);

        System.out.println("支付完成后返回的字符串 "+preSignStr+"&sign="+sign);
        //获得签名验证结果
        boolean isSign = false;
        if(AlipayConfig.sign_type.equals("RSA") ) {
        	try {
        		isSign = RSA.verify(preSignStr, sign, AlipayConfig.ali_public_key, AlipayConfig.input_charset);
				//isSign = AlipaySignature.rsaCheckContent(preSignStr, sign, AlipayConfig.public_key, AlipayConfig.input_charset);
			    //isSign = AlipaySignature.rsaCheckV2(Params, AlipayConfig.public_key, AlipayConfig.input_charset);

			} catch (Exception e) {
				e.printStackTrace();
			}

        }
        return isSign;
    
	}
	
	  /**
	    * 获取远程服务器ATN结果,验证返回URL
	    * @param notify_id 通知校验ID
	    * @return 服务器ATN结果
	    * 验证结果集：
	    * invalid命令参数不对 出现这个错误，请检测返回处理中partner和key是否为空 
	    * true 返回正确信息
	    * false 请检查防火墙或者是服务器阻止端口问题以及验证时间是否超过一分钟
	    */
	    private static String verifyResponse(String notify_id) {
	        //获取远程服务器ATN结果，验证是否是支付宝服务器发来的请求

	        String partner = AlipayConfig.partner;
	        String veryfy_url = AlipayConfig.HTTPS_VERIFY_URL + "partner=" + partner + "&notify_id=" + notify_id;

	        return checkUrl(veryfy_url);
	    }

	    /**
	    * 获取远程服务器ATN结果
	    * @param urlvalue 指定URL路径地址
	    * @return 服务器ATN结果
	    * 验证结果集：
	    * invalid命令参数不对 出现这个错误，请检测返回处理中partner和key是否为空 
	    * true 返回正确信息
	    * false 请检查防火墙或者是服务器阻止端口问题以及验证时间是否超过一分钟
	    */
	    private static String checkUrl(String urlvalue) {
	        String inputLine = "";

	        try {
	            URL url = new URL(urlvalue);
	            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
	            BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection
	                .getInputStream()));
	            inputLine = in.readLine().toString();
	        } catch (Exception e) {
	            e.printStackTrace();
	            inputLine = "";
	        }

	        return inputLine;
	    }
	

	public static final Map<String, String> convertKeyToCamelCase(Map<String, String> map) {

		Map<String, String> camelCaseKeyMap = new HashMap<String, String>();
		for (String key : map.keySet()) {
			String camelKey = StringUtils.camelName(key);
			camelCaseKeyMap.put(camelKey, map.get(key));
		}
		return camelCaseKeyMap;
	}
}
