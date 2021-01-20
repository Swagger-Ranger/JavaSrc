package com.silinx.source.swaggerranger.JavaCore.MultiThread.advanced.Lock.Reentrant;

import java.util.concurrent.locks.Lock;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: MyLockTest
 * @Author: liufei32@outlook.com
 * @Date: 2019/3/8 13:01
 * @Description:
 * @Aha-eureka:
 *******************************************************************************/

public class MyLockTest {

    private int value;

    /**
     * 基本数据可见性测试
     */
    Lock lock = new MyLock();
    public int getNext() {
        lock.lock();//获取锁
        value++;
        lock.unlock();//释放锁
        return value;
    }

    /**
     * 重入锁测试
     */
    Lock lockReenter = new MyLockReenter();
    public void a() {
        lockReenter.lock();
        System.out.println("a------a");
        b();
        lockReenter.unlock();
    }
    public void b() {
        lockReenter.lock();
        System.out.println("b------b");
        lockReenter.unlock();
    }


    /**
     * 这个测试基本的不加同步锁的自定义锁
     */
    public static void test() {
        MyLockTest threadOfLock = new MyLockTest();

        //线程的基本安全性能够得到保证，但没有实现同步锁
//        new Thread(()->{
//            while (true) {
//                System.out.println(Thread.currentThread().getName() + " " + threadOfLock.getNext());
//
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
//
//        new Thread(()->{
//            while (true) {
//                System.out.println(Thread.currentThread().getName() + " " + threadOfLock.getNext());
//
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();


        //没有同步锁就会卡死
        threadOfLock.a();
    }

    public static void testReenter() {
        MyLockTest myLockTest = new MyLockTest();
        myLockTest.a();
        myLockTest.b();
    }

    public static void main( String[] args ) {
//        test();
        testReenter();
    }

}
