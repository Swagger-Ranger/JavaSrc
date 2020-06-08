package com.silinx.source.jcip;

import java.util.concurrent.*;

/**
 * TimedPutTakeTest
 * <p/>
 * Testing with a barrier-based timer
 *
 * @author Brian Goetz and Tim Peierls
 */
@JCIPCodeInfo(chapter = "12.2.1",page = "215")
public class TimedPutTakeTest extends PutTakeTest {
    private BarrierTimer timer = new BarrierTimer();

    public TimedPutTakeTest(int cap, int pairs, int trials) {
        super(cap, pairs, trials);
        /**
         * 创建一个新的 CyclicBarrier ，当给定数量的线程（线程）等待时，它将跳闸，
         * 当屏障跳闸时执行给定的屏障动作，由最后一个进入屏障的线程执行
         */
        barrier = new CyclicBarrier(nPairs * 2 + 1, timer);
    }

    public void test() {
        try {
            timer.clear();
            for (int i = 0; i < nPairs; i++) {
                pool.execute(new PutTakeTest.Producer());
                pool.execute(new PutTakeTest.Consumer());
            }
            barrier.await();
            barrier.await();
            long nsPerItem = timer.getTime() / (nPairs * (long) nTrials);
            System.out.print("Throughput: " + nsPerItem + " ns/item");
            assertEquals(putSum.get(), takeSum.get());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main( String[] args) throws Exception {
        int tpt = 100000; // trials per thread
        for (int cap = 1; cap <= 1000; cap *= 10) {
            System.out.println("Capacity: " + cap);
            for (int pairs = 1; pairs <= 128; pairs *= 2) {
                TimedPutTakeTest t = new TimedPutTakeTest(cap, pairs, tpt);
                System.out.print("Pairs: " + pairs + "\t");
                t.test();
                System.out.print("\t");
                Thread.sleep(1000);
                t.test();
                System.out.println();
                Thread.sleep(1000);
            }
        }
        PutTakeTest.pool.shutdown();
    }
}
