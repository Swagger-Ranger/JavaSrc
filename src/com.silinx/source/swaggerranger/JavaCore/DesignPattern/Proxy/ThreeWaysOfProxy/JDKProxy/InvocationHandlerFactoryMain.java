package com.silinx.source.swaggerranger.JavaCore.DesignPattern.Proxy.ThreeWaysOfProxy.JDKProxy;

/**
 * @author Email:liufei32@outlook.com  github:Swagger-Ranger
 * @description
 * @since 2020/5/18 1:11
 */

public class InvocationHandlerFactoryMain {

    public static void main( String[] args ) {
        ProxyFactoryInterface target = new Target();
        System.out.println("source target:" + target);

//        ProxyFactoryInterface proxy = (ProxyFactoryInterface) new ProxyFactory(target).getProxyInstance();
//        proxy.method();
//        System.out.println("normal Proxy: " + proxy.getClass());

        InvocationHandlerFactory invocationHandlerFactory = new InvocationHandlerFactory();
        invocationHandlerFactory.setRealHandler(target);
        ProxyFactoryInterface factoryInterface = (ProxyFactoryInterface) invocationHandlerFactory.getHandlerInstance();
        factoryInterface.method();
    }
}
