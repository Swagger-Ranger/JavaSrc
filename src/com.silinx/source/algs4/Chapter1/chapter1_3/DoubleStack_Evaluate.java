package com.silinx.source.algs4.Chapter1.chapter1_3;

/*****************************************************************
*
 * 使用双栈来运算表达式
 * 一个作为操作数地存储栈，另一个作为运算结果地存储栈
 * 前提：每一个运算单元都必须使用（）来分割，不考虑运算符的优先级，原因请看操作规则
 * 操作规则：
 * 1.将操作数压入操作数栈
 * 2.将操作符压入操作符栈
 * 3.忽略左括号
 * 4.遇到右括号，弹出一个操作符，和所需数量的操作数（一般是两个），并将运算结果压入操作数栈
 *
 * 输入：数据必须以空格分隔
 *
* ****************************************************************/
public class DoubleStack_Evaluate {

    private static Stack<String> ops = new Stack<>();
    private static Stack<Double> vals= new Stack<>();

    public static Double evaluate( String str){
        String[] expression = str.split(" ");
        for(int i =0;i<expression.length;i++){
             String s = expression[i];
             if      (s.equals("("))            ;
             else if (s.equals("+"))    ops.push(s);
             else if (s.equals("-"))    ops.push(s);
             else if (s.equals("*"))    ops.push(s);
             else if (s.equals("/"))    ops.push(s);
             else if (s.equals("sqrt")) ops.push(s);
             else if (s.equals(")")){
                 String op = ops.pop();
                 Double va = vals.pop();
                 if(op.equals("+"))          va = va + vals.pop();
                 else if(op.equals("-"))     va = va - vals.pop();
                 else if(op.equals("*"))     va = va * vals.pop();
                 else if(op.equals("/"))     va = va / vals.pop();
                 else if(op.equals("sqrt"))  va = Math.sqrt(va);
                 vals.push(va);
             }
             else vals.push(Double.parseDouble(s));
        }
        return vals.pop();
    }

    public static void main( String[] args) {
        System.out.println(evaluate("( 1 + 2.1 ) * ( ( 3.3 - 4 ) * ( 5 - 6 ) ) "));
        System.out.println(evaluate("( sqrt ( 1 + 2 ) ) "));

    }
}
