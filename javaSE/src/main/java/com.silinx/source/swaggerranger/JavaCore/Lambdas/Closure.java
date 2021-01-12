package com.silinx.source.swaggerranger.JavaCore.Lambdas;

import java.util.concurrent.*;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: Closure
 * @Author: liufei32@outlook.com
 * @Date: 2019/10/24 23:35
 * @Description: 函数的闭包特性
 * @Aha-eureka:
 *      闭包的一个重要特性是其中的自由变量所绑定的是闭包创建时的值，而不是变量的当前值.
 *      在 Java 中有与闭包类似的概念，那就是匿名内部类。在匿名内部类中，可以访问词法域中声明为 final 的变量。不是 final 的变量无法被访问，会出现编译错误。匿名内部类提供了一种方式来共享局部变量。不过并不能对该变量的引用进行修改.
 *λ表达式的本质就是一套匿名内部类的语法糖，而匿名内部类是实现函数式编程的关键，当然函数式编程还不止这些。
 *
 *******************************************************************************/

public class Closure {

    public static void main( String[] args) {
        final CountDownLatch latch = new CountDownLatch(1);

        final Future<?> task1 = ForkJoinPool.commonPool().submit(() -> {
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                latch.countDown();
            }
        });

        final Future<?> task2 = ForkJoinPool.commonPool().submit(() -> {
            final long start = System.currentTimeMillis();
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("Done after " + (System.currentTimeMillis()
                        - start) + "ms");
            }
        });

        try {
            task1.get();
            task2.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
