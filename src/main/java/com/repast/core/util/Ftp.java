package com.repast.core.util;

import java.io.*;
import java.net.SocketException;
import java.util.Properties;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

import com.repast.core.util.CommonUtil;
import com.repast.persistence.entity.TraderPauUrl;

public class Ftp {
	@Resource(name="TraderPauUrl")
	private TraderPauUrl traderPauUrl;
	private static final Log logger = LogFactory.getLog(Ftp.class);

	private static String userName="zhiliangread"; // FTP 登录用户名
	private static String password="zhiliangread"; // FTP 登录密码
	//private int port; // FTP 端口
	private Properties property = null; // 属性集
	//private String configFile = "conf/application.properties"; // 配置文件的路径名
	private FTPClient ftpClient = null; // FTP 客户端代理

	// FTP状态码
	public int i = 1;

	/**
	 * 连接到服务器
	 * 
	 * @return true 连接服务器成功，false 连接服务器失败
	 */
	public boolean connectServer() {
		boolean flag = true;
		if (ftpClient == null) {
			int reply;
			try {
				//if (setArg(configFile)) {
					ftpClient = new FTPClient();
					ftpClient.setControlEncoding("GBK");
					// ftpClient.configure(getFtpConfig());
					ftpClient.connect(traderPauUrl.getUrl(), 21);
					ftpClient.login(userName, password);
					reply = ftpClient.getReplyCode();
					ftpClient.setDataTimeout(120000);

					if (!FTPReply.isPositiveCompletion(reply)) {
						ftpClient.disconnect();
						logger.debug("FTP 服务拒绝连接！");
						flag = false;
					}
					i++;
//				} else {
//					flag = false;
//				}
			} catch (SocketException e) {
				flag = false;
				e.printStackTrace();
				logger.debug("登录ftp服务器 " + CommonUtil.FTPIP + " 失败,连接超时！");
			} catch (IOException e) {
				flag = false;
				e.printStackTrace();
				logger.debug("登录ftp服务器 " + CommonUtil.FTPIP + " 失败，FTP服务器无法打开！");
			}
		}
		return flag;
	}

	/**
	 * 上传文件
	 * 
	 * @param remoteFile
	 *            远程文件路径,支持多级目录嵌套
	 * @param localFile
	 *            本地文件名称，绝对路径
	 * 
	 */
	public boolean uploadFile(String remoteFile, File localFile)
			throws IOException {
		boolean flag = false;
		InputStream in = new FileInputStream(localFile);
		String remote = new String(remoteFile.getBytes("GBK"), "iso-8859-1");
		if (ftpClient.storeFile(remote, in)) {
			flag = true;
			logger.debug(localFile.getAbsolutePath() + "上传文件成功！");
		} else {
			logger.debug(localFile.getAbsolutePath() + "上传文件失败！");
		}
		in.close();
		return flag;
	}


