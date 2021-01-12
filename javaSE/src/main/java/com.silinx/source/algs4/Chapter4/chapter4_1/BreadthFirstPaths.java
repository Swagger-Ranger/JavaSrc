package com.silinx.source.algs4.Chapter4.chapter4_1;

import com.silinx.source.algs4.algs4_lib.In;
import com.silinx.source.algs4.algs4_lib.Queue;
import com.silinx.source.algs4.algs4_lib.Stack;
import com.silinx.source.algs4.algs4_lib.StdOut;

/*************************************************************************
 *  Compilation:  javac BreadthFirstPaths.java
 *  Execution:    java BreadthFirstPaths G s
 *  Dependencies: Graph.java Queue.java Stack.java StdOut.java
 *  Data files:   http://algs4.cs.princeton.edu/41undirected/tinyCG.txt
 *
 *  Run breadth first search on an undirected graph.
 *  Runs in O(E + V) time.
 *
 *  %  java Graph tinyCG.txt
 *  6 8
 *  0: 2 1 5 
 *  1: 0 2 
 *  2: 0 1 3 4 
 *  3: 5 4 2 
 *  4: 3 2 
 *  5: 3 0 
 *
 *  %  java BreadthFirstPaths tinyCG.txt 0
 *  0 to 0 (0):  0
 *  0 to 1 (1):  0-1
 *  0 to 2 (1):  0-2
 *  0 to 3 (2):  0-2-3
 *  0 to 4 (2):  0-2-4
 *  0 to 5 (1):  0-5
 *
 *  广度优先算法：深度优先算法符合直觉采用递归简洁清晰，但无法处理寻找最短路径的情况
 *  与深度优先的算法差异在于，不使用递归而是使用队列来保存寻找的顺序使得先从距离短的开始寻找，使用队列是保证广度优先的精髓
 *************************************************************************/

public class BreadthFirstPaths {
    private static final int INFINITY = Integer.MAX_VALUE;
    private boolean[] marked;  // marked[v] = is there an s-v path
    private int[] edgeTo;      // edgeTo[v] = previous edge on shortest s-v path寻找最短路径中的上一个节点
    private int[] distTo;      // distTo[v] = number of edges shortest s-v path  到v的路径长度

    // single source
    public BreadthFirstPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        distTo = new int[G.V()];
        edgeTo = new int[G.V()];
        bfs(G, s);

