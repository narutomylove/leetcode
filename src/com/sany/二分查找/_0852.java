package com.sany.二分查找;

/**
 * 分情况讨论：
 * 1.left < mid > right
 *      确定不了最大值在哪一边
 * 2.left > mid > right
 *      最大值绝不可能出现在mid和right之间（这应该好想）
 * 3.left < mid < right
 *      最大值绝不可能出现在left和mid之间
 * 4.left > mid < right 这种情况绝不可能出现
 */
public class _0852 {

    public static int peakIndexInMountainArray(int[] arr) {
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = {55,59,63,99,97,94,84,81,79,66,40,38,33,23,22,21,17,9,7};
        System.out.println(peakIndexInMountainArray(arr));
    }
}
