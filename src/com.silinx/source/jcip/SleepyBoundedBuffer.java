package com.silinx.source.jcip;

import net.jcip.annotations.*;

/**
 * SleepyBoundedBuffer
 * <p/>
 * Bounded buffer using crude blocking
 *
 * @author Brian Goetz and Tim Peierls
 */
@JCIPCodeInfo(chapter = "14.1.2", page = "241")
@ThreadSafe
public class SleepyBoundedBuffer<V> extends BaseBoundedBuffer<V> {
    int SLEEP_GRANULARITY = 60;

    public SleepyBoundedBuffer() {
        this(100);
    }

    public SleepyBoundedBuffer( int size ) {
        super(size);
    }

    public void put( V v ) throws InterruptedException {
        while (true) {
            synchronized (this) {
                if (!isFull()) {
                    doPut(v);
                    return;
                }
            }
            /**
             * 不满足条件就释放锁先休眠（内置锁退出代码块就自动释放锁），
             * 不能在休眠或阻塞时持有锁，否则线程一旦不能释放锁，就会导致有些条件永远无法为真进而死锁
             */
            Thread.sleep(SLEEP_GRANULARITY);
        }
    }

    public V take() throws InterruptedException {
        while (true) {
            synchronized (this) {
                if (!isEmpty())
                    return doTake();
            }
            Thread.sleep(SLEEP_GRANULARITY);
        }
    }
}
