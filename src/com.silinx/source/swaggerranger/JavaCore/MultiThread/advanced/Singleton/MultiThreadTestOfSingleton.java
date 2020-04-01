package com.silinx.source.swaggerranger.JavaCore.MultiThread.advanced.Singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: MultiThreadTestOfSingleton
 * @Author: liufei32@outlook.com
 * @Date: 2019/3/5 14:43
 * @Description: 多线程下的单例测试
 * @Aha-eureka:
 *******************************************************************************/

public class MultiThreadTestOfSingleton {

    public static void main( String[] args ) {


        ExecutorService threadPool = Executors.newFixedThreadPool(10);

        //懒汉式不加线程安全操作的测试
        for (int i = 0; i < 20; i++) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + ":" + SingletonOfIdler.getInstance());
                }
            });
        }
        threadPool.shutdown();
    }
}
