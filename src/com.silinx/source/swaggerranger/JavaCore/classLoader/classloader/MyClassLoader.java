package com.silinx.source.swaggerranger.JavaCore.classLoader.classloader;

/**
 * @author Email:liufei32@outlook.com  github:Swagger-Ranger
 * @description
 * @since 2020/7/2 16:34
 */

public class MyClassLoader extends ClassLoader {

    @Override
    public Class<?> loadClass( String name ) throws ClassNotFoundException {
        ClassLoader ext = getSystemClassLoader().getParent();
        Class<?> clazz =null;
        try {
            clazz = ext.loadClass(name);
        } catch (Exception e) {

        }

        if (clazz != null) {
            return clazz;
        }
        clazz = findClass(name);
        return clazz;
    }
}
