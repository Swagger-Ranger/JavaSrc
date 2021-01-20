package com.silinx.source.swaggerranger.JavaCore.MultiThread.advanced.Lock;

import java.util.concurrent.locks.StampedLock;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: ThreadOfStampedLock
 * @Author: liufei32@outlook.com
 * @Date: 2019/3/17 18:31
 * @Description: StampedLock代码示例
 * @Aha-eureka:
 *******************************************************************************/

public class ThreadOfStampedLock {

    private int balance;

    private StampedLock lock = new StampedLock();

    public void read() {

        long stamp = lock.readLock();

        int c = balance;
        System.out.println("read value: " + c);

        lock.unlock(stamp);

    }

    /**
     * 乐观读
     */
    public void optimisticRead() {

        long stamp = lock.tryOptimisticRead();

        int c = balance;
        //这里可能出现写操作需要进行判断
        if (!lock.validate(stamp)) {
            //重新读
            long readStamp = lock.readLock();
            c = balance;
            System.out.println("read value: " + c);
            stamp = readStamp;
        }

        lock.unlockRead(stamp);



        lock.unlock(stamp);

    }

    public void write(int value) {

        //加锁
        long stamp = lock.writeLock();
        balance += value;
        //释放锁，释放锁需要把stamp传进去
        lock.unlockWrite(stamp);

    }

    /**
     * 在一定条件下将读写锁的转换
     * @param value
     */
    public void conditionReadWrite( int value ) {
        //首先判断
        long stamp = lock.readLock();
        while (balance > 0) {
            long writeStamp = lock.tryConvertToWriteLock(stamp);
            //成功转换成写锁
            if (writeStamp != 0) {
                stamp = writeStamp;
                balance += value;
                break;
            } else {
                //如果没有转换写锁成功，则要先释放读锁，再拿到写锁
                lock.unlockRead(stamp);
                stamp = lock.writeLock();//然后再执行while
            }
        }

        lock.unlock(stamp);
    }
}
