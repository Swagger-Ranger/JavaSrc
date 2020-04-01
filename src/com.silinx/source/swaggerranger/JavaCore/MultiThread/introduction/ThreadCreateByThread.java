package com.silinx.source.swaggerranger.JavaCore.MultiThread.introduction;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: ThreadCreateByThread
 * @Author: liufei32@outlook.com
 * @Date: 2019/3/4 10:56
 * @Description: 通过继承Thread类来创建线程,然后重写run()方法来执行线程的内容，Thread中本身就有run()方法，但没有实际内容需要自己重写
 * @Aha-eureka:
 *******************************************************************************/

public class ThreadCreateByThread extends Thread {

    /**
     * Thread构造函数有很多参数，这里就传入一个字符串来指定线程的名字
     * */
    public ThreadCreateByThread( String name ) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(getName()+"running ......");
    }

    public static void main( String[] args ){
        ThreadCreateByThread d1 = new ThreadCreateByThread("first thread ");
        ThreadCreateByThread d2 = new ThreadCreateByThread("second thread ");

        d1.start();
        d2.start();

    }
}
