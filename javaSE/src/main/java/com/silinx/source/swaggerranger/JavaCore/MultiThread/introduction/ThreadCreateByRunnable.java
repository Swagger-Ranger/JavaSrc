package com.silinx.source.swaggerranger.JavaCore.MultiThread.introduction;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: ThreadCreate
 * @Author: liufei32@outlook.com
 * @Date: 2019/3/4 9:59
 * @Description: 多线程的创建,通过实现Runnable接口创建线程，实现接口中的run()方法就是执行线程的内容
 *              ，其实这种实现只是一个线程任务，所以不是一个现成的线程，然后再创建一个Thread线程对象，传入实现了Runanble接口的类的实例到Thread的构造函数中，线程即创建成功
 *              执行Thread的方法就是执行线程方法
 * @Aha-eureka:
 *******************************************************************************/

public class ThreadCreateByRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("run 方法中就是线程内容......");

    }

    public static void main( String[] args ) {
        Thread thread = new Thread(new ThreadCreateByRunnable());
        thread.start();
    }
}
