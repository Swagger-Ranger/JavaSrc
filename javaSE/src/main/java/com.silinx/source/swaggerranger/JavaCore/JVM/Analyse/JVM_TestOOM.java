package com.silinx.source.swaggerranger.JavaCore.JVM.Analyse;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: JVM_TestOOM
 * @Author: liufei32@outlook.com
 * @Date: 2019/4/10 16:09
 * @Description: 测试内存溢出  设置VM options:-Xms8m -Xmx8m -XX:+HeapDumpOnOutOfMemoryError
 * @Aha-eureka:
 *******************************************************************************/

public class JVM_TestOOM {

    public static void main( String[] args ) {
        List<Object> list = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            String str = "";
            for (int j = 0; j < 1000; j++) {
                str += UUID.randomUUID().toString();
            }
            list.add(str);
        }
        System.out.println("NOT OOM");
    }
}
