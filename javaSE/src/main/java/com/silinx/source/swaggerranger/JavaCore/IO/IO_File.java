package com.silinx.source.swaggerranger.JavaCore.IO;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: IO_File
 * @Author: liufei32@outlook.com
 * @Date: 2019/3/26 0:33
 * @Description: File的示例
 * @Aha-eureka:
 *******************************************************************************/

public class IO_File {

    public void printPath( String path ) {
        File file = new File(path);
        System.out.println(file.isFile());

        System.out.println();

    }

    public static void main( String[] args ) throws IOException {
//        IO_File io_file = new IO_File();
//        io_file.printPath("D:\\Swagger-Ranger\\git-workspace\\Algorithms\\README.md");

        File file = new File("./src/JavaCore/aaaa.txt");
        System.out.println(file.getAbsolutePath());
        file.createNewFile();
        System.out.println(Arrays.toString(file.list()));
        System.out.println(Arrays.toString(file.listFiles()));
    }
}
