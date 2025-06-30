package com.fintopia.滑动窗口._02不定长滑动窗口.part1求最长最大;

public class _04_1208 {

  public static int equalSubstring(String s, String t, int maxCost) {
    int[] cost = new int[s.length()];
    char[] sChar = s.toCharArray();
    char[] tChar = t.toCharArray();
    for (int i = 0; i < sChar.length; i++) {
      cost[i] = Math.abs(sChar[i] - tChar[i]);
    }
    int max = 0;
    int right = 0;
    int left = 0;
    int sum = 0;
    for (; right < cost.length; right++) {
      sum += cost[right];
      if (sum < maxCost) {
        max = Math.max(max, right - left + 1);
        continue;
      }
      while (sum > maxCost) {
        sum -= cost[left];
        left++;
      }
    }
    return max;
  }

  public static void main(String[] args) {

  }
}
