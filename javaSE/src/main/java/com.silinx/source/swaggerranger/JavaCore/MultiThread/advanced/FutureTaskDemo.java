package com.silinx.source.swaggerranger.JavaCore.MultiThread.advanced;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author Email:liufei32@outlook.com  github:Swagger-Ranger
 * @description 在futureTask中如果没有线程去执行，而调用get()就会一直阻塞等待有线程去执行他
 * @since 2020/4/2 0:20
 */

public class FutureTaskDemo {

    private final FutureTask<String> futureTask = new FutureTask<>(() -> getOracle());


    private String getOracle() {
        String str = "to have light";
        return str;
    }

    private void start() {
        new Thread(futureTask).start();
    }
    public static void main( String[] args ) throws ExecutionException, InterruptedException {
        FutureTaskDemo demo = new FutureTaskDemo();
        new Thread(() -> {
            try {
                System.out.println(demo.futureTask.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }).start();

        demo.start();
    }
}
