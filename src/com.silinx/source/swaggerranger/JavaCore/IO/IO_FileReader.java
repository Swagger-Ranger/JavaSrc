package com.silinx.source.swaggerranger.JavaCore.IO;

import java.io.FileReader;
import java.io.IOException;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: IO_FileReader
 * @Author: liufei32@outlook.com
 * @Date: 2019/3/28 11:00
 * @Description: FileReader
 * @Aha-eureka:
 *******************************************************************************/

public class IO_FileReader {

    public static void main( String[] args ) throws IOException {

        FileReader fr = new FileReader("./src/JavaCore/IO/FOS.txt");

        /**
         * 读取单个字符
         */
//        int len;
//        while ((len = fr.read()) != -1) {
//            System.out.print((char) len);
//        }

        /**
         * 读取多个字符
         */
        char[] cs = new char[1024];
        int len;
        while ((len = fr.read(cs)) != -1) {

            System.out.println(new String(cs,0,len ));
        }

        fr.close();
    }
}
