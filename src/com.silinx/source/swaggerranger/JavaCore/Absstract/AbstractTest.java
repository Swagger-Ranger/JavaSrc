package com.silinx.source.swaggerranger.JavaCore.Absstract;

/**
 * @author Email:liufei32@outlook.com  github:Swagger-Ranger
 * @description
 * @since 2020/6/29 11:01
 */

public class AbstractTest {

    public static void main( String[] args ) {
        TestChild testChild = new TestChild();
    }

    private static abstract class Test {
        Test() {
            System.out.println("abstract class constructor");
        }

        abstract void testMethod();
    }

    private static class TestChild extends Test {

        TestChild() {
            System.out.println("child constructor");
        }

        @Override
        void testMethod() {
            System.out.println("child method");

        }
    }

}
