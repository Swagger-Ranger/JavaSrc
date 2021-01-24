package com.silinx.beanPostProcessorDemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class IndexProxyHandler implements InvocationHandler {

    Object object;

    public IndexProxyHandler(Object o) {
        this.object = o;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("自定義動態代理");

        return method.invoke(object, args);
    }
}
