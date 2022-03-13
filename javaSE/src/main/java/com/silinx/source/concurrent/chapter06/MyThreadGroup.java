package com.silinx.source.concurrent.chapter06;

public class MyThreadGroup extends ThreadGroup {

    public MyThreadGroup(String name) {
        super(name);
    }

    public MyThreadGroup(ThreadGroup parent, String name) {
        super(parent, name);
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println(t.getName() + " occur exception");
        e.printStackTrace();
    }
}
