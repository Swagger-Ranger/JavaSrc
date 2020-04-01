package com.silinx.source.swaggerranger.JavaCore.Lambdas.Stream;

import java.util.ArrayList;
import java.util.List;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: LoopOfCollection
 * @Author: liufei32@outlook.com
 * @Date: 2019/10/21 13:59
 * @Description:
 * @Aha-eureka:
 *******************************************************************************/

public class LoopOfCollection {

    private static List items;
    static {
        items = new ArrayList();
        items.add("A");
        items.add("B");
        items.add("C");
        items.add("D");
    }


    public static void main( String[] args ) {
        items.forEach(i -> System.out.println(i));
        items.forEach(System.out::println);

    }
}
