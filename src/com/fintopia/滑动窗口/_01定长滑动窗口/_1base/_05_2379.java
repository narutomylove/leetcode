package com.fintopia.滑动窗口._01定长滑动窗口._1base;

public class _05_2379 {

  public int minimumRecolors(String blocks, int k) {
    int wNum = 0;
    int min = Integer.MAX_VALUE;
    char[] chars = blocks.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      if (chars[i] == 'W') {
        wNum++;
      }
      if (i < k - 1) {
        continue;
      }
      min = Math.min(min, wNum);
      if (chars[i - k + 1] == 'W') {
        wNum--;
      }
    }
    return min == Integer.MAX_VALUE ? wNum : min;
  }
}
