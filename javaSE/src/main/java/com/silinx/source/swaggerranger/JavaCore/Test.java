package com.silinx.source.swaggerranger.JavaCore;

import java.util.Arrays;
import java.util.function.IntPredicate;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

/**
 * @author liufei
 * @since 2023/3/16
 **/
public class Test {
    static class Mapper1 implements IntUnaryOperator {

        @Override
        public int applyAsInt(int operand) {
            return operand * operand;
        }
    }

    static class Filter1 implements IntPredicate {

        @Override
        public boolean test(int value) {
            return value >= 2;
        }
    }

    static class Mapper2 implements IntUnaryOperator {

        @Override
        public int applyAsInt(int operand) {
            return operand + operand;
        }
    }

    static class Filter2 implements IntPredicate {

        @Override
        public boolean test(int value) {
            return value >= 10;
        }
    }

    static class Mapper3 implements IntUnaryOperator {

        @Override
        public int applyAsInt(int operand) {
            return operand * operand;
        }
    }

    static class Filter3 implements IntPredicate {

        @Override
        public boolean test(int value) {
            return value >= 10;
        }
    }

    public static void main(String[] args) {
        IntStream s1 = Arrays.stream(new int[] {1, 2, 3})
                .map(new Mapper1())
                .filter(new Filter1());

        IntStream s2 = Arrays.stream(new int[] {4, 5, 6})
                .map(new Mapper2())
                .filter(new Filter2());

        IntStream s3 = IntStream.concat(s1, s2)
                .map(new Mapper3())
                .filter(new Filter3());
        int sum = s3.sum();
        System.out.println(sum);
    }
}
