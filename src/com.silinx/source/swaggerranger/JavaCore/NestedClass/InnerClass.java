package com.silinx.source.swaggerranger.JavaCore.NestedClass;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: InnerClass
 * @Author: liufei32@outlook.com
 * @Date: 2019/3/8 22:41
 * @Description: 内部类测试
 * @Aha-eureka:
 *******************************************************************************/

public class InnerClass {

    private Inner inner;
    private class Inner{

        void asdf(){
            System.out.println("inner...");
        }
    }

    void invoke() {
        inner.asdf();
    }
    public static void main( String[] args ) {
        InnerClass innerClass = new InnerClass();
    }
}
