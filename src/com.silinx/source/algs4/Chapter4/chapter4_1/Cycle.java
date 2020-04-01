package com.silinx.source.algs4.Chapter4.chapter4_1;

import com.silinx.source.algs4.algs4_lib.Stack;
import com.silinx.source.algs4.algs4_lib.StdOut;

/*************************************************************************
 *  Compilation:  javac Cycle.java
 *  Dependencies: Graph.java Stack.java
 *
 *  Identifies a cycle.
 *  Runs in O(E + V) time.
 *
 *  环，一个图存在环吗
 *  这个算法很烧脑，一个是判断是否有平行边一个是确认非平行边的一条环
 *  利用DFS判断无向图中是否换的原理是：若在深度优先搜索的过程中遇到回边(即指向已经访问过的顶点的边)，则必定存在环
 *
 *  判断平行边：遍历相邻节点如果走到了已经标记过了的点就说明，对应节点的边有重复的（即有平行边），因为迭代器遍历不会重复元素
 *  判断环：当走到头时就只能有一个来路是相邻节点，否则就是有回路即环
 *************************************************************************/

public class Cycle {
    private boolean[] marked;
    private int[] edgeTo;
    private Stack<Integer> cycle;

    public Cycle(Graph G) {
        if (hasSelfLoop(G)) return;
        if (hasParallelEdges(G)) return;
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        for (int v = 0; v < G.V(); v++)
            if (!marked[v])
                dfs(G, -1, v);      //初始寻找，将中间的节点设为负
    }


    // does this graph have a self loop?自环
    // side effect: initialize cycle to be self loop
    private boolean hasSelfLoop(Graph G) {
        for (int v = 0; v < G.V(); v++) {
            for (int w : G.adj(v)) {
                if (v == w) {
                    cycle = new Stack<Integer>();
                    cycle.push(v);
                    cycle.push(v);
                    return true;
                }
            }
        }
        return false;
    }

    // does this graph have two parallel edges?平行边
    // side effect: initialize cycle to be two parallel edges
    private boolean hasParallelEdges(Graph G) {
        marked = new boolean[G.V()];

        for (int v = 0; v < G.V(); v++) {

            // check for parallel edges incident to v
            for (int w : G.adj(v)) {
                if (marked[w]) {    //这里这个写法不太容易懂：判断是否有平行边，就是两个点之间有多条链接，判断的关键就是迭代节点的每一条边并将节点做标记
                                    //遍历相邻节点如果走到了已经标记过了的点就说明，对应节点的边有重复的（即有平行边），因为迭代器遍历不会重复元素
                    cycle = new Stack<Integer>();
                    cycle.push(v);
                    cycle.push(w);
                    cycle.push(v);
                    return true;
                }
                marked[w] = true;
            }

            // reset so marked[v] = false for all v
            for (int w : G.adj(v)) {
                marked[w] = false;
            }
        }
        return false;
    }

    public boolean hasCycle()        { return cycle != null; }
    public Iterable<Integer> cycle() { return cycle;         }

    //u就是上一个节点路径，v就是dfs的向下搜索节点路径
    private void dfs(Graph G, int u, int v) {       //关键算法，这种写法（递归后面还有代码）好难理解好难排错
        marked[v] = true;
        for (int w : G.adj(v)) {

            // short circuit if cycle already found
            if (cycle != null) return;//找到了环就直接返回

            if (!marked[w]) {       //当走到头时就只能有一个来路是相邻节点，否则就是有回路即环
                edgeTo[w] = v;
                dfs(G, v, w);
            }

            // check for cycle (but disregard reverse of edge leading to v)
            else if (w != u) {      //将路径记录下来，当w全部都被标记走过了也就是走到节点的尽头了，因为递归完成一轮都肯定是走到节点尽头
                                    // ，但却有和来路不同（dfs的中间参数u）的节点就是有回路即环
                cycle = new Stack<Integer>();
                for (int x = v; x != w; x = edgeTo[x]) {    //环的路径，只需要将dfs的路径还原，v+dfs储存路径+w+v
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
            }
        }
    }

    // test client
    public static void main( String[] args) {
        int V = Integer.parseInt(args[0]);
        int E = Integer.parseInt(args[1]);
        Graph G = new Graph(V, E);
        StdOut.println(G);

        Cycle finder = new Cycle(G);
        if (finder.hasCycle()) {
            for (int v : finder.cycle()) {
                StdOut.print(v + " ");
            }
            StdOut.println();
        }
        else {
            StdOut.println("Graph is acyclic");
        }
    }


}

