package com.silinx.source.swaggerranger.JavaCore.MultiThread.advanced.AtomicClass;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: ThreadOfSynchronized
 * @Author: liufei32@outlook.com
 * @Date: 2019/3/5 9:56
 * @Description: 不使用synchronized，而使用原子类实现保证线程安全性操作
 * @Aha-eureka:
 *******************************************************************************/

public class ThreadOfSynchronized_Atomic {

    //基本类型
    private AtomicInteger value = new AtomicInteger();

    //数组
    private int[] ints = {1, 2, 4, 8, 16};
    AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(ints);

    //抽象类型,抽象类型的字段必须使用volatile来修饰，不然会运行报错
    User user = new User();
    AtomicReference<User> userAtomicReference = new AtomicReference<>();
    //然后使用AtomicIntegerFieldUpdater更新字段
    AtomicIntegerFieldUpdater userUpdate = AtomicIntegerFieldUpdater.newUpdater(User.class, "age");

    public int getNextValue() {
        userUpdate.getAndIncrement(user);
        System.out.println(user.age);
        return value.getAndIncrement();
    }

    public static void main( String[] args ) {
        ThreadOfSynchronized_Atomic ts = new ThreadOfSynchronized_Atomic();

        new Thread(()->{
            while (true) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + " " + ts.getNextValue());
            }

        },"Swagger").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " " + ts.getNextValue());
                }
            }
        },"Ranger").start();
    }
}
