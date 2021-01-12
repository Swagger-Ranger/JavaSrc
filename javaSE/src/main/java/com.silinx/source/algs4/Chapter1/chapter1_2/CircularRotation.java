package com.silinx.source.algs4.Chapter1.chapter1_2;


public class CircularRotation {
    /**
     * 回环变位，如果字符串能循环移动任意位置之后得到宁一字符串，那么久称为回环变位
     * @param src
     * @param rotation
     * @return
     */
    public static boolean cirRotation( String src, String rotation){
        boolean result = false;

        int length_src = src.length();
        int length_rotation = rotation.length();

        if (length_rotation == length_src && src.concat(src).indexOf(rotation) > 0) return true;

        return result;
    }

    public static void main( String[] args) {
        String src = "ACTGACG";
        String rot = "TGACGAC";
        System.out.print(CircularRotation.cirRotation(src,rot));
    }
}
