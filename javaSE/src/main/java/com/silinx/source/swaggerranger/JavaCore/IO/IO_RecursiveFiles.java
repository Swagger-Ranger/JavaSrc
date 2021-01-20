package com.silinx.source.swaggerranger.JavaCore.IO;

import java.io.File;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: IO_RecursiveFiles
 * @Author: liufei32@outlook.com
 * @Date: 2019/3/26 12:29
 * @Description: 递归遍历文件
 * @Aha-eureka:
 *******************************************************************************/

public class IO_RecursiveFiles {


    /**
     * 遍历文件夹
     * @param dir
     */
    public void getFiles( File dir ) {
        File[] files = dir.listFiles();
        System.out.println("current dir: " + dir);

        for (File f : files) {
            if (f.isDirectory()) getFiles(f);
            System.out.println(f);
        }
    }

    /**
     * 使用lambda表达式来使用FilenameFilter接口来过滤文件名
     * @param dir
     */
    public void getFilesWithFilenameFilter( File dir) {
        //注意这里的name不是外面传入的，而是作为参数来接收file的文件名的
//        File[] files = dir.listFiles(( File d, String name ) -> {
//            return new File(d, name).isDirectory() || name.toLowerCase().endsWith(".java");
//        });

        File[] files = dir.listFiles(file -> file.isDirectory() || file.getName().toLowerCase().endsWith(".java"));

        for (File f : files) {
            if (f.isDirectory()) getFilesWithFilenameFilter(f);
            System.out.println(f);
        }
    }



    /**
     * 搜索指定文件
     * @param dir
     * @param fileName
     */
    public void getFile( File dir, String fileName ) {
        File[] files = dir.listFiles();

        for (File f : files) {
            if (f.isDirectory()) getFile(f, fileName);
            if(f.getName().equals(fileName)) System.out.println(f);
        }
    }

    public static void main( String[] args ) {
        IO_RecursiveFiles io_recursiveFiles = new IO_RecursiveFiles();
//        io_recursiveFiles.getFiles(new File("./src"));
//        io_recursiveFiles.getFile(new File("./src"), "CountTask.java");

        io_recursiveFiles.getFilesWithFilenameFilter(new File("./src"));

    }
}
