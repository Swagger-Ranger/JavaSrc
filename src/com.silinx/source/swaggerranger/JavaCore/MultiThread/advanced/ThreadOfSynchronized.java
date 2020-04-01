package com.silinx.source.swaggerranger.JavaCore.MultiThread.advanced;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: ThreadOfSynchronized
 * @Author: liufei32@outlook.com
 * @Date: 2019/3/5 9:56
 * @Description: synchronized内置锁
 * @Aha-eureka:
 *******************************************************************************/

public class ThreadOfSynchronized {

    private int value;

    public int getNextValue() {
        synchronized (Integer.valueOf(value)) {
            return value++;
        }
//        return value++;
    }

    public static void main( String[] args ) {
        ThreadOfSynchronized ts = new ThreadOfSynchronized();

        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " " + ts.getNextValue());
            }
        }).start();

        new Thread(()-> {
                while (true) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " " + ts.getNextValue());
                }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " " + ts.getNextValue());
                }
            }
        }).start();
    }
}
