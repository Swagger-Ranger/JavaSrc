package com.silinx.source.swaggerranger.JavaCore.MultiThread.advanced.ThreadCancel;

/**
 * @author Email:liufei32@outlook.com  github:Swagger-Ranger
 * @description 测试取消一个死循环的线程
 * @since 2020/4/2 17:18
 */

public class CancelTest {

    public static void main( String[] args ) {

        Thread threadDeadLoop = new Thread(()->{
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    System.out.println("before cancelled : "+Thread.currentThread().isInterrupted());

                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println("cancel? : "+Thread.currentThread().isInterrupted());

                    //线程静态方法Thread.currentThread().interrupted()就是在清楚线程状态
//                    System.out.println("11111111" + Thread.currentThread().interrupted());
//                    System.out.println("222222222" + Thread.currentThread().interrupted());
                    Thread.currentThread().interrupt();
                    System.out.println("3333333" + Thread.currentThread().interrupted());

                    System.out.println(" is cancelled ? "+Thread.currentThread().isInterrupted());
                }

                System.out.println("a dead thread=====================");
            }

//            System.out.println("thread dead is not be cancelled!");

        });

        Thread threadCancel = new Thread(()->{
            System.out.println("try to stop the dead loop");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (threadDeadLoop.isAlive()) {

                threadDeadLoop.interrupt();
//                threadDeadLoop.stop();
            }
            System.out.println("deadThread is interrupted: "+threadDeadLoop.isInterrupted());
            System.out.println("deadThread is alive: "+threadDeadLoop.isAlive());
        });

        threadDeadLoop.start();
        threadCancel.start();
    }

    public void testInterrupt() throws InterruptedException {

    }
}
