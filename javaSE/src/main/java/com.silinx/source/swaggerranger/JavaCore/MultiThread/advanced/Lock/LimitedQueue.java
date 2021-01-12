package com.silinx.source.swaggerranger.JavaCore.MultiThread.advanced.Lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: LimitedQueue
 * @Author: liufei32@outlook.com
 * @Date: 2019/3/10 17:21
 * @Description: 线程安全地有界单向队列
 * @Aha-eureka:
 *******************************************************************************/

public class LimitedQueue<T> {

    //队列长度
    private int queueSize;

    //入队指针
    private int addIndex;

    //出队指针
    private int removeIndex;

    //队列
    private Object[] queue;

    public LimitedQueue(int size) {
        this.queue = new Object[size];
    }
    //线程安全操作
    Lock lock = new ReentrantLock();
    Condition addCondition = lock.newCondition();
    Condition removeCondition = lock.newCondition();

    /**
     * 入队方法
     *
     * @param t
     */
    public void add( T t ) {
        lock.lock();

        while (queueSize >= queue.length - 1) {
            try {
                addCondition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        queue[addIndex] = t;
        queueSize++;

        if (++addIndex == queue.length) {
            addIndex = 0;
        }

        removeCondition.signal();

        lock.unlock();
    }


    /**
     * @Description 出队方法
     */
    public void remove() {
        lock.lock();

        while (queueSize == 0) {
            try {
                removeCondition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        queue[removeIndex] = null;
        queueSize--;

        if (++removeIndex == queue.length) {
            removeIndex = 0;
        }

        addCondition.signal();

        lock.unlock();
    }
}
