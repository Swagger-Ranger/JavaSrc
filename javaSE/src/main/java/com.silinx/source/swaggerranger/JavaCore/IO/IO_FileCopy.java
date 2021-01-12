package com.silinx.source.swaggerranger.JavaCore.IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: IO_FileCopy
 * @Author: liufei32@outlook.com
 * @Date: 2019/3/27 23:19
 * @Description: 文件拷贝
 * @Aha-eureka:
 *******************************************************************************/

public class IO_FileCopy {

    private FileInputStream FIS = null;
    private FileOutputStream FOS = null;

    void file_copy( File from, File to ) throws IOException {
        FIS = new FileInputStream(from);
        FOS = new FileOutputStream(to);

        byte[] bytes = new byte[1024];
        while ((FIS.read(bytes)) != -1) {
            FOS.write(bytes);
        }

        //先关闭写入流，一般谁后进来就谁先关闭
        FOS.close();
        FIS.close();
    }

    public static void main( String[] args ) throws IOException {
        File fileFrom = new File("./src/JavaCore/Lambdas/TestMain.java");
        File fileTo = new File("./src/JavaCore/IO/Test");

        IO_FileCopy copy = new IO_FileCopy();
        copy.file_copy(fileFrom, fileTo);
    }
}
