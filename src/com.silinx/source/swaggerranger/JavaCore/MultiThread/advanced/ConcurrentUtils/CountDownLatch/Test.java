package com.silinx.source.swaggerranger.JavaCore.MultiThread.advanced.ConcurrentUtils.CountDownLatch;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: Test
 * @Author: liufei32@outlook.com
 * @Date: 2019/3/12 11:59
 * @Description:
 * @Aha-eureka:
 *******************************************************************************/

public class Test {
    public static void main( String[] args ) {
        System.out.println(Thread.activeCount());
        while (Thread.activeCount() > 1) {
            //
        }
    }
}
