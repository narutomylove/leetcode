package com.sany.二分查找;

/**
 * 34题开始接触，带重复元素的二分查找
 */
public class _0034 {

    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;

        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (nums[mid] >= target) {
                right = mid - 1;
                continue;
            }
            left = mid + 1;
        }
        int[] result = new int[]{-1, -1};
        if (left < nums.length && nums[left] == target) {
            result[0] = left;
            while (left < nums.length && nums[left] == target) {
                result[1] = left++;
            }
        }
        return result;
    }
}
