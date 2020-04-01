package com.silinx.source.algs4.Chapter4.chapter4_4; /*************************************************************************
 *  Compilation:  javac DirectedEdge.java
 *  Execution:    java DirectedEdge
 *
 *  Immutable weighted directed edge.
 *
 *  加权有向边，相对而言更简单，将either（）和other（）改成了from（）和to（）
 *************************************************************************/

import com.silinx.source.algs4.algs4_lib.StdOut;

public class DirectedEdge {
    private final int v;
    private final int w;
    private final double weight;

   /**
     * Create a directed edge from v to w with given weight.
     */
    public DirectedEdge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

   /**
     * Return the vertex where this edge begins.
     */
    public int from() {
        return v;
    }

   /**
     * Return the vertex where this edge ends.
     */
    public int to() {
        return w;
    }

   /**
     * Return the weight of this edge.
     */
    public double weight() { return weight; }

   /**
     * Return a string representation of this edge.
     */
    public String toString() {
        return v + "->" + w + " " + String.format("%5.2f", weight);
    }

   /**
     * Test client.
     */
    public static void main( String[] args) {
        DirectedEdge e = new DirectedEdge(12, 23, 3.14);
        StdOut.println(e);
    }
}
