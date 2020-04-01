package com.silinx.source.lambdasinaction.chap9;

/**
 * Created by raoul-gabrielurma on 15/01/2014.
 */
public interface Drawable{
    public void draw();

    default void test() {
        System.out.println("this is a test!");
    }

    static void test1() {
        System.out.println("this is the static method of interface!");
    }
}

class DTest implements Drawable {

    @Override
    public void draw() {

    }

    @Override
    public void test() {

        System.out.println("this is implements!");

    }

    public static void main(String[] args) {
        DTest dTest = new DTest();
        dTest.test();
        Drawable.test1();
    }
}
