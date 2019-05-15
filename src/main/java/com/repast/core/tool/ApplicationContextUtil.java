package com.repast.core.tool;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.repast.core.cache.CacheKeyDefineManager;

public class ApplicationContextUtil implements ApplicationContextAware {

	private static ApplicationContext context;

	// 声明一个静态变量保存

	public void setApplicationContext(ApplicationContext contex)
			throws BeansException {
		System.out.println("获取spring上下文环境成功!");
		this.context = contex;
		//初始化缓存配置文件
		CacheKeyDefineManager.getInstance().init();
	}

	public static ApplicationContext getContext() {

		return context;

	}

	public final static Object getBean(String beanName) {
		return context.getBean(beanName);
	}

	public final static Object getBean(String beanName, Class<?> requiredType) {
		return context.getBean(beanName, requiredType);
	}

}