package com.silinx.source.swaggerranger.JavaCore.MultiThread.advanced.ConcurrentUtils;

import java.util.concurrent.Semaphore;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: ThreadOfSemphore
 * @Author: liufei32@outlook.com
 * @Date: 2019/3/12 15:33
 * @Description: Semaphore使用示例
 * @Aha-eureka:  semaphore有点类似与线程池，实际上某些线程池就是使用的semaphore来实现的
 *******************************************************************************/

public class ThreadOfSemphore {

    public void method( Semaphore semaphore ) {
        //拿到许可才能进入执行
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "开始执行...");

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //释放许可，释放许可后面等待的线程才能进来
        semaphore.release();
    }

    public static void main( String[] args ) {
        ThreadOfSemphore ts = new ThreadOfSemphore();

        //新建一个semaphore并指定许可数量
        Semaphore semaphore = new Semaphore(10);

        while (true) {
            //创建线程并调用使用semaphore的方法，注意这里会一直执行下去，所以只是个演示用法
            new Thread(() -> ts.method(semaphore)).start();
        }
    }
}
