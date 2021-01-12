package com.silinx.source.swaggerranger.JavaCore.IO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: IO_FileOutputStream
 * @Author: liufei32@outlook.com
 * @Date: 2019/3/26 16:58
 * @Description: OutputStream示例
 * @Aha-eureka:
 *******************************************************************************/

public class IO_FileOutputStream {

    FileOutputStream FOS = null;

    /**
     * FOS使用：
     *     1.创建FOS，并传入String path 输出路径，如果路径不存在，文件无法打开等就会抛出FIleNotFoundException
     *     2.FOS.write() 写入数据
     *     3.关闭资源
     * @param path
     * @throws IOException
     */
    void fos( String path ) throws IOException {
        FOS = new FileOutputStream(path);
        //输出结果97--a，因为是以字节输出的
        FOS.write(97);

        /**
         * FOS输入都是字节byte型(-128~127之间），当第一个是负数时则会和后面一个数一起组成一个中文编码默认GBK,GBK-2字节-1中文；UTF-3-1中文
         */
        byte[] bytes = new byte[]{96, 97, 111, 123, 100,126};
        FOS.write(bytes);
        FOS.write(10);//10就是换行符

        /**
         *  换行win：\r\n
         *  linux：/n
         *  ma：/r
        */

        FOS.write("\r\n".getBytes());

        /**
         * 从byte数字的第off位开始读入长度len的byte数据写入
         *
         */
        FOS.write(bytes, 1, 2);
        FOS.write(10);//10就是换行符

        /**
         * 如果是字符串，可以使用String的 byte[] getBytes()方法来转换成byte数组
         */
        byte[] bytes1 = "Hello".getBytes();
        System.out.println(Arrays.toString(bytes1));
        FOS.write(bytes1);


        /**
         * InputStream is = new FileInputStream("a.txt");
         *
         * FileOutputStream fos = new FileOutputStream("b.txt");
         *
         * byte[] b = new byte[1024];
         *
         * int length;
         *
         * while(length= is.read(b)>)0){
         *
         * fos.write(b,0,length);
         *
         * }
         *
         * is.close();
         *
         * fos.close();
         */


        FOS.close();
    }

    public static void main( String[] args ) throws IOException {
        IO_FileOutputStream fos = new IO_FileOutputStream();
//        fos.fos("./src/JavaCore/IO/FOS.txt");
        fos.fos("D:\\liufei5");
    }
}
