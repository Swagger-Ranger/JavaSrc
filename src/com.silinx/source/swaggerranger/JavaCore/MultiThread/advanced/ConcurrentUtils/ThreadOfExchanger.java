package com.silinx.source.swaggerranger.JavaCore.MultiThread.advanced.ConcurrentUtils;

import java.util.concurrent.Exchanger;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: ThreadOfExchanger
 * @Author: liufei32@outlook.com
 * @Date: 2019/3/12 16:24
 * @Description: Exchanger两个线程之间交换数据
 * @Aha-eureka:
 *******************************************************************************/

public class ThreadOfExchanger {

    public void a( Exchanger<String> exchanger ) {
        System.out.println("方法A开始执行...");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("A获取数据中...");

        String val = "123456";

        System.out.println("A获取成功等待比对");

        try {
            String s = exchanger.exchange(val);
            System.out.println("a---" + s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void b( Exchanger<String> exchanger ) {
        String val = "12345";

        System.out.println("方法B开始执行...");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("B获取数据中...");
        try {
            //从exchanger中获取数据
            String res = exchanger.exchange(val);
            System.out.println("b----" + res);
            System.out.println("B获取成功正在比对");
            System.out.println("比对结果为：" + val.equals(res));

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main( String[] args ) {
        ThreadOfExchanger te = new ThreadOfExchanger();
        Exchanger<String> exch = new Exchanger<>();

        new Thread(() -> te.a(exch)).start();
        new Thread(() -> te.b(exch)).start();

    }
}
