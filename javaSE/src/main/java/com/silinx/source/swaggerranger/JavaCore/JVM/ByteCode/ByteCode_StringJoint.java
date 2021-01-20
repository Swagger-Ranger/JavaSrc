package com.silinx.source.swaggerranger.JavaCore.JVM.ByteCode;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: ByteCode_StringJoint
 * @Author: liufei32@outlook.com
 * @Date: 2019/4/14 0:56
 * @Description: 字符串拼接字节码分析
 * @Aha-eureka:
 *******************************************************************************/

public class ByteCode_StringJoint {

    public void m1() {
        String s1 = "123";
        String s2 = "456";
        String s3 = s1 + s2;
        System.out.println(s3);
    }

    public void m2() {
        String s1 = "123";
        String s2 = "456";

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(s1);
        stringBuilder.append(s2);

        String s3 = stringBuilder.toString();
        System.out.println(s3);
    }

    public void m3() {
        String s1 = "123";
        String s2 = "456";

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(s1);
        stringBuffer.append(s2);

        String s3 = stringBuffer.toString();
        System.out.println(s3);
    }

    public static void main( String[] args ) {
        new ByteCode_StringJoint().m1();
        new ByteCode_StringJoint().m2();
        new ByteCode_StringJoint().m3();
    }

}

