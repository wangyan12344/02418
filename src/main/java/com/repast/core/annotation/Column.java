package com.repast.core.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.FIELD})
public @interface Column {
	
	public String name();

	public String comment() default "";
	
	public String required() default "false";
	
	public String maxLength() default "";
	
	public String minLength() default "";
	
	public String validateErrorMsg() default "";
	
	public String validateRegExp() default "";
}
