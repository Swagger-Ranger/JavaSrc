package com.silinx.source.swaggerranger.JavaCore.MultiThread.advanced;

/**
 * @author Email:liufei32@outlook.com  github:Swagger-Ranger
 * @description
 * @since 2020/3/19 20:35
 */

public class ArrayTest {

    public static void main( String[] args ) {
        String[] a = {"1", "2"};
        System.out.println(a);

        a[1] = "3";
        System.out.println(a);
    }
}
