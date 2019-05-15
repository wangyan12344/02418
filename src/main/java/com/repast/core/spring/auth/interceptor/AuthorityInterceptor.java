/**
 * 处理权限拦截
 * 
 */
package com.repast.core.spring.auth.interceptor;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.alibaba.fastjson.JSON;
import com.repast.core.constant.SysConstant;
import com.repast.core.spring.auth.Author;
import com.repast.core.spring.auth.CheckType;
import com.repast.core.spring.mvc.util.JSONMap;

/**
 * 扩展spring的拦截器，对接入的请求进行权限检查
 * @author luandong
 *
 */
public class AuthorityInterceptor extends HandlerInterceptorAdapter {

	final Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 检查session中是否有登录成功的标识
	 * @param request
	 * @return
	 */
	private boolean isLogIn(HttpServletRequest request){
		String loginFlag = (String) request.getSession().getAttribute(SysConstant.SESSION_LOGIN);
		if (loginFlag != null&& SysConstant.SESSION_LOGIN_PASS.equals(loginFlag)) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 未进行登录，提示用户登录
	 * @param mappingPath
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	private boolean writeRespose(RequestMapping mappingPath,HttpServletRequest request,HttpServletResponse response) throws Exception{
		String methotPrex = mappingPath.value()[0];
		if (methotPrex != null && !"".equals(methotPrex)) {
			methotPrex = methotPrex
					.substring(methotPrex.lastIndexOf(".") + 1);
		}

		if ("json".equals(methotPrex)) {
			// ajax方式的请求
			JSONMap<String, Object>jsonMap = new JSONMap<String, Object>();
			jsonMap.put(SysConstant.OP_FLAG, false);
			jsonMap.put(SysConstant.OP_MESSAGE, SysConstant.NOT_LOGIN);

			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=UTF-8");
			OutputStream out = response.getOutputStream();
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(out,"utf-8"));
			pw.println(JSON.toJSONString(jsonMap));
			pw.flush();
			pw.close();
			
		} else if ("do".equals(methotPrex)) {
			// do方式的请求
			response.sendRedirect(request.getContextPath()+"/loginManagerController/showLoginPage.do");
		} else if ("jsp".equals(methotPrex)) {
			// js页面
		//	response.sendRedirect(request.getContextPath());
			return true;
		}else{
			response.sendRedirect(request.getContextPath()+"/loginManagerController/showLoginPage.do");
			return false;
		}
		return true;
	}
	
	/**
	 * 进行权限检查，根据业务方法上声明的标识进行不同粒度的权限控制
	 */
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {

		logger.debug("开始验证权限");
		
		
		HandlerMethod methodHandler = (HandlerMethod) handler;
		RequestMapping mappingPath = methodHandler.getMethodAnnotation(RequestMapping.class);
		
		Author author = methodHandler.getMethodAnnotation(Author.class);
		
        if(null == author){
        	
        	//if(isLogIn(request))						//没有声明权限,检查是否进行了登陆
        	//if(true)
        		return true;
        	//else
        	//	return writeRespose(mappingPath,request,response);
        }else{
        	if(author.type() == CheckType.NO_CHECK)		//声明为不检查，直接进入访问
        		return true;
        	
        	if(author.type() == CheckType.CHECK_LOGIN)  //声明为检查登陆
        		if(isLogIn(request))						//没有声明权限,检查是否进行了登陆
            		return true;
            	else
            	return	writeRespose(mappingPath,request,response);
        	
        	if(author.type() == CheckType.CHECK_RESOURCE) //设置为检查权限方式
        		logger.error("检查权限方式，等待补充！");
        }
        
        
		return true;
	}
}
