package com.silinx.source.swaggerranger.JavaCore.MultiThread.advanced.Lock.AQS;

import java.util.concurrent.locks.Lock;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: Test_AQS
 * @Author: liufei32@outlook.com
 * @Date: 2019/3/8 23:46
 * @Description:
 * @Aha-eureka:
 *******************************************************************************/

public class Test_AQS {

    Lock lock = new MyLockOfAQS();

    private int value;

    //测试同步性
    public int nextValue() {
        lock.lock();
        try {
            Thread.sleep(500);
            return value++;
        } catch (InterruptedException e) {
//            e.printStackTrace();
            throw new RuntimeException();
        }
        finally {
            lock.unlock();//将释放锁的操作放入finally中，保证锁一定能被释放
        }

    }

    //测试重入性
    public void reentrants_a() {
        lock.lock();
        System.out.println("a");
        reentrants_b();
        lock.unlock();
    }
    public void reentrants_b() {
        lock.lock();
        System.out.println("b");
        lock.unlock();
    }

    public static void main( String[] args ) {
        Test_AQS test_aqs = new Test_AQS();


        /*new Thread(() -> {
            while (true) {
                System.out.println(Thread.currentThread().getName() + " " + test_aqs.nextValue());
            }
        }, "AQS-0").start();

        new Thread(() -> {
            while (true) {
                System.out.println(Thread.currentThread().getName() + " " + test_aqs.nextValue());
            }
        }, "AQS-1").start();

        new Thread(() -> {
            while (true) {
                System.out.println(Thread.currentThread().getName() + " " + test_aqs.nextValue());
            }
        }, "AQS-2").start();*/

        new Thread(() -> {
            test_aqs.reentrants_a();
        }, "AQS-Reentrant").start();

    }
}
