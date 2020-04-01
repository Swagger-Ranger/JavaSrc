package com.silinx.source.swaggerranger.JavaCore.DesignPattern.Proxy.ThreeWaysOfProxy.JDKProxy;

/*******************************************************************************
 * <p>@Copyright (C), 2018-2020,github:Swagger-Ranger </p>
 * <p>@FileName:    Target </p>
 * <p>@Author:      liufei32@outlook.com </p>
 * <p>@Date:        2020/1/20 22:24 </p>
 * <p>@Description:  </p>
 * <p>@Aha-eureka: </p>
 ******************************************************************************/

public class Target implements ProxyFactoryInterface {

    @Override
    public void method() {
        System.out.println("--- JDK Proxy ---");
    }
}