        assert check(G, s);
    }

    // multiple sources
    public BreadthFirstPaths(Graph G, Iterable<Integer> sources) {
        marked = new boolean[G.V()];
        distTo = new int[G.V()];
        edgeTo = new int[G.V()];
        for (int v = 0; v < G.V(); v++) distTo[v] = INFINITY;
        bfs(G, sources);
    }


    // BFS from single soruce
    private void bfs(Graph G, int s) {
        Queue<Integer> q = new Queue<Integer>();        //这里不使用递归而是使用队列来存放遍历过的点
        for (int v = 0; v < G.V(); v++) distTo[v] = INFINITY;//将不链接的点的距离设为无穷大
        distTo[s] = 0;
        marked[s] = true;
        q.enqueue(s); //这里是初始化路径,从开始节点S开始搜索

        traverVertex(G, q);
    }

    //bfs的精髓
    private void traverVertex(Graph G, Queue<Integer> q) {
        while (!q.isEmpty()) {               //这里会将每个点都遍历并标记
            int v = q.dequeue();            //遍历了的和即将遍历的节点将队列出队列，也就是先放入的会被寻找，
                                            // 因为每次遍历都会加一所以队列前的值会更小从而保证从小的开始找，并且每次遍历都出队列进而保证所有点都会被遍历
            for (int w : G.adj(v)) {        //这里while+for（每条分支都会走for (int w : G.adj(v)) ）循环会导致很对分支，相当于所有的路径（while (!q.isEmpty()) ）都分人去走一遍
                if (!marked[w]) {           //当被标记了就不用再往下找，同时也就不会被加入队列进而不会再被寻找
                    edgeTo[w] = v;          //在每次遍历中将经过的路径保存在edgeTo[]（引用是节点，值是对应节点的上个节点
                    distTo[w] = distTo[v] + 1;//每找一遍就将距离起点s的路径长度加一
                    marked[w] = true;
                    q.enqueue(w);              //相邻的未遍历的节点入列
                }
            }
        }
    }

    // BFS from multiple sources，多个起点，也就是可以直接开始进入的点，距离直接为0
    private void bfs(Graph G, Iterable<Integer> sources) {
        Queue<Integer> q = new Queue<Integer>();
        //这里相对单起点的bfs没有将所有非起点都设置成无穷大，因为这里是多起点，设置会导致相互干扰结果
        for (int s : sources) {
            marked[s] = true;
            distTo[s] = 0;
            q.enqueue(s);//这里很巧妙，并不需要将节点遍历的使用单点的bfs，而是直接将起点加入查找队列就行了
        }
        traverVertex(G, q);
    }

    // is there a path between s (or sources) and v?
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    // length of shortest path between s (or sources) and v
    public int distTo(int v) {
        return distTo[v];
    }

    // shortest path bewteen s (or sources) and v; null if no such path
    public Iterable<Integer> pathTo( int v) {
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<Integer>();
        int x;
        for (x = v; distTo[x] != 0; x = edgeTo[x])
            path.push(x);
        path.push(x);
        return path;
    }


    // check optimality conditions for single source
    private boolean check(Graph G, int s) {

        // check that the distance of s = 0
        if (distTo[s] != 0) {
            StdOut.println("distance of source " + s + " to itself = " + distTo[s]);
            return false;
        }

        // check that for each edge v-w dist[w] <= dist[v] + 1
        // provided v is reachable from s
        for (int v = 0; v < G.V(); v++) {
            for (int w : G.adj(v)) {
                if (hasPathTo(v) != hasPathTo(w)) {
                    StdOut.println("edge " + v + "-" + w);
                    StdOut.println("hasPathTo(" + v + ") = " + hasPathTo(v));
                    StdOut.println("hasPathTo(" + w + ") = " + hasPathTo(w));
                    return false;
                }
                if (hasPathTo(v) && (distTo[w] > distTo[v] + 1)) {
                    StdOut.println("edge " + v + "-" + w);
                    StdOut.println("distTo[" + v + "] = " + distTo[v]);
                    StdOut.println("distTo[" + w + "] = " + distTo[w]);
                    return false;
                }
            }
        }

        // check that v = edgeTo[w] satisfies distTo[w] + distTo[v] + 1
        // provided v is reachable from s
        for (int w = 0; w < G.V(); w++) {
            if (!hasPathTo(w) || w == s) continue;
            int v = edgeTo[w];
            if (distTo[w] != distTo[v] + 1) {
                StdOut.println("shortest path edge " + v + "-" + w);
                StdOut.println("distTo[" + v + "] = " + distTo[v]);
                StdOut.println("distTo[" + w + "] = " + distTo[w]);
                return false;
            }
        }

        return true;
    }


    // test client
    public static void main( String[] args) {
        In in = new In(args[0]);
        Graph G = new Graph(in);
        // StdOut.println(G);

        int s = Integer.parseInt(args[1]);
        BreadthFirstPaths bfs = new BreadthFirstPaths(G, s);

        for (int v = 0; v < G.V(); v++) {
            if (bfs.hasPathTo(v)) {
                StdOut.printf("%d to %d (%d):  ", s, v, bfs.distTo(v));
                for (int x : bfs.pathTo(v)) {
                    if (x == s) StdOut.print(x);
                    else        StdOut.print("-" + x);
                }
                StdOut.println();
            }

            else {
                StdOut.printf("%d to %d (-):  not connected\n", s, v);
            }

        }
    }


}
