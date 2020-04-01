package com.silinx.source.jcip;

import java.util.concurrent.*;

/**
 * TestHarness
 * <p/>
 * Using CountDownLatch for starting and stopping threads in timing tests
 *
 * @author Brian Goetz and Tim Peierls
 */
public class TestHarness {
    public long timeTasks(int nThreads, final Runnable task)
            throws InterruptedException {
        final CountDownLatch startGate = new CountDownLatch(1);//启动闭锁来等待所有线程都到位之后在后面统一释放开始执行
        final CountDownLatch endGate = new CountDownLatch(nThreads);

        for (int i = 0; i < nThreads; i++) {
            Thread t = new Thread() {
                public void run() {
                    try {
                        startGate.await();//启动线程开始等待
                        try {
                            task.run();//开始执行
                        } finally {
                            endGate.countDown();//执行完后将结束闭锁countDown
                        }
                    } catch (InterruptedException ignored) {
                    }
                }
            };
            t.start();
        }

        long start = System.nanoTime();
        startGate.countDown();//开始统一执行
        endGate.await();//等待执行中的线程执行
        long end = System.nanoTime();
        return end - start;
    }
}
