package com.silinx.source.jcip;

import java.util.*;

/**
 * Puzzle
 * <p/>
 * Abstraction for puzzles like the 'sliding blocks puzzle'
 * 谜题的定义：一个初始位置，一个目标位置，以及用于判断是否是有效移动的规则集；规则集包含两部分：从指定位置开始的所有合法移动，
 *             以及每次移动的结果位置
 *             P：位置类
 *             M：移动类，或者说是移动规则类定义了一个位置的节点能如何移动，一个位置P+一个移动规则M = 新的位置P
 * @author Brian Goetz and Tim Peierls
 */
@JCIPCodeInfo(chapter = "8.5",page = "151")
public interface Puzzle <P, M> {

    //初始位置
    P initialPosition();

    //目标位置
    boolean isGoal( P position );

    //有效移动的规则集
    Set<M> legalMoves( P position );

    //每次移动的结果位置
    P move( P position, M move );
}
