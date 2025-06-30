package com.fintopia.二分查找._01基础二分查找;

public class _05_2529 {

  /**
   * 找到第一个大于等于0的数
   */
  public int maximumCount(int[] nums) {
    int left = 0;
    int right = nums.length - 1;
    int index = -1;
    while (left <= right) {
      int mid = left + ((right - left) >> 1);
      if (nums[mid] < 0) {
        left = mid + 1;
        continue;
      }
      if (mid == 0 || nums[mid - 1] < 0) {
        index = mid;
        break;
      }
      right = mid - 1;
    }
    if (index == -1) {
      return nums.length;
    }
    int negative = index;
    while (index < nums.length && nums[index] == 0) {
      index++;
    }
    int positive = nums.length - index;
    return Math.max(negative, positive);
  }
}
