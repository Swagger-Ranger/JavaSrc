package com.silinx.source.swaggerranger.JavaCore.TypeCast;

/**
 * @author Email:liufei32@outlook.com  github:Swagger-Ranger
 * @description
 * @since 2020/7/1 23:42
 */

public class A {
    private int a;
    private int b;
    private String c;

    public A() {

    }
    public A( int a, int b, String c ) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int getA() {
        return a;
    }

    public void setA( int a ) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB( int b ) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC( String c ) {
        this.c = c;
    }

    @Override
    public String toString() {
        return "A{" +
                "a=" + a +
                ", b=" + b +
                ", c='" + c + '\'' +
                '}';
    }
}
