package com.silinx.source.concurrent.chapter17;

public interface Lock
{

    void lock() throws InterruptedException;

    void unlock();
}