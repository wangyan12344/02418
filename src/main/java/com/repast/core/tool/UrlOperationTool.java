package com.repast.core.tool;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import com.mysql.jdbc.StringUtils;
import com.repast.core.entity.AccessToken;
import com.repast.core.entity.TokenThread;

/**
 * 
 * @author lingy
 * UrlOperationTool.java
 */
public class UrlOperationTool {
	
	private static UrlOperationTool urlOperationTool = null;
	
	private UrlOperationTool() {

	}
	
	private static String org_name="";
	private static String app_name="";
	private static String access_token="";
	
	/**
	 * 单例
	 * @return
	 */
	public static UrlOperationTool getInstance() {
		if (urlOperationTool == null) {
			urlOperationTool = new UrlOperationTool();
		}
		org_name = "qiaoqiaotx2015";
		app_name = "qiaoqiaotx2015";
//		access_token = "YWMt2Elkpp2ZEeWHmHdoE2R-GwAAAVK2Np6L_1pBMjhkJ_YukZRL7WHbeTmVkCQ";
		if(TokenThread.EasemobManAccessToken!=null){
			access_token = TokenThread.EasemobManAccessToken.getAccesstoken();
		}else{
			access_token = "";
		}
		return urlOperationTool;
	}
	
	/**
	 * 知道url和参数，调用环信api
	 * @param inputurl
	 * @param inputparams
	 * @return
	 */
	public String doEasemobAction(String inputurl,String inputparams){
		return doPost(inputurl, inputparams, access_token,"");
	}
	
	/**
	 * 创建用户
	 * @param username
	 * @param password
	 * @return
	 */
	public String registerEasemobUser(String username,String password){
		String url = "https://a1.easemob.com/"+org_name+"/"+app_name+"/users";
		String params = "{\"username\":\""+username+"\",\"password\":\""+password+"\"}";
		return doPost(url,params,access_token,"");
	}
	
	/**
	 * 创建群组
	 * @param groupname
	 * @return
	 */
	public String createEasemobGroup(String groupname,String owner,String desc){
		String url = "https://a1.easemob.com/"+org_name+"/"+app_name+"/chatgroups";
		String params = "{\"groupname\":\""+groupname+"\",\"desc\":\""+desc+"\",\"public\":true,\"approval\":true,\"owner\":\""+owner+"\",\"maxusers\":500,\"members\":[\""+owner+"\"]}";
		String jsonStr = doPost(url,params,access_token,"");
		JSONObject object = JSONObject.fromObject(jsonStr);
		String data = object.getString("data");
		String groupid = JSONObject.fromObject(data).getString("groupid");
		return groupid;
	}
	
	/**
	 * 根据群组ID向群组中插入成员
	 * @param groupid
	 * @param username
	 * @return
	 */
	public String addMemberIntoGroup(String groupid,String username){
		String inputurl = "https://a1.easemob.com/"+org_name+"/"+app_name+"/chatgroups/"+groupid+"/users/"+username+"";
		return doPost(inputurl, "", access_token,"POST");
	}
	
	/**
	 * 根据群组ID和环信用户ID，删除群组中的用户
	 * @param groupid
	 * @param username
	 * @return
	 */
	public String deleteMemberFromGroup(String groupid,String username){
		String inputurl = "https://a1.easemob.com/"+org_name+"/"+app_name+"/chatgroups/"+groupid+"/users/"+username+"";
		return doPost(inputurl, "", access_token,"DELETE");
	}
	
	/**
	 * 根据群组ID获得所有成员
	 * @param groupid
	 * @return
	 */
	public String getAllMemberinfoByGroupid(String groupid){
		String inputurl = "https://a1.easemob.com/"+org_name+"/"+app_name+"/chatgroups/"+groupid+"/users";
		String jsonStr = doPost(inputurl, "", access_token,"GET");
		com.alibaba.fastjson.JSONObject jsonobject = com.alibaba.fastjson.JSONObject.parseObject(jsonStr);
		String data = jsonobject.getString("data");
		List<Object> jsonList = com.alibaba.fastjson.JSONObject.parseArray(data);
		List<String> memberList = new ArrayList<String>();
		for (Object object : jsonList) {
			com.alibaba.fastjson.JSONObject memberJson = (com.alibaba.fastjson.JSONObject) object;
			String memberid = memberJson.getString("member");
			if(memberid!=null){
				memberList.add(memberid);
			}
		}
		String result = join(memberList.iterator(), ",");
		return result;
	}
	
	/**
	 * 根据环信ID获得用户所在全部群组
	 * @return
	 * @author lingy
	 */
	public String getUserAllGroupByEasemobUserId(String easemobuserid){
		String inputurl = "https://a1.easemob.com/"+org_name+"/"+app_name+"/users/"+easemobuserid+"/joined_chatgroups";
		// /{org_name}/{app_name}/users/{username}/joined_chatgroups
		String jsonStr = doPost(inputurl, "", access_token,"GET");
		com.alibaba.fastjson.JSONObject jsonobject = com.alibaba.fastjson.JSONObject.parseObject(jsonStr);
		String data = jsonobject.getString("data");
		List<Object> jsonList = com.alibaba.fastjson.JSONObject.parseArray(data);
		List<String> groupList = new ArrayList<String>();
		for (Object object : jsonList) {
			com.alibaba.fastjson.JSONObject groupJson = (com.alibaba.fastjson.JSONObject) object;
			String groupid = groupJson.getString("groupid");
			if(groupid!=null){
				groupList.add(groupid);
			}
		}
		return join(groupList.iterator(),",");
	}
	
