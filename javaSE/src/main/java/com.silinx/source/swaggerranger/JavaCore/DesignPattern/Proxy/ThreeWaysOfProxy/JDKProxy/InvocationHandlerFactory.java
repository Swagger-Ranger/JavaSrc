package com.silinx.source.swaggerranger.JavaCore.DesignPattern.Proxy.ThreeWaysOfProxy.JDKProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Email:liufei32@outlook.com  github:Swagger-Ranger
 * @description ProxyFactory的另一种写法，此类直接实现InvocationHandler接口，并提供返回代理类的实例方法
 * @since 2020/5/18 0:49
 */

public class InvocationHandlerFactory implements InvocationHandler {

    // 真正的业务处理类，即被代理的类
    private Object realHandler;

    public void setRealHandler( Object realHandler ) {
        this.realHandler = realHandler;
    }

    public Object getRealHandler() {
        return realHandler;
    }

    public Object getHandlerInstance() {
        return Proxy.newProxyInstance(
                realHandler.getClass().getClassLoader(), // 对象的类加载器，和被代理对象保持一致
                realHandler.getClass().getInterfaces(),  // 实现的接口
                this                                  //获取InvocationHandler具体的代理实现，这里就是本类，也就是将Proxy获取实例的工作和具体操作聚合在了一起

        );
    }

    /**
     * 方法处理，被的代理的类要做的操作都在此方法中实现；这样就就实现了代码的服用，
     * @param proxy 调用该方法的代理实例
     * @param method 所述方法对应于调用代理实例上的接口方法的实例.--这里就是通过反射实现的
     * @param args method 方法的传参
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke( Object proxy, Method method, Object[] args ) throws Throwable {

        // 前置处理
        System.out.println("---------- before proxy-----------------");
        Object ret = method.invoke(realHandler, args);
        // 后置处理
        System.out.println("---------- after proxy-----------------");

        return ret;
    }
}
