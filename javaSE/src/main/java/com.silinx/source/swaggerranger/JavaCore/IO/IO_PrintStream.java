package com.silinx.source.swaggerranger.JavaCore.IO;

import java.io.IOException;
import java.io.PrintStream;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: IO_PrintStream
 * @Author: liufei32@outlook.com
 * @Date: 2019/3/30 16:37
 * @Description: 打印流
 * @Aha-eureka:
 *******************************************************************************/

public class IO_PrintStream {

    public static void main( String[] args ) {
        System.out.println("打印流的位置，从控制台输出改为输出到PrintStream");
        changeOut();
    }

    private static void changeOut() {
        try (
                PrintStream ps = new PrintStream("./src/JavaCore/IO/PS.txt")
        ) {
            //将打印目的地修改到PrintStream
            System.setOut(ps);
            System.out.println("打印到PrintStream-----");
        } catch (IOException E) {
            System.out.println(E);
        }
    }
}
