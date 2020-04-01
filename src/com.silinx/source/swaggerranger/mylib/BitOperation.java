package com.silinx.source.swaggerranger.mylib;
/*
*
* 位运算操作符：
* &:与运算，有0为0
* |:或运算，有1为1
* ~：非运算，0转化为1，1转换为0---只需要一个运算数
* ^:异或运算相同为0，不相同为1
* <<:不带符号左移，即第一个符号位不变，其余左移（在10进制中就相当于x2）
* >>:不带符号右移
* <<<:带符号左移，即符号位也进行移动
* >>>:带符号右移
*
* 应用：
*   m*2^n  ==m<<n;
*   不适用中间变量交换数值：int a,b--> a=a^b;b=b^a;a=a^b;--可能有些晦涩，但其实很简单，就是取反公式的应用：a=b^(a^b)
* */
public class BitOperation {
    /**
     * @param a: An integer
     * @param b: An integer
     * @return: The sum of a and b
     * 使用位运算实现加法
     */
    public int bitadd(int a, int b) {

        //迭代方法
        while (b!=0) {
            int temp =a^b;  //计算当前的数字
            b = (a&b)<<1;   //计算进位，while中只有进位全部为零时才算运算完成
            a = temp;
        }
        return a;
    }

    public static int bitaddIterator(int a, int b) {
        //递归方法
        int res=0;
		int xor=a^b;
		int forworad=(a&b)<<1;

		if(forworad!=0) {
			res=bitaddIterator(xor,forworad);
		}else {
			res=xor;
		}
		return res;
    }
}
