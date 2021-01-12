package com.silinx.source.swaggerranger.mylib;
/********************************************************************
* 尾递归的java实现
 * 递归是计算机的一大精髓。
 * 但常用的递归有个致命的问题：很容易导致栈溢出，因为每一次的递归都会保存上一次的状态和变量，进而往下递归压栈，最后收缩回来出栈完成运算
 * 解决办法就是使用尾递归优化：即递归调用在方法或者函数的末尾，在进入递归时不涉及上一次的状态和变量，这样就直接复用栈而不需要去申请新的栈
 * java编译器没有实现尾递归的优化，但Java8 的lambda表达式来实现尾递归的优化
 *
* ********************************************************************/


public class TailRecurse {

    //通常递归
    public static int factorialRecursion(final int number) {
        if (number == 1) return number;
        else return number * factorialRecursion(number - 1);
    }

    //尾递归，关键就是将最后调用存在的number去掉，使用参数保存下去，number：次数，factorial：保存的值
    public static int factorialTailRecursion(final int factorial, final int number) {
        if (number == 1) return factorial;
        else return factorialTailRecursion(factorial * number, number - 1);
    }
}
