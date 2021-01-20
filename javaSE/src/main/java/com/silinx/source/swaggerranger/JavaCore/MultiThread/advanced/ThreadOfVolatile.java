package com.silinx.source.swaggerranger.JavaCore.MultiThread.advanced;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: ThreadOfVolatile
 * @Author: liufei32@outlook.com
 * @Date: 2019/3/7 18:01
 * @Description: Volatile示例
 * @Aha-eureka:  这里的 isRun 如果不加 volatile 同步给另一个线程那么将永远卡死在while里
 *******************************************************************************/

public class ThreadOfVolatile {

    private volatile boolean isRun = false;

    public boolean isRun() {
        return isRun;
    }

    public void setRun( boolean run ) {
        isRun = run;
    }


    public static void main( String[] args ) {
        ThreadOfVolatile threadOfVolatile = new ThreadOfVolatile();

        new Thread(()->{
            for (int i = 1; i < 10; i++) {
                System.out.println("running the " + i + "th thread");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            threadOfVolatile.setRun(true);

        }).start();

        new Thread(()->{
            //这里等待线程1来通知跳出死循环
            while (!threadOfVolatile.isRun) {
                //空，等待
            }
            System.out.println("the another thread is started! ");

        }).start();
    }

}
