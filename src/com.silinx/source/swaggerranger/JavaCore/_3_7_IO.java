package com.silinx.source.swaggerranger.JavaCore;

import java.util.Scanner;

public class _3_7_IO {
    /**
     * 从控制台接受输入
     */
    public static void InputTest(){
        Scanner in = new Scanner(System.in);
        System.out.print("What is your name? ");
        String name = in.nextLine();
        //按行读取in.nextLine，按空格读取in.next;读取整数in.nextInt;
        System.out.print(" how old are you?");
        int age = in.nextInt();

        System.out.println("Hello, "+ name +". Next year ,you will be "+(age + 1));

    }



    public static void main( String[] args) {

        InputTest();
    }
}
