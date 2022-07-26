package com.silinx.source.swaggerranger.mylib.clueBinaryTree;

/**
 * @description:
 * 我们按某种方式对二叉树进行遍历，将二叉树中所有节点排序为一个线性序列，在该序列中，除第一个结点外每个结点有且仅有一个直接前驱结点；
 * 除最后一个结点外每一个结点有且仅有一个直接后继结点。
 *
 * 在有N个节点的二叉树中需要利用N+1个空指针添加线索，这是因为在N个节点的二叉树中，每个节点有2个指针，所以一共有2N个指针，除了根节点以外，
 * 每一个节点都有一个指针从它的父节点指向它，所以一共使用了N-1个指针，所以剩下2N-(N-1)也就是N+1个空指针；
 *
 * 我们利用这些空指针域来存放指向该节点的直接前驱或是直接后继的指针，则可由此信息直接找到在该遍历次序下的前驱结点或后继结点，
 * 从而比递归遍历提高了遍历速度，节省了建立系统栈所使用的存储空间；
 *
 * 这些被重新利用起来的空指针就被称为线索（Thread），加上了这些线索的二叉树就是线索二叉树
 * @author: liufei
 * @date: 2022/7/26
 **/
public class ClueNode {

    private Object data;
    private ClueNode left;
    private ClueNode right;
    private boolean leftIsThread;
    private boolean rightIsThread;

    public ClueNode(Object data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.leftIsThread = false;
        this.rightIsThread = false;
    }

    public ClueNode(Object data, ClueNode left, ClueNode right, boolean leftIsThread, boolean rightIsThread) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.leftIsThread = leftIsThread;
        this.rightIsThread = rightIsThread;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ClueNode getLeft() {
        return left;
    }


    public void setLeft(ClueNode left) {
        this.left = left;
    }

    public boolean isLeftIsThread() {
        return leftIsThread;
    }

    public void setLeftIsThread(boolean leftIsThread) {
        this.leftIsThread = leftIsThread;
    }

    public ClueNode getRight() {
        return right;
    }

    public void setRight(ClueNode right) {
        this.right = right;
    }

    public boolean isRightIsThread() {
        return rightIsThread;
    }

    public void setRightIsThread(boolean rightIsThread) {
        this.rightIsThread = rightIsThread;
    }

    public boolean equals(Object o) {
        if (o instanceof ClueNode) {
            ClueNode clue = (ClueNode) o;
            return clue.getData() == this.data;
        } else return false;
    }

}
