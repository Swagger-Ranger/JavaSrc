package com.silinx.source.concurrent.chapter19;

public interface Future<T>
{
    T get() throws InterruptedException;

    boolean done();
}