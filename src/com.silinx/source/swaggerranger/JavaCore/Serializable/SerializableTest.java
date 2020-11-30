package com.silinx.source.swaggerranger.JavaCore.Serializable;

import java.io.*;

public class SerializableTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        writeIn();
        read();
    }

    static void writeIn() throws IOException {
        FileOutputStream fos = new FileOutputStream("./temp.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        User user = new User();
        user.setAge(18);
        user.setName("sandy");
        oos.writeObject(user);

        oos.flush();
        oos.close();
    }

    static void read() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("./temp.txt");

        ObjectInputStream oin = new ObjectInputStream(fis);

        User user = (User) oin.readObject();

        System.out.println("name="+user.getName());
    }
}
