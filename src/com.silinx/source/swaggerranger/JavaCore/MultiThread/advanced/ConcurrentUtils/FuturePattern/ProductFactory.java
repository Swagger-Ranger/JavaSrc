package com.silinx.source.swaggerranger.JavaCore.MultiThread.advanced.ConcurrentUtils.FuturePattern;

import java.util.Random;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: ProductFactory
 * @Author: liufei32@outlook.com
 * @Date: 2019/3/12 22:20
 * @Description: 工厂类
 * @Aha-eureka:
 *******************************************************************************/

public class ProductFactory {

    public Future CreateFuture( String name ) {
        Future f = new Future();
        new Thread(()->{
            System.out.println("下单成功");
            Product p = new Product(new Random().nextInt(), name);
            f.setProduct(p);
        }).start();

        return f;
    }
}
