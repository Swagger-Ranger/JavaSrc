package com.silinx.source.algs4.Chapter1.chapter1_3;

import java.util.Stack;
import java.util.*;

/***********************************************
*
 * 在Ex_1_3_09中使用了一个运算数栈和操作符栈来进行运算，并且针对严格使用了括号的运算；现在可以只使用一个栈就能完成
 * 区别在于转换表达式，需要将中缀表达式转换成后缀表达式，也就是将复杂的带有优先级的运算表达式直接转化成单纯的线性表达式
 * 在运算时，一般是将习惯使用的中缀表达式1-2+3转换成后缀表达式12-3+来进行计算机运算的
 * 转换表达式：
 * 1.运算数：直接输出
 * 2.左括号：压栈
 * 3.右括号：将栈顶的运算符出栈直到遇到左括号
 * 4.运算符：
 *          若优先级大于栈顶的运算符，压栈
 *          若优先级小于等于栈顶的运算符，则先将栈顶的运算符出栈并输出，再比较新的栈顶运算符是否大于新的运算符，直到
 *          大于栈顶运算符为止，然后将新的运算符压栈
 * 5.若运算对象处理完毕，则将栈的的运算符一并输出
 *
 *
* *********************************************/
public class Postfix_Expression_Operation_v2 {

    //表达式栈
    private static Stack<String> postfix = new Stack();
    private static StringBuilder postfix_ouput = new StringBuilder("");


    //定义一个优先表来确认运算符的优先级
    private static Map priority = new HashMap<String, Integer>();
    private static Set operands =new HashSet<String>();
    private static int priority_base =1;
    static {
        priority.put("+",priority_base);
        priority.put("-",priority.get("+"));
        priority.put("*",priority_base+1);
        priority.put("/",priority.get("*"));
        priority.put("sqrt",(int)priority.get("*")+1);
        priority.put("(",0);
        operands.add("0");
        operands.add("1");
        operands.add("2");
        operands.add("3");
        operands.add("4");
        operands.add("5");
        operands.add("6");
        operands.add("7");
        operands.add("8");
        operands.add("9");
        operands.add(".");
    }


    private static void operator( String str){
        if(priority.containsKey(str)){
            //操作符入栈
            postfix_ouput.append(" ");//遇到操作符就将结果空格来区分每个操作数
            if(postfix.empty() || (int)priority.get(postfix.peek())<(int)priority.get(str)){
                postfix.push(str);
                return;
            }else{
                postfix_ouput.append(postfix.pop());
                operator(str);
            }
        }

    }

    private static void operand( String str){
        if(operands.contains(str)){
            postfix_ouput.append(str);
        }
    }

    public static void transfer( String infix){

        for(int i =0;i<infix.length();i++){
            String str = infix.substring(i,i+1);

            if(str.equals("(")){
                postfix.push(str);//遇到左括号直接压栈
            }
            else if(str.equals(")")){  //遇到右括号将栈中元素弹出直到遇到左括号
                while(!postfix.empty()){
                    String tmp = postfix.pop();
                    if(tmp.equals("(")){
                        break;
                    }else{
                        postfix_ouput.append(tmp);
                    }
                }
            }else{
                if(i+4<=infix.length() && infix.substring(i,i+4).equalsIgnoreCase("sqrt")){
                    str = "sqrt";
                    operator(str);
                    i=+4;
                    continue;
                }
                operator(str);
                operand(str);
            }
        }
        while(!postfix.empty()) postfix_ouput.append(postfix.pop());//完成for循环的对象输入后将栈中元素全部弹出

    }

    public static void main( String[] args) {
        String str1 = "( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) ) ";
        String str2 = "( 1 + 2.1 ) * ( ( 3.3 - 4 ) * ( 5 - 6 ) ) ";
        String str3 = "( sqrt ( 1 + 2 ) )";
        //        postfixTransfer(str2);
        transfer(str2);
        System.out.println(postfix_ouput.toString());
    }

}