	/**
	 * 下载文件
	 * 
	 * @param remoteFileName
	 *            --服务器上的文件名
	 * @param localFileName
	 *            --本地文件名
	 * @return true 下载成功，false 下载失败
	 */
	public boolean loadFile(String remoteFileName, String localFileName) {
		boolean flag = true;
		// 下载文件
		BufferedOutputStream buffOut = null;
		try {
			buffOut = new BufferedOutputStream(new FileOutputStream(
					localFileName));
			flag = ftpClient.retrieveFile(remoteFileName, buffOut);
		} catch (Exception e) {
			e.printStackTrace();
			logger.debug("本地文件下载失败！", e);
		} finally {
			try {
				if (buffOut != null)
					buffOut.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return flag;
	}

	/**
	 * 关闭连接
	 */
	public void closeConnect() {
		try {
			if (ftpClient != null) {
				ftpClient.logout();
				ftpClient.disconnect();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 设置传输文件的类型[文本文件或者二进制文件]
	 * 
	 * @param fileType
	 *            --BINARY_FILE_TYPE、ASCII_FILE_TYPE
	 * 
	 */
	public void setFileType(int fileType) {
		try {
			ftpClient.setFileType(fileType);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 设置参数
	 * 
	 * @param configFile
	 *            --参数的配置文件
	 */
	@SuppressWarnings("unused")
	private boolean setArg(String configFile) {
		boolean flag = true;
		property = new Properties();
		BufferedInputStream inBuff = null;
		try {
			inBuff = new BufferedInputStream(new FileInputStream(getClass()
					.getResource("/").getPath() + configFile));
			property.load(inBuff);
			userName = property.getProperty("username");
			password = property.getProperty("password");
			//ip = property.getProperty("ip");
			//port = Integer.parseInt(property.getProperty("port"));
		} catch (FileNotFoundException e1) {
			flag = false;
			logger.debug("配置文件 " + configFile + " 不存在！");
		} catch (IOException e) {
			flag = false;
			logger.debug("配置文件 " + configFile + " 无法读取！");
		}
		return flag;
	}

	/**
	 * 进入到服务器的某个目录下
	 * 
	 * @param directory
	 */
	public boolean changeWorkingDirectory(String directory) {
		boolean flag = true;
		try {
			flag = ftpClient.changeWorkingDirectory(directory);
			if (flag) {
				logger.debug("进入文件夹" + directory + " 成功！");

			} else {
				logger.debug("进入文件夹" + directory + " 失败！");
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return flag;
	}

	/**
	 * 返回到上一层目录
	 */
	public void changeToParentDirectory() {
		try {
			ftpClient.changeToParentDirectory();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}


	/**
	 * 在服务器上创建一个文件夹
	 * @param dir
	 * 文件夹名称，不能含有特殊字符，如 \ 、/ 、: 、* 、?、 "、 <、>...
	 */
	public boolean makeDirectory(String dir) {
		boolean flag = true;
		try {
			flag = ftpClient.makeDirectory(dir);
			if (flag) {
				logger.debug("创建文件夹" + dir + " 成功！");

			} else {
				logger.debug("创建文件夹" + dir + " 失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	// 检查路径是否存在，存在返回true，否则false
	public boolean existFile(String path) throws IOException {
		boolean flag = false;
		FTPFile[] ftpFileArr = ftpClient.listFiles(path);
	
		if (ftpFileArr.length > 0) {
			flag = true;
		}
		return flag;
	}

	/**
	 * 递归创建远程服务器目录
	 * @param remote
	 * 远程服务器文件绝对路径
	 * @return 目录创建是否成功
	 * @throws IOException
	 */
	public boolean CreateDirecroty(String remote) throws IOException {
		boolean success = true;
		String directory = remote.substring(0, remote.lastIndexOf("/") + 1);
		// 如果远程目录不存在，则递归创建远程服务器目录
		if (!directory.equalsIgnoreCase("/")&& !changeWorkingDirectory(new String(directory))) {
			int start = 0;
			int end = 0;
			if (directory.startsWith("/")) {
				start = 1;
			} else {
				start = 0;
			}
			end = directory.indexOf("/", start);
			while (true) {
				String subDirectory = new String(remote.substring(start, end).getBytes("GBK"), "iso-8859-1");
				if (!changeWorkingDirectory(subDirectory)) {
					if (makeDirectory(subDirectory)) {
						changeWorkingDirectory(subDirectory);
					} else {
						logger.debug("创建目录[" + subDirectory + "]失败");
						System.out.println("创建目录[" + subDirectory + "]失败");
						success = false;
						return success;
					}
				}
				start = end + 1;
				end = directory.indexOf("/", start);
				// 检查所有目录是否创建完毕
				if (end <= start) {
					break;
				}
			}
		}
		return success;
	}

	public static void main(String[] args){
		Ftp ftpClient = new Ftp();
		if (ftpClient.connectServer()) {
			ftpClient.setFileType(FTP.BINARY_FILE_TYPE);// 设置传输二进制文件
			try {
				File file = new File("/Users/jennifer/Desktop/1467207624307.jpg");
				ftpClient.CreateDirecroty("/img/test/");
				ftpClient.uploadFile("1467207624307.jpg", file);
			} catch (IOException e) {
				e.printStackTrace();
			}
			ftpClient.closeConnect();// 关闭连接
		}
	}
}
