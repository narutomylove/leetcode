package com.sany.二分查找;

/**
 * 思考过程：是找到第一个大于 target 的值，还是找到第一个小于 target 的值的位置？应该找第一个大于。
 * 特殊情况考虑：
 * 1.数组中有值等于target怎么办? 所以应该找第一个值大于等于target
 * 2.数组中所有数都大于target? 找第一个值大于等于target的思路能兼容
 * 3.数组中所有数都小于target? 找第一个值大于等于target，发现找不到，直接返回 nums.length
 */
public class _0035 {

    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length;
        int mid = 0;

        while (start < end) {
            mid = start + ((end - start) >> 1);
            if (nums[mid] >= target) {
                end = mid;
                continue;
            }
            start = mid + 1;
        }

        return start;
    }
}
