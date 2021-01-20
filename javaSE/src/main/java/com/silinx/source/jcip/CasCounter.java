package com.silinx.source.jcip;

import net.jcip.annotations.ThreadSafe;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * CasCounter
 * <p/>
 * Nonblocking counter using CAS
 *
 * @author Brian Goetz and Tim Peierls
 */
@JCIPCodeInfo(chapter = "15.2.1",page = "263")
@ThreadSafe
public class CasCounter {
    private SimulatedCAS value;

    public int getValue() {
        return value.get();
    }

    public int increment() {
        int v;
        do {
            v = value.get();
        } while (v != value.compareAndSwap(v, v + 1));
        return v + 1;
    }

    public static void main( String[] args ) {
        AtomicInteger atomicInteger = new AtomicInteger(1);

        System.out.println("expect:1 ,in fact is: " + atomicInteger.getAndAdd(2)) ;
        System.out.println("expect:3 ,in fact is: " + atomicInteger.getAndSet(2));
        System.out.println("expect:2 ,in fact is: " + atomicInteger.get());

    }
}
