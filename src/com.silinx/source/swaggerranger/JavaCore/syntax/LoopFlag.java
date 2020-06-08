package com.silinx.source.swaggerranger.JavaCore.syntax;

/**
 * @author Email:liufei32@outlook.com  github:Swagger-Ranger
 * @description 循环标识符
 * @since 2020/6/3 15:16
 */

public class LoopFlag {


    static void basicLoop() {
        int count = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 5; j++) {
                count++;
                System.out.print(count + " ");
            }
        }
    }

    /**
     * break 只退出当前循环，所以1-2之后第二个循环就被跳出了进而少加了3个数，45678就是第二个完整的打印
     * 结果：1 2 4 5 6 7 8
     */
    static void breakLoop() {
        int count = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 5; j++) {
                count++;
                if(count ==3) break;

                System.out.print(count + " ");

            }
        }
    }

    /**
     * 不同的flag将会导致break退出的循环范围不同，第一个直接退出两个循环打印12，第二个则会break一样只退出当前循环
     */
    static void breakFlagLoop() {
        int count = 0;
//        flag:
        for (int i = 0; i < 2; i++) {
        flag:
            for (int j = 0; j < 5; j++) {
                count++;
                if(count ==3) break flag;

                System.out.print( + count + " ");
            }
        }
    }


    /**
     * continue和break不同，只是跳过当前条件循环会继续执行当前循环的后面的条件，而不是退出当前循环
     */
    static void continueLoop() {
        int count = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 5; j++) {
                count++;
                if(count ==3) continue;

                System.out.print(count + " ");

            }
        }
    }

    static void continueFlagLoop() {
        int count = 0;
        flag:
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 5; j++) {
                count++;
                if(count ==3) continue flag;

                System.out.print( + count + " ");
            }
        }
    }


    public static void main( String[] args ) {

        System.out.println("basic loop: ");
        basicLoop();
        System.out.println("\n");

        System.out.println("break loop: ");
        breakLoop();
        System.out.println("\n");

        System.out.println("break flag loop: ");
        breakFlagLoop();
        System.out.println("\n");

        System.out.println("continue loop: ");
        continueLoop();
        System.out.println("\n");

        System.out.println("continue flag loop: ");
        continueFlagLoop();
        System.out.println("\n");
    }
}
