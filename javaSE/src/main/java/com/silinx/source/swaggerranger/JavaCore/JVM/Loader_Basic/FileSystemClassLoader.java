package com.silinx.source.swaggerranger.JavaCore.JVM.Loader_Basic;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: FileSystemClassLoader
 * @Author: liufei32@outlook.com
 * @Date: 2019/4/8 0:21
 * @Description: 自定义文件加载器
 * @Aha-eureka:  自定义加载类有几个关键方法：
 *                    findLoadedClass(String) 调用这个方法，查看这个Class是否已经别加载，如果没有被加载，继续往下走，查看父类加载器，
 *                递归调用loadClass()，如果父类加载器是null，说明是启动类加载器，查找对应的Class，如果都没有找到，就调用findClass(String)
 *                    findClass()：根据名称或位置加载.class字节码,然后使用defineClass
 *                    definclass()：把字节码转化为Class
 *
 *******************************************************************************/

public class FileSystemClassLoader extends ClassLoader {

    private String rootDir;

    public FileSystemClassLoader( String rootDir){
        this.rootDir = rootDir;
    }

    @Override
    protected Class<?> findClass( String name) throws ClassNotFoundException {

        Class<?> c = findLoadedClass(name);

        //应该要先查询有没有加载过这个类。如果已经加载，则直接返回加载好的类。如果没有，则加载新的类。
        if(c!=null){
            return c;
        }else{
            ClassLoader parent = this.getParent();
            try {
                c = parent.loadClass(name);	   //委派给父类加载
            } catch (Exception e) {
//				e.printStackTrace();
            }

            if(c!=null){
                return c;
            }else{
                byte[] classData = getClassData(name);
                if(classData==null){
                    throw new ClassNotFoundException();
                }else{
                    c = defineClass(name, classData, 0,classData.length);//defineClass就是将字节码转化为Class
                }
            }

        }

        return c;

    }

    private byte[] getClassData( String classname){   //com.bjsxt.test.User   d:/myjava/  com/bjsxt/test/User.class
        String path = rootDir +"/"+ classname.replace('.', '/')+".class";

//		IOUtils,可以使用它将流中的数据转成字节数组
        InputStream is = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try{
            is  = new FileInputStream(path);

            byte[] buffer = new byte[1024];
            int temp=0;
            while((temp=is.read(buffer))!=-1){
                baos.write(buffer, 0, temp);
            }

            return baos.toByteArray();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }finally{
            try {
                if(is!=null){
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(baos!=null){
                    baos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
