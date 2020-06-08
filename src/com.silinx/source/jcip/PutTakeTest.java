package com.silinx.source.jcip;

import junit.framework.TestCase;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * PutTakeTest
 * <p/>
 * Producer-consumer test program for BoundedBuffer
 *
 * @author Brian Goetz and Tim Peierls
 * 测试并发的安全性
 * 如何测试并发操作的安全性：一种方法是，在进行并发读写的时候再使用一个队列或者集合作为影子列表来将并发操作时的读写操作在都复制
 * 操作一份到影子列表，然后对比两者的差异。但这不是一个好的方法，因为影子列表本身也需要同步，这样可能会干扰到测试线程的调度，同时影子列表本身也可能导致操作的阻塞
 *
 * 一个更好的方法是，通过一个对顺序敏感的校验和函数来计算所有入列与出列的操作的校验和，这样不仅能测试结果是否正确还能保证顺序的一致性，
 * 但这有个问题，就是只能在单线程中使用，因为如果扩展到多个读写操作也就是多生产者和消费者时，顺序是无法保证的。当有多个生产者和消费者时
 * 我们就需要一个对入列和出列顺序不敏感但能测试最终结果是否正确的校验和函数，其实只要满足交换律的运算都满足此，比如加法以及XOR异或
 * 。。。。。。这个问题在书JCIP的第209页有详细的描述
 */
@JCIPCodeInfo(chapter = "12.1.3",page = "210")
public class PutTakeTest extends TestCase {
    protected static final ExecutorService pool = Executors.newCachedThreadPool();

    /**
     * 保证线程是真的并发执行，因为如果线程执行时间很短那么很可能线程是串行执行的
     */
    protected CyclicBarrier barrier;

    /**
     * 并发安全队列，即要测试的就是这个队列的存取的数据安全性
     */
    protected final SemaphoreBoundedBuffer<Integer> bb;

    /**
     * nTrials：进行存取的测试次数
     * nPairs：测试的并发存取线程数
     */
    protected final int nTrials, nPairs;
    protected final AtomicInteger putSum = new AtomicInteger(0);
    protected final AtomicInteger takeSum = new AtomicInteger(0);

    public static void main( String[] args) throws Exception {
        new PutTakeTest(10, 10, 100000).test(); // sample parameters
        pool.shutdown();
    }

    public PutTakeTest(int capacity, int npairs, int ntrials) {
        this.bb = new SemaphoreBoundedBuffer<Integer>(capacity);
        this.nTrials = ntrials;
        this.nPairs = npairs;
        this.barrier = new CyclicBarrier(npairs * 2 + 1);
    }

    void test() {
        try {
            for (int i = 0; i < nPairs; i++) {
                pool.execute(new Producer());
                pool.execute(new Consumer());
            }
            barrier.await(); // wait for all threads to be ready，这里调用两次await是因为new CyclicBarrier(npairs * 2 + 1)
            barrier.await(); // wait for all threads to finish
            assertEquals(putSum.get(), takeSum.get());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    static int xorShift(int y) {
        y ^= (y << 6);
        y ^= (y >>> 21);
        y ^= (y << 7);
        return y;
    }

    class Producer implements Runnable {
        public void run() {
            try {
                int seed = (this.hashCode() ^ (int) System.nanoTime());
                int sum = 0;
                barrier.await();
                for (int i = nTrials; i > 0; --i) {
                    //将数据存入测试队列
                    bb.put(seed);
                    // 获取校验值
                    sum += seed;
                    seed = xorShift(seed);
                }
                putSum.getAndAdd(sum);
                barrier.await();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    class Consumer implements Runnable {
        public void run() {
            try {
                barrier.await();
                int sum = 0;
                for (int i = nTrials; i > 0; --i) {
                    //将数据从测试队列取出
                    sum += bb.take();
                }
                // 获取校验值
                takeSum.getAndAdd(sum);
                barrier.await();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
