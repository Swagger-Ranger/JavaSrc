package com.silinx.source.swaggerranger.JavaCore.IO.Enhance_IO.serialize;

import java.io.*;
import java.util.ArrayList;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: IO_SerialAndDeserial
 * @Author: liufei32@outlook.com
 * @Date: 2019/3/30 15:24
 * @Description: 序列化和反序列化
 * @Aha-eureka:
 *******************************************************************************/

public class IO_SerialAndDeserial {
    public static void main( String[] args ) {
//        serialCollection();
        deSerailCollection();
    }

    private static void deSerailCollection() {
        try (
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./src/JavaCore/IO/Enhance_IO/serialize/serial.txt"))
        ) {
            Object o = ois.readObject();
            ArrayList<Person> list = (ArrayList<Person>) o;
            for (Person p : list) System.out.println(p);
        } catch (IOException e) {
            System.out.println(e);
        } catch (ClassNotFoundException c) {
            System.out.println(c);
        }
    }

    private static void serialCollection() {
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("Swagger", 26));
        list.add(new Person("Swagger1", 27));
        list.add(new Person("Swagger2", 28));
        list.add(new Person("Swagger3", 29));

        try (
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("./src/JavaCore/IO/Enhance_IO/serialize/serial.txt"))
        ) {
            oos.writeObject(list);
        } catch (IOException e) {
            System.out.println(e);
        }
    }


}
