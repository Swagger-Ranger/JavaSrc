package com.silinx.source.swaggerranger.JavaCore.IO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: IO_Properties
 * @Author: liufei32@outlook.com
 * @Date: 2019/3/29 0:40
 * @Description: IO的持久化
 * @Aha-eureka:
 *******************************************************************************/

public class IO_Properties {

    static void properties_store() throws IOException {


        //创建properties对象和输出流对象
        Properties prop = new Properties();

        prop.setProperty("swagger", "ranger");
        prop.setProperty("swagger1", "ranger1");
        prop.setProperty("swagger2", "ranger2");
        prop.setProperty("swagger3", "ranger3");

        //这里直接在方法内new 输出流对象，就不用关闭流，因为方法执行完后会自动释放资源
        prop.store(new FileWriter("./src/JavaCore/IO/FOSPROP.txt"), " new data");
        /*try (
             FileWriter fw = new FileWriter("./src/JavaCore/IO/FOSPROP.txt")
        ) {
            //在Properties中存储键值对，键和值都是字符串
            prop.setProperty("swagger", "ranger");
            prop.setProperty("swagger1", "ranger1");
            prop.setProperty("swagger2", "ranger2");
            prop.setProperty("swagger3", "ranger3");
            prop.store(fw, "sava data");
        } catch (IOException e) {
            System.out.println(e);
        }*/
    }

    static void properties_load() throws IOException {
        //新建Properties对象
        Properties prop = new Properties();
        //使用对象读取文件数据
        prop.load(new FileReader("./src/JavaCore/IO/FOS.txt"));
        //使用properties的stringpropertyNames()方法获取键的集合
        Set<String> set = prop.stringPropertyNames();
        //遍历键获取所有的键值对
        for (String key: set) System.out.println(key + ":" + prop.getProperty(key));
    }


    public static void main( String[] args ) throws IOException {
        properties_store();
        properties_load();
    }
}
