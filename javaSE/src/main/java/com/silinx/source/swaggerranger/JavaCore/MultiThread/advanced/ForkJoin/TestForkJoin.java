package com.silinx.source.swaggerranger.JavaCore.MultiThread.advanced.ForkJoin;

import java.util.Arrays;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;


/**
 * 
 */
public class TestForkJoin {

    static class SortTask extends RecursiveAction {
        final long[] array;
        final int lo, hi;

        SortTask(long[] array, int lo, int hi) {
            this.array = array;
            this.lo = lo;
            this.hi = hi;
        }

        SortTask(long[] array) {
            this(array, 0, array.length);
        }

        protected void compute() {
            if (hi - lo < THRESHOLD)
                sortSequentially(lo, hi);
            else {
                int mid = (lo + hi) >>> 1;
                invokeAll(new SortTask(array, lo, mid),
                        new SortTask(array, mid, hi));
                merge(lo, mid, hi);
            }
        }

        // implementation details follow:
        static final int THRESHOLD = 1000;

        void sortSequentially(int lo, int hi) {
            Arrays.sort(array, lo, hi);
        }

        void merge(int lo, int mid, int hi) {
            long[] buf = Arrays.copyOfRange(array, lo, mid);
            for (int i = 0, j = lo, k = mid; i < buf.length; j++)
                array[j] = (k == hi || buf[i] < array[k]) ?
                        buf[i++] : array[k++];
        }
    }


    static class SortTask1 extends RecursiveAction {
        final long[] array;
        final int lo, hi;
        // implementation details follow:
        static final int THRESHOLD = 1000;

        SortTask1(long[] array, int lo, int hi) {
            this.array = array;
            this.lo = lo;
            this.hi = hi;
        }

        SortTask1(long[] array) {
            this(array, 0, array.length - 1);
        }

        @Override
        protected void compute() {
            if (lo < hi) {
                int pivot = partition(array, lo, hi);
                SortTask left = new SortTask(array, lo, pivot - 1);
                SortTask right = new SortTask(array, pivot + 1, hi);
                left.fork();
                right.fork();
                left.join();
                right.join();
            }
        }

        private int partition(long[] array, int lo, int hi) {

            long x = array[hi];
            int i = lo - 1;
            for (int j = lo; j < hi; j++) {
                if (array[j] <= x) {
                    i++;
                    swap(array, i, j);
                }
            }

            swap(array, i + 1, hi);
            return i + 1;
        }

        private void swap(long[] array, int i, int j) {
            if (i != j) {
                long temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

    }




    static class SumTask extends RecursiveTask<Long> {
        private      long start;
        private      long end;
        // implementation details follow:
        static final int  THRESHOLD = 1000;

        SumTask(long start, long end) {
            this.start = start;
            this.end = end;
        }

        SumTask(long n) {
            this(1, n);
        }


        @Override
        protected Long compute() {

            long sum = 0;
            if ((end - start) <= THRESHOLD) {
                for (long l = start; l <= end; l++) {
                    sum += l;
                }
            } else {
                long mid = (start + end) >>> 1;
                SumTask left = new SumTask(start, mid);
                SumTask right = new SumTask(mid, end);
                left.fork();
                right.fork();
                sum = left.join() + right.join();
            }

            return sum;
        }

    }


}
