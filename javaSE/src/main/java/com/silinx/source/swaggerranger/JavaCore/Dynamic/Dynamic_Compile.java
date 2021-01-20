package com.silinx.source.swaggerranger.JavaCore.Dynamic;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLClassLoader;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: Dynamic_Compile
 * @Author: liufei32@outlook.com
 * @Date: 2019/4/7 12:34
 * @Description: Java动态编译
 * @Aha-eureka:
 *******************************************************************************/

public class Dynamic_Compile {

    /**
     * 对输入流进行编译：先将输入流读到一个文件，然后对这个文件进行实时编译
     * @param inputStream
     */
    public static void realTime_Read( InputStream inputStream ) {
        try (
                OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(new File("./src/JavaCore/Dynamic/temp.java")));
        ) {
            byte[] bytes = new byte[1024];
            int len;
            while ((len = inputStream.read(bytes)) != -1) {
                osw.write(new String(bytes, 0, len));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int realTime_Compile( String filePath) {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        return compiler.run(null, null, null, filePath);
    }

    public static void main( String[] args ) throws IOException {

//        String path = "./src/JavaCore/Dynamic/Hello.java";
        String path = "d:/a/Hello.java";

        //获取系统的编译器
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        //执行编译，如果编译成功返回0，失败返回非0的int
        int result = compiler.run(null, null, null, path);
        System.out.println(result == 0 ? "compile success" : "compile failed");

        /*//使用Runtime.getRuntime();来启动新的进程来运行编译后的结果
        Runtime run = Runtime.getRuntime();
        //运行字节码，-cp指定要运行的文件 文件路径  文件名;exitValue:0代表成功，其他代表失败，返回未终止的子进程的数量
        Process process = run.exec("java  ./src/JavaCore/Dynamic  Hello");
        //获取运行的流,并打印出来，因为直接运行并不会获取到process线程中的输出流的
        InputStream in = process.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String info = " ";
        while ((info = br.readLine()) != null) {
            System.out.println(info);
        }*/

        try {
//            URL[] urls = new URL[] {new URL("file:/"+"./src/JavaCore/Dynamic")};
            URL[] urls = new URL[] {new URL("file:/"+"D:/a/")};
            URLClassLoader loader = new URLClassLoader(urls);
            Class c = loader.loadClass("Hello");
            //调用加载类的main方法
            c.getMethod("main", String[].class).invoke(null, (Object)new String[]{});
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }
}
