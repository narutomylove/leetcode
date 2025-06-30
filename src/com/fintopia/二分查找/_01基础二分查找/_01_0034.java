package com.fintopia.二分查找._01基础二分查找;

public class _01_0034 {

    /**
     * 在排序数组中查找元素的第一个和最后一个位置
     * 极客时间二分变体一：找到第一个等于给定值的元素
     */
    public int[] searchRangeV2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int first = -1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] > target) {
                right = mid - 1;
                continue;
            }
            if (nums[mid] < target) {
                left = mid + 1;
                continue;
            }
            if (mid == 0 || nums[mid - 1] < target) {
                first = mid;
                break;
            }
            right = mid - 1;
        }
        if (first == -1) {
            return new int[]{first, first};
        }
        int last = first;
        while (last < nums.length - 1 && nums[last + 1] == nums[first]) {
            last++;
        }
        return new int[]{first, last};
    }
}
