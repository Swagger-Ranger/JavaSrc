package com.silinx.source.swaggerranger.JavaCore.MultiThread.advanced;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: ThreadWithReturn
 * @Author: liufei32@outlook.com
 * @Date: 2019/3/4 15:19
 * @Description: 带返回值的线程，关键就是实现Callable接口，接口和Runnable接口类似只有一个带泛型返回值的方法call
 *              线程执行还需要一个中间对象来接收结果即FutureTask
 * @Aha-eureka:
 *******************************************************************************/

public class ThreadWithReturn implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("Calling ...");
        return 1;
    }

    public static void main( String[] args ) throws ExecutionException, InterruptedException {
        ThreadWithReturn threadWithReturn = new ThreadWithReturn();
        FutureTask<Integer> task = new FutureTask<>(threadWithReturn);
        Thread thread = new Thread(task);
        thread.start();
        int result = task.get();
        System.out.println("the task's result is :" + result);
    }
}
