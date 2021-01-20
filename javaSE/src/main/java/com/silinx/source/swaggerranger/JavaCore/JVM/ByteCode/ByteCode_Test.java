package com.silinx.source.swaggerranger.JavaCore.JVM.ByteCode;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: ByteCode_Test
 * @Author: liufei32@outlook.com
 * @Date: 2019/4/13 14:51
 * @Description:
 * @Aha-eureka:
 *
 * javap生成详细的命令
 * javap -v ByteCode_Test.class > ByteCode_Test.txt
 * 内容：
 * 第一部分：显示了生成这个class的java源文件、版本信息、生成时间等。
 * 第二部分：显示了该类中所涉及到常量池，共35个常量。
 * 第三部分：显示该类的构造器，编译器自动插入的。
 * 第四部分：显示了main方的信息。（这个是需要我们重点关注的）
 *
 * //第一部分
 * Classfile /D:/Swagger-Ranger/git-workspace/Algorithms/out/production/Algorithms/JavaCore/JVM/ByteCode/ByteCode_Test.class
 *   Last modified 2019-4-13; size 617 bytes
 *   MD5 checksum 646edba623f52c83adb9e067841a1ffb
 *   Compiled from "ByteCode_Test.java"
 * public class JavaCore.JVM.ByteCode.ByteCode_Test
 *   minor version: 0
 *   major version: 52
 *   flags: ACC_PUBLIC, ACC_SUPER
 *
 * //第二部分
 * Constant pool:
 *
 *   //这里在描述常量池时，所有的utf-8类型的都是值，即描述符的内容，而常量描述符的内容则用utf-8对于的常量序号引用来描述，并使用.:
 *   //等符号来拼接。比如：#1 = Methodref   #5.#23  --层层引用还原#5.#23即为-->Class:java/lang/Object."<init>"()V返回void---对没错就是后面注释的内容
 *
 *    //常量的序号和类型       常量描述（使用字段描述符或方法描述符描述）   注释
 *
 *    #1 = Methodref          #5.#23         // java/lang/Object."<init>":()V
 *    #2 = Fieldref           #24.#25        // java/lang/System.out:Ljava/io/PrintStream;
 *    #3 = Methodref          #26.#27        // java/io/PrintStream.println:(I)V
 *    #4 = Class              #28            // JavaCore/JVM/ByteCode/ByteCode_Test
 *    #5 = Class              #29            // java/lang/Object
 *    #6 = Utf8               <init>
 *    #7 = Utf8               ()V
 *    #8 = Utf8               Code
 *    #9 = Utf8               LineNumberTable
 *   #10 = Utf8               LocalVariableTable
 *   #11 = Utf8               this
 *   #12 = Utf8               LJavaCore/JVM/ByteCode/ByteCode_Test;
 *   #13 = Utf8               main
 *   #14 = Utf8               ([Ljava/lang/String;)V
 *   #15 = Utf8               args
 *   #16 = Utf8               [Ljava/lang/String;
 *   #17 = Utf8               a
 *   #18 = Utf8               I
 *   #19 = Utf8               b
 *   #20 = Utf8               c
 *   #21 = Utf8               SourceFile
 *   #22 = Utf8               ByteCode_Test.java
 *   #23 = NameAndType        #6:#7          // "<init>":()V
 *   #24 = Class              #30            // java/lang/System
 *   #25 = NameAndType        #31:#32        // out:Ljava/io/PrintStream;
 *   #26 = Class              #33            // java/io/PrintStream
 *   #27 = NameAndType        #34:#35        // println:(I)V
 *   #28 = Utf8               JavaCore/JVM/ByteCode/ByteCode_Test
 *   #29 = Utf8               java/lang/Object
 *   #30 = Utf8               java/lang/System
 *   #31 = Utf8               out
 *   #32 = Utf8               Ljava/io/PrintStream;
 *   #33 = Utf8               java/io/PrintStream
 *   #34 = Utf8               println
 *   #35 = Utf8               (I)V
 *
 *   //第三部分该类的构造器，编译器自动插入的。
 * {
 *   public JavaCore.JVM.ByteCode.ByteCode_Test();
 *     descriptor: ()V                           //构造函数描述，()V-无传入参数并返回空
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
 *             0       5     0  this   LJavaCore/JVM/ByteCode/ByteCode_Test;
 *
 * //第四部分 main方的信息。（这个是需要我们重点关注的）
 *   public static void main(java.lang.String[]);
 *     descriptor: ([Ljava/lang/String;)V             //方法描述，([Ljava/lang/String;)传入一个string一维数组参数;V-返回空
 *     flags: ACC_PUBLIC, ACC_STATIC                  //方法修饰符：ACC_PUBLIC ：public, ACC_STATIC ：static
 *     Code:                                          //代码块
 *       stack=2, locals=4, args_size=1               //首先对Code作了统计，stack操作栈(任何操作都先要把值放入操作栈才能操作)有2个，locals本地变量有4个，args_size参数个数有1个
 *          0: iconst_2          //将数字2值压入操作栈，位于栈的最上面
 *          1: istore_1         //从操作栈中弹出一个元素(数字2)，放入到本地变量表中，位于下标为1的位置（下标为0的是this）
 *          2: iconst_3        //将数字5值压入操作栈，位于栈的最上面
 *          3: istore_2        //从操作栈中弹出一个元素(5)，放入到本地变量表中，位于第下标为2个位置
 *          4: iload_2         //将本地变量表中下标为2的位置元素压入操作栈（5）
 *          5: iload_1         //将本地变量表中下标为1的位置元素压入操作栈（2）
 *          6: isub            //操作栈中的2个数字相减
 *          7: istore_3        // 将相减的结果压入到本地本地变量表中，位于下标为3的位置
 *          // 开始执行打印语句，那首先要找到打印的内容，通过getstatic #2找到对应的常量即常量池中的#2常量，即可找到对应的引用
 *          8: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *         11: iload_3                //将本地变量表中下标为3的位置元素压入操作栈（3）
 *         // 通过#3号找到对应的常量，然后invokevirtual去执行#3= Methodref 方法引用，即可找到对应的引用，进行方法调用
 *         12: invokevirtual #3                  // Method java/io/PrintStream.println:(I)V
 *         15: return              //返回
 *       LineNumberTable:          //这里是源码行号和字节码步骤作一一对应，当然因为我将注释复制了过来所以这里源码行号有改变
 *         line 15: 0
 *         line 16: 2
 *         line 17: 4
 *         line 18: 8
 *         line 19: 15
 *       LocalVariableTable:           //本地变量表
 *                        槽位  变量名  字段描述符
 *         Start  Length  Slot  Name   Signature
 *             0      16     0  args   [Ljava/lang/String;
 *             2      14     1     a   I
 *             4      12     2     b   I
 *             8       8     3     c   I
 * }
 * SourceFile: "ByteCode_Test.java"
 *******************************************************************************/

public class ByteCode_Test {

    public static void main( String[] args ) {
        int a = 2;
        int b = 3;
        int c = b - a;
        System.out.println(c);
    }
}
