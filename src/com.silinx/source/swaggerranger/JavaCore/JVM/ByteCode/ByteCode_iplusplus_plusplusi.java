package com.silinx.source.swaggerranger.JavaCore.JVM.ByteCode;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: ByteCode_iplusplus_plusplusi
 * @Author: liufei32@outlook.com
 * @Date: 2019/4/14 0:04
 * @Description: i++和++i的具体字节码
 * @Aha-eureka:
 *******************************************************************************/

public class ByteCode_iplusplus_plusplusi {

    public void method1() {
        int i = 5;
        int a = i++;
        System.out.println(a);
    }

    public void method2() {
        int i = 5;
        int a = ++i;
        System.out.println(a);
    }

    public static void main( String[] args ) {
        new ByteCode_iplusplus_plusplusi().method1();
        new ByteCode_iplusplus_plusplusi().method2();
    }
}

/**
 * 命令：javap -v ByteCode_iplusplus_plusplusi.class > ByteCode_iplusplus_plusplusi.txt
 *
 * Classfile /D:/Swagger-Ranger/git-workspace/Algorithms/out/production/Algorithms/JavaCore/JVM/ByteCode/ByteCode_iplusplus_plusplusi.class
 *   Last modified 2019-4-14; size 876 bytes
 *   MD5 checksum 6619df3d2429d5c853b4d1972b1e6504
 *   Compiled from "ByteCode_iplusplus_plusplusi.java"
 * public class JavaCore.JVM.ByteCode.ByteCode_iplusplus_plusplusi
 *   minor version: 0
 *   major version: 52
 *   flags: ACC_PUBLIC, ACC_SUPER
 * Constant pool:
 *    #1 = Methodref          #8.#27         // java/lang/Object."<init>":()V
 *    #2 = Fieldref           #28.#29        // java/lang/System.out:Ljava/io/PrintStream;
 *    #3 = Methodref          #30.#31        // java/io/PrintStream.println:(I)V
 *    #4 = Class              #32            // JavaCore/JVM/ByteCode/ByteCode_iplusplus_plusplusi
 *    #5 = Methodref          #4.#27         // JavaCore/JVM/ByteCode/ByteCode_iplusplus_plusplusi."<init>":()V
 *    #6 = Methodref          #4.#33         // JavaCore/JVM/ByteCode/ByteCode_iplusplus_plusplusi.method1:()V
 *    #7 = Methodref          #4.#34         // JavaCore/JVM/ByteCode/ByteCode_iplusplus_plusplusi.method2:()V
 *    #8 = Class              #35            // java/lang/Object
 *    #9 = Utf8               <init>
 *   #10 = Utf8               ()V
 *   #11 = Utf8               Code
 *   #12 = Utf8               LineNumberTable
 *   #13 = Utf8               LocalVariableTable
 *   #14 = Utf8               this
 *   #15 = Utf8               LJavaCore/JVM/ByteCode/ByteCode_iplusplus_plusplusi;
 *   #16 = Utf8               method1
 *   #17 = Utf8               i
 *   #18 = Utf8               I
 *   #19 = Utf8               a
 *   #20 = Utf8               method2
 *   #21 = Utf8               main
 *   #22 = Utf8               ([Ljava/lang/String;)V
 *   #23 = Utf8               args
 *   #24 = Utf8               [Ljava/lang/String;
 *   #25 = Utf8               SourceFile
 *   #26 = Utf8               ByteCode_iplusplus_plusplusi.java
 *   #27 = NameAndType        #9:#10         // "<init>":()V
 *   #28 = Class              #36            // java/lang/System
 *   #29 = NameAndType        #37:#38        // out:Ljava/io/PrintStream;
 *   #30 = Class              #39            // java/io/PrintStream
 *   #31 = NameAndType        #40:#41        // println:(I)V
 *   #32 = Utf8               JavaCore/JVM/ByteCode/ByteCode_iplusplus_plusplusi
 *   #33 = NameAndType        #16:#10        // method1:()V
 *   #34 = NameAndType        #20:#10        // method2:()V
 *   #35 = Utf8               java/lang/Object
 *   #36 = Utf8               java/lang/System
 *   #37 = Utf8               out
 *   #38 = Utf8               Ljava/io/PrintStream;
 *   #39 = Utf8               java/io/PrintStream
 *   #40 = Utf8               println
 *   #41 = Utf8               (I)V
 * {
 *   public JavaCore.JVM.ByteCode.ByteCode_iplusplus_plusplusi();
 *     descriptor: ()V
 *     flags: ACC_PUBLIC
 *     Code:
 *       stack=1, locals=1, args_size=1
 *          0: aload_0
 *          1: invokespecial #1                  // Method java/lang/Object."<init>":()V
 *          4: return
 *       LineNumberTable:
 *         line 12: 0
 *       LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *             0       5     0  this   LJavaCore/JVM/ByteCode/ByteCode_iplusplus_plusplusi;
 *
 *   public void method1();   //i++
 *     descriptor: ()V
 *     flags: ACC_PUBLIC
 *     Code:
 *       stack=2, locals=3, args_size=1
 *          0: iconst_5       //将5压入操作栈
 *          1: istore_1       //从操作栈中弹出变量并保存到下标为1的本地变量表
 *          2: iload_1        //加载下标为1的本地变量表中的变量到操作栈
 *          3: iinc          1, 1    //将本地变量表中下标为1的变量加1，这句命令iinc直接操作本地变量表并跟了两个参数1,1
 *          6: istore_2       //将操作栈中的变量（值为1）弹出并保存到下标为2的本地变量表
 *          7: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *         10: iload_2        //将本地变量表中下标为2的变量加载到操作栈
 *         11: invokevirtual #3                  // Method java/io/PrintStream.println:(I)V  //这里打印传参I就是操作栈中的变量i（值为1）
 *         14: return
 *       LineNumberTable:
 *         line 15: 0
 *         line 16: 2
 *         line 17: 7
 *         line 18: 14
 *       LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *             0      15     0  this   LJavaCore/JVM/ByteCode/ByteCode_iplusplus_plusplusi;
 *             2      13     1     i   I
 *             7       8     2     a   I
 *
 *   public void method2();  //++i
 *     descriptor: ()V
 *     flags: ACC_PUBLIC
 *     Code:
 *       stack=2, locals=3, args_size=1
 *          0: iconst_5              //将5压入操作栈
 *          1: istore_1              //从操作栈中弹出变量并保存到下标为1的本地变量表
 *          2: iinc          1, 1    //将本地变量表中下标为1的变量加1，这句命令iinc直接操作本地变量表并跟了两个参数1,1
 *          5: iload_1               //加载下标为1的本地变量表中的变量到操作栈
 *          6: istore_2
 *          7: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *         10: iload_2
 *         11: invokevirtual #3                  // Method java/io/PrintStream.println:(I)V
 *         14: return
 *       LineNumberTable:
 *         line 21: 0
 *         line 22: 2
 *         line 23: 7
 *         line 24: 14
 *       LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *             0      15     0  this   LJavaCore/JVM/ByteCode/ByteCode_iplusplus_plusplusi;
 *             2      13     1     i   I
 *             7       8     2     a   I
 *
 *   public static void main(java.lang.String[]);
 *     descriptor: ([Ljava/lang/String;)V
 *     flags: ACC_PUBLIC, ACC_STATIC
 *     Code:
 *       stack=2, locals=1, args_size=1
 *          0: new           #4                  // class JavaCore/JVM/ByteCode/ByteCode_iplusplus_plusplusi
 *          3: dup
 *          4: invokespecial #5                  // Method "<init>":()V
 *          7: invokevirtual #6                  // Method method1:()V
 *         10: new           #4                  // class JavaCore/JVM/ByteCode/ByteCode_iplusplus_plusplusi
 *         13: dup
 *         14: invokespecial #5                  // Method "<init>":()V
 *         17: invokevirtual #7                  // Method method2:()V
 *         20: return
 *       LineNumberTable:
 *         line 27: 0
 *         line 28: 10
 *         line 29: 20
 *       LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *             0      21     0  args   [Ljava/lang/String;
 * }
 * SourceFile: "ByteCode_iplusplus_plusplusi.java"
 */
