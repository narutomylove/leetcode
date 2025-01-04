package com.sany.二分查找;

/**
 * 题目都不太看得懂
 * 其实是二分查找的变式题，需要转个弯，转化为二分查找的思路来求解
 * (这题属于写完事后就立马不会的题了)
 */
public class _0153 {

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left < right) {
            mid = left + ((right - left) >> 1);
            if (nums[mid] < nums[right]) {
                right = mid;
                continue;
            }
            left = mid + 1;
        }
        return nums[right];
    }
}
