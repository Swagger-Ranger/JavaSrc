package com.silinx.source.swaggerranger.JavaCore.MultiThread.advanced;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: ThreadOfThreadLocal
 * @Author: liufei32@outlook.com
 * @Date: 2019/3/11 21:37
 * @Description: 线程本地变量
 * @Aha-eureka:
 *******************************************************************************/

public class ThreadOfThreadLocal {

    /**
     * ThreadLocal是一个类用来存储线程的本地变量，这里新建时直接新建了一个ThreadLocal的子类复写他的initialValue方法来给变量赋予初始值
     */
    private ThreadLocal<Integer> count = new ThreadLocal(){
        @Override
        protected Integer initialValue() {
            return new Integer(0);
        }
    };

    /**
     * 这个方法用来展示ThreadLocal的使用，即当线程调用这个方法时就将ThreadLocal变量integer ++,然后统计方法的调用次数
     * @return
     */
    public int getNext() {
        Integer value = count.get();
        value++;
        count.set(value);
        return value;
    }

    public static void main( String[] args ) {
        ThreadOfThreadLocal ttl = new ThreadOfThreadLocal();

        new Thread(() -> {
            while (true) {
                //这里调用了ttl的getNext方法，但每个线程之间的count是独立的相互不影响
                System.out.println(Thread.currentThread().getName() + ": " + ttl.getNext());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();

        new Thread(() -> {
            while (true) {
                System.out.println(Thread.currentThread().getName() + ": " + ttl.getNext());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                System.out.println(Thread.currentThread().getName() + ": " + ttl.getNext());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
