package com.silinx.source.jcip;

import net.jcip.annotations.Immutable;

import java.util.LinkedList;
import java.util.List;

/**
 * PuzzleNode
 * <p/>
 * Link node for the puzzle solving framework
 *
 * @author Brian Goetz and Tim Peierls
 */
@JCIPCodeInfo(chapter = "8.5",page = "151")
@Immutable
public class PuzzleNode <P, M> {
    final P pos;
    final M move;
    final PuzzleNode<P, M> prev;

    public PuzzleNode(P pos, M move, PuzzleNode<P, M> prev) {
        this.pos = pos;
        this.move = move;
        this.prev = prev;
    }

    //返回的是如何移动的轨迹而不是节点的位置变化轨迹
    List<M> asMoveList() {
        List<M> solution = new LinkedList<M>();
        for (PuzzleNode<P, M> n = this; n.move != null; n = n.prev)
            //最初的开始节点 pre和move应该都是null，因为move是移动采取的规则，而第一个节点根本就没有移动过
            solution.add(0, n.move);
        return solution;
    }
}
