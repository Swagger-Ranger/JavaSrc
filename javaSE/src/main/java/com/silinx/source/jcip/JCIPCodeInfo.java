package com.silinx.source.jcip;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Email:liufei32@outlook.com  github:Swagger-Ranger
 * @description 定义一个分类Java并发编程实战代码的注解
 * @since 2020/4/2 17:18
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface JCIPCodeInfo {

    String chapter() default "";

    String page() default "";
}
