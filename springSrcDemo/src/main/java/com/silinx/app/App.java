package com.silinx.app;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@ComponentScan("com.silinx")
@EnableAspectJAutoProxy // 开启AspectJ风格的切面功能，如果没有此注解则没有切面功能，也可以使用xml中<aop:aspectj-autoproxy/>来完成
public class App {

}
