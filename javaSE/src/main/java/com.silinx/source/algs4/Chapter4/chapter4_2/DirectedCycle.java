package com.silinx.source.algs4.Chapter4.chapter4_2;

import com.silinx.source.algs4.algs4_lib.In;
import com.silinx.source.algs4.algs4_lib.Stack;
import com.silinx.source.algs4.algs4_lib.StdOut;

/*************************************************************************
 *  Compilation:  javac DirectedCycle.java
 *  Execution:    java DirectedCycle < input.txt
 *  Dependencies: Digraph.java Stack.java StdOut.java In.java
 *  Data files:   http://algs.cs.princeton.edu/42digraph/tinyDG.txt
 *                http://algs.cs.princeton.edu/42digraph/tinyDAG.txt
 *
 *  Finds a directed cycle in a digraph.
 *  Runs in O(E + V) time.
 *
 *  % java DirectedCycle tinyDG.txt 
 *  Cycle: 3 5 4 3 
 *
 *  %  java DirectedCycle tinyDAG.txt 
 *  No cycle
 *  判断有向图的环：
 *  背景：当应用中存在优先级的任务时的情况那么就是一个有向图，其解就是一个有向图中的所有拓扑序列而如果有向图中存在环，则问题必定是无解的
 *  方法和无向图中判断环是一致的，具体描述见无向图Cycle.java
 *  区别：注意这里与无向图的环判断，有个区别，使用了一个onStack[]的数组来保存能够走通的路径，而不是直接判断是否已经被标记，因为
 *       有向图中被标记并不一定就能走通，图是有方向的，同时无向图时所有的边都可以形成环，而有向图只能在对应的方向路径（也就是正在遍历的栈中形成环）
 *  关键的思想就是：
 *          dfs的递归调用正好就是当前的遍历的有向路径，当在栈中的节点已经被走过同时又在后面节点中被指向（就是else if (!marked[w])不满足，
 *          而else if (onStack[w])满足，当一条路径遍历完后将栈中的元素重新恢复成false
 *
 *************************************************************************/

public class DirectedCycle {
    private boolean[] marked;        // marked[v] = has vertex v been marked?
    private int[] edgeTo;            // edgeTo[v] = previous vertex on path to v
    private boolean[] onStack;       // onStack[v] = is vertex on the stack?
    private Stack<Integer> cycle;    // directed cycle (or null if no such cycle)

    public DirectedCycle(Digraph G) {
        marked  = new boolean[G.V()];
        onStack = new boolean[G.V()];
        edgeTo  = new int[G.V()];
        for (int v = 0; v < G.V(); v++)
            if (!marked[v]) dfs(G, v);

        // check that digraph has a cycle
        assert check(G);        //在生成实例时就检查是否又环，有环则抛出错误
    }


    // check that algorithm computes either the topological order or finds a directed cycle
    private void dfs(Digraph G, int v) {
        onStack[v] = true;
        marked[v] = true;
        for (int w : G.adj(v)) {

            // short circuit if directed cycle found
            if (cycle != null) return;

            //found new vertex, so recur
            else if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            }

            // trace back directed cycle
            else if (onStack[w]) {  //与无向图的差异，这个就是路已经被走过了（在栈中）但仍然可以从没有走过的节点再次走到就是有环
                cycle = new Stack<Integer>();
                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
            }
        }

        onStack[v] = false;//这里必须在没有环时出栈将onStack置为false不然，判断有向图是否有环的条件会不生效一直为真
    }

    public boolean hasCycle()        { return cycle != null;   }
    public Iterable<Integer> cycle() { return cycle;           }


    // certify that digraph is either acyclic or has a directed cycle
    private boolean check(Digraph G) {

        if (hasCycle()) {
            // verify cycle
            int first = -1, last = -1;//给定一个数然后将路径走一遍看最后能否走到最后和开始的点相同
            for (int v : cycle()) {
                if (first == -1) first = v;
                last = v;
            }
            if (first != last) {
                System.err.printf("cycle begins with %d and ends with %d\n", first, last);
                return false;
            }
        }


        return true;
    }

    public static void main( String[] args) {
        In in = new In(args[0]);
        Digraph G = new Digraph(in);

        DirectedCycle finder = new DirectedCycle(G);
        if (finder.hasCycle()) {
            StdOut.print("Cycle: ");
            for (int v : finder.cycle()) {
                StdOut.print(v + " ");
            }
            StdOut.println();
        }

        else {
            StdOut.println("No cycle");
        }
    }

}
