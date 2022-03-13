package com.silinx.source.concurrent.chapter06;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class ThreadGroupEnumerateThreads
{
    public static void main(String[] args)
            throws InterruptedException
    {

        ThreadGroup myGroup = new ThreadGroup("MyGroup");
        Thread thread = new Thread(myGroup, () ->
        {
            while (true)
            {
                try
                {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e)
                {
                }
            }
        }, "MyThread");
        thread.start();

        TimeUnit.MILLISECONDS.sleep(2);
        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();


        Thread[] list = new Thread[mainGroup.activeCount()];
        int recurseSize = mainGroup.enumerate(list);
        Arrays.stream(list).forEach(t -> System.out.println(t.getThreadGroup() + t.getName()));

        // 在IDEA run运行时会多一个监控线程：java.lang.ThreadGroup[name=main,maxpri=10]Monitor Ctrl-Break
        System.out.println(recurseSize);

        recurseSize = mainGroup.enumerate(list, false);
        Arrays.stream(list).forEach(t -> System.out.println(t.getThreadGroup() + t.getName()));
        System.out.println(recurseSize);
    }
}