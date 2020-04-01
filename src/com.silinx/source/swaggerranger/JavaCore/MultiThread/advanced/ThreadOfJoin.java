package com.silinx.source.swaggerranger.JavaCore.MultiThread.advanced;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: ThreadOfJoin
 * @Author: liufei32@outlook.com
 * @Date: 2019/3/11 15:15
 * @Description: Join用法
 * @Aha-eureka:  在一个线程中调用join即在当前线程等待调用join的线程死亡后再继续往下执行，就是在一个线程中插入另外一个线程
 *******************************************************************************/

public class ThreadOfJoin {

    public void a( Thread joinThread ) {
        System.out.println("方法a开始执行...");

        joinThread.start();

        //join
        try {
            joinThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("方法a执行完毕...");

    }

    public void b() {
        System.out.println("join线程开始执行...");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("join线程执行完毕...");

    }

    public static void main( String[] args ) {
        ThreadOfJoin demo = new ThreadOfJoin();

        Thread join = new Thread(() -> demo.b());

        new Thread(() -> demo.a(join)).start();

    }
}
