package com.silinx.source.swaggerranger.mylib;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
*
* 给定一个字符串，逐个翻转字符串中的每个单词
* 给出s = "the sky is blue"，返回"blue is sky the"
* 挑战：原地反转不适用额外的空间
* 正则表达式的使用：Java中使用正则表达式涉及3个类：regex,Pattern,Matcher
*   首先需要将regix编译成pattern：Pattern p = Pattern.compile(regix)
*   然后再用Matcher去匹配pattern:Matcher matcher = p.match(str要使用正则表达式的字符串)
*
* */
public class ReverseStrings {

    /*******************************************
    * 思路：先将所有的字符串都当成一个字符串，整体翻转，然后按空格（这里多个缩成一个空格）再反转单个字符串
    * ***************************************/
    public static String reverseStrings( String input) {
        StringBuffer output = new StringBuffer();
        Pattern pattern = Pattern.compile("\\S+");
        Matcher matcher = pattern.matcher(reverseString(input).trim());
        while (matcher.find()) {
            matcher.appendReplacement(output, reverseString(matcher.group()));
        }
        matcher.appendTail(output);//这里翻转就已经全部完成

        return output.toString().replaceAll("\\s+", " ");  //这里过滤掉多余的字符串string.replace("\\s+"+" ")
    }

    //翻转单个字符串
    private static String reverseString( String input) {
        return  new StringBuilder(input).reverse().toString();
    }

    //当给定的是一个数组的实现
    public static char[] reverseCharArrays(char[] str) {
        //思路仍然相同先整体交换再交换局部
        reverseCharArray(str,0,str.length -1);
        //交换局部
        int k ,l =0;
        for (k = 0; k < str.length; k++) {
            if(str[k] == ' '){
                reverseCharArray(str,l,k-1);
                l = k+1;
            }
        }
        reverseCharArray(str,l,k-1);
        return str;
    }

    private static void reverseCharArray(char[] str, int i, int j) {
        /*if(i > j || i < 0 || j > str.length) throw new ArrayIndexOutOfBoundsException(" Out of arrays!");//注意这里的顺序
        // ，因为在while中判断成立后就会进行+1
        while (i <= j--) {
            int temp = str[i] ^ str[j];//char可以和int相互转化所以这里使用了不使用临时变量的位运算异或来交换字符
            str[j] = (char) (str[j] ^ temp);
            str[i] = (char) (str[i] ^ temp);
            i++;
        }*/  //这里不这么做，因为不方便阅读
        for (int m = i, n = j; i < j; i++, j--) {
            char temp = str[m];
            str[m] = str[n];
            str[n] = temp;
        }
    }


    /*
* 给定一个字符串和一个偏移量，根据偏移量旋转字符串(从左向右旋转)
样例
对于字符串 "abcdefg".
offset=0 => "abcdefg"
offset=1 => "gabcdef"
offset=2 => "fgabcde"
offset=3 => "efgabcd"
*
* */
    public static void rotateString(char[] str, int offset) {
        if(str.length <= 0 || str == null)  return;
        reverseCharArray(str, 0, str.length - offset - 1);
        reverseCharArray(str, str.length - offset, str.length - 1);
        reverseCharArray(str, 0, str.length - 1);
    }

    public static void main( String[] args) {
//        System.out.println(reverseStrings("asdf  sdfasd poiuy"));
        char[] asdf ="zpetg pufmmdf l onwmwpsyr qlke vuijr yrr sndp txvcv x hgkczoo cfuadsza prz e sucs".toCharArray();
//        reverseCharArray(asdf,0,asdf.length);
//        System.out.println(Arrays.toString(asdf));

        char[] out = reverseCharArrays(asdf);
        System.out.println(Arrays.toString(out));
        System.out.println(String.valueOf(out));
    }




}
