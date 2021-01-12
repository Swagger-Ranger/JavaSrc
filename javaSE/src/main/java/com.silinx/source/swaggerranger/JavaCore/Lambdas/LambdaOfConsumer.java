package com.silinx.source.swaggerranger.JavaCore.Lambdas;

import java.util.ArrayList;
import java.util.function.Consumer;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger
 * @FileName: LambdaOfConsumer
 * @Author: liufei32@outlook.com
 * @Date: 2019/3/7 14:52
 * @Description: Consumer接口使用案例
 * @Aha-eureka:
 *******************************************************************************/

public class LambdaOfConsumer {


    public static void consumerTest() {
        Consumer f = System.out::println;
        Consumer f2 = n -> System.out.println(n + "-F2");

        //执行完F后再执行F2的Accept方法
        f.andThen(f2).accept("test");

        //连续执行F的Accept方法
        f.andThen(f).andThen(f).andThen(f).accept("test1");
        ArrayList a = new ArrayList();
    }

    public static void main( String[] args ) {
        consumerTest();
    }
}
