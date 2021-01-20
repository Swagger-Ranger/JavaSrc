package com.silinx.source.swaggerranger.JavaCore.MultiThread.introduction;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: ThreadCreateByThread
 * @Author: liufei32@outlook.com
 * @Date: 2019/3/4 10:56
 * @Description: 通过继承Thread类来创建线程,然后重写run()方法来执行线程的内容，Thread中本身就有run()方法，但没有实际内容需要自己重写
 * @Aha-eureka:
 *******************************************************************************/

public class ThreadOfDaemon extends Thread {

    /**
     * Thread构造函数有很多参数，这里就传入一个字符串来指定线程的名字
     * */
    public ThreadOfDaemon( String name ) {
        super(name);
    }

    @Override
    public void run() {
        while (true)
            System.out.println(getName()+"running ......");
    }

    /**
     * 这里设置一个deamon参数，含义就是守护线程，即会在后台运行，当前的主线程仍会往下执行，（不是daemon则一直会执行当前的线程知道推出）
     * 同时，当主线程推出后daemon线程也会退出
     * @param args
     */
    public static void main( String[] args ) throws InterruptedException {
        ThreadOfDaemon d1 = new ThreadOfDaemon("first thread ");
        ThreadOfDaemon d2 = new ThreadOfDaemon("second thread ");

        d1.setDaemon(true);
        d2.setDaemon(true);

        d1.start();
        d2.start();

        //这里主线程必须sleep 才能看到daemon线程的打印，不然daemon线程在后台执行还未打印，主线程就会执行完成并退出
        Thread.sleep(2000);
    }
}
