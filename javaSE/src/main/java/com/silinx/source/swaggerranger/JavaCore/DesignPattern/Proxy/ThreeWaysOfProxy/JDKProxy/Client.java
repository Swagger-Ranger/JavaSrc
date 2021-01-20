package com.silinx.source.swaggerranger.JavaCore.DesignPattern.Proxy.ThreeWaysOfProxy.JDKProxy;

/*******************************************************************************
 * <p>@Copyright (C), 2018-2020,github:Swagger-Ranger </p>
 * <p>@FileName:    Client </p>
 * <p>@Author:      liufei32@outlook.com </p>
 * <p>@Date:        2020/1/20 22:53 </p>
 * <p>@Description:  </p>
 * <p>@Aha-eureka: </p>
 ******************************************************************************/

public class Client {
    public static void main( String[] args ) {
        ProxyFactoryInterface target = new Target();
        System.out.println("source target:" + target);

        ProxyFactoryInterface proxy = (ProxyFactoryInterface) new ProxyFactory(target).getProxyInstance();
        proxy.method();
        System.out.println("normal Proxy: " + proxy.getClass());

        ProxyFactoryInterface proxy2 = (ProxyFactoryInterface) new ProxyFactory(target).getProxyInstanceLambda();
        proxy2.method();
        System.out.println("lambda Proxy: " + proxy2.getClass());

    }
}
