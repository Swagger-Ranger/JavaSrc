package com.silinx.source.swaggerranger.JavaCore.IO;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.function.Consumer;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: IO_FileInputStream
 * @Author: liufei32@outlook.com
 * @Date: 2019/3/27 10:11
 * @Description: 文件输入流
 * @Aha-eureka:
 *******************************************************************************/

public class IO_FileInputStream {

    FileInputStream FIS = null;

    /**
     * FIS使用：read()
     * 1.新建FIS对象
     * 2.read
     * 3.close
     * @param path
     * @throws IOException
     */
    void fis( String path ) throws IOException {
        FIS = new FileInputStream(path);

        int len;
        while ((len = FIS.read()) != -1) {
            System.out.print((char)len);
        }

        FIS.close();
        System.out.println();
        System.out.println("-------------------------");
        /**
         * 注意循环不能写成下面这样，因为在read时每读取一个指针就会自动往后移，这样读就会跳过很多数据，导致读取不完全
         */
        FileInputStream fis = new FileInputStream("./src/JavaCore/IO/FIS.txt");
        while (fis.read() != -1) {
            System.out.print((char)fis.read());
        }
        fis.close();
    }

    /**
     * 使用byte[]来缓存读取到的字节，int read(byte[])返回的就是读取到的有效字节长度
     * @param path
     * @throws IOException
     */
    void fis_arrayBuff( String path ) throws IOException {
        FIS = new FileInputStream(path);
        byte[] bytes = new byte[1024];
        int len;
        while ((len = FIS.read(bytes)) != -1) {
            //String的构造方法中可以传入一个byte来生成，这里指定了开始位和长度，不然后面会有许多空格，因为1024长度的byte，
            //len长度之后的都是0
            System.out.println(new String(bytes, 0, len));
        }
    }

    public static void main( String[] args ) throws IOException {
        IO_FileInputStream iofis = new IO_FileInputStream();
        iofis.fis_arrayBuff("./src/JavaCore/IO/FIS.txt");

        Integer test = 1;

    }

    static void Test( Consumer comsumer ) {

        comsumer.accept(comsumer);

    }
}
