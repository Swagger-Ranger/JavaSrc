package com.silinx.source.swaggerranger.JavaCore.MultiThread.advanced;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: ThreadOfSpinLock
 * @Author: liufei32@outlook.com
 * @Date: 2019/3/5 23:54
 * @Description: 线程的自旋锁理解，自旋就是在没有得到锁时会不断地等待锁，就是空转CPU时间片
 * @Aha-eureka:
 *******************************************************************************/

public class ThreadOfSpinLock {

    public static void main( String[] args ) {

        //这里新建了5个线程，他们会并发执行，但执行顺序并不确定
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"thread starting...");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName()+"thread ended...");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"thread starting...");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName()+"thread ended...");
            }
        }).start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName()+"thread starting...");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName()+"thread ended...");
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"thread starting...");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName()+"thread ended...");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"thread starting...");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName()+"thread ended...");
            }
        }).start();

        //然后在执行完成之后执行打印操作,然后你会发现这一行并不能保证在最后才执行
        System.out.println("all of threads is ended???");

        //加入自旋操作
        while (Thread.activeCount() != 1) {
            //这里不做任何操作，空转CPU，等待条件不符合退出，
            //Thread.activeCount()就是当前的活动线程，注意主线程也要算，所以是!=1

            //实现不对，但思路是这样的
        }

        System.out.println("all of threads is ended???  yes,yes,yes");

    }



}
