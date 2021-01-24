package com.silinx.app;

import com.silinx.beanPostProcessorDemo.IndexAnnotation;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.silinx")
//@EnableAspectJAutoProxy(proxyTargetClass = true) // 开启AspectJ风格的切面功能，如果没有此注解则没有切面功能，也可以使用xml中<aop:aspectj-autoproxy/>来完成
@IndexAnnotation
public class App {

}
