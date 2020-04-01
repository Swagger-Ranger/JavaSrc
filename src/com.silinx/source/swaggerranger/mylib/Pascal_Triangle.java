package com.silinx.source.swaggerranger.mylib;

public class Pascal_Triangle {
    public static void main( String[] args) {

//        int rows = Integer.parseInt(args[0]);
        int rows = 10;

        for(int i =0;i<rows;i++) {
            int number = 1;
            System.out.format("%"+(rows-i)*2+"s","");//格式化字符串："%"+(rows-i)*2+"s",是一个整个字符串格式，"s"是必须的转换说明符
            for(int j=0;j<=i;j++) {
                System.out.format("%4d",number); //保留4个位置给每个杨辉数，但这里有个问题就是数字大了之后就会全部乱套，这种写法只是在低行数时的简便方法
                number = number * (i - j) / (j + 1);//杨辉三角的特性，每行数字都是n-1的倍数
            }
            System.out.println();
        }

    }
}
