package com.silinx.source.swaggerranger.JavaCore.MultiThread.advanced.Lock.Reentrant;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: Sychronized_Reentrant
 * @Author: liufei32@outlook.com
 * @Date: 2019/4/22 20:39
 * @Description: Synchronized的可重入性
 * @Aha-eureka: 程序正在运行时，执行线程可以再次进入并执行它，仍然获得符合设计时预期的结果。
 *               与多线程并发执行的线程安全不同，可重入强调对单个线程执行时重新进入同一个子程序仍然是安全的。
 *******************************************************************************/

public class Sychronized_Reentrant extends Sychronized_Reentrant_super {

    public Sychronized_Reentrant() {
        System.out.println("chid init");
    }

    @Override
    public synchronized void A() {
//        super.A();
        System.out.println("child A: " + Thread.currentThread().getName());
        B();
    }

    public synchronized void B() {
        super.A();
    }

    public static void main( String[] args ) {
        Sychronized_Reentrant sr = new Sychronized_Reentrant();
        sr.A();
    }
}

class Sychronized_Reentrant_super {

    public Sychronized_Reentrant_super() {
        System.out.println("super init");
    }

    protected synchronized void A() {
        System.out.println("super A: " + Thread.currentThread().getName());
    }
}

