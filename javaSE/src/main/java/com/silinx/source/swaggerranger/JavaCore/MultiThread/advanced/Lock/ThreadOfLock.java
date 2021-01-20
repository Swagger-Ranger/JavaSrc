package com.silinx.source.swaggerranger.JavaCore.MultiThread.advanced.Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: ThreadOfLock
 * @Author: liufei32@outlook.com
 * @Date: 2019/3/8 11:45
 * @Description: 线程中自定义锁，以及Lock接口的操作
 * @Aha-eureka:
 *******************************************************************************/

public class ThreadOfLock {

    private int value;

    /**
     * 所有要共享资源的线程都必须使用一把锁，所以一般锁都会设为全局变量，
     * 如果设为局部变量就要注意可能每个线程在进入时都会去新建自己的锁从而是每个线程拥有的锁不是同一把而导致线程安全性操作失败
     */
    Lock lock = new ReentrantLock();
    public int getNext() {
        lock.lock();//获取锁
        value++;
        lock.unlock();//释放锁
        return value;
    }

    public static void main( String[] args ) {
        ThreadOfLock threadOfLock = new ThreadOfLock();
        new Thread(()->{
            while (true) {
                System.out.println(Thread.currentThread().getName() + " " + threadOfLock.getNext());

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(()->{
            while (true) {
                System.out.println(Thread.currentThread().getName() + " " + threadOfLock.getNext());

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(()->{
            while (true) {
                System.out.println(Thread.currentThread().getName() + " " + threadOfLock.getNext());

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}

