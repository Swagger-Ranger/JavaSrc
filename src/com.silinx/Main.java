package com.silinx;

import java.util.HashMap;

/**
 * @author Email:liufei32@outlook.com  github:Swagger-Ranger
 * @description
 * @since 2020/4/1 10:24
 */

public class Main {
    public static void main( String[] args ) {

        HashMap<String, Double> map = new HashMap<>();
        map.put("h1", 0.1);
        map.put("h2", 0.2);
        map.put("h3", 0.3);

        Thread thread = new Thread(() -> {
            String str = "sss";
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(str);
        });

        Thread thread1 = new Thread(() -> {
            String str = "sss1";
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(str);
        });

        thread.start();
        thread1.start();
    }
}
