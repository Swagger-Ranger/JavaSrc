package com.silinx.source.swaggerranger.JavaCore.MultiThread.advanced.ConcurrentUtils.FuturePattern;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: Main
 * @Author: liufei32@outlook.com
 * @Date: 2019/3/12 22:41
 * @Description:
 * @Aha-eureka:
 *******************************************************************************/

public class Main {

    public static void main( String[] args ) {
        ProductFactory pf = new ProductFactory();

        System.out.println("我购买Swagger...");

        //下订单，期间订单生产
        Future f = pf.CreateFuture("Swagger");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("稍后我来取...");

        //f.getProduct()使用future任务来获取结果
        System.out.println("我取件成功" + f.getProduct());
    }
}
