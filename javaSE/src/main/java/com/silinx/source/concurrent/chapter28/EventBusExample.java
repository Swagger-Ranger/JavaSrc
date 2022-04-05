package com.silinx.source.concurrent.chapter28;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/***************************************
 * @author:Alex Wang
 * @Date:2017/11/28
 * QQ: 532500648
 * QQ群:463962286
 ***************************************/
public class EventBusExample
{
    public static void main(String[] args)
    {

        //1.同步Event Bus
//        Bus bus = new EventBus("TestBus");
//        bus.register(new SimpleSubscriber1());
//        bus.register(new SimpleSubscriber2());
//        bus.post("Hello");
//        System.out.println("-----------------------");
//        bus.post("Hello", "test");

        //2.异步Event Bus
        Bus bus = new AsyncEventBus("TestBus", (ThreadPoolExecutor) Executors.newFixedThreadPool(10));
        bus.register(new SimpleSubscriber1());
        bus.register(new SimpleSubscriber2());
        bus.post("Hello");
        System.out.println("-----------------------");
        bus.post("Hello", "test");
    }
}
