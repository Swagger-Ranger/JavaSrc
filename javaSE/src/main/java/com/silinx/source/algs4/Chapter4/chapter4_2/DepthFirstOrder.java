package com.silinx.source.algs4.Chapter4.chapter4_2;

import com.silinx.source.algs4.algs4_lib.In;
import com.silinx.source.algs4.algs4_lib.Queue;
import com.silinx.source.algs4.algs4_lib.Stack;
import com.silinx.source.algs4.algs4_lib.StdOut;
import com.silinx.source.algs4.Chapter4.chapter4_4.DirectedEdge;
import com.silinx.source.algs4.Chapter4.chapter4_4.EdgeWeightedDigraph;

/*************************************************************************
 *  Compilation:  javac DepthFirstOrder.java
 *  Execution:    java DepthFirstOrder filename.txt
 *  Dependencies: Digraph.java Queue.java Stack.java StdOut.java
 *                EdgeWeightedDigraph.java DirectedEdge.java
 *  Data files:   http://algs4.cs.princeton.edu/42directed/tinyDAG.txt
 *                http://algs4.cs.princeton.edu/42directed/tinyDG.txt
 *
 *  Compute preorder and postorder for a digraph or edge-weighted digraph.
 *  Runs in O(E + V) time.
 *
 *  % java DepthFirstOrder tinyDAG.txt
 *     v  pre post
 *  --------------
 *     0    0    8
 *     1    3    2
 *     2    9   10
 *     3   10    9
 *     4    2    0
 *     5    1    1
 *     6    4    7
 *     7   11   11
 *     8   12   12
 *     9    5    6
 *    10    8    5
 *    11    6    4
 *    12    7    3
 *  Preorder:  0 5 4 1 6 9 11 12 10 2 3 7 8 
 *  Postorder: 4 5 1 12 11 10 9 6 0 3 2 7 8 
 *  Reverse postorder: 8 7 2 3 0 6 9 10 11 12 1 5 4
 *
 *  遍历有向图：3种：前序，后续，和逆后序
 *  前向遍历--前序就是调用顺序也就是进栈的顺序
 *  后向遍历--后序就是递归完成顺序也就是出栈的顺序--注意进栈顺序和出栈顺序并不是相互对应相反的
 *  逆后序遍历--将后序倒过来，原来使用队列保存的顺序直接将队列压栈出栈的顺序就倒过来了
 *
 *************************************************************************/

public class DepthFirstOrder {
    private boolean[] marked;          // marked[v] = has v been marked in dfs?
    private int[] pre;                 // pre[v]    = preorder  number of 所有节点的前序排列，v是前序第几个
    private int[] post;                // post[v]   = postorder number of 所有节点的后序排列
    private Queue<Integer> preorder;   // vertices in preorder      前向遍历--前序就是调用顺序也就是进栈的顺序
    private Queue<Integer> postorder;  // vertices in postorder     后向遍历--后序就是递归完成顺序也就是出栈的顺序
    private int preCounter;            // counter or preorder numbering  前向排序的计数器
    private int postCounter;           // counter for postorder numbering  后向排序的计数器

    // depth-first search preorder and postorder in a digraph
    public DepthFirstOrder(Digraph G) {
        pre    = new int[G.V()];
        post   = new int[G.V()];
        postorder = new Queue<Integer>();
        preorder  = new Queue<Integer>();
        marked    = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++)
            if (!marked[v]) dfs(G, v);
    }

    // depth-first search preorder and postorder in an edge-weighted digraph
    public DepthFirstOrder(EdgeWeightedDigraph G) {
        pre    = new int[G.V()];
        post   = new int[G.V()];
        postorder = new Queue<Integer>();
        preorder  = new Queue<Integer>();
        marked    = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++)
            if (!marked[v]) dfs(G, v);
    }

    // run DFS in digraph G from vertex v and compute preorder/postorder
    private void dfs(Digraph G, int v) {
        marked[v] = true;
        pre[v] = preCounter++;
        preorder.enqueue(v);
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
        postorder.enqueue(v);
        post[v] = postCounter++;
    }

    // run DFS in edge-weighted digraph G from vertex v and compute preorder/postorder
    private void dfs(EdgeWeightedDigraph G, int v) {
        marked[v] = true;
        pre[v] = preCounter++;
        preorder.enqueue(v);
        for (DirectedEdge e : G.adj(v)) {
            int w = e.to();
            if (!marked[w]) {
                dfs(G, w);
            }
        }
        postorder.enqueue(v);
        post[v] = postCounter++;
    }

    public int pre(int v) {
        return pre[v];
    }

    public int post(int v) {
        return post[v];
    }

    // return vertices in postorder as an Iterable
    public Iterable<Integer> post() {
        return postorder;
    }

    // return vertices in postorder as an Iterable
    public Iterable<Integer> pre() {
        return preorder;
    }

    // return vertices in reverse postorder as an Iterable      逆后向遍历
    public Iterable<Integer> reversePost() {
        Stack<Integer> reverse = new Stack<Integer>();
        for (int v : postorder)
            reverse.push(v);
        return reverse;
    }


    //检查是否遍历的路径一致或者能否无环
    private boolean check(Digraph G) {

        // check that post(v) is consistent with post()
        int r = 0;
        for (int v : post()) {  //这里能这么判断的基础就是在遍历时使用的迭代器是一致的，所以这里迭代后顺序也应该和保存的顺序一致
            if (post(v) != r) {
                StdOut.println("post(v) and post() inconsistent");
                return false;
            }
            r++;
        }

        // check that pre(v) is consistent with pre()
        r = 0;
        for (int v : pre()) {
            if (pre(v) != r) {
                StdOut.println("pre(v) and pre() inconsistent");
                return false;
            }
            r++;
        }


        return true;
    }

    public static void main( String[] args) {
        In in = new In(args[0]);
        Digraph G = new Digraph(in);

        DepthFirstOrder dfs = new DepthFirstOrder(G);
        StdOut.println("   v  pre post");
        StdOut.println("--------------");
        for (int v = 0; v < G.V(); v++) {
            StdOut.printf("%4d %4d %4d\n", v, dfs.pre(v), dfs.post(v));
        }

        StdOut.print("Preorder:  ");
        for (int v : dfs.pre()) {
            StdOut.print(v + " ");
        }
        StdOut.println();

        StdOut.print("Postorder: ");
        for (int v : dfs.post()) {
            StdOut.print(v + " ");
        }
        StdOut.println();

        StdOut.print("Reverse postorder: ");
        for (int v : dfs.reversePost()) {
            StdOut.print(v + " ");
        }
        StdOut.println();


    }

}
