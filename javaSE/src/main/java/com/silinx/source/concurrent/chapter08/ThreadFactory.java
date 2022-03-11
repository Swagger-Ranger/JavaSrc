package com.silinx.source.concurrent.chapter08;

public interface ThreadFactory
{
    Thread createThread(Runnable runnable);
}
