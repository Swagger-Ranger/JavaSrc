package com.silinx.source.swaggerranger.JavaCore.IO.Enhance_IO;

import java.io.*;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: IO_Transfer
 * @Author: liufei32@outlook.com
 * @Date: 2019/3/30 11:13
 * @Description: IO转换流
 * @Aha-eureka:
 *******************************************************************************/

public class IO_Transfer {

    public static void main( String[] args ) {
//        outputStreamWriter();
//        inputStreamReader();
        change_charset();
    }

    private static void change_charset() {
        try (
                InputStreamReader isr = new InputStreamReader(new FileInputStream("./src/JavaCore/IO/OSW.txt"), "utf-8");
                OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("./src/JavaCore/IO/OSW_gbk.txt"), "gbk")
        ) {
            int len;
            while ((len = isr.read()) != -1) {
                osw.write(len);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private static void inputStreamReader() {

        try (
//                InputStreamReader isr = new InputStreamReader(new FileInputStream("./src/JavaCore/IO/OSW.txt"), "gbk");
                InputStreamReader isr = new InputStreamReader(new FileInputStream("./src/JavaCore/IO/OSW.txt"), "utf-8");
        ) {
            int len;
            while ((len = isr.read()) != -1) {
                System.out.println((char)len);
            }
        } catch (IOException e) {
            System.out.println(e);
        }

    }

    private static void outputStreamWriter() {
        try (
//                OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("./src/JavaCore/IO/OSW.txt"), "UTF-8")
                OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("./src/JavaCore/IO/OSW.txt",true), "gbk")
        ) {
            osw.write("我是Swagger-Ranger!");
            osw.flush();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
