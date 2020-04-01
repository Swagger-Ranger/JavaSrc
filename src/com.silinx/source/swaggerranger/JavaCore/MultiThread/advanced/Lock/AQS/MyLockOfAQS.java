package com.silinx.source.swaggerranger.JavaCore.MultiThread.advanced.Lock.AQS;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: MyLockOfAQS
 * @Author: liufei32@outlook.com
 * @Date: 2019/3/8 22:16
 * @Description: 使用AbstractQueuedSynchronizer来定制自定义的锁
 * @Aha-eureka:
 *******************************************************************************/

public class MyLockOfAQS implements Lock {

    private Sync sync = new Sync();
    private class Sync extends AbstractQueuedSynchronizer {

        /**
         * AbstractQueuedSynchronizer作为内部帮助器使用，通过AbstractQueuedSynchronizer来实现Lock接口的方法
         * tryAcquire和tryRelease是使用AbstractQueuedSynchronizer需要自己实现同步锁的自定义的方法，
         * 父类中的对应方法只是会抛出异常
         */

        @Override
        protected boolean tryAcquire( int arg ) {
            /**
             * 这个方法是获得锁，且为独占锁，现在需要考虑一下问题
             * 1.如果是第一个线程进来，可以拿到锁，因此我们可以返回true
             * 2.如果是第二个线程进来，拿不到锁，返回false.
             *     注意保证重入锁：如果进来的线程和当前保存的线程是同一个线程则可以拿到锁，但是必须更新状态值
             * 3.如何判断进来的是第一个线程还是其他的线程
             */
            //获取线程状态，默认是0，即第一次没有线程进来就是0
            int state = getState();
            Thread thisThread = Thread.currentThread();
            if (state == 0) {
                if (compareAndSetState(0, arg)) {
                    //设置当前的线程为独自线程，这里不设置也可以，但设置会更安全
                    setExclusiveOwnerThread(thisThread);
                    return true;
                }
            } else if (getExclusiveOwnerThread() == thisThread) {
                setState(state + 1);
                return true;
            }

            return false;
        }

        @Override
        protected boolean tryRelease( int arg ) {
//            return super.tryRelease(arg);
            //锁的获取和释放肯定是一一对应的，调用此方法的一定是当前线程
            if (Thread.currentThread() != getExclusiveOwnerThread()) {
                throw new RuntimeException("当前线程不是持有锁的线程");
            }

            int state = getState() - arg;//这里arg一般就是1
            boolean flag = false;//设置返回标志
            if (state == 0) {
                setExclusiveOwnerThread(null);//将独占线程设为空，即释放锁
                flag = true;
            }
            setState(state);

            return flag;
        }

        //新建一个Condition用以返回给外部的锁Condition方法
        Condition newCondition() {
            return new ConditionObject();
        }
    }

    @Override
    public void lock() {
        sync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock( long time, TimeUnit unit ) throws InterruptedException {
        return sync.tryAcquireNanos(1, unit.toNanos(time));
    }

    @Override
    public void unlock() {
        sync.release(1);
    }

    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }

}
