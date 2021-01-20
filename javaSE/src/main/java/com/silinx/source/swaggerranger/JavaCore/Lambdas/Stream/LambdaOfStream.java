package com.silinx.source.swaggerranger.JavaCore.Lambdas.Stream;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: LambdaOfStream
 * @Author: liufei32@outlook.com
 * @Date: 2019/3/6 15:59
 * @Description: lambda表达式的stream流操作
 * @Aha-eureka:
 *******************************************************************************/

public class LambdaOfStream {

    public static void main( String[] args ) {

        //普通写法
        List<String> collected = new ArrayList<>();

        for (String s : Arrays.asList("a", "b", "c")) {
            String upper = s.toUpperCase();
            collected.add(upper);
        }

        assert Arrays.asList("A", "B", "C").equals( collected):"断言不通过";

        /**
         * lambda写法
         * Stream.of构造一个流，流的类型编译器会自动判断
         * map(s->s.toUpperCase())，map类型转换，将一个类型的流转换称另一类型，map只接受一个指定类型的参数这里是String
         * s->s.toUpperCase()，参数以及要做的操作，参数会返回可以不是同意类型，但必须是Function接口的一个实例
         * collect(Collectors.toList()：由Stream里的值生成一个列表，Collectors是Collection的一个全静态方法类
         *      Function 就是一个函数，其作用类似于数学中函数的定义 ，（x,y）即y=f(x)跟<T,R>的作用几乎一致。
         */
        Collection<String> collection = Stream.of("a", "b", "c").map(s->s.toUpperCase()).collect(Collectors.toList());

        assert Arrays.asList("A", "B", "C").equals( collection):"断言不通过";

        Collection<String> collections = Stream.of("0abc", "abc", "bcc").filter(value-> Character.isDigit(value.charAt(0))).collect(Collectors.toList());

        assert Arrays.asList("0abc").equals(collections) : "两者不相等...";
    }
}
