package com.silinx.source.swaggerranger.JavaCore.MultiThread.introduction;

/**
 * @author Email:liufei32@outlook.com  github:Swagger-Ranger
 * @description
 * @since 2020/3/11 19:36
 */

public class ThreadExcep {
    public static void throwExecption() {
        throw new RuntimeException("线程出现异常-----");
    }

    public static void waiting() throws InterruptedException {
        Thread.sleep(10000);
    }

}
