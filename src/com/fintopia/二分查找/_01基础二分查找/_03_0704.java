package com.fintopia.二分查找._01基础二分查找;

/**
 * 这是二分查找最基本的母题啊
 */
public class _03_0704 {

  public int search(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
      int mid = left + ((right - left) >> 1);
      if (nums[mid] == target) {
        return mid;
      }
      if (nums[mid] > target) {
        right = mid - 1;
        continue;
      }
      left = mid + 1;
    }
    return -1;
  }
}
