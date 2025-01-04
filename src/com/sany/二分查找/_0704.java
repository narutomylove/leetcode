package com.sany.二分查找;

public class _0704 {

    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        while (start <= end) {
            mid = ((end - start) >> 1) + start;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                end = mid - 1;
                continue;
            }
            start = mid + 1;
        }
        return -1;
    }

}
