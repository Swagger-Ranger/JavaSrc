package com.silinx.source.swaggerranger.JavaCore.MultiThread.advanced.Lock.Reentrant;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: MyLock
 * @Author: liufei32@outlook.com
 * @Date: 2019/3/8 12:53
 * @Description: 使用synchronized关键字来实现Lock接口，一个自定义的锁
 * @Aha-eureka:  实现一个可重入的锁,重入锁实现可重入性原理或机制是：
 *               每一个锁关联一个线程持有者和计数器，当计数器为 0 时表示该锁没有被任何线程持有，那么任何线程都可能获得该锁而调用相应的方法；
 *               当某一线程请求成功后，JVM会记下锁的持有线程，并且将计数器置为 1；此时其它线程请求该锁，则必须等待；
 *               而该持有锁的线程如果再次请求这个锁，就可以再次拿到这个锁，同时计数器会递增；
 *               当线程退出同步代码块时，计数器会递减，如果计数器为 0，则释放该锁。
 *******************************************************************************/

public class MyLockReenter implements Lock {

    private boolean isLocked = false;

    Thread lockBy = null;

    int lockCount = 0;

    @Override
    public synchronized void lock() {

        Thread cunrrent = Thread.currentThread();

        while (isLocked && cunrrent!=lockBy) {
            try {
                wait();//进入等待
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        isLocked = true;
        lockBy = cunrrent;
        lockCount++;
    }

    @Override
    public synchronized void unlock() {

        if (lockBy == Thread.currentThread()) {
            lockCount--;

            if (lockCount == 0) {
                notify();//唤醒其他线程
                isLocked = false;
            }
        }
    }


    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock( long time, TimeUnit unit ) throws InterruptedException {
        return false;
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
