package com.silinx.source.swaggerranger.JavaCore;

import java.util.Scanner;

public class Scanner_Learn {

    public static String _next(){
        String str="";
        Scanner scan =new Scanner(System.in);
        System.out.println("next 接收方式：");
        // 判断是否还有输入
        if (scan.hasNext()) {
            str = scan.next();
            System.out.println("输入的数据为：" + str);
        }
        scan.close();
        return str;
    }

    public static String _nextLine(){
        String str = "";
        Scanner scan = new Scanner(System.in);

        System.out.println("nextLine方式接收：");
        // 判断是否还有输入
        if (scan.hasNextLine()) {
            str = scan.nextLine();
            System.out.println("输入的数据为：" + str);
        }
        scan.close();

        return str;
    }



    public static void main( String[] args) {

        _nextLine();
    }
}
