package com.fintopia.滑动窗口._01定长滑动窗口._1base;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给你一个整数数组 nums 和两个正整数 m 和 k 。
 *
 * 请你返回 nums 中长度为 k 的 几乎唯一 子数组的 最大和 ，如果不存在几乎唯一子数组，请你返回 0 。
 *
 * 如果 nums 的一个子数组有至少 m 个互不相同的元素，我们称它是 几乎唯一 子数组。
 *
 * 子数组指的是一个数组中一段连续 非空 的元素序列。
 */
public class _06_2841 {

  // nums = [2,6,7,3,1,7], m = 3, k = 4
  public long maxSum(List<Integer> nums, int m, int k) {
    long maxSubSum = 0;
    long max = 0;
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.size(); i++) {
      maxSubSum += nums.get(i);
      map.put(nums.get(i), map.getOrDefault(nums.get(i), 0) + 1);
      if (i < k - 1) {
        continue;
      }
      if (map.size() >= m) {
        max = Math.max(max, maxSubSum);
      }
      int lastNum = nums.get(i - k + 1);
      if (map.get(lastNum) == 1) {
        map.remove(lastNum);
      } else {
        map.put(lastNum, map.get(lastNum) - 1);
      }
      maxSubSum -= lastNum;
    }
    return max;
  }
}
