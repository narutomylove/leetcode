package com.fintopia.滑动窗口._02不定长滑动窗口.part2求最短最小;

public class _01_0209 {

  public int minSubArrayLen(int target, int[] nums) {
    int subSum = 0;
    int left = 0;
    int min = Integer.MAX_VALUE;

    for (int right = 0; right < nums.length; right++) {
      subSum += nums[right];
      if (subSum < target) {
        continue;
      }
      while (subSum >= target && left <= right) {
        subSum -= nums[left++];
      }
      min = Math.min(min, right - left + 2);
    }
    if (min < Integer.MAX_VALUE) {
      return min;
    }
    return 0;
  }
}
