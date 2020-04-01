package com.silinx.source.algs4.Chapter4.chapter4_1;

import com.silinx.source.algs4.algs4_lib.In;
import com.silinx.source.algs4.algs4_lib.StdOut;

/*************************************************************************
 *  Compilation:  javac DepthFirstSearch.java
 *  Execution:    java DepthFirstSearch filename.txt s
 *  Dependencies: Graph.java StdOut.java
 *  Data files:   http://algs4.cs.princeton.edu/41undirected/tinyG.txt
 *
 *  Run depth first search on an undirected graph.
 *  Runs in O(E + V) time.
 *
 *  % java DepthFirstSearch tinyG.txt 0
 *  0 1 2 3 4 5 6 
 *  NOT connected
 *
 *  % java DepthFirstSearch tinyG.txt 9
 *  9 10 11 12 
 *  NOT connected
 *
 *  深度优先搜索，给定一个顶点s 出发遍历所有的顶点和边，给定一个图和一个点，从给定的点出发在类实例化时就搜索出节点并保存在marked[]数组中
 *  使用一个大小与节点相同的布尔数组标记是否已经遍历，已经遍历就返回，否则就继续往下走--这样就能从一个点出发把能走的节点和边都走一遍
 *  本质上就是在搜索联通图，如果图是联通的那么每个点都会被搜索到
 *  这里输入就是一个图和一个节点然后输出就是一个布尔数组和节点标记
 *************************************************************************/

public class DepthFirstSearch {
    private boolean[] marked;    // marked[v] = is there an s-v path?
    private int count;           // number of vertices connected to s

    // single source
    public DepthFirstSearch(Graph G, int s) {
        marked = new boolean[G.V()];
        dfs(G, s);
    }

    // depth first search from v--算法的关键实现
    private void dfs(Graph G, int v) {
        marked[v] = true;   //标志，也是是否再进入递归和向下寻找的判断
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);  //这里没有退出语句--因为执行完成后自动出栈，并且先在递归前判断是否需要进入，否则就执行完成
            }
        }
    }

    // is there an s-v path?
    public boolean marked(int v) {
        return marked[v];
    }

    // number of vertices connected to s
    public int count() {
        return count;
    }

    // test client
    public static void main( String[] args) {
        In in = new In(args[0]);
        Graph G = new Graph(in);
        int s = Integer.parseInt(args[1]);
        DepthFirstSearch search = new DepthFirstSearch(G, s);
        for (int v = 0; v < G.V(); v++) {
            if (search.marked(v))
                StdOut.print(v + " ");
        }

        StdOut.println();
        if (search.count() != G.V()) StdOut.println("NOT connected");
        else                         StdOut.println("connected");
    }

}
