package com.silinx;

import java.util.LinkedHashSet;

/**
 * @author Email:liufei32@outlook.com  github:Swagger-Ranger
 * @description
 * @since 2020/4/1 10:24
 */

public class Main {
    public static void main( String[] args ) {

//        Thread thread = new Thread(() -> {
//            String str = "sss";
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(str);
//        });
//
//        Thread thread1 = new Thread(() -> {
//            String str = "sss1";
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//            System.out.println(str);
//        });
//
//        thread.start();
//        thread1.start();
//        int a = 5;
//        int b = a++;
//        int c = ++a;

//        System.out.println(a);
//        System.out.println(b);
//        System.out.println(c);

//        Number num = new Integer(1);
//        ArrayList<Number> list = new ArrayList<Integer>(); //type mismatch
//
//        List<? extends Number> list1 = new ArrayList<Number>();
//        list1.add(new Integer(1)); //error
//        list1.add(new Float(1.2f));  //error

//        Integer a = 1;
//        Integer b = 2;
//        Integer c = 3;
//        Integer d = 3;
//        Integer e = 321;
//        Integer f = 321;
//        Long g = 3L;
//        System.out.println("c == d " + (c == d));
//        System.out.println("e == f " + (e == f));
//        System.out.println(c == (a + b));
//        System.out.println("c.equals(a + b) " + c.equals(a + b));
//        System.out.println(g == (a + b));
//        System.out.println(g.equals(a + b));
//
//        Integer a1 = new Integer(1);
//        Integer ab = new Integer(1);
//        ab = 2;
//
//        System.out.println(a1 == ab);
//    }
//
//    <T>void test(T s) {
//        List<T>[] lists = null;


        LinkedHashSet linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(null);
        linkedHashSet.add(null);
        System.out.println(linkedHashSet.size());





    }
}
