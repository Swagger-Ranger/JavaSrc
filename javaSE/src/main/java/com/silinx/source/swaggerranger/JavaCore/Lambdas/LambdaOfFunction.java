package com.silinx.source.swaggerranger.JavaCore.Lambdas;

import java.util.function.Function;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: LambdaOfConsumer
 * @Author: liufei32@outlook.com
 * @Date: 2019/3/7 14:52
 * @Description: Function 接口使用案例
 * @Aha-eureka:
 *******************************************************************************/

public class LambdaOfFunction {


    public static void functionTest() {
        Function<Integer, Integer> f = s -> s = s + 1;//这里不要使用S++，++s 才能将s改变
        Function<Integer, Integer> g = s -> s * 2;

        /**
         * 下面表示在执行F时，先执行G，并且执行F时使用G的输出当作输入。
         * 相当于以下代码：
         * Integer a = g.apply(1);
         * System.out.println(f.apply(a));3
         */
        System.out.println(f.apply(1));
        System.out.println("Compose " + f.compose(g).apply(1));

        /**
         * 表示执行F的Apply后使用其返回的值当作输入再执行G的Apply；
         * 相当于以下代码
         * Integer a = f.apply(1);
         * System.out.println(g.apply(a));4
         */
        System.out.println("andThen " + f.andThen(g).apply(1));

        /**
         * identity方法会返回一个不进行任何处理的Function，即输出与输入值相等；
         */
        System.out.println("identify " + Function.identity().apply("a"));
    }

    public static void main( String[] args ) {
//        functionTest();
        System.out.println(2 % 1);
    }
}
