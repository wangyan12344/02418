package com.repast.core.spring.auth;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 权限声明处理，要求业务方法进行权限检查的声明处理
 * @author luandong
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Author {
	CheckType type() default CheckType.CHECK_LOGIN;
}
