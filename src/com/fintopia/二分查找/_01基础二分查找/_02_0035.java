package com.fintopia.二分查找._01基础二分查找;

public class _02_0035 {

    /**
     * 搜索插入位置。找到第一个等于指定值的元素位置，否则返回插入该元素的位置
     * 极客时间二分变体三：找到第一个大于等于给定值的元素
     */
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] < target) {
                left = mid + 1;
                continue;
            }
            if (mid == 0 || nums[mid - 1] < target) {
                return mid;
            }
            right = mid - 1;
        }
        return nums.length;
    }
}
