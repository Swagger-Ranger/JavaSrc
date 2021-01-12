package com.silinx.source.algs4.Chapter2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Test {
    public static void main( String[] args) throws FileNotFoundException {
//        System.out.println(15/16);
        File f = new File("C:\\Swagger-Ranger\\algs4_github_fork\\AlgorithmsSedgewick\\2-Sorting\\2-2-Mergesort" +
                "\\words3.txt");
        Scanner scanner = new Scanner(f);//scanner可以传入文件对象
        String[] str;
        Pattern SPACE = Pattern.compile("\\p{javaWhitespace}");//模式匹配，可以查看API Pattern（空白）
        Pattern EVERTHING = Pattern.compile("\\A"); //全部文档

        String result = scanner.useDelimiter(EVERTHING).next();
        System.out.println(result);//全部内容不变地输出

        str = SPACE.split(result); //将全部输出地内容按空格切分成数组

//        for(int i=0;i<str.length;i++){
//            System.out.println(str);
//        }
        System.out.println(Arrays.toString(str));

    }
}
