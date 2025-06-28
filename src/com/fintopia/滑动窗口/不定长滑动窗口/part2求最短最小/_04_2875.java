package com.fintopia.滑动窗口.不定长滑动窗口.part2求最短最小;

public class _04_2875 {

  public int minSizeSubarray(int[] nums, int target) {
    int[] twoNums = new int[nums.length * 2];
    int total = 0;
    for (int i = 0; i < nums.length; i++) {
      total += nums[i];
      twoNums[i] = twoNums[i + nums.length] = nums[i];
    }
    int term = target % total;
    int times = target / total;
    if (term == 0) {
      return times * nums.length;
    }
    int sum = 0;
    int left = 0;
    int minLen = Integer.MAX_VALUE;
    for (int right = 0; right < twoNums.length; right++) {
      sum += twoNums[right];
      if (sum < term) {
        continue;
      }
      while (sum > term) {
        sum -= twoNums[left];
        left++;
      }
      if (sum == term) {
        minLen = Math.min(minLen, right - left + 1);
        while (sum >= term) {
          sum -= twoNums[left];
          left++;
        }
      }
    }
    return minLen == Integer.MAX_VALUE ? -1 : minLen + times * nums.length;
  }
}