	/**
	 * @param inputurl
	 * @param inputparams
	 * @return
	 */
	private String doPost(String inputurl,String inputparams,String token,String method){
		StringBuilder json = new StringBuilder();
		try {
			URL url = new URL(inputurl);
			/********************start handle https************************/
			HostnameVerifier hv = new HostnameVerifier() {
				public boolean verify(String urlHostName, SSLSession session) {
					System.out.println("Warning: URL Host: " + urlHostName + " vs. "
							+ session.getPeerHost());
					return true;
				}
			};
			trustAllHttpsCertificates();
			HttpsURLConnection.setDefaultHostnameVerifier(hv);
			/********************end handle https************************/
			HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
			
			//设置头信息
			urlConnection.setRequestProperty("accept", "*/*");
			urlConnection.setRequestProperty("connection", "Keep-Alive");
			urlConnection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			urlConnection.setDoOutput(true);
			urlConnection.setDoInput(true);
			urlConnection.setRequestProperty("Authorization", " Bearer "+token);
			if(!StringUtils.isNullOrEmpty(method)){
				urlConnection.setRequestMethod(method);
			}
			PrintWriter writer = null;
			if(inputparams!=null&&!"".equals(inputparams)){
				writer = new PrintWriter(urlConnection.getOutputStream());
				writer.print(inputparams);
				writer.flush();
			}
            // 发送请求参数
			BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(),"utf-8"));  
            String inputLine = null;
            while ( (inputLine = reader.readLine()) != null) {  
                json.append(inputLine);  
            }  
            reader.close(); 
            if(writer!=null){
            	writer.close();
            }
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return json.toString();
	}
	
	
	private void trustAllHttpsCertificates() throws Exception {
		javax.net.ssl.TrustManager[] trustAllCerts = new javax.net.ssl.TrustManager[1];
		javax.net.ssl.TrustManager tm = new miTM();
		trustAllCerts[0] = tm;
		javax.net.ssl.SSLContext sc = javax.net.ssl.SSLContext
				.getInstance("SSL");
		sc.init(null, trustAllCerts, null);
		javax.net.ssl.HttpsURLConnection.setDefaultSSLSocketFactory(sc
				.getSocketFactory());
	}

	static class miTM implements javax.net.ssl.TrustManager,
			javax.net.ssl.X509TrustManager {
		public java.security.cert.X509Certificate[] getAcceptedIssuers() {
			return null;
		}

		public boolean isServerTrusted(
				java.security.cert.X509Certificate[] certs) {
			return true;
		}

		public boolean isClientTrusted(
				java.security.cert.X509Certificate[] certs) {
			return true;
		}

		public void checkServerTrusted(
				java.security.cert.X509Certificate[] certs, String authType)
				throws java.security.cert.CertificateException {
			return;
		}

		public void checkClientTrusted(
				java.security.cert.X509Certificate[] certs, String authType)
				throws java.security.cert.CertificateException {
			return;
		}
	}
	
	/**
	 * 获取token
	 * @param clientid
	 * @param clientsecret
	 * @return
	 */
	public AccessToken getAccessToken(String clientid, String clientsecret) {
	    AccessToken accessToken = null;
	    String requestUrl = "https://a1.easemob.com/"+org_name+"/"+app_name+"/token";
	    String params = "{\"grant_type\":\"client_credentials\",\"client_id\":\""+clientid+"\",\"client_secret\":\""+clientsecret+"\"}";
	    String result = doPost(requestUrl, params, "", "");
	    JSONObject jsonObject = JSONObject.fromObject(result);
	    // 如果请求成功
	    if (null != jsonObject) {
	        try {
	            accessToken = new AccessToken();
	            accessToken.setAccesstoken(jsonObject.getString("access_token"));
	            accessToken.setExpiresin(jsonObject.getInt("expires_in"));
	        } catch (JSONException e) {
	            // 获取token失败
	        }
	    }
	    return accessToken;
	}
	
	
	public static String join(final Iterator<String> iterator, final String separator) {

        // handle null, zero and one elements before building a buffer
        if (iterator == null) {
            return null;
        }
        if (!iterator.hasNext()) {
            return "";
        }
        final String first = iterator.next();
        if (!iterator.hasNext()) {
            return first;
        }

        // two or more elements
        final StringBuilder buf = new StringBuilder(256); // Java default is 16, probably too small
        if (first != null) {
            buf.append(first);
        }

        while (iterator.hasNext()) {
            buf.append(separator);
            final String obj = iterator.next();
            if (obj != null) {
                buf.append(obj);
            }
        }
        return buf.toString();
    }
	
	public static void main(String args[]){
		urlOperationTool = UrlOperationTool.getInstance();
		urlOperationTool.registerEasemobUser("admin", "123456");
	}
}
