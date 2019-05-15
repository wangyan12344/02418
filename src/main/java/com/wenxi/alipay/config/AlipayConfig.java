package com.wenxi.alipay.config;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *版本：3.3
 *日期：2012-08-10
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
	
 *提示：如何获取安全校验码和合作身份者ID
 *1.用您的签约支付宝账号登录支付宝网站(www.alipay.com)
 *2.点击“商家服务”(https://b.alipay.com/order/myOrder.htm)
 *3.点击“查询合作者身份(PID)”、“查询安全校验码(Key)”

 *安全校验码查看时，输入支付密码后，页面呈灰色的现象，怎么办？
 *解决方法：
 *1、检查浏览器配置，不让浏览器做弹框屏蔽设置
 *2、更换浏览器或电脑，重新登录查询。
 */

public class AlipayConfig {
	
	//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
	// 合作身份者ID，以2088开头由16位纯数字组成的字符串
	public static String partner = "2088521237965633";
	//商户私钥
	public static String private_key ="MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAM8e30ZeboQT8U+7754LUQKlC/p2+QPgPIkOMvj6zAxJmUqAAlMOZ09s1njBnTx4f11HMUsK5PGfupp3kcH982LWTBy+X0Oj90GKTiqH827g0z8mbwY1RuFJ4cPRNXdZ6O2dR11N09Huf4cF6HrTimPcUBS9+Vxpz8mZtpgXvK3rAgMBAAECgYBnes4kkzN2C5ypsITEGnVL8/frGBvLgvHbq9ttp6fgj7jljtUad/zHouH4jQso1i8UBGitTHEcAyiw2gJZwK4jEV9nl7s2NniGPs3ymJA81YWeWzAxl2CVWG5onSKH6fx2L+NzwxeE6qwCM7cIJ+xblTttaNGtSfr5d60L43z3aQJBAPuAHe46kKm4e6DtzkcZKjG03L7dbvCqroCOwlAUUmFhp8MUfE5ZQR9N2QrXhTkJCQlm3ZiuLAWmFwd5Racw6T8CQQDS035Yx8bwx3MsjxiUnPXqNwV1zUVdeLRonJvKLR82XpmP2RQoYf3+Iv9dg7hGnfFlI8FLyIioFm/p62tQVcRVAkEA113Bw7RhFwWE0K1zvEyfZktj0QocK3ltz2bwnNSaKwwONi6/t/QUoTLvzqn6SnojQ+rTjiBwUDIHfH3sGJz4zwJAHzNjmHoAbDPoTKjkx2GvVzlLWpLFeD7b3DuJJtOkseQwL8S9ofhWoZzGVC2hQPow9nnjKncEGnQvndvUZvA6fQJAYf+qRLGBUp9KiWHS5hP4Ksqmcdtd7RlnA1J+/Qj/ciA8gnOjmedRstmAeo/gj340YveOwFMX3HFWFkmmPMP/xg==";
	//商户公钥
	public static String public_key="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDPHt9GXm6EE/FPu++eC1ECpQv6dvkD4DyJDjL4+swMSZlKgAJTDmdPbNZ4wZ08eH9dRzFLCuTxn7qad5HB/fNi1kwcvl9Do/dBik4qh/Nu4NM/Jm8GNUbhSeHD0TV3WejtnUddTdPR7n+HBeh604pj3FAUvflcac/JmbaYF7yt6wIDAQAB";
	// 支付宝的公钥，无需修改该值
	public static String ali_public_key="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDDI6d306Q8fIfCOaTXy"
			+ "iUeJHkrIvYISRcc73s3vF1ZT7XN8RNPwJxo8pWaJMmvyTn9N4HQ632qJBVHf8sxHi/fEsraprwCtzvzQETrNR"
			+ "wVxLO5jVmRGi60j8Ue1efIlzPXV9je9mkjzOmdssymZkh2QhUrCmZYI/FCEa3/cNMW0QIDAQAB";

	//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
	

	// 调试用，创建TXT日志文件夹路径
	public static String log_path = "D:\\";

	// 字符编码格式 目前支持 gbk 或 utf-8
	public static String input_charset = "utf-8";
	
	// 签名方式 不需修改
	public static String sign_type = "RSA";
	
	//调用方法
	public static String sign_method="alipay.trade.app.pay";
	
	//appid
	public static String app_id="2016111402790814";
	
	//version
	public static String version="1.0";
	
	 /**
     * 支付宝消息验证地址
     */
	public static  String HTTPS_VERIFY_URL = "https://mapi.alipay.com/gateway.do?service=notify_verify&";
	

}
