package com.silinx.source.algs4.Chapter1.chapter1_2;

public class Test {

    /**
     *使用递归的方式颠换字符串顺序
     * @param s
     * @return String
     */
    public static String mystery( String s){
        int N = s.length();
        if ( N <= 1) return s;
        String a = s.substring(0,N/2);
        String b = s.substring(N/2,N);

        return mystery(b) +mystery(a);
    }



    public static void main( String[] args) {
//        String string1 = "Hello";
//        String string2 = string1;
//        string1 = "world";
//        System.out.println(string1);
//        System.out.println(string2);
        System.out.println( mystery("SwaggerRanger"));
    }

}
