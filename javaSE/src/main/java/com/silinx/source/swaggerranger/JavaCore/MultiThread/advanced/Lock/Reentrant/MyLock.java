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
 * @Aha-eureka:  这个锁能够初步保证线程安全，但没有实现重入锁，即当两个方法相互调用时会出现一直等待的情况
 *******************************************************************************/

public class MyLock implements Lock {

    private boolean isLocked = false;

    @Override
    public synchronized void lock() {
        //这里要使用while不能使用if，使用if不能绝对保证线程安全
        while (isLocked) {
            try {
                wait();//进入等待
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        isLocked = true;
    }

    @Override
    public synchronized void unlock() {

        isLocked = false;
        notify();//唤醒其他线程
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
