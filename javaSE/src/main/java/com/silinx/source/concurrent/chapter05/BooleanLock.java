package com.silinx.source.concurrent.chapter05;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeoutException;

import static java.lang.System.currentTimeMillis;
import static java.lang.Thread.currentThread;

public class BooleanLock implements Lock
{

    private Thread currentThread;

    private boolean locked = false;

    private final List<Thread> blockedList = new ArrayList<>();

    @Override
    public void lock() throws InterruptedException
    {
        synchronized (this)
        {
            // todo 这里重入的时候不久死锁了吗，如果要实现重入，则需要增加一个计数器来记录重入的次数
            while (locked)
            {
                final Thread tempThread = currentThread();
                try {
                    if (!blockedList.contains(tempThread))
                        blockedList.add(tempThread);
                    this.wait();
                } catch (InterruptedException e) {
                    // 允许被打断，并且从blockedList删除，避免内存泄露
                    blockedList.remove(tempThread);
                    throw e;
                }
            }

            blockedList.remove(currentThread());
            this.locked = true;
            this.currentThread = currentThread();
        }
    }

    @Override
    public void lock(long mills) throws InterruptedException, TimeoutException
    {
        synchronized (this)
        {
            if (mills <= 0)
            {
                this.lock();
            } else
            {
                long remainingMills = mills;
                long endMills = currentTimeMillis() + remainingMills;
                while (locked)
                {
                    if (remainingMills <= 0)
                        throw new TimeoutException("can not get the lock during " + mills + " ms.");
                    final Thread tempThread = currentThread();
                    try {
                        if (!blockedList.contains(tempThread))
                            blockedList.add(tempThread);
                        this.wait(remainingMills);
                    } catch (InterruptedException e) {
                        // 允许被打断，并且从blockedList删除，避免内存泄露
                        blockedList.remove(tempThread);
                        throw e;
                    }

                    remainingMills = endMills - currentTimeMillis();
                }

                blockedList.remove(currentThread());
                this.locked = true;
                this.currentThread = currentThread();
            }
        }
    }

    @Override
    public void unlock()
    {
        synchronized (this)
        {
            if (currentThread == currentThread())
            {
                this.locked = false;
                Optional.of(currentThread().getName() + " release the lock monitor.")
                        .ifPresent(System.out::println);
                this.notifyAll();
            }
        }
    }

    @Override
    public List<Thread> getBlockedThreads()
    {
        return Collections.unmodifiableList(blockedList);
    }
}