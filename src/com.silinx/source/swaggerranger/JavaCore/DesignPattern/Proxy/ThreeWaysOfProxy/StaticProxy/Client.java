package com.silinx.source.swaggerranger.JavaCore.DesignPattern.Proxy.ThreeWaysOfProxy.StaticProxy;

/*******************************************************************************
 * <p>@Copyright (C), 2018-2020,github:Swagger-Ranger </p>
 * <p>@FileName:    Client </p>
 * <p>@Author:      liufei32@outlook.com </p>
 * <p>@Date:        2020/1/20 21:40 </p>
 * <p>@Description: 静态动态代理:直接传入一个被代理的对象作为属性,然后在方法中调用代理对象的方法 </p>
 * <p>@Aha-eureka: 缺点:
 *              冗余。由于代理对象要实现与目标对象一致的接口，会产生过多的代理类。
 *              不易维护。一旦接口增加方法，目标对象与代理对象都要进行修改。
 * </p>
 ******************************************************************************/

public class Client implements ProxyInterface {

    private ProxyInterface target;

    public Client( ProxyInterface target ) {
        this.target = target;
    }

    @Override
    public void proxyMethod() {
        System.out.println("--- before proxy ---");
        target.proxyMethod();
        System.out.println("--- after proxy ---");
    }

    public static void main( String[] args ) {
        Target target = new Target();
        Client client = new Client(target);

        client.proxyMethod();
        /**
         * output:
         * --- before proxy ---
         * --- i am target ---
         * --- after proxy ---
         */
    }
}