/**
 * 命令：javap -v ByteCode_StringJoint.class > ByteCode_StringJoint.txt
 * Classfile /D:/Swagger-Ranger/git-workspace/Algorithms/out/production/Algorithms/JavaCore/JVM/ByteCode/ByteCode_StringJoint.class
 *   Last modified 2019-4-14; size 1515 bytes
 *   MD5 checksum bc203e8e8ef1d2ce6f3baf0e871f5a80
 *   Compiled from "ByteCode_StringJoint.java"
 * public class JavaCore.JVM.ByteCode.ByteCode_StringJoint
 *   minor version: 0
 *   major version: 52
 *   flags: ACC_PUBLIC, ACC_SUPER
 * Constant pool:
 *    #1 = Methodref          #19.#44        // java/lang/Object."<init>":()V
 *    #2 = String             #45            // 123
 *    #3 = String             #46            // 456
 *    #4 = Class              #47            // java/lang/StringBuilder
 *    #5 = Methodref          #4.#44         // java/lang/StringBuilder."<init>":()V
 *    #6 = Methodref          #4.#48         // java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
 *    #7 = Methodref          #4.#49         // java/lang/StringBuilder.toString:()Ljava/lang/String;
 *    #8 = Fieldref           #50.#51        // java/lang/System.out:Ljava/io/PrintStream;
 *    #9 = Methodref          #52.#53        // java/io/PrintStream.println:(Ljava/lang/String;)V
 *   #10 = Class              #54            // java/lang/StringBuffer
 *   #11 = Methodref          #10.#44        // java/lang/StringBuffer."<init>":()V
 *   #12 = Methodref          #10.#55        // java/lang/StringBuffer.append:(Ljava/lang/String;)Ljava/lang/StringBuffer;
 *   #13 = Methodref          #10.#49        // java/lang/StringBuffer.toString:()Ljava/lang/String;
 *   #14 = Class              #56            // JavaCore/JVM/ByteCode/ByteCode_StringJoint
 *   #15 = Methodref          #14.#44        // JavaCore/JVM/ByteCode/ByteCode_StringJoint."<init>":()V
 *   #16 = Methodref          #14.#57        // JavaCore/JVM/ByteCode/ByteCode_StringJoint.m1:()V
 *   #17 = Methodref          #14.#58        // JavaCore/JVM/ByteCode/ByteCode_StringJoint.m2:()V
 *   #18 = Methodref          #14.#59        // JavaCore/JVM/ByteCode/ByteCode_StringJoint.m3:()V
 *   #19 = Class              #60            // java/lang/Object
 *   #20 = Utf8               <init>
 *   #21 = Utf8               ()V
 *   #22 = Utf8               Code
 *   #23 = Utf8               LineNumberTable
 *   #24 = Utf8               LocalVariableTable
 *   #25 = Utf8               this
 *   #26 = Utf8               LJavaCore/JVM/ByteCode/ByteCode_StringJoint;
 *   #27 = Utf8               m1
 *   #28 = Utf8               s1
 *   #29 = Utf8               Ljava/lang/String;
 *   #30 = Utf8               s2
 *   #31 = Utf8               s3
 *   #32 = Utf8               m2
 *   #33 = Utf8               stringBuilder
 *   #34 = Utf8               Ljava/lang/StringBuilder;
 *   #35 = Utf8               m3
 *   #36 = Utf8               stringBuffer
 *   #37 = Utf8               Ljava/lang/StringBuffer;
 *   #38 = Utf8               main
 *   #39 = Utf8               ([Ljava/lang/String;)V
 *   #40 = Utf8               args
 *   #41 = Utf8               [Ljava/lang/String;
 *   #42 = Utf8               SourceFile
 *   #43 = Utf8               ByteCode_StringJoint.java
 *   #44 = NameAndType        #20:#21        // "<init>":()V
 *   #45 = Utf8               123
 *   #46 = Utf8               456
 *   #47 = Utf8               java/lang/StringBuilder
 *   #48 = NameAndType        #61:#62        // append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
 *   #49 = NameAndType        #63:#64        // toString:()Ljava/lang/String;
 *   #50 = Class              #65            // java/lang/System
 *   #51 = NameAndType        #66:#67        // out:Ljava/io/PrintStream;
 *   #52 = Class              #68            // java/io/PrintStream
 *   #53 = NameAndType        #69:#70        // println:(Ljava/lang/String;)V
 *   #54 = Utf8               java/lang/StringBuffer
 *   #55 = NameAndType        #61:#71        // append:(Ljava/lang/String;)Ljava/lang/StringBuffer;
 *   #56 = Utf8               JavaCore/JVM/ByteCode/ByteCode_StringJoint
 *   #57 = NameAndType        #27:#21        // m1:()V
 *   #58 = NameAndType        #32:#21        // m2:()V
 *   #59 = NameAndType        #35:#21        // m3:()V
 *   #60 = Utf8               java/lang/Object
 *   #61 = Utf8               append
 *   #62 = Utf8               (Ljava/lang/String;)Ljava/lang/StringBuilder;
 *   #63 = Utf8               toString
 *   #64 = Utf8               ()Ljava/lang/String;
 *   #65 = Utf8               java/lang/System
 *   #66 = Utf8               out
 *   #67 = Utf8               Ljava/io/PrintStream;
 *   #68 = Utf8               java/io/PrintStream
 *   #69 = Utf8               println
 *   #70 = Utf8               (Ljava/lang/String;)V
 *   #71 = Utf8               (Ljava/lang/String;)Ljava/lang/StringBuffer;
 * {
 *   public JavaCore.JVM.ByteCode.ByteCode_StringJoint();
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
 *             0       5     0  this   LJavaCore/JVM/ByteCode/ByteCode_StringJoint;
 *
 *   public void m1();
 *     descriptor: ()V
 *     flags: ACC_PUBLIC
 *     Code:
 *       stack=2, locals=4, args_size=1
 *          0: ldc           #2                  // String 123
 *          2: astore_1
 *          3: ldc           #3                  // String 456
 *          5: astore_2
 *          6: new           #4                  // class java/lang/StringBuilder
 *          9: dup
 *         10: invokespecial #5                  // Method java/lang/StringBuilder."<init>":()V
 *         13: aload_1
 *         14: invokevirtual #6                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
 *         17: aload_2
 *         18: invokevirtual #6                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
 *         21: invokevirtual #7                  // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
 *         24: astore_3
 *         25: getstatic     #8                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *         28: aload_3
 *         29: invokevirtual #9                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
 *         32: return
 *       LineNumberTable:
 *         line 15: 0
 *         line 16: 3
 *         line 17: 6
 *         line 18: 25
 *         line 19: 32
 *       LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *             0      33     0  this   LJavaCore/JVM/ByteCode/ByteCode_StringJoint;
 *             3      30     1    s1   Ljava/lang/String;
 *             6      27     2    s2   Ljava/lang/String;
 *            25       8     3    s3   Ljava/lang/String;
 *
 *   public void m2();
 *     descriptor: ()V
 *     flags: ACC_PUBLIC
 *     Code:
 *       stack=2, locals=5, args_size=1
 *          0: ldc           #2                  // String 123
 *          2: astore_1
 *          3: ldc           #3                  // String 456
 *          5: astore_2
 *          6: new           #4                  // class java/lang/StringBuilder
 *          9: dup
 *         10: invokespecial #5                  // Method java/lang/StringBuilder."<init>":()V
 *         13: astore_3
 *         14: aload_3
 *         15: aload_1
 *         16: invokevirtual #6                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
 *         19: pop
 *         20: aload_3
 *         21: aload_2
 *         22: invokevirtual #6                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
 *         25: pop
 *         26: aload_3
 *         27: invokevirtual #7                  // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
 *         30: astore        4
 *         32: getstatic     #8                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *         35: aload         4
 *         37: invokevirtual #9                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
 *         40: return
 *       LineNumberTable:
 *         line 22: 0
 *         line 23: 3
 *         line 25: 6
 *         line 26: 14
 *         line 27: 20
 *         line 29: 26
 *         line 30: 32
 *         line 31: 40
 *       LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *             0      41     0  this   LJavaCore/JVM/ByteCode/ByteCode_StringJoint;
 *             3      38     1    s1   Ljava/lang/String;
 *             6      35     2    s2   Ljava/lang/String;
 *            14      27     3 stringBuilder   Ljava/lang/StringBuilder;
 *            32       9     4    s3   Ljava/lang/String;
 *
 *   public void m3();
 *     descriptor: ()V
 *     flags: ACC_PUBLIC
 *     Code:
 *       stack=2, locals=5, args_size=1
 *          0: ldc           #2                  // String 123
 *          2: astore_1
 *          3: ldc           #3                  // String 456
 *          5: astore_2
 *          6: new           #10                 // class java/lang/StringBuffer
 *          9: dup
 *         10: invokespecial #11                 // Method java/lang/StringBuffer."<init>":()V
 *         13: astore_3
 *         14: aload_3
 *         15: aload_1
 *         16: invokevirtual #12                 // Method java/lang/StringBuffer.append:(Ljava/lang/String;)Ljava/lang/StringBuffer;
 *         19: pop
 *         20: aload_3
 *         21: aload_2
 *         22: invokevirtual #12                 // Method java/lang/StringBuffer.append:(Ljava/lang/String;)Ljava/lang/StringBuffer;
 *         25: pop
 *         26: aload_3
 *         27: invokevirtual #13                 // Method java/lang/StringBuffer.toString:()Ljava/lang/String;
 *         30: astore        4
 *         32: getstatic     #8                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *         35: aload         4
 *         37: invokevirtual #9                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
 *         40: return
 *       LineNumberTable:
 *         line 34: 0
 *         line 35: 3
 *         line 37: 6
 *         line 38: 14
 *         line 39: 20
 *         line 41: 26
 *         line 42: 32
 *         line 43: 40
 *       LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *             0      41     0  this   LJavaCore/JVM/ByteCode/ByteCode_StringJoint;
 *             3      38     1    s1   Ljava/lang/String;
 *             6      35     2    s2   Ljava/lang/String;
 *            14      27     3 stringBuffer   Ljava/lang/StringBuffer;
 *            32       9     4    s3   Ljava/lang/String;
 *
 *   public static void main(java.lang.String[]);
 *     descriptor: ([Ljava/lang/String;)V
 *     flags: ACC_PUBLIC, ACC_STATIC
 *     Code:
 *       stack=2, locals=1, args_size=1
 *          0: new           #14                 // class JavaCore/JVM/ByteCode/ByteCode_StringJoint
 *          3: dup
 *          4: invokespecial #15                 // Method "<init>":()V
 *          7: invokevirtual #16                 // Method m1:()V
 *         10: new           #14                 // class JavaCore/JVM/ByteCode/ByteCode_StringJoint
 *         13: dup
 *         14: invokespecial #15                 // Method "<init>":()V
 *         17: invokevirtual #17                 // Method m2:()V
 *         20: new           #14                 // class JavaCore/JVM/ByteCode/ByteCode_StringJoint
 *         23: dup
 *         24: invokespecial #15                 // Method "<init>":()V
 *         27: invokevirtual #18                 // Method m3:()V
 *         30: return
 *       LineNumberTable:
 *         line 46: 0
 *         line 47: 10
 *         line 48: 20
 *         line 49: 30
 *       LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *             0      31     0  args   [Ljava/lang/String;
 * }
 * SourceFile: "ByteCode_StringJoint.java"
 */