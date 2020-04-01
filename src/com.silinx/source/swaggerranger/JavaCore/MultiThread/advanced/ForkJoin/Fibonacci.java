package com.silinx.source.swaggerranger.JavaCore.MultiThread.advanced.ForkJoin;

import java.util.concurrent.*;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: Fibonacci
 * @Author: liufei32@outlook.com
 * @Date: 2019/3/13 12:34
 * @Description: Fibonacci的分治实现
 * @Aha-eureka:  一般斐波那契都是使用递归来写，其实这里使用分治效果会更好，因为可以使用多线程同时运算
 *******************************************************************************/

public class Fibonacci extends RecursiveTask<Long> {

    final int n;

    Fibonacci( int n ) {
        this.n = n;
    }

    @Override
    protected Long compute() {

        if (n <= 1) {
            return 1L;
        } else {
            Fibonacci f1 = new Fibonacci(n - 1);
            Fibonacci f2 = new Fibonacci(n - 2);
            f1.fork();//进行分治运算
            return f2.compute() + f1.join();//join拿到结果

            /** 也可以这么写，但很明显上面的写法更加简洁
            Fibonacci f1 = new Fibonacci(n - 1);
            Fibonacci f2 = new Fibonacci(n - 2);

            f1.fork();
            f2.fork();

            return f1.join() + f2.join();

             */
        }
    }

    public static void main( String[] args ) {

        Fibonacci fibonacci = new Fibonacci(5);

        ForkJoinPool forkJoinPool = new ForkJoinPool();

        Future<Long> future = forkJoinPool.submit(fibonacci);

        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

}
