package com.silinx.source.algs4.Chapter4.chapter4_1;

import com.silinx.source.algs4.algs4_lib.In;
import com.silinx.source.algs4.algs4_lib.StdIn;
import com.silinx.source.algs4.algs4_lib.StdOut;
import com.silinx.source.algs4.Chapter3.chapter3_5.ST;

/*************************************************************************
 *  Compilation:  javac SymbolGraph.java
 *  Execution:    java SymbolGraph filename.txt delimiter
 *  Dependencies: ST.java Graph.java In.java StdIn.java StdOut.java
 *  Data files:   http://algs4.cs.princeton.edu/41undirected/routes.txt
 *                http://algs4.cs.princeton.edu/41undirected/movies.txt
 *  
 *  %  java SymbolGraph routes.txt " "
 *  JFK
 *     MCO
 *     ATL
 *     ORD
 *  LAX
 *     PHX
 *     LAS
 *
 *  % java SymbolGraph movies.txt "/"
 *  Tin Men (1987)
 *     Hershey, Barbara
 *     Geppi, Cindy
 *     Jones, Kathy (II)
 *     Herr, Marcia
 *     ...
 *     Blumenfeld, Alan
 *     DeBoy, David
 *  Bacon, Kevin
 *     Woodsman, The (2004)
 *     Wild Things (1998)
 *     Where the Truth Lies (2005)
 *     Tremors (1990)
 *     ...
 *     Apollo 13 (1995)
 *     Animal House (1978)
 *
 *  符号图
 *  背景：很多图的节点并不是数字定义的，很多是字符串比如文件，网页等等
 *  方法：这里保存非数字定义的节点的方法就是使用符号图即将非数字的节点转化为数字节点
 *       将节点保存进键为字符串等类型值为数字的符号表中，然后用个数组来反向索引刚才的符号表，最后将图的表示使用数字作为节点，那么就可以使用之前的图的所有算法了
 *************************************************************************/

public class SymbolGraph {
    private ST<String, Integer> st;  // string -> index  ST以treemap（红黑树为底层）为底层的符号表
    private String[] keys;           // index  -> string
    private Graph G;

    public SymbolGraph( String filename, String delimiter) {
        st = new ST<String, Integer>();

        // First pass builds the index by reading strings to associate
        // distinct strings with an index
        In in = new In(filename);
        while (in.hasNextLine()) {
            String[] a = in.readLine().split(delimiter);    //使用传入的参数来作为分隔符以读入节点
            for (int i = 0; i < a.length; i++) {
                if (!st.contains(a[i]))
                    st.put(a[i], st.size());
            }
        }

        // inverted index to get string keys in an array反向数组
        keys = new String[st.size()];
        for (String name : st.keys()) {
            keys[st.get(name)] = name;
        }

        // second pass builds the graph by connecting first vertex on each
        // line to all others
        G = new Graph(st.size());
        in = new In(filename);
        while (in.hasNextLine()) {      //这里再次读取文件数据，建立图---其实具体怎么读还是要根据具体的数据
            String[] a = in.readLine().split(delimiter);
            int v = st.get(a[0]);
            for (int i = 1; i < a.length; i++) {
                int w = st.get(a[i]);
                G.addEdge(v, w);
            }
        }
    }

    public boolean contains( String s) {
        return st.contains(s);
    }

    public int index( String s) {
        return st.get(s);
    }

    public String name( int v) {
        return keys[v];
    }

    public Graph G() {
        return G;
    }


    public static void main( String[] args) {
        String filename  = args[0];
        String delimiter = args[1];
        SymbolGraph sg = new SymbolGraph(filename, delimiter);
        Graph G = sg.G();
        while (StdIn.hasNextLine()) {
            String source = StdIn.readLine();
            int s = sg.index(source);
            for (int v : G.adj(s)) {
                StdOut.println("   " + sg.name(v));
            }
        }
    }
}
