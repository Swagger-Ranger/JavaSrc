package com.silinx.source.algs4.Chapter3.chapter3_5; /*************************************************************************
 *  Compilation:  javac FileIndex.java
 *  Execution:    java FileIndex file1.txt file2.txt file3.txt ...
 *  Dependencies: ST.java SET.java In.java StdIn.java StdOut.java
 *  Data files:   http://algs4.cs.princeton.edu/ex1.txt
 *                http://algs4.cs.princeton.edu/ex2.txt
 *                http://algs4.cs.princeton.edu/ex3.txt
 *                http://algs4.cs.princeton.edu/ex4.txt
 *
 *  % java FileIndex ex*.txt
 *  age
 *   ex3.txt
 *   ex4.txt 
 * best
 *   ex1.txt 
 * was
 *   ex1.txt
 *   ex2.txt
 *   ex3.txt
 *   ex4.txt 
 *
 *  % java FileIndex *.txt
 *
 *  % java FileIndex *.java
 *
 *  为文件建立反向索引，文件中出现过某字符的文件列表
 *
 *************************************************************************/

import com.silinx.source.algs4.algs4_lib.In;
import com.silinx.source.algs4.algs4_lib.StdIn;
import com.silinx.source.algs4.algs4_lib.StdOut;

import java.io.File;

public class FileIndex { 

    public static void main( String[] args) {

        // key = word, value = set of files containing that word
        ST<String, SET<File>> st = new ST<String, SET<File>>();

        // create inverted index of all files
        StdOut.println("Indexing files");
        for (String filename : args) {      //依次扫描文件内容建立符号表
            StdOut.println("  " + filename);
            File file = new File(filename);
            In in = new In(file);
            while (!in.isEmpty()) {
                String word = in.readString();
                if (!st.contains(word)) st.put(word, new SET<File>());//不包含的单词就在表里新建集合
                SET<File> set = st.get(word);   //获取到那个集合，将对应的文件元素添加进去
                set.add(file);
            }
        }


        // read queries from standard input, one per line
        while (!StdIn.isEmpty()) {          //出stdIO中接收查询字符串打印结果
            String query = StdIn.readString();
            if (st.contains(query)) {
                SET<File> set = st.get(query);
                for (File file : set) {
                    StdOut.println("  " + file.getName());
                }
            }
        }

    }

}
