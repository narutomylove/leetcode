package com.fintopia.滑动窗口.定长滑动窗口;

import java.util.Arrays;

public class _06_2090 {

  public int[] getAverages(int[] nums, int k) {
    int[] result = new int[nums.length];
    Arrays.fill(result, -1);
    long sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      if (i < k * 2) {
        continue;
      }
      result[i - k] = (int) (sum / (k * 2 + 1));
      sum -= nums[i - k * 2];
    }
    return result;
  }

}
