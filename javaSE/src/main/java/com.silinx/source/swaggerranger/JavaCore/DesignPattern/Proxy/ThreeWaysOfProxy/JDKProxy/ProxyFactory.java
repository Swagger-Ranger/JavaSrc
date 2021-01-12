package com.silinx.source.swaggerranger.JavaCore.DesignPattern.Proxy.ThreeWaysOfProxy.JDKProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/*******************************************************************************
 * <p>@Copyright (C), 2018-2020,github:Swagger-Ranger </p>
 * <p>@FileName:    ProxyFactory </p>
 * <p>@Author:      liufei32@outlook.com </p>
 * <p>@Date:        2020/1/20 22:08 </p>
 * <p>@Description: JDK动态代理
 * 静态代理在编译时就已经实现，编译完成后代理类是一个实际的class文件
 * 动态代理是在运行时动态生成的，即编译完成后没有实际的class文件，而是在运行时动态生成类字节码，并加载到JVM中
 *
 * 动态代理对象不需要实现接口，但是要求目标对象必须实现接口，否则不能使用动态代理。
 * </p>
 * <p>@Aha-eureka: </p>
 ******************************************************************************/

public class ProxyFactory {

    //需要维护一个目标对象
    private Object target;

    public ProxyFactory( Object target ) {
        this.target = target;
    }

    //为目标对象生成代理对象--lambda
    public Object getProxyInstanceLambda() {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                ( proxy, method, args ) -> {
                    System.out.println("--- JDK Proxy before ---");
                    Object returnValue = method.invoke(target, args);
                    System.out.println("--- JDK Proxy after ---");
                    return returnValue;
                }
        );
    }

    public Object getProxyInstance() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke( Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("开启事务");

                        // 执行目标对象方法
                        Object returnValue = method.invoke(target, args);

                        System.out.println("提交事务");
                        return null;
                    }
                });
    }


}
