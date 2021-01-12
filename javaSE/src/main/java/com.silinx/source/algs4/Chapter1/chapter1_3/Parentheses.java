package com.silinx.source.algs4.Chapter1.chapter1_3;

import java.util.Scanner;

/*************************************************************************
 *  Compilation:  javac Parentheses.java
 *  Execution:    java Parentheses
 *  Dependencies: In.java Stack.java
 *
 *  Reads in a text file and checks to see if the parentheses are balanced.
 *
 *  %  java Parentheses
 *  [()]{}{[()()]()}
 *  true
 *
 *  % java Parentheses
 *  [(]) 
 *  false
 *
 *
 *
 *  mend_LEFTPAREN()
 *  % java Ex_1_3_09
 *  1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )
 *  ( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) ) )
 *
 *  % java Ex_1_3_09
 *  sqrt 1 + 2 ) )
 *  ( sqrt ( 1 + 2 ) )
 *
 *************************************************************************/

public class Parentheses {
    private static final char LEFT_PAREN     = '(';
    private static final char RIGHT_PAREN    = ')';
    private static final char LEFT_BRACE     = '{';
    private static final char RIGHT_BRACE    = '}';
    private static final char LEFT_BRACKET   = '[';
    private static final char RIGHT_BRACKET  = ']';

    public static boolean isBalanced( String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == LEFT_PAREN)   stack.push(LEFT_PAREN);
            if (s.charAt(i) == LEFT_BRACE)   stack.push(LEFT_BRACE);
            if (s.charAt(i) == LEFT_BRACKET) stack.push(LEFT_BRACKET);

            if (s.charAt(i) == RIGHT_PAREN) {
                if (stack.isEmpty())           return false;
                if (stack.pop() != LEFT_PAREN) return false;
            }

            else if (s.charAt(i) == RIGHT_BRACE) {
                if (stack.isEmpty())           return false;
                if (stack.pop() != LEFT_BRACE) return false;
            }

            else if (s.charAt(i) == RIGHT_BRACKET) {
                if (stack.isEmpty())             return false;
                if (stack.pop() != LEFT_BRACKET) return false;
            }
        }
        return stack.isEmpty();
    }

    public static String mend_LEFTPAREN(){
        Stack<String> ops =new Stack<String>();
        Stack<String> vals =new Stack<String>();

        Scanner sc =new Scanner(System.in);

        while(!sc.hasNext("end")){
            String s = sc.next();
            if      (s.equals("("))            ;
            else if (s.equals("+")) ops.push(s);
            else if (s.equals("-")) ops.push(s);
            else if (s.equals("*")) ops.push(s);
            else if (s.equals("/")) ops.push(s);
            else if (s.equals("sqrt")) ops.push(s);
            else if (s.equals(")")){
                String op = ops.pop();
                String va = vals.pop();
                if( op.equals("+") ||
                    op.equals("-") ||
                    op.equals("*") ||
                    op.equals("/"))
                    va = String.format("( %s %s %s )" ,vals.pop(),op,va);
                else if(op.equals("sqrt"))
                    va = String.format("( %s %s)",op,va);
                vals.push(va);
            }
            else vals.push(s);

//            sc.close();


        }

        return vals.toString();
    }

    public static void main( String[] args) {
    /*    In in = new In();
        String s = in.readAll().trim();
        StdOut.println(isBalanced(s));*/

        System.out.println(mend_LEFTPAREN());
    }
}

