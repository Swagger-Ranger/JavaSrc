package com.silinx.source.swaggerranger.JavaCore.MultiThread.advanced.Lock.ReadWriteLock;

import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: LockOfReadWrite
 * @Author: liufei32@outlook.com
 * @Date: 2019/3/9 15:23
 * @Description: 读写锁
 * @Aha-eureka:  读写锁中，写和写线程是互斥的，写和读线程也是互斥的，但读和读线程则是共享的
 *******************************************************************************/

public class LockOfReadWrite {

    private HashMap<String, Object> data = new HashMap<>();

    //读写锁,ReentrantReadWriteLock类里提供了可重入的读写锁
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private Lock readLock = readWriteLock.readLock();
    private Lock writeLock = readWriteLock.writeLock();

    /**
     * try 里面可以不使用catch，这里使用finally来保证锁一定会被释放
     * @param key
     * @return
     */
    public Object get( String key ) {
        readLock.lock();
        System.out.println("读线程：" + Thread.currentThread().getName() + "正在进行操作。。。");
        try {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return data.get(key);
        }finally {
            readLock.unlock();
            System.out.println("读线程：" + Thread.currentThread().getName() + "操作完毕。。。");
        }
    }


    public void put( String key, Object value ) {
        writeLock.lock();
        System.out.println("写线程：" + Thread.currentThread().getName() + "正在进行操作。。。");

        try {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            data.put(key, value);
        }finally {
            writeLock.unlock();
            System.out.println("写线程：" + Thread.currentThread().getName() + "操作完毕。。。");

        }
    }


}
