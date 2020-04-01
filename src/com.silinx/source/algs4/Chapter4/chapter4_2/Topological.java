package com.silinx.source.algs4.Chapter4.chapter4_2;

import com.silinx.source.algs4.algs4_lib.StdOut;
import com.silinx.source.algs4.Chapter4.chapter4_4.EdgeWeightedDigraph;
import com.silinx.source.algs4.Chapter4.chapter4_4.EdgeWeightedDirectedCycle;

/*************************************************************************
 *  Compilation:  javac Topoological.java
 *  Dependencies: Digraph.java DepthFirstOrder.java DirectedCycle.java
 *                EdgeWeightedDigraph.java EdgeWeightedDirectedCycle.java
 *  Data files:   http://algs4.cs.princeton.edu/42directed/jobs.txt
 *
 *  Compute topological ordering of a DAG or edge-weighted DAG.
 *  Runs in O(E + V) time.
 *
 *  % java Topological jobs.txt "/"
 *  Calculus
 *  Linear Algebra
 *  Introduction to CS
 *  Programming Systems
 *  Algorithms
 *  Theoretical CS
 *  Artificial Intelligence
 *  Machine Learning
 *  Neural Networks
 *  Robotics
 *  Scientific Computing
 *  Computational Biology
 *  Databases
 *
 * 一幅有向无环图的拓扑顺序即为所有顶点的逆后序排列：也就是直接使用DepthFirstOrder.java求出其逆后序的栈，然后出栈倒过来是其拓扑顺序
 * 原理：在没有环的有向图中，任意v-->w 递归调用链中，w出栈必定在v出栈之前，那么后序遍历就是正确拓扑序列的倒序，在使用逆序倒过来就完成拓扑顺序
 *
 *************************************************************************/

public class Topological {
    private Iterable<Integer> order;    // topological order

    // topological sort in a digraph
    public Topological(Digraph G) {
        DirectedCycle finder = new DirectedCycle(G);
        if (!finder.hasCycle()) {
            DepthFirstOrder dfs = new DepthFirstOrder(G);
            order = dfs.reversePost();
        }
    }

    // topological sort in an edge-weighted digraph
    public Topological(EdgeWeightedDigraph G) {
        EdgeWeightedDirectedCycle finder = new EdgeWeightedDirectedCycle(G);
        if (!finder.hasCycle()) {
            DepthFirstOrder dfs = new DepthFirstOrder(G);
            order = dfs.reversePost();
        }
    }

    // return topological order if a DAG; null otherwise
    public Iterable<Integer> order() {
        return order;
    }

    // does digraph have a topological order?
    public boolean hasOrder() {
        return order != null;
    }


    public static void main( String[] args) {
        String filename  = args[0];
        String delimiter = args[1];
        SymbolDigraph sg = new SymbolDigraph(filename, delimiter);
        Topological topological = new Topological(sg.G());
        for (int v : topological.order()) {
            StdOut.println(sg.name(v));
        }
    }

}
