package com.silinx.source.jcip;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ConditionBoundedBuffer
 * <p/>
 * Bounded buffer using explicit condition variables
 *
 * @author Brian Goetz and Tim Peierls
 */
@JCIPCodeInfo(chapter = "14.3",page = "252")
@ThreadSafe
public class ConditionBoundedBuffer <T> {
    protected final Lock lock = new ReentrantLock();
    // CONDITION PREDICATE: notFull (count < items.length)
    private final Condition notFull = lock.newCondition();
    // CONDITION PREDICATE: notEmpty (count > 0)
    private final Condition notEmpty = lock.newCondition();
    private static final int BUFFER_SIZE = 100;
    @GuardedBy("lock") private final T[] items = (T[]) new Object[BUFFER_SIZE];
    @GuardedBy("lock") private int tail, head, count;

    // BLOCKS-UNTIL: notFull
    public void put(T x) throws InterruptedException {
        lock.lock();
        try {
            /**
             * await，Object.wait进入阻塞状态等待被唤醒或者中断，并且会自动释放持有的锁。
             * 当持有锁的线程发起对应condition的signal或者signalAll时会去获取锁（signalAll比signal高效的原因就是减少锁的请求次数和上下文切换），
             * 当获取到锁之后才继续往下执行
             */
            while (count == items.length)
                notFull.await();
            items[tail] = x;
            if (++tail == items.length)
                tail = 0;
            ++count;
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    // BLOCKS-UNTIL: notEmpty
    public T take() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0)
                notEmpty.await();
            T x = items[head];
            items[head] = null;
            if (++head == items.length)
                head = 0;
            --count;
            notFull.signal();
            return x;
        } finally {
            lock.unlock();
        }
    }

//    public synchronized void test() throws InterruptedException {
//        Lock lock = new ReentrantLock();
//        try {
//            while (true) {
//                System.out.println("-----------");
//                this.wait();
////                lock.unlock();
//
//            }
//        }finally {
//            System.out.println("11111111111111111111111");
//        }
//    }
//
//    public static void main( String[] args ) throws InterruptedException {
//        ConditionBoundedBuffer conditionBoundedBuffer = new ConditionBoundedBuffer();
//        conditionBoundedBuffer.test();
//    }
}
