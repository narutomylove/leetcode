package com.fintopia.滑动窗口.不定长滑动窗口.part1求最长最大;

import java.util.HashMap;
import java.util.Map;

public class _06_1695 {

  public int maximumUniqueSubarray(int[] nums) {
    int max = 0;
    int left = 0;
    int tempSum = 0;
    Map<Integer, Integer> map = new HashMap<>();
    for (int right = 0; right < nums.length; right++) {
      tempSum += nums[right];
      while (map.containsKey(nums[right])) {
        tempSum -= nums[left];
        map.remove(nums[left]);
        left++;
      }
      map.put(nums[right], 1);
      max = Math.max(max, tempSum);
    }
    return max;
  }
}
