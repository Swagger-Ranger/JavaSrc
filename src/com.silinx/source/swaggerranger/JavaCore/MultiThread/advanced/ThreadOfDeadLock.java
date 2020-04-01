package com.silinx.source.swaggerranger.JavaCore.MultiThread.advanced;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: ThreadOfDeadLock
 * @Author: liufei32@outlook.com
 * @Date: 2019/3/6 0:19
 * @Description: 死锁
 * @Aha-eureka:  这里两个线程相互持有对方的锁，进而导致两个线程都无法被执行，注意：这里可能出现速度很快而没有出现死锁，所以将某一线程sleep一下
 *******************************************************************************/

public class ThreadOfDeadLock {

    private Object object1 = new Object();
    private Object object2 = new Object();

    public void a() {
        synchronized (object1) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (object2) {
                System.out.println("a");
            }
        }
    }

    public void b() {
        synchronized (object2) {

            synchronized (object1) {
                System.out.println("b");
            }
        }
    }


    public static void main( String[] args ) {

        ThreadOfDeadLock threadOfDeadLock = new ThreadOfDeadLock();

        new Thread(new Runnable() {
            @Override
            public void run() {
                threadOfDeadLock.a();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                threadOfDeadLock.b();
            }
        }).start();
    }
}
