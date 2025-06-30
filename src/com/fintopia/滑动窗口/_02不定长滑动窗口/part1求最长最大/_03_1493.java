package com.fintopia.滑动窗口._02不定长滑动窗口.part1求最长最大;

public class _03_1493 {

  // 0,1,1,1,0,1,1,0,1
  public int longestSubarray(int[] nums) {
    int max = 0;
    int left = -1;
    int right = 0;
    int zeroIndex = -1;
    for (; right < nums.length; right++) {
      if (nums[right] == 0) {
        if (zeroIndex != -1) {
          left = zeroIndex;
        }
        zeroIndex = right;
      }
      max = Math.max(max, right - left);
    }
    return max - 1;
  }
}
