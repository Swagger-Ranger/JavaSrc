package com.silinx.source.concurrent.chapter04;


public class SynchronizedBasic
{


    private final Object MUTEX = new Object();

    public void sync()
    {
        synchronized (MUTEX)
        {

        }
    }


    public synchronized static void staticSync()
    {

    }


}
