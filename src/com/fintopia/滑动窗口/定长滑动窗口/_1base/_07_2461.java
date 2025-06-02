package com.fintopia.滑动窗口.定长滑动窗口._1base;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 nums 和一个整数 k 。请你从 nums 中满足下述条件的全部子数组中找出最大子数组和：
 *
 * 子数组的长度是 k，且
 * 子数组中的所有元素 各不相同 。
 * 返回满足题面要求的最大子数组和。如果不存在子数组满足这些条件，返回 0 。
 *
 * 子数组 是数组中一段连续非空的元素序列。
 */
public class _07_2461 {

  public long maximumSubarraySum(int[] nums, int k) {
    long subNumSum = 0;
    long maxSum = 0;
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      subNumSum += nums[i];
      map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
      if (i < k - 1) {
        continue;
      }
      if (map.size() == k) {
        maxSum = Math.max(maxSum, subNumSum);
      }
      int lastNum = nums[i - k + 1];
      if (map.get(lastNum) == 1) {
        map.remove(lastNum);
      } else {
        map.put(lastNum, map.get(lastNum) - 1);
      }
      subNumSum -= lastNum;
    }
    return maxSum;
  }
}
