package com.silinx.source.swaggerranger.JavaCore.MultiThread.advanced.ThreadOfPool;

import java.util.concurrent.*;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: ThreadOfPool
 * @Author: liufei32@outlook.com
 * @Date: 2019/3/4 15:47
 * @Description: 线程池的入门
 * @Aha-eureka:
 *******************************************************************************/

public class ThreadPool {

    /**
     * 线程池具体的有固定大小的newFixedThreadPool，newCachedThreadPool()则是根据任务数量来自动管理线程池大小，线程池中线程不够用来就会自动新建
     */
    public static void threadPoolOfExcutor() {
        //Executor和ExecutorService都是一个接口，Executors.new...有很多可用的线程池类型可用
        ExecutorService threadPool = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 100; i++) {
            //excute中创建线程
            threadPool.execute(() -> System.out.println(Thread.currentThread().getName()+" is running..."));
        }
        //销毁线程池
        threadPool.shutdown();
    }

    public static void threadPoolOfThreadPoolExecutor() {
//        ThreadPoolExecutor pool = new ThreadPoolExecutor(10, 10, 0, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>());

        //ExecutorService就是对ThreadPoolExecutor的封装，直接提供一个更简单配置的工具类
        ExecutorService pool = Executors.newFixedThreadPool(10);
        while (true) {
            pool.execute(()->{
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            });
        }
    }

    public static void main( String[] args ) {
//        threadPoolOfExcutor();
        threadPoolOfThreadPoolExecutor();
    }

}
