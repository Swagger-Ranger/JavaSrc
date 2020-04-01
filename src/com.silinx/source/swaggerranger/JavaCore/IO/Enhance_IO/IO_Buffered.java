package com.silinx.source.swaggerranger.JavaCore.IO.Enhance_IO;

import java.io.*;
import java.util.Arrays;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: IO_Buffered
 * @Author: liufei32@outlook.com
 * @Date: 2019/3/29 11:49
 * @Description: 缓冲流
 * @Aha-eureka:
 *******************************************************************************/

public class IO_Buffered {

    /**
     * bufferedOutputStream的使用步骤
     * 1.创建bufferedOutputStream对象，并在构造方法中传入OutputStream
     * 2.使用bufferedOutputStream的write()方法将数据写入缓冲区
     * 3.flush()将缓冲区的数据刷入文件
     * 4.关闭流
     */
    static void bufferedOutputStream() {
        //这里使用的JDK7的新特性，在try中new 流对象，使用完后自动关闭
        try (
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("./src/JavaCore/IO/BOS.txt"), 1024)
        ) {
            bos.write("这是一个昂扬的时代，同时充满了悲伤的故事".getBytes());
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    /**
     * bufferedInputStream的使用步骤
     * 1.创建bufferedInputStream对象，并在构造方法中传入InputStream
     * 2.使用bufferedInputStream对象的read()方法读取数据
     * 3.释放资源
     */
    static void bufferedInputStream() {

        try (
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream("./src/JavaCore/IO/BOS.txt"), 1024)
        ) {
            int len;
            byte[] bytes = new byte[1024];
            while ((len = bis.read(bytes)) != -1) {
                System.out.println(new String(bytes, 0, len));
            }
        } catch (IOException E) {
            System.out.println(E);
        }
    }




    public static void main( String[] args ) {
//        bufferedOutputStream();
        bufferedInputStream();
    }
}
