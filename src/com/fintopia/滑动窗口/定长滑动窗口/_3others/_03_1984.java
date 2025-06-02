package com.fintopia.滑动窗口.定长滑动窗口._3others;

import java.util.Arrays;

public class _03_1984 {

  public static int minimumDifference(int[] nums, int k) {
    Arrays.sort(nums);
    int min = Integer.MAX_VALUE;
    for (int i = k - 1; i < nums.length; i++) {
      min = Math.min(min, nums[i] - nums[i - k + 1]);
    }
    return min;
  }
}
