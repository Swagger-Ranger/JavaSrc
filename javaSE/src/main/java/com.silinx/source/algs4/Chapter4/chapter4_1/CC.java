package com.silinx.source.algs4.Chapter4.chapter4_1;

import com.silinx.source.algs4.algs4_lib.In;
import com.silinx.source.algs4.algs4_lib.Queue;
import com.silinx.source.algs4.algs4_lib.StdOut;

/*************************************************************************
 *  Compilation:  javac CC.java
 *  Execution:    java CC filename.txt
 *  Dependencies: Graph.java StdOut.java Queue.java
 *  Data files:   http://algs4.cs.princeton.edu/41undirected/tinyG.txt
 *
 *  Compute connected components using depth first search.
 *  Runs in O(E + V) time.
 *
 *  %  java CC tinyG.txt
 *  3 components
 *  0 1 2 3 4 5 6
 *  7 8 
 *  9 10 11 12
 *  CC Connected component   联通分量
 *  这里使用了dfs来搜索节点，相对dfs来说只是将每个节点都作为起点如果没有被搜索标记就都搜索一遍
 *  相对dfs这里dfs搜索增加了id[v] = count和size[v]++，这里非常巧妙，在CC初始化分量遍历中count来计算分量数量，在dfs搜索中用count来确定节点所在分量
 *
 *************************************************************************/

public class CC {
    private boolean[] marked;   // marked[v] = has vertex v been marked?
    private int[] id;           // id[v] = id of connected component containing 节点v所在的联通分量
    private int[] size;         // size[v] = number of vertices in component containing v  联通分量中包含的节点数量
    private int count;          // number of connected components  联通分量的数量

    public CC(Graph G) {            //CC和dfs相连的非常巧妙！！！
        marked = new boolean[G.V()];
        id = new int[G.V()];
        size = new int[G.V()];
        for (int v = 0; v < G.V(); v++) {
            if (!marked[v]) {
                dfs(G, v);
                count++;        //每新进入一个dfs就是一个新的分量，即分量数量加一
            }
        }
    }

    // depth first search
    private void dfs(Graph G, int v) {
        marked[v] = true;
        id[v] = count;
        size[v]++;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }

    // id of connected component containing v
    public int id(int v) {
        return id[v];
    }

    // size of connected component containing v
    public int size(int v) {
        return size[id[v]];
    }

    // number of connected components
    public int count() {
        return count;
    }

    // are v and w in the same connected component?
    public boolean areConnected(int v, int w) {
        return id(v) == id(w);
    }


    // test client
    public static void main( String[] args) {
        In in = new In(args[0]);
        Graph G = new Graph(in);
        CC cc = new CC(G);

        // number of connected components
        int M = cc.count();
        StdOut.println(M + " components");

        // compute list of vertices in each connected component
        Queue<Integer>[] components = (Queue<Integer>[]) new Queue[M];
        for (int i = 0; i < M; i++) {
            components[i] = new Queue<Integer>();
        }
        for (int v = 0; v < G.V(); v++) {
            components[cc.id(v)].enqueue(v);
        }

        // print results
        for (int i = 0; i < M; i++) {
            for (int v : components[i]) {
                StdOut.print(v + " ");
            }
            StdOut.println();
        }
    }
}
