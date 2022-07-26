/**
 * @description: 线索二叉树
 *   一棵结点数目为n的二叉树，采用二叉链表的形式存储。对于每个结点均有指向左右孩子的两个指针域，
 *   而结点为 n 的二叉树一共有 n-1 条有效分支路径，则二叉链表中存在 2n -(n-1) =n+1 个空指针域，
 *   这些空指针造成了空间浪费。因此将某结点的空指针域指向该结点的前驱后继，使用线索二叉树能加快树的遍历
 *
 * @author: liufei
 * @date: 2022/7/26
 **/
package com.silinx.source.swaggerranger.mylib.clueBinaryTree;