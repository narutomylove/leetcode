package com.fintopia.滑动窗口._02不定长滑动窗口.part1求最长最大;

/**
 * 最大连续1的个数(第三题)
 */
public class _09_1004 {

  public int longestOnes(int[] nums, int k) {
    int max = 0;
    int left = 0;
    int zero = 0;
    for (int right = 0; right < nums.length; right++) {
      if (nums[right] == 0) {
        if (zero == k) {
          while (nums[left++] == 1);
        } else {
          zero++;
        }
      }
      max = Math.max(max, right - left + 1);
    }
    return max;
  }
}
