package com.silinx.source.swaggerranger.mylib.Sortion;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: KthLargest
 * @Author: liufei32@outlook.com
 * @Date: 2019/5/13 17:28
 * @Description: 第K大的元素
 * @Aha-eureka:
 *******************************************************************************/

public class KthLargest {


    /**
     * 数组中第k大的元素
     * @param k
     * @param nums
     * @return
     */
    public static int kthLargest( int k, int[] nums ) {
        if (nums == null || nums.length == 0 || k < 1 || k > nums.length) {
            return -1;
        }

        //partition从小到大排序，所以这里是nums.length - k
        return partition(nums, 0, nums.length - 1, nums.length - k);
    }

    /**
     * @param nums 要排序查找的数组
     * @param start 从开始第start位
     * @param end   到结束的end位
     * @param k    从小到大第k位的元素
     * @return
     */
    private static int partition( int[] nums, int start, int end, int k ) {

        if(start>-end)
            return nums[k];

        int left = start, right = end;
        int pivot = nums[(start + end) / 2];//锚点，左边的都小于锚点，右边的都大于锚点

        while (left <= right) {
            while (left <= right && nums[left] < pivot)  left++;

            while (left <= right && nums[right] > pivot)  right--;

            if (left <= right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }

        if ( k <= right ) return partition(nums, start, right, k);
        if ( k >= left ) return partition(nums, left, end, k);

        return nums[k];

    }

    private static void swap( int[] nums, int a, int b ) {
        nums[a] = nums[a] ^ nums[b];
        nums[b] = nums[a] ^ nums[b];
        nums[a] = nums[a] ^ nums[b];
    }
}
