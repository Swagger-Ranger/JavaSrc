package com.silinx.source.swaggerranger.JavaCore.MultiThread.advanced;

import java.util.concurrent.*;

/**
 * @author Email:liufei32@outlook.com  github:Swagger-Ranger
 * @description future任务中抛出异常,future get()时如果任务抛出异常，都会被封装到ExecutionException异常中，使用getCause()可以获取原始异常
 * @since 2020/4/1 18:17
 */

public class FutureWithException {

    private static final ExecutorService excutor = Executors.newCachedThreadPool();

    String getOracle( Callable<String> oracle ) {

        Future<String> submit = excutor.submit(oracle);
        String result = null;
        try {
            result = submit.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();

//            e.getCause().printStackTrace();
        }
        return result;
    }

    String getRunnableFuture(Runnable task,String result) {
        Future<String> submit = excutor.submit(task, result);
        String out = null;
        try {
            out = submit.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return out;
    }


    public static void main( String[] args ) {
        FutureWithException fwe = new FutureWithException();
        fwe.getOracle(() -> {

            String str = "ress";
            System.out.println(str);
            throw new RuntimeException("任务中抛出异常");
//            return str;
        });
        System.out.println("-----------------");

        String runnableFuture = fwe.getRunnableFuture(() -> System.out.println("runnable future"), "success");
        System.out.println(runnableFuture);
        excutor.shutdown();//记得关闭线程池，不然主线程不会退出
    }

}
