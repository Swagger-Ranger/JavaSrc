package com.silinx.source.swaggerranger.JavaCore.NestedClass;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: LocalclassWithFinal
 * @Author: liufei32@outlook.com
 * @Date: 2019/3/5 21:55
 * @Description: 局部内部类和局部匿名类只能访问final的局部变量
 * @Aha-eureka:
 *******************************************************************************/

public class LocalclassWithFinal {

    public static void main( String[] args ) {
        OutClass os = new OutClass();

    }
}


class OutClass {
    private int age = 12;

    public void outPrint(int x) {
        class InClass {
            public void InPrint() {
                System.out.println(x);
                System.out.println(age);
            }
        }
        new InClass().InPrint();
    }
}