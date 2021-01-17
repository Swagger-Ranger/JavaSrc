package com.silinx.app;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component // 切面本身也是一个bean，如果没有这个注解则返回的就是自身的对象而不是代理对象
@Aspect // 表面此是一个切面
public class NotVeryUsefulAspect {

    @Pointcut("execution(* com.silinx.service.*.*(..))") // the pointcut expression
    private void anyOldTransfer() {
    } // the pointcut signature

    @Before("anyOldTransfer()")
    public void doAccessCheck() {
        System.out.println("before");
    }
}
