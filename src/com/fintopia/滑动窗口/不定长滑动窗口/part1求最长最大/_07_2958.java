package com.fintopia.滑动窗口.不定长滑动窗口.part1求最长最大;

import java.util.HashMap;
import java.util.Map;

public class _07_2958 {

  public int maxSubarrayLength(int[] nums, int k) {
    int max = 0;
    int left = 0;
    Map<Integer, Integer> map = new HashMap<>();
    for (int right = 0; right < nums.length; right++) {
      int sum = map.getOrDefault(nums[right], 0);
      if (sum == k) {
        if (nums[left] == nums[right]) {
          left++;
        } else {
          while (nums[left++] != nums[right]) {
            map.put(nums[left - 1], map.get(nums[left - 1]) - 1);
          }
        }
        continue;
      }
      map.put(nums[right], sum + 1);
      max = Math.max(max, right - left + 1);
    }
    return max;
  }
}
