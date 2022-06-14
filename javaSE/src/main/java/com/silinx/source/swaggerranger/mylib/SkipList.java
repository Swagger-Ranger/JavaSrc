package com.silinx.source.swaggerranger.mylib;


/**
 * 跳表的一种实现方法。
 * 跳表中存储的是正整数，并且存储的是不重复的。
 * 这个跳表的实现，是更巧妙的一种，没有向下的指针；实现更简洁同时也更不容易看懂
 *
 * Author：ZHENG
 */
public class SkipList {

    private static final float SKIPLIST_P = 0.5f;
    private static final int MAX_LEVEL = 16;

    private int levelCount = 1;

    private final Node head = new Node();  // 带头链表

    public Node find(int value) {
        Node p = head;
        /*
         * 这里 外层一个for然后里面一个while，其实就是将跳表压扁，for代表的就是高度即行，while就是高度行里面的那个数组即列数据
         * 逻辑就是：无脑向右，然后找到不满足的就向下，就这样向右再向下，一直执行下去；
         *          因为数据是拍好序的，向下就是在一层层遍历索引，直到找到数据节点，并且向右之后不可能向左；
         */
        for (int i = levelCount - 1; i >= 0; --i) {
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                p = p.forwards[i];
            }
        }

        if (p.forwards[0] != null && p.forwards[0].data == value) {
            return p.forwards[0];
        } else {
            return null;
        }
    }

    public void insert(int value) {
        int level = randomLevel();
        Node newNode = new Node();
        newNode.data = value;
        newNode.maxLevel = level;
        Node[] update = new Node[level];
        // 新建一个高度是 level的向下的 forwards ，初始化update数组，并且每一层链表的开始都是head节点
        // 这个update数组记录的是每一层要更新的节点数据，并不是一个向下的索引数组
        for (int i = 0; i < level; ++i) {
            update[i] = head;
        }

        // record every level largest value which smaller than insert value in update[]
        Node p = head;
        for (int i = level - 1; i >= 0; --i) {
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                p = p.forwards[i];
            }
            // 还是继续find 方法的逻辑，只是将每一层小于插入值的最大节点都更新到update数组中
            update[i] = p;// use update save node in search path
        }

        // in search path node next node become new node forwords(next)
        for (int i = 0; i < level; ++i) {
            // 每一层都插入新节点，即新的数据进来，当起level是大于0的时候，都在0-level中插入数据和索引节点
            newNode.forwards[i] = update[i].forwards[i];
            update[i].forwards[i] = newNode;
        }

        // update node hight
        if (levelCount < level) levelCount = level;
    }

    public void delete(int value) {
        Node[] update = new Node[levelCount];
        Node p = head;
        for (int i = levelCount - 1; i >= 0; --i) {
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                p = p.forwards[i];
            }
            update[i] = p;
        }

        // 先判断数据节点存不存在
        if (p.forwards[0] != null && p.forwards[0].data == value) {
            for (int i = levelCount - 1; i >= 0; --i) {
                // 再判断如果删除的节点正好有向上索引位置的数组，则将索引数组中的索引节点也删掉
                if (update[i].forwards[i] != null && update[i].forwards[i].data == value) {
                    update[i].forwards[i] = update[i].forwards[i].forwards[i];
                }
            }
        }

        // 如果
        while (levelCount>1&&head.forwards[levelCount]==null){
            levelCount--;
        }

    }

    // 理论来讲，一级索引中元素个数应该占原始数据的 50%，二级索引中元素个数占 25%，三级索引12.5% ，一直到最顶层。
    // 因为这里每一层的晋升概率是 50%。对于每一个新插入的节点，都需要调用 randomLevel 生成一个合理的层数。
    // 该 randomLevel 方法会随机生成 1~MAX_LEVEL 之间的数，且 ：
    //        50%的概率返回 1
    //        25%的概率返回 2
    //      12.5%的概率返回 3 ...
    private int randomLevel() {
        int level = 1;

        while (Math.random() < SKIPLIST_P && level < MAX_LEVEL)
            level += 1;
        return level;
    }

    public void printAll() {
        Node p = head;
        while (p.forwards[0] != null) {
            System.out.print(p.forwards[0] + " ");
            p = p.forwards[0];
        }
        System.out.println();
    }

    /**
     * 结构的核心点在 forwards 属性，即向右是链表，向下是数组
     * forwards 记录的就是向右的节点，同时 forwards 是一个数组，记录的是从0层即数据层到当前索引高度的 向下的数组
     * 也就是说 forwards 数组的的长度最长不会超过索引的高度；同时都是由0层到n层的，即forwards[0]就一定是数据节点而非索引节点
     */
    public static class Node {
        private int data = -1;
        private final Node[] forwards = new Node[MAX_LEVEL];
        private int maxLevel = 0;

        @Override
        public String toString() {

            return "{ data: " +
                    data +
                    "; levels: " +
                    maxLevel +
                    " }";
        }
    }

}