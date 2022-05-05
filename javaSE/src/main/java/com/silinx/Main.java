package com.silinx;

import java.util.LinkedHashSet;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Email:liufei32@outlook.com  github:Swagger-Ranger
 * @description
 * @since 2020/4/1 10:24
 */

public class Main {
    public static void main( String[] args ) throws InterruptedException {
        AtomicInteger integer = new AtomicInteger(1024);
        AtomicInteger integer2 = new AtomicInteger(1024);
        System.out.println(integer == integer2);
        System.out.println(integer.getAndIncrement());

        T t = new T();
        synchronized (t) {

            t.wait();

        }

        t.notify();
        System.out.println(t.s);
    }

    static class T {
        public boolean s;
    }

}
