package com.silinx.source.swaggerranger.JavaCore.IO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: IO_FileWriter
 * @Author: liufei32@outlook.com
 * @Date: 2019/3/28 12:21
 * @Description:
 * @Aha-eureka:
 *******************************************************************************/

public class IO_FileWriter {

    public static void main( String[] args ) throws IOException {
        try (
                //创建输入流对象
                FileReader fr = new FileReader("./src/JavaCore/IO/FIS.txt");
                //创建输出流对象
                FileWriter fw = new FileWriter("./src/JavaCore/IO/FOS.txt", true)
        ) {
            //读取输入流并输出到输出流
            char[] cs = new char[1024];
            int len;
            while ((len = fr.read(cs)) != -1) {

                fw.write(new String(cs, 0, len));
                //这里要刷新流，不然字符输出流不会写入文件，而是留在内存缓冲区中
                fw.flush();
            }
        } catch (IOException e) {
            System.out.println(e);
        }

        //创建输入流对象
        FileReader fr = new FileReader("./src/JavaCore/IO/FIS.txt");
        //创建输出流对象
        FileWriter fw = new FileWriter("./src/JavaCore/IO/FOS.txt", true);

       /* try (fr;fw) {
            //读取输入流并输出到输出流
            char[] cs = new char[1024];
            int len;
            while ((len = fr.read(cs)) != -1) {

                fw.write(new String(cs, 0, len));
                //这里要刷新流，不然字符输出流不会写入文件，而是留在内存缓冲区中
                fw.flush();
            }
        } catch (IOException e) {
            System.out.println(e);
        }*/

    }
}
