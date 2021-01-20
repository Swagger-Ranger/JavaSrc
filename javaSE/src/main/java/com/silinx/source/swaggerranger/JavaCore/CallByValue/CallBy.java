package com.silinx.source.swaggerranger.JavaCore.CallByValue;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: CallBy
 * @Author: liufei32@outlook.com
 * @Date: 2019/4/16 22:50
 * @Description: 值传递和引用传递
 * @Aha-eureka:
 *******************************************************************************/

public class CallBy {

    static int x = 10;

    static void updateValue(int v) {
        v = 3 * v;
    }

    public static void main( String[] args ) {

//        int value = 5;
        int value = x;
        System.out.println("pre: " + x);
        updateValue(value);
        System.out.println("after: " + x);

    }
}
