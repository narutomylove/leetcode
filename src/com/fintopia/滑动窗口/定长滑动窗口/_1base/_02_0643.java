package com.fintopia.滑动窗口.定长滑动窗口._1base;

public class _02_0643 {

  public double findMaxAverage(int[] nums, int k) {
    int maxSum = 0;
    for (int i = 0; i < k; i++) {
      maxSum += nums[i];
    }
    int lastSum = maxSum;
    for (int i = k; i < nums.length; i++) {
      int tempSum = lastSum + nums[i] - nums[i - k];
      maxSum = Math.max(maxSum, tempSum);
      lastSum = tempSum;
    }
    return (double) maxSum / k;
  }
}
