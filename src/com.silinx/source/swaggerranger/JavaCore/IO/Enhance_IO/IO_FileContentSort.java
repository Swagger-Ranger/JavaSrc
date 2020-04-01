package com.silinx.source.swaggerranger.JavaCore.IO.Enhance_IO;

import java.io.*;
import java.util.HashMap;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: IO_FileContentSort
 * @Author: liufei32@outlook.com
 * @Date: 2019/3/30 0:25
 * @Description: 文件内容排序
 * @Aha-eureka:
 *******************************************************************************/

public class IO_FileContentSort {

    /**
     * 这里其实就是一个字符输出流和一个字符输入流，而排序则使用了HashMap，HashMap中key是有序的，会自动排序的功能
     */
    static void fileSort() {
        try (
                BufferedWriter bw = new BufferedWriter(new FileWriter("./src/JavaCore/IO/FileSort.txt"));
                BufferedReader br = new BufferedReader(new FileReader("./src/JavaCOre/IO/FIS.txt"))
        ) {
            HashMap<String, String> content = new HashMap<>();
            String line;
            while ((line = br.readLine()) != null) {
                //这里传入一个正则表达式来分割字符串，"\\."就是转义字符\.的，.是个特殊字符需要转义，而转义字符也是个特殊字符所以需要两个转义字符\\,
                String[] cont = line.split("\\.", 2);
                content.put(cont[0], cont[1]);
            }

            for (String key : content.keySet()) {
                String value = content.get(key);
                line = key + "." + value;
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void main( String[] args ) {
        fileSort();
    }
}
