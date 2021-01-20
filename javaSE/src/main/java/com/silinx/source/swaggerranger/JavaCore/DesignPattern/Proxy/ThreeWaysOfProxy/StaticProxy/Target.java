package com.silinx.source.swaggerranger.JavaCore.DesignPattern.Proxy.ThreeWaysOfProxy.StaticProxy;

/*******************************************************************************
 * <p>@Copyright (C), 2018-2020,github:Swagger-Ranger </p>
 * <p>@FileName:    Target </p>
 * <p>@Author:      liufei32@outlook.com </p>
 * <p>@Date:        2020/1/20 21:59 </p>
 * <p>@Description: 目标类 </p>
 * <p>@Aha-eureka: </p>
 ******************************************************************************/

public class Target implements ProxyInterface {

    @Override
    public void proxyMethod() {
        System.out.println("--- i am target ---");
    }
}
