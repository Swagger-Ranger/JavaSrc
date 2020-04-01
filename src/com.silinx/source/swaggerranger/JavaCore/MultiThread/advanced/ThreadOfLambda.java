package com.silinx.source.swaggerranger.JavaCore.MultiThread.advanced;

import java.util.Arrays;
import java.util.List;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: ThreadOfLambda
 * @Author: liufei32@outlook.com
 * @Date: 2019/3/4 16:56
 * @Description: 使用Lambda表达式创建线程
 * @Aha-eureka:
 *******************************************************************************/

public class ThreadOfLambda {


    public int addWithLambdaStream( List<Integer> values ) {
        //Collection集合中的并行流 parallelStream()，注意parallelStream是没有顺序的，stream会按原有顺序打印，
        // parallelStream要有顺序使用流的forEachOrdered排序遍历方法
//        values.parallelStream().forEachOrdered(System.out::println);
        values.stream().forEach(System.out::println);
        values.parallelStream().forEach(System.out::println);

        //这里就是lambda表达式的求和，注意这里是多线程并行进行的
        //mapToInt就是将流的内容转换成int类型，当然还有mapTo*其他类型，
        //i -> i，第一个i就是向foreach中的变量名，只是这里不需要指定类型，lambda自动判别，第二个i就是对变量的操作，这里就是不做操作，当然也可以做i*2等等操作
        //然后sum就是int流IntStream的对流的求和方法
        return values.parallelStream().mapToInt(i -> i).sum();
    }

    public static void main( String[] args ) {
        List<Integer> values = Arrays.asList(10, 20, 30, 40);
        int result = new ThreadOfLambda().addWithLambdaStream(values);
        System.out.println("the result is :" + result);
    }
}
