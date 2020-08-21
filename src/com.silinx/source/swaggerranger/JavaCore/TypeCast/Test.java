package com.silinx.source.swaggerranger.JavaCore.TypeCast;

/**
 * @author Email:liufei32@outlook.com  github:Swagger-Ranger
 * @description
 * @since 2020/7/1 23:43
 */

public class Test {

    public static void main( String[] args ) {
        A a = new A(1, 2, "test");
        B b = new B(11, 21, "testb");

        Object d = b;
        A c = (A) d;
        System.out.println(c);
    }
}
