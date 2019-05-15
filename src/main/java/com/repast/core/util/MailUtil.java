package com.repast.core.util;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import com.repast.core.mail.MailSenderInfo;
import com.repast.core.mail.SimpleMailSender;

/**
 * @author lingy
 * MailUtil.java
 */
public class MailUtil {

	
	private final static String MAIL_SERVER_HOST = "smtp.163.com";//发件服务器
	
	private final static String MAIL_SERVER_PORT = "25";//端口
	
	private final static String MAIL_FROM_ADDRESS = "checkshop_lsxd@163.com";//发件地址
	
	private final static String MAIL_FROM_PASSWORD = "tlvrjstuzravmqcs";//密码
	
	/**
	 * 
	 * @author lingy
	 * @date 2015年9月23日 下午4:00:20
	 * @param toAddress 收件地址
	 * @param subject 邮件主题
	 * @param content 邮件内容
	 */
	public static void sendMail(String toAddress,String subject,String content,String[] fileNames){
		MailSenderInfo mailInfo = new MailSenderInfo(); 
		mailInfo.setMailServerHost(MAIL_SERVER_HOST); 
		mailInfo.setMailServerPort(MAIL_SERVER_PORT); 
		mailInfo.setValidate(true); 
		mailInfo.setUserName(MAIL_FROM_ADDRESS); //邮箱账号
		mailInfo.setPassword(MAIL_FROM_PASSWORD);//您的邮箱密码 
		mailInfo.setFromAddress(MAIL_FROM_ADDRESS); 
		mailInfo.setToAddress(toAddress); 
		mailInfo.setSubject(subject); //邮件标题
		mailInfo.setContent(content+"<br/><br/>"); //邮件内容
		mailInfo.setAttachFileNames(fileNames);
        //这个类主要来发送邮件
		SimpleMailSender sms = new SimpleMailSender();
//		sms.sendTextMail(mailInfo);//发送文体格式 
		sms.sendHtmlMail(mailInfo);//发送HTML格式
	}
	
	/**
	 * 
	 * @author lingy
	 * @date 2015年9月23日 下午4:44:21
	 * @param toAddressList
	 * @param subject
	 * @param content
	 */
	public static void sendMail(List<String> toAddressList,final String subject, final String content, final String[] fileNames){
		Executor executor = Executors.newFixedThreadPool(4);
		for (String address : toAddressList) {
			final String toAddress = address;
			 executor.execute(new Runnable() {
				 public void run() {
					 try {
						 sendMail(toAddress, subject, content, fileNames);
					 } catch (Exception e) {
						 e.printStackTrace();
						 System.out.println("---------------------------------------发给"+toAddress+"的邮件，发送失败了---------------------------------------");
					 }finally{
                    	
					 }
				 }
            });
		}
	}
	
	public static void main(String args[]){
		sendMail("lingyong@exueji.com", "请收邮件", "我是邮件内容", new String[]{"/Users/lingy/Downloads/ddd.pdf"});
	}
}
