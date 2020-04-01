package com.silinx.source.swaggerranger.JavaCore.BaseStructure;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: BinaryTree
 * @Author: liufei32@outlook.com
 * @Date: 2019/5/16 10:20
 * @Description: 二叉树
 * @Aha-eureka:
 *******************************************************************************/

public class BinaryTree {

    /**
     * 生成一颗指定节点数量的树
     * @param nodeNum
     */
    private static TreeNode generateStandardTree( int nodeNum ) {
        TreeNode[] nodes = new TreeNode[nodeNum];

        for (int i = 0; i < nodeNum; i++) {
            nodes[i] = new TreeNode(i);
        }

        for (int i = 0; i < nodeNum; i++) {
            if (i * 2 + 1 < nodeNum) nodes[i].left = nodes[i * 2 + 1];
            if (i * 2 + 2 < nodeNum) nodes[i].right = nodes[i * 2 + 2];
        }

        return nodes[0];
    }

    /**
     * 树的前序递归遍历--注意操作节点的代码在不同位置，最后遍历出来的顺序也是不同的
     * @param node
     */
    public static void preTraversal_recurse( TreeNode node ) {

        //拿到节点要做操作,操作的位置不同，打印的节点顺序也就不同
        System.out.print(node + " ");

        //先遍历左节点
        TreeNode left = node.left;
        if (left != null) preTraversal_recurse(left);

        //再遍历右节点
        TreeNode right = node.right;
        if (right != null) preTraversal_recurse(right);
    }

    /**
     * 中序：左中右
     * @param node
     */
    public static void midTraversal_recurse( TreeNode node ) {

        if (node == null) return;

        midTraversal_recurse(node.left);
        System.out.print(node + " ");
        midTraversal_recurse(node.right);

    }

    /**
     * 后序：左右中
     * @param node
     */
    public static void postTraversal_recurse( TreeNode node ) {

        if (node == null) return;

        postTraversal_recurse(node.left);
        postTraversal_recurse(node.right);
        System.out.print(node + " ");


    }




    /**
     * 迭代和递归的差异就在于：递归将过程节点压入操作栈，而迭代则是手动使用一个FILO的stack来存遍历的过程节点
     */


    /**
     * 迭代的前序遍历
     * @param node
     */
    public static void preTraversal_iteration( TreeNode node ) {
        //需要一个FILO栈来存储遍历的节点
        Stack<TreeNode> nodeStack = new Stack<>();

        while (node != null || !nodeStack.isEmpty()) {
            while (node != null) {
                System.out.print(node + " ");
                nodeStack.push(node);
                node = node.left;
            }

            if (!nodeStack.isEmpty()) {
                node = nodeStack.pop();
                node = node.right;
            }
        }

    }


    /**
     * 迭代的中序遍历
     * @param node
     */
    public static void midTraversal_iteration( TreeNode node ) {

        Stack<TreeNode> nodeStack = new Stack<>();

        while (node != null || !nodeStack.isEmpty()) {

            while (node != null) {
                nodeStack.push(node);
                node = node.left;
            }

            if (!nodeStack.isEmpty()) {
                node = nodeStack.pop();
                System.out.print(node + " ");
                node = node.right;
            }

        }
    }

    /**
     * 迭代的后序遍历：左右中
     * 后序的迭代遍历是所有二叉树遍历中最难的，
     * @param node
     */
    public static void postTraversal_iteration( TreeNode node ) {
        Stack<TreeNode> nodeStack = new Stack<>();

        //这里需要定义一个辅助节点
        int left = 1;
        int right = 2;
        Stack<Integer> stack_Sup = new Stack<>();


        while (node != null || !nodeStack.isEmpty()) {

            while (node != null) {
                nodeStack.push(node);
                stack_Sup.push(left);
                node = node.left;
            }


            //这里是对节点的操作，所有的操作都必须是对节点已经标记为right的节点
            while (!nodeStack.isEmpty() && stack_Sup.peek() == right) {
                stack_Sup.pop();
                System.out.print(nodeStack.pop() + " ");
            }

            //前面已经在向左迭代到了尽头，现在这里就是在退出。所以先将今天退出的根节点标记为right，然后进行向右节点迭代
            if (!nodeStack.isEmpty() && stack_Sup.peek() == left) {
                stack_Sup.pop();
                stack_Sup.push(right);
                node = nodeStack.peek().right;
            }

        }
    }

    /**
     * 层次遍历：中左右
     * 与树的前中后序遍历的DFS深度优先思想不同，层次遍历用到的是BFS广度优先思想。
     * DFS用递归去实现（也可以用栈实现），BFS需要用队列去实现。
     * 层次遍历的步骤是：
     *     1.对于不为空的结点，先把该结点加入到队列中
     *     2.从队中拿出结点，如果该结点的左右结点不为空，就分别把左右结点加入到队列中
     *     3.重复以上操作直到队列为空
     * @param node
     */
    public static void levelTraversal( TreeNode node ) {
        Queue<TreeNode> queue = new Queue<>();

        if (node == null) return;

        queue.enqueue(node);

        TreeNode currentNode;

        while (!queue.isEmpty()) {

            currentNode = queue.dequeue();

            System.out.print(currentNode + " ");

            if (currentNode.left != null) queue.enqueue(currentNode.left);
            if (currentNode.right != null) queue.enqueue(currentNode.right);
        }




    }


    public static void main( String[] args ) {
        TreeNode root = BinaryTree.generateStandardTree(12);

        System.out.println("pre");
        preTraversal_recurse(root);
        System.out.println();
        preTraversal_iteration(root);

        System.out.println();
        System.out.println("mid");
        midTraversal_recurse(root);
        System.out.println();
        midTraversal_iteration(root);

        System.out.println();
        System.out.println("post");
        postTraversal_recurse(root);
        System.out.println();
        postTraversal_iteration(root);

        System.out.println();
        System.out.println("level");
        levelTraversal(root);

    }
}

class TreeNode {
    int val;

    TreeNode left, right;

    TreeNode( int val ) {
        this.val = val;
        this.left = this.right = null;
    }

    @Override
    public String toString() {
        return " " + val;
    }
}