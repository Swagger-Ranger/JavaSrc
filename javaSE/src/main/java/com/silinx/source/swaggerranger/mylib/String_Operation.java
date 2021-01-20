package com.silinx.source.swaggerranger.mylib;

public class String_Operation {
    /**
     * 回环变位，如果字符串能循环移动任意位置之后得到宁一字符串，那么久称为回环变位
     * @param String src
     * @param String rotation
     * @return boolean
     */
    public static boolean cirRotation( String src, String rotation){
        boolean result = false;

        int length_src = src.length();
        int length_rotation = rotation.length();

        if (length_rotation == length_src && src.concat(src).indexOf(rotation) > 0) return true;

        return result;
    }

    /**
     *使用递归的方式颠换字符串顺序
     * @param String s
     * @return String
     */
    public static String mystery( String s){
        int N = s.length();
        if ( N <= 1) return s;
        String a = s.substring(0,N/2);
        String b = s.substring(N/2,N);

        return mystery(b) +mystery(a);
    }
}
