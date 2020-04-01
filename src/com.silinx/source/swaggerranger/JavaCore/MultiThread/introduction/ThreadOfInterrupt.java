package com.silinx.source.swaggerranger.JavaCore.MultiThread.introduction;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: ThreadCreateByThread
 * @Author: liufei32@outlook.com
 * @Date: 2019/3/4 10:56
 * @Description: 线程的中止用法interrupted和interrupt，停止线程一般不使用stop()方法，因为stop方法不会去释放掉锁和其占用的资源
 * @Aha-eureka:
 *******************************************************************************/

public class ThreadOfInterrupt extends Thread {

    /**
     * Thread构造函数有很多参数，这里就传入一个字符串来指定线程的名字
     * */
    public ThreadOfInterrupt( String name ) {
        super(name);
    }

    @Override
    public void run() {
        //这里使用interrupted()来判断线程后面是否调用interrupt来停止线程，如果为true则会在线程执行完后停止并将锁和资源释放出来
        System.out.println(getName() + Thread.currentThread().isInterrupted());
        while (!interrupted()) {
            System.out.println(getName() + "running ......");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main( String[] args ) throws InterruptedException {
        ThreadOfInterrupt d1 = new ThreadOfInterrupt("first thread ");
        ThreadOfInterrupt d2 = new ThreadOfInterrupt("second thread ");

        d1.start();
        d2.start();

        //这里就直接会将d1线程停掉，可能d1都没有一句打印，因为d1和d2是单独的线程，当前的线程为主线程，
        //d1和d2会在主线程中几乎同时被启动起来，然后主线程也会继续执行后面的语句，即d1.interrupt();
        //也就是说，d1还未执行主线程就执行了interrupt停止了d1线程。如果线程中不加sleep，而在主线程中加sleep则会看到d1的执行打印
//        Thread.sleep(1000);
//        d1.interrupt();

        /**
         * （1）interrupt：在当前线程打一个停止标记，并不是真的停止线程。
         * （2）interrupted：测试当前线程是否已经中断，执行后具有将状态标识置为false的功能。
         * （3）isInterrupt：测试线程Thread是否已经是中断状态，但不清除状态标识。
         *
         * 执行下面一段结果为：
         * is stopped 1 ?: true
         * is stopped 2 ?: false
         */
        Thread.currentThread().interrupt();
//        System.out.println("is stopped 1 ?: "+Thread.interrupted());
//        System.out.println("is stopped 2 ?: "+Thread.interrupted());
        System.out.println("end!");
    }
}
