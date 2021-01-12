package com.silinx.source.algs4.Chapter1.chapter1_5;

import com.silinx.source.algs4.algs4_lib.StdIn;
import com.silinx.source.algs4.algs4_lib.StdOut;

/****************************************************************************
 *  Compilation:  javac QuickFindUF.java
 *  Execution:  java QuickFindUF < input.txt
 *  Dependencies: StdIn.java StdOut.java
 *
 *  Quick-find algorithm.
 *
 *  问题背景：一串节点，判定其联通性，输入两个节点当不连通时就将其联通，联通时则忽略
 *  实现方法：一串节点（这里使用数组来保存）当输入两个节点时，使用一对数组来保存联通的状态，数组的值就是联通分量的分组的组号，数组的引用就是对应的节点
 *      节点如果是联通的则忽略如果不是联通的则将他们联通
 *  优势：查找速度快，find只需要去读取数组引用的值即可
 *  瓶颈：即会每次的union输入都会导致需要扫描整个数组
 ****************************************************************************/

public class QuickFindUF {
    private int[] id;//联通分量数量，用数组来存放
    private int count;//节点的个数

    // instantiate N isolated components 0 through N-1
    public QuickFindUF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;
    }

    // return number of connected components
    public int count() {
        return count;
    }

    // Return component identifier for component containing p
    public int find(int p) {
        return id[p];//直接返回所在分量也就是对应的数组id
    }

    // are elements p and q in the same component?
    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    // merge components containing p and q
    //方法的本质就是使用一对数组来保存联通的状态，数组的值就是联通分量的分组的组号，数组的引用就是对应的节点
    public void union(int p, int q) {
        if (connected(p, q)) return;//联通的就直接忽略跳出程序
        int pid = id[p];
        for (int i = 0; i < id.length; i++) //这里也就是算法的瓶颈--即会每次的union输入都会导致需要扫描整个数组
            if (id[i] == pid) id[i] = id[q]; //归并两个分量
        count--;    //初始化时数组的大小即节点的数量即联通分量的数量，每次链接都对应减少一个联通分量即count --
    }

    public static void main( String[] args) {
        int N = StdIn.readInt();
        QuickFindUF uf = new QuickFindUF(N);

        // read in a sequence of pairs of integers (each in the range 0 to N-1),
         // calling find() for each pair: If the members of the pair are not already
        // call union() and print the pair.
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println("# components: " + uf.count());
    }

}
